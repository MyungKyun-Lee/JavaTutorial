package _16_Static_final_EX;

import java.util.ArrayList;

public class Student {
	static int currentStudentNum = 0;
	ArrayList<Subject> mysubList = new ArrayList<>();
	
	private String st_id = null;   // 학생ID
	private String st_name = null; // 학생이름
	private String st_tel = null;  // 학생전화
	private int st_grade = 0;      // 학년
	
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_tel() {
		return st_tel;
	}
	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}
	public int getSt_grade() {
		return st_grade;
	}
	public void setSt_grade(int st_grade) {
		this.st_grade = st_grade;
	}
	
	public void prt() {
		System.out.println("학생ID["+st_id+"] 학생이름["+st_name+"] 학생전화["+st_tel+"]"+" 학년["+st_grade+"]");
	}
}
