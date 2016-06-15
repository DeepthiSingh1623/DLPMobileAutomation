package gov.snsw.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.pageobjects.DriverPage;

public class SignInNSWAcctPage extends DriverPage {

	public SignInNSWAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Sign In Page,Intro Message
	By signInPg = By.xpath("[text()='Sign in with your  MyService NSW account']");
	
	//Email Address in sign in page
	By emailAddress = By.xpath("//*[@resourceid='"+resourceid+":id/etxtUsername']");
	
	//Password on Signin page	
	By password = By.xpath("//*[@resourceid='"+resourceid+":id/etxtPassword']");
	
		
	//SignIn button	
	By signInBtn = By.xpath("//*[@resourceid='"+resourceid+":id/btnLogin']");
	
	public EnterPINPage signInNswAcct(String email, String pwd )
	{
		fluentWait(emailAddress);
		driver.findElement(emailAddress).click();
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(password).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		return new EnterPINPage(driver);
		
	}


	
	
	

}
