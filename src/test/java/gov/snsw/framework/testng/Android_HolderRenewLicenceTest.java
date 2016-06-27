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
import gov.snsw.framework.android.holder.pageobjects.ManageYourLicPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.RenewLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;

public class Android_HolderRenewLicenceTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void renewLicence(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
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
	 		enterPIN = signIn.signInNswAcct(username,password);
	 		 		
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
	 		assertEquals("My Licences",LicPg.verifyMyLicTitle());
	 		
	 		//Click the License to view the detailed License	 						
	 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);		 	
	 		
	 		//Click on the Manage License Button
	 		ManageYourLicPage mngLic = detailLicPg.clickManageLicenceBtn();
	 		
	 		//click on renew License
	 		RenewLicencePage renewLicPg = mngLic.clickRenewLic();
		 	
	 		//Verify the Renew License Screen is displayed
	 		renewLicPg.verifyHeading();
	 		
	 		//Need to write code to Renew License 		
	 		
	 		
	 		//click back button on the Manage your License page
	 		mngLic.clickbackBtn();
	 		
	 		//click the back button on the detailed License screen
	 		detailLicPg.pressBackBtn();
	 		
		   // Click on the Settings and Sign out
		   LicPg.settings();
		 		
		  	 		
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
	public Android_HolderRenewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}	

}
