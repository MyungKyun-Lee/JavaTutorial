package dao_interface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.StationDTO;

public class StationDAO {
	MariaDBconnecter dbconn = MariaDBconnecter.getInstance();
	
	public ArrayList<StationDTO> selectAll() {
		ArrayList<StationDTO> tlist = new ArrayList<StationDTO>();
		if (dbconn.conn()) {
			try {
				String sql = "select st_id, st_name, st_distance from station";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					StationDTO tTemp = new StationDTO();
					tTemp.setSt_id(rs.getString("st_id"));
					tTemp.setSt_name(rs.getString("st_name"));
					tTemp.setSt_distance(rs.getInt("st_distance"));
					tlist.add(tTemp);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dbconn.conn != null) dbconn.conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
		return tlist;
	}
	
	public void delete(String St_id) {
		if (dbconn.conn()) {
			try {
				String sql = "DELETE FROM station WHERE st_id=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, St_id);
				// 쿼리 실행
				int resultInt = psmt.executeUpdate();
				if (resultInt > 0)	dbconn.conn.commit();
				else				dbconn.conn.rollback();
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dbconn.conn != null) dbconn.conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	
	public void update(StationDTO stationdto) {
		if (dbconn.conn()) {
			try {
				String sql = "UPDATE station SET st_name=?, st_distance=? WHERE st_id=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, stationdto.getSt_name());
				psmt.setInt(2, stationdto.getSt_distance());
				psmt.setString(3, stationdto.getSt_id());
				// 쿼리 실행
				int resultInt = psmt.executeUpdate();
				if (resultInt > 0)	dbconn.conn.commit();
				else				dbconn.conn.rollback();
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dbconn.conn != null) dbconn.conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
	
	public void insert(StationDTO stationdto) {
		if (dbconn.conn()) {
			try {
				String sql = "INSERT INTO station VALUES(?, ?, ?)";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, stationdto.getSt_id());
				psmt.setString(2, stationdto.getSt_name());
				psmt.setInt(3, stationdto.getSt_distance());
				// 쿼리 실행
				int resultInt = psmt.executeUpdate();
				if (resultInt > 0)	dbconn.conn.commit();
				else				dbconn.conn.rollback();
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dbconn.conn != null) dbconn.conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("데이터베이스 커넥션 실패");
		}
	}
}
