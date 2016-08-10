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

import gov.snsw.framework.android.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.android.checker.pageobjects.AppUsageAgreementPage;
import gov.snsw.framework.android.checker.pageobjects.CheckerLogs;
import gov.snsw.framework.android.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.android.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.android.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;



public class CheckerLicActivityTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void checkerActivityAndroidTest(String username, String password,String pin, String licenceNo,String holdName, String status, String licstDate, String licExpD, String clsOrCond, String licName, String dob , String address) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 			
			 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		TermsAndConditionsPage tcPg = new TermsAndConditionsPage(driver);
		 		//Click on the Start button on introduction page
		 		//assertTrue(tcPg.isTextPresentOnScreen("Terms and Conditions"));
		 		EnterPINPage enterPIN = null;
		 		
		 		if(tcPg.isAgreeBtnExist()){
		 			
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
		 		
		 		assertTrue(chkPg.isMenuItemPresent());
		 		chkPg.clickHamburgerMenu();
		 		CheckerLogs chkLogs = chkPg.clickCheckerLog();
		 		
		 		assertEquals("Date doesnt match",Utilities.getCurrentDate(),chkLogs.getDate());
		 		assertEquals("Licence type does not match",licName,chkLogs.getLicenceType());
		 		assertEquals("Licence Number does not match",licenceNo,chkLogs.getLicenceNo());
		 		assertEquals("Event type does not match ","Check",chkLogs.getEventType());
		 		assertEquals("Syn status does not match","Sync status: Log Synced",chkLogs.getSyncStatus());
		 		assertEquals("Notes deos not match","0 Notes",chkLogs.getNotes());
		 		
		 		chkLogs.clickActivityLog(licenceNo);
		 		
		 		assertTrue(chkLogs.isContentPresentOnScreen(licenceNo));
		 		assertTrue(chkLogs.isContentPresentOnScreen("Check"));
		 		assertTrue(chkLogs.isContentPresentOnScreen("Recreational Fishing"));
		 		assertTrue(chkLogs.isContentPresentOnScreen("NSW Department of Primary Industries"));		
		 		assertTrue(chkLogs.verifyFlagStatus().contains("OFF"));	 		
		 		
		 		
		 		Utilities.BackBtn(driver);
		 		assertTrue(chkLogs.isTextPresentOnScreen("Checks"));
		 		
		 		
		 		Utilities.BackBtn(driver);
		 		assertTrue(chkPg.isMenuItemPresent());
 			  			 	
		 		chkPg.signOut();

		 		assertTrue(tcPg.isAgreeBtnExist());
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
	public CheckerLicActivityTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	


