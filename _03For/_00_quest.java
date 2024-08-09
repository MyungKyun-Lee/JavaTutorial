package _03For;

public class _00_quest {

	public static void main(String[] args) {
		// 문제1, 문제2, 문제3
		int sum = 0;
		int sump = 0;
		int summ = 0;
		int cnt =0;
		for (int i=1; i<= 100; i++) {
			if (i%2 == 1) {
				summ +=i;
				sum +=i;
				cnt++;
			}
			else {
				sump +=i;
				sum -=i;
			}
		}
		System.out.println("홀수합: "+summ+" 짝수합: "+sump+" 홀수합-짝수합: "+sum);
		System.out.println("홀수합: "+summ+" 짝수합: "+sump);
		System.out.println("홀수 갯수: "+cnt);
		
		// 문제4
		sum = 0;
		int sumS = 0;
		for (int i=100; i<= 999; i++) {
			sum += i;
			sumS += (i/100) + ((i%100)/10) + (i%10);
		}
//		System.out.println("100~999 합:"+sum+" 4+5+3합: "+(453/100)+"/"+((453%100)/10)+"/"+(453%10));
		System.out.println("100~999 합:"+sum+" 개별합: "+sumS);
		
		// 문제5
		int a = 0;
		for (int i=100; i<= 999; i++) {
			a = (i%100)/10;
			if (a%3 == 0 && a != 0)
				System.out.println("10의자리 3배수: "+a+"("+i+")");
		}
		
		// 문제6
		sum = 0;
		int index = -1;
		for (int i=0; i<=100; i++) {
			sum += i;
			if (sum > 44 && index == -1) index = i;
		}
		System.out.println("44를 넘긴수: "+index);
		
		// 문제7
		sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
			System.out.print(i);
			if (i<10) System.out.print("+");
		}
		System.out.println("="+sum);
		
		// 문제8
		sum = 0;
		int fib = 1;
		int prev = 0;
		int prevPrev = 0;
		for (int i=1; i < 8; i++) {
			if (prev !=0) {
				fib = prev + prevPrev;
				prevPrev = prev;
			}
			prev = fib;
			sum += fib;
			System.out.print(""+fib);
			if (i<7) System.out.print("+");
		}
		System.out.println("="+sum);
		
		// 문제9
		int fib1 = 0;
		int prev1 = 0;
		for (int i=1; i < 20; i = fib1) {
			System.out.println("i= "+i+" prev="+prev1+" fib="+fib1);
			fib1 = prev1 + i;
			prev1 = i;
//			i = fib1;  // for 증가감소에 이동 시킴
		}
		
		// 문제10
		int nsum2 = 0;
		for (int i=987654321; i>0; i=i/10) nsum2 += i%10;
		System.out.println(nsum2);
	}

}
