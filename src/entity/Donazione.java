package entity;



public class Donazione {
	private String descrizione;
	private String indirizzo;
	private int idUtente;
	private int idCaritas;
	
	private int tipologia;
	

	public Donazione( String descrizione, String indirizzo,int idUtente, int idCaritas, int tipologia) {
		this.descrizione = descrizione;
		this.indirizzo = indirizzo;
		this.idCaritas = idCaritas;
		this.idUtente = idUtente;
		this.tipologia = tipologia;
	}

	public Donazione() {
		this.descrizione = "";
		this.indirizzo= "";
		this.idUtente= 0;
		this.idCaritas= 0;
		
		this.tipologia= 0;
		
	}
	

	

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdCaritas() {
		return idCaritas;
	}

	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}


	public int getTipologia() {
		return tipologia;
	}

	public void setTipologia(int tipologia) {
		this.tipologia = tipologia;
	}
	

	
	
}
