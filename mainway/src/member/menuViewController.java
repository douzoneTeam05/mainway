package member;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class menuViewController implements Initializable {
	String[] items;
	@FXML private ListView<menuViewDTO> listView;
	@FXML private ImageView imageView;
	ObservableList<menuViewDTO> menu;
	
	private menuViewService service;
	private Parent menuView;
	
	public void setmenuView(Parent menuview) {
		menuView = menuview;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new menuViewService();
		setListViewTest();
	}
	
	public void setListView() throws FileNotFoundException { // 클릭이벤트
		
		menuViewDTO menudto = new menuViewDTO();
		
		menudto = listView.getSelectionModel().getSelectedItem();
		System.out.println(menudto.getImage());
		
		// "/img/쉬림프.png"
		Image image = new Image(getClass().getResourceAsStream(menudto.getImage()));
		imageView.setImage(image);
		
	}
	
	public void setListViewTest() {
		menu = (ObservableList<menuViewDTO>) service.menuViewStage();
		listView.setItems(menu);
		listView.setCellFactory(listView -> new ListCell<menuViewDTO>() {
		    private ImageView imageView = new ImageView();

		    @Override
		    protected void updateItem(menuViewDTO item, boolean empty) {
		        super.updateItem(item, empty);

		        if (empty || item == null || item.getName() == null) {
		            setText(null);
		        } else {
		            setText(item.getMenu_num() + ". " + item.getName() + ", " +
		            			item.getPrice() + "원");
		        }
		    }
		});
	}
	
}
