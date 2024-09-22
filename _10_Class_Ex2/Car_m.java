package _10_Class_Ex2;

import java.util.Scanner;

public class Car_m {
	Car_Obj[] clist = new Car_Obj[7];
	int total_car_num = 0;
	
	Scanner in = new Scanner(System.in);
	public Car_m() {
		while (true) {
			System.out.println("");
			System.out.println("---주차등록 관리---");
			System.out.println("1. 등록");
			System.out.println("2. 조회");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 전체보기");
			System.out.println("0. 프로그램 종료");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
			in.nextLine();

			if (selNum == 1) {
				add();   // 등록
			} else if (selNum == 2) {
				serch(); // 조회
			} else if (selNum == 3) {
				mod();   // 수정
			} else if (selNum == 4) {
				dell();  // 삭제
			} else if (selNum == 5) {
				allList(); // 전체보기
			} else if (selNum == 0) {
				break;
			}
		}
		in.close();
	}
	public void add() {
		System.out.println("<주차 등록>");
		
		if (total_car_num >= clist.length) 
			System.out.println("더이상 주차공간이 없습니다!");
		else {
			Car_Obj car = new Car_Obj();
			System.out.print("차번호를 입력 하세요 :");
			car.car_no = in.nextInt();
			in.nextLine();
			System.out.print("소유자를 입력 하세요 :");
			car.car_owner = in.nextLine();
			
			for (int i=0; i < clist.length; i++) {
				if (clist[i] == null) {
					clist[i] = car;
					total_car_num++;
					break;
				}
			}
		}
	}
	public void serch() {
		System.out.println("<주차 조회>");
		
		if (total_car_num == 0) 
			System.out.println("등록된 차번호가 없습니다!");
		else {
			System.out.print("차번호를 입력 하세요 :");
			int carNo = in.nextInt();
			in.nextLine();
			
			int serch_cnt=0;
			for (int i=0; i < clist.length; i++) {
				if (clist[i] != null && clist[i].car_no == carNo) {
					clist[i].prt();
					System.out.println("입력한 차번호를 조회 하였습니다!");
					serch_cnt++;
					break;
				}
			}
			if (serch_cnt == 0) System.out.println("맞는 차번호가 없습니다!");
		}
	}
	public void mod() {
		System.out.println("<주차 수정>");
		
		if (total_car_num == 0) 
			System.out.println("등록된 차번호가 없습니다!");
		else {
			System.out.print("차번호를 입력 하세요 :");
			int carNo = in.nextInt();
			in.nextLine();
			
			int serch_cnt=0;
			int new_car_no=0;
			String new_car_owner=null;
			for (int i=0; i < clist.length; i++) {
				if (clist[i] != null && clist[i].car_no == carNo) {
					clist[i].prt();
					
					System.out.print("수정할 차번호를 입력 하세요 :");
					new_car_no = in.nextInt();
					clist[i].car_no = new_car_no;
					in.nextLine();
					System.out.print("수정할 소유자를 입력 하세요 :");
					new_car_owner = in.nextLine();
					clist[i].car_owner = new_car_owner;
					
					serch_cnt++;
					break;
				}
			}
			if (serch_cnt == 0) System.out.println("맞는 차번호가 없습니다!");
		}
	}
	public void allList() {
		System.out.println("<주차 전체보기>");
		
		if (total_car_num == 0) 
			System.out.println("등록된 차번호가 없습니다!");
		else {
			for (int i=0; i < clist.length; i++) {
				if (clist[i] != null) {
					clist[i].prt();
				}
			}
			System.out.println("----------동록된 총 차량수는 "+total_car_num+"대 있습니다");
		}
	}
	public void dell() {
		System.out.println("<주차 삭제>");
		
		if (total_car_num == 0) 
			System.out.println("등록된 차번호가 없습니다!");
		else {
			System.out.print("차번호를 입력 하세요 :");
			int carNo = in.nextInt();
			in.nextLine();
			
			int serch_cnt=0;
			for (int i=0; i < clist.length; i++) {
				if (clist[i] != null && clist[i].car_no == carNo) {
					clist[i].prt();
					System.out.println("입력한 차번호가 삭제 되었습니다!");
					
					clist[i] = null;
					total_car_num--;
					serch_cnt++;
					break;
				}
			}
			if (serch_cnt == 0) System.out.println("맞는 차번호가 없습니다!");
		}
	}
}
