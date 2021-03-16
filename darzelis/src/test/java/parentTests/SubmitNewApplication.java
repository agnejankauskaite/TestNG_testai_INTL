package parentTests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import adminPages.CreateAndDeleteNewUserPage;
import generalMethods.GeneralMethods;
import specialistPages.CreateAndDeleteNewKindergartenPage;

public class SubmitNewApplication extends GeneralMethods {
	
	/**
	 * Test scenario:
	 * Fill in and submit application to a kindergarten. Delete the submitted application afterwards.
	 * 
	 * Test steps:
	 * 1. Login as kindergarten specialist, create a new kindergarten for this test.
	 * 2. Kindergarten specialist checks if registration is open. If it's closed, user opens it for the test. Logout.
	 * 3. Login as admin. New user (parent) is created for the test. Logout.
	 * 4. Login as the newly created user. 
	 * 5. User fills in application. User information is stored in parentAndChildDetails.txt file
	 * 6. After submitting application, user deletes it
	 * 7. The kindergarten and user that were used for this test are deleted.
	 * @throws IOException
	 */
	
	@Test (groups = "regression", priority = 1) 
	  public void successfullySubmitNewApplication() throws IOException{
		  
		successfullyCreateNewKindergarten();

//		// check if registration is open (as kindergarten specialist)
		openRegistrationIfNeeded();
		doLogout();
		
//		CreateAndDeleteNewUserPage newUser = new CreateAndDeleteNewUserPage(driver);
//		newUser.clickOkUserNotLoggedInButton();
		
		waitForLoginToLoad();
		
		// create a new user (parent) for this test
		createNewParent(2);
		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);
	
		// fill in the application and submit it
		fillInTheApplication();
		waitToAgreePopUp();
		
		// go to parent's applications and delete it
//		deleteApplication();
		
		// delete the kindergarten that was created for the test
//		doLogin(createNewUserSpecialistEmail, createNewUserSpecialistEmail);
//		CreateAndDeleteNewKindergartenPage createNewKindergarten = new CreateAndDeleteNewKindergartenPage(driver);
//		createNewKindergarten.searchForTheNewlyCreatedKindergarten("Žvirbliukas");
//		deleteNewKindergarten();
//		doLogout();
//		
//		// delete test user
//		doLoginAsAdmin();
//		deleteNewUser();
//		doLogout();
	}
	
//	@Test (groups = "regression", priority = 2) 
//	public void deleteApplication () {
////		clickNavButtonParentApplications();
//		clickDeleteApplication();
//		waitToAgreePopUp();
//		waitToPressOKPopUp();
//		doLogout();
//	}
  
}
