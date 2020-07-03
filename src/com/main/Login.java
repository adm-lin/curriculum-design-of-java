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
          *登录 类
     * @date 2020年7月2日
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
	public JLabel lblUser = new JLabel("用户名：");
	
	/** The lbl pass. */
	private JLabel lblPass = new JLabel("密码：");
	
	/** The txt user. */
	private JTextField txtUser = new JTextField(10);
	
	/** The txt pass. */
	private JPasswordField txtPass = new JPasswordField(10);
	
	/** The btn login. */
	private JButton btnLogin = new JButton("登录");
	
	/** The btn register. */
	private JButton btnRegister = new JButton("注册");
	
	/** The btn clear. */
	private JButton btnClear = new JButton("清除");
	
	/** The panel bottom. */
	JPanel panelBottom = new JPanel();
	
	/** The log 4 j. */
	Logger log4j = Logger.getLogger(Login.class);
	
	/** The name. */
	String name=null;
	
	/**
	 * Inits the.
	  * 页面初始化
	 */
	public void init() {
		this.setSize(500, 400);
		this.setLocation(600, 400);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\label.jpg");
		this.setIconImage(icon.getImage());

		panelUp.add(picture);
		ImageIcon image = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\login.jpg");
		image.setImage(image.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT));
		picture.setIcon(image);
		this.add(panelUp, BorderLayout.NORTH);
		
		panelCenter.setLayout(new GridLayout(2, 2, 10, 10));
		panelCenter.add(lblUser);
		lblUser.setHorizontalAlignment(lblUser.CENTER);
		lblUser.setFont(new Font("楷体", Font.BOLD, 30));
		panelCenter.add(txtUser);
		panelCenter.add(lblPass);
		lblPass.setHorizontalAlignment(lblPass.CENTER);
		lblPass.setFont(new Font("楷体", Font.BOLD, 30));
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

	
	    /* (非 Javadoc)
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
				JLabel lbl = new JLabel("尚未输入账户名");
				Icon image = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\notify.jpg");
				lbl.setFont(new Font("楷体", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, lbl, "提示", JOptionPane.INFORMATION_MESSAGE, image);
				log4j.info("没有输入");
			} else if (!txtUser.getText().equals("") && txtPass.getText().equals("")) {
				JLabel lbl = new JLabel("请输入密码！");
				Icon image = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\notify.jpg");
				lbl.setFont(new Font("楷体", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, lbl, "提示", JOptionPane.INFORMATION_MESSAGE, image);
			} else if (!txtUser.getText().equals("") && !txtPass.getText().equals("")) {
				int i = studentInfo.loginVerify(txtUser.getText(), txtPass.getText());
				log4j.info(i);
				if (i == 1) {
					name=txtUser.getName();
					try {
						BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\name.txt"),"utf-8"));
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
					JLabel lbl = new JLabel("账户不存在");
					ImageIcon image = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\notify.jpg");
					lbl.setFont(new Font("楷体", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, lbl, "提示", JOptionPane.INFORMATION_MESSAGE, image);
				}
				if (i == 0) {
					JLabel lbl = new JLabel("密码错误！");
					ImageIcon image = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\notify.jpg");
					lbl.setFont(new Font("楷体", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, lbl, "提示", JOptionPane.INFORMATION_MESSAGE, image);
				}
			}
		}
		if(e.getSource()==btnRegister) {
			new Register().init();
		}

	}
}