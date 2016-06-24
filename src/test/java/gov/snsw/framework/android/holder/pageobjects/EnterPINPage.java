package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.android.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.android.holder.pageobjects.DriverPage;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN	
	By enterPin = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_entry']");
	
		
	public void enter4DigitPin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		
	}
	//Change PIN 
	public String enterPINPgExist()
	{
		By enterPinExist = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_title']");
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
	

}
