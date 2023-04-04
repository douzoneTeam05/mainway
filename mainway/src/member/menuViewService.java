package member;

import javafx.collections.ObservableList;

public class menuViewService {
	public ObservableList<menuViewDTO> menuViewStage() {
		menuViewDAO menudao = new menuViewDAO();
		return menudao.menuViewStage();
	}
}
