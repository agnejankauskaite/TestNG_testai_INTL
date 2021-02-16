package testsSpecialistPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;

public class SpecialistLoginLogout extends BaseTest {
 
	  private String specialistLogin = "manager@manager.lt";
	  
	  @Test
	  public void successfulSpecialistLoginAndLogout() {
		  
		  // login
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogin(specialistLogin, specialistLogin);
		  
	      // check if kindergarten specialist is logged in and can see the kindergarten list
		  WebDriverWait waitToCheckIfLoggedIn = new WebDriverWait(driver, 10);
		  WebElement kindergartenListNav = waitToCheckIfLoggedIn.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navManagerKindergartenList")));
		  kindergartenListNav.click();
		  String userList = driver.findElement(By.id("navManagerKindergartenList")).getText();
		  assertEquals(userList, "Darželių sąrašas");
	      
		  // logout
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logoutElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnLogout")));
		  logoutElement.click();  
	  }
	  
}
