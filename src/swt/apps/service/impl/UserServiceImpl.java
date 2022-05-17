package swt.apps.service.impl;

import java.util.HashMap;

import swt.apps.dao.UserDAO;
import swt.apps.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO ud = new UserDAO();
	
	// 회원가입
	@Override
	public int insertSignIn(HashMap<String, Object> map) {
		return ud.insertSignIn(map);
	}

	// 아이디 중복체크
	@Override
	public HashMap<String, Object> selectIdCheck(HashMap<String, Object> map) throws Exception {
		return ud.selectIdCheck(map);
	}

}
