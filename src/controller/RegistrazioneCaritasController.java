package controller;

import java.sql.SQLException;

import dao.CaritasRepository;
import entity.CaritasUser;

public class RegistrazioneCaritasController  {
	
	int tipo;



	public int completaButtonPressed( String nomeCaritas, String passwordCaritas, String via, String tipo,
		
		String telefono, String email, String cittadiResidenza) throws SQLException {
	
		CaritasUser newUser = new CaritasUser(nomeCaritas, passwordCaritas, via, tipo, telefono, email, cittadiResidenza);
	
			CaritasRepository crep = new CaritasRepository();
			int id = crep.insertCaritas(newUser);
			newUser.setId(id);
            
			return id;
			// Manda alla home Caritas
		

	}



}
