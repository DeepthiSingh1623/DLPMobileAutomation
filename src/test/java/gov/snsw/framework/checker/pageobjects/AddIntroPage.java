package gov.snsw.framework.checker.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.holder.pageobjects.DriverPage;

public class AddIntroPage extends DriverPage {
	
	
		public AddIntroPage(WebDriver driver) 
		{
		super(driver);
		// TODO Auto-generated constructor stub
			
		//initializing driver:
		this.driver = driver;
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		SwitchtoContext(driver,"NATIVE_APP");
		}
		
		//Page Objects

		private void SwitchtoContext(WebDriver driver, String string) {
			// TODO Auto-generated method stub
			
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
