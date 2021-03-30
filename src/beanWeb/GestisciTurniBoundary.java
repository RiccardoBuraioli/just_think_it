package beanWeb;




import java.sql.SQLException;
import java.util.List;

import controller.GestioneTurniCaritas;
import entity.CaritasUser;
import entity.TurnoTab;



public class GestisciTurniBoundary {

		private CaritasUser caritas;
	    private GestioneTurniCaritas gestTurn;
	    private CaritasUser currentUser;
	    
	    private int id;
	    
	    private static GestisciTurniBoundary instance  = null;
	    
	    public CaritasUser getCurrentUser() {
			return currentUser;
		}

		private CreaTurnoBoundary caritasTurniBoundary;
	    
	  
		public static GestisciTurniBoundary getInstance() {
			if(instance == null) {
				instance = new GestisciTurniBoundary();
			}
			return instance;
			}
	    
	    public GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    	this.caritasTurniBoundary = new CreaTurnoBoundary();
	    }
	    
	   
	    public boolean cancellaTurno(String i) {
	    	if (i == null || i.equals("")) {
	    		return false;
	    	}
	    	else {
	    		int x = Integer.parseInt(i);
	    		gestTurn.cancellaTurno(x);
	    		return true;
	    	}
	    }

	   
	   public void creaTurno() {	 		
	 		caritasTurniBoundary.setCaritas(caritas);	    	
	    }

	   
	  public boolean ModificaTurno(String note) {
			   if (note == null || note.equals("")) {
				   return false;
			   }else {
				  // gestTurn.modificaTurno(turno,note,getIdCar); //posso mettere i numeri per farlo funzionare
		    	return true;
			   }
	  }

	

		public List<TurnoTab> loadFormTurni() {
			 return gestTurn.getInstance().caricaTurni(id);
			
		}

		public void loadFormBoundary(int id) {
			this.id = id;
		}
	}


