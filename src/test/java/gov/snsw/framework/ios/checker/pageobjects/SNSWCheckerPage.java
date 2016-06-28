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
	
	By cancelBtn = By.xpath("//*[@label='Cancel']");
	
	By noBtn = By.xpath("//*[@label='No']");
							 
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
	
}
