package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.utils.DriverPage;

public class ViewIntroPage extends DriverPage{


	//Introduction with Add Page
	public ViewIntroPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[text()='View']")
	private WebElement notifyIntroPg;
	
	//Start Button
	@FindBy(xpath="//*[text()='Start']")
	private WebElement notifyIntroStartBtn;
	
	public void pressViewStartBtn()
	{
		notifyIntroStartBtn.click();
	}
	
	public TermsAndConditionsPage notifyStartBtn()
	{
		pressViewStartBtn();
		return new TermsAndConditionsPage(driver);
	}
	
}





