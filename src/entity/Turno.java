package entity;

public class Turno {
	private String oraInizio;
	private String oraFine;
	private String giorno;
	int idTurno;



	public Turno() {
		this.oraInizio ="";
		this.oraFine ="";
		this.giorno ="";
		this.idTurno = 0;
	}
	
	public Turno(String giorno, String oraIn, String oraFin) {
		this.giorno = giorno;
		this.oraFine = oraFin;
		this.oraInizio = oraIn;
	
	}
	
	public String getOrai() {
		return this.oraInizio;
	}
	
	
	public String getOraf() {
		return this.oraFine;
	}
	
	
	public String getGiorno() {
		return this.giorno;
	}
	
	

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	
	
	public void setOrai(String orai) {
		this.oraInizio = orai;
		
	}
	public void setOraf(String oraf) {
		this.oraFine = oraf;
	}
	
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
}
