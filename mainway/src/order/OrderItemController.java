package order;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import order.MenuDTO;

public class OrderItemController implements Initializable {
	private OrderService service;
	private OrderDTO order;
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private Parent orderListForm;
	
	public void setOrderListForm(Parent orderListForm) {
		this.orderListForm = orderListForm;
	}
	
	@FXML
    private Label menuCount; // 메뉴 수량

    @FXML
    private CheckBox menuName; // 메뉴명 체크박스

    @FXML
    private ImageView menuImage; // 메뉴 이미지

    @FXML
    private Label menuPrice; // 메뉴 가격

    @FXML
    private Label topingText; // 선택했던 토핑 정보

    @FXML
    private Label beverageText; // 선택했던 음료 정보

    @FXML
    private Label snackText; // 선택했던 스낵 정보

    @FXML
    private Label breadLenText; // 선택했던 빵 길이 정보

    @FXML
    private Label breadText; // 선택했던 빵 종류 정보

    @FXML
    private Label cheeseText; // 선택했던 치즈 종류 정보

    @FXML
    private Label vegetableText; // 선택했던 야채 정보

    @FXML
    private Label sauceText; // 선택했던 소스 정보
    
    @FXML
    private Label orderIndex; // 각 메뉴의 index 정보
    
    private int price; // 각각의 처음 메뉴 가격을 저장하기 위해 선언
    
    @FXML
    void minusAmountProc(ActionEvent event) {
    	int amount = Integer.parseInt(menuCount.getText());
    	int multiPrice = price;
    	
    	// listView controller의 주문 가격 바꾸기
    	Label label = (Label)orderListForm.lookup("#orderPrice");
    	int orderPrice = Integer.parseInt(label.getText().replace(" 원", ""));

    	// '-' 버튼을 계속 눌러도 최소 1개 이상은 되어야 하기 때문  
    	if(amount <= 1) {
    		amount = 1;
    	} else {
    		amount--;
    		orderPrice -= price;
    		if(menuName.isSelected()) {
    			label.setText(orderPrice + " 원");
    		} 
    	}
    	multiPrice = price * amount;
    	menuCount.setText(String.valueOf(amount));
    	menuPrice.setText(multiPrice + " 원");
    }
    
    @FXML
    void plusAmountProc(ActionEvent event) {
    	int amount = Integer.parseInt(menuCount.getText());
    	int multiPrice = price;
    	
    	// listView controller의 주문 가격 바꾸기
    	Label label = (Label)orderListForm.lookup("#orderPrice");
    	int orderPrice = Integer.parseInt(label.getText().replace(" 원", ""));
    	
    	// 최대 수량 5개가 넘어가면 경고창 띄우고 표시되는 최대 수량 고정
    	if(amount >= 5) {
    		amount = 5;
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("경고");
    		alert.setContentText("최대 5개까지 주문 가능합니다.");
    		alert.show();
    	} else {
    		amount++; // 버튼 누를 때 마다 수량 + 1
    		orderPrice += price;
    		if(menuName.isSelected()) {
    			label.setText(orderPrice + " 원");
    		} 
    	}
    	multiPrice = price * amount;
    	menuCount.setText(String.valueOf(amount));
    	menuPrice.setText(multiPrice + " 원");
    }
    
    @FXML
    void optionChangeProc(ActionEvent event) {
    	Stage stage = (Stage)menuImage.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateselectOptionForm.fxml"));
    	Parent updateSelectForm = null;
    	try {
    		updateSelectForm = loader.load();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	UpdateSelectOptionController UpdateOptionCon = loader.getController();
    	order.setId(Integer.parseInt(orderIndex.getText()));
    	UpdateOptionCon.setOrder(order);
    	
    	Scene scene = new Scene(updateSelectForm);
    	stage.setTitle("옵션 변경");
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void setOrder(OrderDTO order, int index) {
    	this.order = order;
    	orderIndex.setText(String.valueOf(index));
    	this.price = Integer.parseInt(order.getPrice().replace(" 원", ""));
    	
    	Image image = new Image(getClass().getResourceAsStream(order.getImg()));
    	menuImage.setImage(image);
    	menuName.setText(order.getName());
    	menuPrice.setText(order.getPrice());
    	
    	breadLenText.setText(order.getBreadLen());
    	breadText.setText(order.getBread());
    	cheeseText.setText(order.getCheese());
    	vegetableText.setText(order.getVegetable());
    	sauceText.setText(order.getSauce());
    	topingText.setText(order.getToping());
    	beverageText.setText(order.getBeverage());
    	snackText.setText(order.getSnack());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new OrderService();
	}
}