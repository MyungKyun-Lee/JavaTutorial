package dto;

public class ClientDTO {
	String user_id = null;		// 고객ID
	String user_pw = null;		// 고객PW
	String user_name = null;	// 고객명
	int    user_age = 0;		// 고객나이
	String user_tel = null;		// 고객전화
	String age_id = null;		// 나이구분
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getAge_id() {
		return age_id;
	}
	public void setAge_id(String age_id) {
		this.age_id = age_id;
	}
	
	
}
