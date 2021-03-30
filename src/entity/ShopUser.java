package entity;

public class ShopUser extends User{
	private String tipologia;
	
	public ShopUser() {}
	
	public ShopUser( String nome, String tipo, String password, String indirizzo, String recapitoTel, String email, String citta) {	
		super(nome, password, indirizzo, recapitoTel, email,  citta, "Negozio");
		this.tipologia = tipo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
}
