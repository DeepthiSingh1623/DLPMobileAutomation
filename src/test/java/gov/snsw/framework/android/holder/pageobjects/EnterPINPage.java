package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import gov.snsw.framework.utils.DriverPage;
import gov.snsw.framework.utils.Utilities;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN	
	//By enterPin = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']");
	
	By enterPin = By.xpath("//*[@class='android.widget.EditText']");
	//By enterPin1 = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']/text[1]");
	//By enterPin2 = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']/text[2]");
	//By enterPin3 = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']/text[3]");
	//By enterPin4 = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/pin_entry']/text[4]");
		
	//forgot PIN
	By forgotPIN = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/forgot_pin']");
	
	//ConfirmText
	By confirmTxt = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/alertTitle']");
	
	//Forgot PIN Ok btn
	By forgotPinOkBtn = By.xpath("//*[@resourceid='android:id/button1']");
	
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
		WebElement element = fluentWait(pinTitle);
		Utilities.logUxPersonaTimer((RemoteWebDriver)driver,"signIn","Time to sign in after PIN entry", 5000);
		//String pinEnterTitle = driver.findElement(pinTitle).getText();
		return element.getText();
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
		
				public String verifyPinEnterPg()
				{
					By pinTitle = By.xpath("//*[text()='Enter PIN']");
					fluentWait(pinTitle);
					String pinEnterTitle = driver.findElement(pinTitle).getText();
					return pinEnterTitle;
				}
				
				public void clickForgotPIN()
				{
					fluentWait(forgotPIN);
					driver.findElement(forgotPIN).click();
				}
				
				public String verifyConfirmTxt()
				{
					fluentWait(confirmTxt);
					String confirmTxt1 = driver.findElement(confirmTxt).getText();
					return confirmTxt1;
				}
				
				public void clickOkBtn()
				{	
					fluentWait(forgotPinOkBtn);
					driver.findElement(forgotPinOkBtn).click();
				}
				
				public String verifyForgotPinTitle()
				{
					By forgotPinTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/forgot_pin']");
					fluentWait(forgotPinTitle);
					String forgotPinPg = driver.findElement(forgotPinTitle).getText();
					return forgotPinPg;
				}
}
