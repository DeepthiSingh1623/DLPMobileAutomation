package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class ActivityPage extends DriverPage {

	public ActivityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Licence Type
	By licType = By.xpath("//*[@label='Recreational Fishing Fee']");
	
	By eventType = By.xpath("//*[@label='Add']");
	
	By activityPage = By.xpath("//*[@label='Activity']");
	
	By activityDetailPage = By.xpath("//*[@label='Activity Detail']");
	
	By settings = By.xpath("//*[@label='Settings']");
	
	public By activityHelp = By.xpath("//device/view/window[1]/table[1]/cell[7]/textfield[1]");
	
	public void clickLicNum(String licenceNo) {
		// TODO Auto-generated method stub
		By log = By.xpath("//*[text()='"+licenceNo+"']");
		driver.findElement(log).click();
	}
	
	public String getLicType()
	{
		fluentWait(licType);
		String licType1 = driver.findElement(licType).getText();
		return licType1;
	}
	
	public String getEventType()
	{
		fluentWait(licType);
		String eventType1 = driver.findElement(eventType).getText();
		return eventType1;
	}
	
	public SettingsPage clickSettings()
	{
		driver.findElement(settings).click();
		return new SettingsPage(driver);
	}
	
	public String verifyActivityTitle()
	{
		fluentWait(activityPage);
		String activityTitle = driver.findElement(activityPage).getText();
		return activityTitle;
	}
	public String verifyActivityDetailTitle()
	{
		fluentWait(activityDetailPage);
		String activityDetailTitle = driver.findElement(activityDetailPage).getText();
		return activityDetailTitle;
	}
	
	

}
