package dao_interface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ClientDTO;

public class ClientDAO {
	MariaDBconnecter dbconn = MariaDBconnecter.getInstance();
	
	public void insert(ClientDTO clientdto) {
		if (dbconn.conn()) {
			try {
//				String sql = "insert into Client values('enjfn', 'sklfk122', '정이신', 30, '010-1111-2222','age64')";
				String sql = "insert into Client values(?, ?, ?, ?, ?, ?)";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, clientdto.getUser_id());
				psmt.setString(2, clientdto.getUser_pw());
				psmt.setString(3, clientdto.getUser_name());
				psmt.setInt(4, clientdto.getUser_age());
				psmt.setString(5, clientdto.getUser_tel());
				psmt.setString(6, clientdto.getAge_id());
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
	
	public void update(ClientDTO clientdto) {
		if (dbconn.conn()) {
			try {
				String sql = "UPDATE client SET user_id=?, user_pw=?, user_name=?, user_age=?, age_id=? WHERE user_tel=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, clientdto.getUser_id());
				psmt.setString(2, clientdto.getUser_pw());
				psmt.setString(3, clientdto.getUser_name());
				psmt.setInt(4, clientdto.getUser_age());
				psmt.setString(5, clientdto.getAge_id());
				psmt.setString(6, clientdto.getUser_tel());
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
	
	public void delete(String user_tel) {
		if (dbconn.conn()) {
			try {
				String sql = "DELETE FROM client WHERE user_tel=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, user_tel);
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
	
	public ArrayList<ClientDTO> selectAll() {
		ArrayList<ClientDTO> tlist = new ArrayList<ClientDTO>();
		if (dbconn.conn()) {
			try {
				String sql = "select a.user_id, a.user_pw, a.user_name, a.user_age, a.user_tel, b.age_type as age_id from client a, age_gubun b where a.age_id = b.age_id order by user_name";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					ClientDTO tTemp = new ClientDTO();
					tTemp.setUser_id(rs.getString("User_id"));
					tTemp.setUser_pw(rs.getString("User_pw"));
					tTemp.setUser_name(rs.getString("User_name"));
					tTemp.setUser_age(rs.getInt("User_age"));
					tTemp.setUser_tel(rs.getString("User_tel"));
					tTemp.setAge_id(rs.getString("Age_id"));
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
}
