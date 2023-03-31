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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import order.MenuDTO;

public class OrderListController implements Initializable {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private Parent orderListForm;
	
	public void setOrderListForm(Parent orderListForm) {
		this.orderListForm = orderListForm;
	}
	
	@FXML
    private ImageView logoImg;
	
	@FXML
    private VBox listLayout;
	private ArrayList<MenuDTO> basicMenus;
	
	@FXML
    void addProc(ActionEvent event) {
		Stage stage = (Stage)logoImg.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuListForm.fxml"));
    	Parent menuListForm = null;
		try {
			menuListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(menuListForm);
		stage.setTitle("메뉴 추가 선택");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void orderProc(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		
		basicMenus = new ArrayList<>(basicMenus());
		
		try {
			for(int i = 0; i < basicMenus.size(); i++) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("orderForm.fxml"));
				AnchorPane order = loader.load();
				OrderItemController orderListCon = loader.getController();
				orderListCon.setData(basicMenus.get(i), i);
				listLayout.getChildren().add(order);
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
		menu.setPrice(5000);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/shrimp.png");
		menu.setName("쉬림프");
		menu.setPrice(4800);
		menus.add(menu);
		
		menu = new MenuDTO();
		menu.setImg("/img/tuna.png");
		menu.setName("참치");
		menu.setPrice(4500);
		menus.add(menu);
		
		return menus;
	}
}