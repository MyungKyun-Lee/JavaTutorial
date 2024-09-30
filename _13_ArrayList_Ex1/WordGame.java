package _13_ArrayList_Ex1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	WordList_menu wl = null;
	ArrayList<String> word_save = new ArrayList<String>();
	ArrayList<String> word_wrong = new ArrayList<String>();
	Random r = new Random();

	public WordGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void WordGame_run() {
		Scanner in = new Scanner(System.in);
		
		String temp_word=null;
		int total_num = wl.wList.size();
		int cnt=0;
		
		while (cnt < total_num) {
			String save_w = null;
			int c_index = -1;
			// 중복되지 않게 함수 만들어서 생성해야됨
			c_index = WordRamdom();
//			System.out.print(wl.wList.get(c_index).e_desc);
			
			
			word_save.add(wl.wList.get(c_index).e_word);
			System.out.print(wl.wList.get(c_index).e_desc +" -> 영어단어를 입력 하세요 :");
			temp_word = in.nextLine();
			if (wl.wList.get(c_index).e_word.equals(temp_word)) {
				System.out.println("맞았습니다");
			} else {
				System.out.println(wl.wList.get(c_index).e_word);
				System.out.println("틀렸습니다");
				word_wrong.add(temp_word);
			}
			cnt++;
		}
		System.out.println("---틀린 단어 리스트---");
		for (int k=0; k<word_wrong.size(); k++) {
			System.out.println(k+". ["+word_wrong.get(k)+"]");
		}
	}
	
	public int WordRamdom() {
		boolean check = true;
		int ret = -1;
		int ram = 0;
		String ram_word = null;
		
		while (check) {
			ram = r.nextInt(wl.wList.size());
			ram_word = wl.wList.get(ram).e_word;
			
			ret = word_save.indexOf(ram_word); // indexOf 찾지 못하면 -1를 return 함 
//			for(int i=0; i<word_save.size(); i++) {
//				if (word_save.get(i).equals(ram_word) ) {
//					ret++;
//					break;
//				}
//			}
			if (ret == -1) check = false;
			else ret = -1;
		}
		return ram;
	}

}
