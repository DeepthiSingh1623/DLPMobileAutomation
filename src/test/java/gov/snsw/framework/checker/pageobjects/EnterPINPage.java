package gov.snsw.framework.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.holder.pageobjects.DriverPage;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN	
		By enterPin = By.xpath("//*[@resourceid='"+checker_resourceid+":id/pin_entry']");
		By enterPinExist = By.xpath("//*[@resourceid='"+checker_resourceid+":id/pin_title']");
		
	public void enterPin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		
	}
	
	
	public String getPINPageTitle()
	{
		
		String pinPgExist = driver.findElement(enterPinExist).getText();
		return pinPgExist;
		 
	}
	

}
