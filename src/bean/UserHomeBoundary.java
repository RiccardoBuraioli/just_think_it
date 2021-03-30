package bean;

import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.ProfileController;
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


public class UserHomeBoundary{



private static UserHomeBoundary instance = null;

private int userId;
	
	private UserHomeController userController ;

	
	//Images slideshow
/*	private Image img1 ;
	private Image img2;
	private Image img3;
	private Image[] images = {img1, img2, img3};
	private int currentImage;*/
	
	
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	
	
	public UserHomeBoundary() {
		/*img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
		
		 currentImage = 0;
		 userController = new UserHomeController();
	*/
	}
	
	@FXML
    private Text nomeCognome;
	
	@FXML
    private Button profileButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private ImageView imagePresentation;
    
    @FXML
    private ImageView profileImage;
    
    @FXML
    private Button searchCaritasButton;

    @FXML
    private Button logoutButton;
    

    
    @FXML
    void deleteAccountButtonPressed(ActionEvent event) {
    		//lo faremo presto
    	this.userController.deleteAccount(userId);
    }

    @FXML
    void profileButtonPressed(ActionEvent event) {
    	ProfileBoundary profileBean;
    	ProfileController profileController = new ProfileController();
    	Logger logger = LoggerFactory.getLogger(UserHomeBoundary.class.getName());

    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserProfilePage.fxml"));
			Parent root = loader.load();
			profileBean = loader.getController();
			profileController.initData(userId, profileBean);
			
			Stage home = (Stage) this.profileButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
    	this.userController.helpButtonPressed();
    }

 

    @FXML
    void logoutButtonPressed(ActionEvent event) {
    	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());

	}

  

    @FXML
    void searchCaritasButtonPressed(ActionEvent event) throws NumberFormatException, SQLException {
    	
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.userId, searchCaritasButton.getScene().getWindow());

   
    }
 

	public void initData(String nome, String cognome, int id) {
     	this.nomeCognome.setText(nome + " "+ cognome);
    /*	final Circle clip = new Circle();
    	clip.setCenterX(25);
    	clip.setCenterY(58);
    	clip.setRadius(200);
        this.profileImage.setClip(clip);*/
        this.userId = id;
  
    }
    
    

}


