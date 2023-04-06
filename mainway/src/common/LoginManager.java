package common;

import member.RegDAO;
import member.RegDTO;

// 싱글톤 LoginManager 클래스 구현
public class LoginManager {
	// 전체에서 공유할 유일한 인스턴스
    private static LoginManager instance;
    private boolean loggedIn = false;
    private static RegDAO regDao = new RegDAO();
    private String id = "";
//    private String userName = "";

    // 외부에서 생성할 수 없게(클래스 내에서만 생성할 수 있도록) private로 생성자 접근제어
    private LoginManager() {
    }

    // getInstance() 메소드 호출 시 인스턴스 반환
    public static synchronized LoginManager getInstance() {
    	// 인스턴스가 없는 경우 생성하여 instance에 저장
        if (instance == null) {
            instance = new LoginManager();
        }
        // 인스턴스 반환
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
    
    // 로그인한 회원 정보 반환
    public static RegDTO regDto(String id) {
    	RegDTO loginMember = new RegDTO();
    	loginMember = regDao.loginMember(id);
    	return loginMember;
    }
    


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	
}

