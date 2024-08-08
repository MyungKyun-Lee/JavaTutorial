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

	}

}
