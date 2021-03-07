package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractObjectPage {

	//input fields
	@FindBy(id = "username")
    public WebElement inputUsername;
	
	@FindBy(id = "password")
	public WebElement inputPassword;
	
	//buttons
	@FindBy(id = "btnLogin")
	public WebElement buttonLogin;
	
	public void enterUsername(String value) {
    inputUsername.sendKeys(value);
    }
	
	public void enterPassword(String value) {
	inputPassword.sendKeys(value);
	}
	
	public void clickLoginButton() {
	buttonLogin.click();
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

	public Boolean waitForLoginToLoad() {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  	return wait.until(ExpectedConditions.textToBe(By.xpath("//h3"), "Prisijungti"));
	}
	
	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
}
