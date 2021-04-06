/**
 * 
 */
package com.qa.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

/**
 * @author pbhattacharjee
 *
 */
public class Sampling extends DriverCalling{
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;
	
	public static WebDriver webDriver = null;
	public static String tcID = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	@Test
	public void TC_Sampling() throws Throwable {
		try {
			file = new File(GlobalConstant.ExcelPath);
		    fis = new FileInputStream(file);
		    wb = new XSSFWorkbook(fis);
		    for(int i=0;i<wb.getNumberOfSheets();i++)
            {
            	sheet = wb.getSheetAt(i);
                for (int j = 1; j <= sheet.getLastRowNum(); j++) 
                {
                	
                	if((sheet.getRow(j).getCell(2).toString()).equalsIgnoreCase(this.getClass().getSimpleName()) 
                			&& (sheet.getRow(j).getCell(4).toString()).equalsIgnoreCase("Y"))
                	{
                		StartTime=System.currentTimeMillis();
                		try
                		{
                		tcID = sheet.getRow(j).getCell(1).toString();
                		System.out.println(tcID);
                		webDriver = launchbrowser(tcID);
                		BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		BL.ICRA_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
            			PBL.select_Project();
            			PBL.setSampling();
            			PBL.allocateSampling();
            			
            			EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();
						}catch(Exception e){
							EndTime=System.currentTimeMillis();
	                        EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                        EndReport();
						}
						

            			
                	}
                	

                }
	        } 

		
		//TODO Test Case Step Function
	} catch (Exception e) {
		System.out.println(e);
	}
		

	}
	
	@AfterTest
	public void tearDown()
	{
       
        if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}
	
//	public void tearDown()
//	{
//		EndReport();
//		if(webDriver != null)
//		{
//			webDriver.quit();
//		}
//	}
//	
	


}
