package dao;
// fishdata table CRUD

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.FishDTO;

public class FishDAO {
	
	private String username="system";
	private String password="oracle";
	private String url="jdbc:oracle:thin:@//localhost:1521/ORCL";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	public static FishDAO fishdao = null; // 자기 자신의 객체 주소 변수
	
	private FishDAO() {
		init();
	}
	
	public static FishDAO getInstance() {
		if (fishdao == null) {
			fishdao = new FishDAO();
		}
		return fishdao;
	}
	private boolean conn() {
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("커넥션 자원 획득 성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void add(FishDTO fdto) {
		if (conn()) {
			try {
				String sql = "insert into fishdata values (?,?,default)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, fdto.getId());
				psmt.setString(2, fdto.getPwd());
				// 쿼리 실행
				// psmt.executeUpdate();
				// 퀴리 실행 리턴을 받아서 다음 처리 작업 정의
				int resultInt = psmt.executeUpdate();
				if (resultInt > 0) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	
	public void update(FishDTO fdto) {
		if (conn()) {
			try {
				String sql = "update fishdata set pwd=? where id=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, fdto.getPwd());
				psmt.setString(2, fdto.getId());
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	
	public void delete(String delID) {
		if (conn()) {
			try {
				String sql = "delete from fishdata where id=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, delID);
				 psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	
	public ArrayList<FishDTO> selectAll() {
		ArrayList<FishDTO> flist = new ArrayList<FishDTO>();
		if (conn()) {
			try {
				String sql = "select * from fishdata order by id desc";
				PreparedStatement psmt = conn.prepareStatement(sql);
				// Resultset은  테이블 형식으로 가져온다고 이해 합니다.
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					FishDTO fishTemp = new FishDTO();
					fishTemp.setId(rs.getString("id"));
					fishTemp.setPwd(rs.getString("pwd"));
					fishTemp.setIndate(rs.getString("indate"));
					flist.add(fishTemp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}

		return flist;
	}
	
	public FishDTO selectOne(String findID) {
		if (conn()) {
			try {
				String sql = "select * from fishdata where id=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, findID);
				ResultSet rs = psmt.executeQuery();
				if (rs.next()) {
					FishDTO fishTemp = new FishDTO();
					fishTemp.setId(rs.getString("id"));
					fishTemp.setPwd(rs.getString("pwd"));
					fishTemp.setIndate(rs.getString("indate"));
					return fishTemp;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
		return null;
	}
	
	private void init() {
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
