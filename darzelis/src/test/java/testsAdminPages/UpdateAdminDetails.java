package testsAdminPages;
import org.testng.annotations.Test;

import adminPages.UpdateAdminDetailsPage;
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
      UpdateAdminDetailsPage updateDetails = new UpdateAdminDetailsPage(driver);
      updateDetails.clickNavButtonAdminMyAccount();

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
}
