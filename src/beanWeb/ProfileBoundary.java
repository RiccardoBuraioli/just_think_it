package beanWeb;

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
	

    

 
/*void backHomeButtonPressed(ActionEvent event) {
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
*/


/*public void initData(String indirizzo, String cognome, String nome, String recapitoTel, int id) {
	this.cittaEdit.setText(indirizzo);
 	this.telefonoEdit.setText(recapitoTel);
 	this.nomeCognomeEdit.setText(nome + " " + cognome);
 	this.idUser = id;
	
}*/



 
}
