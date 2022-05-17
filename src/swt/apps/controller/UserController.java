package swt.apps.controller;

import java.util.HashMap;

import swt.apps.service.impl.UserServiceImpl;

public class UserController {

	private UserServiceImpl us = new UserServiceImpl();

	// 회원가입
	public String insertSignIn(HashMap<String, Object> map) {
		return us.insertSignIn(map) > 0 ? "success" : "fail";
	}

	// 아이디 중복체크
	public HashMap<String, Object> selectIdCheck(HashMap<String, Object> map) throws Exception {
		return us.selectIdCheck(map);
	}

}
