package manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import member.RegDTO;

public class MemberManageController implements Initializable{
	
	private ManagerService service;
	private ObservableList<RegDTO> data;
	private Parent ManagerManage;
	
	public void setMemberManage(Parent memberManage) {
		ManagerManage = memberManage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// 조회 버튼
	@FXML
	public void selectClick(ActionEvent event) {
	}
	
	
	// 저장 버튼
	@FXML
	public void regProc() {
	}
	
	// 등록 버튼
	@FXML
	public void addClick(ActionEvent event) {
		
	}
	
	// 수정 버튼
	@FXML
	public void updateClick(ActionEvent event) {

	}
	
	// 삭제 버튼
	@FXML
	public void deleteClick(ActionEvent event) {
		
	}
	
	// TableView 클릭 했을 때 TexField 반영
	@FXML
	public void tableClick(MouseEvent event) {
		
	}


	
	
	
		
		

}
