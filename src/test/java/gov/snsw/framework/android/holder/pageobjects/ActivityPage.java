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
	
	By activityLicType1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicType'])[1]");
	
	
	
	By activityLicNum = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtLicNo']");
	By activityEventType = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtEventType']");
	
	//Back Button on the Activity Detail Page
	By activityBackBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");

	//Activity Detail	
	By activityLicNumber = By.xpath("//*[@contentDesc='Licence Number']/../text[2]");
	
	//Hyper Link Exist - Important
	public By helpActivity = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtActivityHelp']");
	
	
	public String getActivityDate()
	{
		
		return driver.findElement(activityDate).getText();
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
	
	public String getLicType()
	{
		By activityLicType1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicType'])[1]");
		fluentWait(activityLicType1);
		String LicType1 = driver.findElement(activityLicType1).getText();
		return LicType1;
	}
	
	public String getAltLicType()
	{
		By activityLicType2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicType'])[2]");
		fluentWait(activityLicType2);
		String LicType2 = driver.findElement(activityLicType2).getText();
		return LicType2;
	}
	
	public String getLicNum()
	{
		By activityLicNum1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicNo'])[1]");
		fluentWait(activityLicNum1);
		String LicNum1 = driver.findElement(activityLicNum1).getText();
		return LicNum1;
	}
			
	public String getAltLicNum()
	{
		By activityLicNum2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicNo'])[2]");
		fluentWait(activityLicNum2);
		String LicNum2 = driver.findElement(activityLicNum2).getText();
		return LicNum2;
	}
	
	public String getLicEventType()
	{
		By activityLicEventType1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtEventType'])[1]");
		fluentWait(activityLicEventType1);
		String eventType1 = driver.findElement(activityLicEventType1).getText();
		return eventType1;
	}
			
	public String getAltLicEventType()
	{
		By activityLicEventType2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtEventType'])[2]");
		fluentWait(activityLicEventType2);
		String eventType2 = driver.findElement(activityLicEventType2).getText();
		return eventType2;
	}
	
	public void clickLicType()
	{
		By LicType1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicType'])[1]");
		fluentWait(LicType1);
		driver.findElement(LicType1).click();
	}
	
	public void clickAltLicType()
	{
		By LicType2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicType'])[2]");
		fluentWait(LicType2);
		driver.findElement(LicType2).click();
	}
	

	
	
	
	
	
	
	
	
}






