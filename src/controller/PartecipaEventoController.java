package controller;

import entity.PartecipaEvento;
import dao.EventoDao;

public class PartecipaEventoController {

	private PartecipaEvento partecipaz;
	private static PartecipaEventoController instance = null;


	public static PartecipaEventoController  getInstance() {
		if(instance == null) {
			instance = new PartecipaEventoController ();
		}
		return instance;
		}
	
	
	
	public boolean partecipaEvento(float importo) {
	
		partecipaz.setImport(importo);

		EventoDao partecipazione = new EventoDao();

		return partecipazione.creaPartecipazione(partecipaz);

	}

	public void setDataController(int idEv, int idVol) {
		
		partecipaz = new PartecipaEvento(idEv, idVol);

	}

}
