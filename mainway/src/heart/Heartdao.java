package heart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class Heartdao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs; 
 //db와 연결해주는 기능을 한다
	
	public Heartdao() {
 // 내가 임의로 함수를 정의
		String user = "douzone";
		String password = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
 // db의 좌표값을 입력하고 유저와 비밀번호를 입력한다. 연결을 위한 메소드를 정의
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
 // db와 연결해주는 공식
		}
	}
	
	public int selectMaxNum() {
		String sql = "SELECT nvl(max(num), 0) FROM heart_table";
		//max(num) DB에 저장되어있는 개수, 하트 TABLE에 값이 하나도 없을 때 0 반환
		PreparedStatement ps = null;
		ResultSet rs = null;
		int maxNum = 0;
 // heart table의 데이터를 조회하는 매소드를 정의함, 매소드 이름은 임의로 정함
		
		try {
			ps = con.prepareStatement(sql);
			//DB에 SQL 쿼리문을 전달하고 PS에 저장
			rs = ps.executeQuery();
			//PS 쿼리문을 실행후 SELECT 받아온 값을 RS에 저장
			if(rs.next()) {
				// SELECT 문을 실행했을 때 값이 있으면 실행 (값이 없으면 실행안됨) RS.NEXT를 써서 하나씩 값을 반환한다
				maxNum = rs.getInt(1);
				//저장되있는 값의 자료형에 따라서 ()안에 컬럼명을 입력한다
				//숫자로 입력할 때는 컬럼의 순서를 의미한다
				//RS의 있는 자료를 MAXNUM에 대입한다 getInt(1) = getInt("첫번째 컬럼명")
			}
		} catch (Exception e) {
			
		}
		return ++maxNum;
			// select 조회니까 return 값이 있다
	}
	public void selectuser(Heartdto heart) {
		String sql = "SELECT menu_number, m_number FROM heart_table WHERE H_number = ?";
		//조건을 걸어주는 게 ? 이다 pk가 몇인 행의 회원넘버와 메뉴 넘버값을 가져올지 정하는거다
		PreparedStatement ps = null;
		//ps객체 생성 자료형은 preparedStatement(여기 함수를 사용할 수 있음)
		ResultSet rs = null;
		//rs객체 생성 자료형은 ResultSet 여기 함수 사용할 수 있음
		try {
		ps = con.prepareStatement(sql);
		//db랑 연결해서 prepareStatement 함수로 sql문 실행 한걸 ps에 저장 
			ps.setLong(1, heart.getH_number());
		//heart에 담겨있는 정보(table 전체정보)중에서 H_number 자료를 꺼내서 ps에 넣는다
		rs = ps.executeQuery();
		//ps의 쿼리문을 실행하고 rs에 넣는다
		if(rs.next()) {
		//rs.next rs에 값이 있는지 확인하는 매소드
		//만약 rs.next rs에 값이 있는지 확인한다 없으면 아무것도 안함 else 안썼음
		Long box1 = rs.getLong("menu_number");
		Long box2 = rs.getLong("m_number");
		//long형의 box1공간을 만들어서 rs에 담긴 칼럼 값을 넣는다
		//getlong의 기능 : ()안에 칼럼의 값을 가져온다
				
		}
		} catch (Exception e) {
			e.printStackTrace();		
		}
			
			
		
		}
	
	
	
	public void updateHeart1(Heartdto heart) {
		String sql = "UPDATE heart_table SET heart_num=heart_num+1 WHERE h_number=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		//null 값을 주어서 초기화를 시켜준다 why? 초기화를 안시키면 에러뜰수도 있음
		try {
				
		ps = con.prepareStatement(sql);
			ps.setLong(1, heart.getH_number());
	//sql문의 첫번째 물음표 위치에 heart에 입력한 H_number의 값을 가져와서 넣는다
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateHeart2(Heartdto heart) {
		String sql = "UPDATE heart_table SET heart_num=heart_num-1 WHERE h_number=?";
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {
				
		ps = con.prepareStatement(sql);
			ps.setLong(1, heart.getH_number());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void insertHeart(Heartdto heart) {
		String sql = "INSERT INTO heart_table VALUES(?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		
		ps = con.prepareStatement(sql);
			ps.setLong(1, heart.getH_number());
			ps.setLong(2, heart.getMenu_number());
			ps.setLong(3, heart.getM_number());
			ps.setLong(4, heart.getheart_num());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
