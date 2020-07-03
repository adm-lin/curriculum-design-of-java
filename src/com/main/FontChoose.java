package com.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


    // TODO: Auto-generated Javadoc
/**
     * The Class FontChoose.
          *����ѡ����
     * @date 2020��7��2��
     * @author linyuju
     * @version v1.0
     */
@SuppressWarnings({ "unchecked", "rawtypes" })   
public class FontChoose extends JFrame implements ItemListener {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

	/** The font arrays. */
	String[] fontArrays = null;

	/** The font cho. */
	JComboBox fontCho;

	/** The panel 1. */
	JPanel panel1 = new JPanel();
	
	/** The panel 2. */
	JPanel panel2 = new JPanel();
	
	/** The panel 3. */
	JPanel panel3 = new JPanel();
	
	/** The btn sure. */
	JButton btnSure = new JButton("ȷ��");
	
	/** The btn cancel. */
	JButton btnCancel = new JButton("ȡ��");
	
	/** The info 1. */
	JLabel info1 = new JLabel(" ����    ��� ");
	
	/** The info 2. */
	JLabel info2 = new JLabel("Hello World");
	
	/** The font. */
	Font font;
	
	/** The txt area. */
	JTextArea txtArea = new JTextArea();

	
	/**
	 * Instantiates a new font choose.
	 *
	 * @param txtArea the txt area
	 */
	public FontChoose(JTextArea txtArea) {
		this.setTitle("����ѡ��");
		info1.setFont(new Font("����", Font.BOLD, 20));
		info2.setFont(new Font("����", Font.BOLD, 20));
		panel2.setLayout(new GridLayout(2, 1));
		this.setSize(500, 200);
		this.setLocation(500, 400);
		this.setLayout(new BorderLayout());
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontArrays = env.getAvailableFontFamilyNames(); // ��ȡ������������
		fontCho = new JComboBox(fontArrays);
		fontCho.setSelectedItem("����");
		panel1.add(fontCho);
		panel2.add(info1);
		panel2.add(info2);
		panel3.add(btnSure);
		panel3.add(btnCancel);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
		info1.setHorizontalAlignment(JLabel.CENTER);
		info2.setHorizontalAlignment(JLabel.CENTER);
		btnSure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtArea.setFont(font);
				dispose();
			}

		});
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				font = new Font("����", Font.BOLD, 20);
				fontCho.setSelectedItem("����");
				info1.setFont(font);
				info2.setFont(font);
			}

		});
		fontCho.addItemListener(this);
		this.setVisible(true);
	}

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	    */
	    
	@Override
	public void itemStateChanged(ItemEvent e) {
		String str = (String) fontCho.getSelectedItem();
		font = new Font(str, Font.BOLD, 20);
		info1.setFont(font);
		info2.setFont(font);
	}

}
