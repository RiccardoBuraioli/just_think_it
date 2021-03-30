package beanWeb;

import java.util.List;

import controller.BachecaController;
import entity.Necessita;

public class BachecaBoundary {
	private int idCar;
	private int idUte;
	private DonationBoundary donationBoundary;
	private static BachecaBoundary instance = null;
	private BachecaController bachecaController;
	
	
	
	public static BachecaBoundary getInstance() {
		if(instance == null) {
			instance = new BachecaBoundary();
		}
		return instance;
		}
	
	public BachecaBoundary(){
		bachecaController = BachecaController.getInstance();
	}
	
	
	public void creaEmail() {
		EmailBoundary emailBoundary = null;
		emailBoundary = emailBoundary.getInstance();
		emailBoundary.loadEmail(idCar, idUte);
		}

	
	public void creaDonazione() {
		donationBoundary = donationBoundary.getInstance();
		donationBoundary.initBoundary(this.idCar, this.idUte);
	}
	
 	
	public List<Necessita> loadNecessita(){
		return bachecaController.getInstance().loadForm(this.idCar);
	}
	
	public void loadFormBoundary(int idCar, int idUte) {
		this.idCar  = idCar;
		this.idUte = idUte;
	}

}
