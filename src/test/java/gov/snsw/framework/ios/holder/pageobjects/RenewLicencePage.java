package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class RenewLicencePage extends DriverPage {

	public RenewLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By renewLicNextBtn = By.xpath("//*[@label='Next']");
	
	
	//*[@label="29/06/2016"]
	public String expiryDate()
	{
		By expiryDate = By.xpath("//*[@label='Expiry Date']/../text[12]");
		String LicRenewalExpireDate = driver.findElement(expiryDate).getText();
		return LicRenewalExpireDate;
		
	}
	
	public LicenceDurationAndFeePage nextButton()
	{
		fluentWait(renewLicNextBtn);
		driver.findElement(renewLicNextBtn).click();
		return new LicenceDurationAndFeePage(driver);
	}

}
