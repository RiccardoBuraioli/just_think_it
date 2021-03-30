package bean;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.EmailDao;
import entity.EmailEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class VisualizzaEmailBoundary {

		private String emailUtente;
		private EmailDao emailDao;
		private List<EmailEntity> emailList;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextArea mess;

	    @FXML
	    private Button indietro;

	    @FXML
	    private ChoiceBox<Integer> emailch;

	    @FXML
	    private Button rispondi;

	    @FXML
	    void creaEmail(ActionEvent event) {
	    	//to do
	    }

	    @FXML
	    void indietro(ActionEvent event) {
	    	//to do
	    }
	    
	    public VisualizzaEmailBoundary() {
	    	//to do
	    }

	    @FXML
	    void dragDetected(MouseEvent event) {
	    	
	    	int i =emailch.getValue();
	    	mess.setText(emailList.get(i).getMessaggio());
	    	

	    }
	    
	    

	    @FXML
	    void initialize() {
	    	
	    	int i = 0;
	    	emailList = emailDao.visualizzaEmail(emailUtente);
	    	
	    	while( i < emailList.size()) {
	    	
	    	emailch.getItems().add(emailList.get(i).getIdEmail());
	    	i++;
	    	}
	    	
	    	
	    	
	    	

	    
	}


}