package _03For;

public class test3 {

	public static void main(String[] args) {
		// 중복제거 난수
		int[] lotto = new int[6];
		int j=0;
		
		for (int i=0; i< lotto.length; ) {
			int x = (int) (Math.random() * 100 +1);
	
			if (x != lotto[i]) {
				lotto[i] = x;
				j++; i=0;
			} else {
				i++;
			}

			System.out.println(lotto[i]+" ");
		}

	}

}
