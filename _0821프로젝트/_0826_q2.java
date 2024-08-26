package _0821프로젝트;

public class _0826_q2 {

	public static void main(String[] args) {
		// 네트워크 통신 문자열 분석 알고리즘의 기능을 구현하시오.
		// String a ="aabbccddeeeaaaa";
		// a문자열은 통신 문자이다. a 문자 중 가장 길이를 출력하시오.
		// 위 예제에서는 결과값이 4가된다.
		String a ="aabbccddeeeaaaa ";
		
		char maxchar = ' ';
		int maxcnt = 0;
		for (int i=0; i<a.length(); i++) {
			int cnt = 0;
			char temp = a.charAt(i);
			for (int j=i; j<a.length(); j++) {
				if (a.charAt(j) != temp) {
					break;
				} else {
					cnt++;
				}
			}
			if (maxcnt < cnt ) {
				maxcnt = cnt;
				maxchar = temp;
			}
		}
		System.out.println("긴문자열은 "+maxchar+" 길이는 "+maxcnt);
		System.out.println("--------------------------");
	}

}
