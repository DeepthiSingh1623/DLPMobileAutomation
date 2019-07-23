package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.utils.DriverPage;

public class SettingsPage extends DriverPage{

	public SettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By quickViewToggel = By.xpath("//*[@label='Quick View' and @class='UIASwitch']");
	
	By signout =By.xpath("//*[@label='Sign Out']");
	
	By signOutOKBtn = By.xpath("//*[@label='Yes']");
	
	By changePIN = By.xpath("//*[@label='Change PIN']");
	
	By supportOption = By.xpath("//*[@label='Support']");
	
	By autoLock = By.xpath("//*[@label='Auto Lock']");
	
	By settingsTitle = By.xpath("//*[@class='UIANavigationBar']//*[@label='Settings']");
	
	By immediately = By.xpath("//*[@name='Immediately' and @value='1']//*[@label=' ']");
	
	By fiveMinutes = By.xpath("//*[@name='After 5 minutes' and @class='UIATableCell']//*[@label=' ']");

	By aboutOption = By.xpath("//*[@label='About']");
	
	By aboutAppDetails = By.xpath("//*[@label='APP DETAILS']");
	
	
	//Activity icon
	By activityIcon = By.xpath("//*[@label='Activity']");
	
	
	
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
		By settingsPgTitile =By.xpath("//*[@label='Settings']");
		String settingsPageTitle = driver.findElement(settingsPgTitile).getText();
		return settingsPageTitle;
	}
	
	public AddIntroPage pressSigoutButton()
	{
		fluentWait(signout);
		signoutBtn();
		fluentWait(signOutOKBtn);
		signoutOKBtn();
		return new AddIntroPage(driver);
	}
	
	public void clickChangePin()
	{
		fluentWait(changePIN);
		driver.findElement(changePIN).click();
	}
	
	public void clickQuickView()
	{
		fluentWait(quickViewToggel);
		driver.findElement(quickViewToggel).click();
	}
	
	public String verifyquickViewEnabled()
	{
		fluentWait(quickViewToggel);
		String quickViewFlag = driver.findElement(quickViewToggel).getText();
		return quickViewFlag;
	}
	public void SupportOption()
	{
		
		driver.findElement(supportOption).click();
	}
	
	public SupportPage clickSupportOption()
	{
		fluentWait(supportOption);
		SupportOption();
		return new SupportPage(driver);
	}
	
	public void autoLockOption()
	{
		fluentWait(autoLock);		
		driver.findElement(autoLock).click();
	}
	
	
	
	public boolean verifySettingsTitle()
	{
		boolean autoLockTitlePg = false;
		try
		{
			
			fluentWait(settingsTitle);
			autoLockTitlePg = driver.findElement(settingsTitle).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return autoLockTitlePg;
		
	}
	
	public void clickSettingBackButton()
	{
		fluentWait(settingsTitle);
		driver.findElement(settingsTitle).click();
	}
	
	public boolean verifyAppDetailsTitle()
	{
		boolean appDetailsTitle = false;
		try
		{
			
			fluentWait(aboutAppDetails);
			appDetailsTitle = driver.findElement(aboutAppDetails).isDisplayed();
		}
		catch (Exception e)
		{
			
		}
		return appDetailsTitle;
		
	}
	
	public void clickImmediately()
	{
		fluentWait(immediately);		
		driver.findElement(immediately).click();
	}
	
	public void clickfiveMinutes()
	{
		fluentWait(fiveMinutes);		
		driver.findElement(fiveMinutes).click();
	}
	
	public void clickAboutOption()
	{
		fluentWait(aboutOption);		
		driver.findElement(aboutOption).click();
	}
	
	public String verifyAppName()
	{
		//app Name 
		//By appName = By.xpath("//*[@label='Name']/../text[2]");
		By appName = By.xpath("//device/view/window[1]/table[1]/cell[1]/text[2]");
		fluentWait(appName);
		String appNameTitle = driver.findElement(appName).getText();
		return appNameTitle;
	}
	
	public String verifyAppVersion()
	{
		//appVersion
		//By appVersion = By.xpath("//*[@label='Version']/../text[2]");
		By appversion = By.xpath("//device/view/window[1]/table[1]/cell[2]/text[2]");
		fluentWait(appversion);
		String appVersionTitle = driver.findElement(appversion).getText();
		return appVersionTitle;
	}
	

	public void ActivityOption()
	{
		driver.findElement(activityIcon).click();
	}
	
	public ActivityPage clickActivityOption()
	{
		ActivityOption();		
		return new ActivityPage(driver);
	}
	

	public void ClickTermsCondText()
	{

	
		By tcText = By.xpath("//*[@label='Terms And Conditions']");
		driver.findElement(tcText).click();
	}
	
}
