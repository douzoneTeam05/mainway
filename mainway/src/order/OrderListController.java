package order;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import order.MenuDTO;

public class OrderListController implements Initializable {
	OrderService service;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private Parent orderListForm;
	
	public void setOrderListForm(Parent orderListForm) {
		this.orderListForm = orderListForm;
	}
	
	@FXML
    private ImageView logoImg;

    @FXML
    private ListView<AnchorPane> listLayout;

    @FXML
    private Label orderPrice;
    
    @FXML
    private CheckBox selectAll;
    
    @FXML
    void seleteAllProc(ActionEvent event) {
    	if(selectAll.isSelected()) { // 전체 선택  
    		listLayout.getItems().forEach(item -> {
    			CheckBox checkBox = (CheckBox)item.lookup("#menuName");
    			Label label = (Label)item.lookup("#menuPrice");
    			int menuPrice = Integer.parseInt(label.getText().replace(" 원", ""));
    			totalPrice = Integer.parseInt(orderPrice.getText().replace(" 원", "")); // 전체선택 누르기 전의 totalPrice 값 가져오기
    			// 선택 되어 있지 않은 것들만 선택 후 메뉴 가격 더해주기
    			if(!checkBox.isSelected()) {
    				checkBox.setSelected(true);
    				totalPrice += menuPrice;
    			}
    			orderPrice.setText(totalPrice + " 원");
    		});
    	} else { // 전체 선택 해제
    		listLayout.getItems().forEach(item -> {
    			CheckBox checkBox = (CheckBox)item.lookup("#menuName");
    			Label label = (Label)item.lookup("#menuPrice");
    			int menuPrice = Integer.parseInt(label.getText().replace(" 원", ""));
    			Integer.parseInt(orderPrice.getText().replace(" 원", "")); // 전체선택 누르기 전의 totalPrice 값 가져오기
    			// 선택되어 있는 것들 선택 해제 후 메뉴 가격 빼주기
    			if(checkBox.isSelected()) {
    				checkBox.setSelected(false);
    				totalPrice -= menuPrice;
    			}
    			orderPrice.setText(totalPrice + " 원");
    		});
    	}
    }

    @FXML
    void seletedDeleteProc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.WARNING, "선택한 메뉴를 삭제 하겠습니까?" , ButtonType.YES, ButtonType.NO);
    	alert.setTitle("주문 메뉴 삭제");
    	// 사용자가 누른 버튼의 buttonType을 result에 저장
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.isPresent()) {
    	    ButtonType buttonType = result.get();
    	    if (buttonType == ButtonType.YES) {
    	        // "예" 버튼을 눌렀을 때 처리할 로직
    	    	// check 되어 있는 요소만 DB에서 제거
    	    	listLayout.getItems().forEach(item -> {
    	    		CheckBox checkBox = (CheckBox)item.lookup("#menuName");
    	    		Label indexLabel = (Label)item.lookup("#orderIndex");
    	    		Label priceLabel = (Label)item.lookup("#menuPrice");
    	    		int menuPrice = Integer.parseInt(priceLabel.getText().replace(" 원", ""));
    	    		if(checkBox.isSelected()) {
    	    			totalPrice -= menuPrice;
    	    			service.deleteOrder(indexLabel.getText());
    	    		}
    	    	});
    	    	// check 되어 있는 요소만 listView에서 제거
    	    	Iterator<AnchorPane> itr = listLayout.getItems().iterator();
    	    	while(itr.hasNext()) {
    	    		CheckBox checkBox = (CheckBox)itr.next().lookup("#menuName");
    	    		if(checkBox.isSelected()) {
    	    			itr.remove();
    	    		}
    	    	}
    	    	orderPrice.setText(totalPrice + " 원");
    	    	
    	    	Alert successAlert = new Alert(AlertType.INFORMATION);
    	    	successAlert.setTitle("주문 메뉴 삭제");
    	    	successAlert.setContentText("선택 항목이 삭제 되었습니다.");
    	    	successAlert.show();
    	    }
    	}
    }
    
    @FXML
    void menuAddProc(ActionEvent event) {
    	Stage stage = (Stage)logoImg.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuListForm.fxml"));
    	Parent menuListForm = null;
		try {
			menuListForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(menuListForm);
		stage.setTitle("메뉴 추가 선택");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void orderProc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION, "이대로 주문 하시겠습니까?", ButtonType.YES, ButtonType.NO);
    	alert.setTitle("주문 하기");
    	// 사용자가 누른 버튼의 buttonType을 result에 저장
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.isPresent()) {
    	    ButtonType buttonType = result.get();
    	    if (buttonType == ButtonType.YES) {
    	        // "예" 버튼을 눌렀을 때 처리할 로직
    	    	Alert successAlert = new Alert(AlertType.INFORMATION);
    	    	successAlert.setTitle("주문 하기");
    	    	successAlert.setContentText("주문이 완료 되었습니다.");
    	    	successAlert.show();
    	    }
    	}
    }
    
    private ArrayList<OrderDTO> orders;
    private OrderDTO order;
    private int totalPrice;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new OrderService();
		
		// 리스트 다중 선택 가능하도록 설정
		listLayout.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		Image image = new Image(getClass().getResourceAsStream("/img/mainwaylogo.png"));
		logoImg.setImage(image);
		
		Parent parent = listLayout.getParent().getParent(); // 현재 창의 root 정보 가져오기
		
		String member_id = "admin"; // 회원 아이디 정보
		orders = new ArrayList<>(service.selectOrders(member_id));

		for(int i = 0; i < orders.size(); i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("orderForm.fxml"));
			AnchorPane orderItem = null;
			try {
				orderItem = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			OrderItemController orderItemCon = loader.getController();
			orderItemCon.setOrder(orders.get(i), orders.get(i).getId()); // 오른쪽 파라미터는 order의 PK 값
			orderItemCon.setOrderListForm(parent);
			listLayout.getItems().add(orderItem);
		}
		
    	// 처음에 listLayout 모든 항목들의 checkBox가 체크 되어있게 설정
    	listLayout.getItems().forEach(item -> {
			CheckBox checkBox = (CheckBox)item.lookup("#menuName");
			checkBox.setSelected(true);
			Label label = (Label)item.lookup("#menuPrice");
			int menuPrice = Integer.parseInt(label.getText().replace(" 원", ""));
			Integer.parseInt(orderPrice.getText().replace(" 원", "")); // 전체선택 누르기 전의 totalPrice 값 가져오기
    		totalPrice += menuPrice;
			orderPrice.setText(totalPrice + " 원");
		});
    	
    	// orderItem 클릭 했을 때 번갈아 가며 선택과 선택 취소 될 수 있도록 (listView는 ctrl과 같이 클릭해야 다중선택 됨..)
    	// orderItem 클릭 했을 때 orderItem 안에 있는 checkBox 체크 또는 체크 해제
    	// checkBox가 체크 되어 있으면 선택 된 해당 메뉴 가격만큼 더하고
    	// checkBox가 체크 해제 되어 있으면 해당 메뉴 가격만큼 뺀다.
    	listLayout.setOnMouseClicked(event -> {
    		MultipleSelectionModel<AnchorPane> selectionModel = listLayout.getSelectionModel();
    		CheckBox checkBox = (CheckBox)selectionModel.getSelectedItem().lookup("#menuName");
    		checkBox.setSelected(!checkBox.isSelected());

    		int isSelectCnt = 0;
    	    ObservableList<AnchorPane> orderList = listLayout.getItems();
    	    for(AnchorPane orderItem : orderList) {
    	    	CheckBox box = (CheckBox)orderItem.lookup("#menuName");
    	    	if(box.isSelected()) {
    	    		isSelectCnt++;
    	    	}
    	    }
    	    // 선택 된 listItem 개수가 listLayout 항목 개수와 같다면 전체선택 체크
    	    if(isSelectCnt == orderList.size()) {
    	    	selectAll.setSelected(true);
    	    } else {
    	    	selectAll.setSelected(false);
    	    }
    	    
    	    Label label = (Label)selectionModel.getSelectedItem().lookup("#menuPrice");
    	    int menuPrice = Integer.parseInt(label.getText().replace(" 원", ""));
	        if(checkBox.isSelected()) {
	        	totalPrice += menuPrice;
	        } else {
	        	// totalPrice 전의 정보로 초기화 후 menuPrice 만큼 빼기
	        	totalPrice = Integer.parseInt(orderPrice.getText().replace(" 원", ""));
	        	totalPrice -= menuPrice;
	        }
	        orderPrice.setText(totalPrice + " 원");
	        
	        // check 되어 있으면 선택 되어 있게, 아니면 선택 해제 되어 있게 설정
	        int index = selectionModel.getSelectedIndex();
	        if(!selectionModel.isSelected(index)) {
	        	selectionModel.select(index);
	        } else {
	        	selectionModel.clearSelection(index);
	        }
    	});
	}
	
}