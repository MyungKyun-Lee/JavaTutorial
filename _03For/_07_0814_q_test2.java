package _03For;

import java.util.Scanner;

public class _07_0814_q_test2 {

	public static void main(String[] args) {
		// 문제 Test2)
		int[] road = {0,1,0,0,0,1,0,0,2,0,0,0,0,2,0,0,0,4,0,0,0,4,0,0,0,1,7,0,0,3,0,0,7,0,0,8,0,0,1,3,0,0,1,0};
		int me=-1;
		int last = road.length;
		int sum_k=0;
		
		Scanner in = new Scanner(System.in);
		
		while (sum_k<last) {
		
			System.out.println("[엔터키] 주사위를 던지세요");
			int k = in.nextInt();
			in.nextLine();  // 버퍼 지우기
			if (k>0 && k<7) {
				
				sum_k +=k;
			}
		}

	}

}
