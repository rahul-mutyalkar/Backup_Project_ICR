package com.qa.BusinessLogic;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.PageObjects.ICRA_PageObjects_Niketan;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;


public class AddressAllocationActions_Niketan extends Extent_Reporting
{

	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Niketan icra_elements;
	String Agent="";
	String Zipid="";
	String addresscount="";	
	String TotalUnTouchAddressCount="";
	String TotalChaseCount="";
	String ChaseCount="";
	String xpath="";
	String ageentnameoftable="";	
	int AreaADD;
	int AreaChase;
	String Araid1;
	String Araid2;
	String SummaryADDCnt1="";
	String SummaryADDCnt2="";
	String TotalUntouchedADDCount="";    //Total Untouched Address Count Of Summary Table after allocation 
    String TotalChaCount="";
    String AraADD1Cnt;
    //String SummaryADDChase;
	

	

	public AddressAllocationActions_Niketan(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Niketan(driver);
	}
	
	public void PageLoad(int time,long t)
	{
		for(int i=1;i<=time;i++)
		{
			driver.manage().timeouts().pageLoadTimeout(t, TimeUnit.SECONDS);
		}
	}
	
	public void ClkViewByAreaRadio() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.ViewByAreaRadioButton,"ViewByAreaRadioButton");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ClkAreaCodeRadio() throws Exception
	{
		try
		{
			action.clickButton(icra_elements.AllocateAreaCodeRadio, "Area Code Radio Button");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClkAreaCodeRadio() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public String[] GetZipCntOfHeader() throws Exception
	{
		String[] ZipCntHeader1=new String[2];
		try
		{
			String ZipCntHeader=driver.findElement(By.xpath("//input[@name='AllocateByZip']//parent::li/parent::ul/li[2]")).getText();	
			ZipCntHeader1=ZipCntHeader.split(":");
		}	
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("GetZipCntOfHeader() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return ZipCntHeader1;
	}
	
	
	public String[] GetAdrCntOfHeader() throws Exception
	{
		String[] AdrCntHeader1=new String[2];
		try
		{
			String AdrCntHeader=driver.findElement(By.xpath("//ul[@class='address-details-ul']/li[3]")).getText();	
		    AdrCntHeader1=AdrCntHeader.split(":");
		}    
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("GetAdrCntOfHeader() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return AdrCntHeader1;
	}
	
	public String[] GetChaseCntOfHeader() throws Exception
	{
		String[] ChaseCntHeader1=new String[2];
		try
		{
		String ChaseCntHeader=driver.findElement(By.xpath("//ul[@class='address-details-ul']/li[4]")).getText();
		ChaseCntHeader1=ChaseCntHeader.split(":");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("GetChaseCntOfHeader() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return ChaseCntHeader1;
	}
	
	
	public void Click1stZipCodecheckbox() throws Exception
	{
		try
		{
		WebElement Zipcheckbox=driver.findElement(By.xpath("//div[@class='row pr10']/div[3]//div//tbody/tr[1]/td[1]/p-tablecheckbox"));		
		action.clickButton(Zipcheckbox, "Zip code");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Click1stZipCodecheckbox() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public String Get1stRecordZipId() throws Exception
	{
		String id="0";
		try
		{
		  id=driver.findElement(By.xpath("//div[@class='row pr10']/div[3]//div//tbody/tr[1]/td[2]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecordZipId() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return id;
	}
	
	public String Get1stRecordChaseCount() throws Exception
	{
		String cnt="0";
		try
		{
		   cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[3]//div//tbody/tr[1]/td[4]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecordChaseCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
		
	public String Get1stRecordAddressCount() throws Exception
	{
		String cnt="0";
		try
		{
		  cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[3]//div//tbody/tr[1]/td[3]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecordAddressCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
	
	
	public String Get1stRecordAreaId() throws Exception
	{
		String id="0";
		try
		{
		   id=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[1]/td[2]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecordAreaId() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return id;
	}
	
	public String Get1stRecAreaChaseCount() throws Exception
	{
		String cnt="0";
		try
		{
		  cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[1]/td[4]")).getText();	
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecAreaChaseCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
		
	public String Get1stRecAreaAddressCount() throws Exception
	{
		String cnt="0";
		try
		{
		  cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[1]/td[3]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get1stRecAreaAddressCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
	
	public String Get2ndRecordAreaId() throws Exception
	{
		String id="0";
		try
		{
		  id=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[2]/td[2]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get2ndRecordAreaId() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return id;
	}
	
	public String Get2ndRecAreaChaseCount() throws Exception
	{
		String cnt="0";
		try
		{
		  cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[2]/td[4]")).getText();
		}
		catch(Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get2ndRecAreaChaseCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
		
	public String Get2ndRecAreaAddressCount() throws Exception
	{
		String cnt="0";
		try
		{
		  cnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[2]/td[3]")).getText();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("Get2ndRecAreaAddressCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return cnt;
	}
	
	public void EnterAgent(String name) throws Exception
	{
		try
		{
		  action.clickButton(icra_elements.AgentList, "Agent");
		  PageLoad(1000,20000000);
		  WebElement text=driver.findElement(By.xpath("//option[contains(text(),'"+name+"')]"));
		  action.clickButton(text, "AgentName");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("EnterAgent() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ClickAllocate() throws Exception
	{
		try
		{
			action.clickButton(icra_elements.AllocateButton, "Allocate");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClickAllocate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ClickRemove() throws Exception
	{
		try
		{
			action.JSclickButton(icra_elements.Remove, "Remove");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClickRemove() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
		
	public void ClickReassignButton() throws Exception
	{
		try
		{
			action.JSclickButton(icra_elements.Reassign,"Reassign");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClickReassignButton() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	 public void ClickAgent(String Agent) throws Exception
	 {
	   	try
	   	{
	   		WebElement Sign =driver.findElement(By.xpath("//td[contains(text(),'"+Agent+"')]/preceding-sibling::td//i"));
	   	 	action.ScrollToBottom();
	    	action.clickButton(Sign, "Sign");
	   	}
	   	catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClickAgent() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public void ClkFltSpecHandling() throws Exception
	 {
	   	try
	   	{
	   		action.clickButton(icra_elements.FilterSpecHandChk, "FilterSpecHandChk");
	   	}
	   	catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClkFltSpecHandling() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	 }
	 
	 
	public void VerfiyAlerts(String ExpectedText,WebElement xpath) throws Exception {
		
		try
		{
		   if(xpath.getText().equals(ExpectedText))		
		   {
			Extent_Reporting.Log_Pass("AlertText","Text Is Correct" , test, driver);			
		   }
		   else
		   {
			Extent_Reporting.Log_Fail("AlertText","Text Is Not Correct" , test, driver);
		    }
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("VerfiyAlerts() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkCnt(int actual,int expected,String CntName,String msg,String msg1) throws Exception
	{
		try
		{if(String.valueOf(actual).trim().equals(String.valueOf(expected).trim()))
		{
			Extent_Reporting.Log_Pass(CntName,msg,test,driver);
		}
		else
		{
			Extent_Reporting.Log_Fail(CntName,msg1,test,driver);
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkCnt() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkElement(WebElement w,String ScrScn,String msg,String msg1) throws Exception
	{
		try
		{if(w.isDisplayed())
		{
			Extent_Reporting.Log_Pass(ScrScn,msg,test,driver);
		}
		else
		{
			Extent_Reporting.Log_Fail(ScrScn,msg1,test,driver);
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkElement() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
		
	public boolean ChkAdrCntField() throws Exception
	{
		boolean flag=false;
		try
		{
		 flag=icra_elements.AllocateCountBox.isEnabled();
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkAdrCntField() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return flag;
	}
	
	
	////Method to Select Agent In Reassign window
	public void SelectAgentInReassiWin(String agent) throws Exception
	{
		try
		{
		List Rows=driver.findElements(By.xpath("//div[contains(@class,'ng-tns')]//nz-spin//tbody/tr"));
		 for(int i=1;i<=Rows.size();i++)
		 {
			 String u=driver.findElement(By.xpath("//div[contains(@class,'ng-tns')]//tbody/tr["+i+"]")).getText().trim();
			 if(u.contains("Untouched"))
			 {
				 WebElement w1=driver.findElement(By.xpath("//div[contains(@class,'ng-tns')]//tbody/tr["+i+"]/td[4]//select"));
				 action.clickButton(w1, "Agent_Reassign");
				 PageLoad(500,10000000);
				 WebElement text=driver.findElement(By.xpath("//div[contains(@class,'ng-tns')]//tbody/tr["+i+"]/td[4]//option[contains(text(),'"+agent+"')]"));
				 action.clickButton(text, "AgentName");		
			 }
		 }
		}
		 catch (Exception e)
		  {
	            Extent_Reporting.Log_FailMessage("SelectAgentInReassiWin() failed", test, driver);
				throw new Exception(e.getMessage());
		  }
	}
	
	////Method to Check Header Elements are displaying or not.
	public void ChkHeaderElements() throws Exception
	{
		try
		{ChkElement(icra_elements.ProjectType,"ProjectTypDropdwn","ProjectTypDropdwn is displayed","ProjectTypDropdwn is not displayed");
		ChkElement(icra_elements.State,"State","State dropdown is displayed","State dropdown is not displayed");
		ChkElement(icra_elements.SpecHandDropDown,"SpecHandDropDown","SpecHandDropDown is displayed","SpecHandDropDown is not displayed");
		ChkElement(icra_elements.FilterSpecHandChk,"FilterSpecHandChk","FilterSpecHand Checkbox is displayed","FilterSpecHand Checkbox is not displayed");
		ChkElement(icra_elements.AllocateAreaCodeRadio,"AllocateAreaCodeRadio","AllocateAreaCodeRadio is displayed","AllocateAreaCodeRadio is not displayed");
		if(icra_elements.AllocateZipCodeRadio.isSelected())
		{
			Extent_Reporting.Log_Pass("AllocateZipCodeRadio","AllocateZipCodeRadio is selected",test,driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("AllocateZipCodeRadio","AllocateZipCodeRadio is not selected",test,driver);
		}
		if(icra_elements.ViewByZipRadioButton.isSelected())
		{
			Extent_Reporting.Log_Pass("ViewByZipRadioButton","ViewByZipRadioButton is selected",test,driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("AllocateZipCodeRadio","ViewByZipRadioButton is not selected",test,driver);
		}
		if(icra_elements.SpecHandDropDown.isEnabled())
		{
			Extent_Reporting.Log_Fail("AllocateZipCodeRadio","SpecHandDropDown is not disable",test,driver);
		}
		else
		{
			Extent_Reporting.Log_Pass("SpecHandDropDown","SpecHandDropDown is disable",test,driver);
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkHeaderElements() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	//Method to Check zip code table coloums 
//	public void ChkZipCodetable()
//	{
//		List col=driver.findElements(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th"));
//		for(int i=1;i<=col.size();i++)
//		{
//			WebElement title=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th["+i+"]//span[contains(@class,'title')]"));
//			ChkElement(title,"tbl",""+i+"th column is displayed",""+i+"th column is not displayed");
//			WebElement Sorticon=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th["+i+"]//p-sorticon"));
//			ChkElement(Sorticon,"Sorticon",""+i+"th Sorting icon is displayed",""+i+"th Sorting icon is not displayed");		
//		}
//		WebElement code=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//thead//tr[2]/th[2]//div[1]/span"));
//		ChkElement(code,"ZipCodeTextBox","ZipCodeTextBox is displayed","ZipCodeTextBox is not displayed");
//		
//	}
	
	public void ChkZipCodetable() throws Exception
	{
		try
		{List col=driver.findElements(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th"));
		for(int i=1;i<=col.size();i++)
		{
			WebElement title=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th["+i+"]//span[contains(@class,'title')]"));
			ChkElement(title,"tbl",""+i+"th column is displayed",""+i+"th column is not displayed");
			
			WebElement Sorticon=driver.findElement(By.xpath("//*[@id=\"form-ui\"]//div[3]//th["+i+"]//p-sorticon"));
			
			ChkElement(Sorticon,"Sorticon",""+i+"th Sorting icon is displayed",""+i+"th Sorting icon is not displayed");		
		}
		WebElement code=driver.findElement(By.xpath("//*[@id='form-ui']//div[3]//tr[2]//span[contains(text(),'Zip Code')]"));		
		ChkElement(code,"ZipCodeTextBox","ZipCodeTextBox is displayed","ZipCodeTextBox is not displayed");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkZipCodetable() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	//Method to Check Area code table coloums
	public void ChkAreaCodetable() throws Exception
	{
		try
		{List col=driver.findElements(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[4]//tr[1]/th"));
		for(int i=1;i<=col.size();i++)
		{
			WebElement title=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[4]//tr[1]/th["+i+"]//span[contains(@class,'title')]"));
			                                            
			ChkElement(title,"tbl",""+i+"th column is displayed",""+i+"th column is not displayed");
			WebElement Sorticon=driver.findElement(By.xpath("//*[@id=\"form-ui\"]//div[4]//th["+i+"]//p-sorticon"));
			ChkElement(Sorticon,"Sorticon",""+i+"th Sorting icon is displayed",""+i+"th Sorting icon is not displayed");		
		}
		WebElement code=driver.findElement(By.xpath("//*[@id='form-ui']//div[4]//tr[2]//span[contains(text(),'Area Code')]"));
		ChkElement(code,"AreaCodeTextBox","AreaCodeTextBox is displayed","AreaCodeTextBox is not displayed");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkAreaCodetable() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	//Method to Check Summary code table colums are display or not
	public void ChkSummaryable() throws Exception
	{
		try
		{List col=driver.findElements(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//tr[1]/th"));
		for(int i=2;i<=col.size()-1;i++)
		{
			WebElement title=driver.findElement(By.xpath("//p-table[@datakey='Agent']//thead/tr[1]/th[2]//div/span"));
			ChkElement(title,"tbl",""+i+"th column is displayed",""+i+"th column is not displayed");
		}
		WebElement code=driver.findElement(By.xpath("//p-multiselect[@defaultlabel='Agent']//span[contains(text(),'Agent')]"));
		ChkElement(code,"AgentTextBox","AgentTextBox is displayed","AgentTextBox is not displayed");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkSummaryable() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	//Method to Check Zip code table is disable or not when area code radio button is selected
	public void ChkZiptablevisibility() throws Exception
	{
		try{
			WebElement w=driver.findElement(By.xpath("//*[@id=\"form-ui\"]//div[3]/p-table/div/div[2]"));		
		ChkElement(w,"ZipCodetbl","Zip Code table is disable","Zip Code table is not disable");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkZiptablevisibility() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	//Method to Check Area code table is disable or not when zip code radio button is selected
	public void ChkAreatablevisibility() throws Exception
	{
		try
		{
		WebElement w=driver.findElement(By.xpath("//*[@id=\"form-ui\"]//div[4]/p-table/div/div[2]"));
		ChkElement(w,"AreaCodetbl","Area Code table is disable","Area Code table is not disable");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkAreatablevisibility() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	//Method to Check Other elements or button is displayed or not.
	public void ChkOtherButtons() throws Exception
	{
		try
		{		
		ChkElement(icra_elements.AgentList,"AgentList","Agent Dropdown is displayed","Agent Dropdown is not displayed");
		ChkElement(icra_elements.AllocateCountBox,"AllocateCountBox","Allocate Count Box is displayed","Allocate Count Box is not displayed");
		ChkElement(icra_elements.Codetextbox,"Codetextbox","Code text box is displayed","Code text box is not displayed");
		ChkElement(icra_elements.AllocateButton,"AllocateButton","Allocate Button  is displayed","Allocate Button is not displayed");
		ChkElement(icra_elements.Reassign,"Reassign","Reassign button is displayed","Reassign button is not displayed");
		ChkElement(icra_elements.Remove,"Remove","Remove button is displayed","Remove button is not displayed");
		ChkElement(icra_elements.ViewByAreaRadioButton,"ViewByAreaRadioButton","ViewByAreaRadio Button is displayed","ViewByAreaRadio Button is not displayed");
		ChkElement(icra_elements.ViewByZipRadioButton,"ViewByZipRadioButton","ViewByZipRadioButton is displayed","ViewByZipRadio Button is not displayed");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkOtherButtons() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkReassignAlertMsg() throws Exception
	{
		try
		{
		ClickReassignButton();
		Thread.sleep(2000);
		VerfiyAlerts("Please select atleast one Address count",icra_elements.AlertMsg);
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkReassignAlertMsg() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}	
	
	//Method to Check Special handling dropdown is enable or not after selecting FilterSpecHandChkBox	
	public void ChkSpecHandDrpAftrClkFlterChkBox() throws Exception
	{
		try
		{
		ClkFltSpecHandling();
		if(icra_elements.SpecHandDropDown.isEnabled())
		{	
			Extent_Reporting.Log_Pass("SpecHandDropDown","SpecHandDropDown is enable",test,driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("AllocateZipCodeRadio","ViewByZipRadioButton is not enable",test,driver);
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkSpecHandDrpAftrClkFlterChkBox() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	//Method to assign zip code and Check Zip,Address,Chase Count present in Header 	
	public String[] AssignZip_ChkHdrCnt() throws Exception
	{
		String[] zipdet=new String[3];
		try
	   	{
		String[] ZipCntHeader=GetZipCntOfHeader();
		String[] AdrCntHeader=GetAdrCntOfHeader();
		String[] ChaseCntHeader=GetChaseCntOfHeader();
		Extent_Reporting.Log_Message("Zip Code,Address Count,Chase Count In Heading Is Taken Before Allocation",test,driver);		
		ClickAllocate();
		VerfiyAlerts("Please select Zip code or Area code",icra_elements.AlertMsg);
		addresscount=Get1stRecordAddressCount();
		Zipid=Get1stRecordZipId();
		ChaseCount=Get1stRecordChaseCount();
		zipdet[0]=Get1stRecordAddressCount();
		zipdet[1]=Get1stRecordZipId();
		zipdet[2]=ChaseCount;
		Extent_Reporting.Log_Message("Zip Code,Address Count,Chase Count In Zip Code Table Is Taken Before Allocation",test,driver);		
		Click1stZipCodecheckbox();		
		Agent=ExcelHandling.GetExcelData(TC_ID, "Agent");
		EnterAgent(Agent);		
		ClickAllocate();
		Thread.sleep(4000);
		VerfiyAlerts(""+zipdet[0]+" Address allocated successfully.",icra_elements.AlertMsg);	
		Extent_Reporting.Log_Message("======== ZipCode is allocated =============",test,driver);
		PageLoad(500,10000000);
		String[] ZipCntHeader1=GetZipCntOfHeader();
		String[] AdrCntHeader1=GetAdrCntOfHeader();
		String[] ChaseCntHeader1=GetChaseCntOfHeader();
		Extent_Reporting.Log_Message("Zip Code,Address Count,Chase Count In Heading Is Taken After Allocation",test,driver);		
		ChkCnt(Integer.parseInt(ZipCntHeader1[1].trim()),Integer.parseInt(ZipCntHeader[1].trim())-1,
				"ZipHdrCnt","Count of zip in header is correct","Count of zip in header is not correct");
		ChkCnt(Integer.parseInt(AdrCntHeader1[1].trim()),Integer.parseInt(AdrCntHeader[1].trim())-Integer.parseInt(addresscount),
				"AdrHdrCnt","Count of Address in header is correct","Count of Address in header is not correct");
		ChkCnt(Integer.parseInt(ChaseCntHeader1[1].trim()),Integer.parseInt(ChaseCntHeader[1].trim())-Integer.parseInt(ChaseCount),
				"ChaHdrCnt","Count of Chases in header is correct","Count of Chases in header is not correct");
	   	}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("AssignZip_ChkHdrCnt() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return zipdet;
	}	
	
	//Method to assign Area code and Check Area,Address,Chase Count present in Header 
	public String[] AssignArea_ChkHdrCnt() throws Exception
	{
		String[] AreDet=new String[5];
		try
		{
		String Agent=ExcelHandling.GetExcelData(TC_ID, "Agent");
		WebElement AreaCodecheckbox1=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[1]/td[1]/p-tablecheckbox"));		
		action.clickButton(AreaCodecheckbox1, "Area code1");
		Araid1=Get1stRecordAreaId();
		Araid2=Get2ndRecordAreaId();
		String AraCha1Cnt=Get1stRecAreaChaseCount();
		String AraCha2Cnt=Get2ndRecAreaChaseCount();
		ChkCnt(Integer.parseInt(icra_elements.Codetextbox.getAttribute("value").toString()),Integer.parseInt(Araid1),"iDS",
				"Code is displayed","Code is not displayed");  //Selected Code Must be display in Allocate code textbox
		boolean flag=ChkAdrCntField();                         // Checking of Allocate Count box
		if(flag)
		{
			Extent_Reporting.Log_Pass("AllocateCntBox","Allocate Count is enabled",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("AllocateCntBox","Allocate Count is not enabled",test, driver);
		}
		action.clickButton(AreaCodecheckbox1, "Area code1");
		if(icra_elements.Codetextbox.getAttribute("value").isEmpty())
		{
			Extent_Reporting.Log_Pass("CodeTextBox","Code textbox is blank",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("CodeTextBox","Code textbox is not blank",test, driver);
		}
		action.clickButton(AreaCodecheckbox1, "Area code1");
		WebElement AreaCodecheckbox2=driver.findElement(By.xpath("//div[@class='row pr10']/div[4]//div//tbody/tr[2]/td[1]/p-tablecheckbox"));		
		action.clickButton(AreaCodecheckbox2, "Area code2");
		boolean flag1=ChkAdrCntField();
		if(!flag1)
		{
			Extent_Reporting.Log_Pass("AllocateCntBox","Allocate Count is disable",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("AllocateCntBox","Allocate Count is not disable",test, driver);
		}
		AreDet[0]=Get1stRecordAreaId();                  //1st Record Area id
		AreDet[1]=Get2ndRecordAreaId();                  //2nd Record Area id
		AreDet[2]=Get1stRecAreaAddressCount();           //1st Record Address Count  
		AreDet[3]=Get2ndRecAreaAddressCount();	         //2nd Record Address Count
		AreDet[4]=AraCha1Cnt;                            //We will use for validation in reassign flow.
		Extent_Reporting.Log_Message("Taken All counts Of 1st Two Records In Area Code Table",test,driver);
		String[] AreaCodeHeaderCnt=driver.findElement(By.xpath("//div[@class='row pr10']/div[2]//li[2]")).getText().split(":");
		String AdHeader[]=GetAdrCntOfHeader();
		String ChHeader[]=GetChaseCntOfHeader();
		Extent_Reporting.Log_Message("Total Area Codes Count In Header Before Assign is:" +AreaCodeHeaderCnt[1],test,driver);
		Extent_Reporting.Log_Message("Total Addresses In Header Before Assign is:" +AdHeader[1],test,driver);
		Extent_Reporting.Log_Message("Total Chasees In Header Before Assign is:" +ChHeader[1],test,driver);
		Extent_Reporting.Log_Message("1st Area Address Count is:"+AreDet[2],test,driver);
		Extent_Reporting.Log_Message("2nd Area Address Count is:"+AreDet[3],test,driver);
		AreaADD=Integer.parseInt(AreDet[2])+Integer.parseInt(AreDet[3]);
		/***********Here we convert again into string and give to Addresscount variable for later use in ChkTtlCntInSum method**********/
		addresscount=String.valueOf(AreaADD);
		AreaChase=Integer.parseInt(AraCha1Cnt)+Integer.parseInt(AraCha2Cnt);
		/***********Here we convert again into string and give to ChaseCount variable for later use in ChkTtlCntInSum method**********/
		ChaseCount=String.valueOf(AreaChase);
		String Allocatecnt=icra_elements.AllocateCountBox.getAttribute("value");
		if(Allocatecnt.trim().equals(String.valueOf(AreaADD).trim()))
		{
		   Extent_Reporting.Log_Pass("Count_AreaCodes","Allocate Count and Total Address Count is Equal",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("Count_AreaCodes","Allocate and Total Address Count is not Equal",test, driver);
		}
		EnterAgent(Agent);		
		ClickAllocate();
		Thread.sleep(5000);
		VerfiyAlerts(""+AreaADD+" Address allocated successfully.",icra_elements.AlertMsg);	
		Extent_Reporting.Log_Message("======== AreaCode is allocated =============",test,driver);
		PageLoad(1000,20000000);
		String[] AreaCodesHeaderCnt1=driver.findElement(By.xpath("//div[@class='row pr10']/div[2]//li[2]")).getText().split(":");
		ChkCnt(Integer.parseInt(AreaCodesHeaderCnt1[1].trim()),Integer.parseInt(AreaCodeHeaderCnt[1].trim())-2,
				"AreaCodeHdrCnt","Count of Area Codes in header is correct","Count of Area Codes in header is not correct");;
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("AssignArea_ChkHdrCnt() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return AreDet;
	}
	
	//Method to select code from summary table and return chase count
	public boolean SelectCodefrmSum(String id) throws Exception
	{
		boolean flag=false;
		try
		{
		List rows=driver.findElements(By.xpath("//tr//td[@class='text-center ng-star-inserted']"));
		for(int i=1;i<=rows.size();i++)
		{
		  WebElement sta=driver.findElement(By.xpath("//tr["+i+"]//td[@class='text-center ng-star-inserted']//following-sibling::td[2]"));
		  log.info("==============="+sta.getText());
		  if(sta.getText().trim().equals("Yes"))
		  {
			WebElement w=driver.findElement(By.xpath("//tr["+i+"]//td[contains(@class,'text-center ng')]/following-sibling::td[4]/p-tablecheckbox//div[2]"));
			action.Scroll(w);
			w.click();
			flag=true;
		   	break;
		  }
		 }
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("SelectCodefrmSum() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return flag;
	 }
	
	public String[] GetUntouchedChaseCnt(String zipdet) throws Exception
	{
		String[] a=new String[3];
		try
		{
		int i=100;
		a:
		while(i>0)
		{
			boolean flag=SelectCodefrmSum(zipdet);
			if(flag)
			{
				List<WebElement> rows=driver.findElements(By.xpath("//tr//td[@class='text-center ng-star-inserted']"));
				for(int i1=1;i1<=rows.size();i1++)
				{
				  WebElement sta=driver.findElement(By.xpath("//tr["+i1+"]//td[@class='text-center ng-star-inserted']//following-sibling::td[2]"));
				  if(sta.getText().trim().equals("Yes"))
				  {
				   a[0]=driver.findElement(By.xpath("//tr["+i1+"]//td[contains(@class,'text-center ng')]/following-sibling::td[3]")).getText();
				   a[1]=driver.findElement(By.xpath("//tr["+i1+"]//td[contains(@class,'text-center ng')]/following-sibling::td[1]")).getText();
				   a[2]=driver.findElement(By.xpath("//tr["+i1+"]//td[@class='text-center ng-star-inserted']")).getText();
				   break a;
				  }
			  }
			}
			 else
			 {
				action.ScrollToBottom();
				WebElement nexticon=driver.findElement(By.xpath("//span[@class='ui-paginator-icon pi pi-caret-right']"));
				action.clickButton(nexticon, "NextIcon");
		    }
		 }
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("GetUntouchedChaseCnt() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return a;
	}		
			
			
	
	//Method to Check address count of untouch row in Reassign window.
	//It accepts address count of code present in summary table
	public void ChkChaseCntInReassiWindow(String ChaseCnt) throws Exception
	{
		try
		{
		List Rows=driver.findElements(By.xpath("//h5[contains(text(),'Reassign Addresses')]/parent::div//tbody/tr"));
		 for(int i=1;i<=Rows.size();i++)
		 {
			 String u=driver.findElement(By.xpath("//h5[contains(text(),'Reassign Addresses')]/parent::div//tbody/tr["+i+"]/td[1]")).getText().trim();
			 if(u.contains("Untouched"))
			 {
				 String w=driver.findElement(By.xpath("//h5[contains(text(),'Reassign Addresses')]/parent::div//tbody/tr["+i+"]/td[3]")).getText().trim();
				 ChkCnt(Integer.parseInt(w),Integer.parseInt(ChaseCnt.trim()),"UntouchaseCnt_ReassiWin",
						 "Untouch chase count in reassign winodow is correct","Untouch chase count in reassign winodow  is not correct");
			 }
		 }
		}
		 catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkChaseCntInReassiWindow() failed", test, driver);
				throw new Exception(e.getMessage());
			}
	}
	
	//Method to Click submit button of Reassign window and Checks message.
	public void ClkSbmtReassign_ChkMsg() throws Exception
	{
		try
		{
		action.clickButton(driver.findElement(By.xpath("//div[contains(@class,'ng-tns')]/div/button[2]")),"Submit_Reassign");
		Thread.sleep(2000);
		VerfiyAlerts("Address has been successfully Reassigned to Agent.",icra_elements.AlertMsg);
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClkSbmtReassign_ChkMsg() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	//Method to Check address count of untouch row in Remove window.
	//It accepts address count of code present in summary table
	public void ChkChaseCntInRemoveWindow(String ChaseCnt) throws Exception
	{
		try
		{
			List Rows=driver.findElements(By.xpath("//h5[contains(text(),'Remove Addresses')]/parent::div//tbody/tr"));
			 for(int i=1;i<=Rows.size();i++)
		     {
			 String u=driver.findElement(By.xpath("//h5[contains(text(),'Remove Addresses')]/parent::div//tbody/tr["+i+"]/td[1]")).getText().trim();
			 if(u.contains("Untouched"))
			 {
				 String w=driver.findElement(By.xpath("//h5[contains(text(),'Remove Addresses')]/parent::div//tbody/tr["+i+"]/td[3]")).getText().trim();
				 ChkCnt(Integer.parseInt(w.trim()),Integer.parseInt(ChaseCnt.trim()),"UntouChaseCnt_ReassiWin",
						 "Untouch chase count in remove winodow is correct","Untouch chase count in remove winodow  is not correct");
			 }
		     }
		}
		catch (Exception e)
		{
	            Extent_Reporting.Log_FailMessage("ChkChaseCntInRemoveWindow() failed", test, driver);
				throw new Exception(e.getMessage());
		}
	}
	
	//Method to Click submit button of Reassign window and Checks message
	public void ClkSbmtOfRemoveAndChkRemoveMsg() throws Exception
	{
		try
		{
		action.clickButton(icra_elements.Submit_RemoveAddress, "Submit_RemoveAddress");
		VerfiyAlerts("Address has been removed.",icra_elements.AlertMsg);
		PageLoad(1000,10000000);
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClkSbmtOfRemoveAndChkRemoveMsg() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	//Method to Check Code,Address Count for agent in summary after doing any operation i.e assign,reassign,remove
	//Method accepts Code to check,Agent for which you want to check,Address Count of that zip code
	public void ChkIdDetailInSumTbl(String id,String Agent) throws Exception
	{
		try
		{
		List rows=driver.findElements(By.xpath("//p-table[@datakey='Agent']//tbody/tr"));
		action.ScrollToBottom();
		for(int i1=1;i1<=rows.size();i1++)
		{
			xpath="//p-table[@datakey='Agent']//tbody";
			ageentnameoftable=driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[2]")).getText();
			log.info(Agent);
			log.info(ageentnameoftable);
			if(Agent.trim().contains(ageentnameoftable.trim()))
			{
				WebElement w=driver.findElement(By.xpath(xpath+"/tr["+i1+"]/td[1]//i"));//,"Agent");
				action.clickButton(w,"> sign");
				Extent_Reporting.Log_Message("Clicked on > sign of that agent",test,driver);
				Thread.sleep(5000);
				WebElement areacode=driver.findElement(By.xpath("//p-table[@datakey='Agent']//p-multiselect//span[contains(text(),'Code')]"));
				areacode.click();
				WebElement textbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext')]"));
				action.inputText(textbox, id,"Code");
				WebElement Chkbox=driver.findElement(By.xpath("//div[contains(@class,'ui-chkbox ui-widget ng')]//div[@role='checkbox']"));
				action.clickButton(Chkbox,"checkbox");
				WebElement Close=driver.findElement(By.xpath("//div[contains(@class,'ui-multiselect-filter-container ng')]/following-sibling::a"));
				action.clickButton(Close,"Close");	
				Thread.sleep(5000);
				String id1=driver.findElement(By.xpath("//tr//td[@class='text-center ng-star-inserted']")).getText();
				//String UnAdrCnt=driver.findElement(By.xpath("//tr//td[contains(@class,'text-center n')]/following-sibling::td[2]")).getText();
				//String ChaCnt=driver.findElement(By.xpath("//tr//td[contains(@class,'text-center n')]/following-sibling::td[3]")).getText();
				ChkCnt(Integer.parseInt(id1), Integer.parseInt(id),"Id_SummTbl","Id is present in Summary table","Id is not present in Summary table");
				//ChkCnt(Integer.parseInt(UnAdrCnt),Integer.parseInt(UntnchAdrCnt),"Adr_SummTbl",
						//"Untouch Address Count Of Id in Summary table is correct","Untouch Address Count Of Id in Summary table is not correct");
				//ChkSumTblCnt(Integer.parseInt(ChaCnt), Integer.parseInt(Chcnt), "Chase_SummTbl", "after Re-assign");
				break;
			}
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkIdDetailInSumTbl() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void ChkIdReassginAgent(String id,String ReassignAgent,String Addressid,String ChaseCnt) throws Exception
	{
		try
		{
		List rows=driver.findElements(By.xpath("//p-table[@datakey='Agent']//tbody/tr"));
		action.ScrollToBottom();
		for(int i1=1;i1<=rows.size();i1++)
		{
			xpath="//p-table[@datakey='Agent']//tbody";
			ageentnameoftable=driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[2]")).getText();
			log.info(ageentnameoftable);
			if(ReassignAgent.trim().contains(ageentnameoftable.trim()))
			{
				WebElement w=driver.findElement(By.xpath(xpath+"/tr["+i1+"]/td[1]//i"));//,"Agent");
				action.clickButton(w,"> sign");
				Extent_Reporting.Log_Message("Clicked on > sign of that agent",test,driver);
				Thread.sleep(5000);
				WebElement areacode=driver.findElement(By.xpath("//p-table[@datakey='Agent']//p-multiselect//span[contains(text(),'Code')]"));
				areacode.click();
				WebElement textbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext')]"));
				action.inputText(textbox, id,"Code");
				WebElement Chkbox=driver.findElement(By.xpath("//span[text()='"+id+"']//parent::li/div/div"));
				action.clickButton(Chkbox,"checkbox");
				WebElement Close=driver.findElement(By.xpath("//div[contains(@class,'ui-multiselect-filter-container ng')]/following-sibling::a"));
				action.clickButton(Close,"Close");	
				WebElement AddressId=driver.findElement(By.xpath("//p-table[@datakey='Agent']//p-multiselect//span[contains(text(),'ID')]"));
				AddressId.click();
				WebElement textbox1=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext')]"));
				action.inputText(textbox1, Addressid,"AddressId");
				WebElement Chkbox1=driver.findElement(By.xpath("//span[text()='"+Addressid+"']//parent::li/div/div"));
				action.clickButton(Chkbox1,"checkbox");
				WebElement Close1=driver.findElement(By.xpath("//div[contains(@class,'ui-multiselect-filter-container ng')]/following-sibling::a"));
				action.clickButton(Close1,"Close");
				String id1=driver.findElement(By.xpath("//tr//td[@class='text-center ng-star-inserted']")).getText();
				String Address=driver.findElement(By.xpath("//tr//td[contains(@class,'text-center n')]/following-sibling::td[1]")).getText();
				String ChaCnt=driver.findElement(By.xpath("//tr//td[contains(@class,'text-center n')]/following-sibling::td[3]")).getText();
				ChkCnt(Integer.parseInt(id1), Integer.parseInt(id),"Id_SummTbl","Id is present in Summary table","Id is not present in Summary table");
				ChkCnt(Integer.parseInt(Address),Integer.parseInt(Addressid),"AdrId_SummTbl","Address Id in Summary table is correct","Address Id in Summary table is not correct");
				ChkCnt(Integer.parseInt(ChaCnt), Integer.parseInt(ChaseCnt), "Chase_SummTbl", "Chase count in Summary table is correct",
						"Chase count in Summary table is not correct");
				break;
			}
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkIdReassginAgent() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	//Method to Check ZipCode in Zip Code table after doing assign
	public void ChkCodeInCodeTblAftrAssign() throws Exception
	{
		try
		{
		WebElement zipcodeTextbox=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//div[3]/span"));
		action.clickButton(zipcodeTextbox, "Zipcode Textbox");		
		WebElement SearchTextbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext')]"));		
		action.inputText(SearchTextbox, Zipid, "Zip Id");
		WebElement w=driver.findElement(By.xpath("//li[contains(text(),'No results found')]"));
		if(w.isDisplayed())
		{
		  Extent_Reporting.Log_Pass("AddressCount","Address Count is Zero i.e correct" , test, driver);
		}			
		else
		{
			Extent_Reporting.Log_Fail("AddressCount","Address Count is not Zero i.e not correct" , test, driver);	 
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkCodeInCodeTblAftrAssign() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	//Method to Check ZipCode in Zip Code table after doing Remove
	//Validate Chase Count 
	public void ChkChaseCntInCodeTblAftrRemove(String id,String ChaseCnt) throws Exception
	{
		try
		{
		action.ScrollToTop();
		WebElement zipcodeTextbox=driver.findElement(By.xpath("//*[@id=\"form-ui\"]/div[2]/div[3]//div[3]/span"));
		action.clickButton(zipcodeTextbox, "code Textbox");		
		WebElement SearchTextbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext')]"));		
		action.inputText(SearchTextbox, id, "Id");
		WebElement w=driver.findElement(By.xpath("//div[contains(@class,'ng-trigger-overlay')]//div[@role='checkbox']"));
		action.clickButton(w, "ChkBx");
		WebElement w1=driver.findElement(By.xpath("//div[contains(@class,'ng-trigger-overlay')]//a"));
		action.clickButton(w1, "Close");
		if(Integer.parseInt(Get1stRecordChaseCount())>Integer.parseInt(ChaseCnt)||Integer.parseInt(Get1stRecordChaseCount())==Integer.parseInt(ChaseCnt))
		{
			Extent_Reporting.Log_Pass("ChaseCnt_CodeTbl", "Chase count is added in code table", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("ChaseCnt_CodeTbl", "Chase count is not added in code table", test, driver);
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkChaseCntInCodeTblAftrRemove() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	//Method to Check Total Untouched Address,Total Chases count in Summary table after assigning
	public void ChkTtlCntInSum() throws Exception
	{
    	try
    	{
		List rows=driver.findElements(By.xpath("//p-table[@datakey='Agent']//div[@class='ui-table ui-widget']//table//tbody/tr"));    	
		for(int i1=1;i1<=rows.size();i1++)
		{
			ageentnameoftable =driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[2]")).getText();
			if(Agent.trim().contains(ageentnameoftable.trim()))
			 {
				TotalUntouchedADDCount=driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[4]")).getText();
				TotalChaCount=driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[5]")).getText();
				//Total Untouch address count of summary before addition +Address count Of Zip/Area Code
				int f=Integer.parseInt(TotalUnTouchAddressCount)+Integer.parseInt(addresscount); //Addition stored in f
	            //Total latest Untouch addresses count of summary table after addition
				ChkCnt(Integer.parseInt(TotalUntouchedADDCount),f,"Untouched_SummTableCnt","Total Untouch address count is correct in summary","Total Untouch address count is not correct in summary");				
				//Adding Total chase count of summary before addition + Chase count Of Zip/Area Table
				int x=Integer.parseInt(TotalChaseCount)+Integer.parseInt(ChaseCount);
				//Here Total chase count of Summary table after addition is must be equal or greater than x.
				if(Integer.parseInt(TotalChaCount)>=x)
				{
				  Extent_Reporting.Log_Pass("Chase_SummTableCnt","Chase Count In Summary Table is added" , test, driver);
				}
				else
				{
				  Extent_Reporting.Log_Fail("Chase_SummTableCnt","Chase Count In Summary Table is not added after assigin" , test, driver);
				}
			}
		}
    	}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkTtlCntInSum() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}

	//Method to Check Total Untouched Address,Total Chases count in Summary table for that agent
	public String[] GetAdr_ChaseCntOfSumm(String agent) throws Exception
	{
	    String a[]=new String[2];
	    try
	    {
		boolean flag=CheckAgentInSummary(agent);
		if(flag)
		{
			List rows=driver.findElements(By.xpath("//p-table[@datakey='Agent']//div[@class='ui-table ui-widget']//table//tbody/tr"));
			for(int i1=1;i1<=rows.size();i1++)
			{
				ageentnameoftable =driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[2]")).getText();
				if(agent.trim().contains(ageentnameoftable.trim()))
				 {
					 TotalUnTouchAddressCount =driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[4]")).getText();
					 TotalChaseCount=driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[5]")).getText();
					 a[0]=TotalUnTouchAddressCount;
					 a[1]=TotalChaseCount;
					 Extent_Reporting.Log_Message("Total count of Addresses In  Summary Table :" +TotalUnTouchAddressCount,test,driver);
					 Extent_Reporting.Log_Message("Total count of Chases In Summary Table :" +TotalChaseCount,test,driver);					 
					 break;
				 }
			}	
		}
		else
		{
			Extent_Reporting.Log_Message("Agent is Not Present",test,driver);
			TotalUnTouchAddressCount="0";
			TotalChaseCount="0";
			a[0]=TotalUnTouchAddressCount;
			a[1]=TotalChaseCount;
			Extent_Reporting.Log_Message("Total count of Addresses In  Summary Table Before Allocation is:"+TotalUnTouchAddressCount,test,driver);
			Extent_Reporting.Log_Message("Total count of Chases In Summary Table Before Allocation is :"+TotalChaseCount,test,driver);
		}
	    }
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("GetAdr_ChaseCntOfSumm() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return a;
	}
	
	//Method to Check agent in Summary table
	public boolean CheckAgentInSummary(String Agent) throws Exception
	{
		boolean flag=false;
		try
		{
		List rows=driver.findElements(By.xpath("//p-table[@datakey='Agent']"
    			+ "//div[@class='ui-table ui-widget']//table//tbody/tr"));
		for(int i1=1;i1<=rows.size();i1++)
		{
			xpath="//p-table[@datakey='Agent']//tbody";
			ageentnameoftable =driver.findElement(By.xpath(xpath + "/tr["+i1+"]/td[2]")).getText();
			if(Agent.contains(ageentnameoftable.trim()))
			{
				Extent_Reporting.Log_Message("Agent Found",test,driver);
				flag=true;
				break;
			}
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("CheckAgentInSummary() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return flag;		 
	}
	
	public void ChkAdrRollUp(String id) throws Exception
	
	{
		try
		{
		
		WebElement Submit=driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary mb5']"));
		ClkByJs(Submit);
		//String[] AdrCnt=driver.findElement(By.xpath("//label[@class='field-label pt10 pl10']/strong")).getText().trim().split(":");	
		//String j=AdrCnt[1].
		//log.info(j.trim());
		//if(AdrCnt[1].substring(1, 2).contains(adrcnt)||Integer.parseInt(AdrCnt[1].substring(1, 2))>Integer.parseInt(adrcnt))
		//{
		//	Extent_Reporting.Log_Pass("AdrCntAdrRollUp","Address count is added in RollUp screen",test, driver);
		//}
		//else
		//{
		//	Extent_Reporting.Log_Fail("AdrCntAdrRollUp","Address count is not added in RollUp screen",test, driver);
		//}
		//action.clickButton(Submit, "Submit");
		ClkByJs(Submit);
		Thread.sleep(5000);
		WebElement Allzip=driver.findElement(By.xpath("//span[text()='All Zip']"));
		Allzip.click();
		Extent_Reporting.Log_Message("Zip id is clicked",test,driver);
		WebElement ziptextbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext ui-widget')]"));
		action.inputText(ziptextbox, id,"ZipTextbox");
		WebElement chkbox=driver.findElement(By.xpath("//div[contains(@class,'ui-chkbox ui-widget')]//div[2]"));
		action.clickButton(chkbox, "chkbox");
		WebElement a=driver.findElement(By.xpath("//ul[contains(@class,'ui-multiselect-items')]//li[@aria-label='"+id+"']/span[@class='ng-star-inserted']"));
	    if(a.getText().trim().equals(id))
		{
			Extent_Reporting.Log_Pass("IdAdrRollUp","Id is present in RollUp",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("IdAdrRollUp","Id is not present in RollUp",test, driver);
		}
		WebElement close=driver.findElement(By.xpath("//a[contains(@class,'ui-multiselect-close')]"));
		action.clickButton(close, "close");
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkAdrRollUp() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void ChkAdrRollUpForReassgin(String id,String AddressId,String chasecnt) throws Exception
	{
		
		try
		{
		WebElement Submit=driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary mb5']"));
//		//action.clickButton(Submit, "Submit");
		ClkByJs(Submit);
		Thread.sleep(4000);
		WebElement Addressid=driver.findElement(By.xpath("//span[contains(text(),'All Address ID')]"));
		Addressid.click();
		Extent_Reporting.Log_Message("Address id is clicked",test,driver);
		WebElement addresstextbox=driver.findElement(By.xpath("//input[contains(@class,'ui-inputtext ui-widget')]"));
		action.inputText(addresstextbox, AddressId,"addresstextbox");
		WebElement chkbox1=driver.findElement(By.xpath("//div[contains(@class,'ui-chkbox ui-widget')]//div[2]"));
		action.clickButton(chkbox1, "chkbox1");
		WebElement b=driver.findElement(By.xpath("//ul[contains(@class,'ui-multiselect-items')]//li[@aria-label='"+AddressId+"']/span[@class='ng-star-inserted']"));
		if(b.getText().trim().equals(AddressId))
		{
			Extent_Reporting.Log_Pass("IdAdrRollUp","AddressId is present in RollUp",test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail("IdAdrRollUp","Address Id is not present in RollUp",test, driver);
		}
		WebElement close=driver.findElement(By.xpath("//a[contains(@class,'ui-multiselect-close')]"));
		action.clickButton(close, "close");
//		String chase=driver.findElement(By.xpath("//tbody//tr//td[3]")).getText();
//		if(chase.trim().equals(chasecnt))
//		{
//			Extent_Reporting.Log_Pass("ChaseCnt_GridAdrRollUp","Chase Count is correct in untouched tab of Address RollUp",test, driver);
//		}
//		else
//		{
//			Extent_Reporting.Log_Fail("ChaseCnt_GridAdrRollUp","Chase Count is not correct in untouched tab of Address RollUp",test, driver);
//		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ChkAdrRollUpForReassgin() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
    public void ClkByJs(WebElement ele) throws Exception
	{
		try
		{
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Extent_Reporting.Log_Message("Element is clicked",test,driver);
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClkByJs() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
}

	
	
	
	
	
	

