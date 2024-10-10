package MyFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MyFoodADM {
	Scanner in = new Scanner(System.in);
	Connection conn = null;
	int k=0;

	public MyFoodADM() {
		init();		// 드라이버 로드는 1번만 하면 되므로 생성자에서 작업
		menu();
	}
	
	private void init() {
		// 오라클 드라이버 로드 코딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드 성공");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void menu() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL","system","oracle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			System.out.println();
			System.out.println("1. 음식추가");
			System.out.println("2. 음식삭제");
			System.out.println("3. 음식수정");
			System.out.println("4. 음식전체보기");
			System.out.println("0. 종료");	
			System.out.print("  선택 >>");
			
			String num = in.nextLine();
			if(num.equals("1")) {
				insertFood();
			} else if(num.equals("2")) {
				deleteFood();
			} else if(num.equals("3")) {
				modifyFood();
			} else if(num.equals("4")) {
				listFood();
			} else if(num.equals("0")) {
				break;
			} else {
				System.out.println("선택 번호를 잘못 입력하셨습니다!");
			}
		}
		System.out.println("종료!");
		if (conn != null) {
			try {
				conn.close();  // 자원 반납
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}		
	} // menu 종료
	
	private void insertFood() {
		k++;
		MyFoodDTO mf = new MyFoodDTO();
		mf.setFoodId("f0"+k);
		mf.setFoodName("apple");
		mf.setFoodNum(k);

		String sql="insert into myfood values(?,?,?,default)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mf.getFoodId());
			pstmt.setString(2, mf.getFoodName());
			pstmt.setInt(3, mf.getFoodNum());
			// 실행후 리턴 값 가져오기
			int result = pstmt.executeUpdate();
			if (result == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteFood() {
		MyFoodDTO mf = new MyFoodDTO();
		mf.setFoodId("f01");
		
		String sql="delete from myfood where foodid=? ";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mf.getFoodId());
			// 실행후 리턴 값 가져오기
			int result = pstmt.executeUpdate();
			if (result == 1) {
				conn.rollback();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void modifyFood() {
		MyFoodDTO mf = new MyFoodDTO();
		mf.setFoodId("f02");
		mf.setFoodName("banana");
		
		String sql="update myfood set foodname =? where foodid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mf.getFoodName());
			pstmt.setString(2, mf.getFoodId());
			// 실행후 리턴 값 가져오기
			int result = pstmt.executeUpdate();
			if (result == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listFood() {
		MyFoodDTO mf = new MyFoodDTO();
		
		String sql="select * from myfood";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			// 실행후 리턴 값 가져오기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
//				System.out.print("foodId : " + rs.getString("foodid") +" ");
//				System.out.print("foodName : " + rs.getString("foodname") +" ");
//				System.out.print("foodnum : " + rs.getInt("foodnum") +" ");
//				System.out.println("indate : " + rs.getString("indate") +" ");
				mf.setFoodId(rs.getString("foodid"));
				mf.setFoodName(rs.getString("foodname"));
				mf.setFoodNum(rs.getInt("foodnum"));
				mf.setIndate(rs.getString("indate"));
				mf.prt();
				System.out.println("====================================");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
