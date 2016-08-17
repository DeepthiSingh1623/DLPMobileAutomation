package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class AddLicencePage extends DriverPage{

	public AddLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By addFishingLic = By.xpath("//*[text()='Recreational Fishing Fee']");
	
	 //*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/toolbarTitle"]
			
	By addLicPg = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");	
	
	public AddLicencePage clickAddLicense()
	{	
		fluentWait(addFishingLic);
		driver.findElement(addFishingLic).click();
		return new AddLicencePage(driver);
	
	}	
	
	public  String addLicPgExistVerify()
	{
		
		return driver.findElement(addLicPg).getText();
		
	}
}