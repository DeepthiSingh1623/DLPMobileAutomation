package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.holder.pageobjects.DriverPage;

public class ConfirmPINPage extends DriverPage{

	public ConfirmPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Enter Confirm PIN	
	By confirmPin = By.xpath("//*[@resourceid='"+resourceid+":id/pin_entry']");
	
	public MyLicencePage enter4DigitConfirmNumber(String pin)
	{
		driver.findElement(confirmPin).sendKeys(pin);
		return new MyLicencePage(driver);
	}
	

}
