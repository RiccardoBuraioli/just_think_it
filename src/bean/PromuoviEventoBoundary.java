package bean;
import controller.PromuoviEventoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PromuoviEventoBoundary {


		private int idCar;
		private int idShop;
		
		
	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField prezzo;

	    @FXML
	    private RadioButton idCibo;

	    @FXML
	    private RadioButton idVestiti;

	    @FXML
	    private TextArea note;

	    @FXML
	    private Button conferma;

	    @FXML
	    void confermaPressed(ActionEvent event) {
	    String tipo = "Vestiti";
	    if(idCibo.isSelected()) {
	    	tipo = "Cibo";
	    }
	    float costoEvento = Float.parseFloat(prezzo.getText());
	    
	    PromuoviEventoController promuoviEvento = new PromuoviEventoController();	    
	    promuoviEvento.creaEventoController(nome.getText(),tipo, note.getText(), costoEvento, idCar, idShop );	
	    }

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

	

}
