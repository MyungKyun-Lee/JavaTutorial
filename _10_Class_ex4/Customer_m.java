package _10_Class_ex4;

import java.util.Scanner;

public class Customer_m {
	Scanner in = new Scanner(System.in);
	Event_m CustEvent_meg = null;
			
	Customer_one[] Cust_list = new Customer_one[5];
	int tot_one_num=0;
	
	public void Customer_menu() {
		while (true) {
			System.out.println("");
			System.out.println("---고객 관리메뉴---");
			System.out.println("1. 고객가입");
			System.out.println("2. 정보보기");
			System.out.println("3. 수정하기");
			System.out.println("4. 삭제하기");
			System.out.println("5. 이벤트보기");
			System.out.println("0. 고객관리 종료");
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
			  case 5:
				  CustEvent_meg.serch(); break; // 삭제
			  case 0:
				  System.out.println(">>고객관리 종료<<");
			    break;
			  default:
				  System.out.println("메뉴 0~4 중 숫자만 입력하세요!");
			}
			if (selNum == 0) break;

		} // end while
	}
	
	public void add() {
		System.out.println("<고객가입>");
		String temp_id=null;
		String temp_name=null;
		
		if (tot_one_num >= Cust_list.length) {
			System.out.println("더이상 고객 가입할 수 없습니다!");
			return;
		}
		
		System.out.print("고객 ID를 입력 하세요 :");
		temp_id = in.nextLine();
		System.out.print("고객 name을 입력 하세요 :");
		temp_name = in.nextLine();
		
		int find_num = find_cust(temp_id);
		if (find_num == -1) {
			Customer_one cust_o = new Customer_one();
			cust_o.id = temp_id;
			cust_o.name = temp_name;
			
			for (int i=0; i<Cust_list.length; i++) {
				if (Cust_list[i] == null) {
					Cust_list[i]= cust_o;
					tot_one_num++;
					break;
				}
			}
		} else {
			System.out.println("["+temp_id +"] 아이디는 중복으로 가입할 수 없습니다!");
		}
		
	}
	public void serch() {
		System.out.println("<정보보기>");
		String temp_id=null;
		
		System.out.print("찾을 고객 ID를 입력 하세요(전체보기 *로 입력) :");
		temp_id = in.nextLine();
		if (temp_id != null && temp_id.equals("*")) {
			for (int i=0; i<Cust_list.length; i++) {
				if (Cust_list[i] != null) Cust_list[i].prt();
			}
			System.out.println("----------조회된 총 고객수는 "+tot_one_num+"명 입니다");
		} else {
			int find_num = find_cust(temp_id);
			if (find_num != -1)	{
				Cust_list[find_num].prt();
				for (int i=0; i<CustEvent_meg.Cust_eve_list.length; i++) {
					if (CustEvent_meg.Cust_eve_list[i] != null)
						CustEvent_meg.Cust_eve_list[i].prt();
				}
				System.out.println("----------조회된 고객 입니다.");
			}
			else {
				System.out.println("----------조회된 고객 없습니다.");
			}
		}
		
	}
	public void mod() {
		System.out.println("<수정하기>");
		String temp_id=null;
		String temp_name=null;
		
		if (tot_one_num == 0) {
			System.out.println("등록된 고객이 없어서 수정할 수 없습니다!");
			return;
		}
		
		System.out.print("고객 ID를 입력 하세요 :");
		temp_id = in.nextLine();
		int find_num = find_cust(temp_id);
		if (find_num != -1) {
			System.out.print("수정할 고객 name을 입력 하세요 :");
			temp_name = in.nextLine();
			Cust_list[find_num].name = temp_name;
			Cust_list[find_num].prt();
		}
	}
	public void dell() {
		System.out.println("<삭제하기>");
		String temp_id=null;
		
		if (tot_one_num == 0) {
			System.out.println("등록된 고객이 없어서 삭제할 수 없습니다!");
			return;
		}
		
		System.out.print("고객 ID를 입력 하세요 :");
		temp_id = in.nextLine();
		int find_num = find_cust(temp_id);
		if (find_num != -1) {
			Cust_list[find_num] = null;
			tot_one_num--;
			System.out.println("등록된 고객ID "+temp_id+"가 삭제처리 되었습니다!");
		} else {
			System.out.println("삭제할 고객ID "+temp_id+"가 없습니다! 다시 확인하세요");
		}
	}
	
	public int find_cust(String id) {
		int ret=-1;
		for (int i=0; i<Cust_list.length; i++) {
			if (Cust_list[i] != null && Cust_list[i].id.equals(id)) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}
