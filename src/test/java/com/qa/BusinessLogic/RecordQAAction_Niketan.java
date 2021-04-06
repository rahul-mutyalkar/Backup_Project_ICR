package com.qa.BusinessLogic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ElementAction;
import com.qa.PageObjects.ICRA_PageObjects_Niketan;




public class RecordQAAction_Niketan extends Extent_Reporting{
	
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Niketan icra_elements;
	String[] totalCnt;
	String Reason; 
	
	
	
	public RecordQAAction_Niketan(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Niketan(driver);
	}
	
	public void SendTxtGolbalFilter(String text) throws Exception
	{
		try
		{
		action.inputText(icra_elements.GlobalFilter,text,"GolbalFilter");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("SendTxtGolbalFilter() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
		
	public void ClkHoldQueue() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.HoldQueueBucket, "HoldQueueBucket");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkHoldQueue() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetChase() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[3]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetChase() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
        
		}
	}
	
	public void ClkChase() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[3]/a"));
		action.clickButton(c, "chaseid");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkChase() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetMemName() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[4]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetMemName() failed - " + e.getMessage(), test, driver);
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
	
	public String GetMemDob() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[5]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetMemDob() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetProvName() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[6]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetProvName() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetNoOfPages() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[7]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetNoOfPages() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetProName() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[8]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetProName() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetProType() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[9]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetProType() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetChaseType() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[10]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetChaseType() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetFileLockName() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[11]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetFileLockName() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetLastAccessName() throws Exception
	{
		try
		{
		WebElement c=driver.findElement(By.xpath("//tbody//tr/td[12]"));
		return action.elementGetText(c, "text");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetLastAccessName() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public String GetTotalRecordsCnt() throws Exception
	{
		try
		{
		totalCnt =driver.findElement(By.xpath("//i[@class='pi pi-refresh']/parent::div")).getText().split("-");
		return totalCnt[1].trim();
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetTotalRecordsCnt() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkMove() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Move, "Move");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkMove() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkCopy() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Copy, "Move");	
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkCopy() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkSubmit() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Submit,"Submit");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkSubmit() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkFollowUp() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.FollowUp,"FollowUp");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkFollowUp() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkMovePge() throws Exception
	{
		try
		{
		action.ScrollToBottom();
		action.clickButton(icra_elements.MovePage,"MovePage");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkMovePge() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkDeletePge() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.DeletePage,"DeletePage");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkDeletePge() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkCancelChase() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.CancelChase,"CancelChase");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkCancelChase() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkCloseChase() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Close_RecordQA,"Close_RecordQA");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("SendTxtGolbalFilter() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkHoldChase() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Hold,"Hold");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkHoldChase() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkHold_HoldWin() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Hold_HoldWin,"Hold_HoldWin");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkHold_HoldWin() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkClose_HoldWin() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Close_HoldWin,"Close_HoldWin");	
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkClose_HoldWin() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void SwitchPDFFrame() throws Exception
	{
		try
		{
		action.ScrollToTop();
		action.frameSwitch(driver.findElement(By.xpath("//iframe[@title='ng2-pdfjs-viewer']")),"Total Count of PDF Page");
		log.info("=======");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("SwitchPDFFrame() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	
	public void ClkPDFTools() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Tools, "PDF Tools");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ClkPDFTools() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void RotatePDFCW() throws Exception
	{
		try
		{
		String style=icra_elements.FirstPgePDFView.getAttribute("style");			
		action.clickButton(icra_elements.Tools, "PDF Tools");		
		action.clickButton(icra_elements.RotateClockwise, "RotateClockwise");
		String style1=icra_elements.FirstPgePDFView.getAttribute("style");
		if (style.equalsIgnoreCase(style1))  
		{ 
          Extent_Reporting.Log_Fail(TC_ID,"Rotate Counter functionality not working properly", test, driver);
		}
        else
		{
		  Extent_Reporting.Log_Pass(TC_ID, "Rotate Counter functionality working properly ",test, driver);
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("RotatePDFCW() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void RotatePDFCCW() throws Exception
	{
		
		try
		{
		String style=icra_elements.FirstPgePDFView.getAttribute("style");			
		//action.clickButton(icra_elements.Tools, "PDF Tools");		
		action.clickButton(icra_elements.RotateCounterClockwise, "RotateCounterClockwise");
		String style1=icra_elements.FirstPgePDFView.getAttribute("style");
		if (style.equalsIgnoreCase(style1))  
		{ 
          Extent_Reporting.Log_Fail(TC_ID,"Rotate Counter Clokwise functionality not working properly", test, driver);
		}
        else
		{
		  Extent_Reporting.Log_Pass(TC_ID, "Rotate Counter Clokwise functionality working properly ",test, driver);
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("RotatePDFCCW() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void GotoLastPge(String pageno) throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.GoToLastPage, "Go To Last page");
		WebElement w=driver.findElement(By.xpath("//input[contains(@id,'pageNumber')]"));
		String pageno1=w.getAttribute("max");
		if (pageno1.equalsIgnoreCase(pageno))
		{
			Extent_Reporting.Log_Pass(TC_ID, "Go to last page functionality working properly ",test, driver);
		}
		else
		{
		  Extent_Reporting.Log_Fail(TC_ID,"Go to last page functionality not working properly", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GotoLastPge() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	
	public void GotoFirstPge() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.GoToFirstPage, "Go To first page");
		WebElement w=driver.findElement(By.xpath("//input[contains(@id,'pageNumber')]"));
		String pageno=w.getAttribute("value");
		if (pageno.equalsIgnoreCase("1"))
		{ 
			Extent_Reporting.Log_Pass(TC_ID, "Go to first page functionality working properly ",test, driver);
		}
		else
		{
		  Extent_Reporting.Log_Fail(TC_ID,"Go to first page functionality not working properly", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GotoFirstPge() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void PresentationMode() throws Exception
	{
		try
		{
		WebElement w=driver.findElement(By.xpath("//div[@class='pdfViewer']//div[@data-page-number='1']"));
		String style=w.getAttribute("style");		
		action.JSclickButton(icra_elements.Presentation_mode_label, "Presentation_mode_label");
		WebElement w1=driver.findElement(By.xpath("//div[@class='pdfViewer']//div[@data-page-number='1']"));
		String style1=w1.getAttribute("style");
		if (style.equalsIgnoreCase(style1))
		{ 
			Extent_Reporting.Log_Fail(TC_ID, "Presentation mode functionality not working properly ",test, driver);
		}
		else
		{
		  Extent_Reporting.Log_Pass(TC_ID,"Presentation mode functionality working properly", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("PresentationMode() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void HorizontalScrolling() throws Exception
	{
		try	{
		WebElement w=driver.findElement(By.xpath("//div[@id='viewer']//div[@data-page-number='1']"));
		String style=w.getAttribute("style");		
		action.JSclickButton(icra_elements.Horizontal_Scroll_label, "Horizontal_Scroll_label");
		WebElement w1=driver.findElement(By.xpath("//div[@id='viewer']//div[@data-page-number='1']"));
		String style1=w1.getAttribute("style");
		if (style.equalsIgnoreCase(style1))
		{ 
			Extent_Reporting.Log_Fail(TC_ID, "Horizontal_Scroll_label functionality not working properly ",test, driver);
		}
		else
		{
		  Extent_Reporting.Log_Pass(TC_ID,"Horizontal_Scroll_label functionality working properly", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("HorizontalScrolling() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void VerticalScrolling() throws Exception
	{
		try
		{
		WebElement w=driver.findElement(By.xpath("//div[@id='viewer']//div[@data-page-number='1']"));
		String style=w.getAttribute("style");		
		action.JSclickButton(icra_elements.Vertical_Scroll_label, "Vertical_Scroll_label");
		WebElement w1=driver.findElement(By.xpath("//div[@id='viewer']//div[@data-page-number='1']"));
		String style1=w1.getAttribute("style");
		if (style.equalsIgnoreCase(style1))
		{ 
			Extent_Reporting.Log_Fail(TC_ID, "Vertical_Scroll_label functionality not working properly ",test, driver);
		}
		else
		{
		  Extent_Reporting.Log_Pass(TC_ID,"Vertical_Scroll_label functionality working properly", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("VerticalScrolling() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
		
	public void ChkPDFDocProp() throws Exception
	{
		try
		{
		action.JSclickButton(icra_elements.Document_properties_label, "Document_properties_label");
		try
		{
		  Thread.sleep(3000);
		  WebElement w1=driver.findElement(By.xpath("//div[contains(@id,'documentProperties')]/div"));
		  if (action.WaitUntilDisplayed(w1))
		  { 
			  WebElement close=driver.findElement(By.xpath("//span[@data-l10n-id='document_properties_close']"));
			  action.clickButton(close, "close");
			  Extent_Reporting.Log_Pass(TC_ID, "Doc Properties diaglog is opened ",test, driver);
		  }
		}
		catch(Exception e)
		{
		  Extent_Reporting.Log_Fail(TC_ID,"Doc Properties diaglog is not opened", test, driver);	
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ChkPDFDocProp() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkSpread(String op) throws Exception
	{
		try
		{
		if(op.equalsIgnoreCase("odd"))
        {
			action.JSclickButton(icra_elements.Spread_odd_label, "Spread_odd_label");
			List<WebElement> rows=driver.findElements(By.xpath("//div[@class='spread'][1]/div"));
			int a=rows.size();
			if(a==2)
			{
				Extent_Reporting.Log_Pass("Odd Spreads","Odd Spread functionality is working", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("Odd Spreads","Odd Spread functionality is not working", test, driver);
			}
			
        }
		if(op.equalsIgnoreCase("even"))
        {
			action.JSclickButton(icra_elements.Spread_even_label, "Spread_odd_label");
			List<WebElement> First=driver.findElements(By.xpath("//div[@class='spread'][1]/div"));
			int a=First.size();
			if(a==1)
			{
				Extent_Reporting.Log_Pass("Even Spreads","Even Spread functionality is working", test, driver);	
			}
			else
			{
				Extent_Reporting.Log_Fail("Even Spreads","Even Spread functionality is not working", test, driver);
			}		
        }
		if(op.equalsIgnoreCase("No spread"))
        {
			action.JSclickButton(icra_elements.Spread_None_label, "Spread_none_label");
			try
			{
			  WebElement rows=driver.findElement(By.xpath("//div[@class='spread']"));
			  if (action.isElementDisplayed(rows,"Spread"))
			  { 
				Extent_Reporting.Log_Fail("No Spreads", "No Spread functionality is not working ",test, driver);
			  }
			}
			catch(Exception e)
			{
			  Extent_Reporting.Log_Pass(TC_ID,"No Spread functionality is working", test, driver);	
			}
        }
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ChkSpread() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkThumbnailFunctionPDF() throws Exception
	{
		try
		{
		WebElement w=driver.findElement(By.id("sidebarToggle"));
		action.clickButton(w, "Toolbar Button");
		try
		{
		 WebElement w1=driver.findElement(By.id("sidebarContent"));
		 if(action.isElementDisplayed(w1,"Thumbnail View"))
		 { 
		  Extent_Reporting.Log_Pass("Thumbnail View", "Thumbnail View is display ",test, driver);
		 }
		}
		catch(Exception e)
		{
		  Extent_Reporting.Log_Fail("Thumbnail View","Thumbnail View is not display", test, driver);	
		}
		WebElement w2=driver.findElement(By.xpath("//div[@id='sidebarContent']//a[@title='Page 2']/div"));
		action.clickButton(w2, "2nd Page from thumbnail");
		WebElement w3=driver.findElement(By.xpath("//input[contains(@id,'pageNumber')]"));
		log.info(w3.getAttribute("value"));
		action.elementGetText(w3, "Page no");
		if(action.elementGetAttribute(w3,"value", "Page no").contains("2"))
		{
			Extent_Reporting.Log_Pass("Thumbnail View", "User can moved to selected page from Thumbnail Section ",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("Thumbnail View", "User is not able to move to selected page from Thumbnail Section ",test, driver);
		}
		WebElement w4=driver.findElement(By.id("sidebarToggle"));
		action.clickButton(w4, "Toolbar Button");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ChkThumbnailFunctionPDF() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
     }
	
	
	public String GetMaxPageNo_Chase() throws Exception
	{
		try
		{
		action.frameSwitch(driver.findElement(By.xpath("//iframe[@title='ng2-pdfjs-viewer']")),"Total Count of PDF Page");
		return action.elementGetAttribute(icra_elements.MaxPageNo_Pdf, "max", "Max Pages");
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("GetMaxPageNo_Chase() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkPDFOpenOrNot() throws Exception
	{
		try
		{
		  action.frameSwitch(driver.findElement(By.xpath("//iframe[@title='ng2-pdfjs-viewer']")),"Frame");
		  if(icra_elements.MaxPageNo_Pdf.isDisplayed());
		  {
			  Extent_Reporting.Log_Pass("PDFFile", "PDF File is present ",test, driver);
		  }		  
		}
		catch(Exception e)
		{
		  Extent_Reporting.Log_FailMessage("**************** PDF File is not present.check ***********************" + e.getMessage(), test, driver);
          throw new Exception(e.getMessage());
		}
	}
	
	public void ChkRecordQAURL() throws Exception
	{
		try
		{
		if(driver.getCurrentUrl().contains("http://172.19.9.53/ICRARevamp/#/record-qa"))
		{
			Extent_Reporting.Log_Pass("RecordQAScreen", "RecordQA scrren is displayed", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Pass("RecordQAScreen", "RecordQA scrren is not displayed", test, driver);
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ChkRecordQAURL() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkMsg(String[] msg,String ScrName,String txt,String txt1) throws Exception
	{
		
		try
		{
		WebElement w=driver.findElement(By.xpath("//div[@role='alertdialog']"));
		action.WaitForElement(w, "Message");
		log.info(w.getText());
		boolean status=ChkTxt(w.getText(),msg);		
		CompareText(status,ScrName,txt,txt1);
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("ChkMsg() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public boolean ChkTxt(String text,String[] msg)
	{
		boolean status=false;
		Set<String> hSet = new HashSet<String>();
		for(String x:msg)
		{
			hSet.add(x);
		}
		Iterator<String> str=hSet.iterator();
		String s="";
		while(str.hasNext())
		{
			s=str.next();
			if(s.trim().contains(text.trim()))
			{
				status=true;
				break;
			}
		}
		return status;
	}
	
	public void CompareText(boolean status,String ScrName,String msg,String msg1) throws Exception
	{
		try
		{
		if(status)
		{
		   Extent_Reporting.Log_Pass(ScrName,msg, test, driver);
		}
	   else
		{
		   Extent_Reporting.Log_Fail(ScrName,msg1, test, driver);
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("CompareText() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	
	public void CheckElementDisplay(WebElement w,String ScrName,String name) throws Exception
	{
		try
		{
		if(w.isDisplayed())
		{
		   Extent_Reporting.Log_Pass(ScrName,""+name+" is displayed", test, driver);
		}
	   else
		{
		   Extent_Reporting.Log_Fail(ScrName,""+name+" is not displayed", test, driver);
		}
		}
		catch(Exception e)
		{
		Extent_Reporting.Log_FailMessage("CheckElementDisplay() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkCnt(int previous,String current,String Scrname,String msg,String msg1) throws Exception
	{
	   try
	   {
		if(current.equals(String.valueOf(previous)))
	   {
	   	   Extent_Reporting.Log_Pass(Scrname, msg, test, driver);
	   }
	   else
	   {
	   	   Extent_Reporting.Log_Fail(Scrname, msg1, test, driver);
	   }
	   }
	   catch(Exception e)
	   {
		Extent_Reporting.Log_FailMessage("ChkCnt() failed - " + e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
	   }
	}
	
	public void ClkMoveCopy_MoveWin_ChkMsg() throws Exception
	{
		try
		{
		String[] MSG=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");	
		action.clickButton(icra_elements.Move_MoveWindow, "Move");
		ChkMsg(MSG,"MoveCopySuccess","MoveCopySuccess msg correct","MoveCopySuccess is not correct");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ClkMoveCopy_MoveWin_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public void ClkSubmit_ChkMsg() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		ClkSubmit();
		WebElement f=driver.findElement(By.xpath("//div[@class='jconfirm-content']/div"));
		CheckElementDisplay(f,"SubmitAlert","Submit alert");
		log.info(Messages[0]);
		log.info(f.getText());
		boolean status=ChkTxt(f.getText(),Messages);
		CompareText(status,"Message","Submit alert text of popup is correct","Submit alert text of popup is not correct");
		WebElement g=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		action.clickButton(g, "Yes");
		WebElement w=driver.findElement(By.xpath("//div[@role='alertdialog']"));
		boolean status1=ChkTxt(w.getText(),Messages);		
		CompareText(status1,"SubmitSuccess","SubmitSuccess msg correct","SubmitSuccess msg not correct");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ClkSubmit_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}	
	
	public void ClkClose_ChkMsg() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		ClkCloseChase();
		WebElement f=driver.findElement(By.xpath("//div[@class='jconfirm-content']/div"));
		CheckElementDisplay(f,"CloseChaseAlert","Close Chase alert"); 
		boolean status=ChkTxt(f.getText(),Messages);
		CompareText(status,"Message","Close chase alert text of popup is correct","Close chase alert text of popup is not correct");
		WebElement g=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		action.clickButton(g, "Yes");	
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ClkClose_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}	
	
	
	public void ClkCxlChase_ChkMsg() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		action.clickButton(icra_elements.Move_MoveWindow, "CancelChase");
		WebElement f=driver.findElement(By.xpath("//div[@class='jconfirm-content']/div"));
		CheckElementDisplay(f,"CancelChaseAlert","CancelChaseAlert"); 
		boolean status=ChkTxt(f.getText(),Messages);
		CompareText(status,"CancelChaseAlert","CancelChaseAlert text of popup is correct","CancelChaseAlert text of popup is not correct");
		WebElement g=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		action.clickButton(g, "Yes");
		WebElement e=driver.findElement(By.xpath("//div[@role='alertdialog']"));
		CheckElementDisplay(e,"Cxl Chase Message", "Cxl Chase Success Message");	
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ClkCxlChase_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	  }
	
	public void ClkDeletePage_ChkMsg() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		action.clickButton(icra_elements.Move_MoveWindow, "Delete page");
		ChkMsg(Messages,"Delete Page Success","Delete page Success msg is correct","Delete page Success msg is not correct");
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ClkDeletePage_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	public void ClkFollowUpChase_ChkMsg() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Move_MoveWindow, "FollowUpChase");
		CheckElementDisplay(icra_elements.AlertMsg,"Follow Up Chase Message", "Follow Up Chase Success Message");	
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ClkFollowUpChase_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	public void ClkHoldChase_ChkMsg() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");	
		action.JSclickButton(icra_elements.Hold_HoldWin, "Hold_HoldWin");
		ChkMsg(Messages,"HoldChaseSuccess","HoldChaseSuccess msg correct","HoldChaseSuccess is not correct");
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ClkHoldChase_ChkMsg() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	public void ChkCloseButtonFunction() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Close_MoveWindow, "Close_MoveWindow");
		CheckElementDisplay(icra_elements.Move,"Move","Move");
		Extent_Reporting.Log_Message("Chked After Cliking Close button user is navigated to PDF detail screen or not", test, driver);
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ChkCloseButtonFunction() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	public void ChkClose_HoldWind() throws Exception
	{
		try
		{
		ClkClose_HoldWin();
		try
		{
		if(icra_elements.Hold_HoldWin.isDisplayed())
		{
			Extent_Reporting.Log_Fail(TC_ID,"Close button oF hold window not working", test, driver);
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_Pass(TC_ID,"Close button oF hold window working", test, driver);
		}
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ChkClose_HoldWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	public void ChkClose_CxlChaseFollwUpWind() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Close_MoveWindow, "Close_CxlChaseWindow");
		try
		{
		if(icra_elements.Reason_CancelChaseWin.isDisplayed())
		{
			Extent_Reporting.Log_Fail(TC_ID,"Close button oF Cancel Chase/Follow Up Window not working", test, driver);
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_Pass(TC_ID,"Close button oF Cancel Chase/Follow Up Window working", test, driver);
		}
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ChkClose_CxlChaseFollwUpWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
	}
	
	
	
	
	
	public String GetChaseId() throws Exception
	{
		String t=null;
		try
		{
		List<WebElement> row=driver.findElements(By.xpath("//tbody//tr"));
		for(int i=1;i<=row.size();i++)
		{
			WebElement w=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[11]"));
			action.Scroll(w);
			if(w.getText().isEmpty())
			{
				WebElement chase=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
				t=action.elementGetText(chase, "Chase");
				break;
			}	
		
	    }
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("GetChaseId() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
		return t;
	}
	
	public String GetChaseForDeletePag() throws Exception
	{
		String t=null;
		try
		{
		List<WebElement> row=driver.findElements(By.xpath("//tbody//tr"));
		for(int i=1;i<=row.size();i++)
		{
			WebElement w=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[11]"));
			WebElement w1=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[7]"));
			int page=Integer.parseInt(w1.getText());
			action.Scroll(w);
			if(w.getText().isEmpty() && page>1)
			{
				WebElement chase=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
				t=action.elementGetText(chase, "Chase");
				break;
			}	
		
	    }
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("GetChaseForDeletePag() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
		return t;
	}
	
	public String GetChaseId1(String chase) throws Exception
	{
		String t=null;
		try
		{
		List<WebElement> row=driver.findElements(By.xpath("//tbody//tr"));
		for(int i=1;i<=row.size();i++)
		{
			WebElement w=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[11]"));
			WebElement w1=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
			action.Scroll(w);
			if(w.getText().isEmpty() & (!w1.getText().contains(chase)))
			{
				WebElement c=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
				t=action.elementGetText(c, "Chase");	
				break;
			}	
		
	    }
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("GetChaseId1() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
		return t;
	}
	
	public void ClkDateReceviedCol() throws InterruptedException
	{
		WebElement Sort=driver.findElement(By.xpath("//thead//th[2]//p-sorticon/i"));
		action.clickButton(Sort, "Sort");
		Thread.sleep(4000);
		action.clickButton(Sort, "Sort");
		
	}
	public void ChkGridColmsDtaRecordQA() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"Fields").split(",");
		List<WebElement> col=driver.findElements(By.xpath("//thead//tr//th"));
		
		for(int i=1;i<=col.size();i++)
		{
			WebElement w=driver.findElement(By.xpath("//thead//tr//th["+i+"]//div//div"));
			CheckElementDisplay(w,"Grid_Col",w.getText());
			boolean status=ChkTxt(w.getText(),Messages);
			CompareText(status,"Grid_Col","text  is correct","text is not correct");
			WebElement fil=driver.findElement(By.xpath("//thead//th["+i+"]//div/i"));
			CheckElementDisplay(fil,"Grid_Filter_"+i+"",""+i+"  th filter");
			if(i>14)
			{
			 action.Scroll(driver.findElement(By.xpath("//thead//th["+i+"]//div/i"))); 
			}
			 WebElement sort=driver.findElement(By.xpath("//thead//th["+i+"]//p-sorticon"));			 
			 CheckElementDisplay(sort,"Grid_Sort_"+i+"",""+i+"  th sorting");			
			 action.clickButton(sort, "Sort");
			 WebElement ascSort=driver.findElement(By.xpath("//thead//th["+i+"]//p-sorticon/i[contains(@class,'up')]"));
			 CheckElementDisplay(ascSort,"Grid_AscSort_"+i+"",""+i+"  th Asc-sorting");	
			 action.clickButton(sort, "Sort");
			 WebElement dscSort=driver.findElement(By.xpath("//thead//th["+i+"]//p-sorticon/i[contains(@class,'down')]"));
			 CheckElementDisplay(dscSort,"Grid_dscSort__"+i+"",""+i+"  th dsc-sorting");
			}
		}
		catch(Exception e)
		   {
			Extent_Reporting.Log_FailMessage("ChkGridColmsDtaRecordQA() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		   }
		}
	
	
	
	public void ChkChaseDtlsScrren(String chase) throws Exception
	{
		//String chase=GetChaseId();
		try
		{
        SendTxtGolbalFilter(chase);
        String ProjectName=GetProName();
        String ProjectType=GetProType();
        String Mname=GetMemName();
        String MDOB=GetMemDob();
        String ProviderName=GetProvName();
        String NoPage=GetNoOfPages();
        String ChaseType=GetChaseType();        
        Extent_Reporting.Log_Message("Chase in grid:" + chase,test,driver);
        Extent_Reporting.Log_Message("PojectName in grid:" + ProjectName,test,driver);                
        Extent_Reporting.Log_Message("Project type in grid:" + ProjectType,test,driver);  
        Extent_Reporting.Log_Message("Memmber name in grid:" + Mname,test,driver);
        Extent_Reporting.Log_Message("Memmber Dob in grid:" + MDOB,test,driver);                
        Extent_Reporting.Log_Message("Provider name in grid:" + ProviderName,test,driver);  
        Extent_Reporting.Log_Message("Chase type in grid:" + ChaseType,test,driver);
        Extent_Reporting.Log_Message("Total pages in grid:" + NoPage,test,driver);
        ClkChase();
        ChkPDFOpenOrNot();
        action.defaultSwitch("Original window");
        String[] w= {chase,ProjectName,ProjectType,Mname,MDOB,ProviderName,ChaseType};       
        for(int i=2;i<=13;i++)
        {
        	if(i==7||i==9||i==11||i==13||i==12)
        	{
        		if(i==12)
        		{
        			log.info("Skip");
        		}
        		else
        		{
        		 WebElement a=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr["+i+"]/td[2]"));
            	 CheckElementDisplay(a,"ChaseDetail_"+i+"",a.getText());
        		}
        	}
        	else
        	{
        		if(i==10)
        		{
        			WebElement b=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr["+i+"]/td[3]"));
        			CheckElementDisplay(b,"ChaseDetail_"+i+"","View Original Link"); 
        		}
        		WebElement c=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr["+i+"]/td[2]"));
        		String txt=action.elementGetText(c, "msg");
        		boolean status=ChkTxt(txt,w);  
        		CompareText(status,"ChaseDetail_"+i+"","text  is correct","text is not correct");
        	}
        }
		}
        catch(Exception e)
 	   {
 		 Extent_Reporting.Log_FailMessage("ChkChaseDtlsScrren() failed - " + e.getMessage(), test, driver);
         throw new Exception(e.getMessage());
 	   }
	}
	
	public void ChkOthDetChaseScrren() throws Exception
	{
		try
		{
		String[] msg=ExcelHandling.GetExcelData(TC_ID,"Fields").split(",");
		for(int i=1;i<=10;i++)
        {
        	WebElement d=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr[14]//tr["+i+"]//input"));
			CheckElementDisplay(d,"Chkbox_"+i+"","Chkbox_"+i+"");
        	WebElement e=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr[14]//tr["+i+"]//td[1]"));
			CheckElementDisplay(e,"ChaseDetail_"+i+"",e.getText()); 
			String txt=action.elementGetText(e,"msg");
    		boolean status=ChkTxt(txt,msg);  
    		CompareText(status,"ChaseDetail_"+i+"","text  is correct","text is not correct");
    	 }
    	CheckElementDisplay(icra_elements.ChkBoxNoHCC,"ChkBoxNoHCC","ChkBoxNoHCC"); 
		String txt=action.elementGetText(icra_elements.NOHCCtext, "msg");
		boolean status=ChkTxt(txt,msg);
		CompareText(status,"NOHCCtext","NOHCC text  is correct","NOHCC textis not correct");
		CheckElementDisplay(icra_elements.ChkBoxReject,"ChkBoxReject","ChkBoxReject"); 
		String txt1=action.elementGetText(icra_elements.Rejecttext, "msg");
		boolean status1=ChkTxt(txt1,msg);  
		CompareText(status1,"RejectText","Reject text of is correct","Reject text is not correct");
		CheckElementDisplay(icra_elements.Move,"Move","Move");
		CheckElementDisplay(icra_elements.Copy,"Copy","Copy");
		action.ScrollToBottom();
		CheckElementDisplay(icra_elements.MovePage,"MovePage","MovePage");
		CheckElementDisplay(icra_elements.DeletePage,"DeletePage","DeletePage");
		CheckElementDisplay(icra_elements.FollowUp,"FollowUp","FollowUp");
		CheckElementDisplay(icra_elements.CancelChase,"CancelChase","CancelChase");
		CheckElementDisplay(icra_elements.Submit,"Submit","Submit");
		CheckElementDisplay(icra_elements.Close_RecordQA,"Close_RecordQA","Close_RecordQA");
		CheckElementDisplay(icra_elements.Hold,"Hold","Hold");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkOthDetChaseScrren() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkMoveCpyWind() throws Exception
	{
		try
		{
		CheckElementDisplay(icra_elements.FromPage,"FromPage","FromPage");
		CheckElementDisplay(icra_elements.ToPage,"ToPage","ToPage");
		CheckElementDisplay(icra_elements.MemberLastName,"MemberLastName","MemberLastName");
		CheckElementDisplay(icra_elements.ProviderLastName,"ProviderLastName","ProviderLastName");
		CheckElementDisplay(icra_elements.Search_MoveWindow,"Search_MoveWindow","Search_MoveWindow");
		CheckElementDisplay(icra_elements.Move_MoveWindow,"Move_MoveWindow","Move_MoveWindow");
		CheckElementDisplay(icra_elements.Close_MoveWindow,"Close_MoveWindow","Close_MoveWindow");
		WebElement e=driver.findElement(By.xpath("//div[@ref='gridPanel']"));
		CheckElementDisplay(e,"GridPanel","GridPanel");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMoveCpyWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkHoldScreenWind() throws Exception
	{
		try
		{
		CheckElementDisplay(icra_elements.Reason_HoldWin,"Reason_HoldWin","Reason_HoldWin");
		CheckElementDisplay(icra_elements.Comm_HoldWin,"Comm_HoldWin","Comm_HoldWin");
		CheckElementDisplay(icra_elements.MovePage,"MovePage","MovePage");
		CheckElementDisplay(icra_elements.DeletePage,"DeletePage","DeletePage");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkHoldScreenWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkMovePgeWind() throws Exception
	{
		try
		{
		CheckElementDisplay(icra_elements.FromPage_MovePageWin,"FromPage_MovePageWin","FromPage_MovePageWin");
		CheckElementDisplay(icra_elements.ToPage_MovePageWin,"ToPage_MovePageWin","ToPage_MovePageWin");
		CheckElementDisplay(icra_elements.Move_MoveWindow,"Move_MovePgeWindow","Move_MovePgeWindow");
		CheckElementDisplay(icra_elements.Close_MoveWindow,"Close_MovePgeWindow","Close_MovePgeWindow");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMovePgeWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkDeletePgeWind() throws Exception
	{
		try
		{
		CheckElementDisplay(icra_elements.DeletePages_DeletepgeWin,"DeletePages_DeletepgeWin","DeletePages_DeletepgeWin");
		CheckElementDisplay(icra_elements.Move_MoveWindow,"Delete_DeletePgeWin","Delete_DeletePgeWin");
		CheckElementDisplay(icra_elements.Close_MoveWindow,"Close_DeletePgeWin","Close_DeletePgeWin");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkDeletePgeWind() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public String[] GetChaseDetForCxl() throws Exception
	{
		String[] s=new String[9]; 
		try
		{
		for(int i=2;i<=10;i++)
	    {
	       	WebElement chase=driver.findElement(By.xpath("//table[contains(@class,'table allcp-form theme')]//tr["+i+"]/td[2]"));
	       	for(int u=0;u<=8;u++)
	        {
	        	if(s[u]!=null && s[u].length()>0)
	        	{
	        		log.info("** Skip **");	        		
	        	}
	        	else
	        	{
	        		s[u]=chase.getText();
	        		break;
	        	}
	        }
	      }
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("GetChaseDetForCxl() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
		return s;
	    }
		
	
	
	public void ChkCxlChaseOrFollowUpWin(String[] w) throws Exception
    {
		try
		{
		for(int i=1;i<=4;i++)
	    {
	      if(i==2||i==3)
	      {
	    	WebElement a=driver.findElement(By.xpath("//div[contains(@class,'modal-body')]//tr["+i+"]/td[2]"));
		    boolean status=ChkTxt(a.getText(),w);
		    CompareText(status,"CancelChaseDetail_"+i+"",""+a.getText()+" is correct","text is not correct");	
	    	WebElement dob=driver.findElement(By.xpath("//div[contains(@class,'modal-body')]//tr["+i+"]/td[4]"));
		    boolean status1=ChkTxt(dob.getText(),w);
		    CompareText(status1,"CancelChaseDetail_"+i+"",""+dob.getText()+" is correct","text is not correct");	
	      }
	      else 
	      {
	    	WebElement a=driver.findElement(By.xpath("//div[contains(@class,'modal-body')]//tr["+i+"]/td[2]"));
	    	boolean status=ChkTxt(a.getText(),w);
	    	CompareText(status,"CancelChaseDetail_"+i+"",""+a.getText()+" is correct","text is not correct");	 	  
	      }
	    }
		CheckElementDisplay(icra_elements.Reason_CancelChaseWin,"Reason","Reason");
		CheckElementDisplay(icra_elements.Comm_CancelChaseWin,"Com","Com");
		if(TC_ID.contains("Cancel"))
		{
		 CheckElementDisplay(icra_elements.Move_MoveWindow,"CxlChase","CancelChase");
		 CheckElementDisplay(icra_elements.Close_MoveWindow,"Close_CancelChaseWin","Close_CancelChaseWin");
		}
		else
		{
		 CheckElementDisplay(icra_elements.Move_MoveWindow,"FollowUpChase","FollowUpChase");
		 CheckElementDisplay(icra_elements.Close_MoveWindow,"Close_FollowUpChaseWin","Close_FollowUpChaseWin");
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkCxlChaseOrFollowUpWin() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkMandMsg_FillDtaMoveCopy(String a,String b,String c) throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		if(TC_ID.contains("Move"))
		{
		  ClkMove();
		  action.clickButton(icra_elements.Close_MoveWindow, "Close_MoveWindow");
		  CheckElementDisplay(icra_elements.Move,"Move","Move");
		  Extent_Reporting.Log_Message("Chked After Cliking Close button user is navigated to PDF detail screen or not", test, driver);
		  ClkMove();
		}
		else if(TC_ID.contains("Copy"))
		{
		  ClkCopy();
		  action.clickButton(icra_elements.Close_MoveWindow, "Close_MoveWindow");
		  CheckElementDisplay(icra_elements.Move,"Move","Move");
		  Extent_Reporting.Log_Message("Chked After Cliking Close button user is navigated to PDF detail screen or not", test, driver);
		  ClkCopy();
		}			
		ChkMoveCpyWind();
		action.clickButton(icra_elements.Move_MoveWindow, "Move_MoveWindow");
		WebElement w=driver.findElement(By.xpath("//input[@formcontrolname='FromPage']/parent::td/div"));
		CheckElementDisplay(w,"Message","Message");
		boolean status=ChkTxt(w.getText(),Messages);
		CompareText(status,"FromPageErrMsg","From page error message is correct","From page error message is not correct");
		WebElement w1=driver.findElement(By.xpath("//input[@formcontrolname='ToPage']/parent::td/div"));
		CheckElementDisplay(w1,"Message","Message");
		boolean status1=ChkTxt(w1.getText(),Messages);
		CompareText(status1,"ToPageErrMsg","To page error message is correct","To page error message is not correct");	
		action.clickButton(icra_elements.Search_MoveWindow, "Search_MoveWindow");
		CheckElementDisplay(icra_elements.AlertMsg,"Message","Message");
		boolean status2=ChkTxt(icra_elements.AlertMsg.getText(),Messages);
		CompareText(status2,"SerachAlertMsg","Alert message is correct","Alert message is not correct");
		action.inputText(icra_elements.FromPage,"1","FromPage");
		action.inputText(icra_elements.ToPage,"1","ToPage");
		action.inputText(icra_elements.MemberLastName,a,"MLastName");
		action.inputText(icra_elements.ProviderLastName,b,"PlastName");
		action.clickButton(icra_elements.Search_MoveWindow, "Search_MoveWindow");
		action.clickButton(icra_elements.Move_MoveWindow, "Move_MoveWindow");
		CheckElementDisplay(icra_elements.AlertMsg,"Message","Message");
		boolean status3=ChkTxt(icra_elements.AlertMsg.getText(),Messages);
		CompareText(status3,"AlertMsg_MoveWindow","AlertMsg_MoveWindow is correct","AlertMsg_MoveWindow is not correct");
		List<WebElement> row=driver.findElements(By.xpath("//div[@ref='eCenterContainer']/div"));
		for(int i=2;i<=row.size()+1;i++)
		{
			WebElement ch=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//div[@aria-rowindex='"+i+"']//div[@col-id='ChaseId']"));
			log.info(c);
			log.info(ch.getText());
			if(ch.getText().trim().equals(c))
			{
				log.info("++++++++++++++++++++++");
				WebElement radio=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//input[@value='"+c+"']"));
				action.clickButton(radio, "Radio_MoveWindow");
				log.info("==========================================================");
				break;
			}
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMandMsg_FillDtaMoveCopy() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}	
	
	public void ChkMandMsg_FillDtaMovepage() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		action.clickButton(icra_elements.Move_MoveWindow,"Move_MovePgeWindow");
		WebElement w=driver.findElement(By.xpath("//input[@formcontrolname='MoveFrom']/parent::td/div"));
		CheckElementDisplay(w,"Message","Message");		
		boolean status=ChkTxt(w.getText(),Messages);
		CompareText(status,"FromPageErrMsg_MovePageWindow","From page error message of move page is correct",
				"From page error message of move page is not correct");
		WebElement w1=driver.findElement(By.xpath("//input[@formcontrolname='MoveTo']/parent::td/div"));
		CheckElementDisplay(w1,"Message","Message");
		boolean status1=ChkTxt(w1.getText(),Messages);
		CompareText(status1,"ToPageErrMsg_MovePageWindow","To page error message of move page is correct",
				"To page error message of move page is not correct");
//		action.inputText(icra_elements.FromPage_MovePageWin, "1", "From_MovePage");
//		action.inputText(icra_elements.ToPage_MovePageWin, "1", "To_MovePage");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMandMsg_Movepage() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkMandMsg_FillDtaDeletePage() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		action.clickButton(icra_elements.Move_MoveWindow,"Move_MovePgeWindow");
		WebElement w=driver.findElement(By.xpath("//input[@formcontrolname='DeletePages']/parent::td/div"));
		CheckElementDisplay(w,"Message","Message");		
		boolean status=ChkTxt(w.getText(),Messages);
		CompareText(status,"FromPageErrMsg_MovePageWindow","Delete page error message of Delete page is correct",
				"Delete page error message of Delete page is not correct");
		action.inputText(icra_elements.DeletePages_DeletepgeWin, "1", "Delete Page no");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMandMsg_FillDtaDeletePage() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
					
	}
	
	public void ChkMandMsg_FillDtaHoldChase() throws Exception 
	{
		try
		{
		String[] msg=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		ClkHold_HoldWin();
		ChkMsg(msg, "HoldReasonalert", "HoldReasonalert is correct", "HoldReasonalert is not correct");
		Reason=ExcelHandling.GetExcelData(TC_ID,"Reason_CancelChaseWin");
		action.selectDDByText(icra_elements.Reason_HoldWin, Reason);
		action.inputText(icra_elements.Comm_HoldWin, "Ok", "Comm_HoldWin");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMandMsg_FillDtaHoldChase() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	public void ChkMandMsg_FillDtaCxlOrFollowUpChase() throws Exception
	{
		try
		{
		String[] Messages=ExcelHandling.GetExcelData(TC_ID,"AllMessages").split(",");
		Reason=ExcelHandling.GetExcelData(TC_ID,"Reason_CancelChaseWin");
		action.clickButton(icra_elements.Move_MoveWindow, "CancelChase");
		WebElement z=driver.findElement(By.xpath("//label//following-sibling::div[contains(@class,'invalid-feedback')]/div"));
		CheckElementDisplay(z,"Reasonmsg_CancelChaseWindow","Reasonmsg_CancelChaseWindow");
		boolean status=ChkTxt(z.getText(),Messages);
		CompareText(status,"Reasonmsg_CancelChaseWindow","Reasonmsg_CancelChaseWindow is correct","Reasonmsg_CancelChaseWindow is not correct");
		WebElement z1=driver.findElement(By.xpath("//textarea//following-sibling::div[contains(@class,'invalid-feedback')]/div"));
		CheckElementDisplay(z1,"Commmsg_CancelChaseWindow","Commmsg_CancelChaseWindow");
		boolean status1=ChkTxt(z1.getText(),Messages);
		CompareText(status1,"Commmsg_CancelChaseWindow","Commmsg_CancelChaseWindow is correct","Commmsg_CancelChaseWindow is not correct");
		action.selectDDByText(icra_elements.Reason_CancelChaseWin,Reason);
		action.inputText(icra_elements.Comm_CancelChaseWin,"Ok", "Comm_CancelChaseWin");
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkMandMsg_FillDtaCxlOrFollowUpChase() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	public boolean ChkRecordQAApproval(String Chaseid,String req) throws Exception
	{
		boolean status=false;
		try
		{
		List rows=driver.findElements(By.xpath("//div[@ref='eCenterContainer']/div"));
		List col=driver.findElements(By.xpath("//div[@ref='eCenterContainer']/div[1]/div"));
		for(int i=1;i<=rows.size();i++)
		{
			WebElement chase=driver.findElement(By.xpath("//div[@ref='eCenterContainer']/div["+i+"]/div[2]"));
			WebElement ReqFor=driver.findElement(By.xpath("//div[@ref='eCenterContainer']/div["+i+"]/div[9]"));
			if(chase.getText().contains(Chaseid) && ReqFor.getText().contains(req))
			{
				status=true;
			}
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkRecordQAApproval() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
		return status;
	}	
	public void ChkHoldQueueBucket(String Chaseid,String HoldRea,String HoldCom) throws Exception
	{		
		try
		{
		WebElement chase=driver.findElement(By.xpath("//tbody//tr//td[3]"));
		WebElement HoldReason=driver.findElement(By.xpath("//tbody//tr//td[15]"));
		WebElement HoldComment=driver.findElement(By.xpath("//tbody//tr//td[16]"));
		log.info(chase.getText());
		log.info(HoldReason.getText());
		log.info(HoldComment.getText());
		if(chase.getText().contains(Chaseid) && HoldReason.getText().contains(HoldRea) && HoldComment.getText().contains(HoldCom))
		{
			Extent_Reporting.Log_Pass("HoldBucketTbl","Chase,Hold Comment and Hold Reasonr is correct in Hold Bucket", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("HoldBucketTbl","Chase,Hold Comment and Hold Reasonr is not correct in Hold Bucket", test, driver);
		}
		}
		catch(Exception e)
		{
			Extent_Reporting.Log_FailMessage("ChkHoldQueueBucket() failed - " + e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
		
	}	
	
}
	
	
        



 
	
	