package bean;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sothawo.mapjfx.Projection;

import controller.CaritasHomeController;
import controller.CercaCaritasController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TransizionePagine {


	private static Logger logger = LoggerFactory.getLogger(TransizionePagine.class.getName());
	
	public TransizionePagine() {
		//default
	}
				
	public void visualizzaPagina(String pagina, Window stage){
		

		   try {
				Parent root = FXMLLoader.load(getClass().getResource(pagina));
				Stage signUp = (Stage)  stage;
				Scene scene = new Scene(root,600,425);
				signUp.setScene(scene);
				signUp.show();
				signUp.setResizable(false);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		
		
	}
	
	
	public void apriMappa(int idUser, Window stage){
		try {

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Boundary/CercaCaritas.fxml"));
	        Parent rootNode = loader.load();
	        CercaCaritas cercaCaritasBean = loader.getController();
	        CercaCaritasController controller = new CercaCaritasController(); 
	        controller.initUser(idUser, cercaCaritasBean);
	      
	      
	        final Projection projection = Projection.WEB_MERCATOR;
	      
	        cercaCaritasBean.initMapAndControls(projection);
	       

	        Scene scene = new Scene(rootNode);
	        Stage primaryStage = (Stage) stage;
	        primaryStage.setTitle("sothawo mapjfx demo application");
	        primaryStage.setScene(scene);
	      
	        primaryStage.show();
	        
	
	} catch (IOException e) {
		logger.error(e.getMessage());
	}
	
	}
	
	
	public void backToMenuCaritas(int idUser,Window stage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			CaritasHomeBoundary caritasHomeBoundary;
			caritasHomeBoundary = loader.getController();
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(idUser, caritasHomeBoundary);
		
			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	
	public void logout(Window stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Logout");

		alert.setHeaderText("Dovrai accedere di nuovo se vuoi tornare alla home");

		alert.setContentText("Sei sicuro di voler eseguire il logout?");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.OK) {

			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));

				Parent root = loader.load();

				Stage home = (Stage) stage;

				home.setScene(new Scene(root, 600, 385));

				home.show();

			} catch (IOException e) {

				logger.error(e.getMessage());

			}

		}


	}
	
	public boolean checkerText(TextField[] text) {
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().isEmpty()) {
				
				return true;
			}
		}
				
		return false;
	}
	
	
	
	
}
