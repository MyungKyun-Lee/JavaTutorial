package _08_Array2;

public class _08_0913_q1 {

	public static void main(String[] args) {
		// 인도의 수학자 Kaprekar 셀프넘버
		int [] a = new int[5000];
		int [] b = new int[5000];
		
		for (int i=1; i<5000; i++) {
			int num = i;
			int d1000 = num / 1000;
			int d0100 = (num-d1000*1000) / 100;
			int d0010 = (num-d1000*1000-d0100*100) / 10;
			int d0001 = num % 10;
//			System.out.println(d1000+"\t"+d0100+"\t"+d0010+"\t"+d0001);
			
			int gen_num = num + d1000 + d0100 + d0010 + d0001;
//			System.out.println(i+"\t"+gen_num);
			a[i] = gen_num;
		}
		
		int cnt=0;
		for (int i=1; i<5000; i++) {
			for (int j=1; j<5000; j++) {
				if (i == a[j]) { cnt++; b[i]=cnt; 
//				System.out.print(i+"\t"+"\t");
				}
			}
			cnt = 0;
		}
		
		int sum=0;
		for (int i=1; i<5000; i++) {
			if (b[i] == 0 ) {
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
		
		
		
		
	}

}
