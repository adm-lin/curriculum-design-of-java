package com.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


    // TODO: Auto-generated Javadoc
/**
     * The Class Search.
          *�ı�������
     * @date 2020��7��2��
     * @author linyuju
     * @version v1.0
     */
    
public class Search{
	
	/** The search label. */
	JLabel searchLabel=new JLabel("����");
	
	/** The search txt. */
	JTextField searchTxt=new JTextField(10);
	
	/** The search. */
	JButton search=new JButton("����");
	
	/** The up. */
	JRadioButton up=new JRadioButton("����");
	
	/** The down. */
	JRadioButton down=new JRadioButton("����");
	
	/** The group. */
	ButtonGroup group=new ButtonGroup();
	
	/** The panel center. */
	JPanel panelCenter=new JPanel();
	
	/** The panel bottom. */
	JPanel panelBottom=new JPanel();
	
	/** The txt area. */
	JTextArea txtArea;
	
	/**
	 * Instantiates a new search.
	 *
	 * @param txt the txt
	 */
	public Search(JTextArea txt) {
	this.txtArea=txt;
	}
	
	/**
	 * Inits the.
	  * ҳ���ʼ��
	 */
	public void init() {
		JFrame frame = new JFrame("����");
		JLabel searchLabel = new JLabel("����");
		JTextField searchTxt = new JTextField(10);
		JButton btnSearch = new JButton("����");
		JRadioButton up = new JRadioButton("����");
		JRadioButton down = new JRadioButton("����");
		ButtonGroup group = new ButtonGroup();
		JPanel panelCenter = new JPanel();
		JPanel panelBottom = new JPanel();
		
		frame.setTitle("����");
		frame.setBounds(600, 400, 300, 130);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelBottom, BorderLayout.SOUTH);
		panelCenter.add(searchLabel);
		panelCenter.add(searchTxt);
		panelCenter.add(btnSearch);
		group.add(up);
		group.add(down);
		panelBottom.add(up);
		panelBottom.add(down);

		btnSearch.setPreferredSize(new Dimension(110, 22));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int judge=0;
				int mouseLocation=txtArea.getCaretPosition();
				String strA=txtArea.getText();
				String strB=searchTxt.getText();
				if(up.isSelected()) {
					judge=strA.lastIndexOf(strB, mouseLocation-searchTxt.getText().length()-1);
				}else if(down.isSelected()) {
					judge=strA.indexOf(strB,mouseLocation);
				}
				if(judge>-1) {
					txtArea.setCaretPosition(judge);
					txtArea.select(judge, judge+searchTxt.getText().length());
				}
				
			}
			
		});
	}
	
}
