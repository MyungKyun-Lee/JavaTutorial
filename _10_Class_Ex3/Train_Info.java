package _10_Class_Ex3;

public class Train_Info {
	String tr_no=null;
	String tr_type=null;
	String tr_arr_time=null;
	String tr_fix_yn=null;
	
	public void prt() {
		System.out.println("기차번호:["+tr_no+"] 기차종류:["+tr_type+"] 도착시간:["+tr_arr_time+"]");
	}
	// 새마을 열차
	public void prt2() {
		System.out.println("기차번호:["+tr_no+"] 기차종류:["+tr_type+"*] 도착시간:["+tr_arr_time+"]");
	}
	// 수리중 정보
	public void prt3() {
		System.out.println("기차번호:["+tr_no+"] 기차종류:["+tr_type+"] 수리여부:[수리중]");
	}
}
