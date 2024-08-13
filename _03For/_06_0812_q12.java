package _03For;

import java.util.Random;

public class _06_0812_q12 {

	public static void main(String[] args) {
		// 미션12) 랜덤으로 로또 번호를 10000, 가장 많이 뽑힌 로또 번호가 오늘의 추천 로또 번호, 오늘의 추천 로또 번호 하나를 출력, (로또 번호가 같은 횟수로 나왔을 경우에는 큰 숫자가 우선)
		
		Random r = new Random();
		int[] lotto = new int[10];
		
	
		for (int i=0; i<10000; i++) {
			lotto[ r.nextInt(10)]++;
		}
		for (int i=0; i<10; i++) {
			System.out.println("lotto["+i+"]="+lotto[i]);
		}

		int max_val = lotto[0];
		int max_index = 0;
		for (int i=1; i<10; i++) {
			if (max_val < lotto[i] ) {
				max_index = i;
				max_val = lotto[i];
			}
			else if (max_val == lotto[i] && max_index < i) {
				max_index = i;
				max_val = lotto[i];
			}
		}
		System.out.println("lotto num="+max_index);
		
	}

}
