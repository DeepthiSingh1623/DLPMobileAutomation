package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateResidentialAddressPage extends DriverPage{

	public UpdateResidentialAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By resAdd = By.xpath("//*[@resourceid='applicantResidentialAddress_AddressSearchIntuitive']");
	
	public void resAdd(String Res_Address)
	{
		driver.findElement(resAdd).clear();
		driver.findElement(resAdd).sendKeys(Res_Address);
	}
	
	By doneBtn = By.xpath("//*[@resourceid='DoneStep']");
	
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}
	
	public UpdateLicenceDetailsPage enterNewResidentialAddress(String Res_Address)
	{
		fluentWait(resAdd);
		resAdd(Res_Address);
		fluentWait(doneBtn);
		doneBtn();		
		return new UpdateLicenceDetailsPage(driver);
	}
	
	
					
	
	//*[@resourceid="applicantResidentialAddress_AddressSearchIntuitive"]
	
	//*[@contentDesc=""]
	
	//*[@resourceid="DoneStep"]
	
	//*[@resourceid="ui-id-155"]

}
