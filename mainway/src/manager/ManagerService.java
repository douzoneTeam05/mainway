package manager;

import java.util.ArrayList;

import common.CommonService;
import javafx.collections.ObservableList;

public class ManagerService {	
	private ManagerDAO dao;
	
	public ManagerService() {
		dao = new ManagerDAO();
	}
	
	// 관리자 로그인
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

	// 관리자 로그인 체크
	public String loginCheck(String id) {
		return dao.loginCheck(id);
	}

	
	// 관리자 페이지 - 관리자 계정 관리
	
	// 관리자 전체 조회
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


	// 관리자 계정 수정
	public void update(int managerNum, ManagerDTO managerDto) {
		managerDto.setManager_num(managerNum);
		dao.update(managerDto);
		
	}

	// 관리자 계정 등록
	public void regProc(ManagerDTO managerDto) {
		dao.regProc(managerDto);		
	}


	// 관리자 계정 삭제
	public int delete(int managerNum) {
		int result = dao.delete(managerNum);
		if(result == 1) {
			System.out.println("관리자 계정이 삭제되었습니다.");
		} else {
			System.out.println("메뉴 삭제 에러. DB를 확인해주세요.");
		}
		
		return result;
		
	}

	public ObservableList<ManagerDTO> selectManager(String text) {
		return dao.selectManager(text);
	}



}
