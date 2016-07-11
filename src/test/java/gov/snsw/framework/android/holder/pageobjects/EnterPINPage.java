package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import gov.snsw.framework.utils.DriverPage;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN	
	By enterPin = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']");
	
		
	public void enter4DigitPin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		
	}
	//Change PIN 
	public String enterPINPgExist()
	{
		By enterPinExist = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_title']");
		String pinPgExist = driver.findElement(enterPinExist).getText();
		return pinPgExist;
	}	
	
	
	//Change PIN - New
	public EnterPINPage enterNewPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new EnterPINPage(driver);
	}
	//Change PIN Confirm
	public AppSettingPage confirmNewPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new AppSettingPage(driver);
	}
	
	//Enter Current PIN 	
	public EnterPINPage enterCurrrentPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new EnterPINPage(driver);
	}
	
	//Re-enter New PIN on Login
	public MyLicencePage enterCurrrentPINOnLogin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new MyLicencePage(driver);
	}
	
	public String verifyPinEnterTitle()
	{
		By pinTitle = By.xpath("//*[text()='myLicences']");
		fluentWait(pinTitle);
		String pinEnterTitle = driver.findElement(pinTitle).getText();
		return pinEnterTitle;
	}
	
	//Enter CONFIRM PIN 
		public String verifyPinConfirmTitle()
		{
			By pinConfirmTitle = By.xpath("//*[text()='Confirm PIN']");
			fluentWait(pinConfirmTitle);
			String ConfirmpinEnterTitle = driver.findElement(pinConfirmTitle).getText();
			return ConfirmpinEnterTitle;
		}
	
		//Unlock PIN Title
		public String verifyUnlockPINTitle()
		{
			By unlockTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_title']");
			fluentWait(unlockTitle);
			String unlockPINTitle = driver.findElement(unlockTitle).getText();
			return unlockPINTitle;
		}
		
		//Unlock Error PIN
				public String verifyErrorINTitle()
				{
					By ErrorTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_error']");
					fluentWait(ErrorTitle);
					String unlockPINTitle = driver.findElement(ErrorTitle).getText();
					return unlockPINTitle;
				}
		
		//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/pin_error"]
		
		

}
