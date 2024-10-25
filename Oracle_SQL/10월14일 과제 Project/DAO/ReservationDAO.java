package dao_interface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ReservationDTO;

public class ReservationDAO {
	MariaDBconnecter dbconn = MariaDBconnecter.getInstance();

	public ArrayList<ReservationDTO> selectAll() {
		ArrayList<ReservationDTO> tlist = new ArrayList<ReservationDTO>();
		if (dbconn.conn()) {
			try {
				String sql = "select 예약자, 나이, 예약시간, 출발역, 도착역, 출발시간, 기차정보, 가격, 할인정보, 할인가격 from Ticket_View";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					ReservationDTO tTemp = new ReservationDTO();
					tTemp.setUser_name(rs.getString("예약자"));
					tTemp.setUser_age(rs.getString("나이"));
					tTemp.setRes_time(rs.getString("예약시간"));
					tTemp.setS_st(rs.getString("출발역"));
					tTemp.setE_st(rs.getString("도착역"));
					tTemp.setSch_time(rs.getString("출발시간"));
					tTemp.setTr_name(rs.getString("기차정보"));
					tTemp.setOrigin_price(rs.getString("가격"));
					tTemp.setAge_per(rs.getString("할인정보"));
					tTemp.setSale_price(rs.getString("할인가격"));
					tlist.add(tTemp);
				}
			} catch (SQLException e) {
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
	
	public boolean selectOne(String user_tel) {
		boolean ret = false;
		String t_temp = null;
		if (dbconn.conn()) {
			try {
				String sql = "select user_tel from reservation WHERE user_tel=?";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				psmt.setString(1, user_tel);
				// 쿼리 실행
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					t_temp = rs.getString("user_tel");
				}
				if (t_temp == null) ret = true;
				
			} catch (SQLException e) {
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
		return ret;
	}
}
