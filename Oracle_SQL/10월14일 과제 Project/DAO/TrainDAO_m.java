package dao_interface;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.TrainDTO;

public class TrainDAO_m {
	MariaDBconnecter dbconn = MariaDBconnecter.getInstance();
	
	public ArrayList<TrainDTO> selectAll() {
		ArrayList<TrainDTO> tlist = new ArrayList<TrainDTO>();
		if (dbconn.conn()) {
			try {
				String sql = "select * from train order by tr_id";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					TrainDTO trainTemp = new TrainDTO();
					trainTemp.setTr_id(rs.getString("tr_id"));
					trainTemp.setTr_name(rs.getString("tr_name"));
					trainTemp.setTr_type(rs.getString("tr_type"));
					tlist.add(trainTemp);
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
	
	public void delete(String tr_id) {
		if (dbconn.conn()) {
			try {
				String sql = "DELETE FROM train WHERE tr_id=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, tr_id);
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
	
	public void update(TrainDTO traindto) {
		if (dbconn.conn()) {
			try {
				String sql = "UPDATE train SET tr_name=?, tr_type=? WHERE tr_id=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, traindto.getTr_name());
				psmt.setString(2, traindto.getTr_type());
				psmt.setString(3, traindto.getTr_id());
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
	
	public void insert(TrainDTO traindto) {
		if (dbconn.conn()) {
			try {
				String sql = "INSERT INTO train VALUES(?, ?, ?)";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, traindto.getTr_id());
				psmt.setString(2, traindto.getTr_name());
				psmt.setString(3, traindto.getTr_type());
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
