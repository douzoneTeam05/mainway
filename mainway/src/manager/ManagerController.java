package manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class ManagerController implements Initializable{
	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	// 메뉴 관리 버튼
	public void menuManage() {
		opener.menuManageOpen();
	}
	
	
	// 통계 관리 버튼(좋아요 기준으로  인기메뉴 뽑아내기, 상세페이지 뷰 카운트 기능 넣으면 조회수 높은 수 뽑을 수 있음, 주문 카운트 넣을 시 주 높은 순도 뽑을 수 있음)


	
	// 회원 관리 버튼(1. 회원 전체 조회)
	public void memberManage() {
//		opener.memberOpen();
	}
	
	


	
	// 관리자 계정 관리 버튼
	public void managerManage() {
		opener.managerOpen();
	}
	


}
