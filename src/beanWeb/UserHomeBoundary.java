package beanWeb;



import java.sql.SQLException;

import bean.ProfileBoundary;
import controller.ProfileController;
import controller.UserHomeController;



public class UserHomeBoundary{



/**
	 * 
	 */

private static UserHomeBoundary instance = null;

private int userId;
	
	private UserHomeController userController ;

	
	
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	
	
	public UserHomeBoundary() {
		 userController = new UserHomeController();
	
	}
   


    
 
    public void deleteAccountButtonPressed() {
    		//lo faremo presto
    	this.userController.deleteAccount(userId);
    }

   
   public  void profileButtonPressed() {
    	ProfileBoundary profileBean = null;
    	ProfileController profileController = new ProfileController();
			profileController.initData(userId, profileBean);
		}
   

    
    void helpButtonPressed() {
    	this.userController.helpButtonPressed();
    }

 

   
   /*public void logoutButtonPressed() {    	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());

	}*/

  


    public int  searchCaritasButtonPressed(){
    	TransizionePagine switchPage = new TransizionePagine();
    	try {
			switchPage.apriMappa(this.userId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
 

	public void initData(String nome, String cognome, int id) {
    	//this.nomeCognome.setText(nome + " "+ cognome);
        this.userId = id;
  
    }
}





