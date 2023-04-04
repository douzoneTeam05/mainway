package member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menuMain extends Application {
	//로그인 화면 
	@Override
	public void start(Stage primaryStage) throws Exception {
		Opener opener = new Opener(); // 회원가입 화면을 불러오기 위한 객체 생성
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuView.fxml")); //loader의 객체 생성, loginForm을 얻어온다
		Parent menuForm = loader.load(); //loginForm2 객체 생성

		opener.setPrimaryStage(primaryStage);//opener룰 loginCon에 ?
		Scene scene = new Scene(menuForm); //scenebuilder 출력

		primaryStage.setTitle("메뉴 화면"); //화면 이름
		primaryStage.setScene(scene); //scenebuilder 출력
		primaryStage.show(); //scenebuilder 출력

	}
	
	public static void main(String[] args) {
		launch(args); //scenebuilder 실행
	}
}
