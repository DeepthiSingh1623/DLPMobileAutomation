package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.android.checker.pageobjects.AppSettingPage;
import gov.snsw.framework.android.checker.pageobjects.AppUsageAgreementPage;
import gov.snsw.framework.android.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.android.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.android.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;



public class CheckerAutoLockTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void checkerAutoLock(String username, String password,String pin) throws Exception{
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
		 		TermsAndConditionsPage tcPg = new TermsAndConditionsPage(driver);
		 			 		
		 		EnterPINPage enterPIN = null;
		 		
		 		if(tcPg.isAgreeBtnExist()){
		 			
		 			//TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 			
		 			//Click Accept Button on the Terms and Condition Page
		 			AppUsageAgreementPage appAgree = tcPg.termsAndConditionAcceptBtn();
		 			SignInNSWAcctPage signIn = appAgree.pressAcceptBtn();
			 		
			 		//Enter the login details in the Sign In Page
			 		enterPIN = signIn.signInNswAcct(username,password);
			 		 
				 		//Enter 4 digit PIN
				 		 enterPIN.enterPin(pin);
				 		 enterPIN.enterPin(pin);

		 		}
		 		else{
		 			
		 			enterPIN = new EnterPINPage(driver);
		
		 			//Enter 4 digit PIN confirmation
			 		 enterPIN.enterPin(pin);
		 		}
		 		SNSWCheckerPage chkPg = new SNSWCheckerPage(driver);
		 		
		 		//assertEquals("Enter licence details", chkPg.getAndroidCheckerPageTitle());	
		 		
		 		//verify Scan LicencePage is displayed
		 		assertTrue(chkPg.verifyScanLicenceTitleBar().contains("Scan Licence"));
		 		
		 		//Click on the AppSettings
		 		AppSettingPage appSettingPg = chkPg.clickSettings();
		 		
		 		assertEquals("App Settings",appSettingPg.getAndroidCheckerPageTitle());
		 		
		 		//Click on the AutoLock Option
		 		 appSettingPg.clickAutoLock();		 		
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 				
		 		//select Immediately Radio button
		 		appSettingPg.clickImmediatelyRadioButton();	
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
			 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver);
		 		Thread.sleep(2000);
		 		
		 		//Open App
		 		Utilities.openApp(driver, appName);
		 		Thread.sleep(4000);
	 			
	 			//Verify the Enter PIN is displayed
		 		assertTrue(enterPIN.getPINPageTitle().contains("Enter PIN"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enterPin(pin);
		 		
		 		//verify Scan LicencePage is displayed
		 		assertTrue(chkPg.verifyScanLicenceTitleBar().contains("Scan Licence"));
	 			
		 		//verifying 5 minutes
		 		//Click on the AppSettings
		 		appSettingPg = chkPg.clickSettings();
		 		
		 		assertEquals("App Settings",appSettingPg.getAndroidCheckerPageTitle());
		 		
		 		//Click on the AutoLock Option
		 		 appSettingPg.clickAutoLock();		 		
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 				
		 		//select Immediately Radio button
		 		appSettingPg.clickFiveMinutesRadioButton();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
			 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver);	 		
		 		Thread.sleep(2000);
		 		
		 		//Open App
		 		Utilities.openApp(driver, appName);
	 			Thread.sleep(4000);
	 			
	 			//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));

	 			// Verify After 5 Minutes
		 		
		 		//Click on the AutoLock Option
		 		 appSettingPg.clickAutoLock();		 		
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 				
		 		//select Immediately Radio button
		 		appSettingPg.clickFiveMinutesRadioButton();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
			 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver);	 	 		
		 		Thread.sleep(310000);
		 		
		 		//Open App
		 		Utilities.openApp(driver, appName); 					 				
	 			Thread.sleep(4000);
		 		
	 			//Verify the Enter PIN is displayed
		 		assertTrue(enterPIN.getPINPageTitle().contains("Enter PIN"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enterPin(pin);
		 		
		 		//verify Scan LicencePage is displayed
		 		assertTrue(chkPg.verifyScanLicenceTitleBar().contains("Scan Licence"));
		 			 		
		 		// Click on the Settings and Sign out
		 		chkPg.signOut();

		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	finally{
	 		
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
		  ExcelDriver ed = new ExcelDriver(sysProp.get("inputWorkbook"), sysProp.get("checkerSingInSheet"), false);
		  s = ed.getData(3);
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
	public CheckerAutoLockTest(DesiredCapabilities caps) {
		super(caps);
	}	

}
