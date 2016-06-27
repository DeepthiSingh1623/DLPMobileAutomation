package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageLicencePage extends DriverPage{

	public ManageLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//*[@label="View Licence history"]
	
	//*[@label="Renew your licence"]
	
	By renewLic = By.xpath("//*[@label='Renew your licence']");
	
	
	By updateLic = By.xpath("//*[@label='Update your details']");
	
	By okBtn = By.xpath("//*[@label='OK']");
	
	By cancelBtn = By.xpath("//*[@label='Cancel']");
	
	public void updaleLicBtn()
	{
		driver.findElement(updateLic).click();
	}
	public void okButton()
	{
		driver.findElement(okBtn).click();
	}
	public UpdateLicDetailsPage clickUpdateLicBtn()
	{
		updaleLicBtn();
		fluentWait(okBtn);
		okButton();
		return new UpdateLicDetailsPage(driver);
	}
	
	public boolean verifyUpdateYourDetailsPage()
	{
		return driver.findElement(updateLic).isDisplayed();
		
	}
	
	public void cancelButton()
	{
		driver.findElement(cancelBtn).click();
	}
	public DetailLicencePage clickCancelBtn()
	{
	
		fluentWait(cancelBtn);
		cancelButton();
		return new DetailLicencePage(driver);
	}
	
	public void renewLicBtn()
	{
		driver.findElement(renewLic).click();
	}
	
	public void clickRenewLic()
	{
		fluentWait(renewLic);
		renewLicBtn();
		fluentWait(okBtn);
		okButton();
		
	}
}