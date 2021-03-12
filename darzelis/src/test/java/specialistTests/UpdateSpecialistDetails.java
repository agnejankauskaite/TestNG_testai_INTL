package specialistTests;

import org.testng.annotations.Test;

import generalMethods.GeneralMethods;

public class UpdateSpecialistDetails extends GeneralMethods {
	
	@Test (groups = "regression", priority = 1) 
	public void successfullyChangeSpecialistDetails() {
		// create a new user (kindergarten specialist) for this test
		createNewKindergartenSpecialist(1);
		doLogout();
		doLogin(createNewUserSpecialistEmail, createNewUserSpecialistEmail);
			  
		// go to "Mano paskyra" page
		clickNavButtonSpecialistMyAccount();
		      
		// change user details
		inputUserDetails();
		clickChangeUserDetails();
	}
	
    @Test (groups = "regression", priority = 2) 
	public void successfullyChangeSpecialistPassword() {
		changeUserPassword(createNewUserSpecialistEmail);
	}
    
    @Test (groups = "regression", priority = 3) 
    public void successfullyResetSpecialistPasswordToOriginal () {	  
	    resetUserPassword(createNewUserSpecialistEmail);	
	    
	   	// delete user after successful user details change
	   	doLoginAsAdmin();
	   	deleteNewUser();
	   	doLogout();
    }
    
}
