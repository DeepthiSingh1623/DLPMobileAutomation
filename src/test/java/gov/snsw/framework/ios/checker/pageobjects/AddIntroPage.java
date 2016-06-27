package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;
import gov.snsw.framework.ios.checker.pageobjects.TermsAndCondPage;

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
	
	public String verifyAddPageTitle()
	{	
	By AddPage = By.xpath("//*[@label='Add']");
	String AddTitle = driver.findElement(AddPage).getText();
	return AddTitle;
	}
	
	public boolean isStartBtnExist()
	{
		boolean startBtnExist = false;
		try{
			startBtnExist= driver.findElement(startBtn).isDisplayed();
			
		}
		catch(NoSuchElementException e)
		{
			startBtnExist = false;
		}
		return startBtnExist;
	}

}
