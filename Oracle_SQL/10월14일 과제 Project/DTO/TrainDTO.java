package dto;

public class TrainDTO {
	String tr_id = null;		// 기차ID
	String tr_name = null;		// 기차명
	String tr_type = null;		// 기차유형
	
	public String getTr_id() {
		return tr_id;
	}
	public void setTr_id(String tr_id) {
		this.tr_id = tr_id;
	}

	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}

	public String getTr_type() {
		return tr_type;
	}
	public void setTr_type(String tr_type) {
		this.tr_type = tr_type;
	}



	@Override
	public String toString() {
		return "TrainDTO [tr_id=" + tr_id + ", tr_name=" + tr_name + ", tr_type=" + tr_type + "]";
	}

}
