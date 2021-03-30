package controller;


import java.util.List;
import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessita;


public class BachecaController  {

	
	private static BachecaController instance = null;

	public List<Necessita> loadForm(int idCar) {
		BachecaDao bacheca = new BachecaDao();
		BachecaEntity bachecaEntity = new BachecaEntity();
		List<Necessita>	necessita = bacheca.visualizzaNecessita(idCar);
		bachecaEntity.setNecessita(necessita);
		return bachecaEntity.getNecessita();
			
		
		}

	public static BachecaController getInstance() {
		if ( BachecaController.instance == null)
			 BachecaController.instance = new BachecaController();
		return instance;
	}
	
	
}
