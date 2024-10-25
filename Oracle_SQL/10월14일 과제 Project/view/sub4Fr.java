package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import service.TrainInfo;

public class sub4Fr extends JPanel {
	TrainInfo tinfo = new TrainInfo();
	
	//컴포넌트&컨테이너. 
	private JPanel sub4_p01 = new sub4P1();
	private JPanel sub4_p02 = new sub4P2();
//	private JPanel sub4_p03 = new sub3Fr();
//	private JPanel sub4_p04 = new sub4Fr();
		
	public sub4Fr() {
		this.removeAll();
		JLabel ts4 = new JLabel("기차 기준 정보", JLabel.CENTER);
		
		JPanel center_t40 = new JPanel();
		center_t40.setLayout(new GridLayout());
//		JPanel sub4_p01 = new JPanel(); 
		sub4_p01.setBackground(Color.white);
//		JPanel sub4_p02 = new JPanel(); 
		sub4_p02.setBackground(Color.white);
//		JPanel sub4_p03 = new JPanel(); sub4_p03.setBackground(Color.red);
//		JPanel sub4_p04 = new JPanel(); sub4_p04.setBackground(Color.blue);
		center_t40.add(sub4_p01);
		center_t40.add(sub4_p02);
//		center_t40.add(sub4_p03);
//		center_t40.add(sub4_p04);
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add(ts4, "North");
		this.add(center_t40);
	}

}
