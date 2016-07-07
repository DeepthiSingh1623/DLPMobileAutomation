package gov.snsw.framework.ios.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class LicRenewPaymentPage extends DriverPage{

	public LicRenewPaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Credit Card Number
	By creditCardNum = By.xpath("//*[@class='UIAWebView']/textfield[1]");
	
	//CVV Number
	By cvvNumber = By.xpath("//*[@class='UIAWebView']/textfield[2]");

	//Card Name
	By HolderCardName = By.xpath("//*[@class='UIAWebView']/textfield[3]");
	
	//DoneButton
	By doneBtn = By.xpath("//device/view/window[1]/button[2]");
	
	//Month
	By month = By.xpath("//*[@value='Month']");
	
	//year
	By year = By.xpath("//*[@value='Year']");
	
	//Done button to remove keyboard
	By keyboardDoneBtn = By.xpath("//device/view/window[2]/toolbar[1]/image[1]/../button[3]");

	//DoneButton
		By doneBtn1 = By.xpath("//*[text()='Done']");
	
	//Submit
	By submitBtn = By.xpath("//*[@label='Submit']");
	
	//DatePicker
	By datePicker = By.xpath("//*[@class='UIAPickerWheel']");
	
	public void selectMonth(String cardExpiryMonth)
	{
		//driver.findElement(datePicker).click();
		driver.findElement(By.className("UIAPickerWheel")).sendKeys(cardExpiryMonth);
		//driver.findElement(datePicker).sendKeys(cardExpiryMonth);
		
	}
	
	public void selectYear(String cardExpiryYear)
	{
		driver.findElement(datePicker).click();
		driver.findElement(By.className("UIAPickerWheel")).sendKeys(cardExpiryYear);
		//driver.findElement(datePicker).sendKeys(cardExpiryYear);
		
	}
	
	public void creditCardNum(String cardNumber)
	{
		driver.findElement(creditCardNum).click();
		fluentWait(creditCardNum);
		driver.findElement(creditCardNum).sendKeys(cardNumber);
	}
	
	public void cvvNum(String cardCVVNum)
	{
		driver.findElement(cvvNumber).click();
		driver.findElement(cvvNumber).sendKeys(cardCVVNum);
	}
	
	public void month()
	{
		driver.findElement(month).click();
	}
	
	public void year()
	{
		driver.findElement(year).click();
	}
	
	public void cardName(String cardName)
	{
		driver.findElement(HolderCardName).click();
		driver.findElement(HolderCardName).sendKeys(cardName);
	}
	
	public void keyboardDone()
	{
		driver.findElement(keyboardDoneBtn).click();
	}
	
	public void enterPaymentDetails(String cardNumber,String cardCVVNum, String cardName,String cardExpiryMonth,String cardExpiryYear )
	{
		fluentWait(creditCardNum);
		creditCardNum(cardNumber);
		cvvNum(cardCVVNum);
		month();
		selectMonth(cardExpiryMonth);
		keyboardDone();
		year();
		selectYear(cardExpiryYear);
		keyboardDone();
		cardName(cardName);
		keyboardDone();		
		sumbitBtn();
	}
	
			
	public void clickDone()
	{
		driver.findElement(doneBtn).click();
	}
	
	public void sumbitBtn()
	{
		driver.findElement(submitBtn).click();
	}
	
	public void clickDoneOnSuccessPg()
	{
		fluentWait(doneBtn1);
		driver.findElement(doneBtn1).click();
	}
	
	
	
}
