package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class UpdatePostalAddressPage extends DriverPage{

	public UpdatePostalAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By postalAdd = By.xpath("//*[@resourceid='applicantPostalAddress_AddressSearchIntuitive']");
	                       
	By addressList = By.xpath("//*[@resourceid='ui-id-1']");
	
	public void addresslist()
	{
		String firstSelect = driver.findElement(addressList).getText();
		firstSelect.indexOf(0);
		driver.findElement(addressList).click();
	}
	
	public void postalAdd(String postal_Address)
	{
		driver.findElement(postalAdd).clear();
		driver.findElement(postalAdd).clear();
		driver.findElement(postalAdd).sendKeys(postal_Address);
	}
	
	By doneBtn = By.xpath("//*[@resourceid='DoneStep']");
	
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}
	
	public void enterNewPostalAddress(String postal_Address)
	{
		fluentWait(postalAdd);
		postalAdd(postal_Address);
				
		
	}
	
	public UpdateLicenceDetailsPage pressDoneBtn()
	{
		fluentWait(doneBtn);
		doneBtn();
		return new UpdateLicenceDetailsPage(driver);
	}
	
	public boolean verifyPostalpdateLicTitle()
	{
		By postalAddUpdate = By.xpath("//*[@contentDesc='UPDATE POSTAL ADDRESS']");
		fluentWait(postalAddUpdate);
		return driver.findElement(postalAddUpdate).isDisplayed();
		
	}
	
	}
