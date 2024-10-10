package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ideaDTO;

public class ideaDAO {
	
	private Connection conn = null;
	private String username="system";
	private String password="oracle";
	private String url="jdbc:oracle:thin:@//localhost:1521/ORCL";
	private String driverName="oracle.jdbc.driver.OracleDriver";
	public static ideaDAO ideadao = null; // 자기 자신의 객체 주소 변수
	
	public ideaDAO() {
		init();
	}
	public static ideaDAO getInstance() {
		if (ideadao == null) {
			ideadao = new ideaDAO();
		}
		return ideadao;
	}
	private boolean conn() {
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("커넥션 자원 획득 성공");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void add(ideaDTO idto) {
		if (conn()) {
			try {
				String sql = "insert into openidea values(num.nextval,?,?,?,default)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, idto.getSubject());
				psmt.setString(2, idto.getContent());
				psmt.setString(3, idto.getWriter());
				// 쿼리 실행
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
	
	public void update(ideaDTO idto) {
		if (conn()) {
			try {
				String sql = "update openidea set subject=?, content=?, indate=default where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, idto.getSubject());
				psmt.setString(2, idto.getContent());
				psmt.setInt(3, idto.getNum());
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
	
	public void delete(String delNum) {
		if (conn()) {
			try {
				String sql = "delete from openidea where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, delNum);
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
	
	public ArrayList<ideaDTO> selectAll() {
		ArrayList<ideaDTO> flist = new ArrayList<ideaDTO>();
		if (conn()) {
			try {
				String sql = "select * from openidea order by num";
				PreparedStatement psmt = conn.prepareStatement(sql);
				// Resultset은  테이블 형식으로 가져온다고 이해 합니다.
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					ideaDTO ideaTemp = new ideaDTO();
					ideaTemp.setNum(rs.getInt("num"));
					ideaTemp.setSubject(rs.getString("subject"));
					ideaTemp.setContent(rs.getString("content"));
					ideaTemp.setWriter(rs.getString("writer"));
					ideaTemp.setIndate(rs.getString("indate"));
					flist.add(ideaTemp);
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
	
	public ideaDTO selectNum(String findNum) {
		if (conn()) {
			try {
				String sql = "select * from openidea where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, findNum);
				ResultSet rs = psmt.executeQuery();
				if (rs.next()) {
					ideaDTO ideaTemp = new ideaDTO();
					ideaTemp.setNum(rs.getInt("num"));
					ideaTemp.setSubject(rs.getString("subject"));
					ideaTemp.setContent(rs.getString("content"));
					ideaTemp.setWriter(rs.getString("writer"));
					ideaTemp.setIndate(rs.getString("indate"));
					return ideaTemp;
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
	
	public ideaDTO selectOne(String findSubject) {
		if (conn()) {
			try {
				String sql = "select * from openidea where subject like ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, "%"+findSubject+"%");
				ResultSet rs = psmt.executeQuery();
				if (rs.next()) {
					ideaDTO ideaTemp = new ideaDTO();
					ideaTemp.setNum(rs.getInt("num"));
					ideaTemp.setSubject(rs.getString("subject"));
					ideaTemp.setContent(rs.getString("content"));
					ideaTemp.setWriter(rs.getString("writer"));
					ideaTemp.setIndate(rs.getString("indate"));
					return ideaTemp;
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
			System.out.println("오라클 드라이버 로드 실패");
			e.printStackTrace();
		}
	}
}
