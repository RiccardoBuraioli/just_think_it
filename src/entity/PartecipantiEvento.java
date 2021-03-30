package entity;

import java.util.List;

public class PartecipantiEvento {
	private List<PartecipaEvento> partecipanti;
	private float importoTotale;
	private int count;
	
	
	
	public List<PartecipaEvento> getPartecipanti() {
		return partecipanti;
	}
	public void setPartecipanti(List<PartecipaEvento> partecipanti) {
		this.partecipanti = partecipanti;
	}
	public float getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(float importoTotale) {
		this.importoTotale = importoTotale;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	

}
