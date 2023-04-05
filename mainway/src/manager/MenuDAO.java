package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * 메뉴 테이블 생성
CREATE TABLE menus(
menu_num number(10),
group_name varchar2(20),
menu varchar2(100),
image varchar2(200),
description varchar2(500),
price varchar2(20),
kcal varchar2(10),
PRIMARY Key(menu_num)
);
 */

public class MenuDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MenuDAO() {
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
	
	// 메뉴 등록(Insert)
	public void regProc(MenuDTO menuDto) {
		String sql = "SELECT nvl(max(menu_num), 0)+1 as max_num FROM menus";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				menuDto.setNum(rs.getInt("max_num"));
			} else {
				menuDto.setNum(0);
			}
			sql = "INSERT INTO menus VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, menuDto.getNum());
			ps.setString(2, menuDto.getGroup());
			ps.setString(3, menuDto.getMenu());
			ps.setString(4, menuDto.getImage());
			ps.setString(5, menuDto.getDescription());
			ps.setString(6, menuDto.getPrice());
			ps.setString(7, menuDto.getKcal());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	// 전체 메뉴 조회(SELECT)
	public ObservableList<MenuDTO> selectAll() {
		String sql = "SELECT * FROM menus ORDER BY menu_num";
		ArrayList<MenuDTO> menus = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuDTO menuDto = new MenuDTO();
				menuDto.setNum(rs.getInt("menu_num"));
				menuDto.setGroup(rs.getString("group_name"));
				menuDto.setMenu(rs.getString("menu"));
				menuDto.setImage(rs.getString("image"));
				menuDto.setDescription(rs.getString("description"));
				menuDto.setPrice(rs.getString("price"));
				menuDto.setKcal(rs.getString("kcal"));
				
				menus.add(menuDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (ObservableList<MenuDTO>) menus;
	}
	
	// 메뉴명으로 조회(SELECT)
	public ObservableList<MenuDTO> selectMenu(String menu) {
		String sql = "SELECT * FROM menus WHERE menu LIKE ?";
		ObservableList<MenuDTO> menus = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,  "%"+ menu+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuDTO menuDto = new MenuDTO();
				menuDto.setNum(rs.getInt("menu_num"));
				menuDto.setGroup(rs.getString("group_name"));
				menuDto.setMenu(rs.getString("menu"));
				menuDto.setImage(rs.getString("image"));
				menuDto.setDescription(rs.getString("description"));
				menuDto.setPrice(rs.getString("price"));
				menuDto.setKcal(rs.getString("kcal"));
				
				menus.add(menuDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
	// 메뉴 삭제(DELETE)
	public int delete(int num) {
		String sql =  "DELETE FROM menus WHERE menu_num=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			result = ps.executeUpdate(); // 쿼리 정상 실행 시 result = 1
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<MenuDTO> selectAllList() {
		String sql = "SELECT * FROM menus ORDER BY menu_num";
		ArrayList<MenuDTO> menus = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuDTO menuDto = new MenuDTO();
				menuDto.setNum(rs.getInt("menu_num"));
				menuDto.setGroup(rs.getString("group_name"));
				menuDto.setMenu(rs.getString("menu"));
				menuDto.setImage(rs.getString("image"));
				menuDto.setDescription(rs.getString("description"));
				menuDto.setPrice(rs.getString("price"));
				menuDto.setKcal(rs.getString("kcal"));
				
				menus.add(menuDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menus;
	}
	
	// 메뉴 수정(UPDATE)
	public void update(MenuDTO menuDto) {
		String sql = "UPDATE menus SET group_name = ?, menu = ?, image = ?, description = ?, price = ?, kcal = ? WHERE menu_num=?";
		System.out.println("수정확인");
		System.out.println(menuDto.getGroup());
		System.out.println(menuDto.getMenu());
		System.out.println(menuDto.getDescription());
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(7, menuDto.getNum());
			ps.setString(1, menuDto.getGroup());
			ps.setString(2, menuDto.getMenu());
			ps.setString(3, menuDto.getImage());
			ps.setString(4, menuDto.getDescription());
			ps.setString(5, menuDto.getPrice());
			ps.setString(6, menuDto.getKcal());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
