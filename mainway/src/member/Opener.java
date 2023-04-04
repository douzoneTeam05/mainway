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
	
	// 아이디 찾기 화면
	public void idSearchOpen() {
		Stage IdSearchStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("idSearch.fxml"));
		Parent idsearch = null;
		try {
			idsearch = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IdSearchController searchCon = loader.getController();
		searchCon.setidSearch(idsearch);
		
		Scene scene = new Scene(idsearch);
		IdSearchStage.setTitle("아이디 찾기 화면");
		IdSearchStage.setScene(scene);
		IdSearchStage.show();
	}
	
	// 비밀번호 찾기 화면
	public void pwSearchopen() {
		Stage pwSearchStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("pwSearch.fxml"));
		Parent pwsearch = null;
		try {
			pwsearch = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PwSearchController searchCon = loader.getController();
		searchCon.setpwSearch(pwsearch);
		
		Scene scene = new Scene(pwsearch);
		pwSearchStage.setTitle("비밀번호 찾기 화면");
		pwSearchStage.setScene(scene);
		pwSearchStage.show();
	}
	
	//메인 화면 실행
	public void mainViewopen() {
		Stage mainViewStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainView.fxml"));
		Parent mainview = null;
		
		try {
			mainview = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainViewController MainViewCon = new mainViewController();
		MainViewCon.setmainView(mainview);
		
		Scene scene = new Scene(mainview);
		mainViewStage.setTitle("메인 화면");
		mainViewStage.setScene(scene);
		mainViewStage.show();
	}
	
	//메뉴보기 화면
	public void menuViewopen() {
		Stage menuViewStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuView.fxml"));
		Parent menuview = null;
		
		try {
			menuview = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		menuViewController menuViewCon = loader.getController();
		menuViewCon.setmenuView(menuview);
		
		Scene scene = new Scene(menuview);
		menuViewStage.setTitle("Menu List");
		menuViewStage.setScene(scene);
		menuViewStage.show();
		
//		Stage pwSearchStage = new Stage();
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("pwSearch.fxml"));
//		Parent pwsearch = null;
//		try {
//			pwsearch = loader.load();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		PwSearchController searchCon = loader.getController();
//		searchCon.setpwSearch(pwsearch);
//		
//		Scene scene = new Scene(pwsearch);
//		pwSearchStage.setTitle("비밀번호 찾기 화면");
//		pwSearchStage.setScene(scene);
//		pwSearchStage.show();
	}
	
//	//회원 정보 관리 화면 실행
//	public void memberProcopen () {
//		
//	}
}
