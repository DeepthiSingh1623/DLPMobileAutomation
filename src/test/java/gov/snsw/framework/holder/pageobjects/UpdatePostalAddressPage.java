package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdatePostalAddressPage extends DriverPage{

	public UpdatePostalAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By PostalAdd = By.xpath("//*[@resourceid='applicantPostalAddress_AddressSearchIntuitive']");
	
	By addressList = By.xpath("//*[@resourceid='ui-id-1']");
	
	public void addresslist()
	{
		String firstSelect = driver.findElement(addressList).getText();
		firstSelect.indexOf(0);
		driver.findElement(addressList).click();
	}
	
	public void PostalAdd(String postal_Address)
	{
		driver.findElement(PostalAdd).clear();
		fluentWait(PostalAdd);
		driver.findElement(PostalAdd).sendKeys(postal_Address);
		addresslist();
	}
	
	By doneBtn = By.xpath("//*[@resourceid='DoneStep']");
	
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}
	
	public UpdateLicenceDetailsPage enterNewPostalAddress(String postal_Address)
	{
		fluentWait(PostalAdd);
		PostalAdd(postal_Address);
		addresslist();
		fluentWait(doneBtn);
		doneBtn();		
		return new UpdateLicenceDetailsPage(driver);
	}

}
