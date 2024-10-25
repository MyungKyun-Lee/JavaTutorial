package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class mainFr extends JFrame implements ActionListener {
	//컴포넌트&컨테이너. 
	private JPanel center_p = new JPanel();
	private JPanel center_p1 = new sub1Fr();
	private JPanel center_p2 = new sub2Fr();
	private JPanel center_p3 = new sub3Fr();
	private JPanel center_p4 = new sub4Fr();
	// 버튼
	private JButton c1btn  = new JButton("기차 회원등록");
	private JButton c2btn  = new JButton("기차 운행정보");
	private JButton c3btn  = new JButton("기차 예약현황");
	private JButton c4btn  = new JButton("기차 기준정보");
	
	public mainFr() {
		super("기차 예약관리 프로그램");
		this.setBounds(100, 100, 1000, 600);
		JPanel menu_p = new JPanel();
		menu_p.setBackground(Color.yellow);
		menu_p.add(c1btn); c1btn.addActionListener(this);
		menu_p.add(c2btn); c2btn.addActionListener(this);
		menu_p.add(c3btn); c3btn.addActionListener(this);
		menu_p.add(c4btn); c4btn.addActionListener(this);
		
		JPanel title_p = new JPanel();
		title_p.add(menu_p,"Center");
		this.add(title_p,BorderLayout.NORTH);
		
		ImageIcon image = new ImageIcon("D:\\Workspace\\java_src\\common\\train_re.JPG");
		Image img = image.getImage();
		Image changeimg = img.getScaledInstance(600, 300, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(changeimg));
		label.setBounds(200, 100, 600, 400);
		
//		center_p.setLayout(new GridLayout());
		center_p.setLayout(null);
		center_p.setBackground(Color.white);
		JLabel center_t = new JLabel("기차 예약관리 프로그램 Ver0.1", JLabel.CENTER);
		center_t.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		JPanel title_p2 = new JPanel();
		title_p2.setBounds(0, 0, 600, 50);
		title_p2.setBackground(Color.lightGray);
		title_p2.add(center_t, BorderLayout.CENTER);
		
		label.add(title_p2);
		
		center_p.add(label);
		this.add(center_p, BorderLayout.CENTER);

		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == c1btn) {
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			this.add(center_p1, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("CustomerReg~");
		} else if (e.getSource() == c2btn) {
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			this.add(center_p2, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("ScheduleReg~");
		} else if (e.getSource() == c3btn) {
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			this.add(center_p3, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("ReservationView~");
		} else if (e.getSource() == c4btn) {
			remove(center_p);
			remove(center_p1);
			remove(center_p2);
			remove(center_p3);
			remove(center_p4);
			this.add(center_p4, BorderLayout.CENTER);
			validate();
		    repaint();
			System.out.println("TrainReg~");
		}
	}
	
	
}
