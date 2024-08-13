package _03For;

import java.util.Random;

public class _06_0812_q10 {

	public static void main(String[] args) {
		// 미션10) 9번에서 중복이 되지 않게 하시오...  이때 for문은 한 개만 사용
		Random r = new Random();

		int[] lotto = new int[6];
		int num4=0;
		int cnt = 5;
		int max = -1;
		lotto[5] = r.nextInt(9)+1;
				
		for (int i=0; i<cnt; i++ ) {

			if (max != lotto[i]) {
//				lotto[i] = r.nextInt(9)+1;
				max = lotto[i];
				i++;
			} else {
				System.out.println(i+"/"+temp);
				i = 0;
			}
			System.out.println("random[6]="+lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]+"/");
		}
		
		

	}

}
