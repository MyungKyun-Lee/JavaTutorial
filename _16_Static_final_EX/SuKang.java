package _16_Static_final_EX;

import java.util.ArrayList;

import _13_Arraylist_Ex2.CarParkingOne;

public class SuKang {
	ArrayList<Student> stuList = new ArrayList<>();
	ArrayList<Subject> subList = new ArrayList<>();
	
	final int maxStudent = 10;
	
	public void menuStudent() {
		while(true) {
			System.out.println();
			System.out.println("1. 학생등록");
			System.out.println("2. 학생조회");
			System.out.println("3. 학생삭제");
			System.out.println("4. 학생전체조회");
			System.out.println("0. 학생관리 종료");	
			System.out.print("  선택 >>");
			
			String num = Main.in.nextLine();
			if(num.equals("1")) {
				addStudent();
			} else if(num.equals("2")) {
				serchStudent();
			} else if(num.equals("3")) {
				delStudent();
			} else if(num.equals("4")) {
				prtStudent();
			} else if(num.equals("0")) {
				break;
			} else {
				System.out.println("선택 번호를 잘못 입력하셨습니다!");
			}
		}
	}	// 학생관리 메뉴
	
	public void menuSubject() {
		while(true) {
			System.out.println();
			System.out.println("1. 과목등록");
			System.out.println("2. 과목수정");
			System.out.println("3. 과목전체조회");
			System.out.println("0. 과목관리 종료");	
			System.out.print("  선택 >>");
			
			String num = Main.in.nextLine();
			if(num.equals("1")) {
				addSubject();
			} else if(num.equals("2")) {
				modSubject();
			} else if(num.equals("3")) {
				prtSubject();
			} else if(num.equals("0")) {
				break;
			} else {
				System.out.println("선택 번호를 잘못 입력하셨습니다!");
			}
		}
	}	// 교과목관리 메뉴
	
	public void menuSuKang() {
		System.out.print("학생 ID를 입력하세요 :");
		String temp_id = Main.in.nextLine();
		
		int stuidx = findID(temp_id);
		if (stuidx != -1) {
		
			while(true) {
				System.out.println();
				System.out.println("1. 수강신청");
				System.out.println("2. 신청리스트");
				System.out.println("3. 학생 전체리스트");
				System.out.println("0. 수강신청 종료");	
				System.out.print("  선택 >>");
				
				String num = Main.in.nextLine();
				if(num.equals("1")) {
					addSuKang(stuidx);
				} else if(num.equals("2")) {
	//				serchCar();
				} else if(num.equals("3")) {
	//				delCar();
				} else if(num.equals("0")) {
					break;
				} else {
					System.out.println("선택 번호를 잘못 입력하셨습니다!");
				}
			}
		} else {
			System.out.println("찾는 학생 ID가 없습니다! 다시 입력해 주세요.");
		}
	}	// 수강신청관리 메뉴
	
	// -----------------------------------------------------------------
	// 학생 ID 찾기 (리턴값 -1이면 중복 없음)
	private int findID(String id) {
		int ret = -1;
    	for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getSt_id().equals(id)) {
				ret = i;
				break;
			}
		}
    	return ret;
	}
	
	public void addStudent() {
		System.out.println();
		System.out.println("<학생등록>");
		
		Student stuOne = new Student();
		if (stuOne.currentStudentNum <= maxStudent) {
			
			System.out.print("학생 ID를 입력하세요 :");
			String temp_id = Main.in.nextLine();
			
			// 등록된 ID를 조회하여 index 값을 리턴한다.
			int stuidx = findID(temp_id);
			if (stuidx == -1) {
				stuOne.setSt_id(temp_id);
				
				System.out.print("이름을 입력하세요 :");
				String temp_name = Main.in.nextLine();
				stuOne.setSt_name(temp_name);
				System.out.print("전화번호를 입력하세요 :");
				String temp_tel = Main.in.nextLine();
				stuOne.setSt_tel(temp_tel);
				System.out.print("학년을 입력하세요 :");
				String temp_grade = Main.in.nextLine();
				stuOne.setSt_grade(Integer.parseInt(temp_grade));
				stuOne.currentStudentNum++;
				
				stuList.add(stuOne);
			} else {
				System.out.println("동일한 학생 ID가 있습니다! 다시 입력해 주세요.");
			}
		} else {
			System.out.println("학생수가 10명이 넘어서 더이상 등록할 수 없습니다!!");
		}
	}
	
	public void serchStudent() {
		System.out.println();
		System.out.println("<학생조회>");

		// 이름으로 검색 루틴
		System.out.print("이름을 입력하세요 :");
		String temp_name = Main.in.nextLine();
		
		for(int i=0; i<stuList.size();i++) {
			if(stuList.get(i).getSt_name().indexOf(temp_name) != -1) {
				stuList.get(i).prt(); // 동일 이름이 계속 출력하도록 break 사용안함.
			}
		}
	}
	
	public void delStudent() {
		System.out.println();
		System.out.println("<학생삭제>");
		
		System.out.print("학생 ID를 입력하세요 :");
		String temp_id = Main.in.nextLine();
		
		// 등록된 ID를 조회하여 index 값을 리턴한다.
		int stuidx = findID(temp_id);
		if (stuidx != -1) {
			stuList.get(stuidx).currentStudentNum--;
			stuList.remove(stuidx);
		} else {
			System.out.println("찾는 학생 ID가 없습니다! 다시 입력해 주세요.");
		}
	}
	
	public void prtStudent() {
		System.out.println();
		System.out.println("<학생전체조회>");
		
		int tot_cnt = 0;
		for (Student one : stuList) {
			one.prt();
			tot_cnt++;
		}
    	System.out.println("등록된 총 학생은 :"+tot_cnt+"명 입니다.");
	}

	// -----------------------------------------------------------------
	// 교과목 찾기 (리턴값 -1이면 중복 없음)
	private int findSub(String name) {
		int ret = -1;
    	for (int i = 0; i < stuList.size(); i++) {
			if (subList.get(i).getSub_name().equals(name)) {
				ret = i;
				break;
			}
		}
    	return ret;
	}
		
	public void addSubject() {
		System.out.println();
		System.out.println("<과목등록>");
		
		System.out.print("과목을 입력하세요 :");
		String temp_name = Main.in.nextLine();
		
		// 등록된 ID를 조회하여 index 값을 리턴한다.
    	int subidx = findSub(temp_name);
    	System.out.println(subidx);
    	if (subidx == -1) {
    		Subject subOne = new Subject();
    		subOne.setSub_name(temp_name);
    		
    		System.out.print("강의실를 입력하세요 :");
    		String temp_room = Main.in.nextLine();
    		subOne.setSub_room(temp_room);
    		System.out.print("담당교수를 입력하세요 :");
    		String temp_techer = Main.in.nextLine();
    		subOne.setSub_techer(temp_techer);
    		
    		subList.add(subOne);
    	} else {
    		System.out.println("동일한 과목이 있습니다! 다시 입력해 주세요.");
    	}
	}
	
	public void modSubject() {
		System.out.println();
		System.out.println("<과목수정>");
		
		// 과목 수정내용 입력
	}
	
	public void prtSubject() {
		System.out.println();
		System.out.println("<과목전체조회>");
		
		int tot_cnt = 0;
		for (Subject one : subList) {
			one.prt();
			tot_cnt++;
		}
    	System.out.println("등록된 총 과목은 :"+tot_cnt+"건 입니다.");
	}
	
	// -----------------------------------------------------------------수강신청
	public void addSuKang(int Student_idx) {
		System.out.println();
		System.out.println("<수강신청>");
		
		// 수강신청할 과목 리스트 표시
		for (Subject one : subList) {
			System.out.print(one.hashCode()+": ");
			one.prt();
		}
		
		System.out.println(stuList.get(Student_idx).getSt_name());
	}
	
}
