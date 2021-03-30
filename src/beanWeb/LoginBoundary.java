package beanWeb;

import controller.CaritasHomeController;
import controller.LoginController;
import controller.ShopHomeController;
import controller.UserHomeController;


public class LoginBoundary {



	private LoginController loginC = new LoginController();

	private beanWeb.UserHomeBoundary userHomeBoundary;
	private UserHomeController userHomeController;
	private beanWeb.ShopHomeBoundary shopHomeBoundary;
	private static LoginBoundary instance = null;
	private beanWeb.CaritasHomeBoundary caritasHomeBoundary;

	public static LoginBoundary getInstance() {
		if (instance == null) {
			instance = new LoginBoundary();

		}
		return instance;
	}
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String loginPressed(String username, String password) {
		int idUser = loginC.trovaID(username);
		String loggedUser = loginC.loginAccess(username, password);
		if (loggedUser.equalsIgnoreCase("Volontario")) {
			userHomeBoundary = userHomeBoundary.getInstance();				
			userHomeController = new UserHomeController();
			userHomeController.initDataCont(idUser, userHomeBoundary);
				
				/*
				userHomeController.load();
				String nome = userHomeController.getNome();
				String cognome = userHomeController.getCognome();
				*/
		} else if (loggedUser.equalsIgnoreCase("Caritas")) {
			caritasHomeBoundary = caritasHomeBoundary.getInstance();
			CaritasHomeController caritasHomeController = new CaritasHomeController();
			caritasHomeController.initDataCaritas(idUser, caritasHomeBoundary);
				
		} else if (loggedUser.equalsIgnoreCase("Negozio")) {
				shopHomeBoundary = shopHomeBoundary.getInstance();
				ShopHomeController shopHomeC = new ShopHomeController();
				shopHomeC.initDataShop(idUser, shopHomeBoundary);
		}
		return loggedUser;

	}
}


