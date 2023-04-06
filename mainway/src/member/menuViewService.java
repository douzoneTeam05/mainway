package member;

import javafx.collections.ObservableList;
import manager.MenuDAO;
import manager.MenuDTO;

public class menuViewService {
	public ObservableList<MenuDTO> menuViewStage() {
		MenuDAO menudao = new MenuDAO();
		return menudao.menuViewStage();
	}
}
