package application;
	
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Logger logger = LoggerFactory.getLogger(Main.class.getName());

	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../boundary/Login_boundary.fxml"));
			primaryStage.setScene(new Scene(root));
	        primaryStage.setResizable(false);
	        primaryStage.show();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
