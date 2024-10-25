package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.ClientDTO;
import dto.ReservationDTO;
import dto.ScheduleDTO;
import dto.StationDTO;
import dto.TrainDTO;
import service.TrainInfo;


// 참고> 마우스 리스너 (MouseListener, MouseMotionListener-영역지정)
public class MenuFrame extends JFrame implements ActionListener, KeyListener, ItemListener {
	TrainInfo tinfo = new TrainInfo();
	
	public static final Dimension LBL_SIZE = new Dimension(130, 18);
	public static final int INPUT_SIZE = 10;

	//컴포넌트&컨테이너. 
	private JPanel center_p = new JPanel();
	private JPanel center_p1 = new JPanel();
	private JPanel center_p2 = new JPanel();
	private JPanel center_p3 = new JPanel();
	private JPanel center_p4 = new JPanel();
	
	// Table 콤퍼넌트
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private DefaultTableModel model4;
	private DefaultTableModel model42;
	private JTable center_t1;
	private JTable center_t2;
	private JTable center_t3;
	private JTable center_t4;
	private JTable center_t42;
	private JScrollPane jsp;
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	private JScrollPane jsp4;
	private JScrollPane jsp42;

	private JTextField j1 = new JTextField(INPUT_SIZE);
	private JTextField j2 = new JTextField(INPUT_SIZE);
	private JTextField j3 = new JTextField(INPUT_SIZE);
	private JTextField j4 = new JTextField(INPUT_SIZE);
	private JTextField j5 = new JTextField(INPUT_SIZE);
	private JTextField j6 = new JTextField(INPUT_SIZE);
	private JTextField j7 = new JTextField(INPUT_SIZE);
	private JTextField j31 = new JTextField(INPUT_SIZE);
	
	private JButton c1btn  = new JButton("기차 회원등록");
	private JButton c2btn  = new JButton("기차 운행정보");
	private JButton c3btn  = new JButton("기차 예약현황");
	private JButton c4btn  = new JButton("기차 기준정보");
	
	private JButton c11btn  = new JButton("저장");
	private JButton c12btn  = new JButton("수정");
	private JButton c13btn  = new JButton("삭제");
	private JButton c14btn  = new JButton("이전");
	
	private JButton c31btn  = new JButton("조회");
	
	private JButton c411btn  = new JButton("등록");
	private JButton c412btn  = new JButton("수정");
	private JButton c413btn  = new JButton("삭제");
	
	JComboBox<String> combox;
	
	DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
	DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();

	public MenuFrame() {
		super("기차 예약관리 프로그램");
//		setSize(1200,500);
//		this.setLocationRelativeTo(null); // 화면 중앙에 배치
		this.setBounds(100, 100, 1000, 600);
//		JLabel t = new JLabel("기차 예약관리 프로그램");
//		title_p.add(t);
//		title_p.setSize(1000, 400);
		JPanel menu_p = new JPanel();
//		menu_p.setBackground(Color.yellow);
//		menu_p.setBounds(0, 0, 500, 280);
		menu_p.add(c1btn); c1btn.addActionListener(this);
		menu_p.add(c2btn); c2btn.addActionListener(this);
		menu_p.add(c3btn); c3btn.addActionListener(this);
		menu_p.add(c4btn); c4btn.addActionListener(this);

		c11btn.addActionListener(this);
		c12btn.addActionListener(this);
		c13btn.addActionListener(this);
		c14btn.addActionListener(this);
		
		j4.addKeyListener(this);
		
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		JPanel title_p = new JPanel();
		menu_p.setBackground(Color.yellow);
		title_p.add(menu_p,"Center");
		this.add(title_p,BorderLayout.NORTH);
		
		center_p.setBackground(Color.white);
		center_p.setLayout(new GridLayout());
		JLabel center_t = new JLabel("기차 예약관리 프로그램 Ver0.1", JLabel.CENTER);
		center_p.add(center_t);
		this.add(center_p, BorderLayout.CENTER);
		
		
//		this.pack();  // window 화면 내용 최소화
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void CustomerReg() {
		center_p1.removeAll();
		j1.setText("");
		j2.setText("");
		j3.setText("");
		j4.setText("");
		j5.setText("");
		j6.setText("");
		JLabel ts1 = new JLabel("기차 회원 등록", JLabel.CENTER);
		
		JLabel c1 = new JLabel("회원ID ", JLabel.RIGHT);		c1.setPreferredSize(LBL_SIZE);
		JLabel c2 = new JLabel("회원PW ", JLabel.RIGHT);		c2.setPreferredSize(LBL_SIZE);
		JLabel c3 = new JLabel("회원명  ", JLabel.RIGHT);		c3.setPreferredSize(LBL_SIZE);
		JLabel c4 = new JLabel("회원나이 ", JLabel.RIGHT);		c4.setPreferredSize(LBL_SIZE);
		JLabel c5 = new JLabel("회원전화 ", JLabel.RIGHT);		c5.setPreferredSize(LBL_SIZE);
		JLabel c6 = new JLabel("할인구분 ", JLabel.RIGHT);		c6.setPreferredSize(LBL_SIZE);
		JLabel c7 = new JLabel(""); j7.setVisible(false);
//		j4.addKeyListener(this);

//		j1.setBounds(30, 20, 150, 30);
//		j1.setSize(130,30);
		JPanel c1c = new JPanel();
		c1c.setLayout(new GridLayout(7,2));
		c1c.setBackground(Color.cyan);
		c1c.add(c1);	c1c.add(j1);
		c1c.add(c2);	c1c.add(j2);
		c1c.add(c3);	c1c.add(j3);
		c1c.add(c4);	c1c.add(j4);
		c1c.add(c5);	c1c.add(j5);
		c1c.add(c6);	
		String age_id[] = {"유아","아동","일반","경로","장애"};
		combox = new JComboBox<String>(age_id);
		combox.addActionListener(this);
		c1c.add(combox);
		// j6 안보이게함.
		c1c.add(c7);	c1c.add(j6); j6.setVisible(false);
//		c1c.add(c7);	c1c.add(j7); j7.setEnabled(false); // 수정 안됨
		
		JPanel c11c = new JPanel();
		c11c.setLayout(new BorderLayout());
		c11c.setSize(200, 500);
		c11c.add(c1c);
		
		// [저장 버튼] 상자와 글자 사이 간격조절
		c11btn.setMargin(new Insets(5,5,5,5));		c11btn.setPreferredSize(new Dimension(55,24));
		c12btn.setMargin(new Insets(5,5,5,5));		c12btn.setPreferredSize(new Dimension(55,24));
		c13btn.setMargin(new Insets(5,5,5,5));		c13btn.setPreferredSize(new Dimension(55,24));
		c14btn.setMargin(new Insets(5,5,5,5));		c14btn.setPreferredSize(new Dimension(55,24));
		c11btn.setVisible(true);
		c12btn.setVisible(false);
		c13btn.setVisible(false);
		c14btn.setVisible(false);
//		c11btn.addActionListener(this);
//		c12btn.addActionListener(this);
//		c13btn.addActionListener(this);
//		c14btn.addActionListener(this);
		JPanel c1s = new JPanel();
		c1s.setLayout(new FlowLayout(FlowLayout.CENTER));
		c1s.add(c11btn);
		c1s.add(c12btn); 
		c1s.add(c13btn);
		c1s.add(c14btn);
		
		JPanel center_p11 = new JPanel();
		center_p11.setLayout(new BorderLayout());
		center_p11.setBackground(Color.pink);
		center_p11.setBounds(5, 0, 290, 470);
		center_p11.add(ts1,"North");
		center_p11.add(c1c,"Center");
		center_p11.add(c1s,"South");
		
		// 고객 정보 리스트 출력
		ClaientView();
		
//		center_p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		center_p1.setLayout(null);
		center_p1.setBackground(Color.yellow);
		center_p1.setBounds(0, 50, 1000, 570);
		center_p1.add(center_p11);
		center_p1.add(jsp1);
//		System.out.println(center_p1.getHeight());
	}
	public void ClaientView() {
		
		String[] columName = {"고객ID","고객PW","고객명","고객나이","고객전화","나이구분"};
		model1 = new DefaultTableModel(columName,0);
		center_t1 = new JTable(model1);
		jsp1 = new JScrollPane(center_t1); //스크롤 붙임
		center_t1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t1.setRowHeight(20);
		center_t1.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		center_t1.getColumn("고객명").setCellRenderer(cellAlignCenter);
		center_t1.getColumn("고객나이").setCellRenderer(cellAlignCenter);
		center_t1.getColumn("나이구분").setCellRenderer(cellAlignCenter);
		
		Vector<String> rowData;
		ArrayList<ClientDTO> flist = tinfo.cList();
		for (ClientDTO i : flist) {
			rowData = new Vector<String>();
			rowData.add(i.getUser_id());
			rowData.add(i.getUser_pw());
			rowData.add(i.getUser_name());
			rowData.add(Integer.toString(i.getUser_age()));
			rowData.add(i.getUser_tel());
			rowData.add(i.getAge_id());
			model1.addRow(rowData);
		}
		center_t1.setAutoCreateRowSorter(true); //자동 행 정렬기능
		jsp1.setBounds(300, 0, 680, 510);
	}
	
	public void ScheduleView() {
		center_p2.removeAll();
		JLabel ts2 = new JLabel("기차 운행 정보", JLabel.CENTER);
		
		String[] columName = {"ID","출발시간","출발역","도착역","기차명","가격"};
		model2 = new DefaultTableModel(columName,0);
		center_t2 = new JTable(model2);  //그 모델을 가지고 테이블 생성
		jsp2 = new JScrollPane(center_t2); //스크롤 붙임
		center_t2.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		jsp2.setBounds(10, 0, 960, 460);

		center_t2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t2.setRowHeight(20);
		center_t2.getColumn("ID").setPreferredWidth(30); // cell Width 조정
		center_t2.getColumn("출발시간").setPreferredWidth(130);
		
		// cell 왼쪽 정렬
//		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
//		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		center_t2.getColumn("출발역").setCellRenderer(cellAlignCenter);
		center_t2.getColumn("도착역").setCellRenderer(cellAlignCenter);
		// cell 오른쪽 정렬
//		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
//		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		center_t2.getColumn("가격").setCellRenderer(cellAlignRight);
		
		String[] rowData;
		ArrayList<ScheduleDTO> flist = tinfo.sList();
		for (ScheduleDTO i : flist) {
			rowData = new String[] {i.getSch_id(), i.getSch_time(), i.getS_st_nm(), i.getE_st_nm(), i.getTr_name(), Integer.toString(i.getOrigin_price())};
			model2.addRow(rowData);
		}
		center_t2.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
		JPanel center_t20 = new JPanel();
		center_t20.setLayout(null);
//		center_t20.setBackground(Color.red);
		center_t20.add(jsp2);

		
		center_p2.setBackground(Color.white);
		center_p2.setLayout(new BorderLayout());
		center_p2.add(ts2, "North");
		center_p2.add(center_t20);
	}
	
	public void ReservationView() {
		center_p3.removeAll();
		JLabel ts3 = new JLabel("기차 예약 현황", JLabel.CENTER);
//		ts3.setBounds(0, 0, 1000, 50);
		
		String[] columName = {"승객명","나이","예약시간","출발역","도착역","출발시간","기차정보","가격","활인율","결재금액"};
		model3 = new DefaultTableModel(columName,0);
		center_t3 = new JTable(model3);  //그 모델을 가지고 테이블 생성
		jsp = new JScrollPane(center_t3); //스크롤 붙임
		center_t3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t3.setRowHeight(20);
		center_t3.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
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
		
		center_p3.setBackground(Color.white);
		center_p3.setLayout(new GridLayout());
		center_p3.add(center_t30); 

	}
	public void TrainView() {
		center_p4.removeAll();
		JLabel ts4 = new JLabel("기차 기준 정보", JLabel.CENTER);
		
		String[] columName = {"ID","기차명","기차유형"};
		model4 = new DefaultTableModel(columName,0);
		center_t4 = new JTable(model4);  //그 모델을 가지고 테이블 생성
		jsp4 = new JScrollPane(center_t4); //스크롤 붙임
		center_t4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t4.setRowHeight(20);
		center_t4.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
//		center_t4.getColumn("기차명").setCellRenderer(cellAlignCenter);
		
		c411btn  = new JButton("등록"); c411btn.addActionListener(this);
		c412btn  = new JButton("수정"); c412btn.addActionListener(this);
		c413btn  = new JButton("삭제"); c413btn.addActionListener(this);
		JPanel center_t41 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		center_t41.add(c411btn);
		center_t41.add(c412btn);
		center_t41.add(c413btn);
		
		String[] rowData;
		ArrayList<TrainDTO> flist = tinfo.tlist();
		for (TrainDTO i : flist) {
			rowData = new String[] {i.getTr_id(), i.getTr_name(), i.getTr_type()};
			model4.addRow(rowData);
		}
		center_t4.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
		JPanel center_t40 = new JPanel(new BorderLayout());
		center_t40.add(ts4, "North");
		center_t40.add(jsp4, "Center");
		center_t40.add(center_t41, "South");
		
		center_p4.setBackground(Color.white);
//		center_p4.setLayout(new GridLayout());
		center_p4.add(center_t40);
		StationView();
	}
	public void StationView() {
		JLabel ts42 = new JLabel("기차역 기준 정보", JLabel.CENTER);
		
		String[] columName = {"ID","기차역명","역차이"};
		model42 = new DefaultTableModel(columName,0);
		center_t42 = new JTable(model42);  //그 모델을 가지고 테이블 생성
		jsp42 = new JScrollPane(center_t42); //스크롤 붙임
		center_t42.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t42.setRowHeight(20);
		center_t42.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		JButton c41btn  = new JButton("등록");
		JButton c42btn  = new JButton("수정");
		JButton c43btn  = new JButton("삭제");
		JPanel center_t422 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		center_t422.add(c41btn);
		center_t422.add(c42btn);
		center_t422.add(c43btn);
		
		String[] rowData;
		ArrayList<StationDTO> flist = tinfo.stlist();
		for (StationDTO i : flist) {
			rowData = new String[] {i.getSt_id(), i.getSt_name(), Integer.toString(i.getSt_distance())};
			model42.addRow(rowData);
		}
//		center_t42.setAutoCreateRowSorter(true); //자동 행 정렬기능
		
		JPanel center_t420 = new JPanel(new BorderLayout());
		center_t420.add(ts42, "North");
		center_t420.add(jsp42, "Center");
		center_t420.add(center_t422, "South");
		center_p4.add(center_t420);
	}
	// 고객 정보 등록 처리
	public void insertC() {
		String tex1 = j1.getText();
		String tex2 = j2.getText();
		String tex3 = j3.getText();
		int tex4 = Integer.parseInt(j4.getText());
		String tex5 = j5.getText();
		String tex6 = j6.getText();
		// DB 입력
		tinfo.addClient(tex1, tex2, tex3, tex4, tex5, tex6);
		// JTable 입력
		Vector<String> rowData = new Vector<String>();
		rowData.add(j1.getText());
		rowData.add(j2.getText());
		rowData.add(j3.getText());
		rowData.add(j4.getText());
		rowData.add(j5.getText());
		rowData.add(j6.getText());
		model1.addRow(rowData);
		
		// 입력값 clear
		j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);

		// 팝업창 저장 안내 메시지
		JOptionPane.showMessageDialog(this, "정상으로 저장되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
	}
	// 고객 정보 수정 처리
	public void updateC() {
		String tex1 = j1.getText();
		String tex2 = j2.getText();
		String tex3 = j3.getText();
		int tex4 = Integer.parseInt(j4.getText());
		String tex5 = j5.getText();
		String tex6 = j6.getText();
		// DB 수정
		tinfo.updateClient(tex1, tex2, tex3, tex4, tex5, tex6);
		// JTable 수정 처리
		
		// 입력값 clear
		j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);

		// 팝업창 저장 안내 메시지
		JOptionPane.showMessageDialog(this, "정상으로 수정되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
	}
	// 고객 정보 삭제 처리
	public void deleteC() {
		String tex5 = j5.getText();
		// 삭제 전 예약정보에 고객이 있는지 확인
		boolean temp_one = tinfo.ReservationOne(tex5);
		if (temp_one != false) {
			// DB 삭제
			tinfo.deleteClient(tex5);
			// JTable 삭제 처리
			
			// 입력값 clear
			j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);
	
			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
		} else {
			JOptionPane.showMessageDialog(this, "[기차 예약정보]에 등록된 고객으로 삭제할 수 없습니다!", "삭제 에러", JOptionPane.WARNING_MESSAGE );
		}
	}
	
	// Train 정보 삭제 처리
	public void deleteTr() {
		int rowNum = center_t4.getSelectedRow();
		String del_item = ""+center_t4.getValueAt(rowNum, 0);
		// DB 삭제
		tinfo.deleteTrain(del_item);
		// 팝업창 저장 안내 메시지
		JOptionPane.showMessageDialog(this, "정상으로 삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ActionEvent~");
		int n;
		// 메뉴에 따른 실행
		if (e.getSource() == c1btn) {
//			n = center_p1.getComponentCount();
//			if (n > 0) {
//				System.out.println("CustomerReg~ >>"+n); return;
//			}
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			CustomerReg();  // center_t 테이블에 데이터 add
			this.add(center_p1, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("CustomerReg~");
		} else if (e.getSource() == c2btn) {
//			n = center_p2.getComponentCount();
//			if (n > 0) {
//				System.out.println("ScheduleReg~ >>"+n); return;
//			}
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			ScheduleView();  // center_t 테이블에 데이터 add
			this.add(center_p2, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("ScheduleReg~");
		} else if (e.getSource() == c3btn) {
//			n = center_p3.getComponentCount();
//			if (n > 0) {
//				System.out.println("ReservationView~ >>"+n); return;
//			}
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			ReservationView();  // center_t 테이블에 데이터 add
			this.add(center_p3, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("ReservationView~");
		} else if (e.getSource() == c4btn) {
//			n = center_p4.getComponentCount();
//			if (n > 0) {
//				System.out.println("TrainReg~ >>"+n); return;
//			}
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			TrainView();  // center_t 테이블에 데이터 add
			this.add(center_p4, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("TrainReg~");
		} else if (e.getSource() == c11btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "등록에러", JOptionPane.WARNING_MESSAGE );
				return;
			} else {
				insertC();
				return;
			}
		} else if (e.getSource() == c12btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "수정에러", JOptionPane.WARNING_MESSAGE );
				return;
			} else {
				updateC();
				// table refresh
				center_p1.remove(jsp1);
				ClaientView();
				center_p1.add(jsp1);
				return;
			}
		} else if (e.getSource() == c13btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "삭제에러", JOptionPane.WARNING_MESSAGE );
				return;
			} else {
//				System.out.println("삭제 deleteC()~~");
				deleteC();
				// table refresh
				center_p1.remove(jsp1);
				ClaientView();
				center_p1.add(jsp1);
				return;
			}
		} else if (e.getSource() == combox) {
//			System.out.println("combox selected~~"+combox.getSelectedIndex());
			int sel = combox.getSelectedIndex();
			if (sel == 3) {
				j6.setText("age65");
			} else if (sel == 2) {
				j6.setText("age64");
			} else if (sel == 1) {
				j6.setText("age12");
			} else {
				j6.setText("age05");
			}
			return;
		} else if (e.getSource() == c14btn) {
			// button 활성화
			c11btn.setVisible(true);
			c12btn.setVisible(false);
			c13btn.setVisible(false);
			c14btn.setVisible(false);
			// 입력값 clear
			j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);
		} else if (e.getSource() == c31btn) {
			System.out.println("예약현황 조회~~");
			String str = j31.getText();
			
			for (int i=0; i<center_t3.getRowCount(); i++) {
				String vs = ""+center_t3.getValueAt(i, 0);
				if (str.equals(vs) == true) {
					System.out.println(vs);
//					center_t3.setSelectionMode(i);
					center_t3.changeSelection(i, 0, false, false);
				}
			}
		}  else if (e.getSource() == c413btn) {
			System.out.println("기차정보 삭제~~");
			deleteTr();
			
			// table refresh
			center_p4.removeAll();
			TrainView();
//			center_p4.add(center_t40);
		}
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//만일 엔터키를 눌렀다면
			if (e.getSource() == j31) {
				String str = j31.getText();
				for (int i=0; i<center_t3.getRowCount(); i++) {
					String vs = ""+center_t3.getValueAt(i, 0);
					if (str.equals(vs) == true) {
						System.out.println(vs);
						center_t3.changeSelection(i, 0, false, false);
					}
				}
			}
		}
		// j4 나이 입력시 age_id 값을 넣어야 함.
		if (e.getSource() == j4 && j4.getText().length() > 0) {
//				System.out.println("key input 클릭~~["+j4.getText()+"]");
			int in_age = Integer.parseInt(j4.getText());
			if (in_age >= 65 ) {
				j6.setText("age65");
				combox.setSelectedIndex(3);
			} else if (in_age > 12) {
				j6.setText("age64");
				combox.setSelectedIndex(2);
			} else if (in_age > 5) {
				j6.setText("age12");
				combox.setSelectedIndex(1);
			} else if (in_age > 0) {
				j6.setText("age05");
				combox.setSelectedIndex(0);
			} 
			
		}
	}

	class TableEvent extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
//			System.out.println("테이블 클릭~~");
			super.mouseClicked(e);
			if (e.getSource() == center_t1) {
				int rowNum = center_t1.getSelectedRow();
				j1.setText(""+center_t1.getValueAt(rowNum, 0));
				j2.setText(""+center_t1.getValueAt(rowNum, 1));
				j3.setText(""+center_t1.getValueAt(rowNum, 2));
				j4.setText(""+center_t1.getValueAt(rowNum, 3));
				j5.setText(""+center_t1.getValueAt(rowNum, 4));
				j6.setText(""+center_t1.getValueAt(rowNum, 5));
				// combox 셋팅
				int in_age = Integer.parseInt(j4.getText());
				if (in_age >= 65 )    combox.setSelectedIndex(3);
				else if (in_age > 12) combox.setSelectedIndex(2);
				else if (in_age > 5)  combox.setSelectedIndex(1);
				else if (in_age > 0)  combox.setSelectedIndex(0);
				
				// button 활성화
				c11btn.setVisible(false);
				c12btn.setVisible(true);
				c13btn.setVisible(true);
				c14btn.setVisible(true);
				
			} else if (e.getSource() == center_t4) {
				System.out.println("center_4 mouse click~");
			}
		}
		
	}
}
