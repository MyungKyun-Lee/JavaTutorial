package service;

import dao_inf.DBdao;
import dao_inf.WordDAO;

public class WordService {
	DBdao worddao = new WordDAO();
	//WordDAO worddao= new WordDAO();
	public void menu() {
		add();
	}
	private void add() {
		//add 데이터베이스 Test
		String a ="test";  // DB작업
		worddao.add(a);
	}

}
