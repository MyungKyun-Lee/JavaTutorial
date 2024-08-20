package _04_2For;

import java.util.regex.Pattern;

public class _02_test {

	public static void main(String[] args) {
//		// 이메일 정규식 표현 샘플 예제
//		String email1 = "abc123@abc123.co.kr";
//        String email2 = "abc123@abc123com";
//        // 이스케이프 문자를 활용해야 함
//        String regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
//
//        // 정규 표현식 검증
//        System.out.println(Pattern.matches(regExp, email1));
//        System.out.println(Pattern.matches(regExp, email2));
		
		System.out.println("문제 5번");
		int[] carNum = {1232,1221,1235,1252,1234,4536,3457,3238,3229,2599};
		int[] parking = new int[10];
		for (int i = 0; i < carNum.length-1; i++) {
			if (parking[carNum[i] % 10] == 0) {
				parking[carNum[i] % 10] = carNum[i];
			} else if (parking[carNum[i] % 10] != 0) {
				parking[(carNum[i] % 10) + 1] = carNum[i];
				if (parking[(carNum[i] % 10) + 1] != 0) {
					
				}
			}
		}
		if (parking[carNum[carNum.length-1] % 10] == 0) {
			parking[carNum[carNum.length-1] % 10] = carNum[carNum.length-1];
		}
		for (int i = 0; i < parking.length; i++) {
			System.out.println(parking[i]);
		}

	}

}
