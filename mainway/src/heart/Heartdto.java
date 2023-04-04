package heart;

public class Heartdto {
	private long h_number;
	private long menu_number;
	private long m_number;
	private String yes_no;
	public long getH_number() {
		return h_number;
	}
	public void setH_number(long h_number) {
		this.h_number = h_number;
	}
	public long getMenu_number() {
		return menu_number;
	}
	public void setMenu_number(long menu_number) {
		this.menu_number = menu_number;
	}
	public long getM_number() {
		return m_number;
	}
	public void setM_number(long m_number) {
		this.m_number = m_number;
	}
	public String getYes_no() {
		return yes_no;
	}
	public void setYes_no(String yes_no) {
		this.yes_no = yes_no;
	}
}
	
 /* dto를 쓰는 이유는 
  * 1. dto가 없다면 새로운 class를 만들 때마다 위에처럼 사용하려는 column명을 써서
  * 사용하려는 변수와 자료형을 선언해 줘야한다
    2. 내가 선언한 변수를 고치는 것을 막고 공개하고 싶지 않아서 getter, setter
    매소드만 Public으로 해서 다른 class에서 매소드를 호출 할 때 사용한다*/ 
	
 /* 코드 길이를 줄이려고 쓰는 것이 아니다 코드 길이는 오히려 dto의 get 매소드를 안쓰고
  	eo.data 처럼 데이터를 바로가져오는게 더 편하다.*/
	
 // db table에 입력된 column값을 long 자료형으로 변수를 선언한다
 // get, set 매소드를 사용해서 get, set 함수를 호출한다
	
	
