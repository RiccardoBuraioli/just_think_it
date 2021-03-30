package controller;

import java.util.List;
import dao.EventoDao;
import entity.EventTab;

public class GestisciEventiCaritasController {

	private EventoDao eventDao;
	private static GestisciEventiCaritasController instance  = null;

	public static GestisciEventiCaritasController getInstance() {
		if(instance == null) {
			instance = new GestisciEventiCaritasController();
		}
		return instance;
		}
	
public List<EventTab> caricaEventi(int idCaritas){
	
		return this.eventDao.cercaEventiCaritas(idCaritas);
		
	}
	

public boolean modificaEvento(int idEve) {
	return eventDao.modificaEvento(idEve);
	
}
	
public GestisciEventiCaritasController() {
	eventDao = new EventoDao();
}
	
public boolean eliminaEvento(String nomeEvento) {
	return eventDao.deliteEvent(nomeEvento);
}
}
