package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class QuickViewPage extends DriverPage{

	public QuickViewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By pageTitle = By.xpath("//*[@name='Quick View' and @class='UIANavigationBar']//*[@label='Quick View']");

	//*[@label="NSW Recreational Fishing Fee"]
	By unlock = By.xpath("//*[@label='Unlock']");
	
	
	
		
	public String verifyQuickViewTitle()
	{
		fluentWait(pageTitle);
		String quickTitle = driver.findElement(pageTitle).getText();
		return quickTitle;
	}
	
	public String verifyLicenceName()
	{
		By LicName = By.xpath("//*[@label= 'NSW Recreational Fishing Fee']");
		fluentWait(LicName);
		String LicenceName = driver.findElement(LicName).getText();
		return LicenceName;
		
	}
	
	public EnterPinPage clickUnlock()
	{
		driver.findElement(unlock).click();
		return new EnterPinPage(driver);
	}
	
	
	
	
	
}
