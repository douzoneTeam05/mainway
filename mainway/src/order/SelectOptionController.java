package order;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectOptionController implements Initializable {
	OrderService service = new OrderService();
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
    private ImageView menuImg;

    @FXML
    private Label menuName;

    @FXML
    private Label menuPrice;

    @FXML
    private ImageView breadImg;

    @FXML
    private ToggleGroup breadLenGroup; // 빵 길이 선택 그룹

    @FXML
    private ToggleGroup breadGroup; // 빵 종류 선택 그룹

    @FXML
    private ImageView cheeseImg;

    @FXML
    private ToggleGroup cheeseGroup; // 치즈 종류 선택 그룹

    @FXML
    private ImageView vegsauceImg;

    @FXML
    private CheckBox vegetable1; // 양상추

    @FXML
    private CheckBox vegetable2; // 양파

    @FXML
    private CheckBox vegetable3; // 피망

    @FXML
    private CheckBox vegetable4; // 토마토

    @FXML
    private CheckBox vegetable5; // 오이

    @FXML
    private CheckBox vegetable6; // 피클

    @FXML
    private CheckBox vegetable7; // 할라피뇨

    @FXML
    private CheckBox sauce1; // 렌치

    @FXML
    private CheckBox sauce2; // 스위트 칠리

    @FXML
    private CheckBox sauce3; // 마요네즈

    @FXML
    private CheckBox sauce4; // 허니 머스타드

    @FXML
    private CheckBox sauce5; // 바베큐

    @FXML
    private ImageView topingImg;

    @FXML
    private CheckBox toping1; // 미트 추가

    @FXML
    private CheckBox toping2; // 에그마요

    @FXML
    private CheckBox toping3; // 베이컨

    @FXML
    private CheckBox toping4; // 치즈 추가

    @FXML
    private CheckBox toping5; // 아보카도

    @FXML
    private ImageView beverageImg;

    @FXML
    private ToggleGroup beverageGroup; // 음료 선택 그룹

    @FXML
    private ImageView snackImg;

    @FXML
    private ToggleGroup snackGroup; // 스낵 선택 그룹

    @FXML
    private ImageView logoImg;
    
	private OrderDTO order;
    
    public void setOrder(OrderDTO order) {
    	this.order = order;
    	Image image = new Image(order.getImg());
    	menuImg.setImage(image);
    	menuName.setText(order.getName());
    	menuPrice.setText(order.getPrice());
	}
    
    // 선택한 정보를 orderList로 전달하기 위한 메소드
    public OrderDTO getOrder() {
    	OrderDTO orderItem = new OrderDTO();
    	orderItem.setMember_id(order.getMember_id());
    	orderItem.setName(order.getName());
    	orderItem.setImg(order.getImg());
    	orderItem.setExplain(order.getExplain());
    	orderItem.setPrice(order.getPrice());
    	orderItem.setCalory(order.getCalory());
    	String vegetable = "", sauce = "", toping = "";
    	
    	RadioButton selectedBreadLen = (RadioButton)breadLenGroup.getSelectedToggle();
    	orderItem.setBreadLen(selectedBreadLen.getText());
    	RadioButton selectedBread = (RadioButton)breadGroup.getSelectedToggle();
    	orderItem.setBread(selectedBread.getText());
    	RadioButton selectedCheese = (RadioButton)cheeseGroup.getSelectedToggle();
    	orderItem.setCheese(selectedCheese.getText());
    	if(!vegetable1.isSelected()) {
    		vegetable += "-" + vegetable1.getText() + ", ";
    	}
    	if(!vegetable2.isSelected()) {
    		vegetable += "-" + vegetable2.getText() + ", ";
    	}
    	if(!vegetable3.isSelected()) {
    		vegetable += "-" + vegetable3.getText() + ", ";
    	}
    	if(!vegetable4.isSelected()) {
    		vegetable += "-" + vegetable4.getText() + ", ";
    	}
    	if(!vegetable5.isSelected()) {
    		vegetable += "-" + vegetable5.getText() + ", ";
    	}
    	if(vegetable6.isSelected()) {
    		vegetable += "+" + vegetable6.getText() + ", ";
    	}
    	if(vegetable7.isSelected()) {
    		vegetable += "+" + vegetable7.getText() + ", ";
    	}
    	if(vegetable1.isSelected() && vegetable2.isSelected() && vegetable3.isSelected() 
    			&&vegetable4.isSelected() && vegetable5.isSelected() && !vegetable6.isSelected()
    				&&!vegetable7.isSelected()) {
    		vegetable = "기본 야채";
    	}
    	if(vegetable != "기본 야채") {
    		vegetable = vegetable.substring(0, vegetable.length() - 2);    		
    	}
    	orderItem.setVegetable(vegetable);
    	
    	if(sauce1.isSelected()) {
    		sauce += "+" + sauce1.getText() + ", ";
    		
    	}
    	if(sauce2.isSelected()) {
    		sauce += "+" + sauce2.getText() + ", ";
    	}
    	if(sauce3.isSelected()) {
    		sauce += "+" + sauce3.getText() + ", ";
    	}
    	if(sauce4.isSelected()) {
    		sauce += "+" + sauce4.getText() + ", ";
    	}
    	if(sauce5.isSelected()) {
    		sauce += "+" + sauce5.getText() + ", ";
    	}
    	if(!sauce1.isSelected() && !sauce2.isSelected() && !sauce3.isSelected() 
    			&&!sauce4.isSelected() && !sauce5.isSelected()) {
    		sauce = "선택 안함";
    	}
    	if(sauce != "선택 안함") {
    		sauce = sauce.substring(0, sauce.length() - 2);    		
    	}
    	orderItem.setSauce(sauce);
    	
    	if(toping1.isSelected()) {
    		toping += "+" + toping1.getText() + ", ";
    	}
    	if(toping2.isSelected()) {
    		toping += "+" + toping2.getText() + ", ";
    	}
    	if(toping3.isSelected()) {
    		toping += "+" + toping3.getText() + ", ";
    	}
    	if(toping4.isSelected()) {
    		toping += "+" + toping4.getText() + ", ";
    	}
    	if(toping5.isSelected()) {
    		toping += "+" + toping5.getText() + ", ";
    	}
    	if(!toping1.isSelected() && !toping2.isSelected() && !toping3.isSelected() 
    			&&!toping4.isSelected() && !toping5.isSelected()) {
    		toping = "선택 안함";
    	}
    	if(toping != "선택 안함") {
    		toping = toping.substring(0, toping.length() - 2);    		
    	}
    	orderItem.setToping(toping);
    	
    	RadioButton selectedBeverage = (RadioButton)beverageGroup.getSelectedToggle();
    	if(selectedBeverage == null) {
    		orderItem.setBeverage("선택 안함");
    	} else {
    		orderItem.setBeverage(selectedBeverage.getText());    		
    	}
    	RadioButton selectedSnack = (RadioButton)snackGroup.getSelectedToggle();
    	if(selectedSnack == null) {
    		orderItem.setSnack("선택 안함");
    	} else {
    		orderItem.setSnack(selectedSnack.getText());    		
    	}
    	return orderItem;
    }
    
    @FXML
    void cancelProc(ActionEvent event) {
    	Stage stage = (Stage)logoImg.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("menuListForm.fxml"));
		Parent menuListForm = null;
		try {
			menuListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(menuListForm);
		stage.setTitle("메뉴 선택");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void orderItemAddProc(ActionEvent event) {
    	if(breadLenGroup.getSelectedToggle() == null) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("경고");
    		alert.setContentText("빵 길이를 선택하세요.");
    		alert.show();
    		return;
    	}
    	if(breadGroup.getSelectedToggle() == null) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("경고");
    		alert.setContentText("빵 종류를 선택하세요.");
    		alert.show();
    		return;
    	}
    	if(cheeseGroup.getSelectedToggle() == null) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("경고");
    		alert.setContentText("치즈 종류를 선택하세요.");
    		alert.show();
    		return;
    	}
    	service.insertOrder(getOrder());
    	
    	Stage stage = (Stage)logoImg.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("orderListForm.fxml"));
    	Parent orderListForm = null;
		try {
			orderListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		Scene scene = new Scene(orderListForm);
		stage.setTitle("주문 하기");
		stage.setScene(scene);
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 각 이미지들 세팅
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/bread.png"));
		breadImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/cheese.png"));
		cheeseImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/toping.png"));
		topingImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/vegatable&source.png"));
		vegsauceImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/beverage.png"));
		beverageImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/snack.png"));
		snackImg.setImage(image);
	}
	
}