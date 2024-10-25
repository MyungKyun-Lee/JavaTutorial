package dto;

public class ScheduleDTO {
	String sch_id = null;	// 스케줄ID
	String sch_time = null;	// 출발시간
	String s_st_nm = null;	// 출발역
	String e_st_nm = null;	// 도착역
	String tr_name = null;	// 기차명
	int origin_price = 0;	// 가격
	
	public String getSch_id() {
		return sch_id;
	}
	public void setSch_id(String sch_id) {
		this.sch_id = sch_id;
	}
	public String getSch_time() {
		return sch_time;
	}
	public void setSch_time(String sch_time) {
		this.sch_time = sch_time;
	}
	public String getS_st_nm() {
		return s_st_nm;
	}
	public void setS_st_nm(String s_st_nm) {
		this.s_st_nm = s_st_nm;
	}
	public String getE_st_nm() {
		return e_st_nm;
	}
	public void setE_st_nm(String e_st_nm) {
		this.e_st_nm = e_st_nm;
	}
	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}
	public int getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
	}
	
	@Override
	public String toString() {
		return "ScheduleDTO [sch_id=" + sch_id + ", sch_time=" + sch_time + ", s_st_nm=" + s_st_nm + ", e_st_nm="
				+ e_st_nm + ", tr_name=" + tr_name + ", origin_price=" + origin_price + "]";
	}

}
