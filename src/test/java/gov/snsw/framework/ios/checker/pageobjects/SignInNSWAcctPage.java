package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SignInNSWAcctPage extends DriverPage{

	public SignInNSWAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By userName = By.xpath("//*[@value='Enter Email']");
	
	By pwd = By.xpath("//*[@value='Enter Password']");
	
	By signIn = By.xpath("//*[@label='SIGN IN']");
	
	public void enterEmail(String Username)
	{
		driver.findElement(userName).click();
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(Username);
	}
	
	public void enterPwd(String Password)
	{
		driver.findElement(pwd).click();
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(Password);
		
	}
	
	public void signInBtn()
	{
		driver.findElement(signIn).click();
	}
	
	public EnterPINPage pressSignIn(String Username, String Password)
	{
		fluentWait(userName);
		enterEmail(Username);
		enterPwd(Password);
		fluentWait(signIn);
		signInBtn();
		return new EnterPINPage(driver);
		
	}

}
