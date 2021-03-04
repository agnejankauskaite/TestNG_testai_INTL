package testsAdminPages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import adminPages.CreateAndDeleteNewUserPage;
import basetest.BaseTest;
import pages.LoginPage;

public class CreateAndDeleteNewUser extends BaseTest{
	
  private String adminLogin = "admin@admin.lt";	
	
  @Test (groups = {"smoke", "regression"}, priority = 1) 
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
	  createNewUserPage.enterEmail("emailtestinis@adminas.lt");
	  
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

	  // agree to delete user (pop up)
	  createNewUserPage.waitToAgreeToDeleteUserPopUp();
	  createNewUserPage.waitToPressOKWhenUserIsDeletedPopUp();	  
  }
  
  @Test (groups = {"smoke", "regression"}, priority = 2)
  public void successfullyCreateAndDeleteNewKindergartenSpecialist() {
	   
      // select user role (švietimo specialistas)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(1);
	  
	  // enter email
	  CreateAndDeleteNewUserPage createNewUserPage = new CreateAndDeleteNewUserPage(driver);
	  createNewUserPage.enterEmail("emailtestinis@manager.lt");
	  
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

	  // agree to delete user (pop up)
	  createNewUserPage.waitToAgreeToDeleteUserPopUp();
	  createNewUserPage.waitToPressOKWhenUserIsDeletedPopUp();	
  }
  
  @Test (groups = {"smoke", "regression"}, priority = 3)
  public void successfullyCreateAndDeleteNewParent() {
	   
      // select user role (vaiko atstovas)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(2);
	  
	  // enter email
	  CreateAndDeleteNewUserPage createNewUserPage = new CreateAndDeleteNewUserPage(driver);
	  createNewUserPage.enterEmail("emailtestinis@parents.lt");
	  
	  // enter user details  
	  createNewUserPage.enterName("Vardas");
	  createNewUserPage.enterSurname("Pavardė");
	  createNewUserPage.enterPersonalCode("12345678911");
	  createNewUserPage.enterPhoneNumber("+37061212123");
	  createNewUserPage.enterAddress("Adreso g. 8");
	  
	  // create the user
	  createNewUserPage.clickCreateButton();
	  
	  // check success message
	  createNewUserPage.userIsCreatedMessage();
	  createNewUserPage.clickOKButtonUserIsCreated();
	  
	  // delete the new user
	  createNewUserPage.clickDeleteUserButton();

	  // agree to delete user (pop up)
	  createNewUserPage.waitToAgreeToDeleteUserPopUp();
	  createNewUserPage.waitToPressOKWhenUserIsDeletedPopUp();	
  }
}
