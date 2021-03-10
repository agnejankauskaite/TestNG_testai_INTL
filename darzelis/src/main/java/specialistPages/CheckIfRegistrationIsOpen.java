package specialistPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;
import pages.LoginPage;

public class CheckIfRegistrationIsOpen extends AbstractObjectPage{
	
	@FindBy (id= "btnStartRegistration")
	public WebElement startRegistrationButton;
	
	@FindBy (id= "btnStopRegistration")
	public WebElement stopRegistrationButton;
	
	public void clickStartRegistration() {
		startRegistrationButton.click();
	}
	
	public void clickStopRegistration() {
		stopRegistrationButton.click();
	}
	
	public void openRegistrationIfNeeded () {
		// login as kindergarten specialist
		String specialistLogin = "manager@manager.lt";
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.doLogin(specialistLogin, specialistLogin);
	    
	    // go to Prasymu eile page
	    clickNavButtonApplicationQueue();
	    
	    // check if registration is open
	    if (startRegistrationButton.isDisplayed()) {
	    	clickStartRegistration();
	    } else {
	    	driver.findElement(By.id("btnLogout")).click();
	    }  
	}

	public void clickNavButtonApplicationQueue () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement navApplicationQueue = wait.until(
			ExpectedConditions.presenceOfElementLocated(By.id("navManagerApplicationQueue")));
		navApplicationQueue.click();
		}
	
	// constructor
	public CheckIfRegistrationIsOpen(WebDriver driver) {
		super(driver);
	}

	
}
