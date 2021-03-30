package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Necessita {
	private SimpleIntegerProperty idNece;
	private SimpleStringProperty tipologia;
	private SimpleStringProperty descrizione;
	private SimpleStringProperty urgenza;

	
	public Necessita(int nece, String tipo, String descr, String urg) {
		this.descrizione= new SimpleStringProperty(descr);
		this.tipologia = new SimpleStringProperty(tipo);
		this.urgenza = new SimpleStringProperty(urg);
		this.idNece = new SimpleIntegerProperty(nece);
	}
	
	public Necessita( String tipo, String descr, String urg) {
		this.descrizione= new SimpleStringProperty(descr);
		this.tipologia = new SimpleStringProperty(tipo);
		this.urgenza = new SimpleStringProperty(urg);
		
	}
	


	public Necessita() {
		
	}


	public String getTipologia() {
		return tipologia.get();
	}


	public void setTipologia(String tipo) {
		tipologia.set(tipo);
	}


	public String getDescrizione() {
		return descrizione.get();
	}


	public void setDescrizione(String des) {
		descrizione.set(des);
	}


	public String getUrgenza() {
		return urgenza.get();
	}


	public void setUrgenza(String urgenza) {
		this.urgenza.set(urgenza);
	}


	public int getIdNece() {
		return idNece.get();
	}


	public void setIdNece(int idNece) {
		this.idNece.set(idNece);
	}
}
