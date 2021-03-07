package testsSpecialistPages;
import org.testng.annotations.Test;

import adminPages.UpdateAdminDetailsPage;
import basetest.BaseTest;
import pages.LoginPage;
import pages.ChangeAndResetUserAccountFieldsAndPasswordPage;
import specialistPages.UpdateSpacialistDetailsPage;

public class UpdateSpecialistDetails extends BaseTest{
	
  private String userLogin = "manager2@manager.lt";
	
  @Test  (groups = "regression", priority = 1) 
  public void successfullyChangeKindergartenSpecialistDetails() {
	  
	  //login as švietimo specialistas
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(userLogin, userLogin);
      
      // go to "Mano paskyra" page
      UpdateSpacialistDetailsPage updateDetails = new UpdateSpacialistDetailsPage(driver);
      updateDetails.clickNavButtonSpecialistMyAccount();
      
      // change kindergarten specialist details
      ChangeAndResetUserAccountFieldsAndPasswordPage changeDetails = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
      changeDetails.inputUserDetails();
      changeDetails.clickChangeUserDetails();
  }
  
  @Test (groups = "regression", priority = 2) 
  public void successfullyChangeSpecialistPassword() {	  
	  ChangeAndResetUserAccountFieldsAndPasswordPage changePassword = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
	  changePassword.changeUserPassword(userLogin);
  }
  
  @Test (groups = "regression", priority = 3) 
  public void successfullyResetSpecialistPasswordToOriginal () {	  
	  ChangeAndResetUserAccountFieldsAndPasswordPage resetPassword = new ChangeAndResetUserAccountFieldsAndPasswordPage(driver);
	  resetPassword.resetUserPassword(userLogin); 
  }
}
