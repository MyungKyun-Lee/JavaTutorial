package _04_2For;

public class _01_0819_q9_ex {

	public static void main(String[] args) {
		// 문제9 추가) String ttt ="aabbbcccaaaaddbbbaaaaa"; 만들기
		String a ="aabbbcccaaaaddbbbaaaaa";
		char maxchar = ' ';
		int maxcnt = 0;
		for (int i=0; i<a.length(); i++) {
			char nowchar = a.charAt(i);
			int cnt = 0;
			
			for (int j=0; j<a.length(); j++) {
				if (a.charAt(j) != nowchar) {
					break;
				} else {
					cnt++;
				}
			}
			if (maxcnt <= cnt ) {
				maxcnt = cnt;
				maxchar = nowchar;
				cnt =0;
			}
		}
		System.out.println(maxchar+"/"+maxcnt);

	}

}
