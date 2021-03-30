package controller;

import dao.BachecaDao;
import entity.Necessita;

public class CreaNecessitaController {
	private BachecaDao creaBachecaDao;
	
	private int idCaritas;
	
	public CreaNecessitaController() {
		creaBachecaDao = new BachecaDao();
		
	}
	
	public int creaNecessita(String tipo, String urg, String desc) {
		
		Necessita necessita = new Necessita(tipo, desc, urg);
		creaBachecaDao.creaNecessita(necessita, idCaritas);
		return 0;
		
	}
	
	
	
	public void inizializza(int codCar) {
		this.idCaritas = codCar;
	}
	
}
