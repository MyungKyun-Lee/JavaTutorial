package dao_interface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ScheduleDTO;


public class ScheduleDAO {
	MariaDBconnecter dbconn = MariaDBconnecter.getInstance();
	
	public ArrayList<ScheduleDTO> selectAll() {
		ArrayList<ScheduleDTO> tlist = new ArrayList<ScheduleDTO>();
		if (dbconn.conn()) {
			try {
				String sql = "select c.sch_id as 'ID', c.sch_time as '출발시간', "
						+ "(select st_name from station where st_id = c.s_st) as '출발역', "
						+ "(select st_name from station where st_id = c.e_st) as '도착역',  "
						+ "b.tr_name as '기차정보', c.origin_price as '가격' "
						+ "from schedule c, train b "
						+ "where c.tr_id = b.tr_id "
						+ "order by c.sch_time";
				PreparedStatement psmt = dbconn.conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					ScheduleDTO tTemp = new ScheduleDTO();
					tTemp.setSch_id(rs.getString("ID"));
					tTemp.setSch_time(rs.getString("출발시간"));
					tTemp.setS_st_nm(rs.getString("출발역"));
					tTemp.setE_st_nm(rs.getString("도착역"));
					tTemp.setTr_name(rs.getString("기차정보"));
					tTemp.setOrigin_price(rs.getInt("가격"));
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
