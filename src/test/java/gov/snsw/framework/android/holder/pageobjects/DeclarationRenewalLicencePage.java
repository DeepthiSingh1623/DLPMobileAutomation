package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class DeclarationRenewalLicencePage extends DriverPage{

	public DeclarationRenewalLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	By agreeBtn = By.xpath("(//input[@id='DeclarationAgreeChecked'])[1]");

	By nextBtn = By.xpath("//*[@resourceid='NextStep']");

	
	public void nextBtn()
	{
		driver.findElement(nextBtn).click();
	}
	
	public void agreeFlag()
	{
		driver.findElement(agreeBtn).click();
	}
	
	public PaymentLicenceRenewalPage clickNextBtnDeclarationPage()
	{
		fluentWait(agreeBtn);
		agreeFlag();
		fluentWait(nextBtn);
		nextBtn();
		return new PaymentLicenceRenewalPage(driver);
		
	}
	
	public boolean verifyDeclarationPgExist()
	{
		By declarationPg = By.xpath("//*[text()='I Agree']");
		fluentWait(declarationPg);
		return driver.findElement(declarationPg).isDisplayed();
	}
}
