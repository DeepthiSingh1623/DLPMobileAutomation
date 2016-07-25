package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class AppUsageAgreementPage extends DriverPage{

	public AppUsageAgreementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By agreeBtn = By.xpath("//*[@label='AGREE']");
	By agreeTxt = By.xpath("//*[@label='App usage agreement']");
	
	public void agreeButton()
	{
		driver.findElement(agreeBtn).click();
	}

	public SignInNSWAcctPage pressAgreeBtn()
	{
		fluentWait(agreeTxt);
		agreeButton();
		return new SignInNSWAcctPage(driver);
	}


}
