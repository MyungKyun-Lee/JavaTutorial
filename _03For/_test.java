package _03For;

public class _test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				
		
	}

}
