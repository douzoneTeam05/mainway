package member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.Opener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import order.MenuListController;
//<<<<<<< HEAD
import manager.MenuDTO;

public class menuViewController implements Initializable {
   @FXML private ListView<MenuDTO> listView; 
   @FXML private ImageView imageView;
   ObservableList<MenuDTO> menu = FXCollections.observableArrayList();
	private Opener opener;
   
   private menuViewService service;
   private Parent menuView;
   
   public void setmenuView(Parent menuview) {
      menuView = menuview;
   }
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      service = new menuViewService();
      setListViewTest();
//      listView.getSelectionModel().selectedIndexProperty().addListener((obj, oldv, newv) -> {
//    	  System.out.println("선택값:"+ menu.get((int)newv).getImage());
//    	  Image image = new Image(getClass().getResourceAsStream(menu.get((int)newv).getImage()));
//          imageView.setImage(image);
//      });
      //setListView();
      
      listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
          //avoid exception when nothing is selected as pointed out by @kleopatra
          if (newValue != null) { 
        	  System.out.println(newValue.getImage());
              //set text to your label
//        	  Image image = new Image(getClass().getResourceAsStream());
//              imageView.setImage(image);
          }
      });
      
      
   }
   
   public void setListView() { 
	  
	   MenuDTO menudto = listView.getSelectionModel().getSelectedItem();
	      //왜 menudto가 null 일까???????
      if (menudto != null) {
         Image image = new Image(getClass().getResourceAsStream(menudto.getImage()));
         imageView.setImage(image);
         System.out.println(image);
      } else {
         // menudto 객체가 null인 경우, 기본 이미지를 설정
         Image defaultImage = new Image(getClass().getResourceAsStream("/img/로스트치킨.png"));
         imageView.setImage(defaultImage);
         System.out.println("menudto 객체가 null입니다.");
      }
	   
   }
   
   public void setListViewTest() {
      menu = (ObservableList<MenuDTO>) service.menuViewStage();
      listView.setItems(menu);
    
      // listView 세팅
      listView.setCellFactory(listView -> new ListCell<MenuDTO>() {
          @Override
          protected void updateItem(MenuDTO item, boolean empty) {
              super.updateItem(item, empty);
              
              if (empty || item == null || item.getMenu() == null) {
                  setText(null);
              } else {
                  setText(item.getNum() + ". " + item.getMenu() + ", " + item.getPrice() + "원");
              }
          }
      });

   
}
   
//=======


	
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
	
	// 좋아요 버튼 눌렀을 때 실행할 메서드
	// 좋아요 화면으로 이동 (by.종원)
	@FXML
    void heartProc(ActionEvent event) {
		Stage stage = (Stage)imageView.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/heart/Heart.fxml"));
		Parent heartForm = null;
		try {
			heartForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MenuListController menuListCon = loader.getController();
		// menuListCon.setMemberId(); // 로그인한 사용자 아이디 메뉴선택 화면으로 넘겨주기
		
		Scene scene = new Scene(heartForm);
		stage.setTitle("좋아요");
		stage.setScene(scene);
		stage.show();
    }
}
	
//	
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		service = new menuViewService();
//		setListView();
//	}
	
//	public void setListView() {
//		menuViewDTO menudto = new menuViewDTO();
//		menu = (ObservableList<menuViewDTO>) service.menuViewStage();
//		listView.setItems(menu);
//		
//		listView.setCellFactory(listView -> new ListCell<menuViewDTO>() {
//		    private ImageView imageView = new ImageView();
//>>>>>>> 256f60a5125ee041122ad88452c3d3ef919fd05f

//              if (empty || item == null || item.getMenu() == null) {
//                  setText(null);
//              } else {
//                  setText(item.getNum() + ". " + item.getMenu() + ", " + item.getPrice() + "원");
//              }
//          }
//      });
//
//   
//}