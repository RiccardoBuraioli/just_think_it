package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TurnoTab {
	private SimpleIntegerProperty id;
	private SimpleIntegerProperty idCar;
	private SimpleStringProperty giorno;
	private SimpleStringProperty oraInizio;
	private SimpleStringProperty oraFine;
	private SimpleStringProperty note;
	private SimpleStringProperty partecipanti;


	private SimpleStringProperty orario;

	public TurnoTab(int partecipantiMax,int id,int caritas, String giorno, String oraIn, String oraFin, String note, int parte) {
		this.idCar = new SimpleIntegerProperty(caritas);
		this.id = new SimpleIntegerProperty(id);
		this.giorno = new SimpleStringProperty(giorno);
		this.oraInizio = new SimpleStringProperty(oraIn);
		this.oraFine = new SimpleStringProperty(oraFin);
		this.note = new SimpleStringProperty(note);
		this.partecipanti = new SimpleStringProperty(parte + "/" + partecipantiMax);
		this.orario = new SimpleStringProperty(oraIn + "/" + oraFin);

	}

	public String getGiorno() {
		return this.giorno.get();
	}

	public void setGiorno(String giorno) {
		this.giorno.set(giorno);
	}

	public String getOraIn() {
		return this.oraInizio.get();
	}

	public void setOraIn(String orario) {
		this.oraInizio.set(orario);
	}

	public String getNote() {
		return this.note.get();
	}

	public void setNote(String note) {
		this.note.set(note);
	}

	public String getPartecipanti() {
		return this.partecipanti.get();
	}

	public void setPartecipanti(String partecipanti) {
		this.partecipanti.set(partecipanti);
	}

	public String getOraFine() {
		return this.oraFine.get();
	}

	public void setOraFine(String oraFine) {
		this.oraFine.set(oraFine);
	}

	public void setOrario(String orario) {
		this.orario.set(orario);
	}

	public String getOrario() {
		return this.orario.get();
	}

	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public int getIdCar() {
		return idCar.get();
	}

	public void setIdCar(int idCar) {
		this.idCar.set(idCar);
	}


}
