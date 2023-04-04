package member;

public class IdSearchService {
	public String idSearchStage(IdSearchDTO idsearchdto) {
		IdSearchDAO searchdao = new IdSearchDAO();
		return searchdao.IdSearchStage(idsearchdto);
	}
}
