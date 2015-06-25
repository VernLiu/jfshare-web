package com.jfshare.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.login.LoginException;

import com.jfshare.common.Config;
import com.jfshare.user.service.UserService;
import com.jfshare.user.service.model.User;
import com.jfshare.user.util.PasswordUtils;

public class UserServiceImpl implements UserService {

	private static Map<String, User> users = new HashMap<String, User>();
	private static Pattern USER_NAME_PATTERN = Pattern.compile("user\\.admin\\.(\\w+)\\.name");
	
	static {
		List<String> keys = Config.getUserKeys();
		for(String key : keys) {
			Matcher matcher = USER_NAME_PATTERN.matcher(key);
			if(matcher.find()) {
				User user = new User();
				String loginId = matcher.group(1);
				user.setLoginId(loginId);
				user.setName(Config.getUserStringValue(key, ""));
				StringBuilder pwKey = new StringBuilder("user.admin.");
				pwKey.append(loginId);
				pwKey.append(".password");
				user.setPassword(Config.getUserStringValue(pwKey.toString(), null));
				users.put(loginId, user);
			}
		}
	}

	@Override
	public User login(String loginId, String password) throws LoginException {
		if(users.containsKey(loginId)) {
			if(password != null) {
				String hexPassword = PasswordUtils.enCode(password);
				if(users.get(loginId).getPassword().equals(hexPassword)) {
					return users.get(loginId);
				} else {
					throw new LoginException("003");
				}
			} else {
				throw new LoginException("002");
			}
		} else {
			throw new LoginException("001");
		}
	}

}
