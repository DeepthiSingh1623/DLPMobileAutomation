package gov.snsw.framework.testng;

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

import gov.snsw.framework.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.checker.pageobjects.AppSettingPage;
import gov.snsw.framework.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.checker.pageobjects.TermsAndConditionsPage;



public class CheckerChangePINTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin, String appName) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
	 	try{
	 			//reportPass("success", "param");
	 			 			
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
		 		
		 		//Click on the AppSettings
		 		AppSettingPage appSettingPg = chkPg.clickSettings();
		 		
		 		assertEquals("App Settings",appSettingPg.getPageTitle());
		 		
		 		//Click on the Change PIN Button
		 		 appSettingPg.clickChangePinBtn();
		 		
		 		//click Ok Button
		 		enterPIN = appSettingPg.okBtn();
		 		
		 		assertEquals("Enter your current PIN",enterPIN.getPINPageTitle());
		 		
		 		//enter 4 digit current Pin
		 		enterPIN = enterPIN.enterCurrrentPINOnChangePIN(pin);
		 		
		 		//assertEquals("You are required to setup a new PIN",enterPIN.getPINPageTitle());
		 		enterPIN = enterPIN.enterNewPINOnChangePIN("2222");
		 		appSettingPg = enterPIN.confirmNewPINOnChangePIN("2222");

		 		//Close App
		 		Map<String, Object> params = new HashMap();
		 		params.put("identifier", appName);
		 		Object result1 = driver.executeScript("mobile:application:close", params);
		 		params.clear();
		 		
		 		//Open App		 				 		
		 		Map<String, Object> params1 = new HashMap();
		 		params.put("identifier", appName);
		 		Object result2 = driver.executeScript("mobile:application:open", params);
		 		params.clear();	
		 		
		 		// enter Newly created PIN
		 		chkPg = enterPIN.enterCurrrentPINOnLogin("2222");		 		 		
		 	
		 		
		 		assertEquals("OneGovNSW Checker",chkPg.getPageTitle());
		 		
		 		// Click on the Settings and Sign out
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
	public CheckerChangePINTest(DesiredCapabilities caps) {
		super(caps);
	}	

}
