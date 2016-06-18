package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageYourLicPage extends DriverPage{

	public ManageYourLicPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//View Lic Histroy
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/txtManageLicenceHistory"]
	
	//Update your Details
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/txtManageUpdateDetails"]
	
	//Renew your Licence
	By renewLic = By.xpath("//*[@resourceid='"+holder_resourceid+":id/txtManageRenewLicence']");
	
	//Share Details
	//*[text()="Share Details"]
	
	//Date of Birth
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/txtShareDateOfBirth"]
	
	//DOB Flag
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/chkboxShareDateOfBirth"]
	
	//Address
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/txtShareAddress"]
	
	//Address Flag
	//*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/chkboxShareAddress"]
	
	//Manage your Licence Back Button
	By mngLicBackBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
	
	public void renewLic()
	{
		driver.findElement(renewLic).click();
	}
	
	public RenewLicencePage clickRenewLic()
	{	
		fluentWait(renewLic);
		renewLic();
		return new RenewLicencePage(driver);
	}
	
	public void backBtn()
	{
		driver.findElement(mngLicBackBtn).click();
	}
	
	public DetailLicencePage clickbackBtn()
	{	
		fluentWait(mngLicBackBtn);
		backBtn();
		return new DetailLicencePage(driver);
	}
	
	
}
