package parentPages;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AbstractObjectPage;
import utilities.FileReaderUtils;

public class FillAndSubmitNewApplicationPage extends AbstractObjectPage{

	// input fields (additional parent info)
	@FindBy (id= "txtAdditionalName")
	public WebElement secondParentName;
	
	@FindBy (id= "txtAdditionalSurname")
	public WebElement secondParentSurname;
	
	@FindBy (id= "txtAdditionalPersonalCode")
	public WebElement secondParentPersonalCode;
	
	@FindBy (id= "txtAdditionalPhone")
	public WebElement secondParentPhoneNumber;
	
	@FindBy (id= "txtAdditionalEmail")
	public WebElement secondParentEmail;
	
	@FindBy (id= "txtAdditionalAddress")
	public WebElement secondParentAddress;
	
	// input fields (child info)
	@FindBy (id= "txtChildName")
	public WebElement childName;
	
	@FindBy (id= "txtChildSurname")
	public WebElement childSurname;
	
	@FindBy (id= "txtChildPersonalCode")
	public WebElement childPersonalCode;
	
	@FindBy (xpath= "//div[5]//div[5]//input")
	public WebElement childDateOfBirth;
	
	// checkbox (child priorities)
	@FindBy (id= "chkLivesInVilnius")
	public WebElement priorityOne;
	
	@FindBy (id= "chkChildIsAdopted")
	public WebElement priorityTwo;
	
	@FindBy (id= "chkFamilyHasThreeOrMoreChildrenInSchools")
	public WebElement priorityThree;
	
	@FindBy (id= "chkGuardianInSchool")
	public WebElement priorityFour;
	
	@FindBy (id= "chkGuardianDisability")
	public WebElement priorityFive;
	
	// buttons
	@FindBy (id= "btnEnableAdditionalGuardian")
	public WebElement addAdditionalGuardianButton;
	
	public void clickAddAdditionalGuardianButton () {
	addAdditionalGuardianButton.click();
	}
	
	public void inputSecondParentName (String value) {
	secondParentName.sendKeys(value);
	}
	
	public void inputSecondParentSurname (String value) {
	secondParentSurname.sendKeys(value);
	}
	
	public void inputSecondParentPersonalCode (String value) {
	secondParentPersonalCode.sendKeys(value);
	}
	
	public void inputSecondParentPhoneNumber (String value) {
	secondParentPhoneNumber.sendKeys(value);
	}
	
	public void inputSecondParentEmail (String value) {
	secondParentEmail.sendKeys(value);
	}
	
	public void inputSecondParentAddress (String value) {
	secondParentAddress.sendKeys(value);
	}
	
	public void inputChildName (String value) {
	childName.sendKeys(value);
	}
	
	public void inputChildSurname (String value) {
	childSurname.sendKeys(value);
	}
	
	public void inputChildPersonalCode (String value) {
	childPersonalCode.sendKeys(value);
	}
	
	public void inputChildDateOfBirth (String value) {
		childDateOfBirth.click();
		// delete default date value manually
		for (int i= 0; i< 10; i++){
			childDateOfBirth.sendKeys(Keys.BACK_SPACE);
		}
		// input date of birth
		childDateOfBirth.sendKeys(value);
		childDateOfBirth.sendKeys(Keys.ENTER);
	}
	
	public void clickPriorityOne () {
		priorityOne.click();
	}
	
	public void clickPriorityTwo () {
		priorityTwo.click();
	}
	
	public void clickPriorityThree () {
		priorityThree.click();
	}
	
	public void clickPriorityFour () {
		priorityFour.click();
	}
	
	public void clickPriorityFive () {
		priorityFive.click();
	}
	
	// choose kindergarten priorities
	@FindBy (id = "selKindergartenId1")
	public WebElement kindergartenPriorityOne;
	
	public void openKindergartenListDropdownPriorityOne() {
		kindergartenPriorityOne.click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement navApplicationQueue = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/input[@name='kindergartenId1']")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", kindergartenPriorityOne);
		js.executeScript("arguments[0].value='1 Adarželis (Adresas A)'", kindergartenPriorityOne);
		
	}
	
	@FindBy (xpath= "//*[@id=\"selKindergartenId1\"]/input")
	public WebElement dropdownElement;	
	
	// fill in the form with second parent and child details
	public void fillInTheApplication () throws IOException {
		// go to "Sukurti prašymą" page
		clickNavButtonNewApplication();
		    
		// add additional parent/ guardian
		addAdditionalGuardianButton.click();
		
		// fill in additional parent/ guardian details into the form
		applicationFormSecondParentDetails();
		
		// fill in child details into the form
		applicationFormChildDetailsOne();
	}
	
	public void applicationFormSecondParentDetails () throws IOException {
		List<String> formData = FileReaderUtils.getTestData("src/test/resources/parentAndChildDetails.txt");
		String secondParentName = formData.get(0);
		String secondParentSurname = formData.get(1);
		String secondParentPersonalCode = formData.get(2);
		String secondParentPhoneNumber = formData.get(3);
		String secondParentEmail = formData.get(4);
		String secondParentAddress = formData.get(5);
		inputSecondParentName(secondParentName);
		inputSecondParentSurname(secondParentSurname);
		inputSecondParentPersonalCode(secondParentPersonalCode);
		inputSecondParentPhoneNumber(secondParentPhoneNumber);
		inputSecondParentEmail(secondParentEmail);
		inputSecondParentAddress(secondParentAddress);
	}
	
	public void applicationFormChildDetailsOne () throws IOException {
		List<String> formData = FileReaderUtils.getTestData("src/test/resources/parentAndChildDetails.txt");
		String childName = formData.get(6);
		String childSurname = formData.get(7);
		String childPersonalCode = formData.get(8);
		String childDateOfBirth = formData.get(9);
		inputChildName(childName);
		inputChildSurname(childSurname);
		inputChildPersonalCode(childPersonalCode);
		inputChildDateOfBirth(childDateOfBirth);
	}

	public void clickNavButtonNewApplication () {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement navNewApplication = wait.until(
		ExpectedConditions.presenceOfElementLocated(By.id("navUserNewApplication")));
	navNewApplication.click();
	}
	
	
	// constructor
	public FillAndSubmitNewApplicationPage(WebDriver driver) {
		super(driver);
	}

}
