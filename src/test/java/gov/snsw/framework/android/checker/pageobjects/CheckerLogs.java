package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class CheckerLogs extends DriverPage{

	public CheckerLogs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
		
	By date = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtEventDt'])[1]");
	By licType = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtLicType'])[1]");
	By licNo = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtLicNo'])[1]");
	By eventType = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtEventType'])[1]");
	By syncSts = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtSyncStatus'])[1]");
	By time = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtEventTime'])[1]");
	By notes = By.xpath("(//*[@resourceid='"+checker_android_resourceid+":id/txtHasNotes'])[1]");
	
	
	By flagStatus = By.xpath("//*[text()='OFF']");
	
	public String getDate(){
		
		return driver.findElement(date).getText();
		
	}
	
	public String getLicenceType(){
			
			return driver.findElement(licType).getText();
			
		}
	public String getLicenceNo(){
		
		return driver.findElement(licNo).getText();
		
	}
	public String getEventType(){
		
		return driver.findElement(eventType).getText();
		
	}
	public String getSyncStatus(){
		
		return driver.findElement(syncSts).getText();
		
	}
	public String getTime(){
		
		return driver.findElement(time).getText();
		
	}
	public String getNotes(){
		
		return driver.findElement(notes).getText();
		
	}
	
	public void clickActivityLog(String licenceNo) {
		// TODO Auto-generated method stub
		By log=By.xpath("//*[text()='"+licenceNo+"']");
		driver.findElement(log).click();
	}
	
		
	public String verifyFlagStatus()
	{
		String flagStat = driver.findElement(flagStatus).getText();
		return flagStat;
	}
	

}
