package entity;

public class PartecipaTurno {
	private int codiceVolontario;
	private int codiceTurno;
	private int codiceCaritas; 
	private String curriculum;
	
	public PartecipaTurno(int codV, int codT, int codC, String cv) {
		this.codiceCaritas = codC;
		this.codiceTurno = codT;
		this.codiceVolontario= codV;
		this.curriculum = cv;
	}
	
	
	
	public String getCurriculum() {
		return curriculum;
	}



	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}



	public int getCodiceVolontario() {
		return codiceVolontario;
	}
	public void setCodiceVolontario(int codiceV) {
		this.codiceVolontario = codiceV;
	}
	public int getCodiceTurno() {
		return codiceTurno;
	}
	public void setCodiceTurno(int codiceTurn) {
		this.codiceTurno = codiceTurn;
	}
	public int getCodiceCaritas() {
		return this.codiceCaritas;
	}
	public void setCodiceCaritas(int codiceCaritas) {
		this.codiceCaritas = codiceCaritas;
	}
	
	
	
	
}
