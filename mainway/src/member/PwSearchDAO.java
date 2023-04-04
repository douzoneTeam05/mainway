package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PwSearchDAO {
	private Connection con;
	
	public PwSearchDAO() {
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
	
	public String PwSearchStage(PwSearchDTO pwsearchdto) {
		String sql = "SELECT pw FROM membership WHERE user_name = ? AND phone_num = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pw = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pwsearchdto.getUser_name());
			ps.setString(2, pwsearchdto.getPhone_num());
			rs = ps.executeQuery();
			if (rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pw;
	}
}
