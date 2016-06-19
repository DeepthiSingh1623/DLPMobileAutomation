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

import gov.snsw.framework.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.holder.pageobjects.ConfirmPINPage;
import gov.snsw.framework.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.holder.pageobjects.TermsAndConditionsPage;

public class ViewLicenceDetailsTest extends BasicTest {


	@Test (dataProvider="logInData")
	public void viewLicenceDetails(String username, String password,String pin,String licence_Number, String licence_StartDate, String licence_ExpireDate, String class_Type,String licence_Name, String LogEvent_Type, String new_Pin, String appName) throws Exception{
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
		 		ConfirmPINPage confirmPg = enterPIN.enter4DigitPin(pin);
		 		
		 		//Enter 4 digit PIN confirmation
		 		MyLicencePage LicPg = confirmPg.enter4DigitConfirmNumber(pin);
		 		
		 		//Click the Fishing Fee License 
		 		//DetailLicencePage detailLicPg = LicPg.clickLicStatus();		 				
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		//Capturing the Lic Num
		 		String licenceNumber = detailLicPg.getLicNum();			 		
		 		assertTrue(licenceNumber.equalsIgnoreCase(licence_Number));
		 		
		 		//Capturing the Lic Start Date		 		
		 		String licenceStartDate = detailLicPg.getLicStartDate();
		 		assertTrue(licenceStartDate.equalsIgnoreCase(licence_StartDate));
		 		
		 		
		 		//capturing the Lic Expire Date
		 		String licenceExpireDate = detailLicPg.getLicExpireDate();
		 		//assert licenceExpireDate
		 		assertTrue(licenceExpireDate.equalsIgnoreCase(licence_ExpireDate));		 
		 		
		 		//Capture Class Type
		 		String classType = detailLicPg.getLicClass();		 		
		 		//assert Class Type
		 		assertTrue(classType.equalsIgnoreCase(class_Type));
		 		
		 		//click Back button to go to my license page
		 		LicPg = detailLicPg.pressBackBtn();
		 		
		 		//Click on the Settings and then sign out
		 		LicPg.settings();	
		 		
		 		//clean app
		 		Map  params = new HashMap();
	 			params.put("identifier", appName);
	 			Object result = driver.executeScript("mobile:application:clean", params);
		 		
	 			
	 			
		 		//close App
		 		driver.close();
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

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
		  s = ed.getData(11);
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
	public ViewLicenceDetailsTest(DesiredCapabilities caps) {
		super(caps);
	}
}
