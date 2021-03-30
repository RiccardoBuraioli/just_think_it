package beanWeb;

import java.util.List;
import controller.GestisciEventiCaritasController;
import entity.EventTab;

public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private int idCar;
		
		private EventTab event;
		private static GestisciEventiCaritasBoundary instance  = null;
		
		public static GestisciEventiCaritasBoundary getInstance() {
			if(instance == null) {
				instance = new GestisciEventiCaritasBoundary();
			}
			return instance;
			}
		
		
		public boolean cancellaEvent() {
	    	return gestEventC.eliminaEvento(this.event.getNomeEvento());

		 }

		   
		    public void modificaEvent() {
		    		gestEventC.modificaEvento(this.event.getId());
		    }

		  
		   
		    public void contattaShop() {	  
	    	        EmailBoundary email = null;
	    	        email = email.getInstance();
	    	        email.loadEmail(this.event.getCodiceNegozio(), idCar);
	    	        	    	
		    }
		
		
		public List<EventTab> loadFormEvento() {
			return  gestEventC.getInstance().caricaEventi(idCar);
				
		}

		public void loadShop(int idCar) {
			this.idCar = idCar;
		}
		
		public GestisciEventiCaritasBoundary(){
			gestEventC = new GestisciEventiCaritasController();
		}
		
		
		
	}


