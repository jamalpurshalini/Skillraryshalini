package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class CategoryPage {
	//Declaration
	@FindBy(xpath="//h1[normalize-space()='Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()=' New']")
	private WebElement newButton;
	
	private String deletePath= "//td[text()=%s]/ancestor::tr" + "/descendant::button[text()='Delete']";
	
	@FindBy(xpath="//button[@name='delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//h4[text()=' Success!']")
	private WebElement successMessage;
	
	//Initialization
    public CategoryPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    //utilization
    public String getPageHeader() {
    	return pageHeader.getText();
    	}
    public void clickNewButton() {
    	newButton.click();
    }
    public void deleteCategory(WebDriverUtility web, String couseName) {
    	web.convertPathToWebElemnt(deletePath, couseName).click();
    	deleteButton.click();
    }
   public String getSuccessMessage() {
	   return successMessage.getText();
	   
   }
	
}
