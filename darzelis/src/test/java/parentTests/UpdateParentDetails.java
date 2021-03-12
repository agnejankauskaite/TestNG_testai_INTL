package parentTests;

import org.testng.annotations.Test;

import generalMethods.GeneralMethods;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;
import parentPages.UpdateParentDetailsPage;

public class UpdateParentDetails extends GeneralMethods {
	
	@Test (groups = "regression", priority = 1) 
	public void successfullyChangeParentDetails() {
		// create a new user (parent) for this test
		createNewParent(2);
		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);
			  
		// go to "Mano paskyra" page
		clickNavButtonMyAccountParent();
		      
		// change user details
		inputUserDetails();
		UpdateParentDetailsPage updateParentDetails = new UpdateParentDetailsPage(driver);
		updateParentDetails.inputPersonalCode("37505073214");
		updateParentDetails.inputTelephoneNumber("+37060809123");
		updateParentDetails.inputUserAddress("Adreso g. 99");
		clickChangeUserDetails();
	}
	
    @Test (groups = "regression", priority = 2) 
	public void successfullyChangeParentPassword() {
		changeUserPassword(createNewUserParentEmail);
	}
    
    @Test (groups = "regression", priority = 3) 
    public void successfullyResetParentPasswordToOriginal () {	  
    resetUserPassword(createNewUserParentEmail);
   	  
   	// delete user after successful user details change
   	doLoginAsAdmin();
   	deleteNewUser();
   	doLogout();
    }
    
}
