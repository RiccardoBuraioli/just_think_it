package entity;



public class User {
	protected int id;
	protected String nome;
	protected String password;
	protected String indirizzo;
	protected String recapitoTel;
	protected String email;
	protected String citta;
	protected CoordinateMap coord;
	protected String ruolo;
	


	public User() {}
	
	public User( String nome,  String password, String indirizzo, String recapitoTel, String email,  String citta, String ruolo) {
		this.nome = nome;		
		this.password = password;
		this.indirizzo = indirizzo;
		this.recapitoTel = recapitoTel;
		this.email = email;		
		this.citta = citta;
		this.ruolo = ruolo;
		this.coord = null;
	 }
	
	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getRecapitoTel() {
		return recapitoTel;
	}
	public void setRecapitoTel(String recapitoTel) {
		this.recapitoTel = recapitoTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public CoordinateMap getCoord() {
		return coord;
	}

	public void setCoord(CoordinateMap coord) {
		this.coord = coord;
	}
	
	
}
