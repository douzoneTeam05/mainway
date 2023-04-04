package member;

public class menuViewDTO {
	private String menu_num;
	private String name;
	private String explain;
	private String price;
	private String calory;
	private String image;
	private String pizza; // 이부분 삭제해주세요!
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(String menu_num) {
		this.menu_num = menu_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCalory() {
		return calory;
	}
	public void setCalory(String calory) {
		this.calory = calory;
	}
	
}
