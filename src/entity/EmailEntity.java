package entity;

public class EmailEntity {
	private int idEmail;
	
	
	
	public int getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}


	private String emailMittente;
	private String emailDestinatario;
	private String messaggio;
	private String oggetto;
	
	
	public EmailEntity(String idM, String idD, String mes, String ogg) {
		this.emailMittente = idM;
		this.emailDestinatario = idD;
		this.messaggio = mes;
		this.oggetto = ogg;
		this.idEmail = 0;
	}
	
	public EmailEntity(int idEmail, String messaggio, String oggetto) {
		this.idEmail = idEmail;
		this.messaggio = messaggio;
		this.oggetto = oggetto;
	}


	public String getIdMittente() {
		return emailMittente;
	}


	public void setIdMittente(String idCaritas) {
		this.emailMittente = idCaritas;
	}


	public String getIdDestinatario() {
		return emailDestinatario;
	}


	public void setIdDestinatario(String idUtente) {
		this.emailDestinatario = idUtente;
	}


	public String getMessaggio() {
		return messaggio;
	}


	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}


	public String getOggetto() {
		return oggetto;
	}


	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

}
