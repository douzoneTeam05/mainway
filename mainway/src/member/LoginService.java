package member;

import common.CommonService;
import common.LoginManager;

public class LoginService {
	private LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}
	
	public void loginProc(String id, String pw) {
		if (id.isEmpty() || pw.isEmpty()) { //만약 id와 pw의 문자열이 비어있으면 "아이디 또는 비밀번호를 입력하세요 알림창 출력"
			CommonService.msg("아이디 또는 비밀번호를 입력하세요"); //알림창
			return;
		}
		
		String dbPw = dao.loginProc(id); // dbpw와 dao의 loginProc의 id 값이 일치할 때
		if (dbPw == null || dbPw.isEmpty()) { //dbpw가 없거나 dbpw의 문자열이 비어있으면 "로그인 실패" 알림창 출력
			CommonService.msg("로그인 실패"); //알림창
			return;
		}
		
		if (dbPw.equals(pw)) { //dbpw와 pw값을 비교
			dao.loginSuccess(id); //dao의 loginSuccess의 id값을 이용
			
			// 로그인 성공 시 로그인 싱글톤 클래스 인스턴스 생성
			LoginManager loginManager = LoginManager.getInstance();
			loginManager.setId(id);
			RegDTO loginMember = LoginManager.regDto(loginManager.getId());
			System.out.println("getter로 로그인한 회원 가져오기"+loginMember);

			CommonService.msg("로그인 성공");
		} else { // 아니면
			CommonService.msg("비밀번호가 다릅니다."); // "아이디 또는 비밀번호가 다릅니다." 알림창 출력
		}
	}

	public String loginCheck(String id) {
		return dao.loginCheck(id);
	}
}
