package _11_method;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
//		TestMethod r = new TestMethod();
		
		//Method study
		String a = "880104";
		String year = a.substring(0,2);
		System.out.println(year);
		System.out.println("19"+year);
		
		// String to Int 변환
		System.out.println(a.substring(2,4));
		String b = a.substring(2,4);
		int month = Integer.parseInt(b);
		System.out.println(month);
		
		// 문자열에서 문자열 찾기
		System.out.println(a.contains("8"));  // return bloon형
		
		String w = "개나리";
		String title = "오늘 컨디션 참 개나리야 짜쯩!";
		System.out.println(title.contains(w));
		if (title.contains(w)) 
			System.out.println("욕하지 마세요");
		else
			System.out.println("제목은 올바른 표현입니다.");
		System.out.println(title.indexOf(w));
		
		// 과제 : 제목에서 개나리 부분을 ***으로 바꾸시오.
		System.out.println(title.replace(w,"***"));
		
		// 과제 : 제목에서 개나리 라는 단어가 포함된 부분을 가져오세요
		//       단어가 포함된 기준은 개나리 단어의 시작부터 스페이스까지
		//       위 샘플에서는 [개나리야] 를 가져오는 겁니다.
		System.out.println(title.substring(title.indexOf(w), title.indexOf(" ", title.indexOf(w))));
		
		// myPC ip 가져오기 
		 {
	        InetAddress ipAddress = InetAddress.getLocalHost();
	
	        System.out.println("현재 아이피 : " + ipAddress.getHostAddress());
	        System.out.println("현재 호스트명 : " + ipAddress.getHostName());
		}
		 
		String aaa = null;
		
		System.out.println(aaa);
		
	}

}
