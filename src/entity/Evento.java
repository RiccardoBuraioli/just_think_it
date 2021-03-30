package entity;

import javafx.beans.property.SimpleStringProperty;

public class Evento {
	
	private SimpleStringProperty nomeEvento;
	private String tipoEvento;
	private String noteEvento;
	private float prezzoEvento;
	private int idNegozio;
	private String coord;
	private int idCaritas;

	
	
	public Evento(String nomeEvento,String tipoEvento,String noteEvento,float prezzoEvento,int idNegozio,String coord, int idCaritas) {
		
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.tipoEvento = tipoEvento;
		this.noteEvento = noteEvento;
		this.prezzoEvento = prezzoEvento;
		this.idNegozio = idNegozio;
		this.coord = coord;
		this.idCaritas = idCaritas;
	}
	
	public Evento(String nomeEvento,String tipoEvento,float prezzoEvento,int idNegozio, int idCaritas) {
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.tipoEvento = tipoEvento;
	
		this.prezzoEvento = prezzoEvento;
		this.idNegozio = idNegozio;
		this.idCaritas = idCaritas;
	}
	
	
	public String getNomeEvento() {
		return nomeEvento.get();
	}

	public void setNomeEvento(String nomeEve) {
		nomeEvento.set(nomeEve);
	}

	public String getTipo() {
		return this.tipoEvento;
	}
	public String getNote() {
		return this.noteEvento;
	}
	
	public float getPrezzo() {
		return this.prezzoEvento;
	}
	public int getNeg() {
		return this.idNegozio;
	}
	public String getCoord() {
		return this.coord;
	}
	
	
	public void setCoord(String coordinate) {
		 this.coord = coordinate;
	}

	public int getIdCaritas() {
		return idCaritas;
	}

	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}
	
	
}
