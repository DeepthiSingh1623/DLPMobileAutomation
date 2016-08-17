package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;



public class AppSettingPage extends DriverPage{

	public AppSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	
	//ChangePIN
	By changePIN = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtSettingPin']");
	
	//Auto Lock
	By autoLock = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtSettingAutoLock']");
	
	//Back Button
	By appSettingsBackBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
	
	//Quick View
	By quickView = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/switchQuickView']");
	
	//autolock Title 
	By autoLockTitle = By.xpath("//*[text()='Auto lock']");
	
	//autolock Immediately
	By immediatelyRadio = By.xpath("//*[text()='Immediately']");
	
	//autolock 5 Minutes
	By fiveMinutesRadio = By.xpath("//*[text()='After 5 minutes']");
	
	//Chane PIN Button
	public void changePINBtn()
	{
		driver.findElement(changePIN).click();
	}
	
	public void clickChangePinBtn()
	{
		fluentWait(changePIN);
		changePINBtn();
		
	} 	
	
	//Click Back Button on the App Settings Page
	public void BackBtn()
	{
		driver.findElement(appSettingsBackBtn).click();
	}
	
	public MyLicencePage clickAppSettingsBackBtn()
	{
		BackBtn();
		return new MyLicencePage(driver);
	}
	
	public String verifyAppSettingTitleBar()
	{
		//By appSettingsPg = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
		By appSettingsPg = By.xpath("//*[text()='App Settings']");
		fluentWait(appSettingsPg);
		String appTitleBar = driver.findElement(appSettingsPg).getText();
		return appTitleBar;
	}
	
	//Confirm OK button to change PIN
	By changePinOK = By.xpath("//*[@resourceid='android:id/button1']");
		
	public EnterPINPage changePINOkBtn()
	{
		fluentWait(changePinOK);
		driver.findElement(changePinOK).click();
		return new EnterPINPage(driver);
	}
	
	public void clickQuickView()
	{
		fluentWait(quickView);
		driver.findElement(quickView).click();
	}
	
	public void clickAutoLock()
	{
		fluentWait(autoLock);
		driver.findElement(autoLock).click();
		
	}
	

	
	public boolean alertAutoLock()
	{
		boolean autoLockTitlePg = false;
		try
		{
			
			fluentWait(autoLockTitle);
			autoLockTitlePg = driver.findElement(autoLockTitle).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return autoLockTitlePg;
		
	}
	
	public void clickImmediatelyRadioButton()
	{
		fluentWait(immediatelyRadio);
		driver.findElement(immediatelyRadio).click();
	}
	
	public void clickFiveMinutesRadioButton()
	{
		fluentWait(fiveMinutesRadio);
		driver.findElement(fiveMinutesRadio).click();
	}
	
	
	
	
	
		
	
	
	
	
}
