package _03For;

public class __03For_q10 {

	public static void main(String[] args) {
		// 문제10) 987654321이라는 숫자가 있다.. 변수2개와 for문 한개로 모든 자릿수를 더한 합
		int num = 987654321;
		int nsum = 0;
		for (int i=0; i<9; i++) {
			nsum += num%10;
			num = num/10;
//			System.out.println("sum: "+num+" num: "+nsum);
		}
		System.out.println(nsum);
		
		for(int i = 100; i <=999; i++) {
			if((i/10) % 10 == 3) {				// 100에서 999 중 십의 자리가 6인 수
				System.out.println(i);			// 의 반복적인 나열
			}
		}
		
		int num = 987654321;
		int nsum = 0;
		for (int i=0; i<9; i++) {
			nsum += num%10;
			num = num/10;
		}
		System.out.println(nsum);

		
		int sumofNumber = 0;
		for(int i = 100000000; i >=1; i /= 10) {
			System.out.print((987654321/i)%10);
			System.out.print("+");
			sumofNumber += (987654321/i % 10);
		}
		System.out.println("=" + sumofNumber);
		
		int nsum2 = 0;
		for (int i=987654321; i>0; i=i/10) nsum2 += i%10;
		System.out.println(nsum2);

	}

}
