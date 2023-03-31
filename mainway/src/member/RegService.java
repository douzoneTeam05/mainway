package member;

public class RegService {
	public void regStage(RegDTO reg) {
		RegDAO regDao = new RegDAO();
		regDao.regStage(reg);
	}

	public void idOverlapStage(RegDTO idoverlap) {
		RegDAO iddao = new RegDAO();
		iddao.idOverlapStage(idoverlap);
	}
	
	public void nameOverlapStage(RegDTO nameoverlap) {
		RegDAO namedao = new RegDAO();
		namedao.nameOverlapStage(nameoverlap);
	}
	
	public void emailOverlapStage(RegDTO emailoverlap) {
		RegDAO emaildao = new RegDAO();
		emaildao.emailOverlapStage(emailoverlap);
	}
}
