package testsParentPages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.LoginPage;
import parentPages.FillAndSubmitNewApplicationPage;

public class SubmitNewApplication extends BaseTest{
	
  private String userLogin = "user2@user.lt";
	
  @Test (groups = {"smoke, regression"}, priority = 1) 
  public void successfullyFillAndSubmitNewApplication() throws IOException {
	  
	  //login as parent/ guardian
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(userLogin, userLogin);
      
      // add additional parent/ guardian and fill in parent and child details
      FillAndSubmitNewApplicationPage newApplication = new FillAndSubmitNewApplicationPage(driver);
      newApplication.fillInTheApplication();
      
      // check all priorities
      newApplication.clickPriorityOne();
      newApplication.clickPriorityTwo();
      newApplication.clickPriorityThree();
      newApplication.clickPriorityFour();
      newApplication.clickPriorityFive();
      
      // choose a kindergarten from the list
//    Select dropdownUserRole = new Select(driver.findElement(By.xpath("//*/form/div[3]//div[3]/div")));
//	  dropdownUserRole.selectByIndex(3);
  	  }
  
}
