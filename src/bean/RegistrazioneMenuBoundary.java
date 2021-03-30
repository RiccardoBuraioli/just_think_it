package bean;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.stage.Window;

public class RegistrazioneMenuBoundary {
	
	private String pagina;
	private Window stage;
    @FXML
    private Button caritasButton;

    @FXML
    private Button volontarioButton;

    @FXML
    private Button negozioButton;

    @FXML
    private Button backButton;

    @FXML
    private Button dettagliCaritas;

    @FXML
    private Button dettagliVolontario;

    @FXML
    private Button dettagliNegozio;

    @FXML
    void backButtonPressed(ActionEvent event) {
    	
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina= "../boundary/Login_boundary.fxml";
		this.stage = backButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage);  
    	
    }

    @FXML
    void caritasButtonPressed(ActionEvent event) {
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina= "/boundary/RegistrazioneCaritas.fxml";
		this.stage = caritasButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage);  
  	
	    }

    @FXML
    void dettagliCaritasPressed(ActionEvent event) {
    	   
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina= "/boundary/RegistrazioneCaritas.fxml";
		this.stage = dettagliCaritas.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage);  
    	
    	}

    @FXML
    void dettagliNegozioPressed(ActionEvent event) {
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina="/boundary/Details.fxml";
		this.stage = dettagliNegozio.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage); 
    	
     
    }

    @FXML
    void dettagliVolontarioPressed(ActionEvent event) {
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina="/boundary/Details.fxml";
		this.stage = dettagliVolontario.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage); 
    	
      
    }

    @FXML
    void negozioButtonPressed(ActionEvent event) {
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina="/boundary/RegistrazioneShopManager.fxml";
		this.stage = negozioButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage); 
    	
 
    }

    @FXML
    void volontarioButtonPressed(ActionEvent event) {
    	TransizionePagine pageswitch = new TransizionePagine();
		this.pagina="/boundary/RegistrazioneVolontario.fxml";
		this.stage = volontarioButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage); 
    	
    	
    }


}
