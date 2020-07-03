package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.Student;
import com.dao.StudentDao;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDaoTest.
 *
 * @date 2020年7月2日
 * @author linyuju
 * @version v1.0
 */
public class StudentDaoTest {
	
	/**
	 * Insert test.
	 * 对插入的测试
	 */
	@Test
	public void insertTest() {
		StudentDao studentDao=new StudentDao();
		Student student=new Student("aa","aa","aa","aa","aa","aa");
		studentDao.insert(student);
	}
	
	/**
	 * Revise.
	 * 对修改的测试
	 */
	@Test
	public void revise() {
		StudentDao studentDao=new StudentDao();
		studentDao.revisePassword("林宇驹", "123456");
	}
	
	/**
	 * Query as name.
	 * 对按名字查询的测试
	 */
	@Test
	public void queryAsName() {
		StudentDao studentDao=new StudentDao();
		Student student = studentDao.queryAsCondition("林宇驹");
		System.out.println(student.getName());
	}
	
	/**
	 * Query as class.
	 * 对按班级查询的测试
	 */
	@Test
	public void queryAsClass() {
		StudentDao studentDao=new StudentDao();
		List<Student> queryClass = studentDao.queryClass("2018级3班");
		for(Student student:queryClass) {
			System.out.println(student.getName());
		}
	}
}
