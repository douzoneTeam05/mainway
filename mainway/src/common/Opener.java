package common;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.ManagerController;
import manager.ManagerLoginController;
import manager.ManagerManageController;
import manager.MenuController;
import member.IdSearchController;
import member.PwSearchController;
import member.RegController;

public class Opener {
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primayrStage) {
		this.primaryStage = primayrStage;
	}

// 회원 
	
	//회원 가입 화면
	public void regopen () {
		Stage regStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegForm1.fxml"));
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/idSearch.fxml"));
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pwSearch.fxml"));
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
	public void mainViewOpen(Event event) throws IOException {			
		Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();                  
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainView.fxml"));
        Scene scene = new Scene(root);       
        stage.setScene(scene);
        stage.show();	
	}
	
	
	//메뉴보기 화면
	public void menuViewopen(Event event) throws IOException {		
		Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();                  
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/menuView.fxml"));
        Scene scene = new Scene(root);       
        stage.setScene(scene);
        stage.show();	
		
	}
	
//	//회원 정보 관리 화면 실행
//	public void memberProcopen () {
//		
//	}
	
	
	
	
	
// 관리자
	
	// 관리자 로그인 화면
	public void manageMode(Event event) throws IOException {
		Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();                  
        stage.close();
        
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/managerLogin.fxml"));
		
        Scene scene = new Scene(root);       
        stage.setScene(scene);
        stage.show();			
	}
	

	
	
}
