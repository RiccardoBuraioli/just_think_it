package beanWeb;


import java.util.List;

import controller.GestisciEventiController;
import entity.EventTab;
import entity.ShopUser;


public class GestisciEventiBoundary {

	private GestisciEventiController gestEventC;
	private int idShop;
	
	private EventTab event;
	
	private static GestisciEventiBoundary instance = null;

	public static GestisciEventiBoundary getInstance(){
		if ( instance == null) {
			instance = new GestisciEventiBoundary();
		}
		return instance;
	}
		
	   
	   public void contattaCaritas() {
		   EmailBoundary email = null;
		   email = email.getInstance();
	        email.loadEmail(this.idShop, this.event.getIdCaritas());  	
	   }  	
	    

	    
	   public boolean eliminaEvento(String i) {
		   if (i == null || i.equals("")) {
			   return true;
		   }
		   else {
			   return gestEventC.eliminaEvento(i); 
		   }
	    }

	    
	    void modificaEvento() {
	    	//non si sa se è da fare o no
	    }

	  /*  @FXML
	    void prendiEvento(MouseEvent e) {
	    	this.event = table.getSelectionModel().getSelectedItem();	
	    }*/


	public GestisciEventiBoundary() {

		gestEventC = new GestisciEventiController();

	}

	public GestisciEventiBoundary(int i) {
		gestEventC = new GestisciEventiController();
		this.idShop = i;

	}
	
	public List<EventTab> loadShopBoundary(){
		return gestEventC.getInstance().caricaEventi(idShop);
	}
	

	public void loadShopBean(int idShop) {
		this.idShop = idShop;
	}
	



	

}