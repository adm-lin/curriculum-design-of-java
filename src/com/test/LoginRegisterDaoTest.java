package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dao.LoginRegisterDao;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginRegisterDaoTest.
 *
 * @date 2020年7月2日
 * @author linyuju
 * @version v1.0
 */
public class LoginRegisterDaoTest {
	
	/**
	 * Login test.
	 * 登录验证的测试
	 */
	@Test
	public void loginTest() {
		LoginRegisterDao login=new LoginRegisterDao();
		int loginVerify = login.loginVerify("林宇驹", "123456");
		assertEquals(1, loginVerify);
	}
	
	/**
	 * Register test.
	 * 注册验证的测试
	 */
	@Test
	public void registerTest() {
		LoginRegisterDao register=new LoginRegisterDao();
		int registerVerify = register.RegisterVerify("林宇驹", "2018401215", "2018级3班");
	}
}
