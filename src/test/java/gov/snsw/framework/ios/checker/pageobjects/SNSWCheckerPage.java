package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.ios.checker.pageobjects.SettingsPage;
import gov.snsw.framework.ios.checker.pageobjects.LicenceSearchPage;
import gov.snsw.framework.utils.DriverPage;

public class SNSWCheckerPage extends DriverPage{

	public SNSWCheckerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Settings IconPage
	By settings = By.xpath("//*[@class='UIATabBar']/button[3]");
	
	By manualSearchBtn = By.xpath("//*[@class='UIATabBar']/button[2]");
							 
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
	
	public LicenceSearchPage clickActivity()
	{
		fluentWait(manualSearchBtn);
		driver.findElement(manualSearchBtn).click();
		return new LicenceSearchPage(driver);
	}

	
	
}
