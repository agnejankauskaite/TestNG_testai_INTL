package loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;

public class AdminLoginLogout extends BaseTest {
 
	  private static String userLogins = "admin@admin.lt";
	  private static String expectedErrorMessage= "Neteisingas prisijungimo vardas ir/arba slaptažodis!";
	  
	  @Test (groups = {"smoke", "regression"})
	  public void successfulLoginAndLogout() {
		  
		  // login
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogin(userLogins, userLogins);
		  
		  // check if admin is logged in and can see the user list 
		  loginPage.verifyIfAdminIsLoggedIn();
		
		  // logout
		  loginPage.doLogout();
	  }
	  
	 @Test (groups = "regression")
	 public void unsuccessfulLoginAndLogout() {
		 
		 // wait for the login page to load
		 WebDriverWait waitForLoginPageToLoad = new WebDriverWait(driver, 10);
		 WebElement userListNav = waitForLoginPageToLoad.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]//h3")));
		  
		 //login with incorrect data
		 LoginPage loginPage = new LoginPage(driver);
	     loginPage.doLogin("admin2@admin.lt", "admin2@admin.lt");
	     
	     // check if an error message appears 
	     checkErrorMessage();
	 }
	 
	 private Boolean checkErrorMessage() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.id("incorrectLoginData"), expectedErrorMessage));
		}
	  
	 
}
