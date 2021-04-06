package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.BusinessLogic.RecordQAAction_Niketan;

import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.relevantcodes.extentreports.LogStatus;

import jdk.internal.org.jline.utils.Log;

public class CxlFollUpHold_RecordQA extends DriverCalling
{
  static XSSFWorkbook wb;
  static XSSFSheet sheet;
  static File file;
  static FileInputStream fis;
    
  
  public static String tcID = null;
  ICRA_BusinessLogic_Niketan BL=null;
  RecordQAAction_Niketan  RQ=null;
  ICRA_BusinessLogic_Priyanka PBL=null;
  int a=0;
  String Pdf_TotalPages1="0";
  boolean status;
  String chase;
  Long StartTime;
  Long EndTime;
  
 

  @Test
  public void RecordQATestflow() throws Throwable
  {
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
               driver=launchbrowser(tcID);
               Extent_Reporting.Log_Message("*****" + tcID + " is Started *****", test, driver);
               BL = new ICRA_BusinessLogic_Niketan(driver,tcID);
               RQ = new RecordQAAction_Niketan(driver,tcID);
               PBL=new ICRA_BusinessLogic_Priyanka(driver,tcID);
               BL.ICRA_Login();
               BL.SelectClient();
               BL.PageLoad(1000, 20000000);
               PBL.ICRA_Menu_Selection("");
               BL.PageLoad(2000,30000000);
        	   String TotalRecordCnt=RQ.GetTotalRecordsCnt();
        	   RQ.ClkDateReceviedCol();
        	   if(tcID.contains("PageTest"))
        	   {
        		  chase=RQ.GetChaseForDeletePag();
        	   }
        	   else
        	   {
        	      chase=RQ.GetChaseId();
        	   }
               RQ.SendTxtGolbalFilter(chase);
               BL.PageLoad(1000,30000000);
               String NumberOfPages=RQ.GetNoOfPages();
               BL.PageLoad(1000,30000000);
               RQ.ClkChase();
               RQ.ChkPDFOpenOrNot();
               driver.switchTo().defaultContent();
               if(tcID.contains("Cancel")||tcID.contains("FollowUp"))
               {
            	   RQ.ChkOthDetChaseScrren();
            	   String[] s=RQ.GetChaseDetForCxl();
            	   if(tcID.contains("Cancel"))
            	   {
            	     RQ.ClkCancelChase();
            	     RQ.ChkClose_CxlChaseFollwUpWind();
            	     RQ.ClkCancelChase();
            	   }
            	   else
            	   {
            		 RQ.ClkFollowUp();
            		 RQ.ChkClose_CxlChaseFollwUpWind();
            		 RQ.ClkFollowUp();
            	   }
            	   
            	   RQ.ChkCxlChaseOrFollowUpWin(s); 
            	   RQ.ChkMandMsg_FillDtaCxlOrFollowUpChase();
            	   if(tcID.contains("Cancel"))
            	   {
            	     RQ.ClkCxlChase_ChkMsg();
            	   }
            	   else
            	   {
            		 RQ.ClkFollowUpChase_ChkMsg();
            	   }
            	   String TotalRecordCnt1=RQ.GetTotalRecordsCnt();
            	   int q=Integer.parseInt(TotalRecordCnt)-1;
                   RQ.ChkCnt(q, TotalRecordCnt1,"RecordCount","Record count correct","Record count not correct");
                   RQ.ChkRecordQAURL();
                   BL.ClkRecordQAApproval();
                   if(tcID.contains("Cancel"))
            	   {
                	  status=RQ.ChkRecordQAApproval(s[6], "Cancel");
            	   }
            	   else
            	   {
            		  status=RQ.ChkRecordQAApproval(s[6], "Follow Up");
            	   }
                   if(status)
                   {
                	   Extent_Reporting.Log_Pass("RecordQAGrid","Chase and Request For is correct in record qa grid", test, driver);
                   }
                   else
                   {
                	   Extent_Reporting.Log_Fail("RecordQAGrid", "Chase and Request For is not correct in record qa grid", test,driver);
                   }
            	   
               } 
               else if(tcID.contains("Hold"))
               {
            	  String Reason=ExcelHandling.GetExcelData(tcID,"Reason_CancelChaseWin");
            	  RQ.ClkHoldChase();
                  RQ.ChkClose_HoldWind();
                  RQ.ClkHoldChase();
            	  RQ.ChkHoldScreenWind();
            	  RQ.ChkMandMsg_FillDtaHoldChase();
            	  RQ.ClkHoldChase_ChkMsg();
            	  String TotalRecordCnt1=RQ.GetTotalRecordsCnt();
           	      int q=Integer.parseInt(TotalRecordCnt)-1;
                  RQ.ChkCnt(q, TotalRecordCnt1,"RecordCount","Record count correct","Record count not correct");
                  RQ.ChkRecordQAURL();
                  RQ.ClkHoldQueue();
                  Thread.sleep(5000);
                  RQ.SendTxtGolbalFilter(chase);
                  Thread.sleep(5000);
                  RQ.ChkGridColmsDtaRecordQA();
                  RQ.ChkHoldQueueBucket(chase,Reason,"Ok");
                  driver.close();
               }
               else if(tcID.contains("PageTest"))
               {
            	   Thread.sleep(8000);
            	   String TtlPDFCnt=RQ.GetMaxPageNo_Chase();
            	   log.info(TtlPDFCnt);
            	   driver.switchTo().defaultContent();            	  
            	   RQ.ClkMovePge();
            	   RQ.ChkCloseButtonFunction();
            	   RQ.ClkMovePge();
            	   RQ.ChkMovePgeWind();
            	   RQ.ChkMandMsg_FillDtaMovepage();            	   
            	   BL.RefreshPage();
            	   RQ.ClkDeletePge();
            	   RQ.ChkCloseButtonFunction();
            	   RQ.ClkDeletePge();
            	   RQ.ChkDeletePgeWind();
            	   RQ.ChkMandMsg_FillDtaDeletePage();
            	   RQ.ClkDeletePage_ChkMsg();
            	   String TtlPDFCnt1=RQ.GetMaxPageNo_Chase();
            	   int q=Integer.parseInt(TtlPDFCnt)-1;
            	   RQ.ChkCnt(q, TtlPDFCnt1,"PageCount","Page count Of PDF is correct","Page count of PDF is not correct");
            	   driver.switchTo().defaultContent(); 
            	   PBL.ICRA_Menu_Selection("");
            	   BL.PageLoad(500,20000000);
            	   RQ.SendTxtGolbalFilter(chase);
            	   String NumberOfPages1=RQ.GetNoOfPages();
            	   int R=Integer.parseInt(NumberOfPages)-1;
            	   RQ.ChkCnt(R, NumberOfPages1,"PageCount","Page count is correct in grid after deleting ","Page count is not correct in grid after deleting ");
//            	   driver.close();            	   
               }
               Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, driver);
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
  
   
	
	@AfterTest
	public void tearDown()
	{
		 
	     if(driver != null)
	     {
	        driver.quit();
	     }
	}
		
}


