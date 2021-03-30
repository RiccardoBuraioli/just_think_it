package controller;

import dao.CaritasRepository;
import dao.EventoDao;
import dao.ShopRepository;
import entity.CaritasUser;
import entity.EventTab;
import entity.ShopUser;

public class PromuoviEventoController {
	private CaritasUser caritas;
	private ShopUser shop;
	private EventoDao eventDao;
	
	
	public PromuoviEventoController() {
		eventDao = new EventoDao();
		
	}
	

	public void creaEventoController(String nomeEvento, String tipo, String noteEvento, float prezzoEvento, int idCar, int idUser) {
		CaritasRepository caritasdao = new CaritasRepository();
		ShopRepository shopDao = new ShopRepository();
		this.caritas = caritasdao.getCaritasByID(idCar);
		this.shop = shopDao.getShopByID(idUser);
		EventTab evento = new EventTab(caritas.getId(),tipo,shop.getId(),nomeEvento, this.caritas.getNome(), noteEvento, prezzoEvento, shop.getCoord().getLatitudine(), shop.getCoord().getLongitudine());
		eventDao.creaEvento(evento);
		
	}
	
}
