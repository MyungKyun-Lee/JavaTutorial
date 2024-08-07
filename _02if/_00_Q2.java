package _02if;

public class _00_Q2 {

	public static void main(String[] args) {
		// 
		
		int a = 10;
		int b = 20;
		int my = 18;
		
		if (my >= a && my <= b) {
			System.out.println("도로위");
			System.out.println("a지점에서"+(my-a)+"만큼 떨어져 있습니다");   // up1
		} else {
			System.out.println("도로위가 아님");
		}
		
		// up2
		if (my >= a && my <= b) {
			System.out.println("도로위");
			if (my-a <= b-my ) {
				System.out.println("a지점에서"+(my-a)+"만큼 떨어져 있습니다");   // up2	
			} else {
				System.out.println("b지점에서"+(b-my)+"만큼 떨어져 있습니다");   // up2
			}
			
		} else {
			System.out.println("도로위가 아님");
		}

	}

}
