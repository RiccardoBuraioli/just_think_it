package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CreaTurnoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreaTurnoBoundary {

	@FXML
	private Button back;

	@FXML
	private Button creaTurno;

	@FXML
	private TextArea note;

	@FXML
	private TextField orain;

	@FXML
	private TextField oraFin;

	@FXML
	private ChoiceBox<String> giorni;

	@FXML
	private TextField numParte;

	private int caritas;

	@FXML
	void backPressed(ActionEvent event) {
		Logger logger = LoggerFactory.getLogger(CreaTurnoBoundary.class.getName());

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) back.getScene().getWindow();
			GestisciTurniBoundary gestTurn;
			gestTurn = loader.getController();
			
			gestTurn.loadFormBoundary(caritas);
			home.setScene(new Scene(root, 883, 550));
			home.show();

		} catch (IOException e) {
			logger.error("errore IoException");
		}

	}

	@FXML
	void creaTurnoPressed(ActionEvent event) {
		CreaTurnoController creaTurn = new CreaTurnoController();
		creaTurn.creaEvento(caritas, giorni.getValue().toString(), orain.getText(), oraFin.getText(),
				Integer.parseInt(numParte.getText()), note.getText());

	}

	public void setCaritas(int caritas) {
		this.caritas = caritas;
	}

	@FXML
	void initialize() {

		String[] days = { "Lunedi", "Martedì", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };

		for (int i = 0; i < 7; i++) {

			giorni.getItems().add(days[i]);

		}

	}

}
