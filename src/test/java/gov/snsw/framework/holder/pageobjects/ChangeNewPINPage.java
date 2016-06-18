package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeNewPINPage extends DriverPage{

	public ChangeNewPINPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
		//Enter New  PIN
		By enterNewPin = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_entry']");		
		

		public ConfirmNewPINPage enter4DigitNewPin(String new_Pin)
		{
			fluentWait(enterNewPin);
			driver.findElement(enterNewPin).sendKeys(new_Pin);
			return new ConfirmNewPINPage(driver);
		}
			
		public String viewNewPINPgExist()
		{
			By enterNewPinMsgExist = By.xpath("//*[@resourceid='"+holder_resourceid+":id/pin_title']");
			String newPINMsgExist = driver.findElement(enterNewPinMsgExist).getText();
			return newPINMsgExist;
				 
		}
		
		
	
	
	

}
