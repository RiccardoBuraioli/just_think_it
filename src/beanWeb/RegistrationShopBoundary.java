package beanWeb;


import java.sql.SQLException;


import controller.RegistrationShopManagerController;


public class RegistrationShopBoundary{
	private RegistrationShopManagerController regNeg;

	
	private String NomeNegozio; 
    private String IndirizzoNeg;  
    private String RecapitoTel;  
    private String Email;
    private String Città;
    private String Password; 
    private String confermaPassword;   
    private String Tipologia;
    
    
    public RegistrationShopManagerController getRegNeg() {
		return regNeg;
	}


	public void setRegNeg(RegistrationShopManagerController regNeg) {
		this.regNeg = regNeg;
	}


	public String getNomeNegozio() {
		return NomeNegozio;
	}


	public void setNomeNegozio(String nomeNegozio) {
		NomeNegozio = nomeNegozio;
	}


	public String getIndirizzoNeg() {
		return IndirizzoNeg;
	}


	public void setIndirizzoNeg(String indirizzoNeg) {
		IndirizzoNeg = indirizzoNeg;
	}


	public String getRecapitoTel() {
		return RecapitoTel;
	}


	public void setRecapitoTel(String recapitoTel) {
		RecapitoTel = recapitoTel;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getCittà() {
		return Città;
	}


	public void setCittà(String città) {
		Città = città;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getConfermaPassword() {
		return confermaPassword;
	}


	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}


	public String getTipologia() {
		return Tipologia;
	}


	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}


	public RegistrationShopBoundary() {
    	this.regNeg = new RegistrationShopManagerController();
    }
    



	public boolean registraNegozioPressed(String Tipologia, String NomeNegozio,String Password, String IndirizzoNeg, String RecapitoTel, String Email, String Città) throws SQLException {
    	if (NomeNegozio == null || NomeNegozio.equals("") || Password == null || Password.equals("") ||IndirizzoNeg == null || IndirizzoNeg.equals("") || RecapitoTel == null || RecapitoTel.equals("")|| Email.equals("") || Email == null  || Città == null || Città.equals("")) {
    		return false;    		
    	}
    	else {
    		regNeg.registraNegozioPressed(Tipologia ,NomeNegozio,Password, IndirizzoNeg, RecapitoTel, Email, Città);
    		return true;
    	}
    	
    }
    
    
 
   
    
}
