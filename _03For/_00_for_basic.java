package _03For;

public class _00_for_basic {

	public static void main(String[] args) {
		// For 문 학습
//		for (int i=0; i <3; i++) {
//		// 012
//		}
//		for (int i=3; i>0; i--) {
//		//	321
//		}
//		for (int i=0; i<100; ) {
//		//	0 무한반복
//		}
//		for (int i=0; i<(i+1);i++) {
//		//	0 1 2 3 무한반복
//		}
		
		int[] a = {30, 40, 50, 55, 65};
		//문제1 65 ~ 30 출력
		for (int i=4; i >= 0; i--) {
			System.out.print(a[i]+"/");
		}
		System.out.println(".");
		// 문제2 40~65 30
		for (int i=1; i <= a.length; i++) {
			System.out.print(a[i%5]+"/");
		}
		System.out.println(".");
		// 응용
		for (int i=0; i < a.length; i++) {
			if (a[i] >= 50)
				System.out.print(a[i]+"/");
		}
		System.out.println(".");
		
		// 1. 50이상 점수 합
		int sum = 0;
		for (int i=0; i < a.length; i++) {
			if (a[i] >= 50)
				sum += a[i];
		}
		System.out.print("sum: "+sum+"/");
		System.out.println(".");

		// 2. 평균은. 50점 이상
		int sum2 = 0;
		int index = 0;
		for (int i=0; i < a.length; i++) {
			if (a[i] >= 50) {
				sum2 += a[i]; index++;
			}
		}
		System.out.print("avr: "+(sum2/index)+"/");
		System.out.println(".");

		// 3. 평균은. 최저점수는 포함하지 마시오
		int sum3 = 0;
		int min = a[0];
		double averge = 0.0;
		for (int i=0; i < a.length; i++) {
			if (min >= a[i]) min = a[i];
			sum3 += a[i];
		}
		sum3 = sum3-min;
		averge = (double)sum3 / (a.length-1);
		System.out.print("min: "+min+" sum: "+sum3+" index: "+(a.length-1)+" avr: "+averge+"/");
		System.out.println(".");
	}

}
