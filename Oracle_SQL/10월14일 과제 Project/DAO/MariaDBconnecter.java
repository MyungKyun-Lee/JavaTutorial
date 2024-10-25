package dao_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBconnecter {
	public Connection conn = null;
	private String username="root";
	private String password="1111";
	private String url="jdbc:mariadb://localhost:3306/myproject";
	private String driverName="org.mariadb.jdbc.Driver";
	
	// 싱클톤 디자인 코딩 시작
		public static MariaDBconnecter traindao = null; // 자기 자신의 객체 주소 변수
		
		public MariaDBconnecter() {
			init();
		}
		public static MariaDBconnecter getInstance() {
			if (traindao == null) {
				traindao = new MariaDBconnecter();
			}
			return traindao;
		}
		public boolean conn() {
			try {
				conn = DriverManager.getConnection(url,username,password);
//				System.out.println("커넥션 자원 획득 성공");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("커넥션 자원 획득 실패");
			}
			return false;
		}
		
		private void init() {
			try {
				Class.forName(driverName);
				System.out.println("mySQL 드라이버 로드 성공");
				
			} catch(ClassNotFoundException e) {
				System.out.println("mySQL 드라이버 로드 실패");
				e.printStackTrace();
			}
		}
}
