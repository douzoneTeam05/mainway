package member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	@FXML TextField id;
	@FXML PasswordField pw;
	
	private LoginService service;
	private Opener opener;
	
	public void Opener (Opener opener) { //opener 메서드 생성
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();
	}
	
	public void loginProc() {
		service.loginProc(id.getText(), pw.getText());
		
		// 메뉴판 불러오기
		String result = service.loginCheck(id.getText());
		if(result != null && result.equals("Y")) {
		opener.mainViewopen();
		}
	}
	
	public void regProc () {
		try {
			opener.regopen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void idSearchProc() {
		try {
			opener.idSearchOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pwSearchProc() {
		try {
			opener.pwSearchopen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}