package beanWeb;

import java.util.ArrayList;
import java.util.List;
import controller.GestisciDonazioniCaritas;
import entity.DonazioneTab;




public class GestisciDonazioniBoundary {
	private int caritas;

	private int idVolontario;
	private int idDono;

	private GestisciDonazioniCaritas gestDon;
	
	 private static  GestisciDonazioniBoundary instance  = null;
	
	 public static  GestisciDonazioniBoundary getInstance() {
			if(instance == null) {
				instance = new  GestisciDonazioniBoundary();
			}
			return instance;
			}
	
	public boolean cancellaDonazione(String i) {
		    	gestDon = new  GestisciDonazioniCaritas();
		    	if (i == null || i.equals("") ) {
		    		return false;
		    	}
		    	else {
		    		int x = Integer.parseInt(i);
		    		gestDon.cancellaDonazione(x);
		    		return true;
		    	}
		    }
		    

	public void contattaVolontario() {
		EmailBoundary email = new EmailBoundary();
		email.loadEmail(this.idVolontario, caritas);
	}

	
	public void ritiraDonazione() {
		gestDon.ritiraDon(this.idDono);
	}


	public List<DonazioneTab> loadFormDonazione() {
			return gestDon.visualizzaDonazioni(caritas);	
	}

	public void loadFormBoundary(int caritas ) {
		this.caritas = caritas;
	}
	public GestisciDonazioniBoundary() {
		this.gestDon = new GestisciDonazioniCaritas();
		new ArrayList<>();
	}



}
