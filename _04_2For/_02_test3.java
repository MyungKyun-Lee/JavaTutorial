package _04_2For;

import java.util.Scanner;

public class _02_test3 {

	public static void main(String[] args) {
		// 두 숫자를 입력받아 두 수의 합을 출력
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력해주세요 >> ");
		int num1 = scan.nextInt();
		
		System.out.println("두번째 숫자를 입력해주세요 >> ");
		int num2 = scan.nextInt();
		
		System.out.println("결과 : "+(num1 + num2));

	}

}
