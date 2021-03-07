package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeAndResetUserAccountFieldsAndPasswordPage extends AbstractObjectPage{
	// input fields
	@FindBy (id="txtName")
	public WebElement userName;
	
	@FindBy (id="txtSurname")
	public WebElement userSurname;
	
	@FindBy (id="txtEmail")
	public WebElement userEmail;
	
	@FindBy (xpath = "//div[4]/div/button")
	public WebElement okResetPasswordButton;
	
	@FindBy (xpath = "//div[2]/button")
	public WebElement agreeToResetUserPasswordButton;
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonPasswordIsReset;
	
	@FindBy (id = "txtOldPassword")
	public WebElement oldPassword;
	
	@FindBy (id = "txtNewPassword")
	public WebElement newPassword;
	
	@FindBy (id = "txtNewPasswordRepeat")
	public WebElement repeatNewPassword;
	
	// buttons
	@FindBy (id="btnSubmit")
	public WebElement buttonUpdateUserDetails;
	
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonUserDetailsUpdated;
	
	@FindBy (xpath = "//*//div[5]/div/button")
	public WebElement changeUserPasswordButton;
	
	@FindBy (xpath = "//*/div[5]/button")
	public WebElement buttonSaveChangedPassword;
		
	@FindBy (xpath = "//div[2]/div/button")
	public WebElement okButtonPasswordChanged;
	
	public void changeUserName (String value) {
		userName.clear();
		userName.sendKeys(value);
	}
	
	public void changeUserSurname (String value) {
		userSurname.clear();
		userSurname.sendKeys(value);
	}
	
	public void changeUserEmail (String value) {
		userEmail.clear();
		userEmail.sendKeys(value);
	}
	
	public void clickButtonUpdateUserDetails () {
		buttonUpdateUserDetails.click();
	}
	
	public void clickUserForgotPasswordButton () {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement forgotPassword = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.className("btn-link")));
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
	
	public void clickOkButtonPasswordIsReset () {
		okButtonPasswordIsReset.click();
	}
	
	public Boolean assertThatPasswordWasReset() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Slaptažodis atkurtas sėkmingai"));
	}
	
	public void clickChangeUserPasswordButton () {
		changeUserPasswordButton.click();
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
	
	public Boolean assertThatUserPasswordWasUpdated() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe
		  			(By.xpath("//body/div[2]/div/div[1]"), "Naudotojo slaptažodis atnaujintas sėkmingai"));
	}
	
	public void clickOkButtonPasswordChanged () {
		okButtonPasswordChanged.click();
	}
	
	public Boolean assertThatUserInformationWasUpdated() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe
		  			(By.xpath("//body/div[2]/div/div[1]"), "Naudotojo duomenys buvo sėkmingai atnaujinti"));
	}
	
	public void clickOkButtonUserDetailsUpdated () {
		okButtonUserDetailsUpdated.click();
	}
	
	public void inputUserDetails () {	   
		  String userName = "Pakeistas";
		  String userSurname = "Pakeistas";
		  String userEmail = "pakeistas@email.lt";
		
	      // change kindergarten specialist details
	      waitForMyAccountPageToLoad();
	      changeUserName(userName);
	      changeUserSurname(userSurname);
	      changeUserEmail(userEmail);
	}
	
	public void clickChangeUserDetails () {	   
	      clickButtonUpdateUserDetails();
	      
	      // assert that information was updated 
	      assertThatUserInformationWasUpdated();
	      clickOkButtonUserDetailsUpdated(); 
	}
	
	public void changeUserPassword (String userLogin) {  
		  String newPassword = "Naujas321";
		
		  // click button "Keisti"
		  clickChangeUserPasswordButton();
		  
		  // enter old and new password
		  enterOldPassword(userLogin);
		  enterNewPassword(newPassword);
		  enterRepeatedNewPassword(newPassword);
		  
		  // save the new password
		  clickButtonSaveChangedPassword();
		  
		  // assert that password was changed
		  assertThatUserPasswordWasUpdated();
		  clickOkButtonPasswordChanged();
		  
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogout();
	      
	      // check if user can login with changed password
	      loginPage.waitForLoginToLoad();
	      loginPage.doLogin(userLogin, newPassword);
	      
	      // logout
	      loginPage.doLogout();
	}
	
	public void resetUserPassword (String userLogin) {
		  String adminLogin = "admin@admin.lt";
		
		 // go to login page and click on "Pamiršau slaptažodį" button
		  ChangeAndResetUserAccountFieldsAndPasswordPage reset = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
		  reset.clickUserForgotPasswordButton();
		      
		  // enter user email
		  reset.enterUserEmail(userLogin);
		  reset.clickOkResetPasswordButton();
		  reset.clickDoneButtonForgotPassword();
		      
		  // login as admin
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.doLogin(adminLogin, adminLogin);
		      
		  // reset password that needs to be reset (the button "Atkurti" becomes grey when it needs to be reset)
		  reset.clickResetPasswordButton();
		  reset.clickAgreeToResetUserPasswordButton();
		      
		  // assert message that user password was reset
		  reset.assertThatPasswordWasReset();
		  reset.clickOkButtonPasswordIsReset();

		  // logout and check if user can login with original password
		  loginPage.doLogout();
		  loginPage.waitForLoginToLoad();
		  loginPage.doLogin(userLogin, userLogin);
		  loginPage.doLogout();  
	}
	
	// constructor
	public ChangeAndResetUserAccountFieldsAndPasswordPage(WebDriver driver) {
		super(driver);
	}

}
