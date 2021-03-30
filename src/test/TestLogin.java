package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.LoginController;

public class TestLogin {
	
	private LoginController loginController;
	
	public TestLogin() {
		loginController = new LoginController();
	}
	
	@Test
	public void checkLogin() {
		assertEquals(17, loginController.trovaID("c"));
	}

	@Test
	public void checkTipo() {
		assertEquals("Caritas" , loginController.loginAccess("c", "c"));
	}
	
}
