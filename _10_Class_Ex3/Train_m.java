package _10_Class_Ex3;

import java.util.Scanner;

public class Train_m {
	String[] train_no = {"1111","2222","3333","4444"};
	String[] train_ty = {"무궁화","새마을","무궁화","새마을"};
	
	Train_Info[] tr_info = new Train_Info[4];
	int total_tr_num=0;
	
	Scanner in = new Scanner(System.in);
	public Train_m() {
		while (true) {
			System.out.println("");
			System.out.println("---기차 시간표 관리메뉴---");
			System.out.println("1. 등록");
//			System.out.println("2. 조회");
			System.out.println("3. 수정");
//			System.out.println("4. 삭제");
			System.out.println("5. 전체보기");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------");
			System.out.println("6. 수리정보");
			System.out.println("7. 수리정보입력");
			System.out.println("-------------");
			System.out.print("  선택 >>");
			
			String selectMenu = in.nextLine();
			int selNum = Integer.parseInt(selectMenu);
//			in.nextLine();
			
			switch(selNum) {
			  case 1:
				  add();   // 등록
			    break;
			  case 2:
//				  serch(); // 조회
			    break;
			  case 3:
				  mod();   // 수정
			    break;
			  case 4:
//				  dell();  // 삭제
			    break;
			  case 5:
				  allList(); // 전체보기
			    break;
			  case 6:
				  fixList(); // 수리정보
			    break;
			  case 7:
				  fix(); // 수리정보입력
			    break;
			  case 0:
			    break;
			  default:
				  System.out.println("메뉴 0~7 중 숫자만 입력하세요!");
			}
			if (selNum == 0) {
				System.out.println("프로그램을 종료 합니다!");
				break;
			}
		}
	}
	
	public void add() {
		System.out.println("<기차 등록>");

		String temp_no=null;
		String temp_ty=null;
		String temp_time=null;
		
		System.out.print("기차번호를 입력 하세요 :");
		temp_no = in.nextLine();
		for (int i=0; i<train_no.length; i++ ) {
			if (temp_no.equals(train_no[i])) {
				System.out.print("기차시간을 입력 하세요 :");
				temp_time = in.nextLine();
				temp_ty = train_ty[i];
				break;
			}
		}
		
		if (temp_ty != null) {
			Train_Info tr_one = new Train_Info();
			tr_one.tr_no = 		 temp_no;
			tr_one.tr_type = 	 temp_ty;
			tr_one.tr_arr_time = temp_time;
			tr_one.tr_fix_yn = "N";
			
			for (int i=0; i < tr_info.length; i++) {
				if (tr_info[i] == null) {
					tr_info[i] = tr_one;
					total_tr_num++;
					break;
				}
			}
			
		} else {
			System.out.println("기차번호가 존재하지 않아서 등록할 수 없습니다!");
		}
	} // end add()
	
	public void mod() {
		System.out.println("<기차 수정>");
		String temp_no=null;
		String temp_time=null;
		
		if (total_tr_num == 0) 
			System.out.println("등록된 기차가 없습니다!");
		else {
			System.out.print("기차번호를 입력 하세요 :");
			temp_no = in.nextLine();
			for (int i=0; i<tr_info.length; i++ ) {
				if (temp_no.equals(tr_info[i].tr_no)) {
					System.out.print("기차시간을 입력 하세요 :");
					temp_time = in.nextLine();
					
					tr_info[i].tr_arr_time = temp_time;
					tr_info[i].tr_fix_yn = "N";
					tr_info[i].prt2();
					break;
				}
			}
			if (temp_time == null) System.out.println("기차번호가 존재하지 않아서 수정할 수 없습니다!");
		}
	} // end mod()
	
	public void allList() {
		System.out.println("<기차 전체보기>");
		int tot_cnt=0;
		
		if (total_tr_num == 0) 
			System.out.println("등록된 기차가 없습니다!");
		else {
			for (int i=0; i < tr_info.length; i++) {
				if (tr_info[i] != null && tr_info[i].tr_fix_yn.equals("N")) {
					if (tr_info[i].tr_type.equals("새마을")) { 
						tr_info[i].prt2();
					} else {
						tr_info[i].prt();
					}
					tot_cnt++;
				}
			}
			System.out.println("----------조회된 총 기차수는 "+tot_cnt+"개 입니다");
		}
	}  // end allList()
	
	public void fix() {
		System.out.println("<기차 수리 입력>");
		String temp_no=null;
		String temp_fix=null;
		
		if (total_tr_num == 0) 
			System.out.println("등록된 기차가 없습니다!");
		else {
			System.out.print("수리할 기차번호를 입력 하세요 :");
			temp_no = in.nextLine();
			for (int i=0; i<tr_info.length; i++ ) {
				if (tr_info[i] != null && temp_no.equals(tr_info[i].tr_no)) {
					temp_fix = "Y";
					tr_info[i].tr_fix_yn = temp_fix;
					tr_info[i].prt3();
					break;
				}
			}
			if (temp_fix == null) System.out.println("기차번호가 존재하지 않아서 수정할 수 없습니다!");
		}
	} // end fix()
	
	public void fixList() {
		System.out.println("<수리 기차 전체보기>");
		int fix_cnt=0;
		
		if (total_tr_num == 0) 
			System.out.println("등록된 기차가 없습니다!");
		else {
			for (int i=0; i < tr_info.length; i++) {
				if (tr_info[i] != null) {
					if (tr_info[i].tr_fix_yn.equals("Y")) { 
						tr_info[i].prt3();
						fix_cnt++;
					}
				}
			}
			System.out.println("----------수리중 기차수는 "+fix_cnt+"개 입니다");
		}
	} // end fixList()

}
