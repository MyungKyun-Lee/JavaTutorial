package _03For;

import java.util.Random;

public class _06_0812_q10 {

	public static void main(String[] args) {
		// 미션10) 4번에서 중복이 되지 않게 하시오...  이때 for문은 한 개만 사용
		Random r = new Random();

		int[] lotto = new int[6];
		int num4=0;
		
		for (int i=0; i<6; i++) {
			lotto[i] = r.nextInt(45)+1;
			if (i !=3 && lotto[i] == lotto[3]) i--; 
		}
		System.out.println("random[6]="+lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]+"/");
		
		

	}

}
