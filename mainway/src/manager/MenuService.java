package manager;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class MenuService {
	private MenuDAO menuDao;
	
	public MenuService() {
		menuDao = new MenuDAO();
	}

	public static MenuService getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	// 메뉴 등록
	public void regPrco(MenuDTO menuDto) {		
		// 메뉴명 중복 검증 
		
		// 메뉴 등록 로직
		menuDao.regProc(menuDto);		
	}

	// 메뉴 전체 조회
	public ArrayList<MenuDTO> selectAllList() {
		ArrayList<MenuDTO> menus = menuDao.selectAllList();
		if(menus.isEmpty() == false) {
			for(MenuDTO menu : menus) {
				System.out.print(menu.getMenu());
				System.out.println("데이터 조회 test");
			}
		}
		
		return menuDao.selectAllList();
	}
	

	// 메뉴 수정
	public void update(int menuNum, MenuDTO menuDto) {
		menuDto.setNum(menuNum);
		menuDao.update(menuDto);
	}
	
	
	// 메뉴 삭제
	public int delete(int menuNum) {
		int result = menuDao.delete(menuNum);
		if(result == 1) {
			System.out.println("메뉴가 삭제되었습니다.");
		} else {
			System.out.println("메뉴 삭제 에러. DB를 확인해주세요.");
		}
		
		return result;
	}



	public ObservableList<MenuDTO> selectMenu(String text) {		
		return menuDao.selectMenu(text);
	}

}
