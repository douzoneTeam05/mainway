package member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class mainViewController implements Initializable {
	
	private MainViewService service;
	private Opener opener;
	
	public void Opener(Opener opener) {
		this.opener = opener;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new MainViewService();
		
	}
	
	// 메뉴보기 버튼
	public void menuViewProc () {
		try {
			opener.menuViewopen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void memberProc () {
		
	}

	public void setmainView(Parent mainview) {
		
	}
}
