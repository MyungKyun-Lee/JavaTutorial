package _04_2For;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _02_0820_q6_q7 {
	
	public static void main(String[] args) {
		// 문제6)
		String id = "";
		Scanner in = new Scanner(System.in);
		int cnt_id1 = 0;
		for (;;) {
			System.out.println("아이디를 입력하세요");
			id = in.next();
			in.nextLine(); // 버퍼지우
			
			if (id.length() > 1) {
				for(int i = 0; i < id.length(); i++) {
					if(id.charAt(i) == '@') {
						cnt_id1++;
					}
				}
				if (cnt_id1>0) {
					System.out.println(id + "에는 특수문자 '@'가 " + cnt_id1 + "개 있습니다.");
					break;
				} else {
					System.out.println("id는 @ 포함하여야 합니다.");
				}
//				if (id.indexOf('@') > 0) {
//					if (!Pattern.matches("^[a-zA-Z]*$", id)) {
//					    System.out.println("id는 유효성 검사 실패");
//					}
//				} else {
//					System.out.println("id는 @ 포함하여야 합니다.");
//				}
			}
		}
		System.out.println(id);
		
		// 문제7)
		String sign="!@#$%^&*";
		System.out.println("ID를 입력해주세요.");
		String id2 = in.nextLine();
		int cnt_id2 = 0;
		for(int i = 0; i < sign.length(); i++) {
			for(int j = 0; j < id2.length(); j++) {
				if(id2.charAt(j) == sign.charAt(i)) {
					cnt_id2++;
				}
			}
		}
		if (cnt_id2 > 0)
			System.out.println(id2 + "에는 특수문자가 " + cnt_id2 + "개 있습니다.");
		else {
			System.out.println(id2 + "에는 특수문자가 포함되어 있지 않습니다.");
		}
	}

}
