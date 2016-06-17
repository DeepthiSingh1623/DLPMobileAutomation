package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmNewPINPage extends DriverPage{

	public ConfirmNewPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter Confirm New PIN
	By enterConfirmNewPin = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_entry']");
			
	
	//Confirm PIN
	public AppSettingPage enter4DigitConfirmNewPin(String new_Pin)
	{
		fluentWait(enterConfirmNewPin);
		driver.findElement(enterConfirmNewPin).sendKeys(new_Pin);
		return new AppSettingPage(driver);
	}
				
	public String viewConfirmNewPINPgExist()
	{
		By enterConfirmNewPinMsgExist = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_title']");
		String confirmNewPINMsgExist = driver.findElement(enterConfirmNewPinMsgExist).getText();
		return confirmNewPINMsgExist;
					 
	}
			
	

}
