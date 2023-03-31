package order;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SelectOptionController implements Initializable {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
    private ImageView logoImg;
	
	@FXML
    private ImageView menuImg;

    @FXML
    private Label menuName;

    @FXML
    private Label menuPrice;
	
	@FXML
    private ImageView breadImg;

    @FXML
    private ToggleGroup breadLenGroup;

    @FXML
    private ToggleGroup breadGroup;

    @FXML
    private ImageView cheeseImg;

    @FXML
    private ToggleGroup cheeseGroup;

    @FXML
    private ImageView vegsrcImg;

    @FXML
    private ImageView topingImg;

    @FXML
    private ImageView beverageImg;

    @FXML
    private ToggleGroup beverageGroup;

    @FXML
    private ImageView snackImg;
    
    public void setData(MenuDTO menu) {
    	Image image = new Image(menu.getImg());
    	menuImg.setImage(image);
    	menuName.setText(menu.getName());
    	menuPrice.setText(menu.getPrice() + " 원");
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
		
		MenuListController menuCon = loader.getController();
		menuCon.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(menuListForm);
		stage.setTitle("메뉴 선택");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void orderItemAddProc(ActionEvent event) {
    	/*
    	if(!breadLenGroup.getSelectedToggle().isSelected()) {
    		return;
    	}
    	if(!breadGroup.getSelectedToggle().isSelected()) {
    		return;
    	}
    	if(!cheeseGroup.getSelectedToggle().isSelected()) {
    		return;
    	}
    	*/
    	
    	Stage stage = (Stage)logoImg.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("orderListForm.fxml"));
		Parent orderListForm = null;
		try {
			orderListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		OrderListController orderListCon = loader.getController();
		orderListCon.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(orderListForm);
		stage.setTitle("주문 하기");
		stage.setScene(scene);
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/bread.png"));
		breadImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/cheese.png"));
		cheeseImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/toping.png"));
		topingImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/vegatable&source.png"));
		vegsrcImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/beverage.png"));
		beverageImg.setImage(image);
		image = new Image(getClass().getResourceAsStream("/img/snack.png"));
		snackImg.setImage(image);
	}
	
}