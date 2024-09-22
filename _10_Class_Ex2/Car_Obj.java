package _10_Class_Ex2;

public class Car_Obj {
	int car_no = 0;
	String car_owner = null;
	
	public void prt() {
		System.out.println("----- Car 주차정보 -----");
		System.out.println("차번호 : "+car_no);
		System.out.println("소유자 : "+car_owner);
	}
}
