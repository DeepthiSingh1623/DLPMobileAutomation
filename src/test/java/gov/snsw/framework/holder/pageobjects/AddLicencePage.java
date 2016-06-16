package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLicencePage extends DriverPage{

	public AddLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By addFishingLic = By.xpath("//*[text()='Recreational Fishing Fee']");
	
	 //*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/toolbarTitle"]
			
			
	
	public AddLicencePage clickAddLicense()
	{	
		fluentWait(addFishingLic);
		driver.findElement(addFishingLic).click();
		return new AddLicencePage(driver);
	
	}	
	
	public void addLicPgExistVerify()
	{
		By addLicPg = By.xpath("//*[@resourceid='"+holder_resourceid+":id/toolbarTitle']");
		String addLicPgExist = driver.findElement(addLicPg).getText();
		
	}
}