package manager;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// FXMLLoader 객체 생성, 로딩할 파일 managerLogin.fxml 지정(FXMLLoader 클래스의 정적 메소드 load()를 사용하여 로딩, 로딩 시 컨트롤러와 함께 생성)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("managerLogin.fxml"));  
		// 인스턴스 메소드 load() 호출하여 객체화 시킴 // Parent managerLogin = (Parent)FXMLLoader.load(getClass().getResource("root.fxml")); <- getController()를 호출하기 위해서 필요
		Parent managerLogin = loader.load();
		
		Opener opener = new Opener();
		opener.setPrimaryStage(primaryStage);
		
		ManagerLoginController loginCon = loader.getController();
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
