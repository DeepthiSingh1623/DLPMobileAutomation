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
import gov.snsw.framework.android.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;

public class Android_HolderChangePINTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void changePINTestCase(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
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
			 		
			 		//Verifying Show Password Exist
			 		assertTrue(signIn.verifyShowPwd());
			 		
			 		//Keyboard Remove
			 		Utilities.BackBtn(driver);
			 		
			 		//click Sign In Button
			 		enterPIN = signIn.clickSignInBtn();
			 		 		
			 		//Verify the Enter PIN is displayed
			 		assertTrue(enterPIN.verifyPinEnterTitle().contains("myLicences"));
			 		
			 		//Enter 4 digit PIN
			 		enterPIN.enter4DigitPin(pin);
			 		
			 		//Verify Confirm PIN is displayed
			 		assertTrue(enterPIN.verifyPinConfirmTitle().contains("Confirm PIN"));
			 		
			 		//Enter 4 digit PIN confirmation
			 		enterPIN.enter4DigitPin(pin);
			 		}
			 		
			 		else
			 		{
			 			enterPIN = new EnterPINPage(driver);
			 			
			 			//Verify Unlock Enter Pin is displayed
				 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Enter PIN"));
			 			
			 			//Enter 4 digit PIN
			 			enterPIN.enter4DigitPin(pin);
			 		}	 		
		 		
			 		MyLicencePage LicPg = new MyLicencePage(driver);
			 		
			 		//Verify My Licence Page is displayed.
			 		assertTrue(LicPg.verifyMyLicTitle().contains("Licences"));
			 				 		
			 		//Verify My Licences Page is displayed
			 		assertTrue(LicPg.viewLicName().contains("NSW Recreational Fishing Fee"));
		 		
		 		//Click on the AppSettings
		 		AppSettingPage appSettingPg = LicPg.clickSettings();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 				 		
		 		//Click on the Change PIN Button
		 		 appSettingPg.clickChangePinBtn();
		 		
		 		//click Ok Button
		 		enterPIN = appSettingPg.changePINOkBtn();
		 		
		 		//verify Enter Current PIN Pg is displayed
		 		assertTrue(enterPIN.enterPINPgExist().contains("Enter your current PIN"));
		 		
		 		//enter 4 digit current Pin
		 		enterPIN = enterPIN.enterCurrrentPINOnChangePIN(pin);
		 		
		 		//verify Enter New PIN Pg is displayed
		 		assertTrue(enterPIN.enterPINPgExist().contains("Enter new PIN"));
		 		
		 		//Enter New PIN
		 		enterPIN = enterPIN.enterNewPINOnChangePIN(new_Pin);
		 		
		 		//verify Enter Confirm New PIN Pg is displayed
		 		assertTrue(enterPIN.enterPINPgExist().contains("Confirm PIN"));
		 		
		 		appSettingPg = enterPIN.confirmNewPINOnChangePIN(new_Pin);
		 		
		 		//Verify the AppSettings Page is displayed
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//close app
		 		//Utilities.closeApp(driver, appName);
		 		Map<String, Object> params2 = new HashMap<String, Object>();
		 		params2.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
		 		Object result2 = driver.executeScript("mobile:application:close", params2);
		 		
		 		//Open App
		 		//Utilities.openApp(driver, appName);
		 		Map<String, Object> params3 = new HashMap<String, Object>();
		 		params3.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
		 		Object result3 = driver.executeScript("mobile:application:open", params3);
		 			 		
		 		//Verify Unlock Enter Pin is displayed
		 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Enter PIN"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enter4DigitPin(pin);
		 		
		 		//Verify Error Message for incorrect Password
		 		assertTrue(enterPIN.verifyErrorINTitle().contains("PIN error, please try again."));
		 		
		 		// enter Newly created PIN
		 		LicPg = enterPIN.enterCurrrentPINOnLogin(new_Pin);		 		 		
		 	
		 		//Verify My Licence Page is displayed.
		 		assertTrue(LicPg.verifyMyLicTitle().contains("Licences")); 	
		 		
		 		// Click on the Settings and Sign out
		 		LicPg.settings();
		 		
		 		//Verify Add Intro Page is displayed
		 		assertTrue(AddInPg.verifyAddPg().contains("Add"));
		 		
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{
	 		
	 		//Clean App
	 		//Utilities.cleanApp(driver, appName);
	 		Map<String, Object> params1 = new HashMap<String, Object>();
	 		params1.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 		Object result1 = driver.executeScript("mobile:application:clean", params1);
	 		
	 		
	 		
	 		//close app
	 		//Utilities.closeApp(driver, appName);
	 		Map<String, Object> params2 = new HashMap<String, Object>();
	 		params2.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 		Object result2 = driver.executeScript("mobile:application:close", params2);
	 		
	 		
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
		  s = ed.getData(10);
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
	public Android_HolderChangePINTest(DesiredCapabilities caps) {
		super(caps);
	}	

}
