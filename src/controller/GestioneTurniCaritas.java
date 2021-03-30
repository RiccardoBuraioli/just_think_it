package controller;

import java.util.List;

import dao.PrenotaDao;
import entity.TurnoTab;

public class GestioneTurniCaritas {
	
	private PrenotaDao turniDao;
	private static GestioneTurniCaritas instance = null;
	
	public GestioneTurniCaritas() {
		this.turniDao = new PrenotaDao();
	}
	
	public static GestioneTurniCaritas getInstance() {
		if (GestioneTurniCaritas.instance == null)
			GestioneTurniCaritas.instance = new GestioneTurniCaritas();
		return instance;
	}
	
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		
		return this.turniDao.modificaTurno(idTurn, newNote, codCar);
		
	}
	
	
	
	public boolean cancellaTurno(int idTurn) {
		
		return this.turniDao.cancellaTurno(idTurn);
		
	}
	
	
	
	public List<TurnoTab> caricaTurni(int idCaritas) {
		return this.turniDao.visualizzaTurni(idCaritas);
	}

}
