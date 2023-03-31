package manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("managerLogin.fxml"));
		Parent managerLogin = loader.load();
		
		Opener opener = new Opener();
		opener.setPrimaryStage(primaryStage);
		
		ManagerController loginCon = loader.getController();
		loginCon.setOpener(opener);
		Scene scene = new Scene(managerLogin);
		primaryStage.setTitle("관리자 로그인 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
