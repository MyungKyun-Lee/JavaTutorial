package _01Array;

class _02_IF {

	public static void main(String[] args) {
		// 조건문
		// 이름 나이 성적
		String h_name = "Kim";
		int age = 20;
		int grade = 69;
		String h_grade = "";
		
		if(age >= 18) {
			if (grade > 90) {
				h_grade = "A";
			} else if (grade > 80) {
				h_grade = "B";
			} else if (grade > 70) {
				h_grade = "C";
			} else if (grade > 60) {
				h_grade = "D";
				h_name += "*";
			} else {
				h_grade = "F";
			}
			System.out.println("이름: "+h_name+" 나이: "+age+" 성적: "+grade+"("+h_grade+")");

		} else {
			System.out.println("18세 미만은 수강신청 불가");
		}

	}

}
