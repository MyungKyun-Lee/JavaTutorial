package _10_Class_Ex;

import java.util.Scanner;

// 고양이 관리 단일 책임을 부여 함
public class Cat_m {
	// 클래스 바로 안쪽이라서 멤버변수라고 함
	// 여기서 선언한 이유는 클래스 내부 어느곳에
	Cat_Obj[] clist = new Cat_Obj[5];
	
	Scanner in = new Scanner(System.in);
	Cat_m() {
		while (true) {
		System.out.println(" 고양이 관리자 ");
		System.out.println("1. 등록");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 전체보기");
		System.out.print("  선택 >>");
		
			int selNum = in.nextInt();
			in.nextLine();
			System.out.println(selNum+"번을 선택함");
			if (selNum == 1) {
				add(); // 메서드 호출
			} else if (selNum == 2) {
				del(); 
			} else if (selNum == 3) {
				
			} else if (selNum == 4) {
				allList(); // 메서드 호출
			} else {
				break;
			}
		}
	}
	
	public void add() {
		System.out.println("고양이 등록");
		//
		Cat_Obj cat = new Cat_Obj();
		System.out.print("고양이 이름을 입력 하세요 :");
		cat.name = in.nextLine();
		System.out.print("고양이 나이를 입력 하세요 :");
		cat.age = in.nextInt();
		in.nextLine();
		
		for (int i=0; i < clist.length; i++) {
			if (clist[i] == null) {
				clist[i] = cat;
				break;
			}
		}
	}
	public void allList() {
		System.out.println("고양이 전체보기");
		for (int i=0; i < clist.length; i++) {
			if (clist[i] != null) {
				clist[i].prt();
			}
		}
	}
	public void del() {
		System.out.println("고양이 삭제");
	}
}
