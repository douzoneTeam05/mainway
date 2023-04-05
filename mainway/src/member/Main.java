package member;

import common.Opener;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	//로그인 화면 
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginForm2.fxml")); //loader의 객체 생성, loginForm을 얻어온다
		Parent root = loader.load(); //loginForm2 객체 생성
		
		Opener opener = new Opener(); // 회원가입 화면을 불러오기 위한 객체 생성
		opener.setPrimaryStage(primaryStage); // 회원가입 화면을 primaryStage를 통해 불러온다.
		
		LoginController loginCon = loader.getController(); // LoginController 객체 생성
		loginCon.Opener(opener); //opener를 loginCon에 ?
		
		Scene scene = new Scene(root); //scenebuilder 출력
		primaryStage.setTitle("MainWay"); //화면 이름
		primaryStage.setScene(scene); //scenebuilder 출력
		primaryStage.show(); //scenebuilder 출력		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}

