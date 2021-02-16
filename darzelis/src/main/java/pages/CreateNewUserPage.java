package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewUserPage extends AbstractObjectPage {

	//input fields	
	@FindBy (id= "txtEmail")
	public WebElement inputEmail;
	
	@FindBy (id = "txtName")
	public WebElement inputName;
	
	@FindBy (id="txtSurname")
	public WebElement inputSurname;
	
	//buttons
	@FindBy (id = "btnCreate")
	public WebElement createButton;
	
	@FindBy (xpath = "/html/body/div[2]/div/div[4]/div/button")
	public WebElement okButtonUserIsCreated;
	
	@FindBy (id = "btnDeleteUser")
	public WebElement deleteUserButton;
	
	@FindBy (xpath = "\"/html/body/div[2]/div/div[2]/div/button\"")
	public WebElement okButtonUserIsDeleted;
	
	public void enterEmail (String value) {
		inputEmail.sendKeys(value);
	}
	
	public void enterName (String value) {
		inputName.sendKeys(value);
	}
	
	public void enterSurname (String value) {
		inputSurname.sendKeys(value);
	}
	
	public void clickCreateButton () {
		createButton.click();
	}
	
	public void clickOKButtonUserIsCreated () {
		okButtonUserIsCreated.click();
	}
	
	public void clickDeleteUserButton () {
		deleteUserButton.click();
	}
	
	public void clickOKButtonUserIsDeleted () {
		okButtonUserIsDeleted.click();
	}
	
	// constructor
	public CreateNewUserPage(WebDriver driver) {
		super(driver);
	}
}
