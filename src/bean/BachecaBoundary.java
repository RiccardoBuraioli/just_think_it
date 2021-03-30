package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BachecaController;
import entity.Necessita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BachecaBoundary {
	private static Logger logger = LoggerFactory.getLogger(BachecaBoundary.class.getName());
	private String s = "errore IoException";
	private int idCar;
	private int idUte;

	@FXML
	private Text nomeCaritas;

	@FXML
	private TextArea cibo;

	@FXML
	private TextArea varie;

	@FXML
	private TextArea vestiti;

	@FXML
	void creaDonazione(ActionEvent event) {
		try {

			DonationBoundary donationBoundary;

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Donation.fxml"));

			donationBoundary = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Donazione");
			donationBoundary.initBoundary(idCar, idUte);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML
	void creaEmail(ActionEvent event) {

		EmailBoundary emailBoundary;

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();

			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));

			emailBoundary = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Email");

			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);

			emailBoundary.loadEmail(idCar, idUte);

			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}

	}

	public void loadFormBoundary(int idCar, int idUte) {
		this.idCar = idCar;
		this.idUte = idUte;
		BachecaController bachecaController = new BachecaController();
		List<Necessita> necessita = bachecaController.loadForm(idCar);

		for (int i = 0; i < necessita.size(); i++) {
			Necessita tmp = necessita.get(i);

			switch (tmp.getTipologia()) {
			case "Vestiti":
				vestiti.setText(tmp.getDescrizione());
				break;

			case "Cibo":
				cibo.setText(tmp.getDescrizione());
				break;
			case "Varie":
				varie.setText(tmp.getDescrizione());
				break;

			default:
				break;

			}

		}

	}

}
