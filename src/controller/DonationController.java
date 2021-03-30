package controller;

import dao.DonationDao;
import entity.Donazione;


public class DonationController {

	private static DonationController instance = null;
	
	private Donazione donazione;
	private DonationDao donazioneDao;

	
	private DonationController() {
		donazione = new Donazione();
		donazioneDao = new DonationDao();
	}
	


	public static DonationController getInstance() {
		if (DonationController.instance == null)
			DonationController.instance = new DonationController();
		return instance;
	}

	
	public void initController(int idCar, int idUt) {
		this.donazione.setIdCaritas(idCar);
		this.donazione.setIdUtente(idUt);
	}

	public void setTipologia(int tipo) {
		this.donazione.setTipologia(tipo);
	}

	public Donazione getDonazione() {
		return donazione;
	}

	public void setDonazione(Donazione donazione) {
		this.donazione = donazione;
	}

	public void setIndirizzo(String texts) {
		this.donazione.setIndirizzo(texts);
	}

	public void setDescrizione(String text) {
		this.donazione.setDescrizione(text);
	}

	public int creaDonazione() {
		return donazioneDao.creaDonazione(donazione);
	}
	
	
	
	
	public int creaDonazione2(int tipo, String indirizzo, String descrizione, int idUtente, int idCaritas) {
		
		Donazione don = new Donazione(descrizione,  indirizzo, idUtente,idCaritas,tipo);
		
		
		
		return donazioneDao.creaDonazione(don);
	}
}
