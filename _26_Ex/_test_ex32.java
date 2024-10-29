package _26_Ex;

public class _test_ex32 {

	public static void main(String[] args) {
		Memo m1 = new Memo();
		Memo m2 = m1;
		
		// m2 참조된 변수에 값 입력
		m2.date = "2024-10-25";
		m2.title = "Java 학습";
		m2.memo = "Java 클래스 참조변수 복사 및 사용";
		
		// m1, m2 주소 값이 같음을 IF문 비교로 확인 할 수 있다.
		if (m1 == m2) {
			System.out.println("True");
			
			System.out.println(m1.date);
			System.out.println(m1.title);
			System.out.println(m1.memo);

		} else {
			System.out.println("False");
		}
	}

}
