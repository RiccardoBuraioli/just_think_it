package entity;

public class CaritasUser extends User {
	private String tipologia;
	
	public CaritasUser() {}
	
	public CaritasUser(String nome, String tipo, String password, String indirizzo, String recapitoTel, String email, String citta) {	
		super(nome, password, indirizzo, recapitoTel, email,  citta, "Caritas");
		this.tipologia = tipo;
		
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	
}
