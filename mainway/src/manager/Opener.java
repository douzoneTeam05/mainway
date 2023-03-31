package manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	// 관리자 메뉴
	public void menuOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("managerMenu.fxml"));
		Parent managerMenu = null;
		
		try {
			managerMenu = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(managerMenu);
		primaryStage.setTitle("관리자 메뉴 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
