package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.TextField;

public class ManagerDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	String adminId = "";
	String adminPw = "";
	
	
	public ManagerDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "douzone";		
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public String loginProc(String id) {
		String sql = "SELECT pw FROM managers WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pw = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pw;
	}
	

	// 아이디 조회 
	public boolean findId(String adminId) {
		String sql = "SELECT * FROM managers WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("adminId: " + adminId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	// 비밀번호 확인
	public boolean checkPw(String adminId, String adminPw) {
		String sql = "SELECT pw FROM managers WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("adminPw:" + adminPw);
				if(rs.getString("pw").equals(adminPw)) {
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// 로그인 성공 시 loginCheck 업데이트
	public void loginSuccess(String id) {
		String sql = "UPDATE managers SET login_check='Y' WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// 로그인 여부 조회
	public String loginCheck(String id) {
	String sql = "SELECT login_check FROM managers WHERE id =?";
	PreparedStatement ps = null;
	String loginCheck = "";
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if(rs.next()) {
			loginCheck = rs.getString("login_check");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return loginCheck;
	}



}
