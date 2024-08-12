package _03For;

public class _test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int sum = 0;
		for (int i=1; i<=10 ; i=i+2) {
			sum += i;
//			System.out.println("i="+i+" sum="+sum);
		}
		
//		String[] fruits = {"orange", "kiwi", "apple", "banana", "cherry"};
		
		// 문제9
				sum = 0;
				int fib = 0;
				int prev = 0;
				int prevPrev = 0;
				for (int i=1; i < 20; i = fib) {
					System.out.println("i= "+i+" prev="+prev+" fib="+fib);
					fib = prev + i;
					prev = i;
//					i = fib;
				}
//				System.out.println("="+sum);
				*/
				int cnt12 = 1;
				int tunnelNum = 0;
				int maxTunnelLength12 = 0;
				int[] arr12 = {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,2,0,0,0,0,0,3,3};
				for (int i = 1; i < (arr12.length); i++) {
					System.out.println("i="+i+" arr12[i-1]="+arr12[i-1]);
					if (arr12[i-1] == arr12[i]) {
						cnt12++;
					} else {
						if (maxTunnelLength12 <= cnt12) {
							maxTunnelLength12 = cnt12;
							tunnelNum = arr12[i-1];
							cnt12 = 1;
						} else {
							cnt12 = 1;
						}
					}
				}
				System.out.println((tunnelNum) + " : " + maxTunnelLength12);
				
				
				// String to Array converting 스트링을 배열로 변환 크래스 toCharArray()
				String myStr = "Hello";
			    char[] myArray = myStr.toCharArray();
			    for (char i : myArray) {
			        System.out.println(i);
			      }
				
	}

}
