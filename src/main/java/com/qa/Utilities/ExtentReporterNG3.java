
package com.qa.Utilities;

import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.qa.MainFunctions.GlobalConstant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG3 implements IReporter{
	private ExtentReports extent;
	WebDriver driver=null;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) 
	{
//		extent = new ExtentReports(outputDirectory + File.separator
//						+ "ICRA_REPORT.html", true);
//		File Reportpath=new File(System.getProperty("user.dir") + "\\Reports\\HTML"); 
//	    FileFilter fileFilter = new WildcardFileFilter("*." + "html");
//	    File[] files = Reportpath.listFiles(fileFilter);
//	    for (int i=0;i<files.length;i++)
//	    {
//	    	if(files[i].getName().contains("Report"))
//	    	{
//	    		files[i].delete();
//	    	}
//	    }
//	    File foundedfile=null;
//	    for (int i=0;i<files.length;i++)
//	    {
//	    	if(files[i].getName().contains("TestCasesResults"))
//	    	{
//	    		foundedfile=files[i];
//	    	}
//	    }
//	    System.out.println("Founded File  is" + foundedfile);
//	    File newfile=new File(System.getProperty("user.dir") + "\\Reports\\HTML\\Report.html");
//	    foundedfile.renameTo(newfile);
//	    for (ISuite suite : suites) {
//			Map<String, ISuiteResult> result = suite.getResults();
//
//			for (ISuiteResult r : result.values()) {
//				ITestContext context = r.getTestContext();
//
//				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//			}
//		}
	    try 
	    {
			ExcelUtil.EndExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	extent.flush();
	//	extent.close();
        

	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
                for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

     			if (result.getThrowable() != null) 
				{
					test.log(status,result.getThrowable());
				}
				else
				{
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}

