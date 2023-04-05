package member;

public class PwSearchService {
	public String PwSearchStage(PwSearchDTO pwsearchdto) {
		PwSearchDAO searchdao = new PwSearchDAO();
		return searchdao.PwSearchStage(pwsearchdto);
	}
}
