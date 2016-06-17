package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePINPage extends DriverPage{

	public ChangePINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter Current PIN
	By enterPin = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_entry']");
	
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/pin_title"]Enter your current PIN
	
	//Confirm OK button to change PIN
		By changePinOK = By.xpath("//*[@resourceid='android:id/button1']");

	public ChangeNewPINPage enter4DigitCurrentPin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new ChangeNewPINPage(driver);
	}
		
	public String enterCurrentPINPgExist()
	{
		By enterCurrentPinExist = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_title']");
		String currentpinPgExist = driver.findElement(enterCurrentPinExist).getText();
		return currentpinPgExist;
			 
	}
	
	public void okBtn()
	{
		fluentWait(changePinOK);
		driver.findElement(changePinOK).click();
	}
	
	
}
