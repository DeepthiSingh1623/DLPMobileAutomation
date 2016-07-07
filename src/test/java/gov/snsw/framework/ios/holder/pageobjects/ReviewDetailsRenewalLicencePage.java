package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class ReviewDetailsRenewalLicencePage extends DriverPage{

	public ReviewDetailsRenewalLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By nextBtn = By.xpath("//*[@label='Next']");
	

	public DeclarationRenewalLicencePage nextButton()
	{
		fluentWait(nextBtn);
		driver.findElement(nextBtn).click();
		return new DeclarationRenewalLicencePage(driver);
	}
	
	
	
	

}
