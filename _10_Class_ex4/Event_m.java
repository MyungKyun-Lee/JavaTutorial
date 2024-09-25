package _10_Class_ex4;

import java.util.Scanner;

public class Event_m {
	Scanner in = new Scanner(System.in);
	Customer_m eventCust_meg = null;
	
	Event_one[] Cust_eve_list = new Event_one[10];
	int tot_event_num=0;
	
	public void Event_menu() {
		while (true) {
			System.out.println("");
			System.out.println("---이벤트 관리메뉴---");
			System.out.println("1. 이벤트 등록");
			System.out.println("2. 이벤트 보기");
			System.out.println("3. 이벤트 수정");
			System.out.println("4. 이벤트 삭제");
			System.out.println("0. 이벤트관리 종료");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
			
			switch(selNum) {
			  case 1:
				  add();   break; // 등록
			  case 2:
				  serch(); break; // 조회
			  case 3:
				  mod();   break; // 수정
			  case 4:
				  dell();  break; // 삭제
			  case 0:
				  System.out.println(">>이벤트관리 종료<<");
			    break;
			  default:
				  System.out.println("메뉴 0~4 중 숫자만 입력하세요!");
			}
			if (selNum == 0) break;
			
		} // end while
	}
	
	public void add() {
		System.out.println("<이벤트 등록>");
		String temp_id=null;
		String temp_subject=null;
		String temp_content=null;
		int find_num =-1;
		
		System.out.print("고객 ID를 입력 하세요 :");
		do {
			temp_id = in.nextLine();
			find_num = eventCust_meg.find_cust(temp_id);
			if (find_num == -1) {
				System.out.println("등록된 ID가 아님니다! 다시입력해 주세요");
				System.out.print("고객 ID를 입력 하세요 :");
			}
		} while (find_num == -1);
		
		System.out.print("이벤트 제목를 입력 하세요 :");
		temp_subject = in.nextLine();
		System.out.print("이벤트 내용을 입력 하세요 :");
		temp_content = in.nextLine();
		
		Event_one event_o = new Event_one();
		event_o.id = temp_id;
		event_o.subject = temp_subject;
		event_o.content = temp_content;
		
		for (int i=0; i<Cust_eve_list.length; i++) {
			if (Cust_eve_list[i] == null) {
				Cust_eve_list[i]= event_o;
				tot_event_num++;
				break;
			}
		}
	}
	public void serch() {
		System.out.println("<이벤트 보기>");
		
		for (int i=0; i<Cust_eve_list.length; i++) {
			if (Cust_eve_list[i] != null) Cust_eve_list[i].prt();
		}
		System.out.println("----------조회된 총 이벤트는 "+tot_event_num+"건 입니다");
	}
	public void mod() {
		System.out.println("<이벤트 수정>");
		String temp_subject=null;
		String temp_content=null;
		
		System.out.print("이벤트 메목를 입력 하세요 :");
		temp_subject = in.nextLine();
		int find_num = find_event(temp_subject);
		if (find_num != -1) {
			System.out.print("수정할 이벤트 내용을 입력 하세요 :");
			temp_content = in.nextLine();
			Cust_eve_list[find_num].content = temp_content;
			Cust_eve_list[find_num].prt();
		}
	}
	public void dell() {
		System.out.println("<이벤트 삭제>");
		String temp_subject=null;
		
		System.out.print("이벤트 제목을 입력 하세요 :");
		temp_subject = in.nextLine();
		int find_num = find_event(temp_subject);
		if (find_num != -1) {
			Cust_eve_list[find_num] = null;
			tot_event_num--;
			System.out.println("등록된 이벤트제목 "+temp_subject+"가 삭제처리 되었습니다!");
		} else {
			System.out.println("삭제할 이벤트제목 "+temp_subject+"가 없습니다! 다시 확인하세요");
		}
	}
	
	public int find_event(String subject) {
		int ret=-1;
		for (int i=0; i<Cust_eve_list.length; i++) {
			if (Cust_eve_list[i] != null && Cust_eve_list[i].subject.equals(subject)) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}
