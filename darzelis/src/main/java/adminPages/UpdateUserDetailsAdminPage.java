package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;

public class UpdateUserDetailsAdminPage extends AbstractObjectPage {
	
	// input fields
	@FindBy (id = "txtName")
	public WebElement adminName;
	
	@FindBy (id = "txtSurname")
	public WebElement adminSurname;
	
	@FindBy (id = "txtEmail")
	public WebElement adminEmail;
	
	@FindBy (id = "txtOldPassword")
	public WebElement oldPassword;
	
	@FindBy (id = "txtNewPassword")
	public WebElement newPassword;
	
	@FindBy (id = "txtNewPasswordRepeat")
	public WebElement repeatNewPassword;
	
	// buttons
	@FindBy (id = "btnSubmit")
	public WebElement buttonUpdateAdminDetails;
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonAdminDetailsUpdated;
	
	@FindBy (xpath = "//*//div[5]/div/button")
	public WebElement changeAdminPasswordButton;
	
	@FindBy (xpath = "//*/div[5]/button")
	public WebElement buttonSaveChangedPassword;
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonAdminPasswordChanged;
	
	@FindBy (xpath = "//div[4]/div/button")
	public WebElement okResetPasswordButton;
	
	@FindBy (xpath = "//div[2]/button")
	public WebElement agreeToResetUserPasswordButton;
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonPasswordIsReset;
	
	// menu button
	public void clickNavButtonAdminMyAccount () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement navMyAccountAdmin = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navAdminMyAccount")));
		navMyAccountAdmin.click();
	}
	
	public Boolean waitForMyAccountPageToLoad() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//div[2]/h6"), "Naudotojo prisijungimai"));
	}
	
	public void changeAdminName (String value) {
		adminName.clear();
		adminName.sendKeys(value);
	}
	
	public void changeAdminSurname (String value) {
		adminSurname.clear();
		adminSurname.sendKeys(value);
	}
	
	public void changeAdminEmail (String value) {
		adminEmail.clear();
		adminEmail.sendKeys(value);
	}
	
	public void clickButtonUpdateAdminDetails () {
		buttonUpdateAdminDetails.click();
	}
	
	public Boolean assertThatAdminInformationWasUpdated() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Naudotojo duomenys buvo sėkmingai atnaujinti"));
	}
	
	public void clickOkButtonAdminDetailsUpdated () {
		okButtonAdminDetailsUpdated.click();
	}
	
	public void clickChangeAdminPasswordButton () {
		changeAdminPasswordButton.click();
	}
	
	public void enterOldPassword (String value) {
		oldPassword.sendKeys(value);
	}
	
	public void enterNewPassword (String value) {
		newPassword.sendKeys(value);
	}
	
	public void enterRepeatedNewPassword (String value) {
		repeatNewPassword.sendKeys(value);
	}
	
	public void clickButtonSaveChangedPassword () {
		buttonSaveChangedPassword.click();
	}
	
	public Boolean assertThatAdminPasswordWasUpdated() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Naudotojo slaptažodis atnaujintas sėkmingai"));
	}
	
	public void clickOkButtonAdminPasswordChanged () {
		okButtonAdminPasswordChanged.click();
	}
	
	public void clickUserForgotPasswordButton () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement forgotPassword = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//*/form/button[1]")));
		  forgotPassword.click();
	}
	
	public void enterUserEmail (String value) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement enterUserEmail = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//div[3]/input")));
		  enterUserEmail.sendKeys(value);
	}
	
	public void clickOkResetPasswordButton () {
		okResetPasswordButton.click();
	}
	
	public void clickDoneButtonForgotPassword () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement clickDone = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button")));
		  clickDone.click();
	}
		
	public void clickResetPasswordButton () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement clickResetPassword = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.className("btn-secondary")));
		  clickResetPassword.click();
	}
	
	public void clickAgreeToResetUserPasswordButton () {
		agreeToResetUserPasswordButton.click();
	}
	
	public Boolean assertThatAdminPasswordWasReset() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Slaptažodis atkurtas sėkmingai"));
	}
	
	public void clickOkButtonPasswordIsReset () {
		okButtonPasswordIsReset.click();
	}
	
	public Boolean waitForLoginToLoad() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//h3"), "Prisijungti"));
	}
	
	// constructor
	public UpdateUserDetailsAdminPage(WebDriver driver) {
		super(driver);
	}

}
