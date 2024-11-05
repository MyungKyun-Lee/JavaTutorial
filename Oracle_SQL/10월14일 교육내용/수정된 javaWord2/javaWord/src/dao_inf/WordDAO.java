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
		ArrayList<WordDTO> w =new ArrayList<WordDTO>();
		WordDTO temp = new WordDTO();
		temp.setEng("apple");
		temp.setKor("사과");
		w.add(temp);
		temp = new WordDTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);
		// TODO Auto-generated method stub
		return w;
	}

	@Override
	public void mod(WordDTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("수정 : "+wdto.getEng()+"/"+wdto.getKor());
	}

	@Override
	public void delete(WordDTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("삭제 : "+wdto.getEng());
	}
	

}
