package testsAdminPages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.CreateAndDeleteNewUserPage;
import pages.LoginPage;

public class CreateAndDeleteNewUser extends BaseTest{
	
  private String adminLogin = "admin@admin.lt";	
	
  @Test
  public void successfullyCreateAndDeleteNewAdmin() {
	  
	  //login as admin
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(adminLogin, adminLogin);
      
      // wait for the page to load
      loginPage.verifyIfAdminIsLoggedIn();
	   
      // select user role (administratorius)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(0);
	  
	  // enter email
	  CreateAndDeleteNewUserPage createNewUserPage = new CreateAndDeleteNewUserPage(driver);
	  createNewUserPage.enterEmail("email@adminas.lt");
	  
	  // enter name and surname  
	  createNewUserPage.enterName("Vardas");
	  createNewUserPage.enterSurname("Pavardė");
	  
	  // create the user
	  createNewUserPage.clickCreateButton();
	  
	  // check success message
	  createNewUserPage.userIsCreatedMessage();
	  createNewUserPage.clickOKButtonUserIsCreated();
	  
	  // delete the new user
	  createNewUserPage.clickDeleteUserButton();

	  // check success message that user was deleted
	  createNewUserPage.userWasDeletedMessage();
	  
	  // click "Gerai" button
	  createNewUserPage.clickOKButtonUserIsDeleted();
  }
  
  @Test
  public void successfullyCreateAndDeleteNewKindergartenSpecialist() {
	   
      // select user role (švietimo specialistas)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(1);
	  
	  // enter email
	  CreateAndDeleteNewUserPage createNewUserPage = new CreateAndDeleteNewUserPage(driver);
	  createNewUserPage.enterEmail("specialist@manager.lt");
	  
	  // enter name and surname  
	  createNewUserPage.enterName("Vardas");
	  createNewUserPage.enterSurname("Pavardė");
	  
	  // create the user
	  createNewUserPage.clickCreateButton();
	  
	  // check success message
	  createNewUserPage.userIsCreatedMessage();
	  createNewUserPage.clickOKButtonUserIsCreated();
	  
	  // delete the new user
	  createNewUserPage.clickDeleteUserButton();

	  // check success message that user was deleted
	  createNewUserPage.userWasDeletedMessage();
	  
	  // click "Gerai" button
	  createNewUserPage.clickOKButtonUserIsDeleted();
  }
  
  @Test
  public void successfullyCreateAndDeleteNewParent() {
	   
      // select user role (vaiko atstovas)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(2);
	  
	  // enter email
	  CreateAndDeleteNewUserPage createNewUserPage = new CreateAndDeleteNewUserPage(driver);
	  createNewUserPage.enterEmail("parent@parents.lt");
	  
	  // enter user details  
	  createNewUserPage.enterName("Vardas");
	  createNewUserPage.enterSurname("Pavardė");
	  createNewUserPage.enterPersonalCode("12345678911");
	  createNewUserPage.enterPhoneNumber("61212123");
	  createNewUserPage.enterAddress("Adreso g. 8");
	  
	  // create the user
	  createNewUserPage.clickCreateButton();
	  
	  // check success message
	  createNewUserPage.userIsCreatedMessage();
	  createNewUserPage.clickOKButtonUserIsCreated();
	  
	  // delete the new user
	  createNewUserPage.clickDeleteUserButton();

	  // check success message that user was deleted
	  createNewUserPage.userWasDeletedMessage();
	  
	  // click "Gerai" button
	  createNewUserPage.clickOKButtonUserIsDeleted();
  }
  
  
  

}
