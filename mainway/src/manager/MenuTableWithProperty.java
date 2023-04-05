package manager;

import javafx.beans.property.StringProperty;

// TableView에 보여질 메뉴 데이터 클래스 생성(데이터 변경 시 TableView에 적용하기 위해 Property 사용)
public class MenuTableWithProperty {
	private StringProperty num;
	private StringProperty group;
	private StringProperty menu;
	private StringProperty image;
	private StringProperty description;
	private StringProperty price;
	private StringProperty kcal;
	private StringProperty date;
	
	public MenuTableWithProperty(StringProperty num, StringProperty group, StringProperty menu, StringProperty image, StringProperty description, StringProperty price, StringProperty kcal, StringProperty date) {
		this.num = num;
		this.group = group;
		this.menu = menu;
		this.image = image;
		this.description = description;
		this.price = price;
		this.kcal = kcal;
		this.date = date;
	}
	
	public MenuTableWithProperty(String num, String group, String menu, String image, String description, String price, String kcal, String date) {
		this.num.set(num);
		this.group.set(group);
		this.menu.set(menu);
		this.image.set(image);
		this.description.set(description);
		this.price.set(price);
		this.kcal.set(kcal);
		this.date.set(date);
	}
	
	public StringProperty numProperty() {
		return num;
	}
	
	public StringProperty groupProperty() {
		return group;
	}
	
	public StringProperty menuProperty() {
		return menu;
	}
	
	public StringProperty imageProperty() {
		return image;
	}
	
	public StringProperty descriptionProperty() {
		return description;
	}
	
	public StringProperty priceProperty() {
		return price;
	}
	
	public StringProperty kcalProperty() {
		return kcal;
	}
	
	public StringProperty dateProperty() {
		return date;
	}
	
	
	
	
	

}
