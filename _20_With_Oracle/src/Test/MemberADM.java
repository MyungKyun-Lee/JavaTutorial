package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberADM {
	// ojdb6 으로 개발하는 순서
	// 1. 드라이버로드 1번만 하면됨다
	// 2. CRUD 작업이 있을때 마다 다음 과정을 생각한다
	// 	2-1. 커넥션 가여오기
	//	2-2. 쿼리문 만들기
	//  2-3. 퀴리문 완성하기(Mapping)
	//  2-4. 퀴리문 전송하여 오라클에서 실행
	//  2-5. 오라클에서 리턴값 전송
	//  2-6. 자바에서 2-5에서 받은 리턴값 처리
	//  2-7. 커넥션 자원 반납 (중요)

	//	private static final String DriverMager = null;
	MemberADM() {
		init();		// 드라이버 로드는 1번만 하면 되므로 생성자에서 작업
		insert();
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
	private void insert() {
		MemberDTO m = new MemberDTO();
		m.setId("a");
		m.setName("kim");
		m.setAge(32);
		// DTO 객체를 만들어음.. 오라클에 저장해 보자
		// 2-1. 컨텍션 자원 가져오기
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL","system","oracle");
//			Connection conn = DriverManager.getConnection("jdbc:oracle:this:@localhost:orcl","system","oracle");
			System.out.println("오라클 드라이버 로드 성공");
			String sql="insert into memberone values(?,?,?,default)";
			// 매핑
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setInt(3, m.getAge());
			// 실행후 리턴 값 가져오기
			int result = pstmt.executeUpdate();
			if (result == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();  // 자원 반납
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
