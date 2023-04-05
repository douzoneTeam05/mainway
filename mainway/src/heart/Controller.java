package heart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

//Controller 라는 클래스를 만들어서 scene builder에서 작성한 UI와 연결한다
//여기서 scene builder에서 설정한 event(마우스로 클릭할 때 발생하는 것)를 정의해야 한다


public class Controller  implements Initializable{
    //Controller 클래스는 Initializable interface를 상속한다 (intends는 class를 상속받을 때 사용)
	//interface는 class가 아니다 그러나 다중상속이 가능하기 때문에 사용한다 (implements를 사용)
	//Initializable은 내제된 interface이다 추상 method이기 때문에 @Override로 재정의 해줘야한다
	private Service service;
	private Heartdto heart= new Heartdto();
	
	//자료형을 지정해주면서 변수 선언 ex)int a

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//추상 메소드이다 이걸 재정의 해줘야 함
	//initialize라는 함수를 쓰려면 initialize의 함수를 정의하고 내용도 채워놔야 하는데
	//이미 이클립스에 내장되어 있어서 인터페이스로 내장된 함수를 불러와서 재정의(Override)해주면 그냥 쓸 수 있음
		service = new Service();
	//함수를 재정의 해주는 게 Override인데 구체화 해준다는 의미이다(구현한다)
	}
	
	
	 @FXML
	    private RadioButton button1;

	    @FXML
	    private RadioButton button2;

	    @FXML
	    private RadioButton button3;

	    @FXML
	    private RadioButton button4;

	    @FXML
	    private RadioButton button5;

	    @FXML
	    private RadioButton button6;

	    @FXML
	    private RadioButton button7;

	    @FXML
	    private RadioButton button8;

	    @FXML
	    private RadioButton button9;

	    @FXML
	    private RadioButton button10;


    @FXML
    void insertHeart1(ActionEvent event) {
    	System.out.println("1번 선택");
    	heart.setYes_no("yes"); // yes인경우
    	heart.setM_number(1);
    	heart.setMenu_number(1);
    	if(button1.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
    	
    }

    @FXML
    void insertHeart2(ActionEvent event) {
    	System.out.println("2번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(1);
		heart.setMenu_number(2);
		if(button2.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }

    @FXML
    void insertHeart3(ActionEvent event) {
    	System.out.println("3번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(1);
		heart.setMenu_number(3);   		
		if(button3.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }

    @FXML
    void insertHeart4(ActionEvent event) {
    	System.out.println("4번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(2);
		heart.setMenu_number(4);  		
		if(button4.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart5(ActionEvent event) {
    	System.out.println("5번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(2);
		heart.setMenu_number(5);   		
		if(button5.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart6(ActionEvent event) {
    	System.out.println("6번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(2);
		heart.setMenu_number(6);   		
		if(button6.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart7(ActionEvent event) {
    	System.out.println("7번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(3);
		heart.setMenu_number(7);   		
		if(button7.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart8(ActionEvent event) {
    	System.out.println("8번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(3);
		heart.setMenu_number(8);   		
		if(button8.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart9(ActionEvent event) {
    	System.out.println("9번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(3);
		heart.setMenu_number(9);   		
		if(button9.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
    @FXML
    void insertHeart10(ActionEvent event) {
    	System.out.println("10번 선택");
    	heart.setYes_no("yes"); // yes인경우
		heart.setM_number(3);
		heart.setMenu_number(10);   		
		if(button10.isSelected()) { 
    		service.insertHeart(heart);    		
    	} else {
    		heart.setYes_no("no");
    		service.update(heart);
    	}
	
    }
    
}