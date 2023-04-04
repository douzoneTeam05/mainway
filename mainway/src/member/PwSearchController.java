package member;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class PwSearchController implements Initializable {
	@FXML TextField user_name;
	@FXML TextField phone_num;
	
	private PwSearchService service;
	private Parent pwSearch;
	
	public void setpwSearch(Parent pwsearch) {
		pwSearch = pwsearch;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new PwSearchService();
	
	}
	
	// 비밀번호 찾기 버튼
	public void pwSearchProc () {
		
		PwSearchDTO Pwsearchdto = new PwSearchDTO();
		
		if (user_name.getText().trim().isEmpty()) {
			CommonService.msg("이름을 입력하세요.");
		} else if (phone_num.getText().trim().isEmpty()) {
			CommonService.msg("전화번호를 입력하세요.");
		} else {
			Pwsearchdto.setUser_name(user_name.getText());
			Pwsearchdto.setPhone_num(phone_num.getText());
			String pw = service.PwSearchStage(Pwsearchdto);
			if (pw == null) {
				CommonService.msg("입력된 비밀번호 정보와 일치하는 데이터가 없습니다.");
			} else {
			CommonService.msg(pw);
			}
		}
	}
}
