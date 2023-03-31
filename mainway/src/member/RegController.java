package member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
	
	public void setRegForm(Parent regForm) {
		RegForm = regForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new RegService();
	}
	
	//회원 가입 버튼
	public void regProc() {
		RegDTO reg = new RegDTO();
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
		
	public void idOverlapProc() {
		RegDTO idoverlap = new RegDTO();
		idoverlap.setId(id.getText());
		service.idOverlapStage(idoverlap);
	}
	
	public void nameOverlapProc() {
		RegDTO nameoverlap = new RegDTO();
		nameoverlap.setUser_name(user_name.getText());
		service.nameOverlapStage(nameoverlap);
	}
	
	public void emailOverlapProc() {
		RegDTO emailoverlap = new RegDTO();
		emailoverlap.setEmail(email.getText());
		service.emailOverlapStage(emailoverlap);
	}
}
