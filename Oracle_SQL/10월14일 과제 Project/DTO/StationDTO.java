package dto;

public class StationDTO {
	String st_id = null;	// 기차역ID
	String st_name = null;	// 기차역명
	int st_distance = 0;	// 기차역거리 (서울 기준 0, 떨어진 거리)
	
	@Override
	public String toString() {
		return "StationDTO [st_id=" + st_id + ", st_name=" + st_name + ", st_distance=" + st_distance + "]";
	}

	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}

	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public int getSt_distance() {
		return st_distance;
	}
	public void setSt_distance(int st_distance) {
		this.st_distance = st_distance;
	}
	
	
}
