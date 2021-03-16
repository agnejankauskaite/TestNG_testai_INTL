package parentTests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import adminPages.CreateAndDeleteNewUserPage;
import generalMethods.GeneralMethods;
import pages.LoginPage;
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
		
		waitForLoginToLoad();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(adminLogins);
		loginPage.enterPassword(adminLogins);
		
		CreateAndDeleteNewUserPage newUser = new CreateAndDeleteNewUserPage(driver);
		newUser.clickOkUserNotLoggedInButton();
		
		loginPage.clickLoginButton();
		
		// create a new user (parent) for this test
		createNewParent(2);
		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);
	
		// fill in the application and submit it
		fillInTheApplication();
//		waitToPressOKPopUp();
		clickOkButton();
		doLogout();
	}
	
	@Test (groups = "regression", priority = 2) 
	public void deleteApplication () {
//		clickNavButtonParentApplications();
		
		waitForLoginToLoad();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(createNewUserParentEmail);
		loginPage.enterPassword(createNewUserParentEmail);
		
		CreateAndDeleteNewUserPage newUser = new CreateAndDeleteNewUserPage(driver);
		newUser.clickOkUserNotLoggedInButton();
		
		loginPage.clickLoginButton();
		
		clickDeleteApplication();
		waitToAgreePopUp();
		clickOkButton();
		doLogout();
		
		// delete the kindergarten that was created for the test
		doLogin(specialistLogins, specialistLogins);
		CreateAndDeleteNewKindergartenPage createNewKindergarten = new CreateAndDeleteNewKindergartenPage(driver);
		createNewKindergarten.searchForTheNewlyCreatedKindergarten("123 Testinis");
		deleteNewKindergarten();
		doLogout();
		
		// delete test user
		doLoginAsAdmin();
		verifyIfAdminIsLoggedIn();
		deleteNewUser();
		doLogout();
	}
}
