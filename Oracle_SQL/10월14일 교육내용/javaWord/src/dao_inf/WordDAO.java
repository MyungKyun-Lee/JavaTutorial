package dao_inf;

public class WordDAO implements DBdao{
	public WordDAO() {}
	@Override
	public void add(String d) {
		System.out.println("oracle + "+d);
	}
	@Override
	public String selectAll() {
		return null;
	}

}
