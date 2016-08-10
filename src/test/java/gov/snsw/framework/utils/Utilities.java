package gov.snsw.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utilities {
	
	public static void closeApp(RemoteWebDriver driver,String appName){
		Map<String, Object> params = new HashMap<String, Object>();
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:close", params);
	}
	
	public static void openApp(RemoteWebDriver driver,String appName){
		Map<String, Object> params = new HashMap<String, Object>();
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:open", params);
	}
	
	public static void cleanApp(RemoteWebDriver driver,String appName){
		Map<String, Object> params = new HashMap<String, Object>();
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:clean", params);
 	}
	
	public static void homeBtn(RemoteWebDriver driver){
		Map<String, Object> params = new HashMap<String, Object>();
 		params.put("keySequence", "HOME");
 		Object result1 = driver.executeScript("mobile:presskey", params);
	}
	
	public static void BackBtn(RemoteWebDriver driver)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keySequence", "BACK");
		Object result1 = driver.executeScript("mobile:presskey", params);
	}
	
	public static String dateFormatChange(String p_date) throws ParseException{
        
        
        //System.out.println("Finalend date:"+p_date);
        
       DateFormat formatter = new SimpleDateFormat("dd MMM yy");
       Date date = (Date)formatter.parse(p_date);
       
       formatter = new SimpleDateFormat("dd/MM/yyyy");
       p_date = formatter.format(date);
       //System.out.println("Finalend date:"+p_date);
    
       return p_date;
	}
	
public static String dateSingleFormat(String p_date) throws ParseException{
        
        
        //System.out.println("Finalend date:"+p_date);
        
       DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
       Date date = (Date)formatter.parse(p_date);
       
       formatter = new SimpleDateFormat("d MMM yyyy");
       p_date = formatter.format(date);
       //System.out.println("Finalend date:"+p_date);
    
       return p_date;
	}
	
	public static String getCurrentDate() throws ParseException{

       DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
       Date date = new Date();
       String p_date = formatter.format(date);
       System.out.println(p_date);
    
       return p_date;
	}			
	
	public static  String[] getXLDataLatestByRow(String location, String sheetname, int rowNo) throws IOException
	  {
		File excel = new File (location);
	    FileInputStream fis = new FileInputStream(excel);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet ws = wb.getSheet(sheetname);

	    int rowNum = ws.getLastRowNum()+1;
	    System.out.println("Number of rows:" + rowNum);
	    int colNum = ws.getRow(0).getLastCellNum();
	    System.out.println("Number of columns:" + colNum);
	    String[] data = new String[colNum];
	    //This code is for complete excel reading. 
	    /*for (int i=0; i<rowNum; i++){
	        XSSFRow row = ws.getRow(i);
	            for (int j=0; j<colNum; j++){
	                XSSFCell cell = row.getCell(j);
	                String value = cellToString(cell);
	                data[i][j] = value;
	                System.out.println("The value is" + value);

	            }
	    	} */
	    	XSSFRow row = ws.getRow(rowNo);
	    	 for (int j=0; j<colNum; j++){
	                XSSFCell cell = row.getCell(j);
	               
	                String value="";
	                     // System.out.println(cell);
	                	  
	                try{
	                	cell.setCellType(Cell.CELL_TYPE_STRING);
	                	value =cell.getStringCellValue();
	                }
	                catch(NullPointerException e){
	                	
	                }
	                	  
	                	  data[j] = value;
	                                
	               //System.out.println("The value is" + value);
	              // System.out.println("The data value is" + data[j]);
	    	 }
	    	 wb.close();
	    	return  data;
	    }
	
	public static long timerGet(RemoteWebDriver driver,String timerType) {
		 String command = "mobile:timer:info";
		 Map<String,String> params = new HashMap<String,String>();
		 params.put("type", timerType);
		 long result = (long)driver.executeScript(command, params);
		 	return result;
	}

	public static void logUxPersonaTimer(RemoteWebDriver driver, String name, String description, long threshold ) {
		logPersonaTimer(driver,name,description,timerGet(driver,"ux"),threshold);
	}
	
	
	public static void logPersonaTimer(RemoteWebDriver driver, String name, String description, long duration, long threshold ) {
	    final Map<String, Object> params = new HashMap<>(7);
	    params.put("result", duration);
	    params.put("threshold", threshold);
	    params.put("description", description);
	    params.put("name", name);
	    driver.executeScript("mobile:status:timer", params);
	}
}
