package manager;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerLoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	
	private ManagerService service;
//	private Opener opener;
//	
//	public void setOpener(Opener opener) {
//		this.opener = opener;
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new ManagerService();
	}
	
	// 로그인 버튼 
	@FXML
	public void loginProc(Event event) throws IOException{	
		service.loginProc(id.getText(), pw.getText());
		
		// 로그인 체크
		String result = service.loginCheck(id.getText());
		
		if(result != null && result.equals("Y")) {			
			Node node = (Node) event.getSource();
	        Stage stage = (Stage) node.getScene().getWindow();                  
	        stage.close();
	        
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/managerMenu.fxml"));
			
	        Scene scene = new Scene(root);       
	        stage.setScene(scene);
	        stage.show();	
	       
		}
	}


}
