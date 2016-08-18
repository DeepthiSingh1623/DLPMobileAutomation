package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class DetailLicencePage extends DriverPage{

	public DetailLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Verify/Share Licence	
	By Licshare = By.xpath("//*[@label='SHOW CODE']");
	
	//Manage Button
	By LicManage = By.xpath("//*[@label='Manage']");
	
	//Back Button
	By LicBackBtn = By.xpath("//*[@label='Manage']/../button[1]");
		
	public String getLicName()
	{
		By licName = By.xpath("//*[@label='Name on Licence']/../text[2]");
		String LicenceName = driver.findElement(licName).getText();
		return LicenceName;
	}
	
	public String getLicNum()
	{
		By licNum = By.xpath("//*[@label='Licence No']/../text[2]");
		String LicenceNum = driver.findElement(licNum).getText();
		return LicenceNum;
	}
	
	public String getLicStartDate()
	{
		By licStartDate = By.xpath("//*[@label='Start Date']/../text[2]");
		String LicenceStartDate = driver.findElement(licStartDate).getText();
		return LicenceStartDate;
	}
	
	public boolean getLicExpireDate(String date)
	{
		By licExpireDate = By.xpath("//*[@label='Expiry: "+date+"']");
		boolean expiryDateDisplay = false;
		try{
			fluentWait(licExpireDate);
			expiryDateDisplay = driver.findElement(licExpireDate).isDisplayed();
		}
		
		catch(Exception e){
			
		}
		return expiryDateDisplay;
	}	
	
	public void backBtn()
	{
		fluentWait(LicBackBtn);
		driver.findElement(LicBackBtn).click();
	}
	
	public MyLicencesPage clickBackBtn()
	{
		fluentWait(LicBackBtn);
		backBtn();
		return new MyLicencesPage(driver);
	}
	
	public void shareBtn()
	{
		driver.findElement(Licshare).click();
	}
	
	public ShareLicencePage clickVerifyBtn()
	{
		fluentWait(Licshare);
		shareBtn();
		return new ShareLicencePage(driver);
		
	}
	
	public void manageBtn()
	{
		driver.findElement(LicManage).click();
	}
	
	public ManageLicencePage clickManageBtn()
	{
		fluentWait(LicManage);
		manageBtn();
		return new ManageLicencePage(driver);
		
	}
	
	public String verifyDetailLicTitle()
	{
		By myDetailslicTitle = By.xpath("//*[@label='NSW Recreational Fishing Fee']");
		fluentWait(myDetailslicTitle);
		String myLicDetailPgTitle = driver.findElement(myDetailslicTitle).getText();
		return myLicDetailPgTitle;
	}
	
	

}
