package testsSpecialistPages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;
import specialistPages.CreateAndDeleteNewKindergartenPage;

public class CreateAndDeleteNewKindergarten extends BaseTest{

  private static String specialistLogin = "manager@manager.lt";	
	
  @Test (groups = {"smoke", "regression"})
  public void successfullyCreateUpdateDeleteNewKindergarten () {
	  
	  // login as kindergarten specialist (švietimo atstovas)
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(specialistLogin, specialistLogin);
      
      // wait for the page to load and check if the kindergarten specialist is logged in
      loginPage.verifyIfSpecialistIsLoggedIn();
      
      // input new kindergarten details     
      CreateAndDeleteNewKindergartenPage createNewKindergarten = new CreateAndDeleteNewKindergartenPage(driver);
      createNewKindergarten.inputKindergartenID("000000001");
      createNewKindergarten.inputkindergartenName("Testinis darželis");
      createNewKindergarten.inputkindergartenAddress("Adreso g. 5");
      Select dropdownUserRole = new Select(driver.findElement(By.id("elderate")));
	  dropdownUserRole.selectByIndex(5);
	  createNewKindergarten.inputcapacityAgeGroup2to3("15");
	  createNewKindergarten.inputcapacityAgeGroup3to6("21");
	  
	  // save and create new kindergarten
	  createNewKindergarten.clickButtonSaveKindergarten();
	  createNewKindergarten.clickOKWhenKindergartenIsDeletedPopUp();
	  
	  // search for the newly created kindergarten
	  createNewKindergarten.searchForTheNewlyCreatedKindergarten("Testinis darželis");
	  
	  // assert that the new kindergarten is found in the searched list
	  createNewKindergarten.newKindergartenSearchResult();
	  
	  // update and save the kindergarten details
	  createNewKindergarten.clickButtonUpdateKindergarten();
	  createNewKindergarten.updateNewKindergartenName("Kitas pavadinimas");
	  createNewKindergarten.updateKindergartenNumberCapacity3to6("55");
	  createNewKindergarten.clickSaveUpdatedKindergarten();
	  
	  // delete kindergarten
	  createNewKindergarten.clickButtonDeleteKindergarten();
	  createNewKindergarten.clickButtonAgreeToDeleteKindergarten();
	  createNewKindergarten.assertKindergartenWasDeletedSuccesfully();
	  createNewKindergarten.clickOkKindergartenIsDeletedPopup();	
  }
}
