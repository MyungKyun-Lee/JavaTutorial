package _04_2For;

public class _01_0819_q1_12 {

	public static void main(String[] args) {
		// 문제1)
		for (int i=1; i<5; i++) {
			for (int j=1; j<4; j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println(" ");	
		}
		System.out.println("--------------------------");
		
		// 문제2)
		for (int i=0; i<5; i++) {
			for (int j=5; 0<j-i; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------");
		
		// 문제3)
		for (int i=0; i<4; i++) {
			for (int j=0; j<4+i; j++) {
				if (j >= 4-i-1)
					System.out.print("*");
				else
					System.out.print("0");
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------");
		
		// 문제4) 다시 보기
		for (int i=0; i<4; i++) {
			for (int j=0; j<7-i; j++) {
				if (j > i-1)
					System.out.print("*");
				else
					System.out.print("0");
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------");
		
		// 문제5) 40보다 큰 수는 모두 몇개
		int[] aa ={34,55,23,56,34,45,34};
		int max =0;
		for (int i=0; i<aa.length; i++) {
			if (aa[i] > 40) max++;
		}
		System.out.println("aa[] 40보다 큰수의 갯수는 "+max+"개");
		System.out.println("--------------------------");
		
		// 문제6) b배열의 값보다 큰 값이 a 배열의 값에 모두 몇개가 있는가?
		int[] a ={34,55,23,56,34,45,34};
		int[] b ={36,49};
		int num =0;
		for (int i=0; i<b.length; i++) {
			System.out.print("a 배열의 값에는 "+b[i]+"번호 보다 큰 숫자가 ");
			for (int j=0; j<a.length; j++) {
				if (b[i] <a[j]) {
//					System.out.print(a[j]+",");
					num++;
				}
			}
			System.out.print(num);
			System.out.println("개 있습니다");
		}
		System.out.println("--------------------------");
		
		// 문제7) 10000원짜리 0개, 1000원짜리 0 개, 100짜리 0개, 10짜리 0개, 
		int money = 4570;  // 가격
		int pay  = 10000;  //지불금액
		int bill = pay - money;
		System.out.print("잔액: "+bill +"원 (");
		System.out.println("천원"+bill%10000/1000+"개, 백원"+bill%1000/100+"개, 십원"+bill%100/10+"개)");
		int baseMoney = 10;
		for(;;) {
			bill/=10;
			if(bill <= 0) {
				break;
			}
			System.out.println(baseMoney +":"+ (bill%10)+"개");
			baseMoney *= 10;
		}
		System.out.println("--------------------------");
		
		// 문제8) 같은 캐릭터가 3개 이상이면 제거 대상, 제거 대상 캐릭터 번호와 갯수
		int[] pang={1,0,0,0,2,3,4,4,6,2,2,2,2,5};
		for (int i=0; i<pang.length; i++) {
			int cnt8 = 0;
			int p_val = pang[i];
			for (int j=i; j<pang.length; j++) {
				if (p_val == pang[j]) {
					cnt8++;
				} 
				else {
					break;
				}
			}
			if (cnt8 >= 3) {
				System.out.println("캐릭터 "+pang[i]+"/연속수 "+cnt8+" 인덱스는"+(i+1));
				i += 3-1;
			}
		}
		System.out.println("--------------------------");
	
		// 문제9) 가장 긴 터널의 알파벳 이름과 숫자
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		char maxchar = ' ';
		int maxcnt = 0;
		for (int i=0; i<ttt.length(); i++) {
			int cnt = 0;
			char temp = ttt.charAt(i);
			for (int j=i; j<ttt.length(); j++) {
				if (ttt.charAt(j) != temp) {
					break;
				} else {
					cnt++;
				}
			}
			if (maxcnt < cnt ) {
				maxcnt = cnt;
				maxchar = temp;
			}
		}
		System.out.println("긴터널은 "+maxchar+" 길이는 "+maxcnt);
		System.out.println("--------------------------");
		
		// 문제10)
		int[] arr = {1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1};
		int size = 2;
		int billding_cnt =0;
		for (int i=0; i<arr.length; i++) {
			int cnt =0;
			for (int j=i; j<arr.length; j++) {
				if (arr[j] != 0) {
					break;
				} else {
					cnt++;
				}
			}
			if (cnt >= size) {
				billding_cnt ++;
			}
		}
		System.out.println("건물 size는 "+size+"이고 건물을 지을 수 위치수 "+billding_cnt);
		System.out.println("--------------------------");
		
		// 문제11)
		for (int i=0; i<4; i++) {
			for (int j=0; j<4+i; j++) {
				if (j >= 4-i-1)
					System.out.print("*");
				else
					System.out.print("0");
			}
			System.out.println(" ");
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<6-i; j++) {
				if (j > i)
					System.out.print("*");
				else
					System.out.print("0");
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------");
		
		// 문제12) 11번 문제에서 for문 2개만 사용하기 if문은 갯 수 상관없음.
		int last = 0;
		for (int i=0; i<7; i++) {
			if (i<4) last = 4+i;
			else last = 6-i+4;
			
			for (int j=0; j<last; j++) {
				if (i<4) {
					if (j >= 4-i-1)
						System.out.print("*");
					else
						System.out.print("0");
				} else {
					if (j < i-3)
						System.out.print("0");
					else
						System.out.print("*");
				}
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------");
		
	}

}
