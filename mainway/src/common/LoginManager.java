package common;

import member.RegDAO;
import member.RegDTO;

// 싱글톤 LoginManager 클래스 구현
public class LoginManager {
    private static LoginManager instance;
    private boolean loggedIn = false;
    private RegDAO regDao = new RegDAO();
    private String id = "";

    private LoginManager() {
    }

    // getInstance() 메소드 호출 시 인스턴스 반환
    public static synchronized LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    // 로그인 수행
    public void login() {
        // 로그인 코드 구현
        loggedIn = true;        
    }

    // 로그아웃 수행
    public void logout() {
        // 로그아웃 코드 구현
        loggedIn = false;
    }

    // 로그인 여부 반환
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
//    // 로그인한 회원 정보 반환
//    public RegDTO regDto(String id) {
//    	RegDTO loginMember = new RegDTO();
//    	loginMember = regDao.loginMember(id);
//    	return loginMember;
//    }
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
}

