package gov.snsw.framework.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.pageobjects.DriverPage;

public class AddIntroPage extends DriverPage {
	
	
		public AddIntroPage(WebDriver driver) 
		{
		super(driver);
		// TODO Auto-generated constructor stub
		}

		//Introduction with Add Page
		By addIntroMsg = By.xpath("//*[text()='Add']");	
		
		///Start Button		
		By addIntroStartBtn = By.xpath("//*[@resourceid='au.gov.nsw.onegov.app.holder.uat:id/btnStart']");

		public TermsAndConditionsPage addStartBtn()
		{	
		fluentWait(addIntroStartBtn);
		driver.findElement(addIntroStartBtn).click();
		return new TermsAndConditionsPage(driver);
		}
	
	

}
