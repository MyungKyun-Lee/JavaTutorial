package dao_inf;

import java.util.ArrayList;

import dto.WordDTO;

public class WordDAO implements DBdao{
	
	//Dao 작업 필요
	
	public WordDAO() {}

	@Override
	public void add(WordDTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("insert : "+wdto.getEng());
	}

	@Override
	public ArrayList<WordDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
