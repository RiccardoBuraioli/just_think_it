package entity;

public class PartecipaEvento {
	private int codicePart;
	private int codiceEvento;
	private int codiceVolontario;
	private float importo;
	
	
	
	
	public PartecipaEvento(int codicePart,int codiceEvento,int codiceVolontario,float importo) {
		this.setCodicePart(codicePart);
		this.codiceEvento = codiceEvento;
		this.codiceVolontario = codiceVolontario;
		this.importo = importo;
		
		
		
		
	}
	public PartecipaEvento(int codiceEvento, int codiceVolontario) {
		this.codiceEvento = codiceEvento;
		this.codiceVolontario = codiceVolontario;
	}
	

	
	public int getEvento() {
		return this.codiceEvento;
	}
	public int getVolo() {
		return this.codiceVolontario;
	}
	
	public float getImporto() {
		return this.importo;
	}


	public int getcodice() {
		return this.codiceEvento;
	}
	
	
	
	public void setCodcie(int evento) {
		this.codiceEvento = evento;
	}
	
	public void setCodVol(int vol) {
		this.codiceVolontario = vol;
	}
	
	public void setImport(float importo) {
		this.importo = importo;
	}
	public int getCodicePart() {
		return this.codicePart;
	}
	public void setCodicePart(int codicePart) {
		this.codicePart = codicePart;
	}
}
