package _03For;

import java.util.Random;

public class test3 {

	public static void main(String[] args) {
		// 중복제거 난수
		int[] lotto = new int[6];
		int j=0;
		
		for (int i=0; i< lotto.length; ) {
			int x = (int) (Math.random() * 100 +1);
	
			if (x != lotto[i]) {
				lotto[i] = x;
				j++; i=0;
			} else {
				i++;
			}

			System.out.println(lotto[i]+" ");
		}

//		//08-14[조별] Test3 문제 교사 풀이
//		String[] word ={"apple","banana","car","dog","cat","computer"};
//		Random r = new Random();
//		boolean[] wordchk = new boolean[word.length];
//		for(int i=0; i < word.length; i++) {
//			int idx = r.nextInt(word.length);
//			if(wordchk[idx]==false) {
//				System.out.println(word[idx]);
//				wordchk[idx]=true;				
//			}else {
//				i--;
//			}
//		}
	}

}
