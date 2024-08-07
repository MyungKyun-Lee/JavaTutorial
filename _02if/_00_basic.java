package _02if;

public class _00_basic {

	public static void main(String[] args) {
		// 조건식으로 참과 거짓을 구분하여 코드를 분리하는 if
		// 조건 타입
		// 조건이 하나 인 경우
		// 1차 조건, 2차 조건, 3차 조건이 순서 판별하여면서 하나의 조건에 해당하는 경우
		// 1차 조건 판별 후 2차 조건을 만족, 즉 순차적으로 조건을 판별
		
		// 시나리오 1
		// 키가 160 미만이면 집에 가시오..
		int cm= 163;
		if(cm < 160) {
			System.out.println("집에 가시오");
		}
		// 키가 160 미만이면 집에 가시오.. 160이상이면 환영
		if(cm < 160) {
			System.out.println("집에 가시오");
		} else {
			System.out.println("환영");
		}
		// 점수가 있다. 만약 점수가 홀수라면 +10을 하시오.
		int point = 9;
		if (point%2 == 1) point += 10;
		System.out.println(point);

		// 시나리오 2
		// 키가 180 이사이면 A조, 170~179 B조,170미만이면 C조 조건
		int cm1 = 176;
		System.out.println(cm1 >= 180);
		System.out.println(cm1 >= 170 && cm1 < 180);
		System.out.println(cm1 < 170);

		if (cm1 >= 180) {
			System.out.println("A조");
		} else if (cm1 >= 170) {
			System.out.println("B조");
		} else if (cm1 < 170) {
			System.out.println("C조");
		}
		// 아래 if는 위 에제항 비슷해 보이지만 단독 if가 세 개이다. 즉 
		if (cm1 >= 180) {
			System.out.println("A조");
		} 
		if (cm1 >= 170) {
			System.out.println("B조");
		}
		if (cm1 < 170) {
			System.out.println("C조");
		}
		
		// 시나리오 3 - 조건1에 참인 후에 다시 조건을 순차적으로 판별
		// 출석이 100%이고 과제 제출 횟수가 90%이상인 경우
		int cnt = 100;
		int cntAnswer = 95;
		if (cnt == 100) {
			if (cntAnswer >= 90) {
				System.out.println("MVP");
			} else {
				System.out.println("MVP가 아닙니다.");
			}
		} else {
			System.out.println("출석률 미달로 자격요건이 안됩니다");
		}
	}

}
