package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class RenewLicencePage extends DriverPage{

	public RenewLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Provide Details - RENEW LIC
	By headingReqDetails = By.xpath("//*[@contentDesc='PROVIDE DETAILS']");
	
	//Input License NUmber to be Renewed
	By renewLicNumber = By.xpath("//*[@resourceid='LicenceNumber']");
	
	//Input Renewal Number
	By renewRenewalNumber = By.xpath("//*[@resourceid='RenewalNumber']");
	
	
	//Next Button
	By renewNextBtn = By.xpath("//*[@resourceid='Next']");
	
	public void renewLicNum(String licence_Number)
	{
		driver.findElement(renewLicNumber).sendKeys(licence_Number);
	}
	
	public void renewLicRenewalNum(String Renewal_Number)
	{
		driver.findElement(renewRenewalNumber).sendKeys(Renewal_Number);
	}
	
	public void nextBtn()
	{
		driver.findElement(renewNextBtn).click();
	}
	
	public void enterLicNumber(String licence_Number)
	{
		fluentWait(renewLicNumber);
		renewLicNum(licence_Number);
		nextBtn();
		
	}
	
	public void verifyHeading()
	{
		driver.findElement(headingReqDetails).isDisplayed();
				
	}
}
