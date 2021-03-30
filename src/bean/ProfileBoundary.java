package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.UserHomeController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ProfileBoundary{

	
	private int idUser;
	
	@FXML
    private ImageView profileImageEdit;

    @FXML
    private Button backHomeButton;

    @FXML
    private Button editButton;

    @FXML
    private ImageView donazioniImage;

    @FXML
    private ImageView eventiImage;

    @FXML
    private Text nomeCognomeEdit;

    @FXML
    private Text emailEdit;

    @FXML
    private Text cittaEdit;

    @FXML
    private Text telefonoEdit;
    

@FXML  
 void backHomeButtonPressed(ActionEvent event) {
	Logger logger = LoggerFactory.getLogger(ProfileBoundary.class.getName());

	 try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
			Parent root = loader.load();
			UserHomeBoundary userHomeBoundary;
			UserHomeController userHomeC = new UserHomeController();
			userHomeBoundary = loader.getController();
			userHomeC.initDataCont(idUser, userHomeBoundary);
			Stage home = (Stage) this.backHomeButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			logger.error("errore IoException");
		}


    }

 @FXML
 void editButtonPressed(ActionEvent event) {
	 //perche si
 }


public void initData(String indirizzo, String cognome, String nome, String recapitoTel, int id) {
	this.cittaEdit.setText(indirizzo);
 	this.telefonoEdit.setText(recapitoTel);
 	this.nomeCognomeEdit.setText(nome + " " + cognome);
 	this.idUser = id;
	
}



 
}
