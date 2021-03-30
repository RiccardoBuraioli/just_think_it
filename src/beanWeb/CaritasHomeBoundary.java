package beanWeb;


public class CaritasHomeBoundary {

	
	private int idCar;
	
	private static CaritasHomeBoundary instance = null;

	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;
	private GestisciEventiCaritasBoundary gestisciB;
	private BachecaPersonaleBoundary bacheca;



	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
		}
		return instance;
	}

	public CaritasHomeBoundary() {
		bacheca = new BachecaPersonaleBoundary();
		gestTurn = new GestisciTurniBoundary();
		gestDon = new GestisciDonazioniBoundary();
		gestisciB = new GestisciEventiCaritasBoundary();
	}

	public void gestisciDonazioni() {		
		gestDon.getInstance().loadFormBoundary(idCar);
	}

	
	public void gestisciEventi() {			
			gestisciB.getInstance().loadShop(idCar);
	}

	
	public void gestisciTurni() {
			gestTurn.getInstance().loadFormBoundary(idCar);
	}

	public void visualizzaBacheca() {		
			bacheca.getInstance().loadFormBoundary(idCar);
	}

	void deleteAccountButtonPressed() {
		// handle the event here
	}

	void helpButtonPressed() {
		// handle the event here
	}


	
	/*void logoutButtonPressedCaritas() {
	 	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	

	}*/

	public void initDataC(int id, String nome) {
		this.idCar = id;
		//nomeCognome.setText(nome);
	}

}