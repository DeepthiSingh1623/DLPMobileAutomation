package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class EnterPinPage extends DriverPage{

	public EnterPinPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN 
	By pin1 = By.xpath("//device/view/window[1]/secure[1]");
	By pin2 = By.xpath("//device/view/window[1]/secure[2]");
	By pin3 = By.xpath("//device/view/window[1]/secure[3]");
	By pin4 = By.xpath("//device/view/window[1]/secure[4]");
	
	//Forgot Pin
	By forgotPin = By.xpath("//*[@label='Forgot your PIN']");
	
	//click SignIn
	By reSignIn = By.xpath("//*[@label='Sign In']");
	
	public String verifyPinEnterTitle()
	{
		By pinTitle = By.xpath("//*[@label='You are required to set up a PIN.  You can change this in your App Settings.']");
		fluentWait(pinTitle);
		String pinEnterTitle = driver.findElement(pinTitle).getText();
		return pinEnterTitle;
	}
	
	
	public void enterPin()
	{
		driver.findElement(pin1).sendKeys("1");
		driver.findElement(pin2).sendKeys("2");
		driver.findElement(pin3).sendKeys("3");
		driver.findElement(pin4).sendKeys("4");
	}
	
	//Enter CONFIRM PIN 
	public String verifyPinConfirmTitle()
	{
		By pinConfirmTitle = By.xpath("//*[@label='Confirm PIN']");
		fluentWait(pinConfirmTitle);
		String ConfirmpinEnterTitle = driver.findElement(pinConfirmTitle).getText();
		return ConfirmpinEnterTitle;
	}
	
	//Unlock PIN Title
	public String verifyUnlockPINTitle()
	{
		By unlockTitle = By.xpath("//*[@label='Unlock with PIN']");
		fluentWait(unlockTitle);
		String unlockPINTitle = driver.findElement(unlockTitle).getText();
		return unlockPINTitle;
	}
	
	//Enter Unlock Pin
	By unlockPin1 = By.xpath("//*[@class='UIASecureTextField'][1]");
	By unlockPin2 = By.xpath("//*[@class='UIASecureTextField'][2]");
	By unlockPin3 = By.xpath("//*[@class='UIASecureTextField'][3]");
	By unlockPin4 = By.xpath("//*[@class='UIASecureTextField'][4]");
	
							 
	
	public void enterPinUnlock()
	{
		driver.findElement(unlockPin1).sendKeys("1");
		driver.findElement(unlockPin2).sendKeys("2");
		driver.findElement(unlockPin3).sendKeys("3");
		driver.findElement(unlockPin4).sendKeys("4");
	}
	
	public MyLicencesPage enterPINUnlock()
	{
		fluentWait(unlockPin1);
		enterPinUnlock();
		return new MyLicencesPage(driver);
		
	}
	
	//Enter New PIN
		
	public void enterNewPIN()
	{
		driver.findElement(pin1).sendKeys("2");
		driver.findElement(pin2).sendKeys("2");
		driver.findElement(pin3).sendKeys("2");
		driver.findElement(pin4).sendKeys("2");
	}
	
	public String invalidPINError()
	{
		By invalidPIN = By.xpath("//*[@label='Invalid PIN']");
		String invalidPin = driver.findElement(invalidPIN).getText();
		return invalidPin;
	}
	
	//Enter newPIN Unlock
	public void enterNewPINUnlock()
	{
		driver.findElement(unlockPin1).sendKeys("2");
		driver.findElement(unlockPin2).sendKeys("2");
		driver.findElement(unlockPin3).sendKeys("2");
		driver.findElement(unlockPin4).sendKeys("2");
	}
	
	//enter Old Pin Page title
	public String verifyOldPinTitle()
	{
		By enterOldPin= By.xpath("//*[text()='Enter old PIN']");
		fluentWait(enterOldPin);
		String enterOldPIN = driver.findElement(enterOldPin).getText();
		return enterOldPIN;
	}
	
	//Enter New Pin Page Title
	public String verifyNewPinTitle()
	{
		By enterNewPin = By.xpath("//*[text()='Enter new PIN']");
		fluentWait(enterNewPin);
		String enterNewPIN = driver.findElement(enterNewPin).getText();
		return enterNewPIN;
	}
	
	public void clickforgotPinTxt()
	{
		fluentWait(forgotPin);
		driver.findElement(forgotPin).click();	
	}
	
	public String verifyForgotPinAlert()
	{
		By forgotPIN = By.xpath("//*[@value='Forgot PIN']");
		fluentWait(forgotPIN);
		String forgotPinMsg = driver.findElement(forgotPIN).getText();
		return forgotPinMsg;
	}
	
	public void clickForgotPinSignIn()
	{
		fluentWait(reSignIn);
		driver.findElement(reSignIn).click();	
	}
	
	
	
	
	
	
	
}
