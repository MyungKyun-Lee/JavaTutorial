package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.StationDTO;
import service.TrainInfo;

public class sub4P2 extends JPanel implements ActionListener {
	TrainInfo tinfo = new TrainInfo();
	
	private JTable center_t42;
	
	private JButton c420btn;
	private JButton c421btn;
	private JButton c422btn;
	private JButton c423btn;

	public sub4P2() {
		this.removeAll();
		JLabel ts42 = new JLabel("Station 정보", JLabel.CENTER);
		
		String[] columName = {"ID","기차역명","역차이"};
		DefaultTableModel model42 = new DefaultTableModel(columName,0);
		center_t42 = new JTable(model42);  //그 모델을 가지고 테이블 생성
		JScrollPane jsp42 = new JScrollPane(center_t42); //스크롤 붙임
		center_t42.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t42.setRowHeight(20);
		center_t42.getColumn("ID").setPreferredWidth(20); // cell Width 조정
//		center_t42.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		c420btn  = new JButton("추가"); c420btn.addActionListener(this);
		c421btn  = new JButton("등록"); c421btn.addActionListener(this);
		c422btn  = new JButton("수정"); c422btn.addActionListener(this);
		c423btn  = new JButton("삭제"); c423btn.addActionListener(this);
		JPanel south_t42 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south_t42.add(c420btn);
		south_t42.add(c421btn);
		south_t42.add(c422btn);
		south_t42.add(c423btn);
		c420btn.setVisible(true);
		c421btn.setVisible(false);
		
		String[] rowData;
		ArrayList<StationDTO> flist = tinfo.stlist();
		for (StationDTO i : flist) {
			rowData = new String[] {i.getSt_id(), i.getSt_name(), Integer.toString(i.getSt_distance())};
			model42.addRow(rowData);
		}
		center_t42.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
		JPanel center_t42 = new JPanel(new BorderLayout());
		center_t42.add(ts42, "North");
		center_t42.add(jsp42, "Center");
		center_t42.add(south_t42, "South");
		
		this.add(center_t42);
	}

	// Station 정보 등록 처리
	public void addSt() {
		int rowNum = center_t42.getSelectedRow();
		if (rowNum == -1) return;
		
		String St_id   = ""+center_t42.getValueAt(rowNum, 0);
		String St_name = ""+center_t42.getValueAt(rowNum, 1);
		String St_distance = ""+center_t42.getValueAt(rowNum, 2);
		if (!St_id.equals("") && !St_name.equals("")) {
			// DB 등록
//			System.out.println("St_id=["+St_id+"] St_name=["+St_name+"] St_distance=["+St_distance+"]");
			tinfo.addStation(St_id, St_name, Integer.parseInt(St_distance));
			
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 등록되었습니다.", "등록처리", JOptionPane.INFORMATION_MESSAGE );
			c420btn.setVisible(true);
			c421btn.setVisible(false);
		} else {
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "입력 항목 값이 없습니다.", "등록처리", JOptionPane.WARNING_MESSAGE );
		}
		
	}
	
	// Station 정보 수정 처리
	public void updateSt() {
		int rowNum = center_t42.getSelectedRow();
		if (rowNum == -1) return;
		
		String St_id   = ""+center_t42.getValueAt(rowNum, 0);
		String St_name = ""+center_t42.getValueAt(rowNum, 1);
		String St_distance = ""+center_t42.getValueAt(rowNum, 2);
		if (!St_id.equals("") && !St_name.equals("")) {
			// DB 등록
//			System.out.println("St_id=["+St_id+"] St_name=["+St_name+"] St_distance=["+St_distance+"]");
			tinfo.updateStation(St_id, St_name, Integer.parseInt(St_distance));
			
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 수정되었습니다.", "수정처리", JOptionPane.INFORMATION_MESSAGE );
			c420btn.setVisible(true);
			c421btn.setVisible(false);
		} else {
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "입력 항목 값이 없습니다.", "수정처리", JOptionPane.WARNING_MESSAGE );
		}
	}
	
	// Station 정보 삭제 처리
	public void deleteSt() {
		int rowNum = center_t42.getSelectedRow();
		if (rowNum == -1) return;
		
		// DB 삭제
		String del_item = ""+center_t42.getValueAt(rowNum, 0);
		tinfo.deleteStation(del_item);
		
		DefaultTableModel model = (DefaultTableModel) center_t42.getModel();
		model.removeRow(rowNum);

		// 팝업창 저장 안내 메시지
		JOptionPane.showMessageDialog(this, "정상으로 삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		if (e.getSource() == c420btn) {
			String arr[] = new String[3];
			arr[0] = "";
			arr[1] = "";
			arr[2] = "";
			DefaultTableModel model = (DefaultTableModel) center_t42.getModel();
			model.addRow(arr);

			int last_num = model.getRowCount();
			center_t42.changeSelection(last_num-1, 0, false, false);
			c420btn.setVisible(false);
			c421btn.setVisible(true);
		} else if (e.getSource() == c421btn) {
			addSt();
		} else if (e.getSource() == c422btn) {
			updateSt();
		} else if (e.getSource() == c423btn) {
//			System.out.println("기차정보 삭제~~");
			deleteSt();
		}
	}

}
