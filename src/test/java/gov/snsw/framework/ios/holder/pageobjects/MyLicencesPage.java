package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.ios.holder.pageobjects.DetailLicencePage;

public class MyLicencesPage extends DriverPage{

	public MyLicencesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//License Page Title
	public String myLicPgTitle()
	{
		By mylicTitle = By.xpath("//*[@label='Recreational Fishing Fee']");
		String myLicPgTitle = driver.findElement(mylicTitle).getText();
		return myLicPgTitle;
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
	
	
	

}
