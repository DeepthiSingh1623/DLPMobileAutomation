package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SuccessfullLicDetailsUpdatePage extends DriverPage {

	public SuccessfullLicDetailsUpdatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	By doneBtn = By.xpath("//*[@label='Done']");
	
	public String verifySuccessMsg()
	{
		By successTitle = By.xpath("//*[@label='Your contact details have been updated successfully.']");
		fluentWait(successTitle);
		String successPgTitle = driver.findElement(successTitle).getText();
		return successPgTitle;
		
	}
	
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}

	public ManageLicencePage clickDoneBtn()
	{
		fluentWait(doneBtn);
		doneBtn();
		return new ManageLicencePage(driver);
	}
}


