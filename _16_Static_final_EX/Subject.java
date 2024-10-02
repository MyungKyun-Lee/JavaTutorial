package _16_Static_final_EX;

public class Subject {
	private String sub_name = null;   // 과목명
	private String sub_room = null;   // 강의실
	private String sub_techer = null; // 담당교수
	
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_room() {
		return sub_room;
	}
	public void setSub_room(String sub_room) {
		this.sub_room = sub_room;
	}
	public String getSub_techer() {
		return sub_techer;
	}
	public void setSub_techer(String sub_techer) {
		this.sub_techer = sub_techer;
	}
	
	public void prt() {
		System.out.println("과목명["+sub_name+"] 강의실["+sub_room+"] 담당교수["+sub_techer+"]");
	}
}
