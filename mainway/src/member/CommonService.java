package member;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {
	
	
	public static void msg (String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");
		alert.setContentText(contentText);
		alert.show();
	}
	
	public static void windowClose (Parent form) {
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
	}
}
