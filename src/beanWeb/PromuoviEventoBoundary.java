package beanWeb;
import java.sql.SQLException;

import controller.PromuoviEventoController;


public class PromuoviEventoBoundary {


		private int idCar;
		private int idShop;
		private static PromuoviEventoBoundary   instance  = null;

		
public static PromuoviEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PromuoviEventoBoundary();
		}
		return instance;
		}
	   
	    
	    
	   public boolean confermaPressed(String nome, String tipo, String note, String costoEvento){
		   if (nome == null || nome.equals("")|| tipo == null || tipo.equals("") || note == null || note.equals("") || costoEvento == null || costoEvento.equals("")) {
			   return false;
		   }
		   else {
			   float prezzo = Float.parseFloat(costoEvento);
			   PromuoviEventoController promuoviEvento = new PromuoviEventoController();
			   promuoviEvento.creaEventoController(nome,tipo, note, prezzo , idCar,idShop);	
			   return true;
		   }
	    }

	   
		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

	

}
