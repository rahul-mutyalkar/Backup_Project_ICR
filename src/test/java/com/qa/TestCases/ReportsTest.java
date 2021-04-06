package com.qa.TestCases;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.BusinessLogic.ProviderManageMentAction_Niketan;
import com.qa.BusinessLogic.ReportsAction_Niketan;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;



public class ReportsTest extends DriverCalling
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;

	Long StartTime;
    Long EndTime;
	
	public static WebDriver webDriver = null;
	public static String tcID = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ProviderManageMentAction_Niketan PM=null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	ReportsAction_Niketan RAN=null;
	
	
	
	
	@Test
	public void ReportFlowTest() throws Throwable
	 {
		file = new File(GlobalConstant.ExcelPath);
	    fis = new FileInputStream(file);
	    wb = new XSSFWorkbook(fis);
	    long startTime = 0;
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
        				log.info(tcID);
        				webDriver = launchbrowser(tcID);
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
        				PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				RAN = new ReportsAction_Niketan(webDriver,tcID);
        				BL.ICRA_Login();
        				PBL.ICRA_Client_Select();
        				PBL.ICRA_Menu_Selection("");
        				//String URL1=ExcelHandling.GetExcelData(tcID, "URL1");
      				    if(tcID.contains("CallCenterProductionReportsTest"))
        				{
        				    RAN.ChkCallCenterReport();
        				}
        				else if(tcID.contains("CoderProductionReportsTest"))
        				{
        					RAN.FillData_HoldHCCRejectCoderProdution();
        					RAN.ClkSubmit();
        					RAN.ChkCoderProductionReport();        					
        				}
        				
        				else if(tcID.contains("HoldReportsTest"))
        				{
        					RAN.FillData_HoldHCCRejectCoderProdution();
        					RAN.ClkSubmit();
        					RAN.ChkHoldReport();
        				}
        				else if(tcID.contains("NOHCCReportsTest"))
        				{
        					RAN.FillData_HoldHCCRejectCoderProdution();
        					RAN.ClkSubmit();
        					RAN.ChkNOHCCReport();
        				}
        				else if(tcID.contains("RejectReportsTest"))
        				{
        					RAN.FillData_HoldHCCRejectCoderProdution();
        					RAN.ClkSubmit();
        					RAN.ChkRejectReport();
        				}
      				    
        				else if(tcID.contains("CoderReviewStatusReportsTest"))
        				{
        					RAN.ChkCoderReviewStatusReport();
        				}
        				else if(tcID.contains("CodingReviewDashboardTest"))
        				{
      				      //  driver.get(URL1);
      				        RAN.PageLoad(8000,6000);
      				        RAN.SwitchFrame();
      				        RAN.SwitchFrame_CodingRevirew();
        					RAN.CodingReviewDashboard("");
      				        RAN.ProjectName_CodingReviewDashboard();
      				        RAN.ReportingPeriod_Dashboard();
      				        log.info("=========== Dashboard is checked ===========");
      				        RAN.Dashboard_Monthly();
      				        RAN.ChkAllDashBoard();    				        
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
	
//	@AfterTest
//	public void CloseDriver()
//	{
//       if(webDriver != null)
//        {	
//         webDriver.quit();
//        } 
//	}
	      
} 


