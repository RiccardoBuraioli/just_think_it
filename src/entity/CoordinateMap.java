package entity;

public class CoordinateMap {
	private double longitudine;
	private double latitudine;
	private int idMarker;

	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}

	public String getLatitudine() {
		return String.valueOf(latitudine);
	}

	public String getLongitudine() {
		return String.valueOf(longitudine);
	}

	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}

	public CoordinateMap(double longi, double lati, int id) {
		this.longitudine = longi;
		this.latitudine = lati;
		this.setIdUtente(id);
	}

	public int getIdMarker() {
		return idMarker;
	}

	public void setIdUtente(int idMark) {
		this.idMarker = idMark;
	}
}
