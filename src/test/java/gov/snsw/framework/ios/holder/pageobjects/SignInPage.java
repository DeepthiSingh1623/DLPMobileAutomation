package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SignInPage extends DriverPage{

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By userName = By.xpath("//*[@value='Enter Email']");
	
	By pwd = By.xpath("//*[@value='Enter Password']");
	
	By signIn = By.xpath("//*[@label='SIGN IN']");
	
	By signInPgTitle = By.xpath("//*[@label='Sign in with your MyService NSW account']");
	
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
	
	public EnterPinPage pressSignIn(String Username, String Password)
	{
		fluentWait(userName);
		enterEmail(Username);
		enterPwd(Password);
		fluentWait(signIn);
		signInBtn();
		return new EnterPinPage(driver);
		
	}
	
	public String verifySignInTitle()
	{
		fluentWait(signInPgTitle);
		String signInPg = driver.findElement(signInPgTitle).getText();
		return signInPg;
	}

}
