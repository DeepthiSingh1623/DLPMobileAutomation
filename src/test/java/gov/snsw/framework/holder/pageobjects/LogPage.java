package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogPage extends DriverPage {

	public LogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	By backBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
	
	
	
	public String verifylogsTitle()
	{
		By logsTitle = By.xpath("//*[@resourceid='"+holder_resourceid+":id/toolbarTitle']");
		String logsTitleBar = driver.findElement(logsTitle).getText();
		return logsTitleBar;
		
	}
	
	public MyLicencePage clickBackBtnLogPg()
	{		
		driver.findElement(backBtn);
		return new MyLicencePage(driver);
	}
	
	public LogDetailPage clickOnLicNumber(String licence_Number)
	{
		By licNo = By.xpath("//*[text()='"+licence_Number+"']");
		driver.findElement(licNo).click();
		return new LogDetailPage(driver);
		
	}
	
	public String checklogDetails()
	{
		By LicLogEventType = By.xpath("//*[text()='Check']");
		String eventType = driver.findElement(LicLogEventType).getText();
		return eventType;
		
	}
	

	
}
