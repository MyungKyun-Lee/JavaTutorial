package _26_Ex;

public class Test {

	public static int returnLength(String v_text) {
		int ret = v_text.length();
		return ret;
	}
	
	public static void main(String[] args) {
		String a = "human";
		
		int b = returnLength(a);
		System.out.println(b);
	}
}
