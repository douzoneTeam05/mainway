package heart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//Application 기본으로 생성된 Application(기본으로 내재된 class) class를 상속한다 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Heart.fxml"));
		//heart.fxml 파일의 FXML파일을 가져오는 공식이다
		Parent regForm = loader.load();
		Service sc = new Service();
		//sc라는 객체를 Main클래스에 만든다. Service 클래스에 함수를 사용가능하다
		//상속으로도 다른 클래스의 함수를 사용가능하다. 하지만 다중상속이 안되기 때문에 객체로 클래스를 불러온다
		
		Scene scene = new Scene(regForm);
		primaryStage.setTitle("좋아요");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	//launch 함수를 사용해서 main 클래스를 실행한다
	}
}