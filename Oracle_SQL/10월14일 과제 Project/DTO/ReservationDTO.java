package dto;

public class ReservationDTO {
	String user_name = null;	// 고객명
	String user_age = null;		// 고객나이
	String res_time = null;		// 예약시간
	String s_st = null;			// 출발역
	String e_st = null;			// 도착역
	String sch_time = null;		// 출발시간
	String tr_name = null;		// 기차정보
	String origin_price = null;	// 가격
	String age_per = null;		// 활인율
	String sale_price = null;	// 결재금액
	
	@Override
	public String toString() {
		return "ReservationDTO [user_name=" + user_name + ", user_age=" + user_age + ", res_time=" + res_time
				+ ", s_st=" + s_st + ", e_st=" + e_st + ", sch_time=" + sch_time + ", tr_name=" + tr_name
				+ ", origin_price=" + origin_price + ", age_per=" + age_per + ", sale_price=" + sale_price + "]";
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}

	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	public String getS_st() {
		return s_st;
	}
	public void setS_st(String s_st) {
		this.s_st = s_st;
	}

	public String getE_st() {
		return e_st;
	}
	public void setE_st(String e_st) {
		this.e_st = e_st;
	}

	public String getSch_time() {
		return sch_time;
	}
	public void setSch_time(String sch_time) {
		this.sch_time = sch_time;
	}

	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}

	public String getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(String origin_price) {
		this.origin_price = origin_price;
	}

	public String getAge_per() {
		return age_per;
	}
	public void setAge_per(String age_per) {
		this.age_per = age_per;
	}

	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	
	
}
