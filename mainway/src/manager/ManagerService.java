package manager;

import java.util.ArrayList;

import common.CommonService;

public class ManagerService {	
	private ManagerDAO dao;
	
	public ManagerService() {
		dao = new ManagerDAO();
	}
	
	public void loginProc(String id, String pw) {
		if(id.isEmpty() || pw.isEmpty()) {
			CommonService.msg("아이디 또는 비밀번호를 입력하세요.");
			return;
		}
		
		String dbPw = dao.loginProc(id);
		if(dbPw == null || dbPw.isEmpty()) {
			CommonService.msg("로그인 실패");
			return;
		}
		
		if(dbPw.equals(pw)) {
			CommonService.msg("로그인 성공");
			dao.loginSuccess(id);
		}else {
			CommonService.msg("로그인 실패");
		}
	}

	public String loginCheck(String id) {
		return dao.loginCheck(id);
	}

	// 매니저 - 매니저 계정 관리
	
	// 메뉴 전체 조회
	public ArrayList<ManagerDTO> selectAllList() {
		ArrayList<ManagerDTO> managers = dao.selectAllList();
		if(managers.isEmpty() == false) {
			for(ManagerDTO manager : managers) {
				System.out.print(manager.getId());
				System.out.println("데이터 조회 test");
			}
		}
		return dao.selectAllList();
	}



	public void update(int managerNum, ManagerDTO managerDto) {
		// TODO Auto-generated method stub
		
	}

	public void regProc(ManagerDTO managerDto) {
		// TODO Auto-generated method stub
		
	}



	public void delete(int managerNum) {
		// TODO Auto-generated method stub
		
	}

}
