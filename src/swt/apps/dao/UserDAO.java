package swt.apps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import swt.apps.common.DBTemplate;

@SuppressWarnings("all")
public class UserDAO extends DBTemplate {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// DB연결
	public UserDAO() {}

	// 회원가입
	public int insertSignIn(HashMap<String, Object> map) {
		
		// 커넥션 생성 
		conn = connectDB(conn);
		
		int rtn = 0;
		String SQL = sqlProperties.getProperty("insertSignIn");
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, map.get("id").toString());
			pstmt.setString(2, map.get("pwd").toString());
			pstmt.setString(3, map.get("name").toString());
			pstmt.setString(4, map.get("birth").toString());
			pstmt.setString(5, map.get("gender").toString());

			rtn = pstmt.executeUpdate();

			processTx(conn, rtn);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return rtn;
	}

	// 아이디 중복체크
	public HashMap<String, Object> selectIdCheck(HashMap<String, Object> map) throws Exception {
		
		// 커넥션 생성 
		conn = connectDB(conn);
		
		String SQL = sqlProperties.getProperty("selectIdCheck");
		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, map.get("id").toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				resultMap.put("id", rs.getString("ID"));
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			readTx(rs, pstmt, conn);
		}
		return resultMap;
	}
	

}
