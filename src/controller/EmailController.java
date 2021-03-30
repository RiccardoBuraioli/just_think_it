package controller;


import dao.EmailDao;
import entity.EmailEntity;

public class EmailController {

	private EmailDao emailDao;
	
	
	
    public int sendMessageController(String mit, String dest, String mess, String ogg) {
    	
    	int i=0;
    	EmailEntity emailEntity = new EmailEntity(mit, dest, mess, ogg);

    	emailDao = new EmailDao();
    	i = emailDao.inviaEmail(emailEntity);
    	return i;
    	
    }
    
    public String[] loadMittenteDestinatario(int idDest, int idMit) {
    	emailDao = new EmailDao();
    	return emailDao.visualizzaMittenteDestinatario(idDest, idMit);
    	
    }
    
    
    
}
	
