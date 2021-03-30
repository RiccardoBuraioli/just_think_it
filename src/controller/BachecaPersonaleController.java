package controller;

import java.util.List;


import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessita;




public class BachecaPersonaleController {
	
	private BachecaDao bacheca;
	 private static BachecaPersonaleController instance  = null;
	 
	 
	public static BachecaPersonaleController getInstance() {
		if(instance == null) {
			instance = new BachecaPersonaleController();
		}
		return instance;
		}
	
	
	
	public boolean eliminaAnnuncio(int nece) {
	
		return	bacheca.eliminaNecessita(nece); 
		
		
	}
	
	
	
	public List<Necessita> loadForm(int idCar) {
		
		bacheca = new BachecaDao();
		BachecaEntity bachecaE = new BachecaEntity();
		List<Necessita> necessita = bacheca.visualizzaNecessita(idCar);
		bachecaE.setNecessita(necessita);
	
		return necessita;
	}
	
}
