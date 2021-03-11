package loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import generalTests.GeneralTests;
import pages.LoginPage;

public class AdminLoginLogout extends GeneralTests {
	  
	  @Test (groups = {"smoke", "regression"})
	  public void successfulLoginAndLogout() {
		  
		  // login
	      doLoginAsAdmin();
		  
		  // check if admin is logged in and can see the user list 
		  verifyIfAdminIsLoggedIn();
		
		  // logout
		  doLogout();
	  }
	  
	 @Test (groups = "regression")
	 public void unsuccessfulLoginAndLogout() {
		 
		 // wait for the login page to load
		 WebDriverWait waitForLoginPageToLoad = new WebDriverWait(driver, 10);
		 WebElement userListNav = waitForLoginPageToLoad.until(
				  ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]//h3")));
		  
		 //login with incorrect data
		 LoginPage loginPage = new LoginPage(driver);
	     doLogin("adminNeteisingas@admin.lt", "adminNeteisingas@admin.lt");
	     
	     // check if an error message appears 
	     checkErrorMessage();
	 }

}
