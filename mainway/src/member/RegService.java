package member;

public class RegService {
	public void regStage(RegDTO reg) {
		RegDAO regDao = new RegDAO();
		regDao.regStage(reg);
	}

	public boolean idOverlapStage(String id) {
		RegDAO iddao = new RegDAO();
		return iddao.idOverlapStage(id);
	}
	
	public boolean emailOverlapStage(String email) {
		RegDAO emaildao = new RegDAO();
		return emaildao.emailOverlapStage(email);
	}
	
	public boolean phone_numOverlapStage(String phone) {
		RegDAO phonedao = new RegDAO();
		return phonedao.phone_numOverlapStage(phone);
	}
}
