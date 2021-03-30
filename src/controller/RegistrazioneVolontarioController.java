package controller;


import dao.VolunteerRepository;
import entity.VolunteerUser;


public class RegistrazioneVolontarioController {


   public int completaButtonPressed( String nome, String cognome, String passwordVolontario, String via, String telefono, String email, String date2, String cittadiResidenza) {

    		
        	VolunteerUser newUser = new VolunteerUser(nome, cognome, passwordVolontario, via, telefono, email, date2,cittadiResidenza );
        	VolunteerRepository vrep = new VolunteerRepository();
        	int id = vrep.insertVolunteer(newUser);
        	newUser.setId(id);
        	
        	return id;
        	//Manda alla home dopo la registrazione
        	
    	

    }





    
   

}