package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiCaritasController;
import entity.EventTab;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciEventiCaritasBoundary {

	

	private GestisciEventiCaritasController gestEventC;
	private int idCar;
	
	private EventTab event;
	

	@FXML
	private TableView<EventTab> tab;

	@FXML
	private TableColumn<EventTab, String> nomeEvento;

	@FXML
	private TableColumn<EventTab, String> nomeNegozio;

	@FXML
	private TableColumn<EventTab, String> noteEvento;

	@FXML
	private TableColumn<EventTab, Float> importo;

	@FXML
	private TableColumn<EventTab, Integer> numPartecipanti;

	@FXML
	private TableColumn<EventTab, String> stato;

	@FXML
	private Button cancellaEvento;

	@FXML
	private Button modificaEvento;

	@FXML
	private Button contattaNegozio;

	@FXML
	private Button back;

	@FXML
	boolean cancellaEvent(ActionEvent event) {
		return gestEventC.eliminaEvento(this.event.getNomeEvento());

	}

	@FXML
	void modificaEvent(ActionEvent event) {
		gestEventC.modificaEvento(this.event.getId());
	}

	@FXML
	void backtomenu(ActionEvent event) {
		TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(idCar, back.getScene().getWindow());
	

	}

	@FXML
	void contattaShop(ActionEvent event) {
		Logger logger = LoggerFactory.getLogger(GestisciEventiCaritasBoundary.class.getName());
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));

			EmailBoundary email;
			email = fxmlLoader.getController();
			email.loadEmail(this.event.getCodiceNegozio(), idCar);
			Stage stage = new Stage();
			stage.setTitle("Email");

			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}

	@FXML
	void eventClicked(MouseEvent event) {
		this.event = tab.getSelectionModel().getSelectedItem();

	}

	
	public void loadShop(int idCar) {
		this.idCar = idCar;
		List<EventTab> listEv = gestEventC.caricaEventi(this.idCar);

		ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
		nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
		nomeNegozio.setCellValueFactory(new PropertyValueFactory<>("NomeNegozio"));
		noteEvento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));
		numPartecipanti.setCellValueFactory(new PropertyValueFactory<>("NumPartecipanti"));
		stato.setCellValueFactory(new PropertyValueFactory<>("StatoEvento"));

		tab.setItems(data);

	}

	public GestisciEventiCaritasBoundary() {
		gestEventC = new GestisciEventiCaritasController();
	}

}
