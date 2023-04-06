//package member;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//public class menuViewDAO {
//	
//	Connection con;
//	
//	public menuViewDAO() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "douzone";
//		String password = "oracle";
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			con = DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public ObservableList<menuViewDTO> menuViewStage() {
//		
//		ObservableList<menuViewDTO> obList = FXCollections.observableArrayList();
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "SELECT * FROM menus";
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				menuViewDTO menudto = new menuViewDTO();
//				menudto.setMenu_num(String.valueOf(rs.getInt("menu_num")));
//				menudto.setName(rs.getString("menu"));
//				menudto.setPrice(String.valueOf(rs.getString("price")));
//				menudto.setImage(rs.getString("image"));
//				obList.add(menudto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return obList;
//	}
//}
