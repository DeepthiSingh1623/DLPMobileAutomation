package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class ShareLicencePage extends DriverPage{

	public ShareLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By doneBtn = By.xpath("//*[@label='Done']");
	
	
	
	
	public String getLicName()
	{
		By licName = By.xpath("//*[@label='Name on Licence']/../text[2]");
		String LicenceName = driver.findElement(licName).getText();
		return LicenceName;
	}
	
	public String getLicNum()
	{
		By licNum = By.xpath("//*[@label='Licence No']/../text[2]");
		String LicenceNum = driver.findElement(licNum).getText();
		return LicenceNum;
	}
	
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}
	
	public DetailLicencePage clickDoneBtn()
	{
		fluentWait(doneBtn);
		doneBtn();
		return new DetailLicencePage(driver);
		
	}

	public String verifyLicName()
	{
		By mylicTitle = By.xpath("//*[@label='NSW Recreational Fishing Fee']");
		fluentWait(mylicTitle);
		String myLicenceName = driver.findElement(mylicTitle).getText();
		return myLicenceName;
	}
	
	
	
}
