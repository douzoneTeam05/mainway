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
    private Label menuName;
    
    @FXML
    private Label menuExplain;

    @FXML
    private Label menuCalory;

    @FXML
    private Label menuPrice;
    
	public void setData(MenuDTO menu) {
		Image image = new Image(getClass().getResourceAsStream(menu.getImg()));
		menuImg.setImage(image);
		menuName.setText(menu.getName());
		menuExplain.setText(menu.getExplain());
		menuCalory.setText(menu.getCalory() + "Kcal");
    	menuPrice.setText(menu.getPrice() + " 원");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}