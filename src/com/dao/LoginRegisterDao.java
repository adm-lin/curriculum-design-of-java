package com.dao;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginRegisterDao.
   *登录注册类于数据库的操作
 * @date 2020年7月2日
 * @author linyuju
 * @version v1.0
 */
public class LoginRegisterDao {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The url. */
	String url = "jdbc:mysql://localhost:3306/jsu?useSSL=true&CharacterEnconding=utf-8";
	
	/** The user. */
	String user = "root";
	
	/** The password. */
	String password = "13025526699";
	
	/** The pstm. */
	PreparedStatement pstm = null;
	
	/** The conn. */
	Connection conn = null;
	
	/** The log 4 j. */
	Logger log4j=Logger.getLogger(StudentDao.class);
	
	ResultSet rs=null;
	PreparedStatement pstm1=null;
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	@SuppressWarnings("finally")
	public Connection getConnection() {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
	
	/**
	 * Login verify.
	 *
	 * @param name the name
	 * @param password the password
	 * @return the int
	  * 登录验证
	 */
	public int loginVerify(String name,String password) {
		conn=getConnection();
		String sql="select * from user where name='"+name+"'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()) {
				if(rs.getString(6).equals(password)) {
					log4j.info("登录成功");
					return 1;
				}	else {
					log4j.info("密码错误");
					return 0;
				}
			}
			else {
				log4j.info("账户不存在");
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Register verify.
	 * @param name the name
	 * @param id the id
	 * @param gradeName the grade name
	 * @return the int
	  * 注册验证
	 */
	@SuppressWarnings("unused")
	public int RegisterVerify(String name,String id,String gradeName) {
		conn=getConnection();
		String sql="select * from user where name=? and id=? and grade=?";
		try {
			log4j.info("进入数据库");
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, id);
			pstm.setString(3, gradeName);
			rs=pstm.executeQuery();
			log4j.info(name+" "+id+" "+gradeName);
			if(rs.next()) {
				log4j.info("进入密码申请");
				String password=null;
				password=rs.getString(6);
				log4j.info(password);
				if(password.equals("")) {
					log4j.info("注册");
					String sql1="update user set password='123456' where name='"+name+"'";
					pstm1=conn.prepareStatement(sql1);
					pstm1.executeUpdate();
					JLabel lbl=new JLabel("成功注册");
					lbl.setFont(new Font("宋体",Font.PLAIN,20));
					JOptionPane.showMessageDialog(null, lbl);
					return 1;
				}else {
					JLabel lbl=new JLabel("用户已经存在");
					lbl.setFont(new Font("宋体",Font.PLAIN,20));
					JOptionPane.showMessageDialog(null, lbl);	
				}
			}else {
				JLabel lbl=new JLabel("输入有误");
				lbl.setFont(new Font("宋体",Font.PLAIN,20));
				JOptionPane.showMessageDialog(null, lbl);
			}
		}catch(Exception e){
			
		}finally {
			try {
				rs.close();
				pstm.close();
				pstm1.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
		
	}
}
