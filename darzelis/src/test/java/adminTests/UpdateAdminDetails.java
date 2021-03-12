package adminTests;

import org.testng.annotations.Test;

import generalMethods.GeneralMethods;

public class UpdateAdminDetails extends GeneralMethods{
  @Test (groups = "regression", priority = 1) 
  public void successfullyChangeAdminDetails() {
	  // create a new user (admin) for this test
	  createNewAdmin(0);
	  doLogout();
	  doLogin(createNewUserAdminEmail, createNewUserAdminEmail);
	  
	  // go to "Mano paskyra" page
      clickNavButtonAdminMyAccount();
      
      // change admin details
      inputUserDetails();
      clickChangeUserDetails();
  }
  
  @Test (groups = "regression", priority = 2) 
  public void successfullyChangeAdminPassword() {
	  changeUserPassword(createNewUserAdminEmail);
  }
  
  @Test (groups = "regression", priority = 3) 
  public void successfullyResetAdminPasswordToOriginal() {
	  resetUserPassword(createNewUserAdminEmail);
	  
	  // delete user after successful user details change
	  doLoginAsAdmin();
	  deleteNewUser();
	  doLogout();
  }
}
