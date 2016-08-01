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
	By settings = By.xpath("//*[@label='Settings']");
	
	By activityBtn = By.xpath("//*[@class='UIATabBar']/button[3]");
	
	By manualSearch = By.xpath("//*[@class='UIATabBar']/button[2]");
	
	By cancelBtn = By.xpath("//*[@label='Cancel']");
	
	By noBtn = By.xpath("//*[@label='No']");
	
	By okBtn = By.xpath("//*[@label='Ok']");

	By pgTitle = By.xpath ("//*[@label='Licence Scan']");
	
	public String getPageTitle()
	{
		return driver.findElement(pgTitle).getText();
		
	}

	By licScanPg = By.xpath("//*[@label='Licence Scan']");
	
	public LicenceSearchPage clickManualSearch()
	{
		driver.findElement(manualSearch).click();
		return new LicenceSearchPage(driver);
	}
							 
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
	
	public CheckerActivities clickActivity()
	{
		fluentWait(activityBtn);
		driver.findElement(activityBtn).click();
		return new CheckerActivities(driver);
	}

	public boolean isDialogOpen(){
		
		boolean dialOpn= false;
		try{
			dialOpn = driver.findElement(cancelBtn).isDisplayed();
		}
		
		catch(Exception e){
			dialOpn = false;
		}
		
		return dialOpn;
		
	}
	
	public void  clickCancel(){
		
		driver.findElement(cancelBtn).click();
				
	}

	public boolean isPopupOpen() {
		// TODO Auto-generated method stub
		boolean dialOpn= false;
		try{
			dialOpn = driver.findElement(noBtn).isDisplayed();
		}
		
		catch(Exception e){
			dialOpn = false;
		}
		
		return dialOpn;
	}
	
	public void  clickNo(){
		
		driver.findElement(noBtn).click();
				
	}
	
	public void  clickOk(){
		
	
		driver.findElement(okBtn).click();
				
	}

	public boolean okNotifications() {
		// TODO Auto-generated method stub
		boolean dialOpn= false;
		try{
			dialOpn = driver.findElement(cancelBtn).isDisplayed();
		}
		
		catch(Exception e){
			dialOpn = false;
		}
		
		return dialOpn;
	}
	
	public String verifyLicScanTitle()
	{
		fluentWait(licScanPg);
		String licScanPgTitle = driver.findElement(licScanPg).getText();
		return licScanPgTitle;
	}
	
}
