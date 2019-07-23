package gov.snsw.framework.ios.holder.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class TermsAndCondPage extends DriverPage{

	public TermsAndCondPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By agreeBtn = By.xpath("//*[@label='AGREE']");	
	By settings = By.xpath("//*[@label='Settings']");
    public By emailLink = By.xpath("//*[@class='UIAWebView']/link[2]");
    public By custLink = By.xpath("//*[@class='UIAWebView']/link[3]");
    public By teleLink = By.xpath("//*[@label='13 77 88' and @class='DOMUIALink']");
    public By ovTeleLink = By.xpath("//*[@label='+61 2 8894 1555' and @class='DOMUIALink']");
	

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
	
	public void clickSettings()
	{
		fluentWait(settings);
		driver.findElement(settings).click();
	}
		
	public String emailLinkText(By emailLink, String url)
	{
		String actualText = driver.findElement(emailLink).getAttribute(url);
		return actualText;
	}

	public String CustLinkText(By custLink, String url)
	{
		String actualText = driver.findElement(custLink).getAttribute(url);
		return actualText;
	}

	public String TeleLinkText(By teleLink, String url)
	{
		String actualText = driver.findElement(teleLink).getAttribute(url);
		return actualText;
	}
	
	public String ovTeleLinkText(By ovTeleLink, String url)
	{
		String actualText = driver.findElement(ovTeleLink).getAttribute(url);
		return actualText;
	}
	
}
