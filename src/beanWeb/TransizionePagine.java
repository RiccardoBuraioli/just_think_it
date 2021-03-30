package beanWeb;


import java.sql.SQLException;
import controller.CaritasHomeController;
import controller.CercaCaritasController;


public class TransizionePagine {
	private beanWeb.CercaCaritas cercaCaritasBean;

	public TransizionePagine() {
		//default
	}
				
	
	public void apriMappa(int idUser){
	        
	        try {
				cercaCaritasBean = cercaCaritasBean.getInstance();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        CercaCaritasController controller = new CercaCaritasController(); 
	        controller.initUser(idUser, cercaCaritasBean);
	}
	
	
	public void backToMenuCaritas(int idUser) {
			CaritasHomeBoundary caritasHomeBoundary = new CaritasHomeBoundary();
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(idUser, caritasHomeBoundary);
	}
	

/*	public boolean checkerText(TextField[] text) {
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().isEmpty()) {
				
				return true;
			}
		}
				
		return false;
	}*/
	
	
	
	
}
