package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RenewLicencePage extends DriverPage {

	public RenewLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By renewLicNextBtn = By.xpath("//*[@label='Next']");

}