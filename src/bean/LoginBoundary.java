package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.CaritasHomeController;
import controller.LoginController;
import controller.ShopHomeController;
import controller.UserHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginBoundary {

	private static Logger logger = LoggerFactory.getLogger(LoginBoundary.class.getName());
	//può essere tolta la stringa
	private String s = "errore IoException";

	private LoginController loginC = new LoginController();


	private ShopHomeBoundary shopHomeBoundary;
	private CaritasHomeBoundary caritasHomeBoundary;



	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@FXML
	private Button loginButton;

	@FXML
	private Button registerButton;

	@FXML
	void loginPressed(ActionEvent event) {

		int idUser = loginC.trovaID(usernameField.getText());
		String loggedUser = loginC.loginAccess(usernameField.getText(), passwordField.getText());
		if (loggedUser.equalsIgnoreCase("Volontario")) {

			try {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
				Parent root = loader.load();
				UserHomeBoundary userHomeBoundary = null;
				userHomeBoundary = userHomeBoundary.getInstance();
				userHomeBoundary = loader.getController();
				UserHomeController userHomeController = new UserHomeController();
				userHomeController.initDataCont(idUser, userHomeBoundary);
				
				
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);
			}

		} else if (loggedUser.equalsIgnoreCase("Caritas")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
				Parent root = loader.load();
				caritasHomeBoundary = loader.getController();
				CaritasHomeController caritasHomeController = new CaritasHomeController();
				caritasHomeController.initDataCaritas(idUser, caritasHomeBoundary);
				
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);

			}
		} else if (loggedUser.equalsIgnoreCase("Negozio")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
				Parent root = loader.load();
				shopHomeBoundary = shopHomeBoundary.getInstance();
				shopHomeBoundary = loader.getController();
				ShopHomeController shopHomeC = new ShopHomeController();
				shopHomeC.initDataShop(idUser, shopHomeBoundary);
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);
			}

		}

	}

	@FXML
	void registrazionePressed(ActionEvent event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) registerButton.getScene().getWindow();
			Scene scene = new Scene(root, 600, 400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			logger.error(s);
		}

	}

}
