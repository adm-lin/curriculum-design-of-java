package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
// TODO: Auto-generated Javadoc

/**
 * The Class StudentDao.
 *
 * @date 2020��7��2��
 * @author linyuju
 * @version v1.0
  * ѧ����Ϣ�����ݿ�Ĳ���
 */

public class StudentDao {

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
	
	/**
	 * Gets the connection.
	 * @return the connection
	  * ��ȡ���ݿ�����
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
	 * Insert.
	 * @param student ѧ��
	  * ����
	 */
	public void insert(Student student) {
		try {
			conn = getConnection();
			String sql = "insert into user (name,id,major,grade,school) values(?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getId());
			pstm.setString(3, student.getMajor());
			pstm.setString(4, student.getGrade());
			pstm.setString(5, student.getSchool());
			//pstm.setString(6, student.getPassword());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * Revise password.
	 *
	 * @param name the name
	 * @param password ����
	  * �޸�����
	 */
	public void revisePassword(String name,String password) {
		try {
			conn=getConnection();
			String sql="update user set password=? where name=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, password);
			pstm.setString(2, name);
			pstm.executeUpdate();
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * Query as condition.
	 *
	 * @param name ����
	 * @return the student
	  * ͨ��������ѯ��Ϣ
	 */
	public Student queryAsCondition(String name) {
		Student student =new Student();
		try {
			conn=getConnection();
			String sql="select name,id,major,grade,school from user where name='"+name+"'";
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				student.setName(rs.getString(1));
				student.setId(rs.getString(2));
				student.setMajor(rs.getString(3));
				student.setGrade(rs.getString(4));
				student.setSchool(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
	
	/**
	 * Query class.
	 *
	 * @param className �༶��
	 * @return the list
	  * ͨ���༶����ѯ�ð༶��ѧ��
	 */
	public List<Student> queryClass(String className) {
		List<Student> studentList=new ArrayList<>();
		try {
			conn=getConnection();
			String sql = "select name,id,major,grade,school from user where grade='"+className+"' order by id";
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			Student student=null;
			while(rs.next()) {
				//��ȡ�������1-5�е�����
				String name=rs.getString(1);
				String id=rs.getString(2);
				String major=rs.getString(3);
				String cName=rs.getString(4);
				String school=rs.getString(5);
				
				student =new Student();
				student.setName(name);
				student.setId(id);
				student.setMajor(major);
				student.setGrade(cName);
				student.setSchool(school);
				
				studentList.add(student);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}
}