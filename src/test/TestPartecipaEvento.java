package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.PartecipaEventoController;

public class TestPartecipaEvento {
	PartecipaEventoController partecipaEv;
	
	public TestPartecipaEvento() {
		partecipaEv = new PartecipaEventoController();
		
	}
	@Test
	public void testParte() {
		partecipaEv.setDataController(1,3);
		assertEquals(false, partecipaEv.partecipaEvento((float) 23.54));
	}
}
