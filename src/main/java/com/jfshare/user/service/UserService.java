package com.jfshare.user.service;

import javax.security.auth.login.LoginException;

import com.jfshare.user.service.model.User;

public interface UserService {

	public User login(String loginId, String password) throws LoginException;
}
