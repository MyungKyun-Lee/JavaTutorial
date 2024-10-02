package _15_접근제어자_01;

import _15_접근제어자_02.MemberOne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberOne m = new MemberOne();
		// m.name = "hone"; // error -> name 변수는 default로 선언되었기 때문에
		m.setName("1234");
		m.setName("4567");
		m.prt();
	}

}
