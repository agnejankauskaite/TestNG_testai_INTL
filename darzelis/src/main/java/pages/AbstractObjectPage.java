package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractObjectPage {
	
	protected WebDriver driver; 
	
	public AbstractObjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void doLogin(String username, String password) {
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.enterUsername(username);
	     loginPage.enterPassword(password);
		 loginPage.clickLoginButton();
	 }
	
	public void doLogout() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logoutElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(By.id("btnLogout")));
		  logoutElement.click();  
	 }
	
	public Boolean verifyIfAdminIsLoggedIn() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  return wait.until(ExpectedConditions.textToBe(By.id("navAdminUserList"), "Naudotojų sąrašas"));
		}
	
	public Boolean verifyIfSpecialistIsLoggedIn() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  return wait.until(ExpectedConditions.textToBe(By.id("navManagerKindergartenList"), "Darželių sąrašas"));
		}
	
	
}