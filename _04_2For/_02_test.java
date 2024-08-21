package _04_2For;

import java.util.regex.Pattern;
import java.util.Scanner;

public class _02_test {

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
		
		Scanner scanner = new Scanner(System.in);
        String name, address;
        int age;
        double weight;
                
        System.out.println("당신의 나이를 입력하세요.");
        age = scanner.nextInt();
        scanner.nextLine(); //버퍼삭제
        System.out.println("당신의 이름을 입력하세요.");
        name = scanner.nextLine();
                
        System.out.printf("당신의 나이는 %d입니다.%n",age);
        System.out.printf("당신의 이름은 %s입니다.%n",name);     
	}

}
