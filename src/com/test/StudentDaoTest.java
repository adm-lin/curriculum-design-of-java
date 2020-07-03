package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.Student;
import com.dao.StudentDao;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDaoTest.
 *
 * @date 2020��7��2��
 * @author linyuju
 * @version v1.0
 */
public class StudentDaoTest {
	
	/**
	 * Insert test.
	 * �Բ���Ĳ���
	 */
	@Test
	public void insertTest() {
		StudentDao studentDao=new StudentDao();
		Student student=new Student("aa","aa","aa","aa","aa","aa");
		studentDao.insert(student);
	}
	
	/**
	 * Revise.
	 * ���޸ĵĲ���
	 */
	@Test
	public void revise() {
		StudentDao studentDao=new StudentDao();
		studentDao.revisePassword("�����", "123456");
	}
	
	/**
	 * Query as name.
	 * �԰����ֲ�ѯ�Ĳ���
	 */
	@Test
	public void queryAsName() {
		StudentDao studentDao=new StudentDao();
		Student student = studentDao.queryAsCondition("�����");
		System.out.println(student.getName());
	}
	
	/**
	 * Query as class.
	 * �԰��༶��ѯ�Ĳ���
	 */
	@Test
	public void queryAsClass() {
		StudentDao studentDao=new StudentDao();
		List<Student> queryClass = studentDao.queryClass("2018��3��");
		for(Student student:queryClass) {
			System.out.println(student.getName());
		}
	}
}
