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
	
	By aboutOption = By.xpath("//*[@label='About']");
	
	By appBulidName = By.xpath("//*[@label='Name']/../text[2]");
	
	By appVersion = By.xpath("//*[@label='Version']/../text[2]");
	
	By appDetails = By.xpath("//*[@label='APP DETAILS']");
	
	By supportOption = By.xpath("//*[@label='Support']");
	
	//Support Page Title
	By supportTitle = By.xpath("//*[@label='Support']");
	
	//Agency Support Text
	By supportAgencyTxt = By.xpath("//*[@label='AGENCY SUPPORT']");
	
	//support Email
	By supportEmail = By.xpath("//*[@label='support@licence.nsw.gov.au']");
	
	//BackBtn
	By supportBackBtn = By.xpath("//*[@name='Support' and @class='UIANavigationBar']//*[@label='Settings']");
	
	
	By aboutTitle = By.xpath("//*[@name='OGNAboutView']//*[@label='Settings']");
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
			e.printStackTrace();
		}
		return autoLockTitlePg;
		
	}
	
	public void clickSettingBackButton()
	{
		driver.findElement(aboutTitle).click();
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
	
	public void clickAboutOption()
	{
		fluentWait(aboutOption);
		driver.findElement(aboutOption).click();
	}
	
	public String verifyBuildName()
	{
		fluentWait(appBulidName);
		String appBuild = driver.findElement(appBulidName).getText();
		return appBuild;
	}
	
	public String verifyBuildVersion()
	{
		fluentWait(appVersion);
		String buildVersion = driver.findElement(appVersion).getText();
		return buildVersion;
	}
	
	public boolean verifyAppDetailsTitle()
	{
		boolean appDetailsTitle = false;
		try
		{
			
			fluentWait(appDetails);
			appDetailsTitle = driver.findElement(appDetails).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return appDetailsTitle;
	
	}
	
	public void clickSupportOption()
	{
		fluentWait(supportOption);
		driver.findElement(supportOption).click();
	}
	
	public boolean verifySupportTitle()
	{
		boolean supportPgTitle = false;
		try
		{
			
			fluentWait(supportTitle);
			supportPgTitle = driver.findElement(supportTitle).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return supportPgTitle;
	
	}
	
	public String verifyAgencySupportTxt()
	{
		fluentWait(supportAgencyTxt);
		String agencySupport = driver.findElement(supportAgencyTxt).getText();
		return agencySupport;
	}
	
	public boolean verifySupportEmail()
	{
		boolean supportEmailTxt = false;
		try
		{
			
			fluentWait(supportEmail);
			supportEmailTxt = driver.findElement(supportEmail).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return supportEmailTxt;
	
	}
	
	public void clickSupportBackBtn()
	{
		driver.findElement(supportBackBtn).click();
	}
	
	public boolean verifyAboutTitle()
	{
		boolean aboutTitlePg = false;
		try
		{
			
			fluentWait(aboutTitle);
			aboutTitlePg = driver.findElement(aboutTitle).isDisplayed();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return aboutTitlePg;
		
	}
	
	
}

