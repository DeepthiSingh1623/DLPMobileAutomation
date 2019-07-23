package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.ios.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.utils.DriverPage;

public class MyLicencesPage extends DriverPage{

	public MyLicencesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//License Page Title
	public String myLicPgTitle()
	{
		By mylicTitle = By.xpath("//*[@label='NSW Recreational Fishing Fee']");
		fluentWait(mylicTitle);
		String myLicPgTitle = driver.findElement(mylicTitle).getText();
		return myLicPgTitle;
	}
	
	//Licence Number Displayed
	public String verifyMyLicPgLicNum(String licence_Number)
	{
		By myLicNum = By.xpath("//*[text()='Licence No. "+licence_Number+"']");
		fluentWait(myLicNum);
		String myLicPgNumberDisp = driver.findElement(myLicNum).getText();
		return myLicPgNumberDisp;
	}
	
	public DetailLicencePage clickOnLicNumber(String licence_Number)
	{
		By licNo = By.xpath("//*[text()='Licence No. "+licence_Number+"']");
										
		driver.findElement(licNo).click();
		return new DetailLicencePage(driver);
	}
	
	//Settings Icon
	By settings = By.xpath("//*[@class='UIATabBar']/button[4]");
							 
	public void settingsBtn()
	{
		driver.findElement(settings).click();
	}
	
	public SettingsPage clickSettingsBtn()
	{
		fluentWait(settings);
		settingsBtn();
		return new SettingsPage(driver);
	}
	
	public String verifyLicName(String licence_Number)
	{
		By LicName = By.xpath("//*[text()='Licence No. "+licence_Number+"']/../text[1]");
		fluentWait(LicName);
		String LicName1 = driver.findElement(LicName).getText();
		return LicName1;
		
	}
	
	
	

}
