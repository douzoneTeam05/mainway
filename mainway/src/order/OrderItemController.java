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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import order.MenuDTO;

public class OrderItemController implements Initializable {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
    private Label menuCount;

    @FXML
    private CheckBox menuName;

    @FXML
    private ImageView menuImage;

    @FXML
    private Label menuPrice;

    @FXML
    void optionChangeProc(ActionEvent event) {
    	
    }
	
    public void setData(MenuDTO menu, int index) {
    	Image image = new Image(getClass().getResourceAsStream(menu.getImg()));
    	menuImage.setImage(image);
    	menuName.setText(menu.getName());
    	menuPrice.setText(menu.getPrice() + " 원");
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}