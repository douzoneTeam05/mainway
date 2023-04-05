package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IdSearchDAO {
	private Connection con;
	
	public IdSearchDAO() {
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
	
	public String IdSearchStage(IdSearchDTO idsearchdto) {
		String sql = "SELECT id FROM membership WHERE user_name = ? AND phone_num = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idsearchdto.getUser_name());
			ps.setString(2, idsearchdto.getPhone_num());
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
