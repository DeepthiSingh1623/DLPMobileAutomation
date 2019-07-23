package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SignInNSWAcctPage extends DriverPage {

	public SignInNSWAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Email Address in sign in page
	By emailAdd = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/etxtUsername']");
	//Password on Signin page
	By password = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/etxtPassword']");	
	//SignIn button
	By signInBtn = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/btnLogin']");
	
	
	public EnterPINPage signInNswAcct(String email, String pwd )
	{
		fluentWait(emailAdd);
		driver.findElement(emailAdd).click();
		driver.findElement(emailAdd).sendKeys(email);
		driver.findElement(password).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		return new EnterPINPage(driver);
		
	}


	
	
	

}
