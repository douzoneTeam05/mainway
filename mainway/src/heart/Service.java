package heart;

import member.LoginDAO;

public class Service {
	Heartdao heartDao = new Heartdao();
	
  // heart라는 매개변수는 Heartdto 자료형으로 받았다
  // 왜? Heartdto로 controller class에서 정의를 했기 때문에
  // 하지만 heartDao 객체 자료형은 Heartdao 생성했다!!
  // 왜? Heartdao 클래스의 매소드를 사용하기 위해서!!
	
  // Heartdao 클래스의 매소드를 왜 사용하냐??
  // Heartdao class에서 Db로 DTO를 통해 얻은 데이터를 전달해 주기 위해서
  // DTO의 매소드는 여기서 사용하지도 않았다 굳이 쓰지않았다
  // 왜?? 데이터를 받거나 넣거나 할 이유가 없으니까
  // 왜?? heart에 이미 데이터가 다 있으니까!!
	
  // Heartdao 클래스의 함수를 사용할 수 있는 Heartdao 디폴트 생성자를 사용하는
  // heartDao 라는 공간(객체)를 만든다
  // 공간을 안만들면 Controller에서 받아온 데이터를 함수에 넣어 줄 수 없다
	

	public void updateHeart1(Heartdto heart) {
  // 객체 생성 안해도 함수안에서 Heartdto 함수를 쓸 수 있다
  // int heart로 쓴다면 이 함수 안에서 int 자료형을 쓸 수 있는 것처럼
  // Heartdto를 여기서 썼기 때문에 Controller에서 Heartdto로 쓴것 순서가 뒤에서 앞임
  // Heartdto를 자료형으로 하는 heart라는 매개변수로 updateHeart1 매소드를 실행
  // dto에 데이터를 넣다 뺐다 하니까 dto 자료형으로 만들었다 controller에서
  // 매소드() 괄호 있으면 매소드임 void 리턴값이 없다는 의미
		System.out.println("서비스1실행");
  // 서비스1이 실행되는지 확인, 이 문장은 controller 클래스 함수정의 부분에 써도 똑같다
		heartDao.updateHeart1(heart);
  // heart 변수에 전달된 데이터를 heartDao의 updateHeart1 매소드로 전달한다
		
	}
	
	public void updateHeart2(Heartdto heart) {
  // Heartdto 자료형으로 heart를 매개변수로 하는 updateHeart2 함수를 정의한다
  // Controller에서 여기로 자료를 보냈기 때문에 함수(매소드)를 정의 해줘야 한다
  // Controller에서 데이터를 heart로 보냈다
		System.out.println("서비스2실행");
  // 서비스2가 실행되는지 확인
		heartDao.updateHeart2(heart);
  // heart 변수에 전달된 데이터를 heartDao의 updateHeart2 함수로 보낸다
		
	}

	
	
	
}
