package parentTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import generalTests.GeneralMethods;
import parentPages.FillAndSubmitNewApplicationPage;

public class SubmitNewApplication extends GeneralMethods {
	
	@Test (groups = "regression", priority = 1) 
	  public void successfullySubmitNewApplication() throws IOException {
		  
		successfullyCreateNewKindergarten();
		
		// check if registration is open (as kindergarten specialist)
		openRegistrationIfNeeded();
		doLogout();

		// create a new user (parent) for this test
		createNewParent(2);
		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);
	
		// fill in the application and submit it
		submitApplication();

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
	
	public void submitApplication () throws IOException {
		// add second parent/ guardian's information and fill in child details
		FillAndSubmitNewApplicationPage newApplication = new FillAndSubmitNewApplicationPage(driver); 
		fillInTheApplication();
		
		// check priorities
		newApplication.clickPriorityOne();
		newApplication.clickPriorityTwo();
		newApplication.clickPriorityThree();
		newApplication.clickPriorityFour();
		newApplication.clickPriorityFive();
		
		// choose a kindergarten from the list
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		newApplication.openKindergartenListDropdownPriorityOne();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		// submit application
		newApplication.clickButtonSubmitApplication();
	}
  
}
