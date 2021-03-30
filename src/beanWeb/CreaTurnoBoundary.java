package beanWeb;



import controller.CreaTurnoController;
import entity.CaritasUser;


public class CreaTurnoBoundary {

	private CaritasUser caritas;

	
	
	public boolean creaTurnoPressed(String nome_giorno, String oraInizio, String oraFine, String  numMaxParte, String note) {
		if (nome_giorno == null || nome_giorno.equals("") || oraInizio == null || oraInizio.equals("") || oraFine.equals("") || oraFine == null || numMaxParte.equals("") || numMaxParte == null || note == null || note.equals("")) {
			return false;
		}else {			
			CreaTurnoController creaTurno = new CreaTurnoController();
			creaTurno.creaEvento(caritas.getId(), nome_giorno,oraInizio, oraFine,Integer.parseInt(numMaxParte), note);
		return true;
		}
	}


	public void setCaritas(CaritasUser caritas) {
		this.caritas = caritas;
	}

}
