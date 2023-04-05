package manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerController implements Initializable{	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	// 관리자메뉴 - 메뉴 관리 버튼
	public void menuManage() {
		Stage menuStage = new Stage();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuCreate.fxml"));
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
	
	
	// 통계 관리 버튼(좋아요 기준으로  인기메뉴 뽑아내기, 상세페이지 뷰 카운트 기능 넣으면 조회수 높은 수 뽑을 수 있음, 주문 카운트 넣을 시 주 높은 순도 뽑을 수 있음)
	public void statisticsManage() { 
		Stage menuStage = new Stage();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticsManage.fxml"));
		Parent statisticsManage = null;
		try {
			statisticsManage = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StatisticsManageController managerCon = loader.getController();
		managerCon.setMemberManage(statisticsManage);
		
		Scene scene = new Scene(statisticsManage);
		menuStage.setTitle("통계 관리 화면");
		menuStage.setScene(scene);
		menuStage.show();
	}
	

	
	// 관리자 메뉴 - 회원 관리 버튼(회원 전체 조회 기능)
	public void memberManage() {
		Stage menuStage = new Stage();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/memberManage.fxml"));
		Parent memberManage = null;
		try {
			memberManage = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MemberManageController managerCon = loader.getController();
		managerCon.setMemberManage(memberManage);
		
		Scene scene = new Scene(memberManage);
		menuStage.setTitle("회원 관리 화면");
		menuStage.setScene(scene);
		menuStage.show();
	}

	
	// 관리자 메뉴 - 관리자 계정 관리 버튼
	public void managerManage() {		
		Stage menuStage = new Stage();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/managerManage.fxml"));
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
