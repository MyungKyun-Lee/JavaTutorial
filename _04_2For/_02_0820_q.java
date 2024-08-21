package _04_2For;

public class _02_0820_q {

	public static void main(String[] args) {
		// 문제1) a로 나누어 떨어지는 배열의 값을 모두 출력
		System.out.println("ans 1-------------------------");
		int[] arr = {3,45,26,50,74};
		int a = 5;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] % a == 0) {
				System.out.print(arr[i]+",");
			}
		}
		System.out.println("");

		// 문제2) 배열의 평균값을 구하시오. 소수점 표현
		System.out.println("ans 2-------------------------");
		int[] arr2 = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		int sum = 0;
		double avr = 0.0;
		for (int i=0; i<arr2.length; i++) {
			sum += arr2[i];
		}
		avr = (double) sum / arr2.length;
		System.out.println(avr);
		
		// 문제3) 1부터 10까지 숫자의 각패토리얼의 합
		System.out.println("ans 3-------------------------");
		int sum2 =0;
		for (int i=1; i<=10; i++) {
			int pac = 1;
			for (int k=1; k <= i; k++) {
				pac *= k;
			}
			sum2 += pac; 
			System.out.println(i+"팩토리얼은 "+pac);
		}
		System.out.println("1~10팩토리얼 합은 "+sum2);
		
		// 문제4) 오름차순으로 정렬
		// 1. 가장큰 값을 찾아서 맨뒤 값과 교환한다.. 결과  {56,45,83,58,75,93}
		// 2. 두번째로 큰 값을 찾아서 맨뒤에서 두번째 자리의 값과 교환한다.  결과  {56,45,75,58,83,93}
		// 3. 세번째로 큰 값을 찾아서 맨뒤에서 세번째 자리의 값과 교환한다.  결과  {56,45,58,75,83,93}
		System.out.println("ans 4-------------------------");
		int[] b = {93,45,83,58,75,56};
		int temp = 0;
		for (int i=b.length-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (b[i] < b[j]) {
					temp = b[j]; 
					b[j] = b[i]; 
					b[i] = temp;
				}
			}
			for (int k=0; k<b.length; k++) System.out.print(b[k]+","); System.out.println("");
		}
//		for (int k=0; k<b.length; k++) System.out.print(b[k]+",");System.out.println("");
		
		// 문제5) carnum배열은 자동차 번호, 자동차 번호의 마지막 번호는 해당 차량이 주차할 주차번호, 만약 주차번호에 다른 차량이 주차되어 있으면 다음 주차번호에 주차
		System.out.println("ans 5-------------------------");
		int[] carnum = {1232, 1221, 1235, 1252, 1234, 4536, 3457, 3238, 3229, 2599};
		int[] parking = new int[10];
		for (int i=0; i<carnum.length; i++) {
			int parkingNum = carnum[i]%10;
			for (int j=parkingNum; j<parking.length; ) {  // j++ 증가값 대신 계산값으로 정리
				if (parking[j] == 0) {
					parking[j] = carnum[i];
					break;
				} else {
					j++; 
					j %= 10;
				}
			}
		}
		for (int k=0; k<parking.length; k++) System.out.println("parking번호:"+k+" 차량번호: "+parking[k]); System.out.println("");
		
	}

}
