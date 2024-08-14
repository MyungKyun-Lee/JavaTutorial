package _03For;

import java.util.Scanner;

public class _07_0814_q1_2 {

	public static void main(String[] args) {
		// 문제1) 키보드로 숫자 한 개를 입력 받아서 홀짝을 출력
		Scanner in = new Scanner(System.in);
		
		System.out.println("숫자 입력하세요");
		int k = in.nextInt();
		in.nextLine(); // 버퍼지우
		
		if (k%2 == 0) 
			System.out.println("youer numbaer is even");
		else 
			System.out.println("youer numbaer is odd");

		
		// 문제2) 키보드로 두 개의 숫자를 입력받아서 합
		System.out.println("1번 숫자 입력하세요");
		int k1 = in.nextInt();
		System.out.println("2번 숫자 입력하세요");
		int k2 = in.nextInt();
		System.out.println("1번="+k1+" 2번="+k2+" 합계="+(k1+k2));

	}

}
