package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.CreaNecessitaController;

public class TestNecessita {
	CreaNecessitaController creaNece;
	
	public TestNecessita() {
		creaNece = new CreaNecessitaController();
	}
	
	
	@Test
	public void testNece() {
		assertEquals(0, creaNece.creaNecessita("Cibo", "Alta", "Voglio il latte"));
	}
	

}
