package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class LicenceDurationAndFeePage extends DriverPage {

	public LicenceDurationAndFeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By nextBtn = By.xpath("//*[@label='Next']");
	
	
	//1year Flag
	By oneYear = By.xpath("//*[@label='Next']/../text[7]");
	
	//3year flag
	By threeYear = By.xpath("//*[@label='Next']/../text[9]");
	
	public void nextBtn()
	{
		driver.findElement(nextBtn).click();
	}
	
	public void oneYear()
	{
		driver.findElement(oneYear).click();
	}
	public ReviewDetailsRenewalLicencePage nextButton()
	{
		fluentWait(oneYear);
		oneYear();
		fluentWait(nextBtn);
		nextBtn();
		return new ReviewDetailsRenewalLicencePage(driver);
	}

}
