package testsParentPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;

public class ParentLoginLogout extends BaseTest {
 
	  private String parentLogin = "user@user.lt";
	  
	  @Test
	  public void successfulParentLoginAndLogout() {
		  
		  // login
		  LoginPage loginPage = new LoginPage(driver);
	      loginPage.doLogin(parentLogin, parentLogin);
		  
	      // check if parent is logged in and can see his applications
		  WebDriverWait waitToCheckIfLoggedIn = new WebDriverWait(driver, 10);
		  WebElement applicationsNav = waitToCheckIfLoggedIn.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("navUserMyApplications")));
//		  applicationsNav.click();
		  String myApplications = driver.findElement(By.id("navUserMyApplications")).getText();
		  assertEquals(myApplications, "Mano prašymai");
	      
		  // logout
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logoutElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnLogout")));
		  logoutElement.click();  
	  }
	  
}
