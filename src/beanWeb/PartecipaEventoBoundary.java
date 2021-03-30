package beanWeb;

import controller.PartecipaEventoController;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;

	private PartecipaEventoController partecipaC;
	private static PartecipaEventoBoundary instance = null;
	 
	public static PartecipaEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PartecipaEventoBoundary();
		}
		return instance;
		}
	
	public PartecipaEventoBoundary() {
		partecipaC = PartecipaEventoController.getInstance();
	}


	public boolean partecipaEvento(String importo, String carta) {
		if (importo == null || importo.equals("") || carta == null || importo.equals("")) {
			return false;
		}
		else {
			partecipaC.getInstance().setDataController(idEvento, idUtente);
			partecipaC.getInstance().partecipaEvento(Float.parseFloat(importo));
			return true;
		}
	}

	
	public void setData(int idEvento, int idVolontario) {
		this.idEvento = idEvento;
		this.idUtente = idVolontario;
	}

	public int getIdUtente() {
		return idUtente;
	}




}
