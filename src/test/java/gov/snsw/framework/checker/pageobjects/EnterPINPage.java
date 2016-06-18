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
		
	public EnterPINPage enterNewPin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new EnterPINPage(driver);
	}
	
	public SNSWCheckerPage confirmNewPIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new SNSWCheckerPage(driver);
	}
	
	public EnterPINPage enterCurrrentPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new EnterPINPage(driver);
	}
	
	public SNSWCheckerPage enterCurrrentPINOnLogin(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new SNSWCheckerPage(driver);
	}
	
	public EnterPINPage enterNewPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new EnterPINPage(driver);
	}
	
	public AppSettingPage confirmNewPINOnChangePIN(String pin)
	{
		fluentWait(enterPin);
		driver.findElement(enterPin).sendKeys(pin);
		return new AppSettingPage(driver);
	}
	
	
	public String getPINPageTitle()
	{
		
		String pinPgExist = driver.findElement(enterPinExist).getText();
		return pinPgExist;
		 
	}
	

}
