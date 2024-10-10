package Test;

public class MemberDTO {
	private String Id = null;
	private String Name = null;
	private String Addr = null;
	private Integer Age = 0;
	private Integer Point = 0;
	private String indate=null;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
}
