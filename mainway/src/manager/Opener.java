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
	
	// 관리자 페이지 메뉴 목록
	public void menuOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("managerMenu.fxml"));
		Parent managerMenu = null;
		
		try {
			managerMenu = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Opener opener = new Opener();
		opener.setPrimaryStage(primaryStage);
		
		ManagerController MngCon = loader.getController();
		MngCon.setOpener(opener);

		Scene scene = new Scene(managerMenu);
		primaryStage.setTitle("관리자 메뉴 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	

	// 관리자 페이지 - 메뉴 관리
	public void menuManageOpen() {
	Stage menuStage = new Stage();	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCreate.fxml"));
	Parent menuCreate = null;
	try {
		menuCreate = loader.load();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	MenuController menuCon = loader.getController();
	menuCon.setMenuCreate(menuCreate);
	
	Scene scene = new Scene(menuCreate);
	menuStage.setTitle("메뉴 관리 화면");
	menuStage.setScene(scene);
	menuStage.show();
	}

	
	// 관리자 페이지 - 관리자 계정 관리
	public void managerOpen() {
		Stage menuStage = new Stage();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("managerManage.fxml"));
		Parent managerManage = null;
		try {
			managerManage = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ManagerManageController managerCon = loader.getController();
		managerCon.setManagerManage(managerManage);
		
		Scene scene = new Scene(managerManage);
		menuStage.setTitle("메뉴 관리 화면");
		menuStage.setScene(scene);
		menuStage.show();
		
	}
}
