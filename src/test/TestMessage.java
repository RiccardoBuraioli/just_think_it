package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.EmailController;

public class TestMessage {
	private EmailController emailController;
	
	public TestMessage() {
		emailController = new EmailController();
		
	}
	@Test
	public void testSendMessage() {
		assertEquals(0,emailController.sendMessageController("c", "R", "testbello", "Test"));
	}
	
	
}
