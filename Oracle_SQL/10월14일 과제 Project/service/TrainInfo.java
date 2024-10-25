package service;

import java.util.ArrayList;

import dao_interface.ClientDAO;
import dao_interface.ReservationDAO;
import dao_interface.ScheduleDAO;
import dao_interface.StationDAO;
import dao_interface.TrainDAO_m;
import dto.ClientDTO;
import dto.ReservationDTO;
import dto.ScheduleDTO;
import dto.TrainDTO;
import dto.StationDTO;

public class TrainInfo {
	TrainDAO_m traindao = new TrainDAO_m();
	ReservationDAO reservationdao = new ReservationDAO();
	StationDAO stationdao = new StationDAO();
	ClientDAO clientdao = new ClientDAO();
	ScheduleDAO scheduledao = new ScheduleDAO();

	public TrainInfo() {
//		TrainAllList();
//		ReservationAllList();
//		StationAllList();
//		ScheduleAllList();
	}
	
	public void addClient(String u_id, String u_pw, String u_name, int u_age, String u_tel, String age_id) {
		ClientDTO clientdto = new ClientDTO();

		clientdto.setUser_id(u_id);
		clientdto.setUser_pw(u_pw);
		clientdto.setUser_name(u_name);
		clientdto.setUser_age(u_age);
		clientdto.setUser_tel(u_tel);
		clientdto.setAge_id(age_id);
		
		clientdao.insert(clientdto);
//		System.out.println("정상 저장");
	}
	public void updateClient(String u_id, String u_pw, String u_name, int u_age, String u_tel, String age_id) {
		ClientDTO clientdto = new ClientDTO();
		
		clientdto.setUser_id(u_id);
		clientdto.setUser_pw(u_pw);
		clientdto.setUser_name(u_name);
		clientdto.setUser_age(u_age);
		clientdto.setUser_tel(u_tel);
		clientdto.setAge_id(age_id);
		
		clientdao.update(clientdto);
//		System.out.println("client 업데이트");
	}
	public void deleteClient(String u_tel) {
		clientdao.delete(u_tel);
//		System.out.println("client 삭제");
	}
	public void ClientAllList() {
		ArrayList<ClientDTO> t_list = clientdao.selectAll();
		for(ClientDTO t : t_list) {
			System.out.println(t.toString());
		}
	}
	public ArrayList<ClientDTO> cList() {
		ArrayList<ClientDTO> f = clientdao.selectAll();
		return f;
	}
	
	public void ScheduleAllList() {
		ArrayList<ScheduleDTO> t_list = scheduledao.selectAll();
		for(ScheduleDTO t : t_list) {
			System.out.println(t.toString());
		}
	}
	public ArrayList<ScheduleDTO> sList() {
		ArrayList<ScheduleDTO> f = scheduledao.selectAll();
		return f;
	}
	public boolean ReservationOne(String u_tel) {
		boolean t_one = reservationdao.selectOne(u_tel);
		return t_one;
	}
	public void ReservationAllList() {
		ArrayList<ReservationDTO> t_list = reservationdao.selectAll();
		// DB에 저장된 정보를 모두 출력
		for(ReservationDTO t : t_list) {
			System.out.println(t.toString());
		}
	}
	public ArrayList<ReservationDTO> wlist() {
		ArrayList<ReservationDTO> f = reservationdao.selectAll();
		return f;
	}

	// 기차역 서비스
	public void StationAllList() {
		ArrayList<StationDTO> t_list = stationdao.selectAll();
		// DB에 저장된 정보를 모두 출력
		for(StationDTO t : t_list) {
			System.out.println(t.toString());
		}
	}
	public ArrayList<StationDTO> stlist() {
		ArrayList<StationDTO> f = stationdao.selectAll();
		return f;
	}
	public void deleteStation(String st_id) {
		stationdao.delete(st_id);
		System.out.println("Station 삭제");
	}
	public void updateStation(String st_id, String st_name, int st_distance) {
		StationDTO stationdto = new StationDTO();
		stationdto.setSt_id(st_id);
		stationdto.setSt_name(st_name);
		stationdto.setSt_distance(st_distance);
		
		stationdao.update(stationdto);
		System.out.println("Station 업데이트");
	}
	public void addStation(String st_id, String st_name, int st_distance) {
		StationDTO stationdto = new StationDTO();
		stationdto.setSt_id(st_id);
		stationdto.setSt_name(st_name);
		stationdto.setSt_distance(st_distance);
		
		stationdao.insert(stationdto);
		System.out.println("Station 등록");
	}
	
	// 기차정보 서비스
	public void TrainAllList() {
		ArrayList<TrainDTO> t_list = traindao.selectAll();
		// DB에 저장된 정보를 모두 출력
		for(TrainDTO t : t_list) {
			System.out.println(t.toString());
		}
	}
	public ArrayList<TrainDTO> tlist() {
		ArrayList<TrainDTO> f = traindao.selectAll();
		return f;
	}
	public void deleteTrain(String t_id) {
		traindao.delete(t_id);
		System.out.println("Train 삭제");
	}
	public void updateTrain(String t_id, String t_name, String t_type) {
		TrainDTO traindto = new TrainDTO();
		traindto.setTr_id(t_id);
		traindto.setTr_name(t_name);
		traindto.setTr_type(t_type);
		
		traindao.update(traindto);
		System.out.println("train 업데이트");
	}
	public void addTrain(String t_id, String t_name, String t_type) {
		TrainDTO traindto = new TrainDTO();
		traindto.setTr_id(t_id);
		traindto.setTr_name(t_name);
		traindto.setTr_type(t_type);
		
		traindao.insert(traindto);
		System.out.println("Train 등록");
	}
}
