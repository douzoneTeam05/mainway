package heart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

//Controller 라는 클래스를 만들어서 scene builder에서 작성한 UI와 연결한다
//여기서 scene builder에서 설정한 event(마우스로 클릭할 때 발생하는 것)를 정의해야 한다


public class Controller  implements Initializable{
    //Controller 클래스는 Initializable interface를 상속한다 (intends는 class를 상속받을 때 사용)
	//interface는 class가 아니다 그러나 다중상속이 가능하기 때문에 사용한다 (implements를 사용)
	//Initializable은 내제된 interface이다 추상 method이기 때문에 @Override로 재정의 해줘야한다
	private Service service;
	private Heartdto heart;
	//자료형을 지정해주면서 변수 선언 ex)int a

	@FXML
    private RadioButton button;

	// 좋아요 버튼 정의
    @FXML
   public void updateHeart1(ActionEvent event) {
    	heart = new Heartdto();
    	heart.setH_number(2); // PK 값이 2인 경우 
    	heart.setM_number(10); // 회원 정보가 10인 회원인 경우
    	heart.setMenu_number(100); // 메뉴 번호가 100번인 메뉴인 경우
    	if(!button.isSelected()) {
    		heart.setheart_num(0);   		
    		service.updateHeart2(heart);
    	} else {
    		heart.setheart_num(1);
    		service.updateHeart1(heart);
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//추상 메소드이다 이걸 재정의 해줘야 함
	//initialize라는 함수를 쓰려면 initialize의 함수를 정의하고 내용도 채워놔야 하는데
	//이미 이클립스에 내장되어 있어서 인터페이스로 내장된 함수를 불러와서 재정의(Override)해주면 그냥 쓸 수 있음
		service = new Service();
	//함수를 재정의 해주는 게 Override인데 구체화 해준다는 의미이다(구현한다)
	}


	
	
}