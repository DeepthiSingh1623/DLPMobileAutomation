package gov.snsw.framework.android.checker.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

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
			driver.findElement(agreeBtn).click();
			return new SignInNSWAcctPage(driver);
		}

		By agreeBtn = By.xpath("//*[text()='Agree']");

		public boolean isAgreeBtnExist() {
			// TODO Auto-generated method stub
			boolean agreeBtnExist = false;
			try{
				fluentWait(agreeBtn);
				agreeBtnExist= driver.findElement(agreeBtn).isDisplayed();
				
			}
			catch(Exception e)
			{
				agreeBtnExist = false;
			}
			return agreeBtnExist;
		}	
			
	
	

}
