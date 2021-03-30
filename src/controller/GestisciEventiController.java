package controller;

import java.util.List;

import dao.EventoDao;
import entity.EventTab;

public class GestisciEventiController {


	private EventoDao eventDao;
	private static GestisciEventiController instance  = null;
	
	
	public static GestisciEventiController getInstance() {
		if (instance == null) {
			instance = new GestisciEventiController();
		}
		return instance;
	}
	
	
	
	public GestisciEventiController() {
	
		eventDao = new EventoDao();
	}
	
	
	public List<EventTab> caricaEventi(int idShop){
		return eventDao.cercaEventi(idShop);
		
	}
	
	public boolean eliminaEvento(String nomeEvento) {
		return eventDao.deliteEvent(nomeEvento);
	}
	
	
	public boolean modificaNoteEvento() {
		//da fare?
		return false;
		
	}
	
}
