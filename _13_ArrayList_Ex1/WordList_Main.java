package _13_ArrayList_Ex1;

import java.util.Scanner;

public class WordList_Main {

	public static void main(String[] args) {
		// 영어단어장 관리 프로그램
		System.out.println("[영어단어장 관리 & 단어 께임 프로그램]");
		WordList_menu wl = new WordList_menu();
		WordGame wg = new WordGame();
		wg.wl = wl;

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("");
			System.out.println("1. 영어단어관리");
			System.out.println("2. 영어단어께임");
			System.out.println("0. 프로그램 종료");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
			
			if (selNum == 1) {
				wl.menu();
			} else if (selNum == 2) {
				wg.WordGame_run();
			} else if (selNum == 0) {
				break;
			}
		}
		System.out.println("[프로그램]을 종료합니다");
		in.close();
	}

}
