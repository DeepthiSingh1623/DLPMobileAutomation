package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class AppSettingPage extends DriverPage{

	public AppSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	
	//ChangePIN
	By changePIN = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/txtSettingPin']");
	
	//Auto Lock
	By autoLock = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/txtSettingAutoLock']");
	
	//Back Button
	By appSettingsBackBtn = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/imgLeft']");
	
	public void changePINBtn()
	{
		fluentWait(changePIN);
		driver.findElement(changePIN).click();
	}
	
	public AppSettingPage clickChangePinBtn()
	{
		changePINBtn();
		return new AppSettingPage(driver);
	}
	
	public void BackBtn()
	{
		driver.findElement(appSettingsBackBtn).click();
	}
	
	//Confirm OK button to change PIN
	By changePinOK = By.xpath("//*[@resourceid='android:id/button1']");

	public EnterPINPage okBtn()
	{
		fluentWait(changePinOK);
		driver.findElement(changePinOK).click();
		return new EnterPINPage(driver);
	}
}
