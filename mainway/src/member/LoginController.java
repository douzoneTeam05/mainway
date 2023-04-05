package member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.Opener;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	@FXML TextField id;
	@FXML PasswordField pw;
	@FXML Button signin;
	
	private LoginService service;
	private RegDTO regDto;
	private Opener opener;
	
	public void Opener (Opener opener) { //opener 메서드 생성
		this.opener = opener;
	}
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();
		regDto = new RegDTO();
	}
	
	@FXML
	public void loginProc(Event event) throws IOException {
		service.loginProc(id.getText(), pw.getText());
		
		// 메뉴판 불러오기
		String result = service.loginCheck(id.getText());
		// 회원 로그인
		if(result != null && result.equals("Y")) {
			opener.mainViewOpen(event);
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
	
	// 관리자 모드
	@FXML
	public void manageMode(Event event) {
		try {
			opener.manageMode(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}