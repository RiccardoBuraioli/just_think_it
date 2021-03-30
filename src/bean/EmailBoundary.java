package bean;

import controller.EmailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmailBoundary {

	private EmailController emailC;

	@FXML
	private Stage stage;

	@FXML
	private TextArea messaggio;

	@FXML
	private TextField oggetto;

	@FXML
	private TextField destinatario;

	@FXML
	private TextField mittente;

	@FXML
	private Button invia;

	@FXML
	public int sendMessage(ActionEvent event) {
		int i = 0;

		i = emailC.sendMessageController(mittente.getText(), destinatario.getText(), messaggio.getText(),
				oggetto.getText());

		Stage st = (Stage) invia.getScene().getWindow();
		st.close();
		return i;

	}

	@FXML
	void initialize() {

		emailC = new EmailController();

	}

	public void loadEmail(int idDestinatario, int idMittente) {
		String[] mitDest = emailC.loadMittenteDestinatario(idDestinatario, idMittente);
		this.mittente.setText(mitDest[0]);
		this.destinatario.setText(mitDest[1]);

	}

}
