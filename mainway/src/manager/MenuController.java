package manager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MenuController implements Initializable{
	@FXML ChoiceBox<String> group;
	@FXML TextField menu;
	@FXML TextField image;
	@FXML TextArea description;
	@FXML TextField price;
	@FXML TextField kcal;
	@FXML Button addBtn;
	@FXML Button updateBtn;
	@FXML Button imgBtn;
	@FXML TableView<MenuDTO> table;
	@FXML TableColumn< MenuDTO, String> numCol;
	@FXML TableColumn< MenuDTO, String> groupCol;
	@FXML TableColumn< MenuDTO, String> menuCol;
	@FXML TableColumn< MenuDTO, String> imageCol;
	@FXML TableColumn< MenuDTO, String> descriptionCol;
	@FXML TableColumn< MenuDTO, String> priceCol;
	@FXML TableColumn< MenuDTO, String> kcalCol;
//	@FXML TableColumn< MenuDTO, String> dateCol;

    
	private MenuService service;
	private ObservableList<MenuDTO> data;
	private String status = "";
	private Parent MenuCreate;
	
//    public MenuController() {
//    	service = MenuService.getInstance();
//    }
	
	public void setMenuCreate(Parent menuCreate) {
		MenuCreate = menuCreate;
		ChoiceBox<String> lv =(ChoiceBox<String>) menuCreate.lookup("#group");
		lv.getItems().addAll("샌드위치", "음료");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new MenuService();
		
		// TableView 컬럼에 데이터 맞춰 넣기 
		new TableColumn<>("menu_num");
		numCol.setCellValueFactory(new PropertyValueFactory("num"));
		groupCol.setCellValueFactory(new PropertyValueFactory("group"));
		menuCol.setCellValueFactory(new PropertyValueFactory("menu"));
		imageCol.setCellValueFactory(new PropertyValueFactory("image"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
		priceCol.setCellValueFactory(new PropertyValueFactory("price"));
		kcalCol.setCellValueFactory(new PropertyValueFactory("kcal"));

		setTableView();
	}
	
	// 조회 버튼
	@FXML
	public void selectClick(ActionEvent event) {
	}

	// 저장 버튼
	@FXML
	public void regProc() {
		MenuDTO menuDto = new MenuDTO();
		menuDto.setGroup(group.getValue());
		menuDto.setMenu(menu.getText());
		menuDto.setImage(image.getText());
		menuDto.setDescription(description.getText());
		menuDto.setPrice(price.getText());
		menuDto.setKcal(kcal.getText());
		
		if(status == "update") {			
			// DB 데이터 수정
			int menuNum = table.getSelectionModel().getSelectedItem().getNum();	
			service.update(menuNum, menuDto);
			
			// tableView 데이터 수정
			int idx = table.getSelectionModel().getSelectedIndex();
			data.set(idx, menuDto);
			
			CommonService.msg("메뉴 수정 완료");	
			editExit(updateBtn);
		} else {
			service.regPrco(menuDto);
			CommonService.msg("메뉴 등록 완료");	
			editExit(addBtn);
		}
		
		setTableView();

	}
	
	
	// 등록 버튼
	@FXML
	public void addClick(ActionEvent event) {
		status = "insert";
		editable(addBtn);
		
		// TextField 내용 삭제
		menu.clear();
		image.clear();
		description.clear();
		price.clear();
		kcal.clear();	
		
	}
	
	
	// 수정 버튼
	@FXML
	public void updateClick(ActionEvent event) {
		if(table.getSelectionModel().isEmpty()) {
			CommonService.msg("수정할 데이터를 선택하세요.");
			return;
		}		
		status = "update";
		editable(updateBtn);
	}
	
	
	// 삭제 버튼
	@FXML
	public void deleteClick(ActionEvent event) {
		if(table.getSelectionModel().isEmpty()) {
			CommonService.msg("삭제할 데이터를 선택하세요.");
			return;
		}
		
		// DB 데이터 삭제 
		int menuNum = table.getSelectionModel().getSelectedItem().getNum();
		service.delete(menuNum);
		
		// tableView 데이터 삭제
		int idx = table.getSelectionModel().getSelectedIndex();
		data.remove(idx);
		setTableView();
		
		// TextField 내용 삭제
		menu.clear();
		image.clear();
		description.clear();
		price.clear();
		kcal.clear();	
		
		CommonService.msg("메뉴 삭제 완료");		
	}
	
	
	// TableView 클릭 했을 때 TexField 반영
	@FXML
	public void tableClick(MouseEvent event) {
		if(!table.getSelectionModel().isEmpty()) {
			MenuDTO menuDto = table.getSelectionModel().getSelectedItem();
			
			menu.setText(menuDto.getMenu());
			image.setText(menuDto.getImage());
			description.setText(menuDto.getDescription());
			price.setText(menuDto.getPrice());
			kcal.setText(menuDto.getKcal());		

		}
	}
	

	// 데이터 작업 후 tableView 세팅
	private void setTableView() {
		ArrayList<MenuDTO> menus = service.selectAllList();
	    data = FXCollections.observableArrayList(menus);		
	    
	    table.setItems(data);	    
	}
	
	
	// 편집(등록/수정) 준비
	private void editable(Button button) {
		// Button 비활성화
		button.setDisable(true);
		
		// TextField 편집 상태로 변경
		menu.setEditable(true);
		image.setEditable(true);
		description.setEditable(true);
		price.setEditable(true);
		kcal.setEditable(true);
		
		// 메뉴명에 포커스 주기
		menu.requestFocus();
			
		// TableView 비활성화
		table.setDisable(true);
	}
	
	
	// 편집(등록/수정) 종료
	private void editExit(Button button) {
		// Button 활성화
		button.setDisable(false);
		
		// TextField 편집 불가 상태로 변경
		menu.setEditable(false);
		image.setEditable(false);
		description.setEditable(false);
		price.setEditable(false);
		kcal.setEditable(false);
			
		// TextField 내용 삭제
		menu.clear();
		image.clear();
		description.clear();
		price.clear();
		kcal.clear();	
		
		// TableView 활성화
		table.setDisable(false);		
	}
	
	// 이미지 select 버튼, 이미지 경로 저장
	public void handleSaveFileChooser(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp"),
				new ExtensionFilter("All Files", "."));
		File selectedFile = fileChooser.showSaveDialog(imgBtn.getScene().getWindow());
		if(selectedFile != null) {
			image.setText(selectedFile.getPath());
		}
	}
	
	

	
	
}
