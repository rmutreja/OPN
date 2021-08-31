package com.opn.in.controller;

import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opn.in.entity.Login;
import com.opn.in.exception.LoginException;
import com.opn.in.service.IPlanterService;
import com.opn.in.service.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Login")
@Api(description="this is Login Controller to perform operations")
public class LoginController {
	
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(IPlanterService.class);
	
	//HAS-A RELATIONSHIP
	@Autowired
	private LoginServiceImpl loginService;

	/*
	 * http://localhost:8080/Login/signIn
	 * This method sends the new login details to the signIn method in login service
	 * and verification is done
	 * HTTP Method POST is required
	 */
    @ApiOperation(value="This is signIn method()")
	@PostMapping("/signIn")
	public ResponseEntity<String> signIn(@RequestBody @Valid Login user) throws LoginException {
		logger.info("Called POST mapping signIn() method");

		ResponseEntity<String> response = null;

		if (loginService.existsById(user.getLoginId())) {
			if (loginService.signIn(user))
				response = new ResponseEntity<>("Signed In " + user.getLoginId(), HttpStatus.ACCEPTED);
			else
				response = new ResponseEntity<>("Login Id and password did not match", HttpStatus.UNAUTHORIZED);
		} else
			response = new ResponseEntity<>("User with " + user.getLoginId() + " Does not exists",
					HttpStatus.NOT_FOUND);

		return response;
	}

	/*
	 * http://localhost:8080/Login/changePassword/1234/123456
	 * This method is used to change the password
	 * HTTP Method PUT is required
	 */
    @ApiOperation(value="This is changePassword method() to change the password of the user")
	@PutMapping(value = "/changePassword/{oldPassword}/{newPassword}")
	public ResponseEntity<String> changePassword(@RequestBody Login login,
			@PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword)
			throws LoginException {
		logger.info("Called PUT mapping changePassword() method");

		loginService.changePassword(login, oldPassword, newPassword);
		ResponseEntity<String> entity = new ResponseEntity<String>(
				"Password of ID " + login.getLoginId() + " updated successfully", HttpStatus.OK);
		return entity;
	}

}