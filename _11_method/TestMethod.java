package _11_method;

public class TestMethod {
	// 생성자는 눈에 안 보인지만 생략되어 있음
	String name = null;

	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public String getName2(String pwd) {
		if (pwd.equals("1111")) {
			return name;
		} else {
			return null;
		}
	}
	
	// 이름뒤에 마스킹을 해 주는 메서드 만들기
	// 호출할 때 문자열로 마스킹 문자를 지정하면,
	// 이름뒤에 마스킹 문자를 연결하여 리턴한다
	// 메서드명은 maskName
	
	public String maskName(String mask) {
		String msskName = name.concat(mask);
		return msskName;
	}
}
