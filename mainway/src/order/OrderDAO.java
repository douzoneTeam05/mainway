package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public OrderDAO() {
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
	
	public void insertOrder(OrderDTO order) {
		String sql = "SELECT nvl(max(id), 0)+1 FROM orderInfo";
		int num = 0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			sql = "INSERT INTO orderInfo "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, order.getMember_id());
			ps.setString(3, order.getName());
			ps.setString(4, order.getImg());
			ps.setString(5, order.getExplain());
			ps.setString(6, order.getPrice());
			ps.setString(7, order.getCalory());
			ps.setString(8, order.getBreadLen());
			ps.setString(9, order.getBread());
			ps.setString(10, order.getCheese());
			ps.setString(11, order.getVegetable());
			ps.setString(12, order.getSauce());
			ps.setString(13, order.getToping());
			ps.setString(14, order.getBeverage());
			ps.setString(15, order.getSnack());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<OrderDTO> selectOrders(String member_id) {
		ArrayList<OrderDTO> orders = new ArrayList<>();
		String sql = "SELECT * FROM orderInfo WHERE member_id = ? ORDER BY id";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setMember_id(member_id);
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setExplain(rs.getString("explain"));
				order.setPrice(rs.getString("price"));
				order.setCalory(rs.getString("calory"));
				order.setBreadLen(rs.getString("breadLen"));
				order.setBread(rs.getString("bread"));
				order.setCheese(rs.getString("cheese"));
				order.setVegetable(rs.getString("vegetable"));
				order.setSauce(rs.getString("sauce"));
				order.setToping(rs.getString("toping"));
				order.setBeverage(rs.getString("beverage"));
				order.setSnack(rs.getString("snack"));
				orders.add(order);
			}
			return orders;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public OrderDTO selectOrderById(int id) {
		String sql = "SELECT * FROM orderInfo WHERE id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setMember_id(rs.getString("member_id"));
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setExplain(rs.getString("explain"));
				order.setPrice(rs.getString("price"));
				order.setCalory(rs.getString("calory"));
				order.setBreadLen(rs.getString("breadLen"));
				order.setBread(rs.getString("bread"));
				order.setCheese(rs.getString("cheese"));
				order.setVegetable(rs.getString("vegetable"));
				order.setSauce(rs.getString("sauce"));
				order.setToping(rs.getString("toping"));
				order.setBeverage(rs.getString("beverage"));
				order.setSnack(rs.getString("snack"));
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<OrderDTO> selectOrderByMemberId(String member_id) {
		ArrayList<OrderDTO> orders = new ArrayList<>();
		String sql = "SELECT * FROM orderInfo WHERE member_id = ? ORDER BY id";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setMember_id(rs.getString("member_id"));
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setExplain(rs.getString("explain"));
				order.setPrice(rs.getString("price"));
				order.setCalory(rs.getString("calory"));
				order.setBreadLen(rs.getString("breadLen"));
				order.setBread(rs.getString("bread"));
				order.setCheese(rs.getString("cheese"));
				order.setVegetable(rs.getString("vegetable"));
				order.setSauce(rs.getString("sauce"));
				order.setToping(rs.getString("toping"));
				order.setBeverage(rs.getString("beverage"));
				order.setSnack(rs.getString("snack"));
				orders.add(order);
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateOrder(OrderDTO order) {
		String sql = "UPDATE orderInfo SET breadLen = ?, bread = ?, cheese = ?, vegetable = ? ,"
				+ "sauce = ?, toping = ?, beverage = ?, snack = ? "
				+ "WHERE id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, order.getBreadLen());
			ps.setString(2, order.getBread());
			ps.setString(3, order.getCheese());
			ps.setString(4, order.getVegetable());
			ps.setString(5, order.getSauce());
			ps.setString(6, order.getToping());
			ps.setString(7, order.getBeverage());
			ps.setString(8, order.getSnack());
			ps.setInt(9, order.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(String id) {
		String sql = "DELETE FROM orderInfo WHERE id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}