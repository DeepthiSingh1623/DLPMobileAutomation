package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class QuickViewPage extends DriverPage{

	public QuickViewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By quickViewTitle = By.xpath("//*[text()='Quick View']");
	
	By unlock = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtUnlock']");
	
	By LicType = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceType']");
	
	
	public boolean verifyQuickViewTitle()
	{
		By quickViewTitle = By.xpath("//*[text()='Quick View']");
		fluentWait(quickViewTitle);
		return driver.findElement(quickViewTitle).isDisplayed();
	}
	
	public String verifyLicType()
	{
		By LicType = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceType']");
		fluentWait(LicType);
		String LicenceType = driver.findElement(LicType).getText();
		return LicenceType;
		
	}
	
	public EnterPINPage clickUnlock()
	{
		fluentWait(unlock);
		driver.findElement(unlock).click();
		return new EnterPINPage(driver);
	}
	
	
	
	
	
}
