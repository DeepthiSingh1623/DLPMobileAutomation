package gov.snsw.framework.checker.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import gov.snsw.framework.holder.pageobjects.DriverPage;

public class AddIntroPage extends DriverPage {
	
		//au.gov.nsw.onegov.app.checker.uat
	
		public AddIntroPage(WebDriver driver) 
		{
		super(driver);
		// TODO Auto-generated constructor stub
			
		//initializing driver:
		//this.driver = driver;
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		}
		

		//Introduction with Add Page
		By addIntroMsg = By.xpath("//*[text()='Add']");	
		
		///Start Button
		By addIntroStartBtn = By.xpath("//*[text()='Start']");
	
		
		public TermsAndConditionsPage addStartBtn()
		{	
			driver.findElement(addIntroStartBtn).click();
			return new TermsAndConditionsPage(driver);
		}
	
	

}