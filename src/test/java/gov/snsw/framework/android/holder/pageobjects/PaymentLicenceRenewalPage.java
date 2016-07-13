package gov.snsw.framework.android.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;
import gov.snsw.framework.utils.Utilities;

public class PaymentLicenceRenewalPage extends DriverPage{

	public PaymentLicenceRenewalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//CreditNumber
	By creditCardNum = By.xpath("//*[@resourceid='payment_CreditCardDetails_CreditCardNumber']");
	
	//Credit Card Expiry Month
	
	
	//Credit Card Expiry Year
	
	//*[@resourceid="payment_CreditCardDetails_CreditCardExpiryYear"]
	// CVV Number
	By cvvNumber= By.xpath("//*[@resourceid='payment_CreditCardDetails_CVVNumber']");
	
	// Credit Card Holder Name
	By cardHolderName = By.xpath("//*[@resourceid='payment_CreditCardDetails_CreditCardHolder']");
	
	//Submit Button
	By submitBtn = By.xpath("//*[@resourceid='SubmitStep']");
	
	public void creditCardNum(String cardNum)
	{
		driver.findElement(creditCardNum).click();
		driver.findElement(creditCardNum).sendKeys(cardNum);
	}
	
	public void creditCardExpiryMonth(String cardExpiryMonth)
	{
		By expiryMonth = By.xpath("//*[@resourceid='payment_CreditCardDetails_CreditCardExpiryMonth']");
		driver.findElement(expiryMonth).click();
		By monthDate = By.xpath("//*[text()='"+cardExpiryMonth+"']");
		driver.findElement(monthDate).click();
	}
	
	public void creditCardExpiryYear(String cardExpiryYear)
	{
		By expiryYear = By.xpath("	//*[@resourceid='payment_CreditCardDetails_CreditCardExpiryYear']");
		driver.findElement(expiryYear).click();
		By yearDate = By.xpath("//*[text()='"+cardExpiryYear+"']");
		driver.findElement(yearDate).click();
	}
	
	public void creditCardCVVNum(String cardCVVNum)
	{
		driver.findElement(cvvNumber).click();
		driver.findElement(cvvNumber).sendKeys(cardCVVNum);
	}
	
	public void creditCardHolderName(String cardName)
	{
		driver.findElement(cardHolderName).click();
		driver.findElement(cardHolderName).sendKeys(cardName);
	}
	
	public void submitBtn()
	{
		 driver.findElement(submitBtn).click();
	}
	
	public boolean verifyPaymentPgExist()
	{
		By paymentPg = By.xpath("//*[@contentDesc='PAYMENT']");
		fluentWait(paymentPg);
		return driver.findElement(paymentPg).isDisplayed();
	}
	
	public boolean verifySuccessMessage()
	{
		By successPg = By.xpath("//*[@contentDesc='SUCCESSFUL']");
		fluentWait(successPg);
		return driver.findElement(successPg).isDisplayed();
	}
	
	
	
}
