package com.qa.TestCases;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.qa.BusinessLogic.AddressAllocationActions_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;

public class ReassignAreaidTest extends DriverCalling
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;

	public static WebDriver webDriver = null;
	public static String tcID = null;
	ICRA_BusinessLogic_Niketan BL = null;
	AddressAllocationActions_Niketan AL=null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	String Agent="";
	String ReassignAgent="";
	String[] Oldagent;
	String[] Reassignagent;
	String[] AreaDet;
	String[] Oldagent1;
	String[] Reassignagent1;
	String q="";
	String[] UntouchedChaseCount;
	
	@Test
	public void ReassignFlowTest() throws Throwable
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
        				tcID = this.getClass().getSimpleName();
        				webDriver = launchbrowser(tcID);
        				BL = new ICRA_BusinessLogic_Niketan(webDriver,tcID);
        				AL = new AddressAllocationActions_Niketan(webDriver,tcID);
        				PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				Extent_Reporting.Log_Message("*****" + tcID + " is Started *****", test, webDriver);
        				Agent=ExcelHandling.GetExcelData(tcID,"Agent");
        				ReassignAgent=ExcelHandling.GetExcelData(tcID,"Reassign_Agent");
        				String URL=ExcelHandling.GetExcelData(tcID, "URL");			
        				BL.ICRA_Login();
        				BL.SelectClient();
        			    //BL.ClickMenus();
        				PBL.ICRA_Menu_Selection("");
        			    BL.PageLoad(500,10000000);
        			    AL.ClkViewByAreaRadio();
        			    BL.PageLoad(1000,30000000);
        			    AL.ClkAreaCodeRadio();
        			    AL.GetAdr_ChaseCntOfSumm(Agent);
        			    AreaDet=AL.AssignArea_ChkHdrCnt();
        			    Extent_Reporting.Log_Message("Area id is assigned and Checked Header Count",test,webDriver);
        			    AL.ChkTtlCntInSum();
        			    Extent_Reporting.Log_Message("Checked total Untouch address and Total Chase Count in Allocation Summary table after assign ",test,webDriver);
        			    AL.ChkIdDetailInSumTbl(AreaDet[0], Agent);
        			    Extent_Reporting.Log_Message("Checked 1st area id entry in allocation Summary ",test,webDriver);
        			    driver.navigate().refresh();
        			    BL.PageLoad(500,10000000);
        			    AL.ClkViewByAreaRadio();
        			    BL.PageLoad(500,10000000);
        			    AL.ChkIdDetailInSumTbl(AreaDet[1], Agent);
        			    Extent_Reporting.Log_Message("Checked 2nd area id entry in allocation Summary ",test,webDriver);
        			    Extent_Reporting.Log_Message("Reassign Flow Started.....",test,webDriver);
        			    driver.navigate().refresh();
        			    BL.PageLoad(500,10000000);
        			    AL.ClkViewByAreaRadio();
        			    BL.PageLoad(500,10000000);
        			    Oldagent=AL.GetAdr_ChaseCntOfSumm(Agent);
        			    Reassignagent=AL.GetAdr_ChaseCntOfSumm(ReassignAgent);
        			    AL.ClickAgent(Agent);
        			    UntouchedChaseCount=AL.GetUntouchedChaseCnt(AreaDet[0]);
        			    AL.ClickReassignButton();
        			    AL.ChkChaseCntInReassiWindow(UntouchedChaseCount[0]);
        			    Extent_Reporting.Log_Message("Checked Untouch chase count in reassign window",test,webDriver);
        			    AL.SelectAgentInReassiWin(ReassignAgent);
        			    AL.ClkSbmtReassign_ChkMsg();	    
        			    Oldagent1=AL.GetAdr_ChaseCntOfSumm(Agent);
        			    Reassignagent1=AL.GetAdr_ChaseCntOfSumm(ReassignAgent);
        			    ChkAdrCnt();
        			    ChkChaseCnt();
        				AL.ChkIdReassginAgent(UntouchedChaseCount[2], ReassignAgent,UntouchedChaseCount[1],UntouchedChaseCount[0]);
        				driver.navigate().to(URL);
        			    BL.PageLoad(500, 30000000);
        			    BL.ICRA_Login1();
        			    BL.SelectClient();
        			    BL.ClickMenus();
        			    BL.ClickAdrRollup();
        			    AL.ChkAdrRollUpForReassgin(UntouchedChaseCount[2],UntouchedChaseCount[1],UntouchedChaseCount[0]);	
        				Extent_Reporting.Log_Message("Checked Details in reassign agent in summary table",test,webDriver);
        				Extent_Reporting.Log_Message("Reassign Flow Ended.....",test,webDriver);
        				Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, webDriver);
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
	
	public void ChkAdrCnt() throws NumberFormatException, Exception
	{
		q="Total Untouch Address Count";
		Extent_Reporting.Log_Message(""+q+" Of Old Agent of Summary table before reassign:"+Oldagent[0],test,webDriver);
	    Extent_Reporting.Log_Message(""+q+" Of Old Agent of Summary table after reassign:"+Oldagent1[0],test,webDriver);
	    Extent_Reporting.Log_Message(""+q+" Of New Agent of Summary table before reassign:"+Reassignagent[0],test,webDriver);
	    Extent_Reporting.Log_Message(""+q+" Of New Agent of Summary table after reassign:"+Reassignagent1[0],test,webDriver);
	    Extent_Reporting.Log_Message("Checking Total Untouched Address Count Of Reassign Agent...........",test,webDriver);
		//Total Untouched Address Count Of New agent Before Reassign+Total Untouched Address Count Of Old Agent(Address count of two area codes)
		//Stored in x which is must be equal to Total Untouched Address Count Of New agent After Reassign
		int x=Integer.parseInt(Reassignagent[0])+1;		
		AL.ChkCnt(Integer.parseInt(Reassignagent1[0]), x,"UntouAdr_NewAgentAftrReassign", 
                  "Total Untouch address count of new agent after reassign is correct","Total Untouch address count of new agent after reassign is not correct");
		Extent_Reporting.Log_Message("Checking total Untouched Address Count Of Old Agent...........",test,webDriver);
		//Total Untouched Address Count Of Old agent Before Reassign-(Address count of two area codes)
		//Stored in y which is must be equal to Total Untouched Address Count Of Old agent After Reassign
		int y=Integer.parseInt(Oldagent[0])-1;
		AL.ChkCnt(Integer.parseInt(Oldagent1[0]),y,"UntouAdr_OldAgentAftrReassign", 
				"Total Untouch address count of Old agent after reassign is correct","Total Untouch address count of Old agent after reassign is not correct");
	}
	public void ChkChaseCnt()
	{
		Extent_Reporting.Log_Message("Total Chase Count Of Old Agent of Summary table before reassign:"+Oldagent[1],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count Of Old Agent of Summary table after reassign:"+Oldagent1[1],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count Of New Agent of Summary table before reassign:"+Reassignagent[1],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count Of New Agent of Summary table after reassign:"+Reassignagent1[1],test,webDriver);
		//Total Chase Count Of New agent Before Reassign +Total chase count of 1 area codes and sum is Stored in z
		int z=Integer.parseInt(Reassignagent[1])+Integer.parseInt(UntouchedChaseCount[0]);
		if(Integer.parseInt(Reassignagent1[1])>=z)	//These z must be equal or greater than to Total Chase Count Of New agent After Reassign
		{
		  Extent_Reporting.Log_Pass("TtlChCnt_NewAgentAftrReaasign","Total Chase Count is correct In Reassign Agent",test,webDriver);
		}
		else
		{
		  Extent_Reporting.Log_Fail("TtlChCnt_NewAgentAftrReaasign","Total Chase Count is not correct In Reassign Agent",test,webDriver);
		}
		Extent_Reporting.Log_Message("Checking Total Chase Count Of Old Agent...........",test,webDriver);
		//Total Chase Count Of Old agent Before Reassign-Chase count of 1st area codes
		int p=Integer.parseInt(Oldagent[1])-Integer.parseInt(UntouchedChaseCount[0]); //Result Stored in p
		if(Integer.parseInt(Oldagent1[1])<=p) //Total Untouched Address Count Of Old agent After Reassign must be less or equal to p
		{
		  Extent_Reporting.Log_Pass("TtlChCnt_OldAgentAftrReaasign","Total Chase Count is correct In Old Agent",test,webDriver);
		}
		else
		{
		  Extent_Reporting.Log_Fail("TtlChCnt_OldAgentAftrReaasign","Total Chase Count is not correct In Old Agent",test, webDriver);
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

