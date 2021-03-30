package controller;



import dao.CaritasRepository;
import entity.CaritasUser;

/**
 * Sample Skeleton for "CaritasHomePage.fxml" Controller Class You can copy and
 * paste this code into your favorite IDE
 **/

public class CaritasHomeController {

	private CaritasUser currentUser;


	public CaritasUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initDataCaritas(int idUser, Object caritasHomeBoundary) {
		CaritasRepository c = new CaritasRepository();
		currentUser = c.getCaritasByID(idUser);
		if(caritasHomeBoundary.getClass() == bean.CaritasHomeBoundary.class) {
			((bean.CaritasHomeBoundary) caritasHomeBoundary).initDataC(currentUser.getId(), currentUser.getNome());
		}
		else if (caritasHomeBoundary.getClass() == beanWeb.CaritasHomeBoundary.class) {
			((beanWeb.CaritasHomeBoundary) caritasHomeBoundary).initDataC(currentUser.getId(), currentUser.getNome());
		}
	}

}
