package heart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

//Controller 라는 클래스를 만들어서 scene builder에서 작성한 UI와 연결한다
//여기서 scene builder에서 설정한 event(마우스로 클릭할 때 발생하는 것)를 정의해야 한다


public class Controller  implements Initializable{
    //Controller 클래스는 Initializable interface를 상속한다 (intends는 class를 상속받을 때 사용)
	//interface는 class가 아니다 그러나 다중상속이 가능하기 때문에 사용한다 (implements를 사용)
	//Initializable은 내제된 interface이다 추상 method이기 때문에 @Override로 재정의 해줘야한다
	private Service service;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new Service();
	}
	
	// 좋아요 추가 기능 정의
	public void updateHeart1 () {
	// 반환 값이 없는 updateHeart1 매소드를 정의한다
		System.out.println("좋아요");
	// event가 작동하는지 확인하기 위해 썼다
		Heartdto heart = new Heartdto();
	// Class를 자료형으로 사용할 수 있다 int, long 이런거만 자료형이 아님
	// Heartdto 클래스의 함수를 사용할 수 있는 heart 라는 공간을 Heartdto 디폴트 생성자로 만든다
	// 생성자의 입력 항목이 없고 생성자 내부에 아무 내용이 없는 위와 같은 생성자를 디폴트 생성자라고 부른다.
		heart.setH_number(4);
	// 위에서 만든 heart라는 공간에 H_number pk의 4번째에 데이터를 넣는다 
	// 단! db랑 연동된 것은 아직 아님
		heart.setheart_num(0);
	// pk의 4번째인데 heart_num(좋아요를 저장하기로 한 column)에 데이터를 넣는다
		service.updateHeart1(heart);
	//서비스 클래스의 updateHeart1 함수에 위에서 heart 변수에 입력한 데이터를 전달한다
	}
	
	// 좋아요 삭제 기능 정의
	public void updateHeart2 () {
	// 반환 값이 없는 updateHeart2 함수를 정의한다
		System.out.println("좋아요취소");
		Heartdto heart = new Heartdto();
	// 디폴트 생성자 Heartdto로 Heartdto 클래스의 함수를 쓸 수 있는 heart 공간(객체)생성
		heart.setH_number(4);
	// heart 공간에 pk의 4번째 좌표에 데이터를 넣는다 
		heart.setheart_num(0);
	// heart 공간에 pk의 4번째 좌표의 heart_num column에 데이터를 넣는다
		service.updateHeart2(heart);
	// service 클래스의 updateHeart2 함수에 heart 데이터를 전달한다
	
	}	
}