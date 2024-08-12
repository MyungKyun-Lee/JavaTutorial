package _03For;

import java.util.Scanner;

public class _06_0812_q5 {

	public static void main(String[] args) {
		// 미션5) 문자열을 앞으로 읽으나 뒤로 읽으나 같은 경우의 문자를 판별
		Scanner in = new Scanner(System.in);
		String a  = in.nextLine();
        System.out.println(a);

        boolean t = true;
        int a_length = a.length();
        for (int i=0; i<a_length/2; i++) {
        	if (a.charAt(i) != a.charAt(a_length-1-i)) t = false;
        }
        System.out.println(t);
	}

}
