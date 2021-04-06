package com.qa.BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.PageObjects.ICRA_PageObjects_Niketan;
import com.qa.Utilities.DatabaseWork;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ExcelUtil;
import com.qa.Utilities.Extent_Reporting;

public class ReportsAction_Niketan extends Extent_Reporting
{
	private static Connection conn = null;
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Niketan icra_elements;
	DatabaseWork DBW=null;
	String[] totalCnt;
	String Reason; 
	
	
	
	public ReportsAction_Niketan(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Niketan(driver);
		DBW = new DatabaseWork(driver, TC_ID);
	}
	
	
	public void SwitchFrame() throws Throwable
	{
        try
        {
        	action.frameSwitch(driver.findElement(By.xpath("//iframe[@frameborder='0']")), "Frame");
        }
        catch(Exception e)
        {
        	Extent_Reporting.Log_FailMessage( "SwitchFrame() failed", test, driver);
			throw new Exception(e.getMessage());
        }
	}
	
	
	public void SwitchFrame_CodingRevirew() throws Throwable
	{
		try
		{
			action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'https://app.powerbi.com/reportEmbed?')]")), "Frame");
		}
		catch(Exception e)
        {
        	Extent_Reporting.Log_FailMessage("SwitchFrame_CodingRevirew() failed", test, driver);
        	throw new Exception(e.getMessage());
        }
	}
	
	
	public void PageLoad(int time,long t)
	{
		for(int i=1;i<=time;i++)
		{
			driver.manage().timeouts().pageLoadTimeout(t, TimeUnit.SECONDS);
		}
	}
	
	public void ClkSubmit() throws Throwable
	{
		try
		{
			action.clickButton(icra_elements.Submit_Production_Report, "Submit");
		}
		catch(Exception e)
        {
			Extent_Reporting.Log_FailMessage( "ClkSubmit() failed", test, driver);
			throw new Exception(e.getMessage());
        }
	}
	
	
	public void ChkElement(WebElement w,String ScrScn,String msg,String msg1) throws Throwable
	{
		try
		{
			if(w.isDisplayed())
		    {
			  Extent_Reporting.Log_Pass(ScrScn,msg,test,driver);
		    }		   
		}
		catch(Exception k)
		{
			Extent_Reporting.Log_Fail(ScrScn,msg1,test,driver);		
			//throw new Exception(k.getMessage());
		}
	}
	
	public void ChkReport(WebElement e,String scrname,String msg,String msg1) throws Throwable
	{
		try
		{
			WebElement e1=driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
			if(e1.isDisplayed())
			{
				Extent_Reporting.Log_Info(TC_ID,"************** Records are not present on screen check database ********************",test,driver);
			}
		}
		catch(Exception l)
		{
			ChkElement(e,scrname,msg,msg1);		
			
		}
		
	}
	
	public void FillData_HoldHCCRejectCoderProdution() throws Throwable
	{
		try
		{		
		///String URL1=ExcelHandling.GetExcelData(TC_ID, "URL1");
		String Project=ExcelHandling.GetExcelData(TC_ID, "Project");		
		String Role=ExcelHandling.GetExcelData(TC_ID, "Roles");
		String DtRange=ExcelHandling.GetExcelData(TC_ID, "DateRange");
		//driver.get(URL1);
		Thread.sleep(5000);
		SwitchFrame();
		ClkSubmit();
		WebElement e=driver.findElement(By.xpath("//div[@class='bd']/div[2]"));
		ChkElement(e,"WarningMsg","WarningMsg is displayed","WarningMsg is not displayed");
		WebElement ok=driver.findElement(By.xpath("//div[@class='ft']/span"));
		action.clickButton(ok, "ok");
		action.selectDDByText(icra_elements.ProjectName,Project);
		try
		{
			if(icra_elements.TimeZone.isDisplayed())
			{
				String timezone=ExcelHandling.GetExcelData(TC_ID, "TimeZone");
				action.selectDDByText(icra_elements.TimeZone,timezone);
			}
		}
		catch(Exception o)
		{
			log.info("Time zone is not present");
		}
		action.selectDDByText(icra_elements.Role,Role);
		action.clickButton(icra_elements.NoneSelected, "NoneSelected");
		action.clickButton(icra_elements.SelectAllChkbok, "SelectAllChkbok");		
		action.selectDDByText(icra_elements.DateRange, DtRange);
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage( "FillData_HoldHCCRejectCoderProdution() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
		
	
	public void ChkCallCenterReport() throws Throwable
	{
		try
		{
		 //  String URL1=ExcelHandling.GetExcelData(TC_ID, "URL1");
		  // driver.get(URL1);
		   Thread.sleep(3000);
		   SwitchFrame();
		   ClkSubmit();
		   ChkElement(driver.findElement(By.id("tblProduction")),"Production Report Grid","Production Report Grid is displayed",
				"Production Report Grid is not displayed");
		   action.selectDDByText(icra_elements.ProductionStartTime, "2:00");
		   ClkSubmit();
		   ChkElement(driver.findElement(By.id("tblProduction")),"Production Report Grid","Production Report Grid is displayed....",
				"Production Report Grid is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkCallCenterReport() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
		
	public void ChkCoderProductionReport() throws Throwable
	{
		try
		{
			WebElement e=driver.findElement(By.xpath("//div[@class='bd']/div[2]"));
			if(e.isDisplayed())
			{
				Extent_Reporting.Log_Message("Records not present",test,driver);
				action.clickButton(driver.findElement(By.xpath("//div[@class='ft']/span")), "Ok");
			}
		}
		catch(Exception f)
		{
			ChkElement(icra_elements.CoderProductionGridTbl,"CoderProductionGridTbl","Coder Production Grid Tbl is displayed",
					"Coder Production Grid Tbl is not displayed");
			ChkElement(icra_elements.Summary,"CoderProductionSummaryReport","Coder Production Summary Report is displayed....",
					"Coder Production Summary Report is not displayed");
			
		}	
	}
	
//	@SuppressWarnings("deprecation")
//	public int GetDataFromDB(LocalDate fromvalue,LocalDate tovalue,String AppFromValue,String AppToValue)
//	{
//		 ResultSet rs;
//		 int a=0;
//		 String query="select * from [iCRA_CallCenter_ClientName].[dbo].[RetrievedChaseGLO] " +
//		               " where StatusCode = '"+ExcelHandling.GetExcelData(TC_ID, "StatusCode") +"'"+    
//				       " and ProjectID='"+ExcelHandling.GetExcelData(TC_ID, "ProjectId")+"'"+
//				      // "  and CTModifiedDate Between ('"+fromvalue+"')  and ('"+tovalue+"');";
//		
//		//String query="select * from [iCRA_CallCenter_ClientName].[dbo].[RetrievedChaseGLO] " +
//	        //       " where StatusCode = '5050'"+
//			//       " and ProjectID='1'"+
//			//       "  and CTModifiedDate Between ('"+fromvalue+"')  and ('"+tovalue+"');";
//		               "  and CTModifiedDate <('"+tovalue+"')"+
//		               "  and CTModifiedDate >('"+fromvalue+"');";
//		log.info(query);
//		String host="172.30.54.99";
//		String port="1433";
//		String DatabaseName="iCRA_Master";
//		String user="nicra_test";
//		String password ="nicra_test@321!";	
//		String url = "jdbc:sqlserver://" + host + ":" + port + ";DatabaseName=" + DatabaseName + ";user=" + user
//				+ ";password=" + password;
//		try
//		{
//		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
//		  conn = DriverManager.getConnection(url);
//		  System.out.println("SQLDDatabase connected successfully.");
//		  Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
//				    ResultSet.CONCUR_READ_ONLY);		
//		  rs = stmt.executeQuery(query);		  		  
//		  while (rs.next())
//		  {
//      		String data = rs.getString("CTModifiedDate");
//      		String[] Expecteddata=data.split(":");
//      		SimpleDateFormat  sdfo = new SimpleDateFormat("yyyy-MM-dd");
//      		Date d1 = sdfo.parse(""+AppFromValue+""); 
//            Date d2 = sdfo.parse(""+AppToValue+""); 
//      		String x=Expecteddata[0].substring(0, 10);
//  			Date d=sdfo.parse(""+x+"");      		
//      		if(d.before(d1))
//      		{
//      			log.info("Date is less than from date");
//      		}
//      		else if(d.after(d1) && d.before(d2))//||d.compareTo(d2)<0||d.compareTo(d1)==0||d.compareTo(d2)==0)
//      		{
//      			log.info("Date is greater than from date");
//      			a=a+1;
//      		}
//      		else if(d.equals(d1))
//      		{
//      			log.info("Date is equal to from date");
//      			a=a+1;
//      		}
//      		else if(d.equals(d2))
//      		{
//      			log.info("Date is equal to To date");
//      			a=a+1;
//      		}
//		}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Getting exception while doing operation in database");
//		}
//		return a;
//			
//	}
		
	public void ChkHoldReport() throws Throwable
	{
	  try
	   {
//		    int screenrecordcnt=0;
//		    String fromdate=driver.findElement(By.id("txtFromDate")).getAttribute("value");
//			String[] Fromdate=fromdate.split("/");	
//			String d=""+Fromdate[2]+"-"+Fromdate[0]+"-"+Fromdate[1]+"";
//			LocalDate date = LocalDate.parse(d);		
//			LocalDate fromvalue = date.minusDays(1);	
//			
//			String todate=driver.findElement(By.id("txtToDate")).getAttribute("value");
//			String[] Todate=todate.split("/");	
//			String d1=""+Todate[2]+"-"+Todate[0]+"-"+Todate[1]+"";
//			LocalDate date1 = LocalDate.parse(d1);		
//			LocalDate tovalue = date1.plusDays(1);
//			try
//			{
//			         WebElement e1=driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
//			         if(e1.isDisplayed())
//			         {
//				          Extent_Reporting.Log_Info(TC_ID,"Records not present",test,driver);
//			         }
//			}
//			catch(Exception e)
//			{
//		      int cnt=driver.findElements(By.xpath("//tbody[@id='tbodyOftblhold']/tr")).size(); 
//		      log.info("Screen Record Count "+  cnt);
//		      screenrecordcnt=cnt;
//			}
//		   
//		   int cnt1=GetDataFromDB(fromvalue,tovalue,d,d1);
//		   log.info("Database  Record Count "+  cnt1);
//		   if(cnt1==screenrecordcnt)
//		   {
//				  Extent_Reporting.Log_Pass(TC_ID, "DB record count and Scrren  records count are matching", test, driver);
//		   }
//		   else
//		   {
//		           Extent_Reporting.Log_Fail(TC_ID, "DB record count and Scrren  records count are not matching" ,test, driver);
//		   }
		   
		   ChkReport(icra_elements.HoldTblData,"HoldTblData","Hold Grid Tbl is displayed",	"Hold Grid Tbl is not displayed");
//		   if(flag)
//		   {
//			  int cnt1=GetDatFromDB(fromvalue,tovalue,d,d1);
//			  if(cnt1>0)
//			  {
//				  Extent_Reporting.Log_Fail(TC_ID, "DB Contains Records but output no records found on screen", test, driver);
//			  }			  
//		   }
//		   else
//		   {	
//				  Extent_Reporting.Log_Pass(TC_ID, "DB Contains Records and on screen records are showing", test, driver);
//		   }
	   }
	   catch(Exception e)
		{
		   Extent_Reporting.Log_FailMessage("ChkHoldReport() failed", test, driver);
			throw new Exception(e.getMessage());
		}							
	}
		
	public void ChkNOHCCReport() throws Throwable
	{
		try
		{
			WebElement e=driver.findElement(By.xpath("//div[@class='bd']/div[2]"));
			if(e.isDisplayed())
			{
				Extent_Reporting.Log_Info(TC_ID,"Records not present",test,driver);
				action.clickButton(driver.findElement(By.xpath("//div[@class='ft']/span")), "Ok");
			}
		}
		catch(Exception f)
		{
			ChkElement(icra_elements.NOHCCTblData,"NOHCCTblData","NOHCC Grid Tbl is displayed",
					"NOHCC Grid Tbl is not displayed");	
			
		}	
	}
	
	public void ChkRejectReport() throws Throwable
	{
		try
		{
			ChkReport(icra_elements.RejectTblData,"RejectTblData","Reject Grid Tbl is displayed","Reject Grid Tbl is not displayed");							
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkRejectReport() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkCoderReviewStatusReport() throws Throwable
	{
		try
		{		
			String Project=ExcelHandling.GetExcelData(TC_ID, "Project");
			//String URL1=ExcelHandling.GetExcelData(TC_ID, "URL1");
			//driver.get(URL1);
			Thread.sleep(5000);
			SwitchFrame();
			action.selectDDByText(icra_elements.Project_CoderReviewStatus,"Select");
			action.clickButton(icra_elements.Search_CoderReviewStatus, "Search_CoderReviewStatus");
			WebElement e=driver.findElement(By.xpath("//div[@class='bd']/div[2]"));
			ChkElement(e,"WarningMsg","WarningMsg is displayed","WarningMsg is not displayed");
			WebElement ok=driver.findElement(By.xpath("//div[@class='ft']/span"));
			action.clickButton(ok, "ok");
			action.selectDDByText(icra_elements.Project_CoderReviewStatus,Project);		
			ChkReport(icra_elements.CoderReviewStatusGrid,"CoderReviewStatus","CoderReviewStatus grid is displayed",
					"CoderReviewStatus grid is displayed");	
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkCoderReviewStatusReport() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	public void ChkBackwordarrow() throws Throwable
	{
		try
		{
			ChkElement(icra_elements.Backarrow,"Backarrow","Backarrow is displayed","Backarrow is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkBackwordarrow() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkFilterImage() throws Throwable
	{
		try
		{
			ChkElement(icra_elements.FilterIcon,"FilterIcon","FilterIcon is displayed","FilterIcon is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkFilterImage() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkFocusMode() throws Throwable
	{
		try
		{
			WebElement l=driver.findElement(By.xpath("//div[@class='bodyCells']/div"));
			String x=action.elementGetAttribute(l, "style", "Original size");
			ChkElement(icra_elements.FocusMode,"FocusMode","FocusMode is displayed","FocusMode is not displayed");
			action.clickButton(icra_elements.FocusMode,"FocusMode");
			WebElement l1=driver.findElement(By.xpath("//div[@class='bodyCells']/div"));
			String y=action.elementGetAttribute(l1, "style", "Original size");
			if(x.equals(y))
			{
				Extent_Reporting.Log_Fail(TC_ID, "Focus mode not working", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Pass(TC_ID, "Focus mode is working", test, driver);
				action.clickButton(icra_elements.BackReporticon, "BackReporticon");
			}
			
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkFocusMode() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkMoreOptions() throws Throwable
	{
		try
		{
			ChkElement(icra_elements.MoreOptions,"MoreOptions","MoreOptions is displayed","MoreOptions is not displayed");
			action.clickButton(icra_elements.MoreOptions,"MoreOptions");			
			ChkElement(icra_elements.ExportData_Menu,"ExportData_Menu","ExportData_Menu is displayed","ExportData_Menu is not displayed");
			ChkElement(icra_elements.Showtbl_Menu,"Showtbl_Menu","Showtbl_Menu is displayed","Showtbl_Menu is not displayed");
			ChkElement(icra_elements.Sortaec_Menu,"Sortaec_Menu","Sortaec_Menu is displayed","Sortaec_Menu is not displayed");
			ChkElement(icra_elements.Sortdec_Menu,"Sortdec_Menu","Sortdec_Menu is displayed","Sortdec_Menu is not displayed");
			ChkElement(icra_elements.Sortby_Menu,"Sortby_Menu","Sortby_Menu is displayed","Sortby_Menu is not displayed");
			if(icra_elements.Heading.getText().contains("Average DOS Details"))
			{
				log.info("Skip");
			}
			else
			{	
			if(icra_elements.Sortaec_Menu.getAttribute("aria-disabled").contains("true"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "Sortaec_Menu is disable", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "Sortaec_Menu is not disable", test, driver);
			}
			if(icra_elements.Sortdec_Menu.getAttribute("aria-disabled").contains("true"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "Sortdec_Menu is disable", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "Sortdec_Menu is not disable", test, driver);
			}
			}
			
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMoreOptions() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkFilterSection() throws Throwable
	{
		try
		{
			ChkElement(icra_elements.ShowFilterPane,"ShowFilterPane","ShowFilterPane is displayed","ShowFilterPane is not displayed");
			//action.clickButton(icra_elements.ShowFilterPane, "FilterPane");
			if(icra_elements.Heading.getText().contains("Chases Page Details"))				
			{
				log.info("skip");
			}
			else
			{	
			WebElement filtersection=driver.findElement(By.id("pageFilterContainer"));
			ChkElement(filtersection,"filtersection","filtersection is displayed","filtersection is not displayed");
			List<WebElement> Indfiltersection=driver.findElements(By.xpath("//section[@id='pageFilterContainer']/div[2]//filter-modern/div[1]"));
			for(int i=1;i<=Indfiltersection.size();i++)
			{
				WebElement filter=driver.findElement(By.xpath("//section[@id='pageFilterContainer']/div[2]//filter-modern["+i+"]/div[1]"));
				ChkElement(filter,"filter","filter_"+i+" is displayed","filter_"+i+" is not displayed");				
			}
			}
			//icra_elements.ShowFilterPane.click();
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkFilterSection() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void ClkSortByMenu() throws Throwable
	{
		try
		{
			action.clickButton(icra_elements.Sortby_Menu, "Sortby_Menu");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ClkSortByMenu() failed", test, driver);
			throw new Exception(e.getMessage());			
		}
	}
	
	public void CodingReviewDashboard(String text) throws Throwable
	{
		try
		{
			ChkElement(icra_elements.CodingCompletionStatus,"CodingCompletionStatus","CodingCompletionStatus is displayed","CodingCompletionStatus is not displayed");
			ChkElement(icra_elements.Chases_Received,"Chases_Received","Chases_Received icon is displayed","Chases_Received icon is not displayed");
			ChkElement(icra_elements.AverageHCC,"AverageHCC","AverageHCC image is displayed","AverageHCC image is not displayed");
			ChkElement(icra_elements.AveragePageCount,"AveragePageCount","AveragePageCount image is displayed","AveragePageCount image is not displayed");
			ChkElement(icra_elements.AverageDOS,"AverageDOS","AverageDOS image is displayed","AverageDOS image is not displayed");
			ChkElement(icra_elements.CoderReviewStatus,"CoderReviewStatus","CoderReviewStatus graph is displayed","CoderReviewStatus graph is not displayed");
			ChkElement(icra_elements.CumulativeCoding,"CumulativeCoding","CumulativeCoding graph is displayed","CumulativeCoding graph is not displayed");
			if(text.contains("Monthly"))
			{
				ChkElement(icra_elements.ProductionMonthly,"ProductionMonthly","ProductionMonthly graph is displayed","ProductionMonthly graph is not displayed");
			}
			else
			{
				ChkElement(icra_elements.ProductionWeekly,"ProductionWeekly","ProductionWeekly graph is displayed","ProductionWeekly graph is not displayed");
			}
			ChkElement(icra_elements.Submit_NoHCC_Reject,"Submit_NoHCC_Reject","Submit_NoHCC_Reject graph is displayed","Submit_NoHCC_Reject graph is not displayed");
			ChkElement(icra_elements.ProjectDropdown,"ProjectDropdown","ProjectDropdown is displayed","ProjectDropdown is not displayed");
			ChkElement(icra_elements.ReportingPeriod,"ReportingPeriod","ReportingPeriod is displayed","ReportingPeriod is not displayed");
			ChkElement(icra_elements.ShowFilterPane,"ShowFilterPane","ShowFilterPane is displayed","ShowFilterPane is not displayed");
//			if(text.contains("Monthly"))
	//		{
		//	  action.clickButton(icra_elements.ShowFilterPane, "ShowFilterPane");
		//	}
			ChkElement(icra_elements.Filters,"Filters","Filters text is displayed","Filters text is not displayed");
			ChkElement(icra_elements.Filtersicon,"Filters icon","Filters icon is displayed","Filters icon is not displayed");
			ChkElement(icra_elements.MonthlyDashboard,"MonthlyDashboard","MonthlyDashboard is displayed","MonthlyDashboard is not displayed");
			ChkElement(icra_elements.AverageDOSMonthly,"AverageDOSMonthly","AverageDOSMonthly is displayed","AverageDOSMonthly is not displayed");
			ChkElement(icra_elements.MonthlyPageCount,"MonthlyPageCount","MonthlyPageCount is displayed","MonthlyPageCount is not displayed");			
			ChkElement(icra_elements.CumulativeMonthlyDrill,"CumulativeMonthlyDrill","CumulativeMonthlyDrill is displayed","CumulativeMonthlyDrill is not displayed");
			//ChkElement(icra_elements.AverageDOSWeekly,"AverageDOSWeekly","AverageDOSWeekly is displayed","AverageDOSWeekly is not displayed");			
			ChkElement(icra_elements.CumulativeMonthlyOut,"CumulativeMonthlyOut","CumulativeMonthlyOut is displayed","CumulativeMonthlyOut is not displayed");			
			ChkElement(icra_elements.Search_Filter,"Search_Filter","Search_Filter is displayed","Search_Filter is not displayed");	
		   // action.clickButton(icra_elements.ShowFilterPane, "ShowFilterPane");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("CodingReviewDashboard() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
		
	public void ReportingPeriod_Dashboard() throws Throwable
	{
		try
		{
			String d=driver.findElement(By.xpath("//div[contains(@aria-label,'Custom')]/div")).getText();
			if(d.contains("4 WEEKS AS OF TODAY"))
		    {
			    Extent_Reporting.Log_Pass(TC_ID, "Reporting period value i.e 4 WEEKS AS OF TODAY is selected by default", test, driver);
		    }
		    else
		    {
			    Extent_Reporting.Log_Fail(TC_ID, "Reporting period value i.e 4 WEEKS AS OF TODAY is not selected by default", test, driver);
		    }
		
		    WebElement s=driver.findElement(By.xpath("//visual-container-modern[25]//visual-modern/div"));		
		    ChkElement(s,"ReportingBy_Weekly","ReportingBy_Weekly is displayed","ReportingBy_Weekly is not displayed");
		    WebElement t=driver.findElement(By.xpath("//visual-container-modern[26]//visual-modern/div"));		
	        ChkElement(t,"ReportingBy_Monthly","ReportingBy_Monthly is displayed","ReportingBy_Monthly is not displayed");	
	 		ChkElement(icra_elements.ReportbyTitle2_Header,"ReportbyTitle2_Header","ReportbyTitle2 i.e weekly is displayed","ReportbyTitle2 i.e weekly is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ReportingPeriod_Dashboard() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ProjectName_CodingReviewDashboard() throws Throwable
	{
		try
		{
			String ProjectTitle=action.elementGetAttribute(icra_elements.ProjectTitle_Header,"title","Title");		
			String U=driver.findElement(By.xpath("//div[contains(@aria-label,'ProjectName')]/div")).getText();			
			if(ProjectTitle.contains("Multiple"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "Project name is displayed at header is correct", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "Project name is displayed at header is not correct", test, driver);
			}
			if(U.contains("All"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "Project name field is correct", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "Project name field is not correct", test, driver);
			}
//			action.clickButton(driver.findElement(By.xpath("//div[contains(@aria-label,'ProjectName')]/i")),"Icon");
//			Thread.sleep(5000);
//			WebElement b=driver.findElement(By.xpath("//div[@class='slicerContainer isMultiSelectEnabled']//div[@class='row'][4]"));		
//			action.clickButton(b, "3rd Project");
//			PageLoad(2000,2000);
//			log.info("@======================================@");
//			WebElement c=driver.findElement(By.xpath("//div[@class='slicerContainer isMultiSelectEnabled']//div[@class='row'][2]"));		
//			action.clickButton(c, "2nd Project");
//			PageLoad(2000,2000);		
//			String ProjectTitle1=action.elementGetAttribute(icra_elements.ProjectTitle_Header,"title","Title");
//			String U1=driver.findElement(By.xpath("//div[contains(@aria-label,'ProjectName')]/div")).getText();			
//			if(U1.contains(ProjectTitle1))
//			{
//				Extent_Reporting.Log_Pass(TC_ID, "Project name is displayed at header is correct", test, driver);
//			}
//			else
//			{
//				Extent_Reporting.Log_Fail(TC_ID, "Project name is displayed at header is not correct", test, driver);
//			}
//			WebElement d=driver.findElement(By.xpath("//div[@class='slicerContainer isMultiSelectEnabled']//div[@class='row'][1]"));		
//			action.clickButton(d, "All Project");
//			PageLoad(2000,2000);		
//			String ProjectTitle2=action.elementGetAttribute(icra_elements.ProjectTitle_Header,"title","Title");
//			if(ProjectTitle2.contains("Multiple"))
//			{
//				Extent_Reporting.Log_Pass(TC_ID, "Project name is displayed at header is correct", test, driver);
//			}
//			else
//			{
//				Extent_Reporting.Log_Fail(TC_ID, "Project name is displayed at header is not correct", test, driver);
//			}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ProjectName_CodingReviewDashboard() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void Dashboard_Monthly() throws Throwable
	{
		try
		{
			action.clickButton(icra_elements.MonthlyDashboard, "MonthlyDashboard");
			PageLoad(4000,2000);
			CodingReviewDashboard("Monthly");
			ChkElement(icra_elements.ReportbyTitle1_Header,"ReportbyTitle1_Header","ReportbyTitle1 i.e Monthly is displayed","ReportbyTitle1 i.e Monthly is not displayed");
			ChkElement(icra_elements.ReportingPeriod,"ReportingPeriod","ReportingPeriod is displayed","ReportingPeriod is not displayed");
			String d=driver.findElement(By.xpath("//div[contains(@aria-label,'Custom')]/div")).getText();
			if(d.contains("3 MONTHS AS OF TODAY"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "Reporting period value i.e 3 MONTHS AS OF TODAY is selected by default", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "Reporting period value i.e 3 MONTHS AS OF TODAY is not selected by default", test, driver);
			}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("CodingReviewDashboard_Monthly() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public void ChkTblCol_OtherElements() throws Throwable
	{
		try
		{
			ChkBackwordarrow();
			ChkFilterSection();
			WebElement tbl=driver.findElement(By.xpath("//div[@class='innerContainer']"));
			ChkElement(tbl,"Records","Records is displayed","Records is not displayed");
			List<WebElement> ro=driver.findElements(By.xpath("//div[@class='columnHeaders']/div/div//div[contains(@class,'pivotTable')]"));
			for(int i=1;i<=ro.size();i++)
			{
			    WebElement v=driver.findElement(By.xpath("//div[@class='columnHeaders']/div/div["+i+"]//div[contains(@class,'pivotTable')]"));
			   	ChkElement(v,"Title","Coloumn_"+i+" is displayed i.e "+v.getText()+"","Coloumn_"+i+" is not displayed");
			   	WebElement z=driver.findElement(By.xpath("//div[@class='columnHeaders']/div/div["+i+"]//div[contains(@class,'sort')]"));
			   	Actions a=new Actions(driver);
				a.moveToElement(z).build().perform();			
				//v.click();
			//	WebElement z=driver.findElement(By.xpath("//div[@class='columnHeaders']/div/div["+i+"]//div[contains(@class,'sort')]"));
				ChkElement(z,"Sorting","SortIcon_"+i+" is displayed","SortIcon_"+i+" is not displayed");			
			}
			Thread.sleep(3000);
			action.clickButton(icra_elements.Heading,"Heading");
			ChkFilterImage();
			ChkFocusMode();
			ChkMoreOptions();
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage( "ChkTblCol_OtherElements() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void DashBoard_Cumulative(WebElement w) throws Throwable
	{
	    try
	    {
	    	action.clickButton(w, w.getText());
	    	PageLoad(4000,2000);
			ChkTblCol_OtherElements();
			ClkSortByMenu();		
			ChkElement(icra_elements.ReportingDate_Menu,"ReportingDate_Menu","ReportingDate_Menu is displayed",
					"ReportingDate_Menu is not displayed");
			ChkElement(icra_elements.ChaseID_Menu,"ChaseID_Menu","ChaseID_Menu is displayed","ChaseID_Menu is not displayed");
			ChkElement(icra_elements.Project_Menu,"Project_Menu","Project_Menu is displayed","Project_Menu is not displayed");
			ChkElement(icra_elements.MemberName_Menu,"MemberName_Menu","MemberName_Menu is displayed","MemberName_Menu is not displayed");
			ChkElement(icra_elements.ProviderNPI_Menu,"ProviderNPI_Menu","ProviderNPI_Menu is displayed","ProviderNPI_Menu is not displayed");
			ChkElement(icra_elements.ProviderName_Menu,"ProviderName_Menu","ProviderName_Menu is displayed",
					"ProviderName_Menu is not displayed");
			ChkElement(icra_elements.IsNoHCC_Menu,"IsNoHCC_Menu","IsNoHCC_Menu is displayed","IsNoHCC_Menu is not displayed");
			ChkElement(icra_elements.IsReject_Menu,"IsReject_Menu","IsReject_Menu is displayed","IsReject_Menu is not displayed");
			
			if(icra_elements.Heading.getText().contains("Output Generated Details")||
					icra_elements.Heading.getText().contains("Monthly Output Generated Details"))
			{
				ChkElement(icra_elements.OutputGenerated_Menu,"OutputGenerated_Menu","OutputGenerated_Menu is displayed",
						"OutputGenerated_Menu is not displayed");
			}
			else if(icra_elements.Heading.getText().contains("Weekly Cumulative Completed")||
					icra_elements.Heading.getText().contains("Monthly Completed Details"))
			{
				ChkElement(icra_elements.CompletedDate_Menu,"CompletedDate_Menu","CompletedDate_Menu is displayed",
						"CompletedDate_Menu is not displayed");
			}			
	   }	   
	  catch(Exception e)
	  {
		  Extent_Reporting.Log_FailMessage("DashBoard_Cumulative() failed", test, driver);
		throw new Exception(e.getMessage());
	  }
	}
	
	
	public void Dashboard_AvgDOSWeek_Month(WebElement w) throws Throwable
	{
		try
		{
			 action.clickButton(w, w.getText());
			 PageLoad(4000,2000);	 
			 ChkTblCol_OtherElements();
		     ClkSortByMenu();
		     ChkElement(icra_elements.ChaseID_Menu,"ChaseID_Menu","ChaseID_Menu is displayed","ChaseID_Menu is not displayed");
		     ChkElement(icra_elements.DOS_Menu,"DOS_Menu","DOS_Menu is displayed","DOS_Menu is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("Dashboard_AvgDOSWeek_Month() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}

	public void Dashboard_WeeklyMonthlyPGCnt(WebElement w) throws Throwable
	{
		try
		{
			 action.clickButton(w, w.getText());
			 PageLoad(4000,2000);			
			 ChkTblCol_OtherElements();
		     ClkSortByMenu();
		     ChkElement(icra_elements.ChaseID_Menu,"ChaseID_Menu","ChaseID_Menu is displayed","ChaseID_Menu is not displayed");
		     ChkElement(icra_elements.PageCount_Menu,"PageCount_Menu","PageCount_Menu is displayed","PageCount_Menu is not displayed");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("Dashboard_WeeklyMonthlyPGCnt() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkAllDashBoard() throws Throwable
	{
		try {
			//DashBoard_Cumulative(icra_elements.CumulativeweeklyOutput);
			//Extent_Reporting.Log_Message("****** CumulativeweeklyOutput checked *********", test, driver);
			
			//Dashboard_AvgDOSWeek_Month(icra_elements.AverageDOSWeekly);
			//Extent_Reporting.Log_Message("******* AverageDOSWeekly checked *********", test, driver);
			
			//Dashboard_WeeklyMonthlyPGCnt(icra_elements.WeeklyPageCount);
			//Extent_Reporting.Log_Message("******** WeeklyPageCount checked *********", test, driver);
			
			//DashBoard_Cumulative(icra_elements.CumulativeWeeklyCompleted);
			//Extent_Reporting.Log_Message("*********  CumulativeWeeklyCompleted checked *******", test, driver);
			
			Dashboard_AvgDOSWeek_Month(icra_elements.AverageDOSMonthly);
			Extent_Reporting.Log_Message("******** AverageDOSMonthly checked *********", test, driver);
			
			Dashboard_WeeklyMonthlyPGCnt(icra_elements.MonthlyPageCount);
			Extent_Reporting.Log_Message("******* MonthlyPageCount checked *******", test, driver);
			
			action.clickButton(icra_elements.NextPageIcon,"NextPageIcon");
			DashBoard_Cumulative(icra_elements.CumulativeMonthlyDrill);
			Extent_Reporting.Log_Message("******** CumulativeMonthlyDrill checked ********", test, driver);
			
			DashBoard_Cumulative(icra_elements.CumulativeMonthlyOut);
			Extent_Reporting.Log_Message("******** CumulativeMonthlyOut checked **********", test, driver);
		}
		catch (Exception e) 
		{
			Extent_Reporting.Log_FailMessage("ChkAllDashBoard() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
}
