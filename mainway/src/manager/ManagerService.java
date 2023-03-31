package manager;


public class ManagerService {
//	private ManagerDAO managerDao;
//	
//	public ManagerService() {
//		managerDao = new ManagerDAO();
//	}
//
//	public void loginProc(String adminId, String adminPw) {		
//		if(adminId.isEmpty()) {
//			CommonService.msg("아이디를 입력하세요.");
//		} else if(adminPw.isEmpty()) {
//			CommonService.msg("비밀번호를 입력하세요.");
//		}
//		
//		if(managerDao.findId(adminId) && managerDao.checkPw(adminId, adminPw)) {
//			managerDao.loginSuccess(adminId);
////			CommonService.msg("로그인 성공");
//		} else {
//			CommonService.msg("아이디, 비밀번호를 확인해주세요");
//		}		
//	}
//
//	public String loginCheck(String adminId) {		
//		return managerDao.loginCheck(adminId);
//	}
	
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
//			CommonService.msg("로그인 성공");
			dao.loginSuccess(id);
			/*
			 ALTER TABLE javafx ADD login_check varchar2(3);
			 UPDATE javafx SET login_check='N';
			 SELECT * FROM javafx;
			 COMMIT;
			 */
		}else {
			CommonService.msg("로그인 실패");
		}
	}

	public String loginCheck(String id) {
		return dao.loginCheck(id);
	}

}
