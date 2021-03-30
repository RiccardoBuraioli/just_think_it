package controller;

import dao.PrenotaDao;

public class CreaTurnoController {


	private PrenotaDao turnodao;
	
	public CreaTurnoController() {
		turnodao = new PrenotaDao();
	}
	
	
	public boolean creaEvento(int codCar, String giorno, String oraIni, String oraFin, int numPart, String newNote) {
		return turnodao.creaTurno(codCar, giorno, newNote, oraIni, oraFin, numPart);
	}
}
