package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.AddressRollup_Logic;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class AddressRollup extends DriverCalling{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	public static String startTime;
    public static String endTime;
    Long StartTime;
    Long EndTime;

    
	public static WebDriver webDriver = null;
	public static String tcID = null;
	AddressRollup_Logic ABL = null; 
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;



	@Test
	public void TC_AddressRollup() throws Throwable {
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
                		log.info(tcID);                		           		
        				webDriver = launchbrowser(tcID);
        				ABL = new AddressRollup_Logic(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		
                		BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      				    ABL.Projectsubmit();
      				    ABL.ClickFirstAddress();
      				    if(tcID.contains("Verify_Retrieval_Fax")) 
      				      {
        				    ABL.RetrievalMethod();
      				      }
      				    else if(tcID.contains("Verify_Retrieval_Provider")) 
    				      {
      				        ABL.RetrievalMethod();
    				      }
      				    else if(tcID.contains("Verify_Call_diposition")) 				          
      				      {
      				    	ABL.CallDiposition();
      				      }
      				    else if(tcID.contains("Verify_Send_Request")) 				          
  				          {
      				    	ABL.RetrievalMethod();
      				    	ABL.ChaseDetailsTab();
      				    	ABL.GlobalSearch();
         				    ABL.SendRequest();
         				    ABL.CallDetailsTab_Retrieve();
         				    ABL.ChaseDetailsTab();
         				    ABL.ResendRequest();
  				          }        				   
      			
      				    Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, webDriver);
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
	public void CloseDriver()
	{
       if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}
	
	
}
