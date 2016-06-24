package gov.snsw.framework.android.holder.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;


public class DetailLicencePage extends DriverPage{

	public DetailLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Capture the License Name  
	
	
	//Capture License Status
	By licStatus = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/licenceCurrent']");		
	
	//License Details
	By licDetails = By.xpath("//*[resourceid ='"+holder_android_resourceid+":id/detail']");
	
	
	
	//Click Back Icon	
	By backIcon = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
	
	//Capture License Number
	By licNum = By.xpath("//*[text()='Licence Number']/../text[2]");
	
	By licStartDate = By.xpath("//*[text()='Start Date']/../text[2]");
	
	By licExpiryDate = By.xpath("//*[text()='Expiry Date']/../text[2]");
	
	By licClasses = By.xpath("//*[text()='Classes/Conditions']/../text[2]");
	
	By manageLic = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/menu_licence_manage']");
	
	//Share Button
	By shareLic = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/btnFloatingActionButton']");
	
	/*public String getLicDetails()
	{			
		 List<WebElement> licenseDetails = driver.findElements(licDetails);
		 String data = null;
		 for(int i=0;i<licenseDetails.size();i++)
		 {		
			  
			  data = data + licenseDetails.get(i).getText();
			 
		 }
		return data;
		  
	}*/
	
	public String getLicNum()
	{
		return driver.findElement(licNum).getText();
	}
	
	public String getLicStartDate()
	{
		return driver.findElement(licStartDate).getText();
	}
	
	public String getLicExpireDate()
	{
		return driver.findElement(licExpiryDate).getText();	
	}
	
	public String getLicClass()
	{
		return driver.findElement(licClasses).getText();
	}
	
	
	public MyLicencePage pressBackBtn()
	{
		driver.findElement(backIcon).click();
		return new MyLicencePage(driver);
	}
	
	public void manageLicenceBtn()
	{
		driver.findElement(manageLic).click();
	}
	
	public ManageYourLicPage clickManageLicenceBtn()
	{
		fluentWait(manageLic);
		manageLicenceBtn();
		return new ManageYourLicPage(driver);
	}
	
	public void shareLicenceBtn()
	{
		driver.findElement(shareLic).click();
	}
	
	public SharingLicencePage clickShareLicenceBtn()
	{
		fluentWait(shareLic);
		shareLicenceBtn();
		return new SharingLicencePage(driver);
	}
	
	public String verifylicDetailsPageTitle()
	{
		By licDetailsTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
		String detailedLicTitleBar = driver.findElement(licDetailsTitle).getText();
		return detailedLicTitleBar;
	}
	

}
