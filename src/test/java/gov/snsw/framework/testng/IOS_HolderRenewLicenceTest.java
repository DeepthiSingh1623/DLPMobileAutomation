package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

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
import com.perfectomobile.utils.PerfectoUtils;

import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.ios.holder.pageobjects.DeclarationRenewalLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.EnterPinPage;
import gov.snsw.framework.ios.holder.pageobjects.LicRenewPaymentPage;
import gov.snsw.framework.ios.holder.pageobjects.LicenceDurationAndFeePage;
import gov.snsw.framework.ios.holder.pageobjects.ManageLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.MyLicencesPage;
import gov.snsw.framework.ios.holder.pageobjects.RenewLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.ReviewDetailsRenewalLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.SettingsPage;
import gov.snsw.framework.ios.holder.pageobjects.SignInPage;

import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;


import gov.snsw.framework.utils.Utilities;

public class IOS_HolderRenewLicenceTest extends BasicTest
{
	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String postal_Address,String lic_OwnerName,String cardNumber,String cardExpiryMonth, String cardExpiryYear,String cardCVVNum,String cardName) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		
		String appName = (String) caps.getCapability("bundleId");	
	 	try{
	 			//reportPass("success", "param");
	 			
	 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Enter PIN
		 		EnterPinPage enterPIN = null;
		 		
		 		if(AddInPg.isStartBtnExist())
		 		{		 			
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndCondPage tcPg = AddInPg.pressStartBtn();
		 		
		 		//Click Accept Button on the Terms and Condition Page
		 		SignInPage signIn = tcPg.pressAgreeBtn();
		 		
		 		//Enter the login details in the Sign In Page
		 		enterPIN = signIn.pressSignIn(username,password);
		 		
		 		assertTrue(enterPIN.verifyPinEnterTitle().contains("You are required to set up a PIN.  You can change this in your App Settings."));
		 		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enterPin();
		 		
		 		//Enter 4 digit PIN confirmation
		 		enterPIN.enterPin();
		 		}
		 		else
		 		{
		 			enterPIN = new EnterPinPage(driver);
		 			
		 			//Enter 4 digit PIN
		 			enterPIN.enterPINUnlock();
		 		}
		 				 		
		 		MyLicencesPage LicPg = new MyLicencesPage(driver);
		 		
		 		if(LicPg.isTextPresentOnScreen("Notifications have been disabled"))
		 		{
		 			LicPg.selectNo();
		 		} 
		 		
		 		//Verify My Licence Page is displayed
		 		//assertEquals(licence_Name,LicPg.myLicPgTitle());
		 		//assertTrue(LicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));
		 		
		 		//Click Licence Number
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		//verify the Detailed Lic Page 
		 		//assertTrue(detailLicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));
		 		//assertEquals("Recreational Fishing Fee",licence_Name);
		 		
		 		//Click Manage Button
		 		ManageLicencePage manageLicPg = detailLicPg.clickManageBtn();
		 		
		 		//click Update your details
		 		RenewLicencePage renewLicPg  = manageLicPg.clickRenewLic();
		 		
		 		
		 		//verify lic number
		 		//assertTrue(renewLicPg.isTextPresentOnScreen(licence_Number));
		 		
		 		//Verify Lic Name
		 		//assertTrue(renewLicPg.isTextPresentOnScreen(lic_OwnerName));
		 		
		 		//verify LicenceType
		 		//assertTrue(renewLicPg.isTextPresentOnScreen(licence_Name));
		 		
		 		//Verify Expiry Date	 	 		
		 		//assertEquals(Utilities.dateFormatChange(licence_ExpireDate),renewLicPg.expiryDate());
		 		
		 	    //Click Next Button on the Licensee Details 
		 		LicenceDurationAndFeePage durationFeePg = renewLicPg.nextButton();
		 		
		 		//Click 1year or 3years and Next Button
		 		ReviewDetailsRenewalLicencePage reviewLicPg = durationFeePg.nextButton();
		 		
		 		//Click Next Button
		 		DeclarationRenewalLicencePage declarionPg = reviewLicPg.nextButton();
		 		
		 		//Click Agree and Next
		 		LicRenewPaymentPage LicRenewPg = declarionPg.pressNextButton();
		 		
		 		//Enter Payment Details
		 		LicRenewPg.enterPaymentDetails(cardNumber, cardCVVNum, cardName, cardExpiryMonth, cardExpiryYear);
		 		
		 		//verify Successful message
		 		//assertTrue(LicRenewPg.isTextPresentOnScreen("SUCCESSFUL"));
		 		
		 		LicRenewPg.clickDoneOnSuccessPg();
		 		
		 		//Click Cancel Button on the Manage Page
		 		detailLicPg = manageLicPg.clickCancelBtn();
		 		
		 		//Click Back Button on the Detailed Lic Page
		 		LicPg = detailLicPg.clickBackBtn();
		 		
		 		//Verify My Licence Page is displayed
		 		//assertEquals(licence_Name,LicPg.myLicPgTitle());
		 		assertTrue(LicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));		 		
		 	
		 		//Click on the Settings and then sign out
		 		SettingsPage settingPg = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		settingPg.verifySettingsPageTitile();
		 		
		 		
		 		//Click SignOut
		 		AddInPg = settingPg.pressSigoutButton();
		 		
		 		//Verify Add Intro Page is displayed
		 		assertEquals("Add",AddInPg.verifyAddPageTitle());
		 		
		 	}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{
	 		
	 		//clean app
	 		Utilities.cleanApp(driver, appName);
	 			 		
 			//close app
	 		Utilities.closeApp(driver, appName);
	 		
 			try {
	                
	                // In case you want to download the report or the report attachments, do it here.
	                PerfectoUtils.downloadReport(driver, "pdf", "C:\\test\\Report");
	            } 
 				catch (Exception e) 
 				{
	            e.printStackTrace();
	            }
	 		
	 		//close App
	 		driver.close();
	 		
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
	public IOS_HolderRenewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}

}
