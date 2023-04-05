package manager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ManagerManageController implements Initializable{
	@FXML TextField manager_num;
	@FXML TextField id;
	@FXML TextField pw;
	@FXML TextField date;
	@FXML TextField keyword;	
	@FXML Button saveBtn;
	@FXML Button searchBtn;
	@FXML Button addBtn;
	@FXML Button updateBtn;
	@FXML Button deleteBtn;
	@FXML TableView<ManagerDTO> table;
	@FXML TableColumn<ManagerDTO, Integer> numCol;
	@FXML TableColumn<ManagerDTO, String> idCol;
	@FXML TableColumn<ManagerDTO, String> pwCol;
	@FXML TableColumn<ManagerDTO, String> dateCol;
	
	private ManagerService service;
	private ObservableList<ManagerDTO> data;
	private Parent ManagerManage;
	private String status = "";
	
	public void setManagerManage(Parent managerManage) {
		ManagerManage = managerManage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new ManagerService();
		
		// TableView 컬럼에 데이터 맞춰 넣기
		new TableColumn<>("manager_num");
		numCol.setCellValueFactory(new PropertyValueFactory("manager_num"));
		idCol.setCellValueFactory(new PropertyValueFactory("id"));
		pwCol.setCellValueFactory(new PropertyValueFactory("pw"));	
		dateCol.setCellValueFactory(new PropertyValueFactory("regDate"));
		
		saveBtn.setDisable(true);
		setTableView();
	}
	
	
	// 조회 버튼
	public void selectClick() {
		table.getItems().clear();
		table.setItems(service.selectManager(keyword.getText()));
	}

	// 저장 버튼
	@FXML
	public void regProc() {
		if(id.getText().isEmpty()) {
			CommonService.warningMsg("입력 오류", "아이디를 입력하세요.");
			id.requestFocus();
			return;			
		} else if(pw.getText().isEmpty()) {
			CommonService.warningMsg("입력 오류", "패스워드를 입력하세요.");
			pw.requestFocus();
			return;
		}
		
		ManagerDTO managerDto = new ManagerDTO();
		managerDto.setId(id.getText());
		managerDto.setPw(pw.getText());
		
		Date date = new Date(); // 날짜 구하기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식
		String regDate = sdf.format(date);
		managerDto.setRegDate(regDate);
		
		if(status == "update") {
			// DB 데이터 수정
			int managerNum = table.getSelectionModel().getSelectedItem().getManager_num();
			service.update(managerNum, managerDto);
			
			// tableView데이터 수정
			int idx = table.getSelectionModel().getSelectedIndex();
			data.set(idx, managerDto);
			
			CommonService.msg("데이터 수정 완료");
			editExit(addBtn, updateBtn, deleteBtn, saveBtn);
		} else {
			service.regProc(managerDto);
			CommonService.msg("관리자 등록 완료");
			editExit(addBtn, updateBtn, deleteBtn, saveBtn);
		}
		
		setTableView();
	}
	
	
	// 등록 버튼
	@FXML
	public void addClick(ActionEvent event) {
		status = "insert";
		editable(addBtn, updateBtn, deleteBtn, saveBtn);
		
		// 관리자 번호 비활성화
		manager_num.setEditable(false);
		
		// TextField 내용 삭제
		id.clear();
		pw.clear();
	}
	
	
	// 수정 버튼
	@FXML
	public void updateClick(ActionEvent event) {
		if(table.getSelectionModel().isEmpty()) {
			CommonService.msg("수정할 데이터를 선택하세요.");
			return;
		}
		status = "update";
		editable(addBtn, updateBtn, deleteBtn, saveBtn);
	}
	
	
	// 삭제 버튼
	@FXML
	public void deleteClick(ActionEvent event) {
		if(table.getSelectionModel().isEmpty()) {
			CommonService.warningMsg("선택 오류", "삭제할 데이터를 선택하세요.");
			return;
		}
		
		// DB 데이터 삭제
		int managerNum = table.getSelectionModel().getSelectedItem().getManager_num();
		service.delete(managerNum);
		setTableView();
		
		// TextField 내용 삭제
		id.clear();
		pw.clear();
		
		CommonService.msg("관리자 데이터 삭제 완료");
	}
	
	// TableView 클릭 했을 때 TexField 반영
	@FXML
	public void tableClick(MouseEvent event) {
		if(!table.getSelectionModel().isEmpty()) {
			ManagerDTO managerDto = table.getSelectionModel().getSelectedItem();
			
//			manager_num.setText(managerDto.getManager_num());
			id.setText(managerDto.getId());
			pw.setText(managerDto.getPw());
			date.setText(managerDto.getRegDate());
		}
	
	}
	

	// 데이터 작업 후 tableView 세팅
	private void setTableView() {
		ArrayList<ManagerDTO> managers = service.selectAllList();
		data = FXCollections.observableArrayList(managers);

		table.setItems(data);
	}
	
	// 편집(등록/수정) 준비
		private void editable(Button addBtn, Button updateBtn, Button deleteBtn, Button saveBtn) {
			// 등록, 수정, 삭제 Button 비활성화, 저장 Button 활성화
			saveBtn.setDisable(false);
			addBtn.setDisable(true);
			updateBtn.setDisable(true);
			deleteBtn.setDisable(true);
			
			// TextField 관리자 번호 비활성화
			manager_num.setDisable(true);
			
			// TableView 비활성화
			table.setDisable(true);
			
			// TextField 편집 상태로 변경
			id.setEditable(true);
			pw.setEditable(true);
			
			// 아이디에 포커스 주기
			id.requestFocus();
				

		}
	
	// 편집(등록/수정) 종료
		private void editExit(Button addBtn, Button updateBtn, Button deleteBtn, Button saveBtn) {
			// 등록, 수정, 삭제 Button 활성화, 저장 Button 비활성화
			saveBtn.setDisable(true);
			addBtn.setDisable(false);
			updateBtn.setDisable(false);
			deleteBtn.setDisable(false);
			
			// TextField 편집 불가 상태로 변경
//			manager_num.setEditable(false);
			id.setEditable(false);
			pw.setEditable(false);
				
			// TextField 내용 삭제
			id.clear();
			pw.clear();
			
			// TableView 활성화
			table.setDisable(false);		
		}
	
	

}
