package testsSpecialistPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;

public class UpdateSpecialistDetails extends BaseTest{
	
  private String specialistLogin = "manager2@manager.lt";
	
  @Test  (groups = "regression", priority = 1) 
  public void successfullyChangeKindergartenSpecialistDetails() {
	  
	  //login as kindergarten specialist
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(specialistLogin, specialistLogin);
      
      // go to "Mano paskyra" page
      clickNavButtonSpecialistMyAccount();
      
      // change kindergarten specialist details
      ChangeAndResetUserAccountFieldsAndPasswordPage changeDetails = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
      changeDetails.inputUserDetails();
      changeDetails.clickChangeUserDetails();
  }
  
  @Test (groups = "regression", priority = 2) 
  public void successfullyChangeSpecialistPassword() {	  
	  ChangeAndResetUserAccountFieldsAndPasswordPage changePassword = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
	  changePassword.changeUserPassword(specialistLogin);
  }
  
  @Test (groups = "regression", priority = 3) 
  public void successfullyResetSpecialistPasswordToOriginal () {	  
	  ChangeAndResetUserAccountFieldsAndPasswordPage resetPassword = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
	  resetPassword.resetUserPassword(specialistLogin); 
  }
  
  public void clickNavButtonSpecialistMyAccount () {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement navMyAccountSpecialist = wait.until(
			ExpectedConditions.presenceOfElementLocated(By.id("navManagerMyAccount")));
	  navMyAccountSpecialist.click();
  }
}
