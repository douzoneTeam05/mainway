package manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManagerLoginController implements Initializable{
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
		
		// 로그인 체크
		String result = service.loginCheck(id.getText());
		
		if(result != null && result.equals("Y")) {
			// 로그인 화면의 Stage에 managerMenu.fxml 화면 실행
			opener.menuOpen();
		}
	}


}
