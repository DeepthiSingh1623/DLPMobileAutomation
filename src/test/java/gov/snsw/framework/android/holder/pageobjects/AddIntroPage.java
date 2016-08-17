package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class AddIntroPage extends DriverPage {
	
	
		public AddIntroPage(WebDriver driver) 
		{
		super(driver);
		// TODO Auto-generated constructor stub
		}

		//Introduction with Add Page
		By addIntroMsg = By.xpath("//*[text()='Add']");	
		
		///Start Button		
		By addIntroStartBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/btnStart']");

		public TermsAndConditionsPage addStartBtn()
		{	
		fluentWait(addIntroStartBtn);
		driver.findElement(addIntroStartBtn).click();
		return new TermsAndConditionsPage(driver);
		}
		
		
		public boolean isStartBtnExist()
		{
			boolean startBtnExist = false;
			try{
				startBtnExist= driver.findElement(addIntroStartBtn).isDisplayed();
				
			}
			catch(NoSuchElementException e)
			{
				startBtnExist = false;
			}
			return startBtnExist;
		}
		
		public String verifyAddPg()
		{
			String addTitle = driver.findElement(addIntroMsg).getText();
			return addTitle;
		}
		
	
	

}
