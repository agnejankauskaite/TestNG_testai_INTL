package testsAdminPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;

public class UpdateAdminDetails extends BaseTest{
	
  private String userLogin = "admin2@admin.lt";
	
  @Test (groups = "regression", priority = 1) 
  public void successfullyChangeAdminDetails() {
	  
	  //login as admin
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(userLogin, userLogin);
      
      // go to "Mano paskyra" page
      clickNavButtonAdminMyAccount();

      // change kindergarten specialist details
      ChangeAndResetUserAccountFieldsAndPasswordPage changeDetails = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
      changeDetails.inputUserDetails();
      changeDetails.clickChangeUserDetails();
  	  }
  
	  @Test (groups = "regression", priority = 2) 
	  public void successfullyChangeAdminPassword() {	  
		  ChangeAndResetUserAccountFieldsAndPasswordPage changePassword = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
		  changePassword.changeUserPassword(userLogin);
	  }
	  
	  @Test (groups = "regression", priority = 3) 
	  public void successfullyResetAdminPasswordToOriginal() {	  
		  ChangeAndResetUserAccountFieldsAndPasswordPage reset = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
		  reset.resetUserPassword(userLogin);
	  }
	  
	public void clickNavButtonAdminMyAccount () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement navMyAccountAdmin = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id("navAdminMyAccount")));
		navMyAccountAdmin.click();
	}
}
