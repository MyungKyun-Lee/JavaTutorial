package _03For;

public class _00_for_basic2 {

	public static void main(String[] args) {
		// basic
		// 1.
		for (int i=0; i<5; i++){
			System.out.println(i);
		}
		System.out.println("--------------------");
		// 2.
		for (int i=5; 5>=0; i--){
			System.out.println(i);
			if (i<0) break;
		}
		System.out.println("--------------------");
		// 3.
		for (int i=0; i<100; i++){
			if(i%2==0){
				System.out.println(i);
			}
		}
		System.out.println("--------------------");
		// 4.
		int sum=0;
		for(int i=0; i<5; i++){
			sum=sum+1;
		}
		System.out.println(sum);
	}

}
