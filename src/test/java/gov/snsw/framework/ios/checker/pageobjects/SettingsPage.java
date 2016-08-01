package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.ios.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.DriverPage;

public class SettingsPage extends DriverPage{

	public SettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By signout =By.xpath("//*[@label='Sign Out']");
	
	By signOutOKBtn = By.xpath("//*[@label='Yes']");
	
	By autoLock = By.xpath("//*[@label='Auto Lock']");
	
	By changePIN = By.xpath("//*[@label='Change PIN']");
	
	By settingsPgTitile =By.xpath("//*[@label='Settings']");
	
	By settingMainPgTitle = By.xpath("//*[@value='Settings']");
	
	By settingTitleAutoLock = By.xpath("//*[@name='OGNAutoLockTableView']//*[@label='Settings']");
	
	By immediateAutoLock = By.xpath("//*[@label='Immediately']");
	
	By fiveMinutesAutoLock = By.xpath("//*[@name='After 5 minutes' and @class='UIATableCell']//*[@label=' ']");
	
	public void signoutBtn()
	{
		driver.findElement(signout).click();
	}
	
	public void signoutOKBtn()
	{
		driver.findElement(signOutOKBtn).click();
	}
	
	public String verifySettingsPageTitile()
	{
		
		String settingsPageTitle = driver.findElement(settingsPgTitile).getText();
		return settingsPageTitle;
	}
	
	public TermsAndConditionsPage pressSigoutButton()
	{
		fluentWait(signout);
		signoutBtn();
		fluentWait(signOutOKBtn);
		signoutOKBtn();
		return new TermsAndConditionsPage(driver);
	}
	
	public void clickChangePin()
	{
		fluentWait(changePIN);
		driver.findElement(changePIN).click();
	}
	
	public void clickAutoLockOption()
	{
		fluentWait(autoLock);
		driver.findElement(autoLock).click();
	}
	
	
	public boolean verifySettingsTitle()
	{
		boolean autoLockTitlePg = false;
		try
		{
			
			fluentWait(settingTitleAutoLock);
			autoLockTitlePg = driver.findElement(settingTitleAutoLock).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return autoLockTitlePg;
		
	}
	
	public void clickImmediateAutoLockOption()
	{
		fluentWait(immediateAutoLock);
		driver.findElement(immediateAutoLock).click();
	}
	public void clickFiveMinAutoLockOption()
	{
		fluentWait(fiveMinutesAutoLock);
		driver.findElement(fiveMinutesAutoLock).click();
	}
	
	public String verifySettingsMainPageTitle()
	{
		fluentWait(settingMainPgTitle);
		String settingsPageTitle = driver.findElement(settingMainPgTitle).getText();
		return settingsPageTitle;
	}
}

