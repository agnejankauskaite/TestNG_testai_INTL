package login;

import org.testng.annotations.Test;

import generalTests.GeneralMethods;

public class AdminLoginLogout extends GeneralMethods {

	@Test (groups = "smoke")
	  public void successfulLoginAndLogout() {
		  // login
	      doLoginAsAdmin();
		  
		  // check if admin is logged in and can see the user list 
		  verifyIfAdminIsLoggedIn();
		
		  // logout
		  doLogout();
	  }
	
	@Test (groups = "regression")
	 public void unsuccessfulLogin() {
		 
		 // wait for the login page to load
		 waitForLoginToLoad();
		 
		 //login with incorrect data
	     doLogin("adminNeteisingas@admin.lt", "adminNeteisingas@admin.lt");
	     
	     // check if an error message appears 
	     checkErrorMessage();
	     
	     
	 }
}
