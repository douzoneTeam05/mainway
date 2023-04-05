package member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.Opener;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainViewController implements Initializable {
	
	private MainViewService service;
	private Parent mainview;
	private Opener opener;
	
	public void Opener (Opener opener) {
		this.opener = opener;
	}

	public void setmainView(Parent mainview) {
//		mainView = mainview;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new MainViewService();
		
	}
	
	// 메뉴 보기 버튼
	@FXML
	public void menuViewProc (Event event) throws IOException {
		Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();                  
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/menuView.fxml"));
        Scene scene = new Scene(root);       
        stage.setScene(scene);
        stage.show();
	}
	
	public void memberProc () {
		
	}

	public void setLogin(Opener opener) {
		this.opener = opener;
		
	}
}
