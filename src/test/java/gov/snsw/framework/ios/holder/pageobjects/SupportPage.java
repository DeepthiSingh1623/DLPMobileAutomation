package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SupportPage extends DriverPage{

	public SupportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By feedBack = By.xpath("//*[@label='info@service.nsw.gov.au']");
	
	By assistedServices = By.xpath("//*[@label='ASSISTED SERVICES']");
	
	By customerService = By.xpath("//*[@label='CUSTOMER SERVICE']");
	
	By settings = By.xpath("//*[@label='Settings']");
	
	By supportPgTitle = By.xpath("//*[@label='Support']");
	
	
	public void clickSettings()
	{
		fluentWait(settings);
		driver.findElement(settings).click();
	}
	
	public String verifyCustomerService()
	{
		fluentWait(customerService);
		return driver.findElement(customerService).getText();
		
	}
	
	public String verifyAssistedService()
	{
		fluentWait(assistedServices);
		return driver.findElement(assistedServices).getText();
		
	}
	
	public String verifyFeedBack()
	{
		fluentWait(feedBack);
		return driver.findElement(feedBack).getText();
		
	}
	
	public String verifySupportPgTitle()
	{
		fluentWait(supportPgTitle);
		return driver.findElement(supportPgTitle).getText();
		
	}
	
	
}
