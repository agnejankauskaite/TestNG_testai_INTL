package testsAdminPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;

public class AdminLoginLogout extends BaseTest {
 
	  private String adminLogin = "admin@admin.lt";
	
	  @Test
	  public void successfulAdminLoginAndLogout() {
		  
		  // login
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogin(adminLogin, adminLogin);
		  
		  // check if admin is logged in and can see the user list
		  WebDriverWait waitToCheckIfLoggedIn = new WebDriverWait(driver, 10);
		  WebElement userListNav = waitToCheckIfLoggedIn.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navAdminUserList")));
		  userListNav.click();
		  String userList = driver.findElement(By.id("navAdminUserList")).getText();
		  assertEquals(userList, "Naudotojų sąrašas");
		  
		  // logout
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logoutElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnLogout")));
		  logoutElement.click();  
	  }
	  
	  @Test
	  public void unsuccessfulAdminLoginAndLogout() {
		  
		  // wait for login page to load
		  WebDriverWait waitForLoginPage = new WebDriverWait(driver, 10);
		  WebElement usernameInputField = waitForLoginPage.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("username")));
		  
		  // login
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogin("admin2@admin.lt", "admin2@admin.lt");
		  
		  // check if error message appears
	      String errorMessage = driver.findElement(By.cssSelector("#root > div > div > div > span")).getText(); // PAKEISTI I ID, KAI BUS !!!
	      assertEquals(errorMessage, "Neteisingas prisijungimo vardas ir/arba slaptažodis!");

 
	  }
	  
}
