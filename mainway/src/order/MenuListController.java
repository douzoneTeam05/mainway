package order;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuListController implements Initializable {
private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
    private ImageView logoImg;
	
	@FXML
    private ListView<AnchorPane> listLayout;
	
	@FXML
    void menuAddProc(ActionEvent event) {
		// 리스트 뷰 선택한 것이 있을 때 옵션 선택 화면으로 이동
		if(listLayout.getSelectionModel().getSelectedItem() != null) {
			// 현재 화면의 scene 정보를 가져옴 (Stage 형으로 바꿔주기)
			Stage stage = (Stage)logoImg.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("selectOptionForm.fxml"));
			Parent optionForm = null;
			try {
				optionForm = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			SelectOptionController optionCon = loader.getController();
			optionCon.setPrimaryStage(primaryStage);
			
			// 선택한 메뉴의 index 값을 가져옴
			int index = listLayout.getSelectionModel().getSelectedIndex();
			MenuDTO menu = new MenuDTO();
			// index 값으로 선택 메뉴 정보 가져와서 menu에 저장
			menu.setImg(basicMenus.get(index).getImg());
			menu.setName(basicMenus.get(index).getName());
			menu.setPrice(basicMenus.get(index).getPrice());
			menu.setCalory(basicMenus.get(index).getCalory());
			menu.setExplain(basicMenus.get(index).getExplain());
			optionCon.setData(menu); // 선택한 메뉴 정보를 옵션 선택 화면으로 데이터 넘겨줌
			
			Scene scene = new Scene(optionForm);
			stage.setTitle("옵션 선택");
			stage.setScene(scene);
			stage.show();			
		}
		
    }
	
	private ArrayList<MenuDTO> basicMenus;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		
		basicMenus = new ArrayList<>(basicMenus());
		try {
			for(int i = 0; i < basicMenus.size(); i++) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("menuForm.fxml"));
				AnchorPane menu = loader.load();
				MenuItemController menuListCon = loader.getController();
				menuListCon.setData(basicMenus.get(i), i);
				listLayout.getItems().add(menu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<MenuDTO> basicMenus() {
		ArrayList<MenuDTO> menus = new ArrayList<>();
		MenuDTO menu = new MenuDTO();
		menu.setImg("/img/chicken.png");
		menu.setName("치킨 로스트");
		menu.setCalory(388);
		menu.setPrice(5000);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/shrimp.png");
		menu.setName("쉬림프");
		menu.setCalory(299);
		menu.setPrice(4800);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/tuna.png");
		menu.setName("참치");
		menu.setCalory(350);
		menu.setPrice(4500);
		menus.add(menu);
		
		return menus;
	}
}