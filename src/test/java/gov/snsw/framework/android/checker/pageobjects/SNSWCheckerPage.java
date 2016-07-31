package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.android.checker.pageobjects.AppSettingPage;
import gov.snsw.framework.utils.DriverPage;

public class SNSWCheckerPage extends DriverPage{
	
	
	public By manualScan = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/btnManualCheck']");
	
	By scanOption = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/btnFloatingActionButton']");
	
	//Click Settings to ChangePIN
		By settingOption = By.xpath("//*[text()='Settings']");
	
	
	//Click on Sign out  
	By signOut = By.xpath("//*[text()='Sign Out']");
	
	
	//Click on the Sign out OK Confirm Button  
	By ok = By.xpath("//*[text()='OK']");
	
	//Click 3bars Setting	
	By setting3Bars = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/imgLeft']");
	By selectSearchOption = By.xpath("//*[text()='Search']");
	By checkerLog = By.xpath("//*[text()='Checks']");
	public SNSWCheckerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signOut()
	{
		fluentWait(setting3Bars);
		driver.findElement(setting3Bars).click();
		driver.findElement(signOut).click();
		driver.findElement(ok).click();
	}
	

	public LicenceSearch clickSearch() {
		// TODO Auto-generated method stub
		fluentWait(setting3Bars);
		driver.findElement(setting3Bars).click();
		driver.findElement(selectSearchOption).click();
		return new LicenceSearch(driver);
	}
	
	//Setting Menu to change PIN
		public AppSettingPage clickSettings()
		{
			fluentWait(setting3Bars);
			driver.findElement(setting3Bars).click();
			driver.findElement(settingOption).click();
			return new AppSettingPage(driver);
		}
		
				
		public CheckerLogs clickCheckerLog(){
			
			driver.findElement(checkerLog).click();
			return new CheckerLogs(driver);
		}

}
