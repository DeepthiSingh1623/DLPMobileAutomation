package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class UpdatePostalAddressPage extends DriverPage{

	public UpdatePostalAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//By doneBtn = By.xpath("//*[@class='DOMUIAButton']");
	By doneBtn = By.xpath("//*[text()='International']/../button");
	//Address 
	
	
	By addEnterDone = By.xpath("//device/view/window[2]/toolbar[3]/button[3]");
	
	
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
		By pgTitle = By.xpath("//*[@label='Australia']");
		fluentWait(pgTitle);
		String LicPgTitle = driver.findElement(pgTitle).getText();
		return LicPgTitle;
	}
	
	By Address = By.xpath("//*[@class='UIAWebView']/textfield");
	By deletIcon = By.xpath("//*[@label='Delete']");
	public void addressField(String current_add)
	{
		
		fluentWait(Address);
		driver.findElement(Address).click();
		driver.findElement(Address).clear();
		driver.findElement(Address).clear();
		/*while(driver.findElement(Address).getText().length()>0){
			
			driver.findElement(Address).click();
			driver.findElement(deletIcon).click();
.			driver.findElement(deletIcon).click();
			driver.findElement(deletIcon).click();
			driver.findElement(deletIcon).click();
			driver.findElement(deletIcon).click();
			
			if(driver.findElement(Address).getText().equals(null)){
				break;
			}
		}*/
		
		driver.findElement(Address).sendKeys("95-103 Victoria Street, EAST GOSFORD NSW 2250");
	}
	
	
	
	
	
	
}
