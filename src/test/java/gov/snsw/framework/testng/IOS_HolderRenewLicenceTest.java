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
	public void renewalLicenceIOS(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String postal_Address,String lic_OwnerName,String cardNumber,String cardExpiryMonth, String cardExpiryYear,String cardCVVNum,String cardName) throws Exception{
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
			 		 		
			 		//Verify Enter Pin is displayed
			 		assertTrue(enterPIN.verifyPinEnterTitle().contains("You are required to set up a PIN.  You can change this in your App Settings."));
			 		
			 		//Enter 4 digit PIN
			 		enterPIN.enterPin();
			 		
			 		//Verify Confirm PIN is displayed
			 		assertTrue(enterPIN.verifyPinConfirmTitle().contains("Confirm PIN"));
			 		
			 		//Enter 4 digit PIN confirmation
			 		enterPIN.enterPin();
			 		}
			 		
			 		else
			 		{
			 			enterPIN = new EnterPinPage(driver);
			 			
			 			//Verify Enter Pin is displayed
				 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Unlock with PIN"));
				 		
			 			//Enter 4 digit PIN
			 			enterPIN.enterPINUnlock();
			 		}
			 				 		
			 		
			 		MyLicencesPage LicPg = new MyLicencesPage(driver);
			 		
			 		if(LicPg.isTextPresentOnScreen("Notifications have been disabled"))
			 		{
			 			LicPg.selectNo();
			 		}
			 		
			 		
			 	//Verify My Licence Page is displayed
			 	assertTrue(LicPg.myLicPgTitle().contains(licence_Name));
		 		
			 	//Click Licence Number
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		//verify the Detailed Lic Page 
		 		assertTrue(detailLicPg.verifyDetailLicTitle().contains(licence_Name));

		 		//Click Manage Button
		 		ManageLicencePage manageLicPg = detailLicPg.clickManageBtn();
		 		
		 		//Verify Manage Page id displayed
		 		assertTrue(manageLicPg.verifyManagePgTitle().contains("Manage"));

		 		//click Update your details
		 		RenewLicencePage renewLicPg  = manageLicPg.clickRenewLic();
		 		
		 		//Verify the the Page is redirected to Renewal SNSW WebSite
		 		assertTrue(renewLicPg.verifyRenewalLicTitle().contains("LICENCE NUMBER"));
		 		
		 		//verify lic number
		 		assertTrue(renewLicPg.isTextPresentOnScreen(licence_Number));
		 		
		 		//Verify Lic Name
		 		assertTrue(renewLicPg.isTextPresentOnScreen(lic_OwnerName));
		 		
		 		//verify LicenceType
		 		assertTrue(renewLicPg.isTextPresentOnScreen("Recreational Fishing Fee"));
		 		
		 		//Verify Expiry Date	 	 		
		 		//assertEquals(Utilities.dateFormatChange(licence_ExpireDate),renewLicPg.expiryDate());
		 		
		 	    //Click Next Button on the Licensee Details 
		 		LicenceDurationAndFeePage durationFeePg = renewLicPg.nextButton();
		 		
		 		//Verify Duration and Fee Page is displayed
		 		assertTrue(renewLicPg.verifyRenewalDurationFeeLicTitle().contentEquals("Total Amount Due"));
		 		
		 		//Click 1year or 3years and Next Button
		 		ReviewDetailsRenewalLicencePage reviewLicPg = durationFeePg.nextButton();
		 		
		 		//Verify the Review Details Page is displayed
		 		assertTrue(renewLicPg.verifyRenewalReviewDetailsTitle().contains("LICENSEE"));
		 		
		 		//Click Next Button
		 		DeclarationRenewalLicencePage declarionPg = reviewLicPg.nextButton();
		 		
		 		//Verify the Declaration Page is displayed
		 		assertTrue(renewLicPg.verifyRenewalDeclartionTitle().contains("I Agree"));
		 		
		 		//Click Agree and Next
		 		LicRenewPaymentPage LicRenewPg = declarionPg.pressNextButton();
		 		
		 		//Verify the Payments Page is displayed
		 		assertTrue(renewLicPg.verifyPaymentTitle().contains("Total Due"));
		 		
		 		//Enter Payment Details
		 		LicRenewPg.enterPaymentDetails(cardNumber, cardCVVNum, cardName, cardExpiryMonth, cardExpiryYear);
		 		
		 		//verify Successful message
		 		assertTrue(LicRenewPg.verifySuccessMsg());
		 		
		 		//click Done Button on the Success Page		 		
		 		LicRenewPg.clickDoneOnSuccessPg();		 		
		 		
		 		//Click Cancel Button on the Manage Page
		 		detailLicPg = manageLicPg.clickCancelBtn();
		 		
		 		assertTrue(detailLicPg.verifyDetailLicTitle().contains(licence_Name));
		 		
		 		//Click Back Button on the Detailed Lic Page
		 		LicPg = detailLicPg.clickBackBtn();		
		 		
		 		//Verify My Licence Page is displayed
		 		assertTrue(LicPg.myLicPgTitle().contains(licence_Name));
		 		
		 		//Click on the Settings and then sign out
		 		SettingsPage settingPg = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		assertTrue(settingPg.verifySettingsPageTitile().contains("Settings"));
		 		
		 		//Click SignOut
		 		AddInPg = settingPg.pressSigoutButton();
		 		
		 		//Verify Add Intro Page is displayed
		 		assertTrue(AddInPg.verifyAddPageTitle());
		 		
		 		
		 			 		
		 	}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{
	 		
	 		
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
	public IOS_HolderRenewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}

}
