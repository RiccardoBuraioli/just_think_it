package beanWeb;

public class ShopHomeBoundary {
	

	private int idShop;
	private GestisciEventiBoundary gestisciBoundary;
	private static ShopHomeBoundary instance = null;
	

		public static ShopHomeBoundary getInstance() {
			if (instance == null) {
				instance = new ShopHomeBoundary();
				}
			return instance;
		}

		public ShopHomeBoundary() {
			 gestisciBoundary = new GestisciEventiBoundary();
		}
		
    public void cercaCaritas(){
    	TransizionePagine switchPage = new TransizionePagine();
    	try {
			switchPage.apriMappa(this.idShop);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    
   /* void deleteAccountButtonPressed(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		logger.trace("sei morto");
    	}
    }*/

   
    public void gestisciEventi() {
    	gestisciBoundary.getInstance().loadShopBean(idShop);
    }

  



	public void initData(int id, String nome) {
		this.idShop = id;
    	//nomeCognome.setText(nome);	
	}





}

