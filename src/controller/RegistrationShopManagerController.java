package controller;


import dao.ShopRepository;
import entity.ShopUser;
import javafx.stage.Window;

public  class RegistrationShopManagerController {





	public RegistrationShopManagerController() {
		//dai dai
	}

	public void backButtonNegPressed(Window window) {
 // ma quanti back
	
	}

	public int  registraNegozioPressed( String tipo, String nome, String pass, String via, String tel,String mail, String citta) {

		ShopUser shop = new ShopUser(nome, pass,tipo, via,  tel, mail, citta);
		ShopRepository crep = new ShopRepository();
		int id = crep.insertShop(shop);
		shop.setId(id);
		return id;
	}


}