package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.holder.pageobjects.DriverPage;

public class NotifyIntroPage extends DriverPage{


	//Introduction with Add Page
	public NotifyIntroPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[text()='Notify']")
	private WebElement notifyIntroPg;
	
	//Start Button
	@FindBy(xpath="//*[text()='Start']")
	private WebElement notifyIntroStartBtn;
	
	public void pressNotifyStartBtn()
	{
		notifyIntroStartBtn.click();
	}
	
	public TermsAndConditionsPage notifyStartBtn()
	{
		pressNotifyStartBtn();
		return new TermsAndConditionsPage(driver);
	}
	
}

