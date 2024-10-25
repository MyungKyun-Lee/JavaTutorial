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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.ClientDTO;
import service.TrainInfo;

public class sub1Fr extends JPanel implements ActionListener, KeyListener, ItemListener {
	TrainInfo tinfo = new TrainInfo();
	
	// Table 콤퍼넌트
	private DefaultTableModel model1;
	private JTable center_t1;
	private JScrollPane jsp1;
	
	public static final Dimension LBL_SIZE = new Dimension(130, 18);
	public static final int INPUT_SIZE = 10;
	
	private JTextField j1 = new JTextField(INPUT_SIZE);
	private JTextField j2 = new JTextField(INPUT_SIZE);
	private JTextField j3 = new JTextField(INPUT_SIZE);
	private JTextField j4 = new JTextField(INPUT_SIZE);
	private JTextField j5 = new JTextField(INPUT_SIZE);
	private JTextField j6 = new JTextField(INPUT_SIZE);
//	private JTextField j7 = new JTextField(INPUT_SIZE);
	
	JComboBox<String> combox;
	
	private JButton c11btn  = new JButton("저장");
	private JButton c12btn  = new JButton("수정");
	private JButton c13btn  = new JButton("삭제");
	private JButton c14btn  = new JButton("이전");
	
	public sub1Fr() {
//		this.removeAll();
		JLabel ts1 = new JLabel("기차 회원 등록", JLabel.CENTER);
		
		JLabel c1 = new JLabel("회원ID ", JLabel.RIGHT);		c1.setPreferredSize(LBL_SIZE);
		JLabel c2 = new JLabel("회원PW ", JLabel.RIGHT);		c2.setPreferredSize(LBL_SIZE);
		JLabel c3 = new JLabel("회원명  ", JLabel.RIGHT);		c3.setPreferredSize(LBL_SIZE);
		JLabel c4 = new JLabel("회원나이 ", JLabel.RIGHT);		c4.setPreferredSize(LBL_SIZE);
		JLabel c5 = new JLabel("회원전화 ", JLabel.RIGHT);		c5.setPreferredSize(LBL_SIZE);
		JLabel c6 = new JLabel("할인구분 ", JLabel.RIGHT);		c6.setPreferredSize(LBL_SIZE);
		JLabel c7 = new JLabel(""); //j7.setVisible(false);
		
		JPanel c1c = new JPanel();
		c1c.setLayout(new GridLayout(7,2));
		c1c.setBackground(Color.cyan);
		c1c.add(c1);	c1c.add(j1);
		c1c.add(c2);	c1c.add(j2);
		c1c.add(c3);	c1c.add(j3);
		c1c.add(c4);	c1c.add(j4);	j4.addKeyListener(this);
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
				c11btn.addActionListener(this);
				c12btn.addActionListener(this);
				c13btn.addActionListener(this);
				c14btn.addActionListener(this);
		JPanel c1s = new JPanel();
		c1s.setLayout(new FlowLayout(FlowLayout.CENTER));
		c1s.add(c11btn);
		c1s.add(c12btn); 
		c1s.add(c13btn);
		c1s.add(c14btn);
		
		JPanel center_p11 = new JPanel();
		center_p11.setLayout(new BorderLayout());
//		center_p11.setBackground(Color.pink);
		center_p11.setBounds(5, 0, 290, 470);
//		center_p11.add(ts1,"North");
		center_p11.add(c1c,"Center");
		center_p11.add(c1s,"South");
		
		// 고객 정보 리스트 출력
		ClaientView();
		
		JPanel center_p10 = new JPanel();
		center_p10.setLayout(null);
		center_p10.setBackground(Color.white);
		center_p10.setBounds(5, 0, 1000, 570);
		center_p10.add(center_p11);
		center_p10.add(jsp1);
		
		JPanel center_t10 = new JPanel();
		center_t10.setLayout(new BorderLayout());
		center_t10.add(ts1,"North");
		center_t10.add(center_p10,"Center");
		
		this.setBackground(Color.white);
		this.setLayout(new GridLayout());
		this.add(center_t10); 
	}

	public void ClaientView() {
		
		String[] columName = {"고객ID","고객PW","고객명","고객나이","고객전화","나이구분"};
		model1 = new DefaultTableModel(columName,0);
		center_t1 = new JTable(model1);
		jsp1 = new JScrollPane(center_t1); //스크롤 붙임
		center_t1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		center_t1.setRowHeight(20);
		center_t1.addMouseListener(new TableEvent()); // 테이블에 마우스 이벤트 추가
		
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
//		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
//		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
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
	
	// 고객 정보 등록 처리
		public void insertC() {
//			System.out.println("추가 insertC()~~");
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
			String tex7 = (String) combox.getSelectedItem();
			rowData.add(tex7);
			DefaultTableModel model = (DefaultTableModel) center_t1.getModel();
			model.addRow(rowData);

			// 입력되 값을 잘 보이도록 선택바 표시
			int last_num = model.getRowCount();
			center_t1.changeSelection(last_num-1, 0, false, false);
			
			// 입력값 clear
			j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);

			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 저장되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
		}
		// 고객 정보 수정 처리
		public void updateC() {
			int rowNum = center_t1.getSelectedRow();
			if (rowNum == -1) return;
			
			String tex1 = j1.getText();
			String tex2 = j2.getText();
			String tex3 = j3.getText();
			int tex4 = Integer.parseInt(j4.getText());
			String tex5 = j5.getText();
			String tex6 = j6.getText();
			// DB 수정
			tinfo.updateClient(tex1, tex2, tex3, tex4, tex5, tex6);
			// JTable 수정 처리
			center_t1.setValueAt(tex1, rowNum, 0);
			center_t1.setValueAt(tex2, rowNum, 1);
			center_t1.setValueAt(tex3, rowNum, 2);
			center_t1.setValueAt(tex4, rowNum, 3);
			center_t1.setValueAt(tex5, rowNum, 4);
			String tex7 = (String) combox.getSelectedItem();
			center_t1.setValueAt(tex7, rowNum, 5);
			
			// 입력값 clear
			j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);

			// 팝업창 저장 안내 메시지
			JOptionPane.showMessageDialog(this, "정상으로 수정되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
		}
		// 고객 정보 삭제 처리
		public void deleteC() {
			int rowNum = center_t1.getSelectedRow();
			if (rowNum == -1) return;
			
			String tex5 = j5.getText();
			// 삭제 전 예약정보에 고객이 있는지 확인
			boolean temp_one = tinfo.ReservationOne(tex5);
			if (temp_one != false) {
				// DB 삭제
				tinfo.deleteClient(tex5);
				// JTable 삭제 처리
				DefaultTableModel model = (DefaultTableModel) center_t1.getModel();
				model.removeRow(rowNum);
				
				// 입력값 clear
				j1.setText(null);	j2.setText(null);	j3.setText(null);	j4.setText(null);	j5.setText(null);	j6.setText(null);
		
				// 팝업창 저장 안내 메시지
				JOptionPane.showMessageDialog(this, "정상으로 삭제되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE );
			} else {
				JOptionPane.showMessageDialog(this, "[기차 예약정보]에 등록된 고객으로 삭제할 수 없습니다!", "삭제 에러", JOptionPane.WARNING_MESSAGE );
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent~");
		// 신규 저장
		if (e.getSource() == c11btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "등록에러", JOptionPane.WARNING_MESSAGE );
			} else {
//				System.out.println("추가 insertC()~~");
				insertC();
			}
		} else if (e.getSource() == c12btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "수정에러", JOptionPane.WARNING_MESSAGE );
			} else {
//				System.out.println("수정 updateC()~~");
				updateC();
			}
		} else if (e.getSource() == c13btn) {
			String user_id = j1.getText();
			String user_pw = j2.getText();
			String user_nm = j3.getText();
			String user_tel = j5.getText();
			if (user_id.length()==0 || user_pw.length()==0 || user_nm.length()==0 || user_tel.length()==0) {
				JOptionPane.showMessageDialog(this, "필수 입력 (ID, 패스워드, 이름, 전화)항목을 모두 입력해 주세요!", "삭제에러", JOptionPane.WARNING_MESSAGE );
			} else {
//				System.out.println("삭제 deleteC()~~");
				deleteC();
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
		}
	}
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
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
		// j4 나이 입력시 age_id 값을 넣어야 함.
		if (e.getSource() == j4 && j4.getText().length() > 0) {
						System.out.println("key input 클릭~~["+j4.getText()+"]");
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
//			System.out.println("테이블 Row 클릭~~");
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

			}
		}
		
	}
}
