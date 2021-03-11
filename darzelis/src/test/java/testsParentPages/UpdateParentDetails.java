package testsParentPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import generalTests.GeneralTests;
import pages.LoginPage;
import parentPages.UpdateParentDetailsPage;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;

public class UpdateParentDetails extends GeneralTests {
	
  private String userLogin = "user2@user.lt";
	
  @Test (groups = "regression", priority = 1) 
  public void successfullyChangeAdminDetails() {
	  
	  //login as parent/ guardian
	  doLogin(userLogin, userLogin);
      
      // go to "Mano paskyra" page
      clickNavButtonMyAccountParent();

      // change parent details
      inputUserDetails();
      inputDetails.inputPersonalCode("37505073214");
      inputDetails.inputTelephoneNumber("+37060809123");
      inputDetails.inputUserAddress("Adreso g. 99");
      clickChangeUserDetails();
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
	  
	  public void clickNavButtonMyAccountParent () {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement navMyAccountParent = wait.until(
			ExpectedConditions.presenceOfElementLocated(By.id("navUserMyAccount")));
	  navMyAccountParent.click();
	}
}
