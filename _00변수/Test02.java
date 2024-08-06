package _00변수;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 오후 문제 풀이
		// 중요 기능 : 변수, 자료형, 연산자
		// 문제1

		
		
		int[] lotto = {6,12,33,4,5,26};
		lotto[0]=lotto[0];
		lotto[1]+=lotto[0];
		lotto[2]+=lotto[1];
		lotto[3]+=lotto[2];
		lotto[4]+=lotto[3];
		lotto[5]+=lotto[4];
		System.out.println(lotto[0]+"/"+lotto[1]+"/"+lotto[2]+"/"+lotto[3]+"/"+lotto[4]+"/"+lotto[5]);
		
		char a = 'A';
		char b = 'a';
		char c;
		System.out.println(b-a);
//		for (int i=0; i<33; i++) {
//			c = a + i;
//			System.out.println(c);
//		}
	}

}
