package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QRCodePage extends DriverPage{

	public QRCodePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String verifyQRCodePageTitle()
	{
		By qrScanPgTitle = By.xpath("//*[@resourceid='"+holder_resourceid+":id/toolbarTitle']");
		String qrScanPg = driver.findElement(qrScanPgTitle).getText();
		return qrScanPg;
	}

}
