package member;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class IdSearchController implements Initializable {
	@FXML TextField user_name;
	@FXML TextField phone_num;
	
	private IdSearchService service;
	private Parent idSearch;
	
	public void setidSearch(Parent idsearch) {
		idSearch = idsearch;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new IdSearchService();
	}
	
	// 아이디 찾기 버튼
	public void idSearchProc () {
		
		IdSearchDTO idsearchdto = new IdSearchDTO();
		
		if (user_name.getText().trim().isEmpty()) {
			CommonService.msg("이름을 입력하세요.");
		} else if (phone_num.getText().trim().isEmpty()) {
			CommonService.msg("전화번호를 입력하세요.");
		} else {
			idsearchdto.setUser_name(user_name.getText());
			idsearchdto.setPhone_num(phone_num.getText());
			String id = service.idSearchStage(idsearchdto);
			if (id == null) {
			CommonService.msg("입력된 아이디 정보와 일치하는 데이터가 없습니다.");
			} else {
			CommonService.msg(id);
			}
		}
	}
}
