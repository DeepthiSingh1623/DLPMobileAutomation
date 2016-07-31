package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class CheckerLogs extends DriverPage{

	public CheckerLogs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By fishingLog = By.xpath("(//*[text()='Recreational Fishing Fee'])[1]");
	
	public void selectLogDetails(){
		
		driver.findElement(fishingLog).click();
		
	}

}
