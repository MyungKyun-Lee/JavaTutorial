package service;

import java.util.ArrayList;
import java.util.Scanner;
import dao.ideaDAO;
import dto.ideaDTO;

public class ideaService {
	Scanner in = new Scanner(System.in);
	ideaDAO ideadao = ideaDAO.getInstance();
	
	public void menu() {
		while (true) {
			System.out.println();
			System.out.println("1. 아이디어 제안하기");
			System.out.println("2. 아이디어 수정하기");
			System.out.println("3. 아이디어 삭제하기");
			System.out.println("4. 아이디어 전체보기");
			System.out.println("5. 제목으로 검색하기");
			System.out.println("0. 종료");
			System.out.print("   선택 >>");
			
			String selNum = in.nextLine();
			if (selNum.equals("1")) {
				add();
			} else if (selNum.equals("2")) {
				update();
			} else if (selNum.equals("3")) {
				del();
			} else if (selNum.equals("4")) {
				list();
			} else if (selNum.equals("5")) {
				search();
			} else if (selNum.equals("0")) {
				break;
			} else {
				System.out.println("다시 입력해 주세요!");
			}
		}
		System.out.println("프로그램을 종료 합니다.");
	}
	
	private void add() {
		System.out.println("신규 idea 등록");
		System.out.print("아이디어 제목를 입력: ");
		String subject = in.nextLine();
		System.out.print("아이디어 내용을 입력: ");
		String content = in.nextLine();
		System.out.print("작성자를 입력: ");
		String writer = in.nextLine();

		// DTO 저장
		ideaDTO ideadto = new ideaDTO();
		ideadto.setSubject(subject);
		ideadto.setContent(content);
		ideadto.setWriter(writer);
		// DAO의 add메서드 호출하여 데이터베이스에 insert
		ideadao.add(ideadto);
	}
	
	private void update() {
		list();
		System.out.println("수정할 아이디어의 번호를 입력하세요");
		String findNum = in.nextLine();
		
		ideaDTO f = ideadao.selectNum(findNum);
		if (f != null) {
			System.out.println("수정할 정보는 다음과 같습니다.");
			System.out.println(f.toString());
			
			System.out.println("아이디어 제목를 수정하세요.");
			String editSubject = in.nextLine();
			f.setSubject(editSubject);
			
			System.out.println("아이디어 내용을 수정하세요.");
			String editcontent = in.nextLine();
			f.setContent(editcontent);
			ideadao.update(f);
		} else {
			System.out.println("없는 번호 입니다. 다시 입력하세요");
		}
	}
	
	private void del() {
		list();
		System.out.println("삭제할 아이디어의 번호를 입력하세요");
		String delNum = in.nextLine();
		ideadao.delete(delNum);
	}
	
	private void list() {
		ArrayList<ideaDTO> f = ideadao.selectAll();
		// DB에 저장된 정보를 모두 출력
		System.out.println(f.size()+" 건의 아이디어가 있습니다.");
		for (ideaDTO tempf : f) {
			System.out.println(tempf.toString());
		}
	}
	
	private void search() {
		System.out.println("검색할 제목을 입력하세요");
		String findSubject = in.nextLine();
		ideaDTO f = ideadao.selectOne(findSubject);
		if (f != null) {
			System.out.println(f.toString());
		} else {
			System.out.println("찾는 제목 없습니다. 다시 입력하세요");
		}
	}
}
