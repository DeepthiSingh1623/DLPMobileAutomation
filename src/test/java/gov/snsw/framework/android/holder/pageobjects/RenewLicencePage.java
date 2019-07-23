package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class RenewLicencePage extends DriverPage{

	public RenewLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	By nextBtn = By.xpath("//*[@resourceid='NextStep']");
	
	public void nextBtn()
	{
		driver.findElement(nextBtn).click();
	}
	
	public LicenceDurationAndFeePage clickNextBtn()
	{
		fluentWait(nextBtn);
		nextBtn();
		return new LicenceDurationAndFeePage(driver);
	}
	
	public String VerifytitlePg()
	{
		By titlePg = By.xpath("//*[text()='Renew Licence']");
		fluentWait(titlePg);
		String pgTitle = driver.findElement(titlePg).getText();
		return pgTitle;
	}
	
	public String expiryDate()
	{
		By expiryDate = By.xpath("//*[@contentDesc='EXPIRY DATE']/../view[11]");
		String LicRenewalExpireDate = driver.findElement(expiryDate).getText();
		return LicRenewalExpireDate;
	}
	
	public boolean verifyLicenceNumberDisp()
	{
		By renPgLicNum = By.xpath("//*[@contentDesc='LICENCE NUMBER']");
		fluentWait(renPgLicNum);
		return driver.findElement(renPgLicNum).isDisplayed();
	}
}
