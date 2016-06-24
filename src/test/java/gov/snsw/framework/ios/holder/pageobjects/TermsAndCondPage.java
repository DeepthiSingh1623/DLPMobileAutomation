package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndCondPage extends DriverPage{

	public TermsAndCondPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By agreeBtn = By.xpath("//*[@label='AGREE']");

	public void agreeButton()
	{
		driver.findElement(agreeBtn).click();
	}

	public SignInPage pressAgreeBtn()
	{
		fluentWait(agreeBtn);
		agreeButton();
		return new SignInPage(driver);
	}
	

	public String verifyTermsAndConditionsPageTitle()
	{	
	By tAndCPage = By.xpath("//*[@label='Terms & Conditions']");
	String tAndCTitle = driver.findElement(tAndCPage).getText();
	return tAndCTitle;
	}
}
