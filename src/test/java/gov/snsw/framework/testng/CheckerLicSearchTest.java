package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertNotNull;
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

import gov.snsw.framework.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.checker.pageobjects.CheckerLicenceDetails;


import gov.snsw.framework.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.checker.pageobjects.LicenceSearch;
import gov.snsw.framework.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.checker.pageobjects.TermsAndConditionsPage;



public class CheckerLicSearchTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin, String appName, String licenceNo,String holdName, String status, String licstDate, String licExpD, String clsOrCond, String licName, String dob , String address) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
	 	try{
	 			
	 			 	
	 			 
	 			 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 		
		 		//Click Accept Button on the Terms and Condition Page
		 		SignInNSWAcctPage signIn = tcPg.termsAndConditionAcceptBtn();
		 		
		 		//Enter the login details in the Sign In Page
		 		EnterPINPage enterPIN = signIn.signInNswAcct(username,password);
		 		 		
		 		//Enter 4 digit PIN
		 		enterPIN = enterPIN.enterNewPin(pin);
		 		
		 		//Enter 4 digit PIN confirmation
		 		SNSWCheckerPage chkPg = enterPIN.confirmNewPIN(pin);
		 		
		 		assertEquals("OneGovNSW Checker", chkPg.getPageTitle());	
		 		
		 		LicenceSearch licSch= chkPg.clickManualSearch();	
		 		
		 		//Thread.sleep(100000);
		 		assertEquals("Enter licence details", licSch.getPageTitle());
		 		
		 		licSch.enterLicenceNumber(licenceNo);
		 		
		 		Map<String, Object> params = new HashMap();
 			 	params.put("keySequence", "BACK");
 			 	Object result = driver.executeScript("mobile:presskey", params);
 			 	
		 		CheckerLicenceDetails licDtls= licSch.clickCheckBtn();
		 		
		 		assertEquals("Licence Details", licDtls.getPageTitle());
		 		
		 		assertNotNull(licDtls.isTextPresentOnScreen(licenceNo));
		 		assertNotNull(licDtls.isTextPresentOnScreen(licstDate));
		 		assertNotNull(licDtls.isTextPresentOnScreen(licName));
		 		assertNotNull(licDtls.isTextPresentOnScreen(holdName));
		 		assertNotNull(licDtls.isTextPresentOnScreen(status));
	 		
		 		params.clear();
		 		params.put("start", "887,2173");
		 		params.put("end", "894,463");
		 		Object result1 = driver.executeScript("mobile:touch:swipe", params);
		 		
		 		assertNotNull(licDtls.isTextPresentOnScreen(licExpD));
		 		assertNotNull(licDtls.isTextPresentOnScreen(address));
		 		assertNotNull(licDtls.isTextPresentOnScreen(dob));
		 		
		 		params.clear();
 			 	params.put("keySequence", "BACK");
 			 	driver.executeScript("mobile:presskey", params);
 			 	
 			 	driver.executeScript("mobile:presskey", params);
		 		
		 		chkPg.signOut();
		 		
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
		
	 	finally{
	 		
	 		Map<String, Object> params = new HashMap();
	 		params.put("identifier", appName);
	 		Object result1 = driver.executeScript("mobile:application:clean", params);
	 		params.clear();
	 		
	  		params.put("identifier", appName);
	 		result1 = driver.executeScript("mobile:application:close", params);
	 		params.clear();
	 		
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
		  s = ed.getData(13);
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
	public CheckerLicSearchTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	


