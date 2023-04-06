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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
	
	private String memberId;
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@FXML
    private ImageView logoImg;
	
	@FXML
    private ListView<AnchorPane> listLayout;
	
	@FXML
    void goPreviousProc(ActionEvent event) {
		Stage stage = (Stage)logoImg.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuView.fxml"));
		Parent menuViewForm = null;
		try {
			menuViewForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(menuViewForm);
		stage.setTitle("");
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void menuAddProc(ActionEvent event) {
		// 리스트 뷰 선택한 것이 있을 때 옵션 선택 화면으로 이동
		if(listLayout.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("메뉴 선택");
			alert.setContentText("메뉴를 선택 하세요.");
			return;
		}
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
		optionCon.setPrimaryStage(stage);
		
		// 선택한 메뉴의 index 값을 가져옴
		int index = listLayout.getSelectionModel().getSelectedIndex();
		OrderDTO order = new OrderDTO();
		// index 값으로 선택 메뉴 정보 가져와서 menu에 저장
		order.setMember_id("admin"); // 로그인한 회원 아이디 (가져와야 하는데 어떻게 가져오지..)
		order.setImg(basicMenus.get(index).getImg());
		order.setName(basicMenus.get(index).getName());
		order.setExplain(basicMenus.get(index).getExplain());
		order.setPrice(basicMenus.get(index).getPrice() + " 원");
		order.setCalory(basicMenus.get(index).getCalory() + " Kcal");
		optionCon.setOrder(order); // 선택한 메뉴 정보를 옵션 선택 화면으로 데이터 넘겨줌
		
		Scene scene = new Scene(optionForm);
		stage.setTitle("옵션 선택");
		stage.setScene(scene);
		stage.show();
    }
	
	private ArrayList<MenuDTO> basicMenus;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		
		basicMenus = new ArrayList<>(basicMenus());
		try {
			for(int i = 0; i < basicMenus.size(); i++) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("menuForm.fxml"));
				AnchorPane menu = loader.load();
				MenuItemController menuListCon = loader.getController();
				menuListCon.setData(basicMenus.get(i));
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
		menu.setExplain("오븐에 구워 담백한\n"
				+ "저칼로리 닭가슴살의 건강한 풍미");
		menu.setCalory(388);
		menu.setPrice(5000);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/shrimp.png");
		menu.setName("쉬림프");
		menu.setExplain("탱글한 식감이 그대로 살아있는 통새우가\n"
				+ "5마리 들어가 한 입 베어 먹을 때 마다\n 진짜 새우의 풍미가 가득");
		menu.setCalory(299);
		menu.setPrice(4800);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/tuna.png");
		menu.setName("참치");
		menu.setExplain("남녀노소 누구나 좋아하는 담백한 참치와\n"
				+ " 고소한 마요네즈의 완벽한 조화");
		menu.setCalory(350);
		menu.setPrice(4500);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/egg-mayo.png");
		menu.setName("에그마요");
		menu.setExplain("부드러운 달걀과 고소한 마요네즈가 만나\n"
				+ "더 부드러운 스테디 셀러");
		menu.setCalory(416);
		menu.setPrice(4100);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/steak-cheese.png");
		menu.setName("스테이크 & 치즈");
		menu.setExplain("육즙이 풍부한 비프 스테이크의\n"
				+ "풍미가 입안 한가득");
		menu.setCalory(355);
		menu.setPrice(5300);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/Italian-BMT.png");
		menu.setName("이탈리안 비엠티");
		menu.setExplain("페퍼로니, 살라미 그리고 햄이\n"
				+ "만들어 내는 최상의 조화! ");
		menu.setCalory(388);
		menu.setPrice(4800);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/K-barbecue.png");
		menu.setName("K-바베큐");
		menu.setExplain("메인웨이의 코리안 스타일 샌드위치!\n"
				+ "마늘, 간장 그리고 은은한 불맛까지!");
		menu.setCalory(372);
		menu.setPrice(4300);
		menus.add(menu);
		
		return menus;
	}
}