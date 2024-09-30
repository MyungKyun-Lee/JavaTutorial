package _13_ArrayList_Ex1;

import java.util.ArrayList;
import java.util.Scanner;

import _10_Class_ex4.Customer_one;

public class WordList_menu {
	Scanner in = new Scanner(System.in);
	
	ArrayList<WordList_one> wList = new ArrayList<WordList_one>();
	
	public WordList_menu() {
		WordList_one word_0 = new WordList_one();
		word_0.e_word = "java";
		word_0.e_desc = "객체지향적 프로그래밍 언어";
		wList.add(word_0);
		WordList_one word_1 = new WordList_one();
		word_1.e_word = "apple";
		word_1.e_desc = "사과";
		wList.add(word_1);
		WordList_one word_2 = new WordList_one();
		word_2.e_word = "banana";
		word_2.e_desc = "바나나";
		wList.add(word_2);
		WordList_one word_3 = new WordList_one();
		word_3.e_word = "kiwi";
		word_3.e_desc = "키위";
		wList.add(word_3);
		WordList_one word_4 = new WordList_one();
		word_4.e_word = "grape";
		word_4.e_desc = "포도";
		wList.add(word_4);
		WordList_one word_5 = new WordList_one();
		word_5.e_word = "peach";
		word_5.e_desc = "복숭아";
		wList.add(word_5);
	}
	public void menu() {
		while (true) {
			System.out.println("");
			System.out.println("---영어 단어장 관리메뉴---");
			System.out.println("1. 단어등록");
			System.out.println("2. 단어보기");
			System.out.println("3. 수정하기");
			System.out.println("4. 삭제하기");
			System.out.println("0. 단어장 종료");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
			
			switch(selNum) {
			  case 1:
				  add();   break; // 등록
			  case 2:
				  serch(); break; // 조회
			  case 3:
				  mod();   break; // 수정
			  case 4:
				  dell();  break; // 삭제
			  case 0:
				  System.out.println(">>단어장 종료<<");
			    break;
			  default:
				  System.out.println("메뉴 0~4 중 숫자만 입력하세요!");
			}
			if (selNum == 0) break;

		} // end while
	}
	public void add() {
		System.out.println("<단어등록>");
		String temp_word=null;
		String temp_desc=null;
		
		System.out.print("영어단어를 입력 하세요 :");
		temp_word = in.nextLine();
		System.out.print("한글설명을 입력 하세요 :");
		temp_desc = in.nextLine();
		
		WordList_one word_o = new WordList_one();
		word_o.e_word = temp_word;
		word_o.e_desc = temp_desc;
		word_o.prt();
		
		wList.add(word_o);
	}
	public void serch() {
		System.out.println("<단어조회>");
		
		for(int i=0; i<wList.size(); i++) {
			wList.get(i).prt();
		}
		System.out.println("----------조회된 영어단어수는 "+wList.size()+"건 입니다");
	}
	public void mod() {
		System.out.println("<단어수정>");
		String temp_word=null;
		String temp_desc=null;
		
		System.out.print("영어단어를 입력 하세요 :");
		temp_word = in.nextLine();
		
		for(int i=0; i<wList.size(); i++) {
			if (wList.get(i).e_word.equals(temp_word)) {
				System.out.print("수정할 영어단어 설명을 입력 하세요 :");
				temp_desc = in.nextLine();
				
				wList.get(i).e_desc = temp_desc;
				wList.get(i).prt();
				break;
			}
		}
	}
	public void dell() {
		System.out.println("<단어삭제>");
		String temp_word=null;
		
		System.out.print("영어단어를 입력 하세요 :");
		temp_word = in.nextLine();
		
		for(int i=0; i<wList.size(); i++) {
			if (wList.get(i).e_word.equals(temp_word)) {
				wList.remove(i);
				System.out.println("등록된 영어단어 "+temp_word+"가 삭제처리 되었습니다!");
				break;
			}
		}
	}

}
