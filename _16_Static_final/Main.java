package _16_Static_final;

public class Main {

	// 접근 공용변수 리턴타입 메서드명 매개변수
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = Thread.currentThread().getName();
		// 스레드가 코드를 실행한다
		// 현재 코드를 실행하는 스레드의 여러 정보 중
		// 스레드의 이름을 가져온다
		
		System.out.println(name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		MemberADM m = new MemberADM();
		
		// static변수는 공용변수, 위치는 Method area
		// 모든 스레드가 공용해서 사용가능 > 즉, 변수값접근가능
		// 객체를 만들기 않고 클래스명과 변수 또는 메서드명 으로 접근
		String a = MemberADM.compayName;
		System.out.println(a);
		System.out.println(MemberADM.compayName);
		MemberADM.prt();
		MemberADM.compayName = "HOman";
		System.out.println(MemberADM.compayName);
		
		// 상수는 초기값이 결정되면 값을 변경 불가능
//		MemberADM.teamName = "kkk";
		
		
		// 새로운 스레드를 하나 만들어서 멀티스레드로 운용이 가능
//		Thread t1 = new Thread();
//		t1.setName("task1_thread");
//		String tname = t1.getName();
//		System.out.println("새로만든 스레드 이름은 "+tname);
		

	}

}
