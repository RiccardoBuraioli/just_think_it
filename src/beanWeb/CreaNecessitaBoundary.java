package beanWeb;

import controller.CreaNecessitaController;


public class CreaNecessitaBoundary {
	
		private int idCaritas;
		private String richiesta;
	    private String tipologia;
	    private String urgenza;
	  
	    
	 
	    public boolean creaAnnuncioPressed(String tipologia,String urgenza,String richiesta) {
	    	if (tipologia == null || tipologia.equals("") || urgenza == null || urgenza.equals("") || richiesta == null || richiesta.equals("")) {
	    		return false;
	    	}else {
	    		CreaNecessitaController creaNec = new CreaNecessitaController();
	    		creaNec.inizializza(idCaritas);
	    		creaNec.creaNecessita(tipologia, urgenza, richiesta);
	    		return true;
	    	}
	    }

	    
	    public String getRichiesta() {
			return richiesta;
		}

		public void setRichiesta(String richiesta) {
			this.richiesta = richiesta;
		}

		public String getTipologia() {
			return tipologia;
		}

		public void setTipologia(String tipologia) {
			this.tipologia = tipologia;
		}

		public String getUrgenza() {
			return urgenza;
		}

		public void setUrgenza(String urgenza) {
			this.urgenza = urgenza;
		}

	

		  
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	    
	

}
