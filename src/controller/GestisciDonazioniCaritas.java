package controller;

import java.util.List;

import dao.DonationDao;
import entity.DonazioneTab;

public class GestisciDonazioniCaritas {

	private DonationDao donDao;
	
	private static GestisciDonazioniCaritas instance  = null;
	
	public static GestisciDonazioniCaritas getInstance() {
		if(instance == null) {
			instance = new GestisciDonazioniCaritas();
		}
		return instance;
		}
	
	
	public GestisciDonazioniCaritas() {
		this.donDao = new DonationDao();
		
	}
	
	public boolean cancellaDonazione(int idDon) {
		return donDao.cancellaDonazione(idDon);
	}
	
	
	public boolean ritiraDon(int idDon) {
		return donDao.modificaDonazione(idDon);
	}
	
	
	public List<DonazioneTab> visualizzaDonazioni(int idCar){
		return donDao.visualizzaDonazioni(idCar);
	}
	
	
	
}
