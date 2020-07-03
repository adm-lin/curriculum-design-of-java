package com.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import com.dao.LoginRegisterDao;


    // TODO: Auto-generated Javadoc
/**
     * The Class Register.
          *ע����
     * @date 2020��7��2��
     * @author linyuju
     * @version v1.0
     */
    
public class Register extends JFrame implements ItemListener,ActionListener{
	
	/** The student info. */
	LoginRegisterDao studentInfo=new LoginRegisterDao();
	
	/** The lbl name. */
	JLabel lblName=new JLabel("������");
	
	/** The txt user. */
	JTextField txtUser=new JTextField(10);
	
	/** The lbl id. */
	JLabel lblId=new JLabel("ѧ�ţ�");
	
	/** The txt id. */
	JTextField txtId=new JTextField(10);
	
	/** The lbl grade. */
	JLabel lblGrade=new JLabel("�༶��");
	
	/** The grade list. */
	String gradeList[]= {"2018��1��","2018��2��","2018��3��","2018��4��","2018��5��"};
	
	/** The grade. */
	JComboBox grade;
	
	/** The btn yes. */
	JButton btnYes=new JButton("ȷ��");
	
	/** The pan up. */
	JPanel panUp=new JPanel();
	
	/** The pan center. */
	JPanel panCenter=new JPanel();
	
	/** The pan bottom. */
	JPanel panBottom=new JPanel();
	
	/**
	 * Inits the.
	 */
	public void init() {
		this.setTitle("�û�ע��");
		this.setSize(300, 200);
		this.setLocation(500, 300);
		this.add(panUp,BorderLayout.NORTH);
		this.add(panCenter,BorderLayout.CENTER);
		this.add(panBottom,BorderLayout.SOUTH);
		grade=new JComboBox(gradeList);
		grade.setSelectedItem(gradeList[0]);
		
		panCenter.setLayout(new GridLayout(3,2,5,5));
		lblName.setHorizontalAlignment(lblName.CENTER);
		lblId.setHorizontalAlignment(lblId.CENTER);
		lblGrade.setHorizontalAlignment(lblGrade.CENTER);
		panCenter.add(lblGrade);
		panCenter.add(grade);
		panCenter.add(lblName);
		panCenter.add(txtUser);
		panCenter.add(lblId);
		panCenter.add(txtId);
		panBottom.add(btnYes);
		
		btnYes.addActionListener(this);
		grade.addItemListener(this);
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
		// TODO Auto-generated method stub
		
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnYes) {
			String name=txtUser.getText();
			String id=txtId.getText();
			String gradeName=(String) grade.getSelectedItem();
			int i=studentInfo.RegisterVerify(name, id, gradeName);
			if(i==1)
				this.dispose();
		}
		
	}
}
