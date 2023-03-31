package manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManagerController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	private ManagerService service;
	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new ManagerService();
	}
	// 로그인 버튼 
	public void loginProc(){	
		service.loginProc(id.getText(), pw.getText());
		String result = service.loginCheck(id.getText());
		if(result != null && result.equals("Y")) {
			//로그인 화면의 Stage에 Menu.fxml 화면을 실행하겠다.
			opener.menuOpen();
		}
		
		/*
		 LoginService Class를 생성하고, Method를 loginProc을 구현하세요.
		 LoginDAO Class를 생성하고, Method를 LoginProc을 구현하세요.
		 DAO는 데이터베이스 접근
		 Service는 데이터(입력 값) 검증
		 
		 출력 : 로그인 성공 또는 실패 Alert를 출력하기
		 Table Name : javaFx
		 Column Name : id, pw, name, gender(성별), hobbys(취미)
		 */
	}



}
