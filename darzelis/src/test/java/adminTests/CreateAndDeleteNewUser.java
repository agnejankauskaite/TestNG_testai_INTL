package adminTests;

import org.testng.annotations.Test;

import adminPages.CreateAndDeleteNewUserPage;
import generalMethods.GeneralMethods;

public class CreateAndDeleteNewUser extends GeneralMethods {
  @Test (groups = {"smoke", "regression"}) 
  public void successfullyCreateAndDeleteNewAdmin () {
	  createNewAdmin(0);
	  deleteNewUser();
  }
  
  @Test (groups = {"smoke", "regression"})
  public void successfullyCreateAndDeleteNewKindergartenSpecialist () {
	  createNewKindergartenSpecialist(1); 
	  deleteNewUser();
  }
  
  @Test (groups = {"smoke", "regression"})
  public void successfullyCreateAndDeleteNewParent () {
	  createNewParent(2); 
	  deleteNewUser();
  }
  
}
