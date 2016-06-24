package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdatePostalAddressPage extends DriverPage{

	public UpdatePostalAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By doneBtn = By.xpath("//*[@class='DOMUIAButton']");
	
	//Address 
	By Address = By.xpath("//*[@class='DOMUIAButton']/../textfield");
	
	By addEnterDone = By.xpath("//device/view/window[2]/toolbar[1]/button[3]");
	
	
	public void addressEnterDoneBtn()
	{
		driver.findElement(addEnterDone).click();
	}
	public void doneBtn()
	{
		driver.findElement(doneBtn).click();
	}
	
	public UpdateLicDetailsPage clickDoneBtn()
	{
		fluentWait(doneBtn);
		doneBtn();
		return new UpdateLicDetailsPage(driver);
	}
	
	public String verifyPostalAddressTitle()
	{
		//Title
		By pgTitle = By.xpath("//*[@label='UPDATE CONTACT DETAILS']");
		String LicPgTitle = driver.findElement(pgTitle).getText();
		return LicPgTitle;
	}
	
	public void addressField(String postal_add)
	{
		driver.findElement(Address).clear();
		driver.findElement(Address).sendKeys(postal_add);
	}
	
	public void getAddressList()
	{
		
	}
	
	
	
	
}
