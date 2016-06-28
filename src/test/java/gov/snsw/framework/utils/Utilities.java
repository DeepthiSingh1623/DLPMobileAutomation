package gov.snsw.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Utilities {
	
	
	static Map<String, Object> params = new HashMap<String, Object>();
	
	public static void closeApp(RemoteWebDriver driver,String appName){
	
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:close", params);
 		params.clear();
	}
	
	public static void openApp(RemoteWebDriver driver,String appName){
		
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:open", params);
 		params.clear();
	}
	
	public static void cleanApp(RemoteWebDriver driver,String appName){
		
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:clean", params);
 		params.clear();
	}
	
	public static void BackBtn(RemoteWebDriver driver)
	{
	params.put("keySequence", "BACK");
	driver.executeScript("mobile:presskey", params);
	}
	public static String dateFormatChange(String p_date) throws ParseException{
        
        
        //System.out.println("Finalend date:"+p_date);
        
       DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
       Date date = (Date)formatter.parse(p_date);

        formatter = new SimpleDateFormat("dd/MM/yyyy");
       p_date = formatter.format(date);
       //System.out.println("Finalend date:"+p_date);
    
       return p_date;
}

}
