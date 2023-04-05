package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	// 관리자 계정 전체 조회(SELECT)
	public ArrayList<ManagerDTO> selectAllList() {
		String sql = "SELECT * FROM managers ORDER BY manager_num";
		ArrayList<ManagerDTO> managers = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ManagerDTO managerDto = new ManagerDTO();
				managerDto.setManager_num(rs.getInt("manager_num"));
				managerDto.setId(rs.getString("id"));
				managerDto.setPw(rs.getString("pw"));
				managerDto.setRegDate(rs.getString("reg_date"));
				
				managers.add(managerDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return managers;
	}

	// 관리자 계정 수정(UPDATE)
	public void update(ManagerDTO managerDto) {
		String sql = "UPDATE managers SET id = ?, pw = ?, reg_date = ? WHERE manager_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(3, managerDto.getManager_num());
			ps.setString(1, managerDto.getId());
			ps.setString(2, managerDto.getPw());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 관리자 아이디로 조회(SELECT)
	public ObservableList<ManagerDTO> selectManager(String id) {
		String sql = "SELECT * FROM managers WHERE id LIKE ?";
		ObservableList<ManagerDTO> managers = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,  "%"+ id +"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ManagerDTO managerDto = new ManagerDTO();
				managerDto.setManager_num(rs.getInt("manager_num"));
				managerDto.setId(rs.getString("id"));
				managerDto.setPw(rs.getString("pw"));
				managerDto.setRegDate(rs.getString("reg_date"));
				
				managers.add(managerDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return managers;
	}
	// 관리자 계정 등록(INSERT)
	public void regProc(ManagerDTO managerDto) {
		String sql = "SELECT nvl(max(manager_num), 0)+1 as max_num FROM managers";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				managerDto.setManager_num(rs.getInt("max_num"));
			} else {
				managerDto.setManager_num(0);
			}
			sql = "INSERT INTO managers VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, managerDto.getManager_num());
			ps.setString(2, managerDto.getId());
			ps.setString(3, managerDto.getPw());
			ps.setString(4, managerDto.getRegDate());

			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	// 관리자 계정 삭제(DELETE)
	public int delete(int managerNum) {
		String sql =  "DELETE FROM managers WHERE manager_num = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, managerNum);
			result = ps.executeUpdate(); // 쿼리 정상 실행 시 result = 1
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



}
