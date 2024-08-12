package _03For;

public class _04_basic_replay {

	public static void main(String[] args) {
		// for basic
		// 문제1) 100부터 999까지의 숫자중에서 홀수만 출력
		for (int i=100; i<=999; i++) if(i%2==1) System.out.println("i= "+i);
		
		// 문제2) 1부터 100까지 숫자중에서 홀수의 총합
		int sum = 0;
		for (int i=1; i<=100; i+=2) sum +=i;
		System.out.println("합계: "+sum);
		
		// 문제3) 다음과 같이 출력하시오   10  9  8  7  6  5  4  3  2  1
		for (int i=10; i>0; i--) System.out.println("i= "+i);

		// 문제4) 배열의 값이 짝수인 것만 출력
		int[] arr = {45,23,25,64,3,24,48};
		for (int i=0; i<arr.length; i++) if (arr[i]%2==0) System.out.println("a["+i+"] :"+arr[i]);
		
		// 문제6) 배열의 값이 홀수 인 곳의 인덱스만 출력
		for (int i=0; i<arr.length; i++) if (arr[i]%2==1) System.out.println("index i="+i);
		
		// 문제7) 배열의 값을 모두 더한 총합
		sum = 0;
		for (int i=0; i<arr.length; i++) sum +=arr[i]; System.out.println("sum= "+sum);
		
		// 문제8) 짝수는 모두 몇개
		int cnt = 0;
		for (int i=0; i<arr.length; i++) if (arr[i]%2==0) cnt++; System.out.println("cnt= "+cnt);
		
		// 문제9) 문자열에 a가 몇개
		String test = "abcdeabce";
		char aaa ;
		int a_cnt =0;
	    for (int i=0; i < test.length(); i ++) {
	    	aaa = test.charAt(i);
//	    	System.out.println(aaa);
	    	if (aaa == 'a') a_cnt++;
	    }
	    System.out.println("a cnt= "+a_cnt);
	}

}
