package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
	
}