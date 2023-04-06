package member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.Opener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import order.MenuListController;

public class menuViewController implements Initializable {
	@FXML private ListView<menuViewDTO> listView;
	ObservableList<menuViewDTO> menu;
	@FXML
    private ImageView imageView;
	
	private menuViewService service;
	private Parent menuView;
	private Opener opener;
	
	public void setmenuView(Parent menuview) {
		menuView = menuview;
	}
	
	// 주문하기 버튼 눌렀을 때 실행할 메서드
	// 주문하기 화면으로 이동 (by.용)
	@FXML
    void orderProc(ActionEvent event) {
		Stage stage = (Stage)imageView.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/order/menuListForm.fxml"));
		Parent menuListForm = null;
		try {
			menuListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MenuListController menuListCon = loader.getController();
		// menuListCon.setMemberId(); // 로그인한 사용자 아이디 메뉴선택 화면으로 넘겨주기
		
		Scene scene = new Scene(menuListForm);
		stage.setTitle("메뉴 선택");
		stage.setScene(scene);
		stage.show();
    }
	
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
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	public void setMain(Opener opener) {
		this.opener = opener;
		
	}
}
