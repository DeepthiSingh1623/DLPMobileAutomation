package gov.snsw.framework.testng;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;
import com.perfectomobile.webCommunityPOM.WebCommunityBaseView;

public class NewTest extends BasicTest {


	@Test (dataProvider="logInData")
	public void signIn(String username, String password, String greetingMsg) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
	 	try{
	 		reportPass("success", "param");
	 		//reportFail("expected", "actual","params");
	 		
	 	}
	 	catch(Exception e){

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
	public NewTest(DesiredCapabilities caps) {
		super(caps);
	}
}
