package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateLicDetailsPage extends DriverPage{

	public UpdateLicDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Postal Address
	By editPostalAdd = By.xpath("//*[@class='UIAWebView']/link[3]/link[1]/text[1]");
							    
	
						
	//Save Changes Button
	By saveChangeBtn = By.xpath("//*[@label='Save Changes']");
		
	
	public void editPostalBtn()
	{
		driver.findElement(editPostalAdd).click();
	}
	
	public void  saveChangeBtn()
	{
		driver.findElement(saveChangeBtn).click();
	}
	
	public String verifyUpdateLicTitle()
	{
		//Title
		By updateLicTitle = By.xpath("//*[@label='UPDATE CONTACT DETAILS']");
		fluentWait(updateLicTitle);
		String PgTitle = driver.findElement(updateLicTitle).getText();
		return PgTitle;
	}
	public UpdatePostalAddressPage clickeditPostalBtn()
	{
		fluentWait(editPostalAdd);
		editPostalBtn();
		return new UpdatePostalAddressPage(driver);
	}
	
	public SuccessfullLicDetailsUpdatePage clickSaveBtn()
	{
		fluentWait(saveChangeBtn);
		saveChangeBtn();
		return new SuccessfullLicDetailsUpdatePage(driver);
	}
	
	public String verifyChangedAddress()
	{
		//Address Field
		By addressField = By.xpath("//*[@label='POSTAL ADDRESS']/../text[5]");
		String changedAddress = driver.findElement(addressField).getText();
		return changedAddress;
	}

	
}