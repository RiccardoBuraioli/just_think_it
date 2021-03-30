package bean;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CaritasHomeBoundary {

//	private Image img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
	private int idCar;
	
	private static CaritasHomeBoundary instance = null;
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());
	private String s = "errore IoException";

	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;

	private BachecaPersonaleBoundary bacheca;


	@FXML
	private Button helpButton;

	@FXML
	private Button deleteAccountButton;

	@FXML
	private ImageView imagePresentation;

	@FXML
	private Button vBacheca;

	@FXML
	private Font x1;

	@FXML
	private Button eventiC;

	@FXML
	private Button turni;

	@FXML
	private Text textOverImages;

	@FXML
	private Button logoutButton;

	@FXML
	private ImageView arrowRight;

	@FXML
	private ImageView arrowLeft;

	@FXML
	private Text nomeCognome;


	@FXML
	private ImageView profileImage;

	@FXML
	private Button gestisciDona;

	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
		}
		return instance;
	}

	public CaritasHomeBoundary() {
		bacheca = new BachecaPersonaleBoundary();
		gestTurn = new GestisciTurniBoundary();
		gestDon = new GestisciDonazioniBoundary();
	}

	@FXML
	void gestisciDonazioni(ActionEvent event) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("../boundary/Gestisci_Donazioni.fxml"));
			gestDon = fxmlLoader.getController();
			Stage stage = (Stage) eventiC.getScene().getWindow();
			stage.setTitle("Gestisci Eventi");
		
			gestDon.loadFormBoundary(idCar);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}
	}

	@FXML
	void gestisciEventi(ActionEvent event) {
		// handle the event here

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader
					.load(getClass().getResourceAsStream("../boundary/Gestisci_eventi_caritas.fxml"));
			GestisciEventiCaritasBoundary gestisciB = fxmlLoader.getController();
			Stage stage = (Stage) eventiC.getScene().getWindow();
			stage.setTitle("Gestisci Eventi");
			
			gestisciB.loadShop(idCar);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}
	}

	@FXML
	void gestisciTurni(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) turni.getScene().getWindow();

			gestTurn = loader.getController();

			gestTurn.loadFormBoundary(idCar);

			home.setScene(new Scene(root, 883, 550));
			home.show();

		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML // dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di
			// chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	void visualizzaBacheca(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) vBacheca.getScene().getWindow();
			home.setScene(new Scene(root, 775, 500));
			home.show();

			bacheca = loader.getController();
		
			bacheca.loadFormBoundary(idCar);

		} catch (IOException e) {
			logger.error(s);
		}
	}

	@FXML
	void deleteAccountButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void helpButtonPressed(ActionEvent event) {
		// handle the event here
	}


	@FXML
	void logoutButtonPressedCaritas(ActionEvent event) {
	 	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	

	}

	public void initDataC(int id, String nome) {
		this.idCar = id;
		nomeCognome.setText(nome);
		final Circle clip = new Circle();
		clip.setCenterX(25);
		clip.setCenterY(58);
		clip.setRadius(200);
		profileImage.setClip(clip);
		

	}

}
