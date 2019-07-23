package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class ReviewDetailsRenewalLicencePage extends DriverPage{

	public ReviewDetailsRenewalLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By nextBtn = By.xpath("//*[@resourceid='NextStep']");

	public void nextBtn()
	{
		driver.findElement(nextBtn).click();
	}
	
	public DeclarationRenewalLicencePage clickNext()
	{
		fluentWait(nextBtn);
		nextBtn();
		return new DeclarationRenewalLicencePage(driver);
	}
	
	public boolean verifyReviewDetailsPgExist()
	{
		By reviewDetailsPg = By.xpath("//*[text()='Please review and update your licence details as required.']");
		fluentWait(reviewDetailsPg);
		return driver.findElement(reviewDetailsPg).isDisplayed();
	}
	
}
