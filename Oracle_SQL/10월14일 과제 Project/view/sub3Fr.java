package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.ReservationDTO;
import service.TrainInfo;

public class sub3Fr extends JPanel implements ActionListener, KeyListener {
	TrainInfo tinfo = new TrainInfo();
	
	private JTable center_t3;
	
	public static final Dimension LBL_SIZE = new Dimension(130, 18);
	public static final int INPUT_SIZE = 10;
	
	private JTextField j31;
	private JButton c31btn;
	
	DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
	DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
	
	public sub3Fr() {
		this.removeAll();
		JLabel ts3 = new JLabel("기차 예약 현황", JLabel.CENTER);
		
		String[] columName = {"승객명","나이","예약시간","출발역","도착역","출발시간","기차정보","가격","활인율","결재금액"};
		DefaultTableModel model3 = new DefaultTableModel(columName,0);
		center_t3 = new JTable(model3);  //그 모델을 가지고 테이블 생성
		JScrollPane jsp = new JScrollPane(center_t3); //스크롤 붙임
		center_t3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t3.setRowHeight(20);
		center_t3.getColumn("나이").setPreferredWidth(20); // cell Width 조정
//		center_t3.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		center_t3.getColumn("승객명").setCellRenderer(cellAlignCenter);
		center_t3.getColumn("나이").setCellRenderer(cellAlignCenter);
		center_t3.getColumn("출발역").setCellRenderer(cellAlignCenter);
		center_t3.getColumn("도착역").setCellRenderer(cellAlignCenter);
		center_t3.getColumn("가격").setCellRenderer(cellAlignRight);
		center_t3.getColumn("활인율").setCellRenderer(cellAlignCenter);
		center_t3.getColumn("결재금액").setCellRenderer(cellAlignRight);
		
		JLabel ts31 = new JLabel("승객명", JLabel.RIGHT);
		j31 = new JTextField(INPUT_SIZE); j31.addKeyListener(this);
		c31btn  = new JButton("조회"); c31btn.addActionListener(this);
		JPanel center_t31 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		center_t31.add(ts31);
		center_t31.add(j31);
		center_t31.add(c31btn);
		
		String[] rowData;
		ArrayList<ReservationDTO> flist = tinfo.wlist();
		for (ReservationDTO i : flist) {
			rowData = new String[] {i.getUser_name(), i.getUser_age(), i.getRes_time(), i.getS_st(), i.getE_st(), 
					i.getSch_time(), i.getTr_name(), i.getOrigin_price(), i.getAge_per(), i.getSale_price()};
			model3.addRow(rowData);
		}
		center_t3.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
//		JPanel center_t30 = new JPanel(new GridLayout(3,0));
		JPanel center_t30 = new JPanel(new BorderLayout());
		center_t30.add(ts3, "North");
		center_t30.add(jsp, "Center");
		center_t30.add(center_t31, "South");
		
		this.setBackground(Color.white);
		this.setLayout(new GridLayout());
		this.add(center_t30); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == c31btn && j31.getText().length() > 0) {
//			System.out.println("예약현황 조회~~");
			String str = j31.getText();

			for (int i=0; i<center_t3.getRowCount(); i++) {
				String vs = ""+center_t3.getValueAt(i, 0);
				if (str.equals(vs) == true) {
//					System.out.println(vs);
					center_t3.changeSelection(i, 0, false, false);	// 찾은 row 표시
					j31.setText("");
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//만일 엔터키를 눌렀다면
			if (e.getSource() == j31) {
				String str = j31.getText();
				for (int i=0; i<center_t3.getRowCount(); i++) {
					String vs = ""+center_t3.getValueAt(i, 0);
					if (str.equals(vs) == true) {
//						System.out.println(vs);
						center_t3.changeSelection(i, 0, false, false);
						j31.setText("");
					}
				}
			}
		}
	}

}
