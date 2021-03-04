package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;

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
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonUserIsCreated;
	
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
	
	public Boolean userIsCreatedMessage() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Naujas naudotojas buvo sėkmingai sukurtas."));
	}
	
	public void clickDeleteUserButton () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement deleteUserButton = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnDeleteUser")));
		deleteUserButton.click();
	}
	
	public void waitToAgreeToDeleteUserPopUp () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement agreeToDeleteUser = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//*/div[2]/button")));
		agreeToDeleteUser.click();
	}
	
	public void waitToPressOKWhenUserIsDeletedPopUp() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement popUpClickOK = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.swal-overlay.swal-overlay--show-modal > div > div.swal-footer > div > button")));
		  popUpClickOK.click();
	}
	
		
	// constructor
	public CreateAndDeleteNewUserPage(WebDriver driver) {
		super(driver);
	}
}
