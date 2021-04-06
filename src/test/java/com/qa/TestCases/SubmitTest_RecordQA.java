package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.qa.Utilities.Extent_Reporting;


public class SubmitTest_RecordQA extends DriverCalling
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
               chase=RQ.GetChaseId();
               if(chase==null)
               {
            	   Extent_Reporting.Log_Fail("ChaseDetail_RecordQA", "Chase not found,all files are locked", test, driver);
               }
        	   RQ.ChkChaseDtlsScrren(chase);
               Extent_Reporting.Log_Message("Checked scrren of inside chase", test, driver);
               RQ.ClkClose_ChkMsg();
               RQ.ChkRecordQAURL();
               Extent_Reporting.Log_Message("Checked close function of chase detail screen", test, driver);
               RQ.SendTxtGolbalFilter(chase);
               BL.PageLoad(500,20000000);
               RQ.ClkChase();
               RQ.ClkSubmit_ChkMsg();
               String TotalRecordCnt1=RQ.GetTotalRecordsCnt();
               int q=Integer.parseInt(TotalRecordCnt)-1;
               RQ.ChkCnt(q, TotalRecordCnt1,"RecordCount","Record Count is correct","Record Count is not correct");
               RQ.ChkRecordQAURL();
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


