package entity;

public class Orario {
	private String oraInizio;
	private String oraFine;
	
	
	
	public Orario() {
		
	}



	public Orario(String oraIn, String oraFin) {
		this.oraFine= oraIn;
		this.oraInizio= oraFin;
	}



	public String getOraInizio() {
		return oraInizio;
	}



	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}



	public String getOraFine() {
		return oraFine;
	}



	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}
	
	
	
	
	
}
