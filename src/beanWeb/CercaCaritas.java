package beanWeb;




import controller.CercaCaritasController;
import controller.ShopHomeController;
import controller.UserHomeController;
import entity.CoordinateMap;
import entity.MarkerID;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CercaCaritas {

	public enum MarkerType {
		CARITAS, EVENTO, DONAZIONE, MAP
	}
	
	private int idCaritas;
	private int idEvento;

	private String ruolo;
	private int idUser;
	private String v = "Volontario";
	private String c = "Caritas";
	private String n = "Negozio";
	
	/** logger for the class. */
	private static final Logger logger = LoggerFactory.getLogger(CercaCaritas.class);

	
	

	private static CercaCaritas instance  = null;

	/** default zoom value. */
	private static final int ZOOMDEFAULT = 14;

	/** the markers. */
	private CercaCaritasController cercaController;

	private List<CoordinateMap> markerCaritas;
	private List<CoordinateMap> markerEventi;
	private List<CoordinateMap> markerDonazioni;
	private DonationBoundary donationBoundary;
	private PrenotaTurnoBoundary prenotaTurnoBoundary;
	private BachecaBoundary bachecaBoundary;
	private PartecipaEventoBoundary partecipaEventoBoundary;
	private PromuoviEventoBoundary promuoviEventoBoundary;
	
	public static CercaCaritas getInstance() throws NumberFormatException, SQLException{
		if(instance == null) {
			instance = new CercaCaritas();
		}
		return instance;
		}
	
	
	
	
	public void indietro() {
	if (ruolo.equals(v)) {				
				UserHomeBoundary userHomeBoundary = new UserHomeBoundary();
				UserHomeController userHomeController = new UserHomeController();
				userHomeController.initDataCont(this.idUser,userHomeBoundary);
	}
	else if(ruolo.equalsIgnoreCase(n)) {
			ShopHomeBoundary shopHomeBoundary = new ShopHomeBoundary();
			ShopHomeController shopHomeC = new ShopHomeController();
			shopHomeC.initDataShop(this.idUser, shopHomeBoundary);
	}
	else {
		
	}
	}
	
	public void promuoviEvento(int idCar) {
			promuoviEventoBoundary = promuoviEventoBoundary.getInstance();
			System.out.print(idCar);
			promuoviEventoBoundary.loadFormBoundary(idCar, this.idUser);
		}


	public  void vediNecessita(int idCar) {
			bachecaBoundary = bachecaBoundary.getInstance();
			bachecaBoundary.loadFormBoundary(idCar, this.idUser);
	}

	public void creaDonazione(int idCar) {
			donationBoundary =  donationBoundary.getInstance();
			donationBoundary.initBoundary(idCar, this.idUser);
	}

	public void prenotaTurno(int idCar) {
			prenotaTurnoBoundary = prenotaTurnoBoundary.getInstance();
			prenotaTurnoBoundary.setData(idCar, this.idUser);		
	}
	

	public void partecipaEvento(int idEvent) {
			partecipaEventoBoundary = partecipaEventoBoundary.getInstance();
			partecipaEventoBoundary.setData(idEvent, this.idUser);
		}

	

	public CercaCaritas(){
		cercaController = new CercaCaritasController();

	}

	public String trovaRuoloBean() {
		return cercaController.trovaRuolo(this.idUser);
	}
	

	public List<CoordinateMap> initMarkersCaritas() {
		return cercaController.initMarkerCar();
	}

	public List<CoordinateMap> initMarkersEvento() {
		return cercaController.initMarkerEvent();
	}
	
	public List<CoordinateMap> initMarkersDonazione() {
		return cercaController.initMarkerDonation();
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public int getIdUte() {
		return this.idUser;
	}
	

	public void setUser(int id, String ruolo) {
		this.idUser = id;
		this.ruolo = ruolo;
		

	}
	public int getIdCaritas() {
		return idCaritas;
	}
	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}
}
