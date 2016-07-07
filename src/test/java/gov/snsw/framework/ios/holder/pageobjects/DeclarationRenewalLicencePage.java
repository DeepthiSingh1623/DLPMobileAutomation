package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class DeclarationRenewalLicencePage extends DriverPage{

	public DeclarationRenewalLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By declarationNextBtn = By.xpath("//*[@label='Next']");
	
	//I agree Flag
	//*[@label="I Agree"]/../text[5]
	//*[@label=""]
	
	
	By agreeFlag = By.xpath("//*[@label='']");
	
	public void agreeBtn()
	{
		driver.findElement(agreeFlag).click();
	}
	
	public void nextButton()
	{
		driver.findElement(declarationNextBtn).click();
	}
	
	public LicRenewPaymentPage pressNextButton()
	{
		fluentWait(declarationNextBtn);
		agreeBtn();
		nextButton();
		return new LicRenewPaymentPage(driver);
	}

}
