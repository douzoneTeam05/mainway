package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public void idOverlapStage(RegDTO idoverlap) {
		PreparedStatement ps = null;
		String sql = "SELECT id FROM membership WHERE id=?";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idoverlap.getId());
			rs = ps.executeQuery();
			if (idoverlap.getId().isEmpty()) {
				CommonService.msg("아이디를 입력하세요.");
			} else if (rs.next()) {
				CommonService.msg("이미 사용중인 아이디 입니다.");
			} else {
				CommonService.msg("사용할 수 있는 아이디 입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void nameOverlapStage(RegDTO nameoverlap) {
		PreparedStatement ps = null;
		String sql = "SELECT user_name FROM membership WHERE user_name=?";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nameoverlap.getUser_name());
			rs = ps.executeQuery();
			if (nameoverlap.getUser_name().isEmpty()) {
				CommonService.msg("닉네임을 입력하세요.");
			} else if (rs.next()) {
				CommonService.msg("이미 사용중인 닉네임 입니다.");
			} else {
				CommonService.msg("사용할 수 있는 닉네임 입니디.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void emailOverlapStage(RegDTO emailoverlap) {
		PreparedStatement ps = null;
		String sql = "SELECT email FROM membership WHERE email =?";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, emailoverlap.getEmail());
			rs = ps.executeQuery();
			if (emailoverlap.getEmail().isEmpty()) {
				CommonService.msg("이메일을 입력하세요.");
			} else if (rs.next()) {
				CommonService.msg("이미 사용중인 이메일 입니다.");
			} else {
				CommonService.msg("사용힐 수 있는 이메일 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
