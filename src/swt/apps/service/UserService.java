package swt.apps.service;

import java.util.HashMap;

public interface UserService {

	public int insertSignIn(HashMap<String, Object> map);
	public HashMap<String, Object> selectIdCheck(HashMap<String, Object> map) throws Exception;

}
