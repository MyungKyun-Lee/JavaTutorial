package _10_Class_ex4;

import java.util.Scanner;

public class Customer_main {
	
	public static void main(String[] args) {
		Customer_m Cust_meg = new Customer_m();;
		Event_m event_meg = new Event_m();
		Scanner in = new Scanner(System.in);
		
		// 고객관리 프로그램
		System.out.println("[고객관리 프로그램]");
		while (true) {
			System.out.println("");
			System.out.println("1. 고객관리");
			System.out.println("2. 이벤트관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
			
			if (selNum == 1) {
					Cust_meg.Customer_menu();
			} else if (selNum == 2) {
					event_meg.Event_menu();
			} else if (selNum == 0) {
				break;
			}
		}
		
		System.out.println("[프로그램]을 종료합니다");
	}

}
