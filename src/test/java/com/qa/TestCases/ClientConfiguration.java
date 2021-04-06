/**
 * 
 */
package com.qa.TestCases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.Utilities.DatabaseWork;
import com.qa.Utilities.FileConversion;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

/**
 * @author pbhattacharjee
 *
 */
public class ClientConfiguration extends DriverCalling{
	
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
	public void TC_ClientConfiguration() throws Throwable {
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
                		try
                		{
                		StartTime=System.currentTimeMillis();	
                		tcID = sheet.getRow(j).getCell(1).toString();
                		System.out.println(tcID);
                		webDriver = launchbrowser(tcID);
                		BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		BL.ICRA_Login();             		
                   		PBL.ICRA_Client_Select();
                   		PBL.ICRA_Menu_Selection("");
            			PBL.ICRA_AddSubClient_Logo_Footer();
            			PBL.ICRA_CC_Fields();
            			PBL.ICRA_CC_Attribute_Type();
            			PBL.ICRA_CC_Mandatory_Fields();            			
            			if(tcID.contains("Placeholders"))
            			{
            				PBL.ICRA_CC_Placeholders();
            			}
            			else if(tcID.contains("BlankError"))
            			{
            				PBL.ICRA_Save();
            			}
            			else if(tcID.contains("Invalid"))
            			{
            			PBL.ICRA_CC_DataEntry();
            			PBL.ICRA_Save();
            			}
            			else if(tcID.contains("Valid"))
            			{
            			   String verifyClient = PBL.ICRA_CC_DataEntry();            			
            			   PBL.ICRA_Save();
            			   PBL.ICRA_Menu_Selection("Project Configuration");            			
            			   String clientname = PBL.clientVerifyProject(verifyClient);          			
            			   String csvFile = GlobalConstant.DownloadPath + "\\ClientConfig"+JavaUtilities.datetime("ddMM_mmss")+".csv";
            			   String xlsxFile = GlobalConstant.DownloadPath + "\\ClientConfig"+JavaUtilities.datetime("ddMM_mmss")+".xlsx";
            			   DatabaseWork.sqlDatabaseConnectionEstablish("172.30.54.99", "1433", "iCRA_Master", "nicra_test", "nicra_test@321!");
            			   DatabaseWork.sqlQueryExecution(csvFile, ExcelHandling.GetExcelData(tcID, "DatabaseQuery")+clientname+"';");
            			   FileConversion.CSVToExcelConverter(csvFile, xlsxFile);
            			   HashMap<String, String> datamap = ExcelHandling.readCellData(xlsxFile);
            			   PBL.displayHashmap(datamap);
            			}
            			EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();
						}
                		catch(Exception e)
                		{
							EndTime=System.currentTimeMillis();
	                        EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                        EndReport();
	                    }
					            	
                	}			
                	
                	}

                }
	        }
		catch (Exception e)
		{
		     //Extent_Reporting.Log_Fail("Failed", "Failure in testcase :"+tcID, test, driver);
	    }
		

	}
	

	/**
	 * @param datamap
	 */
	@AfterTest
	public void tearDown()
	{
        
        if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}

}
