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
	
	
	
	
}
