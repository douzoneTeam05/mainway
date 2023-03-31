package order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuItemController implements Initializable {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
	private ImageView logoImg;
	
	@FXML
    private ImageView menuImg;

    @FXML
    private Label MenuName;

    @FXML
    private Label menuCalory;

    @FXML
    private Label menuPrice;
    
	public void setData(MenuDTO menu, int index) {
		Image image = new Image(getClass().getResourceAsStream(menu.getImg()));
		menuImg.setImage(image);
		MenuName.setText(menu.getName());
		menuCalory.setText(menu.getCalory() + "Kcal");
    	menuPrice.setText(menu.getPrice() + " 원");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}