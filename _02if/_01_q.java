package _02if;

public class _01_q {

	public static void main(String[] args) {
		// for문 사용하지 않습니다
		
		// 문제1
		double avrage = 89.2;
		if (avrage >= 80) {
			System.out.println("평균: "+avrage+"은 합격");
		} else {
			System.out.println("평균: "+avrage+"은 불합격");
		}
		
		// 문제2
		int level = 2;
		int point = 30;
		if (level == 1) {
			point += 30;
		} else {
			point += 10;
		}
		System.out.println("level: "+level+" 이며 point: "+point);
		
		// 문제3
		int[] lotto = {6,12,33,4,5,26};
		lotto[2] += 80;
		System.out.println("lotto 3번째 값은 "+lotto[2]);
		// 문제4
		if (lotto[3]%2 == 1) {
			System.out.println("lotto 4번째 값은 "+lotto[3]+"으로 홀수");
		} else {
			System.out.println("lotto 4번째 값은 "+lotto[3]+"으로 짝수");
		}
		// 문제5
		int[] lotto2 = {6,12,33,4,5,26};
		int sum = 0;
		if (lotto2[0]%2 == 1) sum += lotto2[0];
		if (lotto2[1]%2 == 1) sum += lotto2[1];
		if (lotto2[2]%2 == 1) sum += lotto2[2];
		if (lotto2[3]%2 == 1) sum += lotto2[3];
		if (lotto2[4]%2 == 1) sum += lotto2[4];
		if (lotto2[5]%2 == 1) sum += lotto2[5];
		System.out.println("홀수인 로또번호의 합:"+sum);
		// 문제6
		int[] a = {45,34,64,45,24};
		int sum2 = 0;
		sum2 += a[0];
		sum2 += a[1];
		sum2 += a[2];
		sum2 += a[3];
		sum2 += a[4];
		System.out.println("a배열 값의 합계는 "+sum2+" 입니다");
		// 문제7
		int[] aa = {45,34,64};
		int max = 0;
		int cnt = 0;
		
		// 배열 변수 생성하여 합한 값을 저장하고 비교한 다른 방법
		int[] bb = {0,0,0};
		bb[0] = aa[0]/10 + aa[0]%10;
		bb[1] = aa[1]/10 + aa[1]%10;
		bb[2] = aa[2]/10 + aa[2]%10;
		max = 0;
		if (max < bb[0]) { max = bb[0]; cnt = 1;}
		if (max < bb[1]) { max = bb[1]; cnt = 2;}
		if (max < bb[2]) { max = bb[2]; cnt = 3;}
		System.out.println("a배열에서 분해하여 합한 큰수는"+max+"이고 "+cnt+"몇번째 입니다.");
		
		
		// up2
		int[] x = {6,5,9};
		int[] y = {4,10,6};
		int cX = 3;
		int cY = 2;
		
		if (x[0]%cX==0 && y[0]%cY==0) System.out.println("맞은새는 x: "+x[0]+" y: "+y[0]);
		if (x[1]%cX==0 && y[1]%cY==0) System.out.println("맞은새는 x: "+x[1]+" y: "+y[1]);
		if (x[2]%cX==0 && y[2]%cY==0) System.out.println("맞은새는 x: "+x[2]+" y: "+y[2]);
		
		// up3
		int xx = 10; /* 가로 5 */
		int yy = 20; /* 세로 6 */
		int mx = 15; /* 가로 2 */
		int my = 26;  /* 세로 2 */
		
		if ((xx-2 <= mx && xx+7 >= mx+2) && (yy-2 <= my && yy+8 >= my+2)) {
			System.out.println("Hit");
		} else {
			System.out.println("No Hit");
		}
		
		

	}

}
