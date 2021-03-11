package generalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.BaseTest;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;
import pages.LoginPage;
import parentPages.UpdateParentDetailsPage;

public class GeneralTests extends BaseTest {

	private LoginPage loginPage = new LoginPage(driver);
	protected UpdateParentDetailsPage inputDetails = new UpdateParentDetailsPage(driver);
	private ChangeAndResetUserAccountFieldsAndPasswordPage changeAccountDetails = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
	private String expectedErrorMessage= "Neteisingas prisijungimo vardas ir/arba slaptažodis!";
	private String adminLogins = "admin@admin.lt";
	private String newPassword = "Naujas321";
	private String userName = "Pakeistas";
	private String userSurname = "Pakeistas";
	private String userEmail = "pakeistas@email.lt";
	
	public void doLogin(String username, String password) {
		waitForLoginToLoad();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	 }
	
	public void doLoginAsAdmin() {
		waitForLoginToLoad();
		loginPage.enterUsername(adminLogins);
		loginPage.enterPassword(adminLogins);
		loginPage.clickLoginButton();
	 }
	
	public void doLogout() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logoutElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnLogout")));
		  logoutElement.click();  
	 }
	
	public Boolean verifyIfAdminIsLoggedIn() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  return wait.until(ExpectedConditions.textToBe(By.id("navAdminUserList"), "Naudotojų sąrašas"));
		}
	
	public Boolean verifyIfSpecialistIsLoggedIn() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  return wait.until(ExpectedConditions.textToBe(By.id("navManagerKindergartenList"), "Darželių sąrašas"));
		}

	public Boolean waitForLoginToLoad() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//h3"), "Prisijungti"));
	}
	
	public Boolean checkErrorMessage() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.id("incorrectLoginData"), expectedErrorMessage));
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
	
	public Boolean assertThatPasswordWasReset() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//body/div[2]/div/div[1]"), "Slaptažodis atkurtas sėkmingai"));
	}
	
	public Boolean assertThatUserPasswordWasUpdated() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe
		  			(By.xpath("//body/div[2]/div/div[1]"), "Naudotojo slaptažodis atnaujintas sėkmingai"));
	}
	
	public void clickNavButtonSpecialistMyAccount () {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement navMyAccountSpecialist = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id("navManagerMyAccount")));
		  navMyAccountSpecialist.click();
	  }
	
	public void inputUserDetails () {	   
		
	// change kindergarten specialist details
	changeAccountDetails.waitForMyAccountPageToLoad();
	changeAccountDetails.changeUserName(userName);
	changeAccountDetails.changeUserSurname(userSurname);
	changeAccountDetails.changeUserEmail(userEmail);
	}
	
	public void clickChangeUserDetails () {	   
	changeAccountDetails.clickButtonUpdateUserDetails();
	      
	// assert that information was updated 
	changeAccountDetails.assertThatUserInformationWasUpdated();
	changeAccountDetails.clickOkButtonUserDetailsUpdated(); 
	}
	
	public void resetUserPassword (String userLogin) {
		
		 // go to login page and click on "Pamiršau slaptažodį" button
		  clickUserForgotPasswordButton();
		      
		  // enter user email
		  enterUserEmail(userLogin);
		  changeAccountDetails.clickOkResetPasswordButton();
		  clickDoneButtonForgotPassword();
		      
		  // login as admin
		  doLoginAsAdmin();
		      
		  // reset password that needs to be reset (the button "Atkurti" becomes grey when it needs to be reset)
		  clickResetPasswordButton();
		  changeAccountDetails.clickAgreeToResetUserPasswordButton();
		      
		  // assert message that user password was reset
		  assertThatPasswordWasReset();
		  changeAccountDetails.clickOkButtonPasswordIsReset();

		  // logout and check if user can login with original password
		  doLogout();
		  waitForLoginToLoad();
		  doLogin(userLogin, userLogin);
		  doLogout();  
	}
	
	public void changeUserPassword (String userLogin) {  
		
		  // click button "Keisti"
		  changeAccountDetails.clickChangeUserPasswordButton();
		  
		  // enter old and new password
		  changeAccountDetails.enterOldPassword(userLogin);
		  changeAccountDetails.enterNewPassword(newPassword);
		  changeAccountDetails.enterRepeatedNewPassword(newPassword);
		  
		  // save the new password
		  changeAccountDetails.clickButtonSaveChangedPassword();
		  
		  // assert that password was changed
		  assertThatUserPasswordWasUpdated();
		  changeAccountDetails.clickOkButtonPasswordChanged();
		  
	      doLogout();
	      
	      // check if user can login with changed password
	      waitForLoginToLoad();
	      doLogin(userLogin, newPassword);
	      
	      // logout
	      doLogout();
	}
}
