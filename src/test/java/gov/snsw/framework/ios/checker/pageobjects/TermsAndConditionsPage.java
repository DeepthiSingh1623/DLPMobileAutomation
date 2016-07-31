package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class TermsAndConditionsPage extends DriverPage{

	public TermsAndConditionsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By agreeBtn = By.xpath("//*[@label='AGREE']");

	public void agreeButton()
	{
		driver.findElement(agreeBtn).click();
	}

	public AppUsageAgreementPage pressAgreeBtn()
	{
		fluentWait(agreeBtn);
		agreeButton();
		return new AppUsageAgreementPage(driver);
	}
	

	public String verifyTermsAndConditionsPageTitle()
	{	
	By tAndCPage = By.xpath("//*[@label='Terms & Conditions']");
	String tAndCTitle = driver.findElement(tAndCPage).getText();
	return tAndCTitle;
	}

	public boolean isAgreeBtnExist() {
		// TODO Auto-generated method stub
		boolean agreeBtnExist = false;
		try{
			//fluentWait(agreeBtn);
			agreeBtnExist= driver.findElement(agreeBtn).isDisplayed();
			
		}
		catch(NoSuchElementException e)
		{
			agreeBtnExist = false;
		}
		return agreeBtnExist;
	
	}
}
