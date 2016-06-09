package gov.snsw.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.pageobjects.DriverPage;

public class ConfirmPINPage extends DriverPage{

	public ConfirmPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Enter Confirm PIN
	By confirmPin = By.xpath("//*[contains(text(),'confirm')]/../group");
	
	public MyLicencePage enter4DigitConfirmNumber(String pin)
	{
		driver.findElement(confirmPin).sendKeys(pin);
		return new MyLicencePage(driver);
	}
	

}
