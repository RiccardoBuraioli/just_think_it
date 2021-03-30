package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BachecaPersonaleController;
import controller.CaritasHomeController;
import entity.Necessita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BachecaPersonaleBoundary {
	
	private BachecaPersonaleController bachecaController;
	private static Logger logger = LoggerFactory.getLogger(BachecaPersonaleBoundary.class.getName());
	private String s = "errore IoException";
	private int caritas;

	@FXML
	private TableView<Necessita> bacheca;

	@FXML
	private TableColumn<Necessita, String> tipologia;

	@FXML
	private TableColumn<Necessita, String> descrizione;

	@FXML
	private TableColumn<Necessita, String> urgenza;

	@FXML
	private Button necessita;

	@FXML
	private Button elimina;

	@FXML
	private Button back;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			CaritasHomeBoundary homeC = loader.getController();
		
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(caritas, homeC);

			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML
	void creaNecessita(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Crea_Necessità.fxml"));
			Parent root = loader.load();
			CreaNecessitaBoundary creaNec = loader.getController();
			creaNec.setCaritas2(caritas);
			Stage home = (Stage) necessita.getScene().getWindow();
			home.setScene(new Scene(root, 600, 500));

			home.show();
		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML
	void eliminaNecessita(ActionEvent event) {
		Necessita nec = bacheca.getSelectionModel().getSelectedItem();
		bachecaController.eliminaAnnuncio(nec.getIdNece());
	}

	public void loadFormBoundary(int idCar) {
		this.caritas = idCar;

		bachecaController = new BachecaPersonaleController();
		List<Necessita> necessitaList = bachecaController.loadForm(idCar);
		ObservableList<Necessita> data = FXCollections.observableArrayList(necessitaList);

		descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));

		tipologia.setCellValueFactory(new PropertyValueFactory<>("Tipologia"));

		urgenza.setCellValueFactory(new PropertyValueFactory<>("Urgenza"));

		bacheca.setItems(data);

	}



}
