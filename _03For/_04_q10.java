package _03For;

import java.util.StringTokenizer;

import javax.management.StringValueExp;

public class _04_q10 {

	public static void main(String[] args) {
		// 문제10) 큰 값과 가장 큰 값이 있는 인덱스를 출력
		int[] arr = {45,23,25,64,3,24,48};
		int max = arr[0];
		int max_cnt = 0;
		for (int i=0; i<arr.length; i++) {
			if (max <= arr[i]) {
				max = arr[i];
				max_cnt = i;
			}
		}
		System.out.println("max value= "+max+" index= "+max_cnt);
		
		// 문제11) 100부터 999까지 숫자중 /숫자의 각자릿수를 더한 값이 짝수 인 수
		int sumS = 0;
		for (int i=100; i<=999; i++) {
			sumS = (i/100) + ((i%100)/10) + (i%10);
			if (sumS % 2 == 0) System.out.println("Even i= "+i);
		}
		
		// 문제12) 0은 터널이다. 가장 긴 터널의 길이
		int[] arr2 = {1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,3,3};
		int pre = 0;
		int pre_cnt2 = 0;
		int max2 = 0;
		for (int i=0; i<arr2.length; i++) {
			if (arr2[i] == pre && arr2[i] == 0) {
				pre_cnt2++;
			} else {
				pre = arr2[i];
				pre_cnt2 = 1;
			}
			if (pre_cnt2 >= max2) max2 = pre_cnt2;
		}
		System.out.println("0 max value= " + max2);
		
		// 문제13) 숫자는 터널의 번호이다. 터널의 길이가 가장 긴 숫자와 길이를 출력
		int[] arr3 = {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,2,2,0,0,0,0,0,3,3};
		int pre3 = -1;
		int pre3_cnt = -1;
		int max3 = -1;
		int max3_cnt = -1;
		for (int i=0; i<arr3.length; i++) {
			if (pre3 == arr3[i]) {
				pre3_cnt++;
			} else {
				pre3 = arr3[i];
				pre3_cnt = 1;
			}
			if (max3_cnt <= pre3_cnt) {
				max3_cnt = pre3_cnt;
				max3 = arr3[i];
			}
		}
		System.out.println("max cnt="+max3_cnt+" max item="+max3);
		
		
		// 문제14) 가장 긴 터널의 알파벳 이름과 숫자를 찾으세요
		String ttt ="aabbbcccaaaaddbbbaaaaa";
		char pre_a = 'z';
		int  pre_cnt = 0;
		char max4_a = 'z';
		int  max4_cnt = 0;
		
		for (int i=0; i<ttt.length(); i++) {
			char a = ttt.charAt(i);
			if (a == pre_a) {
				pre_cnt++;
			} else {
				pre_a = a;
				pre_cnt = 1;
			}
			if (pre_cnt >= max4_cnt) {
				max4_cnt = pre_cnt;
				max4_a = a;
			}
		}
		System.out.println("max cnt="+max4_cnt+" max item="+max4_a);
		
		// 문제15) 압축하시오. 압축 하는 방법 a2b3c3a4d2b3a5
		String ttt2 ="aabbbcccaaaaddbbbaaaaa";
		char a2 = 0;
		char pre_a2 = ttt2.charAt(0);
		int max5 = 0;
		String reString2 = "";
		
		for (int i=0; i<ttt2.length(); i++) {
			a2 = ttt2.charAt(i);
			if (a2 == pre_a2) {
				max5++;
			} else {
				reString2 += pre_a2; 
				reString2 += max5;
				pre_a2 = a2;
				max5 = 1;
			}
//			System.out.println("a2="+a2+"/"+" max5="+max5+" pre_a2="+pre_a2+" reString2="+reString2);
		}
		reString2 += pre_a2;
		reString2 += max5;
		System.out.println(reString2);
	}

}
