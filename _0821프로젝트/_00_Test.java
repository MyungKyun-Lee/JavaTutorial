// 프로젝트명: Middle
// 개발자: 최진석, 이명균, 김시온
// 개발일자: 2024-08-21
// 프로젝트 설명: 단어 맞추기를 기본으로 한 프로젝트. 기존의 단어 맞추기에서 벗어나 가운데 글자를 추론하여 맞히는 것으로 목표를 설정.
//			  두 가지의 난이도를 설정하였고, 3문제 이상 연속으로 맞혔을 경우 높은 정확도로 인하여 추가 점수를 부여.
//			  최대 140점.
package _04_2For;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
	
public class _00_Test {
		//카운트다운을 수행할 변수 선언 실시
		static int count = 1;

		public static void main(String[] args) {
			String RED = "\u001B[31m";
			String BLUE = "\u001B[34m";
			String RESET = "\u001B[0m";
			
			String[] a = {"탕수육","연포탕","회덮밥","비빔밥","햄버거","짜장면","순대국","돈까스","순두부","육개장","떡볶이","불고기","삼겹살","갈비탕","잡채밥","콩국수","매운탕","삼계탕","닭갈비","김치전"};
			String[] aA = {"마라탕","똠양꿍","팥빙수","막국수","라볶이","설렁탕","감자탕","만두국","감자전","된장국","갈비찜","파스타","감자전","김치찜","쌀국수","수제비","물냉면","전복죽","리조또","아욱국"};
			Scanner in = new Scanner(System.in);
			Random r = new Random();
			Timer timer=new Timer();
			
			TimerTask task1 = new TimerTask() { 
				public void run() {
					if(count <= 5){ //count값이 5보다 작거나 같을때까지 수행
						System.out.println("[카운트다운 : "+count+"]");
						count++; //실행횟수 증가 
					}
					else{
						timer.cancel(); //타이머 종료
						System.out.println("[카운트다운 : 종료]");
					}
				}
			};
			
			
			
			System.out.println("점심 메뉴 맞추기 (빈칸을 채워라!!!)");
			int c=0;
			
			// c가 1 또는 2 외의 다른 숫자 입력 시 do 반복.
			do {
				System.out.println("난이도를 선택하세요.");			
				System.out.println("상(1) 또는 하(2)");
				c =in.nextInt();
				in.nextLine();
			} while (c !=1 && c!=2);
			
			// c의 값이 1일 경우 밑에 for문에서의 a배열을 aA배열로 치환하여 진행하도록 하는 if문
			if (c == 1) {
				for (int i=0; i<a.length; i++) {
					a[i] = aA[i];
				}
			}
			
			System.out.println();
		    System.out.println("가운데 글자를 맞혀보세요.");
		    System.out.println();
		    
			// 랜덤수가 겹치지 않게 하기 위한 배열 생성
			int[] arr = new int[10];
			// 보너스 점수를 계산하기 위한 변수
			int cnt = 0;
			// 총 점수를 계산하기 위한 변수
			int point = 0;
			
			// 총 10문제 실행할 for문
			for (int i = 0; i < 10; i++) {
				// 랜덤한 수 10개 생성(배열에 사용할거라 0~9사용)
				int num = r.nextInt(10);
				// 랜덤수가 겹치지 않게 하기 위한 if문
				if (arr[num] != 1) {
					System.out.println(a[num].charAt(0)+"[ ]"+a[num].charAt(2));
					arr[num] = 1;
				} else {
					i = i - 1;
					continue;
				}
				
				timer.schedule(task1, 1000, 3000); //실행 Task, 1초뒤 실행, 1초마다 반복
				// 입력값
				String b = in.nextLine();
				
				// 정답일 경우 10점 추가 및 추가점수 체크
				if (a[num].charAt(1) == b.charAt(0)) {
					System.out.println(BLUE+"정답"+RESET);
					point += 10;
					cnt++;
				} else {
					System.out.println(RED+"오답"+RESET);
					cnt = 0;
				}
				// cnt가 3이상일 경우 추가 점수 매번 부여
				if (cnt >= 3) {
					point += 5;
				}
				System.out.println("점수: " + point);
				
				// 한 칸 띄우기 위한 sysout
				System.out.println("--------------------------");
				
			}
			in.close();
			// 총 점수 계산
			System.out.println("총 점수: "+point);
		
		
		
		
	}

}
