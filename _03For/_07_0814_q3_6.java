package _03For;

import java.util.Random;

public class _07_0814_q3_6 {

	public static void main(String[] args) {
		// 문제2) 1부터 100까지 숫자 중 랜덤 수, 7의 배수이면 행운의 숫자, 7의 배수가 아니면 조심
		Random r = new Random();
		int num1 = r.nextInt(100) + 1;
		if (num1 %7 == 0) {
			System.out.println(num1+ "숫자는 7의 배수는 행운숫자");
		}
		else {
			System.out.println(num1+ "숫자는 7의 배수 아님 조심해야하는 숫자");
		}
		
		// 문제3) 랜덤 수를 하나 뽑아서 출력, 7의 배수이면 행운의 숫자, 7의 배수가 아니면 행운의 숫자가 나올 때 까지 계속 뽑는다.
		for (int i=0; ;i++) {
			int num2 = r.nextInt(100)+1;
			if (num2 % 7 == 0) {
				System.out.println("7의 배수는 행운숫자="+num2);
				break;
			}
		}
		
		// 문제4) 10개를 저장할수 있는 배열, 0부터 99숫자중 랜덤으로 10개, 짝수만 저장, 
//		Random r = new Random();
		int[] array = new int[10];
		for (int i=0; i<array.length; i++) {
			int num = r.nextInt(45)+1;
			if (num%2 == 0) {
				array[i] = num;
			}
			System.out.println("array["+i+"]="+array[i]+"\t num="+num);
		}
		
		// 문제5) 중복허용 가능, 로또 번호 6개를 배열에 저장하고, 출력
		int[] lotto1 = new int[6];
		for (int i=0; i<6; i++) {
			lotto1[i] = r.nextInt(45)+1;
		}
		System.out.println("random[6]="+lotto1[0]+"/"+lotto1[1]+"/"+lotto1[2]+"/"+lotto1[3]+"/"+lotto1[4]+"/"+lotto1[5]+"/");
		
		// 문제6) 랜덤으로 로또 번호를 10000, 가장 많이 뽑힌 로또 번호가 오늘의 추천 로또 번호, 오늘의 추천 로또 번호 하나를 출력, (로또 번호가 같은 횟수로 나왔을 경우에는 큰 숫자가 우선)
//		Random r = new Random();
		int[] lotto = new int[100];
		
	
		for (int i=0; i<10000; i++) {
			lotto[ r.nextInt(45)+1]++;
		}
		for (int i=1; i<=45; i++) {
			System.out.println("lotto["+i+"]="+lotto[i]);
		}

		int max_val = lotto[0];
		int max_index = 0;
		for (int i=1; i<= 45; i++) {
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
