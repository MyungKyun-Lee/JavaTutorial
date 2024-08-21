package _04_2For;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

public class _02_test {

	// 색상 코드 정의
	public static final String RESET = "\u001B[0m";  
	public static final String RED = "\u001B[31m";   
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String WHITE = "\u001B[37m";
	
	public static void main(String[] args) {
//		// 이메일 정규식 표현 샘플 예제
//		String email1 = "abc123@abc123.co.kr";
//        String email2 = "abc123@abc123com";
//        // 이스케이프 문자를 활용해야 함
//        String regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
//
//        // 정규 표현식 검증
//        System.out.println(Pattern.matches(regExp, email1));
//        System.out.println(Pattern.matches(regExp, email2));
		

		String[] key = {"종달새","키보드","노트북","모니터","볼펜","스피커","형광등","칠판","선생님"
				,"텀블러","윤율킹왕짱","보드","안경","마스크","책상","의자","이어폰","종이","빨대","선풍기","에어컨"};
		
		
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		String a;
		String pa;
		String name;
		do {			
			int sum = 0;
			int cnt = 0;
			int num = 5;
			System.out.println("이름을 입력해 주세요 : ");
			name = sc.nextLine();
			System.out.println(name+"님 다음 출력된 단어를 입력하세요 총 "+num+"문제입니다.");
			for (int i=0; i < num; i++) {
				String randomWord = key[r.nextInt(key.length)]; //
				System.out.println(randomWord);
				a = sc.nextLine();
				if(randomWord.equals(a)==true) {
					sum += 20;
					cnt++;
					System.out.println(GREEN+"정답입니다"+RESET);
				}else {				
					System.out.println(RED+"오답입니다"+RESET);
				}
					 
			}System.out.println(name+"님의 총점은 "+YELLOW+sum+RESET+"점 정확도는 "+BLUE+20*cnt+RESET+"% 입니다" );
			System.out.println(WHITE + "다시 실행하겠습니까? (예/아니오) : "+RESET);
			pa = sc.nextLine();
		} while (pa.equals("예"));
		System.out.println("프로그램을 종료합니다");
		sc.close();        
  
	}

}
