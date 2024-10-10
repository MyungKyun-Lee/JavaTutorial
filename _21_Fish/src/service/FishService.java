package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FishDAO;
import dto.FishDTO;

public class FishService {
	// Fishdata 테이블에 데이터를 입력하기 위해서는 FishDao 객체에 의존한다.
	FishDAO fishdao = FishDAO.getInstance();
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 전체보기");
			System.out.println("5. 자세히보기");
			System.out.println("6. 종료");
			
			int selNum = in.nextInt(); in.nextLine();
			if (selNum == 1) {
				add();
			} else if (selNum == 2) {
				update();
			} else if (selNum == 3) {
				del();
			} else if (selNum == 4) {
				list();
			} else if (selNum == 5) {
				search();
			} else if (selNum == 6) {
				break;
			} else {
				System.out.println("다시 입력해 주세요!");
			}
		}
	}

	private void add() {
		Scanner in = new Scanner(System.in);
		boolean checkin = false;
		String pass = null;
		
		System.out.println("신규 Fish 등록");
		System.out.println("아이디를 입력");
		String id = in.nextLine();
		do {
			System.out.println("암호를 4자리 이하로 다시 입력해 주세요");
			pass = in.nextLine();
		} while (pass.length() > 4);

			// DTO 저장
			FishDTO fishdto = new FishDTO();
			fishdto.setId(id);
			fishdto.setPwd(pass);
			// DAO의 add메서드 호출하여 데이터베이스에 insert
			fishdao.add(fishdto);

	}
	
	private void update() {
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요");
		String findId = in.nextLine();
		FishDTO f = fishdao.selectOne(findId);
		if (f != null) {
			System.out.println("수정할 정보는 다음과 같습니다.");
			System.out.println(f.toString());
			
			System.out.println("비밀번호를 수정하세요.");
			String delPass = in.nextLine();
			// 
			f.setPwd(delPass);
			fishdao.update(f);
		} else {
			System.out.println("없는 아이디 입니다. 다시 입력하세요");
		}
	}

	private void del() {
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하세요");
		String delId = in.nextLine();
		fishdao.delete(delId);
	}

	private void list() {
		ArrayList<FishDTO> f = fishdao.selectAll();
		// DB에 저장된 정보를 모두 출력
		System.out.println(f.size()+" 마리의 물고기가 있습니다.");
		for (FishDTO tempf : f) {
			System.out.println(tempf.toString());
		}
	}

	private void search() {
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 아이디를 입력하세요");
		String findID = in.nextLine();
		FishDTO f = fishdao.selectOne(findID);
		if (f != null) {
			System.out.println(f.toString());
		} else {
			System.out.println("없는 아이디 입니다. 다시 입력하세요");
		}
	}
}
