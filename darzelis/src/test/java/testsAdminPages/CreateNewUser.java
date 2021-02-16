package testsAdminPages;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.CreateNewUserPage;
import pages.LoginPage;

public class CreateNewUser extends BaseTest{
	
  private String adminLogin = "admin@admin.lt";	
  private String newUserSuccessMessage = "Naujas naudotojas buvo sėkmingai sukurtas.";
  private String userIsDeletedSuccessMessage = "Naudotojas panaikintas sėkmingai";
	
  @Test
  public void successfulNewAdminCreateAndDelete() {
	  
	  //login as admin
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.doLogin(adminLogin, adminLogin);
      
      // wait for the page to load
      WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement waitForUserRole = wait.until(
			  ExpectedConditions.presenceOfElementLocated(By.id("selRole")));
	   
      // select user role (admin)
	  Select dropdownUserRole = new Select(driver.findElement(By.id("selRole")));
	  dropdownUserRole.selectByIndex(0);
	  
	  // enter email
	  CreateNewUserPage createNewUserPage = new CreateNewUserPage(driver);
	  createNewUserPage.enterEmail("email@adminas.lt");
	  
	  // enter name and surname  
	  createNewUserPage.enterName("Vardas");
	  createNewUserPage.enterSurname("Pavardė");
	  
	  // create the user
	  createNewUserPage.clickCreateButton();
	  
	  // check success message
	  WebElement popUpSuccess = wait.until(
			 ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]")));

	  String successMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div[3]")).getText();
	  assertEquals(successMessage, newUserSuccessMessage);
	  
	  // click "Gerai" button
	  createNewUserPage.clickOKButtonUserIsCreated();
	  
	  // delete the new user
	  WebElement deleteUserButton = wait.until(
			  ExpectedConditions.presenceOfElementLocated(By.id("btnDeleteUser")));
	  createNewUserPage.clickDeleteUserButton();

	  // check success message that user was deleted
	  WebDriverWait waitForSuccessfulDeleteMessage = new WebDriverWait(driver, 10);
	  WebElement popUpUserDeleted = waitForSuccessfulDeleteMessage.until(
			 ExpectedConditions.presenceOfElementLocated(By.xpath("body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-text")));

	  String userIsDeletedMessage= driver.findElement(By.xpath("body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-text")).getText();
	  assertEquals(userIsDeletedMessage, userIsDeletedSuccessMessage);
	  
	  
//	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/button")).click();
  }
  
//  private Boolean verifyUserWasDeleted () {
//	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//			  .withTimeout(Duration.ofSeconds(20))
//			  .pollingEvery(Duration.ofMillis(50))
//			  .ignoring(NoSuchElementException.class);
//	  
//	  WebElement waitForSuccessfulDeleteMessage = wait.until(new Function<WebDriver, WebElement>() {
//		  public WebElement apply(WebDriver driver) {
//			  return driver.findElement(By.cssSelector("body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-text"));
//		  }  
//	  });
//	  return waitForSuccessfulDeleteMessage.getText().contains(userIsDeletedSuccessMessage);
//  }

}
