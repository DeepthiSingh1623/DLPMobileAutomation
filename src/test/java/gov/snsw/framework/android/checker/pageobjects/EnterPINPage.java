package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class EnterPINPage extends DriverPage{

	public EnterPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter PIN	
		By enterPin = By.xpath("//*[@class='android.widget.EditText']");
		By enterPinExist = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/pin_title']");
		
		//Alert
		By confirmPg = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/alertTitle']");
		
		// OK Button
		By okBtn = By.xpath("//*[@resourceid='android:id/button1']");
		
		//Forgot PIN
		By forgotPIN = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/forgot_pin']");
	
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
	
	public void clickForgotPIN()
	{
		fluentWait(forgotPIN);
		driver.findElement(forgotPIN).click();;
	}
	
	public String verifyConfirmAlert()
	{
		fluentWait(confirmPg);
		String confirmTitle = driver.findElement(confirmPg).getText();
		return confirmTitle;
	}
	
	public void clickOKBtn()
	{
		fluentWait(okBtn);
		driver.findElement(okBtn);
	}
	
	

}
