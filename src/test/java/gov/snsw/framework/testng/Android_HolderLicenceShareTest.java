package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;

import gov.snsw.framework.android.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;

import gov.snsw.framework.android.holder.pageobjects.SharingLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;


public class Android_HolderLicenceShareTest extends BasicTest{

	

	@Test (dataProvider="logInData")
	public void licenceShareAsHolder(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin)  throws Exception{
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
		 		
		 		//Keyboard Remove
		 		Utilities.BackBtn(driver);
		 		
		 		//click Sign In Button
		 		enterPIN = signIn.clickSignInBtn();
		 		 		
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
		 		assertEquals("Licences",LicPg.verifyMyLicTitle());
		 		
		 		//Click the License Number		 				 				
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		//click on Share License Button
		 		SharingLicencePage shareLicPg = detailLicPg.clickShareLicenceBtn();
		 		
		 		//verify the License Share Page - Title is displayed
		 		//String shareTitle = shareLicPg.verifySharePageTitle();
		 		//assertTrue(shareTitle.contains("Sharing Licence"));
		 		
		 	assertTrue(shareLicPg.isTextPresentOnScreen("Sharing Licence"));
		 		
		 		//verify the License Share Page - Lic Name is displayed
		 		//String shareLicName = shareLicPg.verifyShareLicName();
		 		//assertTrue(shareLicName.contains("Fishing licence"));
		 		
		 		assertTrue(shareLicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));
		 		
		 		//verify the License Share Page - Lic Num is displayed
		 		//String shareLicNum = shareLicPg.verifyShareLicNum();
		 		
		 	//	assertTrue(shareLicNum.contains(licence_Number));
		 		
		 		assertTrue(shareLicPg.isTextPresentOnScreen(licence_Number));
		 		
		 		//verify the License Share Page - Scan Img is displayed
		 		//assertTrue(shareLicPg.verifyShareQRScan());
		 		
		 		//Click Back Button on the QR Scan Page
		 		shareLicPg.backBtn();
		 		
		 		//click the back button on the License Detailed Page
		 		//LicPg = detailLicPg.pressBackBtn();
		 		Utilities.BackBtn(driver);
		 		
		 		
		 		//Click on the Settings and then sign out
		 		LicPg.settings();

		 		reportFail("expected", "actual","params");	
		 		
		 		
		 		
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
	
	public Android_HolderLicenceShareTest(DesiredCapabilities caps) {
		super(caps);
	}
}
