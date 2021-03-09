package testsParentPages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;
import parentPages.FillAndSubmitNewApplicationPage;
import specialistPages.CheckIfRegistrationIsOpen;

public class SubmitNewApplication extends BaseTest{
	
  private String userLogin = "user2@user.lt";
	
  @Test (groups = {"smoke, regression"}, priority = 1) 
  public void successfullyFillSubmitDeleteNewApplication() throws IOException{
	  
	// check if registration is open (as kindergarten specialist)
//	CheckIfRegistrationIsOpen openRegistration = new CheckIfRegistrationIsOpen(driver);
//	openRegistration.openRegistrationIfNeeded();

	//login as parent/ guardian
	LoginPage loginPage = new LoginPage(driver);
	loginPage.doLogin(userLogin, userLogin);

	// add second parent/ guardian's information and fill in child details
	FillAndSubmitNewApplicationPage newApplication = new FillAndSubmitNewApplicationPage(driver); 
	newApplication.fillInTheApplication();
  
	// check priorities
	newApplication.clickPriorityOne();
	newApplication.clickPriorityTwo();
	newApplication.clickPriorityThree();
	newApplication.clickPriorityFour();
	newApplication.clickPriorityFive();
      
	// choose a kindergarten from the list
	newApplication.chooseKindergartenFromDropdownList();
	
  	}
  
  
}
