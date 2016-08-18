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
	
	By LicType1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceType'])[1]");
	
	By LicType2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceType'])[2]");
	
	
	
	
	public boolean verifyQuickViewTitle()
	{
		By quickViewTitle = By.xpath("//*[text()='Quick View']");
		fluentWait(quickViewTitle);
		return driver.findElement(quickViewTitle).isDisplayed();
	}
	
	public String LicType()
	{
		fluentWait(LicType1);
		String LicenceType = driver.findElement(LicType1).getText();
		return LicenceType;
		
	}
	
	public String LicTypeAlt()
	{
		fluentWait(LicType2);
		String LicenceType = driver.findElement(LicType2).getText();
		return LicenceType;
		
	}
	
	public EnterPINPage clickUnlock()
	{
		fluentWait(unlock);
		driver.findElement(unlock).click();
		return new EnterPINPage(driver);
	}
	
	public String getExpiryDate(String expDate)
	{
		By expDateQuickView = By.xpath("//*[text()='Expires "+expDate+"']");
		fluentWait(expDateQuickView);
		String expDateQV = driver.findElement(expDateQuickView).getText();
		return expDateQV;
	}
	
	public String getLicStatusIndex1()
	{
		By LicStatus1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceStatus'])[1]");
		String LicStatusIndex1 = driver.findElement(LicStatus1).getText();
		return LicStatusIndex1;
	}
	
	public String getLicStatusIndex2()
	{
		By LicStatus2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceStatus'])[2]");
		String LicStatusIndex2 = driver.findElement(LicStatus2).getText();
		return LicStatusIndex2;
	}
	
	public String getLicNumberIndex1()
	{
		By LicNumber1 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceNumber'])[1]");
		String LicNumberIndex1 = driver.findElement(LicNumber1).getText();
		return LicNumberIndex1;
	}
	
	public String getLicNumberIndex2()
	{
		By LicNumber2 = By.xpath("(//*[@resourceid='"+holder_android_resourceid+":id/txtLicenceNumber'])[2]");
		String LicNumberIndex2 = driver.findElement(LicNumber2).getText();
		return LicNumberIndex2;
	}
	
}
