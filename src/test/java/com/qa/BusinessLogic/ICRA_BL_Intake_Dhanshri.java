package com.qa.BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.PageObjects.ICRA_Intake_PO_Dhanshri;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;

public class ICRA_BL_Intake_Dhanshri extends Extent_Reporting {

	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_Intake_PO_Dhanshri icra_elements;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	
	public ICRA_BL_Intake_Dhanshri(WebDriver driver, String TC_ID) {
		this.driver = driver;
		this.TC_ID = TC_ID;
		icra_elements = new ICRA_Intake_PO_Dhanshri(driver);

	}
	
	public void accesspdf() throws Throwable
	{
		
	 	
		try {
			List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
					
			for(int i=1;i<=label.size();i++)
			{
				
				String list = driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")).getText();
				String[] parts = list.split(", ");
			
				String part2 = parts[1]; 
			   
				
				Extent_Reporting.Log_Message("Filename in "+i+" is : "+list, test, driver);
				
				
				
				if(part2.contains(ExcelHandling.GetExcelData(TC_ID, "LoginUsername"))||list.length() == 0 )
				{
					action.clickButton(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[1])")), "click on PDF");
					
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is Available for user ", test, driver);
					
					
					Thread.sleep(1000);
					break;				
				}
			
				else
				{				
					Extent_Reporting.Log_Fail(TC_ID, "Pdf is not Available for user ", test, driver);
					action.Scroll(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")));
				}

			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "accesspdf() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
	}
	
	public void Zoomin() throws Throwable
	{
		
		try {
			action.frameSwitch(icra_elements.pdfframe, "frame is selected ");
			action.WaitUntilDisplayed(icra_elements.Zoomin);
			String style=icra_elements.pdft.getAttribute("style");
			action.JSclickButton(icra_elements.Zoomin, "click on zoom in");
			String style1=icra_elements.pdft.getAttribute("style");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Zoom in functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Zoom in functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Zoomin() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}
		
	}
	
	
	public void Zoomout() throws Throwable
	{		
		try {
			action.WaitUntilDisplayed(icra_elements.Zoomout);
				
			String style=icra_elements.pdft.getAttribute("style");
				
			action.JSclickButton(icra_elements.Zoomout, "click on Zoomout");
			String style1=icra_elements.pdft.getAttribute("style");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Zoom out functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Zoom out functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Zoomout() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}
	}
	
	public void RotateCCW() throws Throwable
	{
		
	
		try {
			action.WaitUntilDisplayed(icra_elements.pdftool);
				
			String style=icra_elements.pdft.getAttribute("style");
				
			action.JSclickButton(icra_elements.pdftool, "click on pdftool");
			
			action.JSclickButton(icra_elements.rccw, "click on rccw");
			
			String style1=icra_elements.pdft.getAttribute("style");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Rotate Counter clockwise  functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Rotate Counter clockwise functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "RotateCCW() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());

		}
	}
	
	public void RotateCW() throws Throwable
	{
				
		try {
			String style=icra_elements.pdft.getAttribute("style");
				
			
			
			action.JSclickButton(icra_elements.rcw, "click on rcw");
			
			String style1=icra_elements.pdft.getAttribute("style");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Rotate Counter functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Rotate Counter functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "RotateCW() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());

		}
	}
	
	public void gotolastpage() throws Throwable
	{
		
		
		try {
			String style=icra_elements.pages.getAttribute("data-page-number");
				
			
			
			action.JSclickButton(icra_elements.gtlastpage, "click on last page");
			
			String style1=icra_elements.pdft.getAttribute("data-page-number");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Go to last page functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Go to last page functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "gotolastpage() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
	}
	public void gotofirstpage() throws Throwable
	{
		try {
			Zoomin();
			action.Scroll(icra_elements.Zoomout);
			Zoomout();
			action.Scroll(icra_elements.pdftool);
			RotateCCW();
			action.Scroll(icra_elements.rcw);
			RotateCW();
			
			action.Scroll(icra_elements.gtlastpage);
			gotolastpage();
			
			action.Scroll(icra_elements.pdftool);
			
				
			String style=icra_elements.pages.getAttribute("data-page-number");
				
			action.JSclickButton(icra_elements.pdftool, "click on pdftool");
			
			action.JSclickButton(icra_elements.gtfirstpage, "click on first page");
			
			String style1=icra_elements.pdft.getAttribute("data-page-number");

			 if (style.equalsIgnoreCase(style1)) { 

			  Extent_Reporting.Log_Fail(TC_ID,"Go to First page functionality not working properly", test, driver);
			
			 
			  } else
			  
			  {
				  Extent_Reporting.Log_Pass(TC_ID, "Go to First page functionality working properly ",test, driver);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "gotofirstpage() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
	}
	public void GlobalFilt() throws Throwable
	{
		try {
			String data=ExcelHandling.GetExcelData(TC_ID, "GlobalFilt");
			action.WaitUntilDisplayed(icra_elements.GlobalFilt);
			icra_elements.GlobalFilt.sendKeys(data);
			
			 List<WebElement> label =driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));
			 Thread.sleep(1000);
			 OUTER_LOOP: 
				 for(int i=1;i<=label.size();i++) { 
				 for(int j=2;j<=7;j++)
				 { 
					 String list =driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td["+j+"])")).getText();
			 		  if (list.contains(data)) {
			  	  
			
			  Extent_Reporting.Log_Pass(TC_ID,"Global filter Working Properly ", test, driver);
			  break OUTER_LOOP ;
			  
			
			  } else { 
				 
				  Extent_Reporting.Log_Fail(TC_ID,"Global filter Working Properly", test, driver);
			  }
			  } 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "GlobalFilt() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		
	     
	}
	     
		
	
	
	
public void pdfCheck() throws Throwable
{
	try {
		String msg="This file is already in use by another use";
		
		List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));
		Thread.sleep(1000);;
		for(int i=1;i<=label.size();i++)
		{
			
		action.clickButton(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[1])")), "click on PDF");

			
		WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
  
   if(action.isElementDisplayed(w,"AlertDialog"))
		{
		   msg = action.elementGetText(w, "Alert dialog");
		}
 if(msg.contains("This file is already in use by another use"))
 {
		Extent_Reporting.Log_Pass(TC_ID, msg, test, driver);
		break;
 }
 else
 {
		Extent_Reporting.Log_Fail(TC_ID, msg, test, driver);
 }
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "pdfCheck() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}

public void verifytotalcount() throws Throwable
{

	
	try {
		List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));
		 Thread.sleep(1000);;
		
		 int a=label.size();
		 String str1 = Integer.toString(a);
		   
		
		 String list=icra_elements.TotalCount.getText();
		 String[] parts = list.split("- ");
			
			String part2 = parts[1]; 
			
		 Thread.sleep(1000);
		 if (part2.contains(str1)) {
		 	
			
			
			Extent_Reporting.Log_Pass(TC_ID, "Total count match with no .of PDF ", test, driver);
		
			
		} else {
			
			Extent_Reporting.Log_Fail(TC_ID, "Total count not match with no .of PDF", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "verifytotalcount() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
 	}
	
public void NoofPages() throws Throwable
{
	
	try {
		List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
		
		for(int i=1;i<=label.size();i++)
		{
			
			String list = driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")).getText();
			String[] parts = list.split(", ");
			String part2 = parts[1]; 
			Extent_Reporting.Log_Message("Filename in "+i+" is : "+list, test, driver);
			
			if(part2.contains(ExcelHandling.GetExcelData(TC_ID, "LoginUsername"))||list.length() == 0 )
			{
				String pageno=driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[4])")).getText();
				
				
				
				action.clickButton(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[1])")), "click on PDF");
				
				Extent_Reporting.Log_Pass(TC_ID, "Pdf is Available for user ", test, driver);
				action.frameSwitch(icra_elements.pdfframe, "frame is selected ");
				String count = icra_elements.maxnumpages.getAttribute("max");
		
				
				Thread.sleep(1000);
								
				if(pageno.equalsIgnoreCase(count))
				{
					Extent_Reporting.Log_Pass(TC_ID, "Total count match with no .of pages in PDF ", test, driver);
				}
				 else {
				 		
				 		Extent_Reporting.Log_Fail(TC_ID, "Total count not match with no .of pages in PDF", test, driver);
				 	}
				break;
				}
			
		
			else
			{				
						
				Extent_Reporting.Log_Fail(TC_ID, "Pdf is not Available for user ", test, driver);
				action.Scroll(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")));
			}
		
}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "NoofPages() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
	}



public void FinishWCNF() throws Throwable
{
	try {
		accesspdf();
		List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
		action.WaitUntilDisplayed(icra_elements.FinishButton);
		
		action.JSclickButton(icra_elements.ChaseNotFoundCheckBox, "Chase Not Found CheckBox");
		  Thread.sleep(500);
		action.clickButton(icra_elements.FinishButton, "Finish Button");
		  Thread.sleep(1000);
		 List<WebElement> label2 = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
		if(label.size()==label2.size()-1)
		{

		
			Extent_Reporting.Log_Pass(TC_ID, "Total count match with no .of PDF ", test, driver);
		
			
		} else {
			
			Extent_Reporting.Log_Fail(TC_ID, "Total count not match with no .of PDF", test, driver);
		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "FinishWCNF() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
		
}


public void FinishWDD() throws Throwable
{
	try {
		accesspdf();
		List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
		action.WaitUntilDisplayed(icra_elements.FinishButton);
		 Thread.sleep(1000);
		action.JSclickButton(icra_elements.DuplicateDocumentCheckBox, "Duplicate Document CheckBox");
		  Thread.sleep(1000);
		action.clickButton(icra_elements.FinishButton, "Finish Button");
		 Thread.sleep(1000);
		 List<WebElement> label2 = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
		if(label.size()==label2.size()-1)
		{

			
			Extent_Reporting.Log_Pass(TC_ID, "Total count match with no .of PDF ", test, driver);
		
			
		} else {
		
			Extent_Reporting.Log_Fail(TC_ID, "Total count not match with no .of PDF", test, driver);
		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "FinishWDD() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
		
}

public void Reorder() throws Throwable
{
	try {
		String msg="Successfully pages moved";
		action.WaitUntilDisplayed(icra_elements.ReorderButton);
		action.clickButton(icra_elements.ReorderButton, "Reoder Button");
		action.WaitUntilDisplayed(icra_elements.ReorderFrom);

		icra_elements.ReorderFrom.sendKeys(ExcelHandling.GetExcelData(TC_ID, "FromPage"));
		
		Thread.sleep(1000);
		icra_elements.ReorderTo.sendKeys(ExcelHandling.GetExcelData(TC_ID, "ToPage"));
		
		action.clickButton(icra_elements.ReorderPage, "Reoder Page");
		
		WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));

   if(action.isElementDisplayed(w,"AlertDialog"))
		{
		   msg = action.elementGetText(w, "Alert dialog");
		}
 if(msg.contains("Successfully"))
 {
		Extent_Reporting.Log_Pass("Reorder", msg, test, driver);
 }
 else
 {
		Extent_Reporting.Log_Fail("Reorder", msg, test, driver);
 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "Reorder() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}

public void ReorderWAV() throws Throwable
{
	try {
		String msg=" Please enter From Page and To Page No ";
		action.WaitUntilDisplayed(icra_elements.ReorderButton);
		action.clickButton(icra_elements.ReorderButton, "Reoder Button");
		
		action.clickButton(icra_elements.ReorderPage, "Reoder Page");
		
		WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));

   if(action.isElementDisplayed(w,"AlertDialog"))
		{
		   msg = action.elementGetText(w, "Alert dialog");
		}
 if(msg.contains("enter From Page and To Page No"))
 {
		Extent_Reporting.Log_Pass("Reorder", msg, test, driver);
 }
 else
 {
		Extent_Reporting.Log_Fail("Reorder", msg, test, driver);
 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "ReorderWAV() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}
public void SearchByAllMemberDtails() throws Throwable
{
	try {
		action.WaitUntilDisplayed(icra_elements.MemberFirstNameTxt);
		action.inputText(icra_elements.MemberFirstNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberFirstname"),
				"firstname is entered");
		action.inputText(icra_elements.MemberMiddleNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberMiddlename"),
				"middle name  is entered");
		action.inputText(icra_elements.MemberLastNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberLastname"),
				"firstname is entered");
		action.inputText(icra_elements.MemberDOBTxt, ExcelHandling.GetExcelData(TC_ID, "MemberDOB"), "firstname is entered");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "SearchByAllMemberDtails() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}

public void SearchByAllProviderDtails() throws Throwable
{
	try {
		action.WaitUntilDisplayed(icra_elements.ProviderLastNameTxt);
		action.inputText(icra_elements.ProviderLastNameTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderLastName"),
				"lastname is entered");
		
		action.inputText(icra_elements.ProviderNPITxt, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"),
				"firstname is entered");
		action.inputText(icra_elements.ProviderAddressTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderAddress"),
				"firstname is entered");
		Thread.sleep(1000);
		action.JSclickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "SearchByAllProviderDtails() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}
public void Hold() throws Throwable
{
	try {
		String msg="Successfully pages moved";
		action.WaitUntilDisplayed(icra_elements.holdbutton);
		action.clickButton(icra_elements.holdbutton, "Hold Button");
		action.WaitUntilDisplayed(icra_elements.holdreason);
		action.selectDDByText(icra_elements.holdreason, ExcelHandling.GetExcelData(TC_ID, "HoldReason"));
		action.inputText(icra_elements.holdComments, ExcelHandling.GetExcelData(TC_ID, "HoldComment"), "Hold Comment");
		action.clickButton(icra_elements.holdSubmit, "Hold Button");
		WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));

   if(action.isElementDisplayed(w,"AlertDialog"))
		{
		   msg = action.elementGetText(w, "Alert dialog");
		}
 if(msg.contains("Successfully"))
 {
		Extent_Reporting.Log_Pass("Hold", msg, test, driver);
 }
 else
 {
		Extent_Reporting.Log_Fail("Hold", msg, test, driver);
 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "Hold() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}

public void HoldWAV() throws Throwable
{
	try {
		String msg="Please select hold reason.";
		action.WaitUntilDisplayed(icra_elements.holdbutton);
		action.clickButton(icra_elements.holdbutton, "Hold Button");
		action.WaitUntilDisplayed(icra_elements.holdreason);
		
		action.clickButton(icra_elements.holdSubmit, "Hold Button");
		WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
		
   if(action.isElementDisplayed(w,"AlertDialog"))
		{
		   msg = action.elementGetText(w, "Alert dialog");
		}
 if(msg.contains("select hold reason"))
 {
		Extent_Reporting.Log_Pass("Hold", msg, test, driver);
 }
 else
 {
		Extent_Reporting.Log_Fail("Hold", msg, test, driver);
 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "HoldWAV() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}


public void clearButton() throws Throwable
{
	try {
		action.WaitUntilDisplayed(icra_elements.MemberFirstNameTxt);
		action.inputText(icra_elements.MemberFirstNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberFirstname"),
				"firstname is entered");
		action.inputText(icra_elements.MemberMiddleNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberMiddlename"),
				"middle name  is entered");
		action.inputText(icra_elements.MemberLastNameTxt, ExcelHandling.GetExcelData(TC_ID, "MemberLastname"),
				"firstname is entered");
		action.inputText(icra_elements.MemberDOBTxt, ExcelHandling.GetExcelData(TC_ID, "MemberDOB"), "firstname is entered");
		action.inputText(icra_elements.ProviderLastNameTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderLastName"),
				"lastname is entered");
		action.inputText(icra_elements.ProviderMiddleNameTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderMiddleName"),
				"firstname is entered");
		action.inputText(icra_elements.ProviderNPITxt, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"),
				"firstname is entered");
		action.inputText(icra_elements.ProviderAddressTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderAddress"),
				"firstname is entered");
		action.WaitUntilDisplayed(icra_elements.ClearButton);
		action.JSclickButton(icra_elements.ClearButton, "Clear Button");
		
		if((action.elementGetText(icra_elements.ProviderAddressTxt,"provider address").isEmpty()))
		{
			Extent_Reporting.Log_Pass("Clear", "pass", test, driver);
		 }
		 else
		 {
		 	Extent_Reporting.Log_Fail("Clear", "Clear", test, driver);
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "clearButton() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}	
public void memberLnameSerach() throws Throwable
{
	try {
		action.elementDisplayed(icra_elements.MemberLastNameTxt);
		action.inputText(icra_elements.MemberLastNameTxt,ExcelHandling.GetExcelData(TC_ID, "MemberLastname"), "Memeber lastname");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "memberLnameSerach() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}
public void memberFnameSerach() throws Throwable
{
	try {
		action.elementDisplayed(icra_elements.MemberFirstNameTxt);
		action.inputText(icra_elements.MemberFirstNameTxt,ExcelHandling.GetExcelData(TC_ID, "MemberFirstname"), "Member Firstname");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "memberFnameSerach() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}
public void memberDOBSerach() throws Throwable
{
	try {
		action.elementDisplayed(icra_elements.MemberDOBTxt);
		action.inputText(icra_elements.MemberDOBTxt,ExcelHandling.GetExcelData(TC_ID, "MemberDOB"), "MemberDOB");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "memberDOBSerach() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}

public void searchplastname() throws Throwable{
	try {
		action.WaitUntilDisplayed(icra_elements.ProviderLastNameTxt);
		action.inputText(icra_elements.ProviderLastNameTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderLastName"),
				"lastname is entered");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "searchplastname() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}



}

public void searchPfirstname() throws Throwable{
	try {
		action.WaitUntilDisplayed(icra_elements.ProviderFirstNameTxt);
		action.inputText(icra_elements.ProviderFirstNameTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderFirstName"),
				"firstname is entered");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "searchPfirstname() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}

}

public void searchPNPI() throws Throwable{
	try {
		action.WaitUntilDisplayed(icra_elements.ProviderNPITxt);
		action.inputText(icra_elements.ProviderNPITxt, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"),
				"firstname is entered");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "searchPNPI() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}

}

public void searchPAddress() throws Throwable{
	try {
		action.WaitUntilDisplayed(icra_elements.ProviderAddressTxt);
		action.inputText(icra_elements.ProviderAddressTxt, ExcelHandling.GetExcelData(TC_ID, "ProviderAddress"),
				"firstname is entered");
		action.WaitUntilDisplayed(icra_elements.SearchChaseButton);
		action.clickButton(icra_elements.SearchChaseButton, "click on chase button");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "searchPAddress() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
}



public void Splitpage() throws Throwable
{
	try {
		String msg="PDF Created successfully.";
		
		
		log.info("search button click successfully");
		WebElement ChaseId = driver.findElement(By.xpath("//tr[1]//td[3]//a[contains(@class,'btnHyperlink')]"));
		
		
		
		action.JSclickButton(ChaseId, "Chase ID");
		log.info("chaseid click successfully");
		action.WaitUntilDisplayed(icra_elements.SplitFrom);
		log.info("reoder from successfully");
		
		action.inputText(icra_elements.SplitFrom,ExcelHandling.GetExcelData(TC_ID, "FromPage"), "From Page");
		action.inputText(icra_elements.SplitTo,ExcelHandling.GetExcelData(TC_ID, "ToPage"), "To page");
		action.JSclickButton(icra_elements.	SubmitButton, "Submit Button");
		 WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
		   
		   if(action.isElementDisplayed(w,"AlertDialog"))
		    {
		       msg = action.elementGetText(w, "Alert dialog");
		    }
		 if(msg.contains("Successfully"))
		 {
		 	Extent_Reporting.Log_Pass("Spilt", msg, test, driver);
		 }
		 else
		 {
		 	Extent_Reporting.Log_Fail("Split", msg, test, driver);
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "Splitpage() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
	

}
public boolean verify_finishbuttonfunctionality() throws Throwable{
	boolean flag = false;
	try {
		
		action.clickButton(icra_elements.FinishButton, "click on finish button");

		if (action.WaitUntilDisplayed(icra_elements.failchasetoaster)) {
			Extent_Reporting.Log_Pass(TC_ID,
					"System displayed validation message as Please map the chase OR mark this file as Duplicate Document OR Chase Not Found.",
					test, driver);
			flag = true;
		} else {
			Extent_Reporting.Log_Fail(TC_ID, " system wont show any validation ", test, driver);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_Reporting.Log_Fail("MethodFailed", "verify_finishbuttonfunctionality() failed "+ e.getMessage(), test, driver);
		throw new Exception(e.getMessage());
	}
	return flag;
}


public void clickOnChaseid() throws Throwable
{
try {
	List<WebElement> label = driver.findElements(By.xpath("//tr//td[3]//a[@class='btnHyperlink']"));	 	
		
		for(int i=1;i<=label.size();i++)
		{
		WebElement chaseid = driver.findElement(By.xpath("(//tr["+i+"]//td[3]//a[@class='btnHyperlink'])"));
		
		if(chaseid.getText()!="")
		{
			Extent_Reporting.Log_Pass("Chase Id", "pass", test, driver);
			action.JSclickButton(chaseid, "Chase Id click");
			break;
		 }
		 else
		 {
		 	Extent_Reporting.Log_Fail("ChaseId", "Clear", test, driver);
		 }
		
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	   Extent_Reporting.Log_Fail("MethodFailed", "clickOnChaseid() failed "+ e.getMessage(), test, driver);
	   throw new Exception(e.getMessage());
}
	
}
public void EnterFrompage() throws Throwable{
	try {
		action.WaitUntilDisplayed(icra_elements.frompagenotxt);
		action.inputText(icra_elements.frompagenotxt, ExcelHandling.GetExcelData(TC_ID, "FromPage"),
				"frompage number is entered");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "EnterFrompage() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public String EnterToPage() throws Throwable{
	String topage="";
	try {
		action.WaitUntilDisplayed(icra_elements.Topagenotxt);
		topage = ExcelHandling.GetExcelData(TC_ID, "ToPage");
		action.inputText(icra_elements.Topagenotxt, topage, "Topage number is entered");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "EnterToPage() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
	
	return topage;
}
public boolean verifynumberofpages() throws Throwable {
	boolean flag = false;
	try {
		
		searchplastname();
		clickOnChaseid();
		action.frameSwitch(icra_elements.pdfframe, "frame is selected ");

		String count = icra_elements.maxnumpages.getAttribute("max");
		int maxcount = Integer.parseInt(count);
		
		action.defaultSwitch("Swtich to main frame");

		EnterFrompage();
		String topage = EnterToPage();
		int topagecount = Integer.parseInt(topage);
		if (topagecount < maxcount) {
			int calculatedcount = maxcount - topagecount;
			
			action.clickButton(icra_elements.submitbutton, "click on submit button");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			action.frameSwitch(icra_elements.pdfframe, "frame is selected ");
			count = icra_elements.maxnumpages.getAttribute("max");
			maxcount = Integer.parseInt(count);
			if (calculatedcount == maxcount && calculatedcount > 1) {
				Extent_Reporting.Log_Pass(TC_ID,
						" Page numbers are immediatly deducted from Number of pages field on main screen and also pdf pages.",
						test, driver);
				
				flag = true;
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID,
						"Page numbers are  not immediatly deducted from Number of pages field on main screen and also pdf pages",
						test, driver);
			}

		} else if (maxcount == topagecount) {
			action.clickButton(icra_elements.submitbutton, "click on submit button");
			String message = icra_elements.alertToaster.getText();
			if (message.equalsIgnoreCase(
					"All pages of file were mapped to the selected chase. We can't delete all pages from the pdf.")) {
				Extent_Reporting.Log_Pass(TC_ID,
						" Pages are not getting deducted from the pdf when user map all the pages to a chase.", test,
						driver);
				flag = true;
			} else {
				Extent_Reporting.Log_Fail(TC_ID,
						" Pages are getting deducted from the pdf when user map all the pages to a chase.", test,
						driver);
				flag = false;
			}

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "verifynumberofpages() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
	return flag;
}

public boolean  Closebuttonwithyes() throws Throwable{
	boolean flag = false;
	try {
		
		action.clickButton(icra_elements.CloseButton, "click on close button");
		action.acceptAlert();
		flag= true;
		Extent_Reporting.Log_Pass(TC_ID, "Alert is accepted on clicking close button ", test, driver);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 Extent_Reporting.Log_Fail("MethodFailed", "Closebuttonwithyes() failed "+ e.getMessage(), test, driver);
		 throw new Exception(e.getMessage());
	}
	return flag;
}




public boolean closebuttonwithNo() throws Throwable {
	boolean flag = false;
	
	try {
	
		action.clickButton(icra_elements.CloseButton, "click on close button");
		action.rejectAlert();
		flag= true;
		Extent_Reporting.Log_Pass(TC_ID, "Alert is rejected  on clicking close button ", test, driver);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 Extent_Reporting.Log_Fail("MethodFailed", "closebuttonwithNo() failed "+ e.getMessage(), test, driver);
		 throw new Exception(e.getMessage());
	}
	
	return flag;
}

public boolean submitbuttonforChaseNotFound() throws Throwable {
	boolean flag = false;
	try {
	
		if (icra_elements.ChaseNotFoundCheckBox.isSelected() == false) {
			if (icra_elements.submitbutton.isDisplayed()) {
				Extent_Reporting.Log_Pass(TC_ID, "Submit Button is Enabled", test, driver);
			}

			action.clickButton(icra_elements.ChaseNotFoundCheckBox, "The Chase Not found Checkbox is selected");

			if (icra_elements.ChaseNotFoundCheckBox.isSelected()) {
				try {
					if (icra_elements.submitbutton.isDisplayed()) {
						Extent_Reporting.Log_Fail(TC_ID, "Submit Button is Enabled", test, driver);
					}
				} catch (Exception e) {
					Extent_Reporting.Log_Pass(TC_ID, "Submit Button is Disabled", test, driver);
					
				}

			}
			flag = true;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "submitbuttonforChaseNotFound() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());

		
	}
	return flag;
}

public void submitbuttonforDuplicateDocument() throws Throwable{

	try {
		if (icra_elements.DuplicateDocumentCheckBox.isSelected() == false) {
			if (icra_elements.submitbutton.isDisplayed()) {
				Extent_Reporting.Log_Pass(TC_ID, "Submit Button is Enabled", test, driver);
			}

			action.clickButton(icra_elements.DuplicateDocumentCheckBox, "The Duplicate Document Checkbox is selected");

			if (icra_elements.DuplicateDocumentCheckBox.isSelected()) {
				try {
					if (icra_elements.submitbutton.isDisplayed()) {
						Extent_Reporting.Log_Fail(TC_ID, "Submit Button is Enabled", test, driver);
					}
				} catch (Exception e) {
					Extent_Reporting.Log_Pass(TC_ID, "Submit Button is Disabled", test, driver);
				}

			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "submitbuttonforDuplicateDocument() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}
public void ChaseNotFoundisClickable() throws Throwable {
	try {
		boolean checkboxstatus = icra_elements.ChaseNotFoundCheckBox.isSelected();
		if (checkboxstatus == false) {

			Extent_Reporting.Log_Pass(TC_ID, "Chase Not Found checkbox is not selected by default", test, driver);

			for (int clicks = 0; clicks < 2; clicks++) {
				action.clickButton(icra_elements.ChaseNotFoundCheckBox, "Check box is clicked");
				if (icra_elements.ChaseNotFoundCheckBox.isSelected())
					Extent_Reporting.Log_Pass(TC_ID, "Chase Not Found checkbox is checked", test, driver);
				else
					Extent_Reporting.Log_Pass(TC_ID, "Chase Not Found checkbox is unchecked", test, driver);
			}
		} else {
			Extent_Reporting.Log_Fail(TC_ID, "Chase Not Found checkbox is  selected by default", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "ChaseNotFoundisClickable() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public boolean DuplicateDocumentisClickable() throws Throwable{
	boolean flag = false;
	try {
		
		boolean checkboxstatus = icra_elements.DuplicateDocumentCheckBox.isSelected();
		if (checkboxstatus == false) {

			Extent_Reporting.Log_Pass(TC_ID, "Duplicate document checkbox is not selected by default", test, driver);

			for (int clicks = 0; clicks < 2; clicks++) {
				action.clickButton(icra_elements.DuplicateDocumentCheckBox, "Check box is clicked");
				if (icra_elements.DuplicateDocumentCheckBox.isSelected())
					Extent_Reporting.Log_Pass(TC_ID, "Duplicate document  checkbox is checked", test, driver);
				else
					Extent_Reporting.Log_Pass(TC_ID, "Duplicate document checkbox is unchecked", test, driver);
			}
		} else {
			Extent_Reporting.Log_Fail(TC_ID, "Duplicate document checkbox is  selected by default", test, driver);
		}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "DuplicateDocumentisClickable() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
	return flag;
}



public void Display_ProjectName() throws Throwable{
	try {
		for (int i = 0; i <= 8; i++) {
			action.WaitUntilDisplayed(icra_elements.Projectname);
		}
		if (action.elementDisplayed(icra_elements.Projectname)) {
			Extent_Reporting.Log_Pass(TC_ID, "Projectname  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "Projectname element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Display_ProjectName() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void Display_FileName() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.Filename)) {
			Extent_Reporting.Log_Pass(TC_ID, "Filename  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "Filename element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Display_FileName() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void Display_RetrievaMethod() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.RetrievaMethod)) {
			Extent_Reporting.Log_Pass(TC_ID, "RetrievaMethod  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "RetrievaMethod element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Display_RetrievaMethod() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void Display_ChaseId() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.ChaseId)) {
			Extent_Reporting.Log_Pass(TC_ID, "ChaseId  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "ChaseId element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Display_ChaseId() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void Display_ChaseStatus() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.ChaseStatus)) {
			Extent_Reporting.Log_Pass(TC_ID, "ChaseStatus  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "ChaseStatus element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Display_ChaseStatus() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void DisplaySubmitButton() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.submitbutton)) {
			Extent_Reporting.Log_Pass(TC_ID, "submitbutton  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "submitbutton element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "DisplaySubmitButton() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}

}

public void Display_Closebutton() throws Throwable{

	try {
		if (action.elementDisplayed(icra_elements.CloseButton)) {
			Extent_Reporting.Log_Pass(TC_ID, "CloseButton  element is displayed", test, driver);

		} else {
			Extent_Reporting.Log_Fail(TC_ID, "CloseButton element is not  displayed", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}

}



public boolean Verify_Projectdetails() throws Throwable {
	boolean flag = false;

	try {
		
		
		Display_ProjectName();
		Display_FileName();
		Display_RetrievaMethod();
		Display_ChaseId();
		Display_ChaseStatus();
		DisplaySubmitButton();
		Display_Closebutton();
		flag = true;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Verify_Projectdetails() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
	return flag;
}


public boolean Verify_ProjectName() throws Throwable{
	boolean flag= false;
	try {
	
		String projectname = icra_elements.Projectname.getText();
		String inputprojectdata = ExcelHandling.GetExcelData(TC_ID, "ProjectName");
	
		action.clickButton(icra_elements.ClearButton, "all details get clear");
		searchplastname();
		clickOnChaseid();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualprojectname = driver.findElement(By.xpath("//label[@id='lblProjectName']")).getText();
	
	
		if (actualprojectname.equalsIgnoreCase(inputprojectdata)) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Extent_Reporting.Log_Pass(TC_ID, " project name is verified   " + projectname + "  " + actualprojectname,
					test, driver);
	       flag = true;
		} else {
	
			Extent_Reporting.Log_Fail(TC_ID, "project name is  not verified", test, driver);
		}
		
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	   Extent_Reporting.Log_Fail("MethodFailed", "Verify_ProjectName() failed "+ e.getMessage(), test, driver);
	   throw new Exception(e.getMessage());
}
	return flag;
}


public boolean VerifyFileName() throws Throwable{
 
	boolean flag= false;
	try {
	
		for (int i = 0; i <= 8; i++) {
			action.WaitUntilDisplayed(icra_elements.Filename);
		}
		String filename = driver.findElement(By.xpath("//strong[contains(text(),'File Name:')]")).getText();
		
		String inputfilename = ExcelHandling.GetExcelData(TC_ID, "FileName");
	
		action.clickButton(icra_elements.ClearButton, "all details get clear");
		searchplastname();
		clickOnChaseid();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualfilename = driver.findElement(By.xpath("//label[@id='lblFileName']")).getText();
	
	
		Thread.sleep(5000);
		if (actualfilename.equalsIgnoreCase(inputfilename)) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Extent_Reporting.Log_Pass(TC_ID, " File name is verified  " + filename + " " + actualfilename, test,
					driver);
			 flag = true;
		} else {
	
			Extent_Reporting.Log_Fail(TC_ID, "File name is  not verified", test, driver);
		}
		
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	   Extent_Reporting.Log_Fail("MethodFailed", "VerifyFileName() failed "+ e.getMessage(), test, driver);
	   throw new Exception(e.getMessage());
}
 return flag;
}


	public boolean Verify_View_Originallink() throws Throwable{
		boolean flag = false;
		try {
			
			searchplastname();
			List<WebElement> label = driver.findElements(By.xpath("//tr//td[3]//a[@class='btnHyperlink']"));	 	
			
			for(int i=1;i<=label.size();)
			{
			WebElement chaseid = driver.findElement(By.xpath("(//tr["+i+"]//td[3]//a[@class='btnHyperlink'])"));
			String ChaseId = chaseid.getText();
			String ChaseStatus = driver.findElement(By.xpath("//button[contains(text(),'" + ChaseId
					+ "')]/parent::link-renderer/parent::div/parent::div/div[@col-id='ChaseStatus']")).getText();
			
			clickOnChaseid();

			if (ChaseStatus.equalsIgnoreCase("Received Record")) {

				verify_display_view_originallink();

			} else if (ChaseStatus.equalsIgnoreCase("Record QA")) {
				verify_display_view_originallink();

			} else if (ChaseStatus.equalsIgnoreCase("Record QA triggered follow up")) {
				verify_display_view_originallink();
			} else if (ChaseStatus.equalsIgnoreCase("Follow up chase approved by Record QA Manager")) {
				verify_display_view_originallink();

			} else if (ChaseStatus.equalsIgnoreCase("Record QA triggered with pursuit on hold")) {
				verify_display_view_originallink();

			} else if (ChaseStatus.equalsIgnoreCase("Pursuit Hold approved by Record QA Manager")) {
				verify_display_view_originallink();
			} else {
				Extent_Reporting.Log_Pass(TC_ID, "chase  status is " + ChaseStatus
						+ " which is < 3000 therefore  View Original hyperlink is not  available  for this chase status  ",
						test, driver);
			}
			flag=true;
			break;
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Verify_View_Originallink() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
		return flag;
		
	}
	
	public void verify_display_view_originallink() throws Throwable {
		try {
			if (action.elementDisplayed(icra_elements.ViewOriginalButton)) {

				Extent_Reporting.Log_Info(TC_ID, " View original link is display  ", test, driver);
				action.clickButton(icra_elements.ViewOriginalButton, " click on view original link");
				Extent_Reporting.Log_Pass(TC_ID, " original pdf is opened  ", test, driver);
			} else {
				Extent_Reporting.Log_Fail(TC_ID, "View original link is not available", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "verify_display_view_originallink() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}

	}

	public boolean verify_ChaseNotFoundFunctionality() throws Throwable{
		boolean flag = false;
		try {
			
			searchplastname();
			clickOnChaseid();
			action.clickButton(icra_elements.ChaseNotFoundCheckBox, "chase not found checkbox selected");
			Closebuttonwithyes();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if (action.elementDisplayed(icra_elements.intakePageHeader)) {
				Extent_Reporting.Log_Pass(TC_ID, "Intake pdf grid is displayed", test, driver);
				flag = true;
			} else {
				Extent_Reporting.Log_Fail(TC_ID, "Intake pdf grid is not  0displayed", test, driver);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "verify_ChaseNotFoundFunctionality() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		return flag;
	}
	

	public boolean verify_DuplicateDocumentFunctionality() throws Throwable{
		boolean flag = false;
		try {
			
			searchplastname();
			clickOnChaseid();
			action.clickButton(icra_elements.DuplicateDocumentCheckBox, "DuplicateDocument checkbox selected");
			Closebuttonwithyes();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if (action.elementDisplayed(icra_elements.intakePageHeader)) {
				Extent_Reporting.Log_Pass(TC_ID, "Intake pdf grid is displayed", test, driver);
				flag = true;
			} else {
				Extent_Reporting.Log_Fail(TC_ID, "Intake pdf grid is not displayed", test, driver);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "verify_DuplicateDocumentFunctionality() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		return flag;

	}
	
	
	public void AccesspdfHoldtab() throws Throwable
	{
		
		try {
			action.JSclickButton(icra_elements.HoldTab, "Hold Tab");
			Thread.sleep(1000);
			
			List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[6]"));	 	
			
			for(int i=1;i<=label.size();i++)
			{
				
				String list = driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")).getText();
				String[] parts = list.split(", ");
			
				String part2 = parts[1]; 
			   
				
				Extent_Reporting.Log_Message("Filename in "+i+" is : "+list, test, driver);
				
				
				
				if(list.length()==0 ||part2.contains(ExcelHandling.GetExcelData(TC_ID, "LoginUsername")) )
				{
					action.clickButton(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[1])")), "click on PDF");
					action.acceptAlert();
					
					Extent_Reporting.Log_Pass(TC_ID, "Alert is accepted on clicking ok button ", test, driver);
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is Available for user ", test, driver);
					
					
					Thread.sleep(1000);
					break;				
				}
			
				else
				{				
					Extent_Reporting.Log_Fail(TC_ID, "Pdf is not Available for user ", test, driver);
					action.Scroll(driver.findElement(By.xpath("(//tr["+i+"][@class='ng-star-inserted']//td[6])")));
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "AccesspdfHoldtab() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
	
	}
}

