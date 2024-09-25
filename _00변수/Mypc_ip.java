package _00변수;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Mypc_ip {

	public static void main(String[] args) throws UnknownHostException {
		// 사용하는 pc의 이름 및 ip 보기
		// myPC ip 가져오기 
		 {
	        InetAddress ipAddress = InetAddress.getLocalHost();
	
	        System.out.println("현재 아이피 : " + ipAddress.getHostAddress());
	        System.out.println("현재 호스트 : " + ipAddress.getHostName());
		}

	}

}
