package _03For;

import java.util.Random;

public class _06_0812_q10 {

	public static void main(String[] args) {
		// 미션10) 9번에서 중복이 되지 않게 하시오...  이때 for문은 한 개만 사용
		Random r = new Random();

		int[] lotto = new int[6];
		int k = 0;
		int max = -1;

		for (int i=0; i<6; ) {
			if (i == k) {
				max = r.nextInt(45)+1;
				lotto[k] = max;
				k++; 
				i = 0;
			} else if ((k-1)>i && max == lotto[i]) {
					k--;
			} else  i++;

//			System.out.println(i+"/"+k);
//			System.out.println("random[6]="+lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]+"/");
		}
		System.out.println("random[6]="+lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]+"/");

	}

}
