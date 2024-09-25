package _11_method;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMethod t = new TestMethod();
		System.out.println(t.name);
		t.setName("hong");
		System.out.println(t.name);
		
		String resultName = t.getName2("1122");
		if (resultName != null) {
			System.out.println(resultName);
		} else {
			System.out.println("비범틀림");
		}
		
		String ret = t.maskName("***");
		System.out.println(ret);
		System.out.println(t.name);
	}

}
