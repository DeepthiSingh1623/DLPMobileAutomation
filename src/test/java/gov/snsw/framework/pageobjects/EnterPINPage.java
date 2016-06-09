package gov.snsw.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.pageobjects.DriverPage;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN
	By enterPin = By.xpath("//*[contains(text(),'App settings.')]/../group");
	
		
	public ConfirmPINPage enter4DigitPin(String pin)
	{
		driver.findElement(enterPin).sendKeys(pin);
		return new ConfirmPINPage(driver);
	}
	
	

}
