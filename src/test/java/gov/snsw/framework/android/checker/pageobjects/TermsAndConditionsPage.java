package gov.snsw.framework.android.checker.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.android.holder.pageobjects.DriverPage;

public class TermsAndConditionsPage extends DriverPage
{

	public TermsAndConditionsPage(WebDriver driver) 
	{
		super(driver);
				
		
	}
		//Terms and Conditions Page
		By termsAndconditionMsg = By.xpath("//*[text()='Terms & Conditions']");	
		
		//Terms and Conditions Page Accept Button
		By tAndcAcceptBtn = By.xpath("//*[text()='Accept']");
		
		//Terms and Conditions Page Decline Button
		By tAndcDeclineBtn = By.xpath("//*[text()='Decline']");
		
	
		
		public SignInNSWAcctPage termsAndConditionAcceptBtn()
		{
			driver.findElement(tAndcAcceptBtn).click();
			return new SignInNSWAcctPage(driver);
		}	
			
	
	

}
