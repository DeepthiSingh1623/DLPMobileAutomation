package gov.snsw.framework.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.pageobjects.DriverPage;

public class TermsAndConditionsPage extends DriverPage
{

	public TermsAndConditionsPage(WebDriver driver) 
	{
		super(driver);
				
		
	}
		//Terms and Conditions Page
		By termsAndconditionMsg = By.xpath("//*[text()='Terms & Conditions']");	
		
		//Terms and Conditions Page Accept Button		
		By tAndcAcceptBtn = By.xpath("//*[@resourceid=\"au.gov.nsw.onegov.app.holder.uat:id/btnAccept\"]");
		
		//Terms and Conditions Page Decline Button
		By tAndcDeclineBtn = By.xpath("//*[text()='Decline']");	
	
		
		public SignInNSWAcctPage termsAndConditionAcceptBtn()
		{
		driver.findElement(tAndcAcceptBtn).click();
		return new SignInNSWAcctPage(driver);
		}	
			
	
	

}
