package _03For;

import java.util.Scanner;
import java.util.Random;

public class _06_0812_q11 {

	public static void main(String[] args) {
		
		// 미션11) 랜덤으로 번호를 먼저 뽑고, 키보드로 사용자가 번호를 입력하는 방식으로 가위 바위 보 게임
		Random r = new Random();
		int num3 = r.nextInt(3)+1;
		
		System.out.println("가위=1 바위=2 보=3 중 하나를 입력하세요");  // 가위=1 바위=2 보=3
		Scanner in = new Scanner(System.in);
		String a  = in.nextLine();

		int cal = Integer.parseInt(a) - num3;
		
		if (cal == 0) System.out.println("comput="+num3+" 으로 비겼음!");
		else if (cal == 1 ) System.out.println("comput="+num3+" 으로 사람 승!");
		else if (cal == 2 ) System.out.println("comput="+num3+" 으로 computer 승!");
		else if (cal == -1) System.out.println("comput="+num3+" 으로 computer 승!");
		else if (cal == -2 ) System.out.println("comput="+num3+" 으로 사람 승!");
	}

}
