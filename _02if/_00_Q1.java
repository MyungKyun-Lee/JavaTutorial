package _02if;

public class _00_Q1 {

	public static void main(String[] args) {
		/*
		 * Basic
		 * 영수는 게일을 개발중인데 명중에 따라 점수를 차등 부여 하는 알고리즘을 개발 중이다.
		 * 
		 */
		int point = 20;
		int x = -40;
		
		if ( x < 0 ) {
			point *= -1;
		} else if (x >= 0 && x <= 12) {
			if ( x <= 1) point += point * 0.1;   // up2 0~1 사이이면 보너스 점수에서 10% 추가
			point += 10;
		} else if ( x <= 20) {
			point += 9;
		} else if ( x <= 30) {
			point += 8;
		} else {
			point += 7;
		}
		
		System.out.println(point);
	}

}
