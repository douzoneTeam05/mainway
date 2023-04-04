package member;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegController implements Initializable {
	@FXML TextField id;
	@FXML TextField user_name;
	@FXML TextField birth;
	@FXML TextField email;
	@FXML TextField phone_num;
	@FXML PasswordField pw;
	@FXML PasswordField confirm;
	@FXML RadioButton manRadio;
	@FXML RadioButton womanRadio;
	
	private RegService service;
	private Parent RegForm;
	
	int idCheck = 0;
	int emailCheck = 0;
	int phoneCheck = 0;
	
	public void setRegForm(Parent regForm) {
		RegForm = regForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new RegService();
	}
	
	//회원 가입 버튼
	public void regProc() {
		
		if(idCheck > 0 && emailCheck > 0 && phoneCheck > 0 ) {
			RegDTO reg = new RegDTO();
			
			if (pw.getText().isEmpty()) {
				CommonService.msg("비밀번호를 입력하세요.");
			} else if (birth.getText().isEmpty()) {
				CommonService.msg("생년월일을 입력하세요.");
			} else if (user_name.getText().isEmpty()) {
				CommonService.msg("이름을 입력하세요.");
			} else if (!manRadio.isSelected() && !womanRadio.isSelected()) {
				CommonService.msg("성별을 체크하세요.");
			} else {
				reg.setId(id.getText());
				reg.setPw(pw.getText());
				reg.setUser_name(user_name.getText());
				reg.setBirth(birth.getText());
				reg.setEmail(email.getText());
				reg.setPhone_num(phone_num.getText());
				
				if(manRadio.isSelected()) {
					reg.setGender("남");
				} else if (womanRadio.isSelected()) {
					reg.setGender("여");
				}
				
				service.regStage(reg);
				CommonService.windowClose(RegForm);
			}
			
		} else if (idCheck == 0){
			CommonService.msg("아이디 중복확인을 해주세요.");
		} else if (emailCheck == 0) {
			CommonService.msg("이메일 중복체크를 해주세요.");
		} else if (phoneCheck == 0) {
			CommonService.msg("전화번호 중복체크를 해주세요.");
		}
	}
		
	public void idOverlapProc(MouseEvent event) {
		idCheck = event.getClickCount();
		if(!service.idOverlapStage(id.getText())) {
			idCheck = 0;
		}	
	}
	
	public void emailOverlapProc(MouseEvent event) {
		emailCheck = event.getClickCount();
		if (!service.emailOverlapStage(email.getText())) {
			emailCheck = 0;
		}
	}
	
	public void phone_numOverlapProc(MouseEvent event) {
		phoneCheck = event.getClickCount();
		if (!service.phone_numOverlapStage(phone_num.getText())) {
			phoneCheck = 0;
		}
	}
}
