package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dao.LoginRegisterDao;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginRegisterDaoTest.
 *
 * @date 2020��7��2��
 * @author linyuju
 * @version v1.0
 */
public class LoginRegisterDaoTest {
	
	/**
	 * Login test.
	 * ��¼��֤�Ĳ���
	 */
	@Test
	public void loginTest() {
		LoginRegisterDao login=new LoginRegisterDao();
		int loginVerify = login.loginVerify("�����", "123456");
		assertEquals(1, loginVerify);
	}
	
	/**
	 * Register test.
	 * ע����֤�Ĳ���
	 */
	@Test
	public void registerTest() {
		LoginRegisterDao register=new LoginRegisterDao();
		int registerVerify = register.RegisterVerify("�����", "2018401215", "2018��3��");
	}
}
