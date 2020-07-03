package com.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


    // TODO: Auto-generated Javadoc
/**
     * The Class Search.
          *文本搜索类
     * @date 2020年7月2日
     * @author linyuju
     * @version v1.0
     */
    
public class Search{
	
	/** The search label. */
	JLabel searchLabel=new JLabel("查找");
	JLabel replaceLabel=new JLabel("替换");
	
	JTextField replaceTxt=new JTextField(10);
	/** The search txt. */
	JTextField searchTxt=new JTextField(10);
	
	/** The search. */
	JButton btnSearch=new JButton("查找");
	JButton btnReplace=new JButton("替换");
	
	/** The up. */
	JRadioButton up=new JRadioButton("向上");
	
	/** The down. */
	JRadioButton down=new JRadioButton("向下");
	
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
	  * 页面初始化
	 */
	public void init() {
		JFrame frame = new JFrame("查找");
		
		frame.setTitle("查找");
		frame.setBounds(600, 400, 300, 130);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelBottom, BorderLayout.SOUTH);
		panelCenter.setLayout(new GridLayout(2,3));
		panelCenter.add(searchLabel);
		panelCenter.add(searchTxt);
		panelCenter.add(btnSearch);
		panelCenter.add(replaceLabel);
		panelCenter.add(replaceTxt);
		panelCenter.add(btnReplace);
		searchLabel.setHorizontalAlignment(searchLabel.CENTER);
		replaceLabel.setHorizontalAlignment(replaceLabel.CENTER);
		
		group.add(up);
		group.add(down);
		panelBottom.add(up);
		panelBottom.add(down);

		btnSearch.setPreferredSize(new Dimension(110, 22));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnReplace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(replaceTxt.getText().length()>0&&txtArea.getSelectedText()!=null)
					txtArea.replaceSelection(replaceTxt.getText());
				
			}
			
		});
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
