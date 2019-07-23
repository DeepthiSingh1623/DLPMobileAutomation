package gov.snsw.framework.testng;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.ios.checker.pageobjects.AppUsageAgreementPage;
import gov.snsw.framework.ios.checker.pageobjects.CheckerActivities;
import gov.snsw.framework.ios.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.ios.checker.pageobjects.LicenceSearchPage;
import gov.snsw.framework.ios.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.ios.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.ios.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.ios.checker.pageobjects.SettingsPage;
import gov.snsw.framework.utils.Utilities;


public class IOSCheckerActivityTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void checkerActivityDetailsIOS(String username, String password,String pin, String licenceNo) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("bundleId");
	 	try{
	 			 			
		 		switchToContext(driver, "NATIVE_APP");
		 	
		 		
		 		TermsAndConditionsPage tcPg = new TermsAndConditionsPage(driver);
		 		EnterPINPage enterPIN = new EnterPINPage(driver);
		 		
		 		if(tcPg.isAgreeBtnExist()){
		 			
		 			AppUsageAgreementPage appAgree = tcPg.pressAgreeBtn();
		 			
		 			SignInNSWAcctPage signIn = appAgree.pressAgreeBtn();
			 		
			 		//Enter the login details in the Sign In Page
		 			enterPIN = signIn.pressSignIn(username,password);
			 		 
				 		//Enter 4 digit PIN
				 		 enterPIN.enterPin();
				 		 enterPIN.enterPin();
		  		}
		 		
		 		else
		 		{
		 			
		 			enterPIN.enterPinUnlock();
		 		}
		 	
		 		SNSWCheckerPage chkPg = new SNSWCheckerPage(driver);
		 		if(chkPg.isPopupOpen()){
		 			chkPg.clickNo();
		 		}
		 		
		 		if(chkPg.isDialogOpen()){
		 			
		 			chkPg.clickCancel();
		 			
		 		}
		 		
		 		if(chkPg.okNotifications()){
		 			
		 			chkPg.clickOk();
		 			
		 		}
		 		
		 		assertEquals("Scan page title doesnt match","Licence Scan",chkPg.getPageTitle());	
		 		
		 		
		 		CheckerActivities chkAct= chkPg.clickActivity();
		 		assertTrue(chkAct.isTextPresentOnScreen(Utilities.getCurrentDate()));
		 		assertTrue(chkAct.isTextPresentOnScreen("Licence Number:"));
		 		assertTrue(chkAct.isTextPresentOnScreen(licenceNo));
		 		assertTrue(chkAct.isTextPresentOnScreen("Check"));
		 		assertTrue(chkAct.isTextPresentOnScreen("0 Notes"));
		 		assertTrue(chkAct.isTextPresentOnScreen("Recreational Fishing Fee"));
		 		

		 		chkAct.clickActivityLog(licenceNo);
		 		
		 		assertTrue(chkAct.verifyActivityTitle().contains("Activity Detail"));
		 		
		 		assertTrue(chkAct.isTextPresentOnScreen("Licence Number"));
		 		assertTrue(chkAct.isTextPresentOnScreen(licenceNo));
		 		assertTrue(chkAct.isTextPresentOnScreen("Check"));
		 		assertTrue(chkAct.isTextPresentOnScreen("Recreational Fishing"));
		 		assertTrue(chkAct.isTextPresentOnScreen("NSW Department of Primary Industries"));
		 		assertTrue(chkAct.isTextPresentOnScreen("0"));
		 		
		 		chkAct.clickActivityDetailBackBtn();
		 		
		 		assertTrue(chkAct.isTextPresentOnScreen("Activity"));
		 		
		 				 		
		 		SettingsPage settingPg = chkPg.clickSettingsBtn();
		 		
		 		//Click SignOut
		 		tcPg = settingPg.pressSigoutButton();
		 		
		 		assertTrue(tcPg.isTextPresentOnScreen("Terms and Conditions"));
		 		//reportFail("Manual search on iOS", "No Manual search on iOS", "No Manual Search on iOS");	
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
		
	 	finally{
	 		
	 		Utilities.cleanApp(driver, appName);
	 		
	 		Utilities.closeApp(driver, appName);
	 		
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
		  ExcelDriver ed = new ExcelDriver(sysProp.get("inputWorkbook"), sysProp.get("checkerSingInSheet"), false);
		  s = ed.getData(4);
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
	public IOSCheckerActivityTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	


