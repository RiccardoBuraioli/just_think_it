package entity;


import com.sothawo.mapjfx.Marker;


public class MarkerID {
	private Marker marker;
	private int id;
	
	public MarkerID(Marker marker, int id) {
		
		this.setMarker(marker);
		this.setId(id);
	}

	public Marker getMarker() {
		return this.marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}


