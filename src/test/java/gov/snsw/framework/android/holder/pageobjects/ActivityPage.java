package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class ActivityPage extends DriverPage{

	public ActivityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Activity Page Title
	By activityTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
	By activityDate = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtEventDt']");
	By activityLicType = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtLicType']");
	
	By activityLicNum = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtLicNo']");
	By activityEventType = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtEventType']");
	
	//Back Button on the Activity Detail Page
	By activityBackBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");

	//Activity Detail	
	By activityLicNumber = By.xpath("//*[@contentDesc='Licence Number']/../text[2]");
	

	public String getActivityDate()
	{
		
		return driver.findElement(activityDate).getText();
	}
	
	public String getActivityLicType()
	{
		
		return driver.findElement(activityLicType).getText();
	}
	
	
	public String getActivityLicNum()
	{
		
		return driver.findElement(activityLicNum).getText();
	}
	
	
	public String getActivityEventType()
	{
		
		return driver.findElement(activityEventType).getText();
	}
	
	public String getActivityDetailsLicNumber()
	{
		
		return driver.findElement(activityLicNumber).getText();
	}
	
	public void clickLicNumber()
	{
		
		 driver.findElement(activityLicNum).click();
	}
	
	public String isActivityTitlePresent()
	{
		fluentWait(activityTitle);
		return driver.findElement(activityTitle).getText();
	}
		
	
	public void clickActivityBackBtn()
	{		
		driver.findElement(activityBackBtn).click();
	}
	
	
	
	
	
	
	
	
	
}






