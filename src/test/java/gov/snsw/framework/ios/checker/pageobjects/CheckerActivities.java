package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class CheckerActivities extends DriverPage {

	public CheckerActivities(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	public void clickActivityLog(String licenceNo) {
		// TODO Auto-generated method stub
		By log=By.xpath("//*[text()='"+licenceNo+"']");
		driver.findElement(log).click();
	}
}
