package member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.MenuDTO;

public class menuViewController implements Initializable {
   @FXML private ListView<MenuDTO> listView; 
   @FXML private ImageView imageView;
   ObservableList<MenuDTO> menu = FXCollections.observableArrayList();
   
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
   
}