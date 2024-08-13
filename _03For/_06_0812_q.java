package _03For;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class _06_0812_q {

	public static void main(String[] args) {
		// 미션0) 짝수만 출력
		int[] letter = {8,12,4,13,2,14,4,5};
		for (int i=0; i<letter.length; i++) {
			if (letter[i]%2 == 0) System.out.println("미션0->"+letter[i]);
		}
		
		// 미션1) 배열의 가장 큰수가 있는 인덱스를 출력
		int[] letter1 = {8,12,4,13,2,14,4,5};
		int max_val = -1, max_inx = -1;
		for (int i=0; i<letter.length; i++) {
			if (max_val <= letter1[i]) {
				max_inx = i;
				max_val = letter1[i];
			}
		}
		System.out.println("미션1->"+"max Array index= " + max_inx);
		
		// 미션2) 짝수이면서 가장큰 값
		int[] letter2={8,12,4,13,25,14,4,5};
		int max_val2 = -1, max_inx2 = -1;
		for (int i=0; i<letter.length; i++) {
			if (letter2[i]%2 == 0) {
				if (max_val2 <= letter2[i]) {
					max_inx2 = i;
					max_val2 = letter2[i];
				}
			}
		}
		System.out.println("미션2->"+"max Array odd value= " + max_val2);
		
		// 미션3) letter 배열은 word문자열 알파벳의 위치, 배열의 암호를 풀어서 편지의 내용을 출력
		String word ="gehoudfkimjnlvy";
		int[] letter3 = {8,12,3,13,1,14,3,4};
		String new_str = "";
		for (int i=0; i<letter3.length; i++) {
			new_str += word.charAt(letter3[i]);
		}
		System.out.println("미션3->"+new_str);
		
		// 미션4) 0이 의미하는 것은 공터, 공터는 연속적, 건물을 지을 수 있는 위치는 모두 몇개
		int[] arr = {1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1};
		int size = 1;  // 건물 사이즈
		int p_arr_val = arr[0]; // 초기값 이전 배열값
		int max_val4 = 0;       // 최대값
		int cnt = 0;			// 건물수
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == 0 && p_arr_val == arr[i]) {
				max_val4++;
				if (max_val4 >= size) cnt++;
			}
			else {
				p_arr_val = arr[i];
				max_val4 = 1;
			}
		}
		System.out.println("미션4->"+"cnt= "+cnt);
		
		// 미션5)
//		Scanner in = new Scanner(System.in);
//		String a  = in.nextLine();
		
		// 미션6) 연산자 우선순위 없이 앞에서 부터 차례대로 계산
		String a ="23-56+45*2-56";
		String pre_a = "", pre_b = "";
		int result = 0;
		int cnt_c = 0;                // 연산자 수
		char cla_c = '-';					// 이전 연자는
		for (int i=0; i<a.length(); i++) {
			if (a.charAt(i) == '-' || a.charAt(i) == '+' || a.charAt(i) == '*' || a.charAt(i) == '/') {
				if (cnt_c == 0) {
					cnt_c++;
					cla_c = a.charAt(i);
					result = Integer.parseInt(pre_a);
					pre_a = "";
				}
				else {
//					System.out.println("result="+result+" pre_a="+pre_a+" cla_c="+cla_c);
					if (cla_c == '-') result = result - Integer.parseInt(pre_a);
					else if (cla_c == '+') result = result + Integer.parseInt(pre_a);
					else if (cla_c == '*') result = result * Integer.parseInt(pre_a);
					else if (cla_c == '/') result = result / Integer.parseInt(pre_a);
					cla_c = a.charAt(i);
					pre_a = "";
				}
			} 
			else {
				pre_a += a.charAt(i);
			}
		}
		if (cla_c == '-') result = result - Integer.parseInt(pre_a);
		else if (cla_c == '+') result = result + Integer.parseInt(pre_a);
		else if (cla_c == '*') result = result * Integer.parseInt(pre_a);
		else if (cla_c == '/') result = result / Integer.parseInt(pre_a);
		System.out.println("미션6->"+"result= "+result );
		
		// 미션7) 변수를 사용하지 않고 배열만 이용하여 푸는 방법
		int[] a7 = {34,2,35,8,31,45};
		int temp = a7[0];
		for (int i=1; i<a7.length; i++) {
			if (a7[i-1] > a7[i]) {
				temp = a7[i];
				a7[i] = a7[i-1];
				a7[i-1] = temp;
			}
		}
		System.out.println("미션7->"+"a7[5]= "+a7[5]);
		
		// 미션8) 0번인덱스와 그 다음 인덱스를 비교하여 큰 수를 뒤로 배치
		int[] a8 = {34,2,35,8,31,45};
		int temp2 = a8[0];
		for (int i=1; i<a8.length; i++) {
			if (a8[0] < a8[i]) {
				temp = a8[0];
				a8[0] = a8[i];
				a8[i] = temp;
			}
		}
		System.out.println("미션8->"+"max= "+a8[0]);

		// 특별1)
		String a13 = "6/4/3/2/5/1/4/5/6/7/8/9/1/2/3/4/5/6";
		int[] aa = new int[10];
		int b13 = a13.charAt(0);
//		for (int i=0; i<aa.length; i++) aa[i] = 0;
		for (int i=0; i<a13.length(); i++) {
			b13 = a13.charAt(i)-'0';
			if (b13 >=0 && b13 < 10) aa[b13]++;
//			System.out.println(b13);
		}
		for (int i=0; i<aa.length; i++) System.out.print("aa["+i+"]="+aa[i]+" ");
		System.out.println("<- 특별1");
		
		// 특별2)
		String aaa ="67/414/1/23/32/45/54/12/11/232";
		String tmp_a="";
		int res_sum = 0;
		for (int i=0; i<aaa.length(); i++) {
			if (aaa.charAt(i) == '/' ) {
				res_sum = res_sum + Integer.parseInt(tmp_a);
//				System.out.println(res_sum);
				tmp_a = "";
			}
			else {
				tmp_a+=aaa.charAt(i);
			}
		}
		res_sum = res_sum + Integer.parseInt(tmp_a);
		System.out.println("특별2->"+res_sum);
		
	}

}
