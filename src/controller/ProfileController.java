package controller;

import bean.ProfileBoundary;
import dao.VolunteerRepository;
import entity.VolunteerUser;

public class ProfileController {
	private VolunteerRepository userD;
	
	public ProfileController() {
		userD = new VolunteerRepository();
	}
	
	public void initData(int userId, ProfileBoundary profileBean) {
		VolunteerUser v = userD.getVolunteerByID(userId);
		profileBean.initData(v.getIndirizzo(), v.getCognome(), v.getNome(), v.getRecapitoTel(), userId);
		
	}

}
