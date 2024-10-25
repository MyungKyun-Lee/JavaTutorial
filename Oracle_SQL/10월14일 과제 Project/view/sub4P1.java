package view;

import java.awt.BorderLayout;
import java.awt.Color;
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

import dto.TrainDTO;
import service.TrainInfo;

public class sub4P1 extends JPanel implements ActionListener {
	TrainInfo tinfo = new TrainInfo();
	
	private JTable center_t41;
	
	private JButton c410btn;
	private JButton c411btn;
	private JButton c412btn;
	private JButton c413btn;
	
	public sub4P1() {
		this.removeAll();
		JLabel ts41 = new JLabel("Train 정보", JLabel.CENTER);
		
		String[] columName = {"ID","기차명","기차유형"};
		DefaultTableModel model41 = new DefaultTableModel(columName,0);
		center_t41 = new JTable(model41);  //그 모델을 가지고 테이블 생성
		JScrollPane jsp41 = new JScrollPane(center_t41); //스크롤 붙임
		center_t41.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t41.setRowHeight(20);
		center_t41.getColumn("ID").setPreferredWidth(20); // cell Width 조정
//		center_t41.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		c410btn  = new JButton("추가"); c410btn.addActionListener(this);
		c411btn  = new JButton("등록"); c411btn.addActionListener(this);
		c412btn  = new JButton("수정"); c412btn.addActionListener(this);
		c413btn  = new JButton("삭제"); c413btn.addActionListener(this);
		JPanel south_t41 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south_t41.add(c410btn);
		south_t41.add(c411btn);
		south_t41.add(c412btn);
		south_t41.add(c413btn);
		c410btn.setVisible(true);
		c411btn.setVisible(false);
		
		String[] rowData;
		ArrayList<TrainDTO> flist = tinfo.tlist();
		for (TrainDTO i : flist) {
			rowData = new String[] {i.getTr_id(), i.getTr_name(), i.getTr_type()};
			model41.addRow(rowData);
		}
		center_t41.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
		JPanel center_t41 = new JPanel(new BorderLayout());
		center_t41.add(ts41, "North");
		center_t41.add(jsp41, "Center");
		center_t41.add(south_t41, "South");
		
		this.setBackground(Color.white);
		this.add(center_t41);
	}
	
	// Train 정보 등록 처리
	public void addTr() {
		int rowNum = center_t41.getSelectedRow();
		if (rowNum == -1) return;
		
		String Tr_id   = ""+center_t41.getValueAt(rowNum, 0);
		String Tr_name = ""+center_t41.getValueAt(rowNum, 1);
		String Tr_type = ""+center_t41.getValueAt(rowNum, 2);
		if (!Tr_id.equals("") && !Tr_name.equals("")) {
			// DB 등록
//			System.out.println("Tr_id=["+Tr_id+"] Tr_name=["+Tr_name+"] Tr_type=["+Tr_type+"]");
			tinfo.addTrain(Tr_id, Tr_name, Tr_type);
			
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 등록되었습니다.", "등록처리", JOptionPane.INFORMATION_MESSAGE );
			c410btn.setVisible(true);
			c411btn.setVisible(false);
		} else {
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "입력 항목 값이 없습니다.", "등록처리", JOptionPane.WARNING_MESSAGE );
		}
		
	}
	
	// Train 정보 수정 처리
	public void updateTr() {
		int rowNum = center_t41.getSelectedRow();
		if (rowNum == -1) return;
		
		String Tr_id   = ""+center_t41.getValueAt(rowNum, 0);
		String Tr_name = ""+center_t41.getValueAt(rowNum, 1);
		String Tr_type = ""+center_t41.getValueAt(rowNum, 2);
		if (!Tr_id.equals("") && !Tr_name.equals("")) {
			// DB 등록
//			System.out.println("Tr_id=["+Tr_id+"] Tr_name=["+Tr_name+"] Tr_type=["+Tr_type+"]");
			tinfo.updateTrain(Tr_id, Tr_name, Tr_type);
			
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 수정되었습니다.", "수정처리", JOptionPane.INFORMATION_MESSAGE );
			c410btn.setVisible(true);
			c411btn.setVisible(false);
		} else {
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "입력 항목 값이 없습니다.", "수정처리", JOptionPane.WARNING_MESSAGE );
		}
	}
	
	// Train 정보 삭제 처리
	public void deleteTr() {
		int rowNum = center_t41.getSelectedRow();
		if (rowNum == -1) return;
		
		// DB 삭제
		String del_item = ""+center_t41.getValueAt(rowNum, 0);
		tinfo.deleteTrain(del_item);
		
		DefaultTableModel model = (DefaultTableModel) center_t41.getModel();
		model.removeRow(rowNum);

		// 팝업창 저장 안내 메시지
		JOptionPane.showMessageDialog(this, "정상으로 삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		if (e.getSource() == c410btn) {
			String arr[] = new String[3];
			arr[0] = "";
			arr[1] = "";
			arr[2] = "";
			DefaultTableModel model = (DefaultTableModel) center_t41.getModel();
			model.addRow(arr);

			int last_num = model.getRowCount();
			center_t41.changeSelection(last_num-1, 0, false, false);
			c410btn.setVisible(false);
			c411btn.setVisible(true);
		} else if (e.getSource() == c411btn) {
			addTr();
		} else if (e.getSource() == c412btn) {
			updateTr();
		} else if (e.getSource() == c413btn) {
//			System.out.println("기차정보 삭제~~");
			deleteTr();
		}
	}

}
