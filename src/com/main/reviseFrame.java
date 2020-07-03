package com.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.dao.StudentDao;


    // TODO: Auto-generated Javadoc
/**
     * The Class reviseFrame.
          *密码修改面板框
     * @date 2020年7月2日
     * @author linyuju
     * @version v1.0
     */
    
public class reviseFrame {
	
	/** The log 4 j. */
	Logger log4j=Logger.getLogger(reviseFrame.class);
	
	/** The revise. */
	JFrame revise = new JFrame("密码修改");
	
	/** The panel. */
	JPanel panel = new JPanel();
	
	/** The panel 2. */
	JPanel panel2 = new JPanel();
	
	/** The panel 3. */
	JPanel panel3 = new JPanel();
	
	/** The btn yes. */
	JButton btnYes = new JButton("确定");
	
	/** The password. */
	JLabel password = new JLabel("输入新密码：");
	
	/** The password 1. */
	JLabel password1 = new JLabel("请再次输入：");
	
	/** The info. */
	JLabel info = new JLabel("密码修改");
	
	/** The pass input. */
	JTextField passInput = new JTextField(10);
	
	/** The pass input 1. */
	JTextField passInput1 = new JTextField(10);
	
	/**
	 * Inits the.
	 */
	@SuppressWarnings("static-access")
	public void init() {
	info.setFont(new Font("黑体", Font.PLAIN, 15));
	
	panel.setLayout(new GridLayout(2, 2, 5, 10));
	revise.setBounds(400, 300, 300, 200);
	panel.add(password);
	panel.add(passInput);
	panel.add(password1);
	panel.add(passInput1);
	passInput.setSize(10, 2);
	password.setHorizontalAlignment(password.CENTER);
	password1.setHorizontalAlignment(password1.CENTER);
	revise.add(panel, BorderLayout.CENTER);

	panel2.add(btnYes);
	revise.add(panel2, BorderLayout.SOUTH);
	panel3.add(info);
	revise.add(panel3, BorderLayout.NORTH);

	revise.setVisible(true);
	
	btnYes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log4j.info(passInput.getText() + passInput1.getText());
			if (passInput.getText().equals(passInput1.getText()) && passInput.getText() != null) {
				String name = new Demo().getName();
				new StudentDao().revisePassword(name, passInput.getText());
				revise.dispose();
			}
		}

	});
	}
}
