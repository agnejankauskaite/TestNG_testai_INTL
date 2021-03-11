package parentTests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generalTests.GeneralMethods;
import parentPages.FillAndSubmitNewApplicationPage;

public class SubmitNewApplication extends GeneralMethods {
	
	@Test (groups = {"smoke, regression"}, priority = 1) 
	  public void successfullyFillSubmitDeleteNewApplication() throws IOException, InterruptedException{
		  
		// check if registration is open (as kindergarten specialist)
//		CheckIfRegistrationIsOpen openRegistration = new CheckIfRegistrationIsOpen(driver);
//		openRegistration.openRegistrationIfNeeded();

		// create a new user (parent) for this test
//		createNewParent(2);
//		doLogout();
		doLogin(createNewUserParentEmail, createNewUserParentEmail);

		// add second parent/ guardian's information and fill in child details
		FillAndSubmitNewApplicationPage newApplication = new FillAndSubmitNewApplicationPage(driver); 
		fillInTheApplication();

		// choose a kindergarten from the list
		newApplication.openKindergartenListDropdownPriorityOne();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[5]/button")).click();
		Thread.sleep(3000);
		
		
		// check priorities
		newApplication.clickPriorityOne();
		newApplication.clickPriorityTwo();
//		newApplication.clickPriorityThree();
//		newApplication.clickPriorityFour();
//		newApplication.clickPriorityFive();

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement navApplicationQueue = wait.until(
//			ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(5) > button")));
//		navApplicationQueue.click();

	  	}
  
}
