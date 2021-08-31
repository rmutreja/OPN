package com.opn.in.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import com.opn.in.entity.Login;
import com.opn.in.exception.LoginException;
import com.opn.in.repository.LoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {


	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(ILoginService.class);
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public boolean existsById(String userId) {
		logger.info("Called existsById() method of LoginServices");
		return loginRepo.existsById(userId);
	}

	@Override
	public boolean signIn(Login user) throws LoginException {
		logger.info("Called signIn() method of LoginServices");
		if (user == null) {
			throw new LoginException("SignIn details Cannot be Null");
		}
		Optional<Login> userDetails = loginRepo.findById(user.getLoginId());
		if (userDetails.isEmpty()) {
			throw new LoginException("User Details does not Exists");
		}
		if (!userDetails.get().getRole().equals(user.getRole()))
			throw new LoginException("Role does not match");
		return userDetails.get().getPassword().equals(user.getPassword());
	}

	@Override
	public Login changePassword(Login login, String oldPassword, String newPassword) throws LoginException {
		logger.info("Called changePassword() method of LoginServices");
		Optional<Login> searchUserId = loginRepo.findById(login.getLoginId());

		if (searchUserId.isPresent()) {
			if (oldPassword.equals(login.getPassword())) {
				login.setPassword(newPassword);
				loginRepo.save(login);
			}
			return login;
		} else {
			throw new LoginException("User with ID " + login.getLoginId() + " not available");
		}
	}
}
