package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class UpdateLicenceDetailsPage extends DriverPage{

	public UpdateLicenceDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//TitleBar - Update Licence //*[@resourceid="au.gov.nsw.onegov.app.holder.uat:id/toolbarTitle"]
	
	//Review and Update //*[@contentDesc="REVIEW AND UPDATE"]
	
	//Residential Address
	//*[@resourceid="licenceApplication"]/view[5]
	By editResAdd = By.xpath("//*[@resourceid='licenceApplication']/view[6]/view[1]");
	
	//Postal Address
	//*[@resourceid="licenceApplication"]/view[9]
	//*[@resourceid="licenceApplication"]/view[10]/view[1]
	By editPostalAdd = By.xpath("//*[@resourceid='licenceApplication']/view[6]/view[1]");
	
	//Mobile Number
	////*[@contentDesc="0412962427"]
	//*[@resourceid="licenceApplication"]/view[14]/view[1]
	By editMobileNum = By.xpath("//*[@resourceid='licenceApplication']view[14]/view[1]");
	
	//email Address
	//*[@contentDesc="Deepthi.Singh@avocadoconsulting.com.au"]
	//*[@resourceid="licenceApplication"]/view[18]/view[1]
	By editEmailAdd = By.xpath("//*[@resourceid='licenceApplication']view[18]/view[1]");
	
	//save changes button
	//*[@resourceid="SaveChangesStep"]
	By saveChanges = By.xpath("//*[@resourceid='SaveChangesStep']");
	
	//Back Button
	By backBtn = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
	
	public void backBtn()
	{
		driver.findElement(backBtn).click();
	}
	
	public ManageYourLicPage clickUpdateLicBackBtn()
	{
		fluentWait(backBtn);
		backBtn();
		return new ManageYourLicPage(driver);
	}
	
	public void editAddress()
	{
		driver.findElement(editResAdd).clear();
		driver.findElement(editResAdd).click();
	}
	
	public UpdateResidentialAddressPage clickEditResAddressBtn()
	{
		fluentWait(editResAdd);
		editAddress();
		return new UpdateResidentialAddressPage(driver);
	}
	
	public void editPostal()
	{
		driver.findElement(editPostalAdd).click();
	}
	
	public UpdatePostalAddressPage clickEditPostalAddressBtn()
	{
		fluentWait(editPostalAdd);
		editPostal();
		return new UpdatePostalAddressPage(driver);
	}
	
	public void editMobile()
	{
		driver.findElement(editMobileNum).click();
	}
	public UpdateMobilePage clickMobileBtn()
	{
		fluentWait(editMobileNum);
		editMobile();
		return new UpdateMobilePage(driver);
	}
	public void editEmail()
	{
		driver.findElement(editEmailAdd).click();
	}
	public UpdateEmailPage clickEmailBtn()
	{
		fluentWait(editEmailAdd);
		editEmail();
		return new UpdateEmailPage(driver);
	}
	
	public void editSaveChanges()
	{
		driver.findElement(saveChanges).click();
	}
	public SuccessfulLicDetailsUpdatePage clickUpdateLicDetailsSaveBtn()
	{
		fluentWait(saveChanges);
		editSaveChanges();
		return new SuccessfulLicDetailsUpdatePage(driver);
	}
	
	
	
	
	
}
