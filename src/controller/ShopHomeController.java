package controller;

import dao.ShopRepository;
import entity.ShopUser;
import javafx.stage.Window;

public class ShopHomeController {

	

	private ShopUser currentUser;

	public ShopUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(ShopUser currentUser) {
		this.currentUser = currentUser;
	}


	public void deleteAccountButtonPressed(Window event) {
		//funzionera
	}

	public void initDataShop(int id, Object shopBean) {
		ShopRepository sd = new ShopRepository();
		currentUser = sd.getShopByID(id);
		if(shopBean.getClass() == bean.ShopHomeBoundary.class) {
		((bean.ShopHomeBoundary) shopBean).initData(currentUser.getId(), currentUser.getNome());
		}
		else if(shopBean.getClass() == beanWeb.ShopHomeBoundary.class) {
			((beanWeb.ShopHomeBoundary) shopBean).getInstance().initData(currentUser.getId(), currentUser.getNome());
			}
	}


}
