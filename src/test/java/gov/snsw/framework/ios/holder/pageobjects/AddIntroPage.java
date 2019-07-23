package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;
import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;

public class AddIntroPage extends DriverPage{

	public AddIntroPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By startBtn = By.xpath("//*[@label='START']");
	
	public void IntrostartBtn()
	{
		driver.findElement(startBtn).click();
	}
			
	public TermsAndCondPage pressStartBtn()
	{
		fluentWait(startBtn);
		IntrostartBtn();
		return new TermsAndCondPage(driver);
	}
	
	public Boolean verifyAddPageTitle()
	{		
	By AddPage = By.xpath("//*[@label='Add']");
	fluentWait(AddPage);
	return driver.findElement(AddPage).isDisplayed();
	}
	
	public boolean isStartBtnExist()
	{
		boolean startBtnExist = false;
		try{
			fluentWait(startBtn);
			startBtnExist= driver.findElement(startBtn).isDisplayed();
			
		}
		catch(NoSuchElementException e)
		{
			startBtnExist = false;
		}
		return startBtnExist;
	}

}
