package specialistPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;

public class UpdateSpacialistDetailsPage extends AbstractObjectPage{

	
	// navigation buttons
	public void clickNavButtonSpecialistMyAccount () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement navMyAccountSpecialist = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navManagerMyAccount")));
		navMyAccountSpecialist.click();
	}

	// constructor
	public UpdateSpacialistDetailsPage(WebDriver driver) {
		super(driver);
	}

}
