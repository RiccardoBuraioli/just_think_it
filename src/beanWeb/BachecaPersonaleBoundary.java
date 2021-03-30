package beanWeb;

import java.util.List;
import controller.BachecaPersonaleController;
import entity.Necessita;

public class BachecaPersonaleBoundary {
	
	private int idCar;
	private BachecaPersonaleController bachecaController;
	private CaritasHomeBoundary caritasHomeBoundary;
	private CreaNecessitaBoundary creaNec;
	private Necessita nec;
	private int i;
	
	private static BachecaPersonaleBoundary instance  = null;
	
	public static BachecaPersonaleBoundary getInstance() {
		if(instance == null) {
			instance = new BachecaPersonaleBoundary();
		}
		return instance;
		} 
	 
	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public Necessita getNec() {
		return nec;
	}



	public void setNec(Necessita nec) {
		this.nec = nec;
	}

	
	public CreaNecessitaBoundary getCreaNec() {
		return creaNec;
	}



	public void setCreaNec(CreaNecessitaBoundary creaNec) {
		this.creaNec = creaNec;
	}



	public CaritasHomeBoundary getCaritasHomeBoundary() {
		return caritasHomeBoundary;
	}



	public void setCaritasHomeBoundary(CaritasHomeBoundary caritasHomeBoundary) {
		this.caritasHomeBoundary = caritasHomeBoundary;
	}


	public void creaNecessita() {
			 creaNec.setCaritas(idCar);
	}

	
	public boolean eliminaNecessita(String i){
		bachecaController = new BachecaPersonaleController();
		if (i == null || i.equals("")) {
			return false;
		}
		else {
			int x = Integer.parseInt(i);
			bachecaController.getInstance().eliminaAnnuncio(x);
			return true;
		}
	}

	public List<Necessita> loadFormBacheca(){
		return bachecaController.getInstance().loadForm(idCar);
		}

	
	public void loadFormBoundary(int idCar) {
		this.idCar = idCar;
	}
	


}
