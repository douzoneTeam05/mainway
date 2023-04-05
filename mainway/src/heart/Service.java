package heart;


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
  // 서비스1이 실행되는지 확인, 이 문장은 controller 클래스 함수정의 부분에 써도 똑같다
	
  // heart 변수에 전달된 데이터를 heartDao의 updateHeart1 매소드로 전달한다
		
	}
	
//	public void selectyes(Heartdto heart) {
//	System.out.println("조회");
//		
//		Heart.selectyes(heart);
//	}
		
	public void update(Heartdto heart) {
	System.out.println("수정");
	
		Heart.update(heart);
	
		
	}

	
	
	
}
