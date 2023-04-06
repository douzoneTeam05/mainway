package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.CommonService;

public class RegDAO {
	private Connection con;
	
	public RegDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void regStage(RegDTO reg) {
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO membership VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reg.getId());
			ps.setString(2, reg.getPw());
			ps.setString(3, reg.getUser_name());
			ps.setString(4, reg.getBirth());
			ps.setString(5, reg.getEmail());
			ps.setString(6, reg.getPhone_num());
			ps.setString(7, reg.getGender());
			ps.setString(8, reg.getLogin_check());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean idOverlapStage(String id) {
		
		if (id.trim().isEmpty()) {
			CommonService.msg("아이디를 입력하세요.");
			return false;
		} else if(id.length() > 20) {
			CommonService.msg("아이디를 20자내로만 가능합니다.");
			return false;
		}else {
			
			PreparedStatement ps = null;
			String sql = "SELECT id FROM membership WHERE id=?";
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					CommonService.msg("이미 사용중인 아이디 입니다.");
					return false;
				} else {
					CommonService.msg("사용할 수 있는 아이디 입니다.");
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	} 
	
	public boolean emailOverlapStage(String email) {
		
		if (email.trim().isEmpty()) {
			CommonService.msg("이메일을 입력하세요.");
			return false;
		} else if(email.length() > 50) {
			CommonService.msg("이메일은 50자내로만 가능합니다.");
			return false;
		} else {
			
			PreparedStatement ps = null;
			String sql = "SELECT email FROM membership WHERE email=?";
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				rs = ps.executeQuery();
				
				
				if (rs.next()) {
					System.out.println(rs.getString("email"));
					CommonService.msg("이미 사용중인 이메일 입니다.");
					return false;
				} else {
					CommonService.msg("사용할 수 있는 이메일 입니다.");
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean phone_numOverlapStage(String phone) {
		if (phone.trim().isEmpty()) {
			CommonService.msg("전화번호를 입력하세요.");
			return false;
		} else if(phone.length() > 20) {
			CommonService.msg("전화번호 10자내로만 가능합니다.");
			return false;
		} else {
			
			PreparedStatement ps = null;
			String sql = "SELECT phone_num FROM membership WHERE phone_num=?";
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, phone);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					CommonService.msg("이미 사용중인 이메일 입니다.");
					return false;
				} else {
					CommonService.msg("사용할 수 있는 이메일 입니다.");
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// 로그인한 회원 정보 조회 
	public RegDTO loginMember(String id) {
		PreparedStatement ps = null;
		String sql = "SELECT * FROM membership WHERE id = ?";
		ResultSet rs = null;
		RegDTO loginMember = new RegDTO();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				loginMember = new RegDTO();
				loginMember.setId(rs.getString("id"));
				loginMember.setUser_name(rs.getString("user_name"));
				System.out.println(rs.getString("id") +"로그인한 회원 정보 가져오기 Test"+rs.getString("user_name"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginMember;
	}
}
