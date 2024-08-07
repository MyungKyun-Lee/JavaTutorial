package _02if;

public class _01_qq {

	public static void main(String[] args) {
		// Sorting
		int[] aaa = {45,34,64};
		int maxx = 0;
		System.out.println(aaa[0]+"/"+aaa[1]+"/"+aaa[2]);
		
		if (aaa[0] < aaa[1]) { maxx = aaa[0]; aaa[0] = aaa[1]; aaa[1] = maxx;}
		System.out.println(aaa[0]+"/"+aaa[1]+"/"+aaa[2]);
		
		if (aaa[1] < aaa[2]) { maxx = aaa[1]; aaa[1] = aaa[2]; aaa[2] = maxx;}
		System.out.println(aaa[0]+"/"+aaa[1]+"/"+aaa[2]);
		
		if (aaa[0] < aaa[1]) { maxx = aaa[0]; aaa[0] = aaa[1]; aaa[1] = maxx;}
		System.out.println(aaa[0]+"/"+aaa[1]+"/"+aaa[2]);
		
		
		int[] aa = {45,34,64};
		int max = 0;
		int aPlus = 0;
		int cnt = 0;
//		System.out.println(aa[0]/10 +"+"+aa[0]%10);
		aPlus = aa[0]/10 + aa[0]%10;
		if (max <= aPlus) {
			max = aPlus;
			cnt = 1;
		}
		aPlus = aa[1]/10 + aa[1]%10;
		if (max <= aPlus) {
			max = aPlus;
			cnt = 2;
		}
		aPlus = aa[2]/10 + aa[2]%10;
		if (max <= aPlus) {
			max = aPlus;
			cnt = 3;
		}
		System.out.println("a배열에서 분해하여 합한 큰수는"+max+"이고 "+cnt+"몇번째 입니다.");

		int [] b= {64,45,34};
		 int b0Sum=(b[0]/10)+(b[0]%10);
		 int b1Sum=(b[1]/10)+(b[1]%10);
		 int b2Sum=(b[2]/10)+(b[2]%10);
		 if ((b0Sum>=b1Sum)&&(b0Sum>=b2Sum)) {
			 System.out.println("선택할 숫자: 0번째"+" 숫자의 합: "+b0Sum );
		 }else if(b1Sum>=b2Sum) {
			 System.out.println("선택할 숫자: 1번째"+" 숫자의 합: "+b1Sum);
		 }else {
			 System.out.println("선택할 숫자: 2번째"+" 숫자의 합: "+b2Sum);
		 }
		 
		 int [] x= {6,5,9};
		 int [] y= {4,10,6};
		 int [] bullet= {3,2};
		 double gradientBullet = bullet[1]/bullet[0];
		 double gradientBird0 = y[0]/x[0];
		 double gradientBird1 = y[1]/x[1];
		 double gradientBird2 = y[2]/x[2];
		 
		 if(gradientBullet == gradientBird0) {
			 System.out.println("총알에 맞는 새는 0번입니다.");
		 }
		 if(gradientBullet == gradientBird1) {
			 System.out.println("총알에 맞는 새는 1번입니다.");
		 }
		 if(gradientBullet == gradientBird2) {
			 System.out.println("총알에 맞는 새는 2번입니다.");
		 }
	}

}
