package entity;

import java.util.List;

public class BachecaEntity {
	private int idCaritas;
	private List<Necessita> necessita;
	
	
	public int getIdCaritas() {
		return idCaritas;
	}
	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}
	public List<Necessita> getNecessita() {
		return necessita;
	}
	public void setNecessita(List<Necessita> necessita) {
		this.necessita = necessita;
	}
}
