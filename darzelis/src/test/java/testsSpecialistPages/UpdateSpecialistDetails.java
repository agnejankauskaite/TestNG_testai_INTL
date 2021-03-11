package testsSpecialistPages;
import org.testng.annotations.Test;
import generalTests.GeneralTests;

public class UpdateSpecialistDetails extends GeneralTests {
	
  private String specialistLogin = "manager2@manager.lt";
	
  @Test  (groups = "regression", priority = 1) 
  public void successfullyChangeKindergartenSpecialistDetails() {
	  
	  //login as kindergarten specialist
      doLogin(specialistLogin, specialistLogin);
      
      // go to "Mano paskyra" page
      clickNavButtonSpecialistMyAccount();
      
      // change kindergarten specialist details
      inputUserDetails();
      clickChangeUserDetails();
  }
  
  @Test (groups = "regression", priority = 2) 
  public void successfullyChangeSpecialistPassword() {	  
	  changeUserPassword(specialistLogin);
  }
  
  @Test (groups = "regression", priority = 3) 
  public void successfullyResetSpecialistPasswordToOriginal () {	  
	  resetUserPassword(specialistLogin); 
  }
  
}
