package parentTests;
import java.io.IOException;
import org.testng.annotations.Test;
import generalMethods.GeneralMethods;

public class SubmitNewApplication extends GeneralMethods {
	
	@Test (groups = "regression", priority = 1) 
	  public void successfullySubmitNewApplication() throws IOException{
		  
		successfullyCreateNewKindergarten();
		
		// check if registration is open (as kindergarten specialist)
		openRegistrationIfNeeded();
		doLogout();
		
		// create a new user (parent) for this test
		createNewParent(2);
		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);
	
		// fill in the application and submit it
		fillInTheApplication();

		// go to parent's applications and delete it
//		deleteApplication();
		
		// delete the kindergarten that was created for the test
//		deleteNewKindergarten();
	}
	
	public void deleteApplication () {
		clickNavButtonParentApplications();
		clickDeleteApplication();
		waitToAgreePopUp();
		waitToPressOKPopUp();
	}
  
}
