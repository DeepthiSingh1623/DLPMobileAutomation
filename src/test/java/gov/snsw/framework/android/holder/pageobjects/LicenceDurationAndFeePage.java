package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class LicenceDurationAndFeePage extends DriverPage
{
	public LicenceDurationAndFeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By oneYearFlag = By.xpath("//*[@resourceid='RenewalDuration1']");
	By threeYearFlag = By.xpath("//*[@resourceid='RenewalDuration3']");
	//*[@contentDesc="DURATION & FEES"]
	
	By nextBtn = By.xpath("//*[@resourceid='NextStep']");
	
	public void durationFlag()
	{
		driver.findElement(oneYearFlag).click();
	}
	
	public void nextBtn()
	{
		driver.findElement(nextBtn).click();
	}
	
	public ReviewDetailsRenewalLicencePage selectDuration()
	{
		fluentWait(oneYearFlag);
		durationFlag();
		nextBtn();
		return new ReviewDetailsRenewalLicencePage(driver);
	}
	
	
}
