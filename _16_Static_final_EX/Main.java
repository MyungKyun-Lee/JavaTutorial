package _16_Static_final_EX;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		SuKang suk = new SuKang();
		
		// 수강신청 프로그램
		System.out.println("[수강신청 프로그램]");

		while(true) {
			System.out.println();
			System.out.println("1. 학생관리");
			System.out.println("2. 교과목관리");
			System.out.println("3. 수강신청 로그인");
			System.out.println("0. 프로그램 종료");
			System.out.print("  선택 >>");
			
			String num = in.nextLine();
			if(num.equals("1")) {
				suk.menuStudent();
			} else if(num.equals("2")) {
				suk.menuSubject();
			} else if(num.equals("3")) {
				suk.menuSuKang();
			} else if(num.equals("0")) {
				break;
			} else {
				System.out.println("선택 번호를 잘못 입력하셨습니다!");
			}
		}
		System.out.println("[프로그램]을 종료합니다");
		in.close();
	}
	

	
}
