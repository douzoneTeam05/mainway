package member;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class menuViewController implements Initializable {
	@FXML private ListView<menuViewDTO> listView;
	ObservableList<menuViewDTO> menu;
	
	private menuViewService service;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new menuViewService();
		setListView();
	}
	
	public void setListView() {
		menuViewDTO menudto = new menuViewDTO();
		menu = (ObservableList<menuViewDTO>) service.menuViewStage();
		listView.setItems(menu);
		
		listView.setCellFactory(listView -> new ListCell<menuViewDTO>() {
		    private ImageView imageView = new ImageView();

		    @Override
		    protected void updateItem(menuViewDTO item, boolean empty) {
		        super.updateItem(item, empty);

		        if (empty || item == null || item.getName() == null) {
		            setText(null);
		            setGraphic(null);
		        } else {
		            setText(item.getMenu_num() + ". " + item.getName() + ", " + item.getExplain()
		            		+ ", " + item.getPrice() + ", " + item.getCalory());
//		            imageView.setImage(image);
//		            setGraphic(imageView);
		        }
		    }
		});
	}
}
