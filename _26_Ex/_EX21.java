package _26_Ex;

public class _EX21 {

	public static void main(String[] args) {
		String id = "human01";
		
		for (int i=0; i<id.length(); i++)
			System.out.println(id.charAt(i));
	}

	public int returnLength(String v_text) {
		int ret = v_text.length();
		return ret;
	}
}
