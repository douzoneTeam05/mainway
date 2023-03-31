package heart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Heartdao {
	private Connection con;
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
}
