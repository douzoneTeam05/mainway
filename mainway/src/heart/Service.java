package heart;

import java.util.ArrayList;

public class Service {
	HeartDAO Heart;
	
	public Service() {
		Heart = new HeartDAO();
	}
	
	public void insertHeart(Heartdto heart) {
 
	System.out.println("좋아요");
	
	if(Heart.selectyes(heart) != null) {
		
		heart.setYes_no("yes");
		Heart.update(heart);
		
	} else {
		Heart.insertHeart(heart);
	}
	}

	public void update(Heartdto heart) {
	System.out.println("수정");
	
		Heart.update(heart);
		
	}
	
	
	public String selectyes(Heartdto heart) {
		return Heart.selectyes(heart);
	}
	
	public ArrayList<Long> selectmenu(Heartdto heart) {
		System.out.println("조회");
		return Heart.selectmenu(heart);
	}
	
}
