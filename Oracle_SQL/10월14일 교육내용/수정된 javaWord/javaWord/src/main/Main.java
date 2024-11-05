package main;

import dao_inf.DBdao;
import dao_inf.WordDAO;
import service.WordMainFrame;
import service.WordService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		DBdao dao = new WordDAO();
		WordMainFrame ws = new WordMainFrame(dao);

	}

}
