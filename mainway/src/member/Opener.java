package member;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primayrStage) {
		this.primaryStage = primayrStage;
	}
	
	//회원 가입 화면
	public void regopen () {
		Stage regStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("regForm1.fxml"));
		Parent regForm = null;
		try {
			regForm = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RegController regCon = loader.getController();
		regCon.setRegForm(regForm);
		
		Scene scene = new Scene(regForm);
		regStage.setTitle("회원가입 화면");
		regStage.setScene(scene);
		regStage.show();
		
		
	}
	
//	//메뉴 화면 실행
//	public void menu() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
//		Parent menuForm = null;
//		
//		try {
//			menuForm = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		Scene scene = new Scene(menuForm);
//		primaryStage.setTitle("메뉴");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
}
