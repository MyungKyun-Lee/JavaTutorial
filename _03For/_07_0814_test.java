package _03For;

import java.util.Random;
import java.util.Scanner;

public class _07_0814_test {

	public static void main(String[] args) {
		// 
		Random r = new Random();
		
		int[] lotto = new int[6];
		
		Scanner in = new Scanner(System.in);
				
		for (int i=0; i<lotto.length; i++) {
			System.out.println((i+1) + "번 입력하세요");			
			int k = in.nextInt();
			in.nextLine(); // 버퍼지우
			lotto[i] = k;
			
//			lotto[i] = r.nextInt(45) + 1;
		}
		for (int i=0; i< lotto.length; i++) {
			if (i == lotto.length-1) {
				System.out.println("보너스 : "+lotto[i]);
			} else {
				System.out.println(lotto[i]);
			}
		}

	}

}
