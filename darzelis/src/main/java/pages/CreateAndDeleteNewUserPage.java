package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAndDeleteNewUserPage extends AbstractObjectPage {

	//input fields	
	@FindBy (id= "txtEmail")
	public WebElement inputEmail;
	
	@FindBy (id = "txtName")
	public WebElement inputName;
	
	@FindBy (id="txtSurname")
	public WebElement inputSurname;
	
	@FindBy (id = "txtPersonalCode")
	public WebElement inputPersonalCode;
	
	@FindBy (id = "txtTelNo")
	public WebElement inputPhoneNumber;
	
	@FindBy (id = "txtAddress")
	public WebElement inputAddress;
	
	//buttons
	@FindBy (id = "btnCreate")
	public WebElement createButton;
	
	@FindBy (xpath = "//div[4]//button")
	public WebElement okButtonUserIsCreated;
	
	@FindBy (xpath = "//*/div[2]/div/button")
	public WebElement okButtonUserIsDeleted;
	
	public void enterEmail (String value) {
		inputEmail.sendKeys(value);
	}
	
	public void enterName (String value) {
		inputName.sendKeys(value);
	}
	
	public void enterSurname (String value) {
		inputSurname.sendKeys(value);
	}
	
	public void enterPersonalCode (String value) {
		inputPersonalCode.sendKeys(value);
	}
	
	public void enterPhoneNumber (String value) {
		inputPhoneNumber.sendKeys(value);
	}
	
	public void enterAddress (String value) {
		inputAddress.sendKeys(value);
	}
	
	public void clickCreateButton () {
		createButton.click();
	}
	
	public void clickOKButtonUserIsCreated () {
		okButtonUserIsCreated.click();
	}
	
	public void clickDeleteUserButton () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement deleteUserButton = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnDeleteUser")));
		deleteUserButton.click();
	}
	
	public void clickOKButtonUserIsDeleted () {
		okButtonUserIsDeleted.click();
	}
	
	public Boolean userIsCreatedMessage() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//div[2]/div/div[3]"), "Naujas naudotojas buvo sėkmingai sukurtas."));
		}
	
	public Boolean userWasDeletedMessage() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Naudotojas panaikintas sėkmingai"));
		}
		
	// constructor
	public CreateAndDeleteNewUserPage(WebDriver driver) {
		super(driver);
	}
}
