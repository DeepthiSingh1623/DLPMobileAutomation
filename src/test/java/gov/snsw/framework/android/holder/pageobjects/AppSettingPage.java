package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AppSettingPage extends DriverPage{

	public AppSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	
	//ChangePIN
	By changePIN = By.xpath("//*[@resourceid='"+holder_resourceid+":id/txtSettingPin']");
	
	//Auto Lock
	By autoLock = By.xpath("//*[@resourceid='"+holder_resourceid+":id/txtSettingAutoLock']");
	
	//Back Button
	By appSettingsBackBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
	
	//Chane PIN Button
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
		By appSettingsPg = By.xpath("//*[@resourceid='"+holder_resourceid+":id/toolbarTitle']");
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
		
	
	
	
	
}