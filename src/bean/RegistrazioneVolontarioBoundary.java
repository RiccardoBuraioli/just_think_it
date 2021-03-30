package bean;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.RegistrazioneVolontarioController;
import controller.UserHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrazioneVolontarioBoundary implements Initializable {
	private RegistrazioneVolontarioController regC;

	private TextField[] text;
	

	
	    @FXML
	    private TextField cittaRes;

	    @FXML
	    private TextField via;

	    @FXML
	    private TextField civico;

	    @FXML
	    private TextField tel;

	    @FXML
	    private TextField mail;

	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField cognome;

	    @FXML
	    private Button completaReg;

	    @FXML
	    private TextField codiceFisc;

	    @FXML
	    private Button backButton;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private PasswordField confermaPass;

	    @FXML
	    private Text passwordMatch;


	    @FXML
	    private TextField date;
	  




	public RegistrazioneVolontarioBoundary() {
		regC = new RegistrazioneVolontarioController();
	}

	@FXML
	void backButtonPres(ActionEvent event) {
		TransizionePagine pageswitch = new TransizionePagine();
		String pagina= "/boundary/RegistrazioneMenu.fxml";
		Window stage = backButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage);
	  

	}

	@FXML
	void registraVolontarioPressed(ActionEvent event) {

		if (checker() == 0) {
		int idVol =	regC.completaButtonPressed( nome.getText(), cognome.getText(),
					password.getText(), via.getText(), tel.getText(), mail.getText(), date.getText(),
					cittaRes.getText());
		 Logger logger = LoggerFactory.getLogger(RegistrazioneVolontarioBoundary.class.getName());
		
			try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
    			Parent root = loader.load();
    			UserHomeBoundary userHomeBoundary = loader.getController();
    			UserHomeController userHomeC = new UserHomeController();
    			userHomeC.initDataCont(idVol, userHomeBoundary);
    			Stage home = (Stage) completaReg.getScene().getWindow();
    			home.setScene(new Scene(root, 800, 600));
    			
    			home.show();
    		} catch (IOException e) {
    			logger.error(e.getMessage());
    		}
    	

		}

	}

	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
		}

		// Valida che i campi password e conferma password siano uguali

		if (password.getText().equals(confermaPass.getText())) {
			passwordMatch.setVisible(false);
			return 0;
		} else {
			passwordMatch.setText("Le password non corrispondono");
			passwordMatch.setVisible(true);
			return -1;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		passwordMatch.setVisible(false);
		text = new TextField[] { nome, mail, cittaRes, cognome, civico, via, tel };
		// Per rendere opzionale un campo basta rimuoverlo da questa lista
	}

}
