package bean;


import controller.DonationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DonationBoundary {

	@FXML
	private RadioButton vestiti;

	@FXML
	private RadioButton cibo;

	@FXML
	private Button donazione;

	@FXML
	private Button indietro;

	@FXML
	private TextField indirizzo;

	@FXML
	private TextArea descrizione;

	private TextField[] textFields;

	private DonationController controller;

	public DonationBoundary() {
		controller = DonationController.getInstance();
	}

	@FXML
	public void creaDonazione(ActionEvent event) {

		checker();
		controller.setIndirizzo(this.indirizzo.getText());
		controller.setDescrizione(this.descrizione.getText());
		controller.creaDonazione();
		Stage st = (Stage) donazione.getScene().getWindow();
		st.close();

	}

	public void initialize() {
		textFields = new TextField[] { indirizzo };

	}

	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {

				return -1;
			} else if (cibo.isSelected()) {
				controller.setTipologia(2);
				// Almeno uno dei tipi deve essere selezionato
			} else if (vestiti.isSelected()) {
				controller.setTipologia(1);
				// Almeno uno dei tipi deve essere selezionato
			}
		}
		return 0;

	}

	public void initBoundary(int idCar, int idUte) {
		controller.initController(idCar, idUte);
	}

}
