package heart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class HeartDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public HeartDAO() {
		String user = "douzone";
		String password = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public String selectyes(Heartdto heart) {
		String sql = "SELECT yes_no FROM heart_table WHERE menu_number=? and m_number = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String box = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, heart.getMenu_number());
		ps.setLong(2, heart.getM_number());
			rs = ps.executeQuery();
		if(rs.next()) {
				 box = rs.getString("yes_no");
				 
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	return box;
		
	}
	
	public void insertHeart(Heartdto heart) {
		String sql = "SELECT nvl(max(h_number), 0) FROM heart_table";
		PreparedStatement ps = null;
		ResultSet rs = null;
		long num = 0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getLong(1)+1;
			}
			
			sql = "INSERT INTO heart_table VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, num);
			ps.setLong(2, heart.getMenu_number());
			ps.setLong(3, heart.getM_number());
			ps.setString(4, heart.getYes_no());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
		
	public void update(Heartdto heart) {
		String sql = "UPDATE heart_table SET yes_no = ? WHERE Menu_number = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, heart.getYes_no());
			ps.setLong(2, heart.getMenu_number());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
