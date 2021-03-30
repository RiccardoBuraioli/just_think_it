package beanWeb;

import controller.EmailController;


public class EmailBoundary {
	
	private EmailController emailC;

    private String messaggio;
    private String oggetto;
    private String destinatario;
    private String mittente;
    private static EmailBoundary instance = null;
    
    public static EmailBoundary getInstance() {
		if(instance == null) {
			instance = new EmailBoundary();
		}
		return instance;
		}
	
    
    public String getMessaggio() {
		return messaggio;
	}



	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}



	public String getOggetto() {
		return oggetto;
	}



	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}



	public String getDestinatario() {
		return destinatario;
	}



	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}



	public String getMittente() {
		return mittente;
	}



	public void setMittente(String mittente) {
		this.mittente = mittente;
	}



	public int sendMessage(String mittente, String destinatario, String messaggio, String oggetto) {
    	int i = 0;	
    	i =emailC.sendMessageController(mittente, destinatario, messaggio, oggetto);
    	return i;
    }
    
    

	public EmailBoundary() {
		emailC = new EmailController();
	}
	
	
	public void loadEmail(int idDestinatario, int idMittente) {
		String[] mitDest = emailC.loadMittenteDestinatario(idDestinatario, idMittente);
		this.setMittente(mitDest[0]);
		this.setDestinatario(mitDest[1]);
		
	}
	
}
