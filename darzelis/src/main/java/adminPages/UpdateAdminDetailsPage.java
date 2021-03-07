package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;

public class UpdateAdminDetailsPage extends AbstractObjectPage {	
	
	// navigation button
	public void clickNavButtonAdminMyAccount () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement navMyAccountAdmin = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navAdminMyAccount")));
		navMyAccountAdmin.click();
	}	
	
	// constructor
	public UpdateAdminDetailsPage(WebDriver driver) {
		super(driver);
	}

}
