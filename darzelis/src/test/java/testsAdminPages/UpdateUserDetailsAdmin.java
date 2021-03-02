package testsAdminPages;
import org.testng.annotations.Test;
import adminPages.UpdateUserDetailsAdminPage;
import basetest.BaseTest;
import pages.LoginPage;

public class UpdateUserDetailsAdmin extends BaseTest{
	
  private String userLogin = "admin2@admin.lt";
  private String newAdminPassword = "Naujas321";
  private String adminLogin = "admin@admin.lt";
	
  @Test (groups = "regression", priority = 1) 
  public void successfullyChangeAdminDetails() {
	  
	  //login as admin
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(userLogin, userLogin);
      
      // go to "Mano paskyra" page
      UpdateUserDetailsAdminPage updateDetails = new UpdateUserDetailsAdminPage(driver);
      updateDetails.clickNavButtonAdminMyAccount();

      // change admin details (name, surname, email)
      updateDetails.waitForMyAccountPageToLoad();
      updateDetails.changeAdminName("Petras");
      updateDetails.changeAdminSurname("Petraitis");
      updateDetails.changeAdminEmail("pakeistas@emailas.lt");
      updateDetails.clickButtonUpdateAdminDetails();
      updateDetails.assertThatAdminInformationWasUpdated();
      updateDetails.clickOkButtonAdminDetailsUpdated();
  }
  
  @Test (groups = "regression", priority = 2) 
  public void successfullyChangeAdminPassword() {	  
	  UpdateUserDetailsAdminPage changePassword = new UpdateUserDetailsAdminPage(driver);
	  
	  // click button "Keisti"
	  changePassword.clickChangeAdminPasswordButton();
	  
	  // enter old and new password
	  changePassword.enterOldPassword(userLogin);
	  changePassword.enterNewPassword(newAdminPassword);
	  changePassword.enterRepeatedNewPassword(newAdminPassword);
	  
	  // save the new password
	  changePassword.clickButtonSaveChangedPassword();
	  
	  // assert that password was changed
	  changePassword.assertThatAdminPasswordWasUpdated();
	  changePassword.clickOkButtonAdminPasswordChanged();
	  
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogout();
      
      // check if user can login with changed password
      changePassword.waitForLoginToLoad();
      loginPage.doLogin(userLogin, newAdminPassword);
      loginPage.verifyIfAdminIsLoggedIn();
      
      // logout
      loginPage.doLogout();
  }
  
  @Test (groups = "regression", priority = 3) 
  public void successfullyResetAdminPasswordToOriginal() {	  
      
	  // go to login page and click on "Pamiršau slaptažodį" button
      UpdateUserDetailsAdminPage resetPassword = new UpdateUserDetailsAdminPage(driver);
      resetPassword.clickUserForgotPasswordButton();
      
      // enter user email
      resetPassword.enterUserEmail(userLogin);
      resetPassword.clickOkResetPasswordButton();
      resetPassword.clickDoneButtonForgotPassword();
      
      // login as admin
      LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(adminLogin, adminLogin);
      
      // reset password that needs to be reset (the button "Atkurti" has a grey background when it needs to be reset)
      resetPassword.clickResetPasswordButton();
      resetPassword.clickAgreeToResetUserPasswordButton();
      
      // assert message that user password was reset
      resetPassword.assertThatAdminPasswordWasReset();
      resetPassword.clickOkButtonPasswordIsReset();

      // logout and check if user can login with original password
      loginPage.doLogout();
      resetPassword.waitForLoginToLoad();
      loginPage.doLogin(userLogin, userLogin);
      loginPage.verifyIfAdminIsLoggedIn();
      loginPage.doLogout();
  }
}
