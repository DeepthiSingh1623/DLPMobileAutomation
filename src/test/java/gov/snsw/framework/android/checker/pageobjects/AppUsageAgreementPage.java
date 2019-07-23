package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class AppUsageAgreementPage extends DriverPage {

	
	public AppUsageAgreementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Terms and Conditions Page Accept Button
	By tAndcAcceptBtn = By.xpath("//*[text()='Agree']");
	public SignInNSWAcctPage pressAcceptBtn()
	{
		driver.findElement(tAndcAcceptBtn).click();
		return new SignInNSWAcctPage(driver);
	}
}
