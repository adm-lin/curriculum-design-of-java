package com.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import org.apache.log4j.Logger;

import com.dao.LoginRegisterDao;


    // TODO: Auto-generated Javadoc
/**
     * The Class Login.
          *��¼ ��
     * @date 2020��7��2��
     * @author linyuju
     * @version v1.0
     */
    
public class Login extends JFrame implements ActionListener {
	
	/** The student info. */
	LoginRegisterDao studentInfo = new LoginRegisterDao();

	/** The panel up. */
	JPanel panelUp = new JPanel();
	
	/** The picture. */
	JLabel picture = new JLabel();
	
	/** The panel center. */
	JPanel panelCenter = new JPanel();
	
	/** The lbl user. */
	public JLabel lblUser = new JLabel("�û�����");
	
	/** The lbl pass. */
	private JLabel lblPass = new JLabel("���룺");
	
	/** The txt user. */
	private JTextField txtUser = new JTextField(10);
	
	/** The txt pass. */
	private JPasswordField txtPass = new JPasswordField(10);
	
	/** The btn login. */
	private JButton btnLogin = new JButton("��¼");
	
	/** The btn register. */
	private JButton btnRegister = new JButton("ע��");
	
	/** The btn clear. */
	private JButton btnClear = new JButton("���");
	
	/** The panel bottom. */
	JPanel panelBottom = new JPanel();
	
	/** The log 4 j. */
	Logger log4j = Logger.getLogger(Login.class);
	
	/** The name. */
	String name=null;
	
	/**
	 * Inits the.
	  * ҳ���ʼ��
	 */
	public void init() {
		this.setSize(500, 400);
		this.setLocation(600, 400);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\label.jpg");
		this.setIconImage(icon.getImage());

		panelUp.add(picture);
		ImageIcon image = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\login.jpg");
		image.setImage(image.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT));
		picture.setIcon(image);
		this.add(panelUp, BorderLayout.NORTH);
		
		panelCenter.setLayout(new GridLayout(2, 2, 10, 10));
		panelCenter.add(lblUser);
		lblUser.setHorizontalAlignment(lblUser.CENTER);
		lblUser.setFont(new Font("����", Font.BOLD, 30));
		panelCenter.add(txtUser);
		panelCenter.add(lblPass);
		lblPass.setHorizontalAlignment(lblPass.CENTER);
		lblPass.setFont(new Font("����", Font.BOLD, 30));
		panelCenter.add(txtPass);
		txtPass.setEchoChar('*');
		this.add(panelCenter, BorderLayout.CENTER);

		panelBottom.setLayout(new GridLayout(1, 3, 10, 20));
		panelBottom.add(btnLogin);
		panelBottom.add(btnRegister);
		panelBottom.add(btnClear);
		this.add(panelBottom, BorderLayout.SOUTH);

		btnLogin.addActionListener(this);
		btnClear.addActionListener(this);
		btnRegister.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Login().init();
	}

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			txtUser.setText("");
			txtPass.setText("");
		}
		if (e.getSource() == btnLogin) {
			if (txtUser.getText().equals("")) {
				JLabel lbl = new JLabel("��δ�����˻���");
				Icon image = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\notify.jpg");
				lbl.setFont(new Font("����", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, lbl, "��ʾ", JOptionPane.INFORMATION_MESSAGE, image);
				log4j.info("û������");
			} else if (!txtUser.getText().equals("") && txtPass.getText().equals("")) {
				JLabel lbl = new JLabel("���������룡");
				Icon image = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\notify.jpg");
				lbl.setFont(new Font("����", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, lbl, "��ʾ", JOptionPane.INFORMATION_MESSAGE, image);
			} else if (!txtUser.getText().equals("") && !txtPass.getText().equals("")) {
				int i = studentInfo.loginVerify(txtUser.getText(), txtPass.getText());
				log4j.info(i);
				if (i == 1) {
					name=txtUser.getName();
					try {
						BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\name.txt"),"utf-8"));
						bw.write(txtUser.getText());
						bw.flush();
						bw.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						this.dispose();
						new Demo().init();
					}
				}
				if (i == -1) {
					JLabel lbl = new JLabel("�˻�������");
					ImageIcon image = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\notify.jpg");
					lbl.setFont(new Font("����", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, lbl, "��ʾ", JOptionPane.INFORMATION_MESSAGE, image);
				}
				if (i == 0) {
					JLabel lbl = new JLabel("�������");
					ImageIcon image = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\notify.jpg");
					lbl.setFont(new Font("����", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, lbl, "��ʾ", JOptionPane.INFORMATION_MESSAGE, image);
				}
			}
		}
		if(e.getSource()==btnRegister) {
			new Register().init();
		}

	}
}