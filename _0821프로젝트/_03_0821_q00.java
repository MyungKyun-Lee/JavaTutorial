package _04_2For;

import java.util.Random;
import java.util.Scanner;

public class _03_0821_q00 {

	public static void main(String[] args) {
		String[] a = {"탕수육","연포탕","회덮밥","비빔밥","햄버거","짜장면","순대국","돈까스","순두부","육개장","떡볶이","불고기","삼겹살","갈비탕","잡채밥","콩국수","매운탕","삼계탕","닭갈비","파스타"};
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("점심 메뉴 맞추기 (빈칸을 채워라!!!)");
//		in.nextLine();
		// 랜덤수가 겹치지 않게 하기 위한 배열 생성
		int[] arr = new int[10];
		// 보너스 점수를 계산하기 위한 변수
		int cnt = 0;
		// 총 점수를 계산하기 위한 변수
		int point = 0;
		
		// 총 10문제 실행할 for문
		for (int i = 0; i < 10; i++) {
			// 랜덤한 수 10개 생성(배열에 사용할거라 0~9사용)
			int num = r.nextInt(10);
			// 랜덤수가 겹치지 않게 하기 위한 if문
			if (arr[num] != 1) {
				System.out.println(i+"번 "+a[num].charAt(0)+"[ ]"+a[num].charAt(2));
				arr[num] = 1;
			} else {
				i = i - 1;
				continue;
			}
			// 입력값
			String b = in.nextLine();             // keyboard 입력을 받는다
			// 정답일 경우 10점 추가 및 추가점수 체크
			if (a[num].charAt(1) == b.charAt(0)) {
				System.out.println("정답");
				point += 10;
				cnt++;
			} else {
				System.out.println("오답");
				cnt = 0;
			}
			// 한 칸 띄우기 위한 sysout
			System.out.println();
			// cnt가 3이상일 경우 추가 점수 매번 부여
			if (cnt >= 3) {
				point += 5;
			}
		}
		in.close();
		// 총 점수 계산
		System.out.println(point);
		
	}

}
