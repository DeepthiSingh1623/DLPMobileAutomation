package gov.snsw.framework.testng;


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

import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.ios.holder.pageobjects.EnterPinPage;
import gov.snsw.framework.ios.holder.pageobjects.MyLicencesPage;
import gov.snsw.framework.ios.holder.pageobjects.SettingsPage;

import gov.snsw.framework.ios.holder.pageobjects.SignInPage;
import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;
import gov.snsw.framework.utils.Utilities;

public class IOS_HolderChangePinTest extends BasicTest
{
	@Test (dataProvider="logInData")
	public void changePinIOS(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String postal_Address,String lic_OwnerName) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("bundleId");	
	 	try{
	 			//reportPass("success", "param");
	 			
	 			//close App
 				Map<String, Object> params12 = new HashMap<>();
 				params12.put("identifier", "au.gov.nsw.onegov.MyLicences.uat");
 				Object result12 = driver.executeScript("mobile:application:close", params12);
 		
 				//open app
 				Map<String, Object> params22 = new HashMap<>();
 				params22.put("identifier", "au.gov.nsw.onegov.MyLicences.uat");
 				Object result22 = driver.executeScript("mobile:application:open", params22);
 			
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
			 	
			 	//Click Settings Button
		 		SettingsPage settingsPage = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		assertTrue(settingsPage.verifySettingsPageTitile().contains("Settings"));
		 		
		 		//select Change PIN Option on settings Page
		 		settingsPage.clickChangePin();
		 		
		 		//verify old pin Page 
		 		assertTrue(enterPIN.verifyOldPinTitle().contains("Enter old PIN"));
		 		
		 		//enter Old 4 digit PIN
		 		enterPIN.enterPin();
		 		
		 		//verify New pin Page 
		 		assertTrue(enterPIN.verifyNewPinTitle().contains("Enter new PIN"));
		 		
		 		//enter New PIN
		 		enterPIN.enterNewPIN();
		 		
		 		//Verify Confirm PIN
		 		assertTrue(enterPIN.verifyPinConfirmTitle().contains("Confirm PIN"));
		 		
		 		//Enter Confirm New PIN
		 		enterPIN.enterNewPIN();
		 		
		 		//close app
		 		Utilities.closeApp(driver, appName);
		 		
		 		//Open App	
		 		Utilities.openApp(driver, appName);
		 			 				 		
		 		//Verify the Re-Enter PIN Page is displayed
		 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Unlock with PIN"));
		 		
		 		//Re-enter 4 digit PIN Number
		 		enterPIN.enterPINUnlock(); 		
		 		
		 		//assert Error Message
		 		assertTrue(enterPIN.invalidPINError().contains("Invalid PIN"));
		 		
		 		//Enter New PIN
		 		enterPIN.enterNewPINUnlock();	
		 				 		
		 		//Verify My Licence Page is displayed
		 		assertTrue(LicPg.myLicPgTitle().contains(licence_Name));
		 				 				 		
		 		//Click on the Settings and then sign out
		 		SettingsPage settingPg = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		assertTrue(settingsPage.verifySettingsPageTitile().contains("Settings"));
		 		
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
	 		
	 		//clean app
	 		//Utilities.cleanApp(driver, appName);
	 		
	 		Map<String, Object> params1 = new HashMap<>();
	 		params1.put("identifier", "au.gov.nsw.onegov.MyLicences.uat");
	 		Object result1 = driver.executeScript("mobile:application:clean", params1);
	 		
	 		//close app
	 		//Utilities.closeApp(driver, appName);

	 		Map<String, Object> params2 = new HashMap<>();
	 		params2.put("identifier", "au.gov.nsw.onegov.MyLicences.uat");
	 		Object result2 = driver.executeScript("mobile:application:close", params2);
	 		
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
		  s = ed.getData(12);
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
	public IOS_HolderChangePinTest(DesiredCapabilities caps) {
		super(caps);
	}

}
