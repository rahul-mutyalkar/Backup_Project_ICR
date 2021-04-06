package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.AddressRollup_Logic;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.BusinessLogic.REPORT_BUSINESS_ARC;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class REPORT_TESTCASE extends DriverCalling{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	public static String startTime;
    public static String endTime;
    
	public static WebDriver webDriver = null;
	public static String tcID = null;
	REPORT_BUSINESS_ARC Report = null;

	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	public static String Button = null;
	  Long StartTime;
      Long EndTime;



	@Test
	public void TC_TestCaseName() throws Throwable {
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
                  		try {
                  		System.out.println(j);
                		tcID = sheet.getRow(j).getCell(1).toString();
                		log.info(tcID);
                		
                		startTime = JavaUtilities.datetime("dd/MM/yyyy HH:mm:ss");
        				webDriver = launchbrowser(tcID);
        				Report = new REPORT_BUSINESS_ARC(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		BL.ICRA_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      				
      			
      				  if(tcID.equalsIgnoreCase("Verify_QualityReport")) 
				        {
      					   Report.Quality_Validation();
      					   Report.Quality_Function();
				        }
      				  else if(tcID.equalsIgnoreCase("Verify_IntakeReport")) 
			            {
  					   Report.Intake_Function();
  					   
			            }
      				  else if(tcID.equalsIgnoreCase("Verify_ManQualityReport")) 
			            {
  					   Report.MANQuality_Function(); 					   
			            }
      				  else if(tcID.equalsIgnoreCase("Verify_RecordqaReport")) 
			            {
					      Report.RecordQA_Function(); 					   
			            }
      				  
      				  else if(tcID.equalsIgnoreCase("Verify_ManHCCReport")) 
		                {
				          Report.ManHCC_Function(); 					   
		                }
      				  else if(tcID.equalsIgnoreCase("Verify_ManRetDash")) 
	                {
			          Report.Retrival_Dashboard(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_Agent_TotalCall_LINK")) 
	                {
			          Report.Agent_TotalCall_LINK(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_AVG_REC_LINK")) 
	                {
			          Report.AVG_REC_LINK(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_PRO_ADD_TOU_LINK")) 
	                {
			          Report.PRO_ADD_TOU_LINK(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_PROLO_SUCC_LINK")) 
	                {
			          Report.PROLO_SUCC_LINK(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_ESC_SCAN_LINK")) 
	                {
			          Report.ESC_SCAN_LINK(); 					   
	                }
      				  else if(tcID.equalsIgnoreCase("Verify_RET_SCAN_REC_LINK")) 
	                {
			          Report.RET_SCAN_REC_LINK(); 					   
	                }
      			
      				      EndTime=System.currentTimeMillis();
   				          Extent_Reporting.Log_Message("***************" + tcID + " is Ended *****************", test, webDriver);
   				          EndExcelReport1(EndTime,StartTime,tcID);
                          EndReport();
      				
						  }
                		catch (AssertionError e) 
                		{
							 Extent_Reporting.Log_Message("REPORTS Test case Failed", test, webDriver);
							 EndTime=System.currentTimeMillis();
                            EndExcelReport(EndTime,StartTime,"Fail",tcID);
							EndReport();
							
						}
                		catch (Exception e) 
                		{
							 Extent_Reporting.Log_Message("REPORTS Test case Failed", test, webDriver);	
							 EndTime=System.currentTimeMillis();
	                         EndExcelReport(EndTime,StartTime,"Fail",tcID);
							EndReport();
						}
		
					}//end if loop
					
					//tearDown();

				}

			}

			// TODO Test Case Step Function
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
}
