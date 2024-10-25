package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.ScheduleDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import service.TrainInfo;

public class sub2Fr extends JPanel implements ActionListener {
	TrainInfo tinfo = new TrainInfo();
	
	// Table 콤퍼넌트
		private DefaultTableModel model2;
		private JTable center_t2;
		private JScrollPane jsp2;
		
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		
	// Label, textfield 변수 정의
		public static final Dimension LBL_SIZE = new Dimension(130, 18);
		public static final int INPUT_SIZE = 10;
		
		private JTextField j1 = new JTextField(INPUT_SIZE);
		private JTextField j2 = new JTextField(INPUT_SIZE);
			private JTextField j21 = new JTextField(2);  // 시간
			private JTextField j22 = new JTextField(2);  // 분
		private JTextField j3 = new JTextField(INPUT_SIZE);
		private JTextField j4 = new JTextField(INPUT_SIZE);
		private JTextField j5 = new JTextField(INPUT_SIZE);
		private JTextField j6 = new JTextField(INPUT_SIZE);
		
		JComboBox<String> combox1;
		JComboBox<String> combox2;
		
	// button 변수 정의
		private JButton c11btn  = new JButton("저장");
		private JButton c12btn  = new JButton("수정");
		private JButton c13btn  = new JButton("삭제");
		private JButton c14btn  = new JButton("이전");
	
	
	public sub2Fr() {
//		this.removeAll();
		JLabel ts2 = new JLabel("기차 운행 정보", JLabel.CENTER);
		
		JLabel c1 = new JLabel("스케줄ID ", JLabel.RIGHT);	c1.setPreferredSize(LBL_SIZE);
		JLabel c2 = new JLabel("출발시간 ", JLabel.RIGHT);		c2.setPreferredSize(LBL_SIZE);
			JLabel c21 = new JLabel("시", JLabel.RIGHT);		c2.setPreferredSize(LBL_SIZE);
			JLabel c22 = new JLabel("분", JLabel.RIGHT);		c2.setPreferredSize(LBL_SIZE);
		JLabel c3 = new JLabel("출발역  ", JLabel.RIGHT);		c3.setPreferredSize(LBL_SIZE);
		JLabel c4 = new JLabel("도착역 ", JLabel.RIGHT);		c4.setPreferredSize(LBL_SIZE);
		JLabel c5 = new JLabel("기차명 ", JLabel.RIGHT);		c5.setPreferredSize(LBL_SIZE);
		JLabel c6 = new JLabel("가격 ", JLabel.RIGHT);		c6.setPreferredSize(LBL_SIZE);
		
		// 날짜 
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		
		// 입력창
		JPanel initem_p = new JPanel();
		initem_p.setLayout(new GridLayout(7,2));
		initem_p.setBackground(Color.cyan);
		initem_p.setBounds(0, 0, 300, 500);
//		initem_p.setSize(200, 500);
		initem_p.add(c1);	initem_p.add(j1);
		initem_p.add(c2);	//initem_p.add(j2); j2.setVisible(false); 
		
//		String HOUR_id[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
//		combox1 = new JComboBox<String>(HOUR_id);
//		combox1.addActionListener(this);
//		String MINUTE_id[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
//		combox2 = new JComboBox<String>(MINUTE_id);
//		combox2.addActionListener(this);
		
		// 날짜 시간 입력 항목
		JPanel initem_date = new JPanel();
		initem_date.setLayout(null);
		initem_date.setBackground(Color.red);
//		initem_date.setBounds(0, 0, 100, 25);
		datePicker.setSize(120,25);
		c21.setSize(20,25);
		c22.setSize(20,25);
		initem_date.add(datePicker); initem_date.add(j21); initem_date.add(c21); initem_date.add(j22); initem_date.add(c22); 
		initem_p.add(initem_date);
		
		
		initem_p.add(c3);	initem_p.add(j3);
		initem_p.add(c4);	initem_p.add(j4);
		initem_p.add(c5);	initem_p.add(j5);
		initem_p.add(c6);	initem_p.add(j6);
		
		// 현재 날짜 시간 가져오기 
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.get(Calendar.AM_PM));
//		System.out.println(cal.get(Calendar.HOUR));
//		System.out.println(cal.get(Calendar.MINUTE));
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		// 현재 날짜 셋팅
		int dateY = cal.get(Calendar.YEAR);
		int dateM = cal.get(Calendar.MONTH);
		int dateD = cal.get(Calendar.DAY_OF_MONTH);
		int dateTs = cal.get(Calendar.AM_PM);
		int dateT = cal.get(Calendar.HOUR);
		int dateMM = cal.get(Calendar.MINUTE);
		model.setDate(dateY, dateM, dateD);
		model.setSelected(true);
		
		if (dateTs == 1) dateT = dateT+12;
		j21.setText(Integer.toString(dateT));
		j22.setText(Integer.toString(dateMM));
//		combox1.setSelectedIndex(dateT-1);
//		combox2.setSelectedIndex(dateMM-1);
		
		
		// [저장 버튼] 상자와 글자 사이 간격조절
		c11btn.setMargin(new Insets(5,5,5,5));		c11btn.setPreferredSize(new Dimension(55,24));
		c12btn.setMargin(new Insets(5,5,5,5));		c12btn.setPreferredSize(new Dimension(55,24));
		c13btn.setMargin(new Insets(5,5,5,5));		c13btn.setPreferredSize(new Dimension(55,24));
		c14btn.setMargin(new Insets(5,5,5,5));		c14btn.setPreferredSize(new Dimension(55,24));
		c11btn.setVisible(true);
		c12btn.setVisible(false);
		c13btn.setVisible(false);
		c14btn.setVisible(false);
				c11btn.addActionListener(this);
				c12btn.addActionListener(this);
				c13btn.addActionListener(this);
				c14btn.addActionListener(this);
		JPanel south_b = new JPanel();
		south_b.setLayout(new FlowLayout(FlowLayout.CENTER));
		south_b.add(c11btn);
		south_b.add(c12btn); 
		south_b.add(c13btn);
		south_b.add(c14btn);
		
		JPanel left_p1 = new JPanel();
		left_p1.setLayout(new BorderLayout());
		left_p1.setBackground(Color.cyan);
		left_p1.setBounds(5, 0, 300, 470);
		left_p1.add(initem_p,"Center");
		left_p1.add(south_b,"South");
		
		JPanel left_p0 = new JPanel();
//		left_p0.setLayout(new GridLayout());
		left_p0.add(left_p1);
		
		
		// left 스케줄 Table
		ScheduleView();
		JPanel right_p = new JPanel();
		right_p.setLayout(new GridLayout());
		right_p.setBackground(Color.green);
//		right_p.setBounds(310, 0, 660, 450);
		right_p.add(jsp2);
		
		JPanel center_t20 = new JPanel();
		center_t20.setBounds(0, 0, 1000, 470);
		center_t20.setLayout(new BorderLayout());
		center_t20.add(ts2, BorderLayout.NORTH);
		center_t20.add(left_p0, BorderLayout.WEST);
		center_t20.add(right_p, BorderLayout.CENTER);
		
		this.setBackground(Color.white);
		this.setLayout(new GridLayout());
		this.add(center_t20);
	}
	
	public void ScheduleView() {
		String[] columName = {"ID","출발시간","출발역","도착역","기차명","가격"};
		model2 = new DefaultTableModel(columName,0);
		center_t2 = new JTable(model2);  //그 모델을 가지고 테이블 생성
		jsp2 = new JScrollPane(center_t2); //스크롤 붙임
		center_t2.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
//		jsp2.setBounds(10, 0, 960, 460);
		
		center_t2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t2.setRowHeight(20);
		center_t2.getColumn("ID").setPreferredWidth(20); // cell Width 조정
		center_t2.getColumn("출발시간").setPreferredWidth(130);
		center_t2.getColumn("기차명").setPreferredWidth(130);
		
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		// cell 왼쪽 정렬
		center_t2.getColumn("출발역").setCellRenderer(cellAlignCenter);
		center_t2.getColumn("도착역").setCellRenderer(cellAlignCenter);
		// cell 오른쪽 정렬
		center_t2.getColumn("가격").setCellRenderer(cellAlignRight);
		
		
		String[] rowData;
		ArrayList<ScheduleDTO> flist = tinfo.sList();
		for (ScheduleDTO i : flist) {
			rowData = new String[] {i.getSch_id(), i.getSch_time(), i.getS_st_nm(), i.getE_st_nm(), i.getTr_name(), Integer.toString(i.getOrigin_price())};
			model2.addRow(rowData);
		}
		center_t2.setAutoCreateRowSorter(true); //자동 행 정렬기능
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class TableEvent extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("테이블 Row 클릭~~");
			super.mouseClicked(e);
			if (e.getSource() == center_t2) {
				int rowNum = center_t2.getSelectedRow();
				j1.setText(""+center_t2.getValueAt(rowNum, 0));
				j2.setText(""+center_t2.getValueAt(rowNum, 1));
				j3.setText(""+center_t2.getValueAt(rowNum, 2));
				j4.setText(""+center_t2.getValueAt(rowNum, 3));
				j5.setText(""+center_t2.getValueAt(rowNum, 4));
				j6.setText(""+center_t2.getValueAt(rowNum, 5));
				
				// button 활성화
				c11btn.setVisible(false);
				c12btn.setVisible(true);
				c13btn.setVisible(true);
				c14btn.setVisible(true);

			}
		}
		
	}
}
