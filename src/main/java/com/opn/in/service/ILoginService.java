package com.opn.in.service;

import com.opn.in.exception.LoginException;
import com.opn.in.entity.Login;

public interface ILoginService {
	
	boolean existsById(String userId);

	boolean signIn(Login user) throws LoginException;

	Login changePassword(Login login, String oldPassord, String newPassword) throws LoginException;


	
}	