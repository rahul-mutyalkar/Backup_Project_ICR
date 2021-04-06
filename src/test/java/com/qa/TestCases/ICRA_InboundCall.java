package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import com.qa.BusinessLogic.ICRA_InboundCall_BL_Dhanshri;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

public class ICRA_InboundCall extends DriverCalling {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;
    
	public static WebDriver webDriver = null;
	public static String tcID = null;

	ICRA_InboundCall_BL_Dhanshri DBL = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;



	@Test
	public void TC_ICRA_InboundCall() throws Throwable {
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
                		webDriver = launchbrowser(tcID);
        				DBL = new ICRA_InboundCall_BL_Dhanshri(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      
      				    
            				if(tcID.contains("verify Search By member Detail"))
              			{
            				DBL.MemberIdSearch();
              				
          					DBL.Searchbutton();
          					DBL.Clearbutton();
              				DBL.MemberNSearch();
              				DBL.Searchbutton();
              				
              				
              			}
            			else	if(tcID.contains("Search by provider Detail"))
              			{
              				DBL.ProviderNSearch();
              				
              				DBL.Searchbutton();
              				DBL.Clearbutton();
              				DBL.ProviderNPISearch();
              				DBL.Searchbutton();
              			}
              			else	if(tcID.contains("Search by both provider and member details"))
              			{
              				DBL.Member_ProviderSearch();
              			    DBL.Searchbutton();
              		
              			}
              			
              			else if(tcID.contains(" no data found error"))
              			{
              				DBL.Member_ProviderSearch();
              				
              				DBL.Nodatafound();
              			}
              				
              			
            			
              			else if(tcID.contains("Search Without any data"))
              			{
              				
              				DBL.ICRA_IB_Errors();
              			}
              			 
              			else if(tcID.contains("inbound radio button is selected"))
              			{
              				
              				
              				
              				DBL.MemberNSearch();
              				DBL.Searchbutton();
              				DBL.InboundcallRB();
              			}
              			else if(tcID.contains("return to inbound call page from Address management page"))
              			{
              				DBL.MemberNSearch();
              				DBL.Searchbutton();
              				DBL.Inboundlink();
              			}
              			
              			else if(tcID.contains("Search By Address id"))
              			{
              				DBL.SBAddressID();
              				DBL.Searchbutton();
              				DBL.validateid();
              			}
              			
              			else if(tcID.contains("Search By City"))
              			{
        				DBL.SBCity();
        				DBL.Searchbutton();
              				//DBL.Validatedata();
              			}
              			
        			else if(tcID.equalsIgnoreCase("verify Search By State"))
              			{
              				DBL.SBState();
              				DBL.Searchbutton();
              				//DBL.Validatedata();
              			}
              			
              			else if(tcID.equalsIgnoreCase("Search By  Zip Code"))
              			{
              				DBL.SBZipcode();
              				DBL.Searchbutton();
              				//DBL.Validatedata();
              			}
              			
              			if(tcID.equalsIgnoreCase("verify Search By  All Detail"))
              			{
              				DBL.Alldata();
              				DBL.Searchbutton();
              			}
              			
              			else if(tcID.equalsIgnoreCase("verify Search By  Group Name"))
              			{
              				DBL.SBGroupName();
              				DBL.Searchbutton();
              			}
              			
              			else if(tcID.equalsIgnoreCase("verify Validate data Grid data"))
              			{
              				DBL.SBAddressID();
              				DBL.Searchbutton();
              				DBL.VDDataGriddetail();
              				DBL.VDCount();
              			}
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
