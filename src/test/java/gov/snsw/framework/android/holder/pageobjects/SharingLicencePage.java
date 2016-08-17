package gov.snsw.framework.android.holder.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class SharingLicencePage extends DriverPage{

	public SharingLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By shareScanCode = By.xpath("//*[@class='android.widget.ImageView']");
	
	By shareBackBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
	
	By Confirm = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/alertTitle']");
	
	By noShare = By.xpath("//*[text()='No']");
	
	public String verifySharePageTitle()
	{
		By shareTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
		String shareTitleExist = driver.findElement(shareTitle).getText();
		return shareTitleExist;
	}
	
	public String verifyShareLicName()
	{
		By shareLicName = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/textLicence']");
		String shareLicenceName = driver.findElement(shareLicName).getText();
		return shareLicenceName;
	}
	
	public String verifyShareLicNum()
	{
		By shareLicNum = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/textLicenceNo']");
		String shareLicenceNum = driver.findElement(shareLicNum).getText();
		return shareLicenceNum;
	}
	
	public boolean verifyShareQRScan()
	{
		return driver.findElement(shareScanCode).isDisplayed();
		
	}
	
	public void backBtn()
	{
		 driver.findElement(shareBackBtn).click();
		
	}
	
	public String verifyConfirm()
	{
		fluentWait(Confirm);
		return driver.findElement(Confirm).getText();
	}
	
	public void clickNoShare()
	{
		fluentWait(noShare);
		driver.findElement(noShare).click();
	}
	

		
	
	

}

