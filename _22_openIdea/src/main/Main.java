package main;

import service.ideaService;

public class Main {

	public static void main(String[] args) {
		System.out.println("open Idea Info");
		ideaService ois = new ideaService();
		ois.menu();
		
	}

}
