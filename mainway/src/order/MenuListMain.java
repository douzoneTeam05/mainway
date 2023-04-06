package order;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuListMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuListForm.fxml"));
		Parent menuListForm = loader.load();
		
		MenuListController menuCon = loader.getController();
		menuCon.setPrimaryStage(primaryStage);
		
		loader = new FXMLLoader(getClass().getResource("orderListForm.fxml"));
		Parent orderListForm = loader.load();
		
		OrderListController orderListCon = loader.getController();
		orderListCon.setOrderListForm(orderListForm);
		
		Scene scene = new Scene(menuListForm);
		primaryStage.setTitle("메뉴 선택");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
