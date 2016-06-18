package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulLicDetailsUpdatePage extends DriverPage{

	public SuccessfulLicDetailsUpdatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//*[@contentDesc="Your contact details have been updated successfully."]
	//*[@contentDesc="CONTINUE"]
	
	
	
	////*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/imgLeft"] = back button
	
	public String verifyUpdateLicSucessPage()
	{
		By successMsg = By.xpath("//*[@contentDesc='SUCCESSFUL']");   
		String successfullyUpdatedLic = driver.findElement(successMsg).getText();
		return successfullyUpdatedLic;
	}
	
	//Click BackButton
		By backBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
		
		public void BackBtnSuccessUpdateLicDetail()
		{
			driver.findElement(backBtn).click();
		}
		
		public ManageYourLicPage clickBackBtnSucessLicDetail()
		{		
			BackBtnSuccessUpdateLicDetail();
			return new ManageYourLicPage(driver);
		}
	
}
