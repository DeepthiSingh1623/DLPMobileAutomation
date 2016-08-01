package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SupportPage extends DriverPage {

	public SupportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By support = By.xpath("//*[text()='Support']");
	
	By customerServices = By.xpath("//*[text()='Customer Service']");
	
	By assistedServices = By.xpath("//*[text()= 'Assisted Services']");
	
    By feedback = By.xpath("//*[@contentDesc='info@service.nsw.gov.au']");

    
    
	
	public void clickSupportOption()
	{
		fluentWait(support);
		driver.findElement(support).click();
	}
	
	public String verifySupportTitile()
	{
		fluentWait(support);
		return driver.findElement(support).getText();
	}
	
	public String verifySupportServices()
	{
		fluentWait(customerServices);
		return driver.findElement(customerServices).getText();
	}
	
	public String verifyAssistedServices()
	{
		fluentWait(assistedServices);
		return driver.findElement(assistedServices).getText();
	}
	
	public String verifyFeedbackServices()
	{
		fluentWait(feedback);
		String feedBackInfo = driver.findElement(feedback).getText();
		return feedBackInfo;
	}
	
	
	
	
	
	
}
