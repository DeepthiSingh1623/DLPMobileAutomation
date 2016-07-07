package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.android.holder.pageobjects.AppSettingPage;
import gov.snsw.framework.android.holder.pageobjects.DeclarationRenewalLicencePage;
import gov.snsw.framework.android.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.LicenceDurationAndFeePage;
import gov.snsw.framework.android.holder.pageobjects.ManageYourLicPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.PaymentLicenceRenewalPage;
import gov.snsw.framework.android.holder.pageobjects.RenewLicencePage;
import gov.snsw.framework.android.holder.pageobjects.ReviewDetailsRenewalLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;

public class Android_HolderRenewLicenceTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String postal_Address,String lic_OwnerName,String cardNumber,String cardExpiryMonth,String cardExpiryYear, String cardCVVNum, String cardName) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 			//reportPass("success", "param");
	 			 			
	 		switchToContext(driver, "NATIVE_APP");
	 		//Driver initialization	 		
	 		AddIntroPage AddInPg = new AddIntroPage(driver);
	 		
	 		//Enter PIN
	 		EnterPINPage enterPIN = null;
	 		
	 		if(AddInPg.isStartBtnExist())
	 		{		 			
	 		
	 		//Click on the Start button on introduction page
	 		TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
	 		
	 		//Click Accept Button on the Terms and Condition Page
	 		SignInNSWAcctPage signIn = tcPg.termsAndConditionAcceptBtn();
	 		
	 		//Enter the login details in the Sign In Page
	 		signIn.signInNswAcct(username,password);
	 		
	 		//Keyboard Remove
	 		Utilities.BackBtn(driver);
	 		
	 		//click Sign In Button
	 		enterPIN = signIn.clickSignInBtn();
	 		 		
	 		//Enter 4 digit PIN
	 		enterPIN.enter4DigitPin(pin);
	 		
	 		//Enter 4 digit PIN confirmation
	 		enterPIN.enter4DigitPin(pin);
	 		}
	 		
	 		else
	 		{
	 			enterPIN = new EnterPINPage(driver);
	 			
	 			//Enter 4 digit PIN
	 			enterPIN.enter4DigitPin(pin);
	 		}
	 		
	 		
	 		MyLicencePage LicPg = new MyLicencePage(driver);
	 		
	 		//Verify My License Page is displayed
	 		assertEquals("Licences",LicPg.verifyMyLicTitle());
	 		
	 		Map<String, Object> params6 = new HashMap<>();
	 		params6.put("start", "571,2126");
	 		params6.put("end", "504,0");
	 		params6.put("duration", "2");
	 		Object result6 = driver.executeScript("mobile:touch:swipe", params6);
	 		
	 		//Click the License to view the detailed License	 						
	 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);		 	
	 		
	 		//Click on the Manage License Button
	 		ManageYourLicPage mngLic = detailLicPg.clickManageLicenceBtn();
	 		
	 		//click on renew License
	 		RenewLicencePage renewLicPg = mngLic.clickRenewLic();
		 	
	 		//Verify the Renew License Screen is displayed
	 		assertTrue(renewLicPg.isTextPresentOnScreen("Renew Licence"));
	 			 		
	 		
	 		//verify Licence Details
	 		//verify lic number
	 		assertTrue(renewLicPg.isContentPresentOnScreen(licence_Number));
	 		
	 		//Verify Lic Name
	 		assertTrue(renewLicPg.isContentPresentOnScreen(lic_OwnerName));
	 		
	 		//verify LicenceType
	 		assertTrue(renewLicPg.isContentPresentOnScreen(licence_Name));
	 		
	 		//Verify Expiry Date	 	 		
	 		//assertEquals(Utilities.dateFormatChange(licence_ExpireDate),renewLicPg.expiryDate());
	 		
	 		//click Next Button
	 		LicenceDurationAndFeePage licDurationFee = renewLicPg.clickNextBtn();
	 		
	 		//click Next Button on the Fee Page
	 		ReviewDetailsRenewalLicencePage reviewDetails = licDurationFee.selectDuration();
	 		
	 		//Review Details Page
	 		DeclarationRenewalLicencePage dclare = reviewDetails.clickNext();
	 		
	 		//click agree and Next Button
	 		PaymentLicenceRenewalPage payPg = dclare.clickNextBtnDeclarationPage();
	 		
	 		//Enter Details in Payment Page 
	 		payPg.creditCardNum(cardNumber);	 		
	 		Utilities.BackBtn(driver);
	 		
	 		payPg.creditCardExpiryMonth(cardExpiryMonth);
	 		
	 		payPg.creditCardExpiryYear(cardExpiryYear);
	 		
	 		payPg.creditCardCVVNum(cardCVVNum);
	 		Utilities.BackBtn(driver);
	 		
	 		payPg.creditCardHolderName(cardName);
	 		Utilities.BackBtn(driver);
	 		
	 		Map<String, Object> params7 = new HashMap<>();
	 		params7.put("start", "816,2287");
	 		params7.put("end", "787,479");
	 		Object result7 = driver.executeScript("mobile:touch:swipe", params7);
	 		
	 		Utilities.BackBtn(driver);	
	 		//payPg.submitBtn();
	 		
	 		//click back button on the Manage your License page
	 		 mngLic.clickbackBtn();
	 		
	 		//click the back button on the detailed License screen
	 		Utilities.BackBtn(driver);	
	 		
	 		//Scroll to settings page
	 		Map<String, Object> params22 = new HashMap<>();
	 		params22.put("start", "566,700");
	 		params22.put("end", "552,1721");
	 		params22.put("duration", "2");
	 		Object result22 = driver.executeScript("mobile:touch:swipe", params22); 		
	 		 		 		
	 		// Click on the Settings and Sign out
		    LicPg.settings();
		    
		  //Verify Add Intro Page is displayed
		  assertTrue(AddInPg.isTextPresentOnScreen("Add"));
	 		
	 	  reportFail("expected", "actual","params");	
		 		
		  	 		
	 	}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	finally{
	 		
	 		//Clean App
	 		Utilities.cleanApp(driver, appName);
	 		
	 		
	 		//close app
	 		Utilities.closeApp(driver, appName);
	 		
	 	}
		
        if(testFail){
        	Assert.fail();
        }
	}


	@DataProvider (name = "logInData", parallel = false)
	public Object[][] searchItemsData(){
		 Object[][] s = null;
		try {
		  ExcelDriver ed = new ExcelDriver(sysProp.get("inputWorkbook"), sysProp.get("signInSheet"), false);
		  s = ed.getData(17);
		} catch(IOException e) {
			System.out.println("Not able to search data from excel: " + sysProp.get("inputWorkbook"));
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Factory(dataProvider="factoryData")
	public Android_HolderRenewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}	

}
