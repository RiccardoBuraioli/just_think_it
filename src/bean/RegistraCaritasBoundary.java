package bean;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CaritasHomeController;
import controller.RegistrazioneCaritasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistraCaritasBoundary implements Initializable {


	private RegistrazioneCaritasController regController;

	private TextField[] textFields;
	TransizionePagine pageSwitch;
	private String tipo;

	@FXML
	private TextField cittadiResidenza;

	@FXML
	private TextField via;

	@FXML
	private TextField civico;

	@FXML
	private TextField telefono;

	@FXML
	private Button backButton;

	@FXML
	private TextField nomeCaritas;

	@FXML
	private TextField email;

	@FXML
	private CheckBox type;

	@FXML
	private CheckBox type2;

	@FXML
	private TextField nomeResp;

	@FXML
	private TextField cognomeResp;

	@FXML
	private Button completaButton;

	@FXML
	private TextField codiceFiscaleResp;

	@FXML
	private PasswordField passwordCaritas;

	@FXML
	private Text passwordMatch;

	@FXML
	private PasswordField confermaPassCaritas;

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
	}

	@FXML
	void backButtonPressed(ActionEvent event) {
		
		pageSwitch = new TransizionePagine();
    	pageSwitch.visualizzaPagina("/boundary/RegistrazioneMenu.fxml", backButton.getScene().getWindow());
    	

	}

	@FXML
	public void completaButtonPressed(ActionEvent event) throws SQLException {
		int resCheck = checker();
		if (resCheck == 0) {
			int caritas = regController.completaButtonPressed( nomeCaritas.getText(),
					passwordCaritas.getText(), via.getText(), tipo, telefono.getText(), email.getText(),
					cittadiResidenza.getText());
			
		
			
			Logger logger = LoggerFactory.getLogger(RegistraCaritasBoundary.class.getName());
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			Stage home = (Stage) completaButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			CaritasHomeBoundary caritasHome = loader.getController();
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(caritas, caritasHome);
		
			home.show();
		} catch (IOException e) {
			logger.error(e.getMessage());
			}
		}
	}

	public int checker() {
		pageSwitch = new TransizionePagine();
		// Controlla che non ci siano campi lasciati vuoti
		if(!pageSwitch.checkerText(textFields)) {
			passwordMatch.setText("Alcuni campi sono vuoti");
			passwordMatch.setVisible(true);
		}
			if (type.isSelected()) {
				tipo = "Vestiti";
				return 0; // Almeno uno dei tipi deve essere selezionato

			} else if (type2.isSelected()) {
				tipo = "Cibo";
				passwordMatch.setText("Alcuni campi sono vuoti 2");
				passwordMatch.setVisible(true);
				return 0; // Almeno uno dei tipi deve essere selezionato
			}
		

		// Valida che i campi password e conferma password siano uguali

		if (passwordCaritas.getText().equals(confermaPassCaritas.getText())) {
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
		textFields = new TextField[] { cittadiResidenza, via, civico, telefono, nomeCaritas, email, nomeResp,
				cognomeResp, codiceFiscaleResp };

	}

}