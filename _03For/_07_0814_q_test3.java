package _03For;

import java.util.Random;

public class _07_0814_q_test3 {

	public static void main(String[] args) {
		// 문제 Test3) 랜덤으로 모든 단어를 출력, 단어는 딱 한 번만 출력, 모든 단어가 모두 출력
		String[] word = {"apple","banana","car","dog","cat","computer"};
		Random r = new Random();
		int num=0;
		boolean[] t = {false,false,false,false,false,false};
		
		for (int i=0; ; i++) {
			num = r.nextInt(6);
			if (t[num] == false) {
				t[num] = true;
				System.out.print(word[num]+"/");
			}
			if (t[0] && t[1] && t[2] && t[3] && t[4] && t[5]) break;
		}
		System.out.println(".");
	}

}
