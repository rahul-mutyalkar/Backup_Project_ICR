package com.qa.BusinessLogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.PageObjects.ICRA_PageObjects_Niketan;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;



public class ProviderManageMentAction_Niketan extends Extent_Reporting{
		
		ElementAction action = new ElementAction();
		String TC_ID = null;
		WebDriver driver;
		ICRA_PageObjects_Niketan icra_elements; 
		String firstname="";
		String Lastname="";
		String Taxnumber="";
		String TaxCode="";
		String Speciality="";
		String CommunicationMode="";
		String NPI="";
		String DocumentTitle="";
		String DocumentYear="";
		String DocumentType="";
	    String DocumentTitle1="";
	    String ContactType="";
	    String Email="";
	    String MailingAddress="";
	    String State="";
	    String City="";
	    String Zip="";
	    String Fax="";
	    String Phone="";
	    String Address2="";
		String Address1="";
		String AddressType="";
			
		
		public ProviderManageMentAction_Niketan(WebDriver driver,String TC_ID)
		{
			this.driver=driver;
			this.TC_ID=TC_ID;
			icra_elements= new ICRA_PageObjects_Niketan(driver);
		}
		
		public void WaitElement(WebElement w,int wait)
		{
			for(int i=1;i<=wait;i++)
		    {
				action.WaitUntilDisplayed(w);
		    }		
		}
		
		public void clickProviderManagementTab() throws Exception
		{
			try
			{
				CheckElementDisplay(icra_elements.ProviderManagementTab,"Provider Mangement","Provider Mangement tab");
			    action.clickButton(icra_elements.ProviderManagementTab," Provider Management Tab");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
			
		public void CheckElementDisplay(WebElement w,String ScrName,String name) throws Exception
		{
			try
			{
			if(action.WaitUntilDisplayed(w))
			{
			  
			  Extent_Reporting.Log_Pass(ScrName,""+name+" is displayed", test, driver);
			}
		   else
			{
				Extent_Reporting.Log_Fail(ScrName,""+name+" is not displayed", test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckElementDisplay() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
				
		public void VerifyFieldsText(WebElement w,String Actualtext) throws Exception
		{
			try
			{
			String text=w.getAttribute("value");
			if(text.trim().equals(Actualtext))
			{
			  Extent_Reporting.Log_Pass(""+text+"","text is equal", test, driver);
			}
			else
			{
			 Extent_Reporting.Log_Fail(""+text+"","text is not equal", test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("VerifyFieldsText() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void VerifyText(WebElement w,String Actualtext,String msg,String msg1) throws Exception
		{
			try
			{
			String text=action.elementGetText(w,"Ele");
			if(text.trim().equals(Actualtext))
			{
				Extent_Reporting.Log_Pass(""+text+"",msg, test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(""+text+"",msg1, test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("VerifyText() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void ChkDis(WebElement w,String name) throws Exception
		{
			try
			{
			if(w.isEnabled())
			{
			  Extent_Reporting.Log_Fail("Disable",""+name+" is not disable", test, driver);
            }
			else
			{
				Extent_Reporting.Log_Pass("Disable",""+name+" is disable", test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkDis() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void ChkWaterMark(WebElement w,String Actualtext,String msg,String msg1) throws Exception
		{
			try
			{
			String text=w.getAttribute("placeholder");			
			if(text.contains(Actualtext))
			{
			  Extent_Reporting.Log_Pass(""+text+"",msg, test, driver);
			}
			else
			{
			  Extent_Reporting.Log_Fail(""+text+"",msg1, test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkWaterMark() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public boolean CheckMandatoryFieldMessage(WebElement w)
		{
			boolean status=false;
			String[] Messages=ExcelHandling.GetExcelData(TC_ID,"MandatoryFieldsVaildationMessages").split(",");
			Set<String> hSet = new HashSet<String>();
			for(String x:Messages)
			{
				hSet.add(x);
			}
			Iterator<String> str=hSet.iterator();
			String s="";
			while(str.hasNext())
			{
				s=str.next();
				if(s.equals(w.getText().trim()))
				{
					status=true;
					try 
					{
					  Assert.assertTrue(status, ""+s+" Is Not Displayed");
					  Extent_Reporting.Log_Pass(""+s+"",""+s+"is displayed", test, driver);
					}
					catch(AssertionError e)
					{
					  Extent_Reporting.Log_Fail(""+s+"",""+s+"is not displayed", test, driver);
					}	
					break;
				}
			}
			return status;
		}
			
		public boolean CheckFields(String text)
		{
			boolean status=false;
			String[] Messages=ExcelHandling.GetExcelData(TC_ID,"Fields").split(",");
			Set<String> hSet = new HashSet<String>();
			for(String x:Messages)
			{
				hSet.add(x);
			}
			Iterator<String> str=hSet.iterator();
			String s="";
			while(str.hasNext())
			{
				s=str.next();
				if(s.equals(text))
				{
					status=true;
					try 
					{
					  Assert.assertTrue(status, ""+s+" Is Not Displayed");
					  Extent_Reporting.Log_Pass(""+s+"",""+s+" is displayed", test, driver);
					}
					catch(AssertionError e)
					{
					  Extent_Reporting.Log_Fail(""+s+"",""+s+" is not displayed", test, driver);
					}	
					break;
				}
			}
			return status;
		}
		
		
		public void EnterProviderSearchFieldAndVerifyColNames() throws Exception
		{
			try
			{
			CheckElementDisplay(icra_elements.SearchTextBox,"Serach text box","Serach text box");
			CheckElementDisplay(icra_elements.SearchButton,"Search button","Serach Button");
			CheckElementDisplay(icra_elements.ClearButton,"Clear Button","Clear Button");
			Extent_Reporting.Log_Message("Search Field,Search and Clear Button is displayed",test,driver);
			String text=ExcelHandling.GetExcelData(TC_ID,"SearchTextBox");
			action.inputText(icra_elements.SearchTextBox, text, text);
			Extent_Reporting.Log_Message("Entered data in Search Field",test,driver);
			action.WaitForElement(icra_elements.SearchButton, "Search Button");
			icra_elements.SearchButton.click();
			Extent_Reporting.Log_Message("Search Button is clicked",test,driver);
			String colnames=driver.findElement(By.xpath("//span[@aria-colindex='1']")).getText();
			CheckFields(colnames.trim());
			for(int i=2;i<=14;i++)
			{
				WaitElement(icra_elements.ProviderManagementTab,10);
				WebElement w;	
				if(i>6)
				{
					w=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/preceding::span[1]"));
					JavascriptExecutor js = (JavascriptExecutor)driver; 
					js.executeScript("arguments[0].scrollIntoView()", w);
					js.executeScript("window.scrollBy(0,-1000)","");
					WebElement w1=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']"));
					String colnames1=w1.getText();
					CheckFields(colnames1.trim());						
					Actions a=new Actions(driver);
					a.moveToElement(w1).build().perform();			
					w1.click();
	      		    WebElement asendingicon=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/parent::div/span[4]"));
					CheckElementDisplay(asendingicon,"Asc sign","Asc sign");
					Extent_Reporting.Log_Message(""+i+"th asec icon is displayed",test,driver);
					w1.click();
					WebElement desendingicon=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/parent::div/span[5]"));
					CheckElementDisplay(desendingicon,"Desc sign","Desc sign");
					Extent_Reporting.Log_Message(""+i+"th desc icon is displayed",test,driver);
					WebElement Filtericon=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/preceding::span[1]"));				
					CheckElementDisplay(Filtericon,"Filter","Filter");
					Extent_Reporting.Log_Message(""+i+"th Filter is displayed",test,driver);
					CheckElementDisplay(w,"Filter icon","Filter icon");
					Extent_Reporting.Log_Message(""+i+"th Filter is displayed",test,driver);
				}
				else
				{
				
				 w=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/preceding::span[1]"));
				 WebElement w2=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']"));
				 String colnames1=w2.getText();
				 CheckFields(colnames1.trim());				
				 Actions a=new Actions(driver);
				 a.moveToElement(w2).build().perform();			
				 w2.click();
      		     WebElement asendingicon=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/parent::div/span[4]"));
				 CheckElementDisplay(asendingicon,"Asc icon","Asc icon");
				 Extent_Reporting.Log_Message(""+i+"th asec icon is displayed",test,driver);
				 w2.click();
				 WebElement desendingicon=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']/parent::div/span[5]"));
				 CheckElementDisplay(desendingicon,"Desc icon","Desc icon");
				 Extent_Reporting.Log_Message(""+i+"th desc icon is displayed",test,driver);
				 CheckElementDisplay(w2,"Filter","Filter");
   				 Extent_Reporting.Log_Message(""+i+"th Filter is displayed",test,driver);
				 }
				}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("EnterProviderSearchFieldAndVerifyColNames() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			}
		
		public void CheckTextFieldsInTabs() throws Exception
		{
			try
			{
			String data=ExcelHandling.GetExcelData(TC_ID,"Tabs");
			EnterNPIAndClickAdd_EditIcon();
			if(data.equals("Provider"))
			{
				VaildateTextDataInProviderTab();
			}
			else if(data.equals("Contact"))
			{
				VaildateTextDatainContactTab();
			}
			else if(data.equals("Document"))
			{
				VaildateTextDatainDocumentTab();
			}
			else if(data.equals("Address"))
			{
				VaildateTextDatainAddressTab();
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckTextFieldsInTabs() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void EnterNPIAndClickAdd_EditIcon() throws Exception
		{
			try
			{
            action.clickButton(icra_elements.AddProviderTab, "AddProviderTab");
            action.clickButton(icra_elements.ProviderManagementTab, "ProviderManagementTab");
			ClrEle(icra_elements.SearchTextBox);
			WaitElement(icra_elements.ProviderManagementTab,20);
			String text=ExcelHandling.GetExcelData(TC_ID,"SearchTextBox");
			action.inputText(icra_elements.SearchTextBox, text, text);
			Extent_Reporting.Log_Message("Entered data in Search Field",test,driver);
			action.WaitForElement(icra_elements.SearchButton, "Search Button");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", icra_elements.SearchButton, "Search Button");
			Extent_Reporting.Log_Message("Search Button is clicked",test,driver);
			WaitElement(icra_elements.ProviderManagementTab,10);
			WebElement w1=driver.findElement(By.xpath("//i[@class='fa fa-edit']"));
			WaitElement(w1,20);			
			Extent_Reporting.Log_Message("Add/edit button is displayed",test,driver);
			action.clickButton(w1,"Add Edit");
			Extent_Reporting.Log_Message("Add/edit button icon is clicked",test,driver);
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("EnterNPIAndClickAdd_EditIcon() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void CheckAllTabsInProviderDetailssection() throws Exception
		{
			try
			{
			EnterNPIAndClickAdd_EditIcon();
			action.Scroll(icra_elements.ProviderName_ProviderManagementScreen);
			CheckElementDisplay(icra_elements.ProviderName_ProviderManagementScreen,"ProviderName","ProviderName");
			CheckElementDisplay(icra_elements.Provider_Subtab,"ProviderTab","ProviderTab");
			Extent_Reporting.Log_Message("Provider tab is displayed",test,driver);
			CheckElementDisplay(icra_elements.Address_Subtab,"AddressTab","AddressTab");
			Extent_Reporting.Log_Message("Address tab is displayed",test,driver);
			CheckElementDisplay(icra_elements.Contact_Subtab,"ContactTab","ContactTab");
			Extent_Reporting.Log_Message("Contact tab is displayed",test,driver);
			CheckElementDisplay(icra_elements.Document_Subtab,"DocTab","DocTab");
			Extent_Reporting.Log_Message("Documents tab is displayed",test,driver);			
			CheckElementDisplay(icra_elements.Contract_Subtab,"ContractTab","ContractTab");
			Extent_Reporting.Log_Message("Contract tab is displayed",test,driver);
			CheckElementDisplay(icra_elements.Payment_Subtab,"PaymentTab","PaymentTab");
			Extent_Reporting.Log_Message("Payment tab is displayed",test,driver);	
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllTabsInProviderDetailssection() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void CheckAllFieldsinProviderTab() throws Exception
		{
			try
			{
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Provider')]"));
			action.clickButton(w1, "Provider");
			Extent_Reporting.Log_Message("Provider Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking all fields in provider tab",test,driver);
			CheckElementDisplay(icra_elements.FirstName_Provider,"FirstName","FirstName");
			CheckElementDisplay(icra_elements.LastName_Provider,"LastName","LastName");
			CheckElementDisplay(icra_elements.Tax_Identification_Number_Provider,"TaxNo","Tax No");
			CheckElementDisplay(icra_elements.TaxCode_Provider,"TaxCode","Tax Code");
			CheckElementDisplay(icra_elements.NPI_Provider,"NPI","NPI");
			CheckElementDisplay(icra_elements.Speclty_Provider,"Speciality","Speciality");
			CheckElementDisplay(icra_elements.GroupName_Provider,"GrpName","GrpName");
			CheckElementDisplay(icra_elements.Save_Provider,"Save Button","Save Button");
			CheckElementDisplay(icra_elements.CommunicationMode_Provider,"Communication Mode","Communication Mode");
			Extent_Reporting.Log_Message("All Fields In Provider Tab are present",test,driver);
			Select se=new Select(icra_elements.CommunicationMode_Provider);
			List<WebElement> elements=se.getOptions();
			Iterator<WebElement> str=elements.iterator();
			WebElement s;
			while(str.hasNext())
			{
				s=str.next();
				CheckFields(s.getText().trim());
			}
			action.inputText(icra_elements.NPI_Provider, "abc", "abc");
			if(icra_elements.NPI_Provider.getAttribute("value").contentEquals("abc"))
			{
				Extent_Reporting.Log_Fail("NPI","NPI is not disbale", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Pass("NPI","NPI is disbale", test, driver);
			}
			action.inputText(icra_elements.GroupName_Provider, "abc", "abc");
			if(icra_elements.GroupName_Provider.getAttribute("value").contentEquals("abc"))
			{
				Extent_Reporting.Log_Fail("GroupName_Provider","GroupName is not disbale", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Pass("GroupName_Provider","GroupName is disbale", test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllFieldsinProviderTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
		
		public void ChkWaterMarkProviderTab() throws Exception
		{
			try
			{
			Extent_Reporting.Log_Message("Checking all watermark in contact tab",test,driver);
			ChkWaterMark(icra_elements.FirstName_Provider,"First Name","First Name Watermark is present","First Name Watermark is not present");
			ChkWaterMark(icra_elements.LastName_Provider,"Last Name","Last Name Watermark is present","Last Name Watermark is not present");
			ChkWaterMark(icra_elements.Tax_Identification_Number_Provider,"Tax Identification Number",
					"Tax Identification Number Watermark is present","Tax Identification Number Watermark is not present");
			ChkWaterMark(icra_elements.TaxCode_Provider,"Taxanomy Code",
					"Taxanomy Code Watermark is present","Taxanomy Code Watermark is not present");			
			ChkWaterMark(icra_elements.NPI_Provider,"NPI","NPI Watermark is present","NPI Watermark is not present");
			ChkWaterMark(icra_elements.Speclty_Provider,"Specialty","Specialty Watermark is present","Specialty Watermark is not present");
			ChkWaterMark(icra_elements.CommunicationMode_Provider,"Preffered communication mode",
					"Preffered communication mode Watermark is present","Preffered communication mode is not present");
			ChkWaterMark(icra_elements.GroupName_Provider,"Provider Group Name","Provider Group Name Watermark is present","Provider Group Name is not present");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkWaterMarkProviderTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void CheckAllFieldsinAddressTab() throws Exception
		{
			try
			{
			action.ScrollToBottom();
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Address')]"));
			action.clickButton(w1, "Address");
			Extent_Reporting.Log_Message("Address Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking all fields in address tab",test,driver);
			CheckElementDisplay(icra_elements.Address1_Address,"Address1_Address","Address1");
			CheckElementDisplay(icra_elements.Address2_Address,"Address2_Address","Address2");
			CheckElementDisplay(icra_elements.City_Address,"City_Address","City");
			CheckElementDisplay(icra_elements.State_Address,"State_Address","State");
			CheckElementDisplay(icra_elements.Zip_Address,"Zip_Address","Zip");
			CheckElementDisplay(icra_elements.FaxNo_Address,"FaxNo_Address","FaxNo");
			CheckElementDisplay(icra_elements.Save_Address,"Save_Address","Save");
			CheckElementDisplay(icra_elements.AddressType_Address,"AddressType_Address","AddressType");
			Extent_Reporting.Log_Message("All Fields In Address Tab are present",test,driver);
			Select se=new Select(icra_elements.AddressType_Address);
			List<WebElement> elements=se.getOptions();
			Iterator<WebElement> str=elements.iterator();
			WebElement s;
			while(str.hasNext())
			{
				s=str.next();
				CheckFields(s.getText().trim());
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllFieldsinAddressTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		  } 
		
		public void ChkWaterMarkAddressTab() throws Exception
		{
			try
			{
			action.ScrollToBottom();
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Address')]"));
			action.clickButton(w1, "Address");
			Extent_Reporting.Log_Message("Address Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking all watermark in Address tab",test,driver);
			ChkWaterMark(icra_elements.Address1_Address,"Address 1","Address1 Watermark is present","Address1 Watermark is not present");
			ChkWaterMark(icra_elements.Address2_Address,"Address 2","Address2 Watermark is present","Address2 Watermark is not present");
			ChkWaterMark(icra_elements.City_Address,"City","City Watermark is present","City Watermark is not present");
			ChkWaterMark(icra_elements.State_Address,"State","State Watermark is present","State Watermark is not present");
			ChkWaterMark(icra_elements.Zip_Address,"Zip","Zip Watermark is present","Zip Watermark is not present");
			ChkWaterMark(icra_elements.FaxNo_Address,"Fax No","Fax No. Watermark is present","Fax No.Watermark is not present");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkWaterMarkAddressTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void CheckAllFieldsinContactTab() throws Exception
		{
			
			try
			{
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'ontact')]"));
			action.clickButton(w1, "Contact");
			Extent_Reporting.Log_Message("Contact Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking all fields in contact tab",test,driver);
			CheckElementDisplay(icra_elements.FirstName_Contact,"FirstName_Contact","FirstName_Contact");
			CheckElementDisplay(icra_elements.LastName_Contact,"LastName_Contact","LastName_Contact");
			CheckElementDisplay(icra_elements.Email_Contact,"Email_Contact","Email_Contact");
			CheckElementDisplay(icra_elements.MailingAddress_Contact,"MailingAddress_Contact","MailingAddress_Contact");
			CheckElementDisplay(icra_elements.State_Contact,"State_Contact","State_Contact");
			CheckElementDisplay(icra_elements.City_Contact,"City_Contact","City_Contact");
			CheckElementDisplay(icra_elements.Zip_Contact,"Zip_Contact","Zip_Contact");
			CheckElementDisplay(icra_elements.Fax_Contact,"Fax_Contact","Fax_Contact");
			CheckElementDisplay(icra_elements.Phone_Contact,"Phone_Contact","Phone_Contact");
			CheckElementDisplay(icra_elements.Save_Contact,"Save_Contact","Save_Contact");
			CheckElementDisplay(icra_elements.ContactType_Contact,"ContactType_Contact","ContactType_Contact");
			Extent_Reporting.Log_Message("All Fields In Contact Tab are present",test,driver);
			Select se=new Select(icra_elements.ContactType_Contact);
			List<WebElement> elements=se.getOptions();
			Iterator<WebElement> str=elements.iterator();
			WebElement s;
			while(str.hasNext())
			{
				s=str.next();
				CheckFields(s.getText().trim());				
		     }
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllFieldsinContactTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
		
		public void ChkWaterMarkContactTab() throws Exception
		{
			try
			{
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'ontact')]"));
			action.clickButton(w1, "Contact");
			Extent_Reporting.Log_Message("Contact Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking all watermark in contact tab",test,driver);
			ChkWaterMark(icra_elements.FirstName_Contact,"First Name","First Name Watermark is present","First Name Watermark is not present");
			ChkWaterMark(icra_elements.LastName_Contact,"Last Name","Last Name Watermark is present","Last Name Watermark is not present");
			ChkWaterMark(icra_elements.Email_Contact,"Email","Email Watermark is present","Email Watermark is not present");
			ChkWaterMark(icra_elements.MailingAddress_Contact,"Mailing Address","Mailing Address Watermark is present","Mailing Address Watermark is not present");
			ChkWaterMark(icra_elements.State_Contact,"State","State Watermark is present","State Watermark is not present");
			ChkWaterMark(icra_elements.Zip_Contact,"Zip","Zip Watermark is present","Zip Watermark is not present");
			ChkWaterMark(icra_elements.Fax_Contact,"Fax","Fax Watermark is present","Fax Watermark is not present");
			ChkWaterMark(icra_elements.Phone_Contact,"Phone","Phone Watermark is present","Phone Watermark is not present");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkWaterMarkContactTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		
		public void CheckAllFieldsinDocumentTab() throws Exception
		{
			try
			{
			WebElement w2=driver.findElement(By.xpath("//li//a[contains(@href,'Documents')]"));
			action.clickButton(w2, "Documents");
			Extent_Reporting.Log_Message("Document Field is clicked",test,driver);
			Extent_Reporting.Log_Message("Checking grid table colums.....",test,driver);
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("window.scrollBy(0,1000)","");
			String xpath="//div[@class='ag-root ag-unselectable ag-layout-normal'][@aria-colcount='6']/div[1]//div[2]/div";
			
			for(int j=1;j<=6;j++)
			{
				String elexpath=xpath+"/span[@aria-colindex='"+j+"']";
				if(j==6)
				{
					WebElement ele=driver.findElement(By.xpath(elexpath+"/parent::div/preceding::span[1]"));
					//action.Scroll(ele);
					JavascriptExecutor js1 = (JavascriptExecutor)driver; 
					js1.executeScript("arguments[0].scrollIntoView()", ele);
				
				}
				if(j==2||j==3||j==5||j==6)
				{
				  Actions a=new Actions(driver);
				  a.moveToElement(driver.findElement(By.xpath(elexpath+"/parent::div"))).build().perform();	
				  WaitElement(driver.findElement(By.xpath(elexpath+"/parent::div")),20);
				  action.clickButton(driver.findElement(By.xpath(elexpath+"/parent::div")),"Element");
				  WebElement w1=driver.findElement(By.xpath(elexpath));
				  CheckFields(w1.getText().trim());				 			
				  WebElement asendingicon=driver.findElement(By.xpath(elexpath+"/parent::div/span[4]"));
				  CheckElementDisplay(asendingicon,"Asc icon_Document","Asc icon_Document");
				  Extent_Reporting.Log_Message(""+j+"th asec icon is Displayed",test,driver);
				  action.clickButton(driver.findElement(By.xpath(elexpath+"/parent::div")),"Element");
				  WebElement desendingicon=driver.findElement(By.xpath(elexpath+"/parent::div/span[5]"));
				  CheckElementDisplay(desendingicon,"Desc icon_doc","Desc icon_doc");
				  Extent_Reporting.Log_Message(""+j+"th desc icon is displayed",test,driver);
				  WebElement Filtericon=driver.findElement(By.xpath(elexpath+"/parent::div/preceding::span[1]"));				
				  CheckElementDisplay(Filtericon,"Filter_Doc","Filter_Doc");
				  Extent_Reporting.Log_Message(""+j+"th Filter is displayed",test,driver);
				 }
				WebElement w=driver.findElement(By.xpath(elexpath));
				CheckFields(w.getText().trim());
			}
			Extent_Reporting.Log_Message("Checking all fields in documents tab",test,driver);
			CheckElementDisplay(icra_elements.DocumentTitle_Document,"DocumentTitle_Document","DocumentTitle_Document");
			CheckElementDisplay(icra_elements.SelectFile_Document,"SelectFile_Document","SelectFile_Document");
			CheckElementDisplay(icra_elements.UploadDocument_Document,"UploadDocument_Document","UploadDocument_Document");
			CheckElementDisplay(icra_elements.DocumentType_Document,"DocumentType_Document","DocumentType_Document");
			CheckElementDisplay(icra_elements.DocumentYear_Document,"DocumentYear_Document","DocumentYear_Document");
			Extent_Reporting.Log_Message("All Fields In Document Tab are present",test,driver);
			Select se=new Select(icra_elements.DocumentType_Document);
			List<WebElement> elements=se.getOptions();
			Iterator<WebElement> str=elements.iterator();
			WebElement s;
			while(str.hasNext())
			{
				s=str.next();
				CheckFields(s.getText().trim());
			}
			Select se1=new Select(icra_elements.DocumentYear_Document);
			List<WebElement> elem=se1.getOptions();
			Iterator<WebElement> st=elem.iterator();
			WebElement s1;
			while(st.hasNext())
			{
				s1=st.next();
			    CheckFields(s1.getText().trim());
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllFieldsinDocumentTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void ClkContractTab() throws Exception
		{
			try
			{
			action.clickButton(icra_elements.Contract_Subtab, "Contract_Subtab");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ClkContractTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		
		public void ClkAddContractIcon() throws Exception
		{
    		  try
    		  {
    		  action.clickButton(icra_elements.AddProviderIcon,"Add Provider Icon");
    		  }
    		  catch (Exception e)
    			{
    	            Extent_Reporting.Log_FailMessage("ClkAddContractIcon() failed", test, driver);
    				throw new Exception(e.getMessage());
    			}
		}
		
		
		public void ChkAllFieldsAddProviderContractScreen() throws Exception
		{
			try
			{
			Extent_Reporting.Log_Message("Checking all fields in Add Provider Contract Screen",test,driver);
			CheckElementDisplay(icra_elements.ClientName,"ClientName","ClientName");
			CheckElementDisplay(icra_elements.ContractrateType,"ContractrateType","ContractrateType");
			CheckElementDisplay(icra_elements.Decreiption,"Decreiption","Decreiption");
			CheckElementDisplay(icra_elements.StartDate,"StartDate","StartDate");
			CheckElementDisplay(icra_elements.LineofBusiness,"LineofBusiness","LineofBusiness");
			CheckElementDisplay(icra_elements.StandardRadioButton,"StandardRadioButton","StandardRadioButton");
			CheckElementDisplay(icra_elements.TierRadioButton,"TierRadioButton","TierRadioButton");
			action.clickButton(icra_elements.StandardRadioButton,"StandardRadioButton");			
			CheckElementDisplay(icra_elements.Amount,"Amount","Amount");
			action.clickButton(icra_elements.TierRadioButton,"TierRadioButton");	
			CheckElementDisplay(icra_elements.From,"From","From");
			CheckElementDisplay(icra_elements.To,"To","To");
			CheckElementDisplay(icra_elements.Rate,"Rate","Rate");
			CheckElementDisplay(icra_elements.AddSymbol,"AddSymbol","AddSymbol");
			CheckElementDisplay(icra_elements.RetrievalMethod,"RetrievalMethod","RetrievalMethod");	
			CheckElementDisplay(icra_elements.MinimumQty,"MinimumQty","MinimumQty");
			CheckElementDisplay(icra_elements.Save,"Save","Save");
			CheckElementDisplay(icra_elements.Close,"Close","Close");	
			action.inputText(icra_elements.ProviderGroupName, "abc", "abc");
			if(icra_elements.ProviderGroupName.getAttribute("value").contentEquals("abc"))
			{
				 Extent_Reporting.Log_Fail("ProviderGroupName1","ProviderGroupName is not disable", test, driver);				
			}
			else
			{
				 Extent_Reporting.Log_Pass("ProviderGroupName","ProviderGroupName is disable", test, driver);
			}
			action.inputText(icra_elements.ContractID, "abc", "abc");
			if(icra_elements.ContractID.getAttribute("value").contentEquals("abc"))
			{
				 Extent_Reporting.Log_Fail("ContractID","ContractID is not disable", test, driver);				
			}
			else
			{
				 Extent_Reporting.Log_Pass("ContractID","ContractID is disable", test, driver);
			}
			Extent_Reporting.Log_Message("All Fields In Add Provider Contract Screen are Checked",test,driver);
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkAllFieldsAddProviderContractScreen() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		 }
		
		
		
		public void ChkAllFieldsContractScreen() throws Exception
		{
			try
			{
			CheckElementDisplay(icra_elements.PFirstName,"FirstName","FirstName");
			CheckElementDisplay(icra_elements.Search,"Search","Search");
			CheckElementDisplay(icra_elements.Clear,"Clear","Clear");
			CheckElementDisplay(icra_elements.AddProviderIcon,"Add Provider Icon","Add Provider icon");
			String colnames=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='1']")).getText();
			CheckFields(colnames.trim());
			
			for(int i=2;i<12;i++)
			{
			  WebElement w=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='"+i+"']/preceding::span[1]"));
			 if(i==9)
			 {
			   JavascriptExecutor js = (JavascriptExecutor)driver;
			   WebElement w1=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='"+i+"']"));
			   js.executeScript("arguments[0].scrollIntoView()", w1);	
			    String colnames1=w1.getText();
				CheckFields(colnames1.trim());
			 }
			else {
			  JavascriptExecutor js = (JavascriptExecutor)driver; 
			  js.executeScript("arguments[0].scrollIntoView()", w);
			  js.executeScript("window.scrollBy(0,-500)","");
			  Thread.sleep(2000);
			  WebElement w1=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='"+i+"']"));
			  String colnames1=w1.getText();
			  CheckFields(colnames1.trim());						
			  Actions a=new Actions(driver);
			  a.moveToElement(w1).build().perform();			
			  w1.click();
  		      WebElement asendingicon=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='"+i+"']/parent::div//span[4]"));
			  CheckElementDisplay(asendingicon,"Asc sign","Asc sign");
			  Extent_Reporting.Log_Message(""+i+"th asec icon is displayed",test,driver);
			  w1.click();
			  WebElement desendingicon=driver.findElement(By.xpath("//div[@id='nav-Contract']//span[@aria-colindex='"+i+"']/parent::div/span[5]"));
			  CheckElementDisplay(desendingicon,"Desc sign","Desc sign");
			  Extent_Reporting.Log_Message(""+i+"th desc icon is displayed",test,driver);
			  CheckElementDisplay(w,"Filter icon",""+i+"th Filter icon");
			  Extent_Reporting.Log_Message(""+i+"th Filter is displayed",test,driver);
			}
		}
			CheckElementDisplay(icra_elements.ClientName1,"ClientName1","ClientName1");
			CheckElementDisplay(icra_elements.ContractrateType1,"ContractrateType1","ContractrateType1");
			CheckElementDisplay(icra_elements.Decreiption1,"Decreiption1","Decreiption1");
			CheckElementDisplay(icra_elements.StartDate1,"StartDate1","StartDate1");
			CheckElementDisplay(icra_elements.LineofBusiness1,"LineofBusiness1","LineofBusiness1");
			CheckElementDisplay(icra_elements.StandardRadioButton1,"StandardRadioButton1","StandardRadioButton1");
			CheckElementDisplay(icra_elements.TierRadioButton1,"TierRadioButton1","TierRadioButton1");
			CheckElementDisplay(icra_elements.Amount1,"Amount1","Amount1");
			action.clickButton(icra_elements.TierRadioButton1,"TierRadioButton1");
			CheckElementDisplay(icra_elements.From1,"From1","From1");
			CheckElementDisplay(icra_elements.To1,"To1","To1");
			CheckElementDisplay(icra_elements.Rate1,"Rate1","Rate1");
			CheckElementDisplay(icra_elements.AddSymbol1,"AddSymbol1","AddSymbol1");
			CheckElementDisplay(icra_elements.RetrievalMethod1,"RetrievalMethod1","RetrievalMethod1");	
			CheckElementDisplay(icra_elements.MinimumQty1,"MinimumQty1","MinimumQty1");
			CheckElementDisplay(icra_elements.Save1,"Save1","Save1");
			ChkDis(icra_elements.ClientName1,"ClientName1");
			ChkDis(icra_elements.ContractrateType1,"ContractrateType1");
			action.inputText(icra_elements.ProviderGroupName1, "abc", "abc");
			if(icra_elements.ProviderGroupName1.getAttribute("value").contentEquals("abc"))
			{
				 Extent_Reporting.Log_Fail("ProviderGroupName1","ProviderGroupName1 is not disable", test, driver);				
			}
			else
			{
				 Extent_Reporting.Log_Pass("ProviderGroupName1","ProviderGroupName1 is disable", test, driver);
			}
			action.inputText(icra_elements.ContractID1, "abc", "abc");
			if(icra_elements.ContractID1.getAttribute("value").contentEquals("abc"))
			{
				 Extent_Reporting.Log_Fail("ContractID1","ContractID1 is not disable", test, driver);				
			}
			else
			{
				 Extent_Reporting.Log_Pass("ContractID1","ContractID1 is disable", test, driver);
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkAllFieldsContractScreen() failed", test, driver);
				throw new Exception(e.getMessage());
			}
    	 }
		
		public void CheckAllFieldsinPaymentTab() throws Exception
		{
			try
			{
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Payments')]"));
			action.clickButton(w1, "Payments");
			Extent_Reporting.Log_Message("Checking all fields in Payment tab",test,driver);
			CheckElementDisplay(icra_elements.GroupName_Payment,"GroupName_Payment","GroupName_Payment");
			CheckElementDisplay(icra_elements.PayeeName_Payment,"PayeeName_Payment","PayeeName_Payment");
			CheckElementDisplay(icra_elements.BankName_Payment,"BankName_Payment","BankName_Payment");
			CheckElementDisplay(icra_elements.PaymentTypeVal_Payment,"PaymentTypeVal_Payment","PaymentTypeVal_Payment");
			CheckElementDisplay(icra_elements.BankAcNO_Payment,"BankAcNO_Payment","BankAcNO_Payment");
			CheckElementDisplay(icra_elements.RoutingNo_Payment,"RoutingNo_Payment","RoutingNo_Payment");
			CheckElementDisplay(icra_elements.ChequeRadio_Payment,"ChequeRadio_Payment","ChequeRadio_Payment");
			CheckElementDisplay(icra_elements.EFTRadio_Payment,"EFTRadio_Payment","EFTRadio_Payment");
			CheckElementDisplay(icra_elements.PaymentType_Payment,"PaymentType_Payment","PaymentType_Payment");
			CheckElementDisplay(icra_elements.HolderName_Payment,"HolderName_Payment","HolderName_Payment");
			CheckElementDisplay(icra_elements.Amt_Payment,"Amt_Payment","Amt_Payment");
			CheckElementDisplay(icra_elements.Save_Payment,"Save_Payment","Save_Payment");			
			Extent_Reporting.Log_Message("All Fields In Contact Tab are present",test,driver);
			Select se=new Select(icra_elements.PaymentType_Payment);
			List<WebElement> elements=se.getOptions();
			Iterator<WebElement> str=elements.iterator();
			WebElement s;
			while(str.hasNext())
			{
				s=str.next();
				CheckFields(s.getText().trim());
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("CheckAllFieldsinPaymentTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		 }
		public void ClrEle(WebElement w) throws Exception
		{
			try
			{
			String ele=w.getAttribute("value");
			if(ele.length()>0)
			{		
			 for(int i=0;i<=ele.length();i++)
			 {	
			    w.sendKeys(Keys.BACK_SPACE);
			 }
			}
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ClrEle() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
		public void EnterProviderDetails() throws Exception
		{
			try
			{
			EnterNPIAndClickAdd_EditIcon();
			action.ScrollToBottom();
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Address')]"));
			action.clickButton(w1, "Address");
			WebElement w2=driver.findElement(By.xpath("//li//a[contains(@href,'Provider')]"));
			action.clickButton(w2, "Provider");
			Extent_Reporting.Log_Message("Checking Mandatory Fields Vaildation Message........",test,driver);
			action.ScrollToBottom();
			ClrEle(icra_elements.FirstName_Provider);
			ClrEle(icra_elements.LastName_Provider);
			action.clickButton(icra_elements.Save_Provider,"Save Button Of Provider");
			Extent_Reporting.Log_Message("Save button Of Provider Detail is Clicked",test,driver);			
			boolean status=CheckMandatoryFieldMessage(driver.findElement(By.xpath("//div[@class='col-md-2'][2]"
					+ "//div[1]//div[2]/div")));
			if(status) 
			{
			  Extent_Reporting.Log_Pass("FirstName","First Name Message is Correct", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("FirstName","First Name Message is not Correct", test, driver);
			}
			boolean status1=CheckMandatoryFieldMessage(driver.findElement(By.xpath("//div[@class='col-md-2'][4]"
					+ "//div[1]//div[2]/div")));
			if(status1) 
			{
			    Extent_Reporting.Log_Pass("LastName","Last Name Message is Correct", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("LastName","Last Name Message is Not Correct", test, driver);
			}
			action.inputText(icra_elements.FirstName_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "FirstName")+"", "First Name");
			Extent_Reporting.Log_Message("First Name is Entered",test,driver);
	        firstname=icra_elements.FirstName_Provider.getAttribute("value");	        
	        action.inputText(icra_elements.LastName_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "LastName")+"", "Last Name");
			Extent_Reporting.Log_Message("Last Name is Entered",test,driver);
			Lastname=icra_elements.LastName_Provider.getAttribute("value");			     
			ClrEle(icra_elements.Tax_Identification_Number_Provider);			
			action.inputText(icra_elements.Tax_Identification_Number_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "TaxNumber")+"", "Tax Number");
			Extent_Reporting.Log_Message("Tax Number is Entered",test,driver);
			Taxnumber=icra_elements.Tax_Identification_Number_Provider.getAttribute("value");			
			ClrEle(icra_elements.TaxCode_Provider);
			action.inputText(icra_elements.TaxCode_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "TaxCode")+"", "Tax Code");
			Extent_Reporting.Log_Message("Tax Code is Entered",test,driver);
			TaxCode=icra_elements.TaxCode_Provider.getAttribute("value");			
			ClrEle(icra_elements.Speclty_Provider);
			action.inputText(icra_elements.Speclty_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "Speciality")+"", "Speciality");
			Extent_Reporting.Log_Message("Speciality is Entered",test,driver);
			Speciality=icra_elements.Speclty_Provider.getAttribute("value");		 						
			action.selectDDByText(icra_elements.CommunicationMode_Provider, ""+ExcelHandling.GetExcelData(TC_ID, "CommunicationMode")+"");
			Extent_Reporting.Log_Message("Communication mode is selected",test,driver);
			Select se=new Select(icra_elements.CommunicationMode_Provider);
			CommunicationMode=se.getFirstSelectedOption().getText();
			NPI=icra_elements.NPI_Provider.getAttribute("value");			
			action.clickButton(icra_elements.Save_Provider,"Save Button Of Provider");
			CheckElementDisplay(icra_elements.SaveMsg,"Message_Provider","Message_Provider");
			VerifyText(icra_elements.SaveMsg,""+ExcelHandling.GetExcelData(TC_ID,"Message")+"","Message is Correct","Message is Not Correct");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("EnterProviderDetails() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
		
		public void EnterAllDetailsInAddressTab() throws Exception
		{
			try
			{
			EnterNPIAndClickAdd_EditIcon();
			action.ScrollToBottom();
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Address')]"));
			action.clickButton(w1, "Address");
			Extent_Reporting.Log_Message("Address Tab is clicked",test,driver);			
			action.selectDDByText(icra_elements.AddressType_Address,""+ExcelHandling.GetExcelData(TC_ID, "AddressType")+"");
			Extent_Reporting.Log_Message("Address Type is selcted",test,driver);		
			ClrEle(icra_elements.Address1_Address);
			action.inputText(icra_elements.Address1_Address,""+ExcelHandling.GetExcelData(TC_ID,"Address1")+"","Address1");
			Extent_Reporting.Log_Message("Address1 is Entered",test,driver);
			Address1=icra_elements.Address1_Address.getAttribute("value");			
			ClrEle(icra_elements.Address2_Address);
			action.inputText(icra_elements.Address2_Address,""+ExcelHandling.GetExcelData(TC_ID, "Address2")+"","Address2");
			Extent_Reporting.Log_Message("Address2 is Entered",test,driver);
			Address2=icra_elements.Address2_Address.getAttribute("value");			
			ClrEle(icra_elements.State_Address);
			action.inputText(icra_elements.State_Address,""+ExcelHandling.GetExcelData(TC_ID, "State")+"","State_AddressTab");
			Extent_Reporting.Log_Message("State is Entered",test,driver);
			State=icra_elements.State_Address.getAttribute("value");			
			ClrEle(icra_elements.City_Address);
			action.inputText(icra_elements.City_Address,""+ExcelHandling.GetExcelData(TC_ID,"City")+"","City_AddressTab");
			Extent_Reporting.Log_Message("City is Entered",test,driver);
			City=icra_elements.City_Address.getAttribute("value");			
			ClrEle(icra_elements.Zip_Address);
			action.inputText(icra_elements.Zip_Address,""+ExcelHandling.GetExcelData(TC_ID,"zip")+"","Zip_AddressTab");
			Extent_Reporting.Log_Message("Zip is Entered",test,driver);
			Zip=icra_elements.Zip_Address.getAttribute("value");			
			ClrEle(icra_elements.FaxNo_Address);
			action.inputText(icra_elements.FaxNo_Address,""+ExcelHandling.GetExcelData(TC_ID,"fax")+"","Fax_AddressTab");
			Extent_Reporting.Log_Message("Fax is Entered",test,driver);
			Fax=icra_elements.FaxNo_Address.getAttribute("value");	
			action.ScrollToBottom();
			action.clickButton(icra_elements.Save_Address,"Save");
			Extent_Reporting.Log_Message("Save Button is Clicked",test,driver);			
			CheckElementDisplay(icra_elements.SaveMsg,"SaveMessage_Address","SaveMessage_Address");			
			VerifyText(icra_elements.SaveMsg,""+ExcelHandling.GetExcelData(TC_ID,"Message")+"","Message is Correct","Message is Not Correct");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("EnterAllDetailsInAddressTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
		
		
		public void EnterAllDetailsInContactTab() throws Exception
		{
			try
			{
			EnterNPIAndClickAdd_EditIcon();
			WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'ontact')]"));
			action.clickButton(w1, "Contact");
			action.selectDDByText(icra_elements.ContactType_Contact,""+ExcelHandling.GetExcelData(TC_ID, "ContactType")+"");
			Select condrop=new Select(icra_elements.ContactType_Contact);
			ContactType=condrop.getFirstSelectedOption().getText();			
			ClrEle(icra_elements.Email_Contact);
			action.inputText(icra_elements.Email_Contact,""+ExcelHandling.GetExcelData(TC_ID,"Email")+"","Email");
			Email=icra_elements.Email_Contact.getAttribute("value");			
			ClrEle(icra_elements.MailingAddress_Contact);
			action.inputText(icra_elements.MailingAddress_Contact,""+ExcelHandling.GetExcelData(TC_ID, "MailingAddress")+"","MailingAddress");
			MailingAddress=icra_elements.MailingAddress_Contact.getAttribute("value");			
			ClrEle(icra_elements.State_Contact);
			action.inputText(icra_elements.State_Contact,""+ExcelHandling.GetExcelData(TC_ID, "State")+"","State");
			State=icra_elements.State_Contact.getAttribute("value");			
			ClrEle(icra_elements.City_Contact);
			action.inputText(icra_elements.City_Contact,""+ExcelHandling.GetExcelData(TC_ID,"City")+"","City");
			City=icra_elements.City_Contact.getAttribute("value");			
			ClrEle(icra_elements.Zip_Contact);
			action.inputText(icra_elements.Zip_Contact,""+ExcelHandling.GetExcelData(TC_ID,"zip")+"","Zip");
			Zip=icra_elements.Zip_Contact.getAttribute("value");			
			ClrEle(icra_elements.Fax_Contact);
			action.inputText(icra_elements.Fax_Contact,""+ExcelHandling.GetExcelData(TC_ID,"fax")+"","Fax");
			Fax=icra_elements.Fax_Contact.getAttribute("value");			
			ClrEle(icra_elements.Phone_Contact);
			action.inputText(icra_elements.Phone_Contact,""+ExcelHandling.GetExcelData(TC_ID,"phone")+"","Phone");			
			Phone=icra_elements.Phone_Contact.getAttribute("value");			
			ClrEle(icra_elements.FirstName_Contact);
			action.inputText(icra_elements.FirstName_Contact,""+ExcelHandling.GetExcelData(TC_ID,"FirstName")+"","FirstName");			
			firstname=icra_elements.FirstName_Contact.getAttribute("value");		
			ClrEle(icra_elements.LastName_Contact);
			action.inputText(icra_elements.LastName_Contact,""+ExcelHandling.GetExcelData(TC_ID,"LastName")+"","LastName");			
			Lastname=icra_elements.LastName_Contact.getAttribute("value");	
			action.ScrollToBottom();
			action.clickButton(icra_elements.Save_Contact,"Save");								
			CheckElementDisplay(icra_elements.SaveMsg,"SaveMessage_Contact","SaveMessage_Contact");			
			VerifyText(icra_elements.SaveMsg,""+ExcelHandling.GetExcelData(TC_ID,"Message")+"","Message is Correct","Message is Not Correct");
			}
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("EnterAllDetailsInContactTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
			
		}
				
		public void EnterDocumentDetails(String path) throws Exception
		{
			try
			{
			EnterNPIAndClickAdd_EditIcon();
			 action.ScrollToBottom();
			 WebElement w2=driver.findElement(By.xpath("//li//a[contains(@href,'Documents')]"));
			 action.clickButton(w2, "Documents");
			 Extent_Reporting.Log_Message("Vaildating Mandatory Fields Message.......",test,driver);
			 action.Scroll(icra_elements.UploadDocument_Document);
			 action.clickButton(icra_elements.UploadDocument_Document, "Upload Document");						 
			 CheckMandatoryFieldMessage(driver.findElement(By.xpath("//select[@formcontrolname='documentType']/parent::label/parent::div/following-sibling::div")));
			 CheckMandatoryFieldMessage(driver.findElement(By.xpath("//select[@formcontrolname='DocumentYear']/parent::label/parent::div/following-sibling::div")));			 
			 CheckMandatoryFieldMessage(driver.findElement(By.xpath("//input[@formcontrolname='documentTitle']/parent::label/parent::div/following-sibling::div")));
			 action.selectDDByText(icra_elements.DocumentType_Document, ""+ExcelHandling.GetExcelData(TC_ID,"DocType")+"");
			 Select se=new Select(icra_elements.DocumentType_Document);			 
			 DocumentType = se.getFirstSelectedOption().getText();				 
			 action.selectDDByText(icra_elements.DocumentYear_Document, ""+ExcelHandling.GetExcelData(TC_ID,"DocYear")+"");			
			 Select yeardropdown=new Select(icra_elements.DocumentYear_Document);			 
			 DocumentYear=yeardropdown.getFirstSelectedOption().getText();			 
			 DocumentTitle = "Title_"+new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());
			 action.inputText(icra_elements.DocumentTitle_Document,DocumentTitle,"Document Title");			 	 
			 action.inputText(icra_elements.SelectFile_Document,path,"File Path");			 			 
			 action.clickButton(icra_elements.UploadDocument_Document, "Upload Document");						 
			 WebElement w3=driver.findElement(By.xpath("//div[@class='toast-message ng-star-inserted']"));
			 CheckElementDisplay(w3,"SaveMessage_Document","SaveMessage_Document");			
			 if(w3.getText().trim().equals(""+ExcelHandling.GetExcelData(TC_ID,"Message")+""))
			 {
				Extent_Reporting.Log_Pass(""+ExcelHandling.GetExcelData(TC_ID,"Message")+"","Message is Correct", test, driver);
			 }
			 else
			 {
				 Extent_Reporting.Log_Fail(""+ExcelHandling.GetExcelData(TC_ID,"Message")+"","Message is not Correct", test, driver);
			 }
			}
			 catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("EnterDocumentDetails() failed", test, driver);
					throw new Exception(e.getMessage());
				}
		 }
		
		public void VaildateTextDataInProviderTab() throws Exception
		{
	        try
	        {
			action.ScrollToBottom();		 
			 WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Provider')]"));
			 action.clickButton(w1, "Provider");
			 Extent_Reporting.Log_Message("Checking all fields in provider tab",test,driver);
			 VerifyFieldsText(icra_elements.FirstName_Provider,firstname);
			 VerifyFieldsText(icra_elements.LastName_Provider,Lastname);			
			 VerifyFieldsText(icra_elements.Tax_Identification_Number_Provider,Taxnumber);
			 VerifyFieldsText(icra_elements.TaxCode_Provider,TaxCode);
			 VerifyFieldsText(icra_elements.Speclty_Provider,Speciality);			
			 if(CommunicationMode.trim().equals(""+ExcelHandling.GetExcelData(TC_ID, "CommunicationMode")+""))
			 {	
				 Extent_Reporting.Log_Pass("CommunicationModeDrop","Communication Mode is saved in provider tab", test, driver);
			 }
			 else
			 {
				 Extent_Reporting.Log_Fail("CommunicationModeDrop","Communication Mode is not saved in provider tab", test, driver);
			 }
			 VerifyFieldsText(icra_elements.NPI_Provider,NPI);
			 Extent_Reporting.Log_Message("All Fields Text are verified",test,driver);
	        }
			 catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("VaildateTextDataInProviderTab() failed", test, driver);
					throw new Exception(e.getMessage());
				}
		}
		
		 public void ValidateInvaildDataFieldMessage() throws Exception
	        {
	        	try
	        	{
			    EnterNPIAndClickAdd_EditIcon();
	        	action.ScrollToBottom();
	        	WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Provider')]"));
				action.clickButton(w1, "Provider");				
				ClrEle(icra_elements.FirstName_Provider);
				Extent_Reporting.Log_Message("First Name Field is cleared",test,driver);
				action.inputText(icra_elements.FirstName_Provider,"@@","First Name field");
				ClrEle(icra_elements.LastName_Provider);
				Extent_Reporting.Log_Message("Last Name Field is cleared",test,driver);
				action.inputText(icra_elements.LastName_Provider,"@@","Last Name field");
				action.ScrollToBottom();
				action.clickButton(icra_elements.Save_Provider,"Save button");
				Extent_Reporting.Log_Message("Save Button is clicked",test,driver);
				Extent_Reporting.Log_Message("Checking field vaildation message...",test,driver);
				CheckMandatoryFieldMessage(icra_elements.FirstName_Provider);
				CheckMandatoryFieldMessage(icra_elements.LastName_Provider);  
	        	}
				catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("ValidateInvaildDataFieldMessage() failed", test, driver);
					throw new Exception(e.getMessage());
				}
	        }
		 
		public void ChkProviderTxtDtaInGrid() throws Exception
		{
			try
			{
			VerifyText(icra_elements.FirstName_GridTable,firstname,"First Name is saved in Grid table","First Name is not saved in Grid table");
			 VerifyText(icra_elements.LastName_GridTable,Lastname,"Lastname is saved in Grid table","Lastname is not saved in Grid table");
			 VerifyText(icra_elements.Specialty_GridTable,Speciality,"Speciality is saved in Grid table","Speciality is not saved in Grid table");
			}
			 catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("ChkProviderTxtDtaInGrid() failed", test, driver);
					throw new Exception(e.getMessage());
				}
		}
		
		public void ChkAddressTxtDtaInGrid() throws Exception
		{
		   try
		   {
		   for(int i=6;i<=14;i++)
		   {
		     WebElement w=driver.findElement(By.xpath("//span[@aria-colindex='"+i+"']"));
		     JavascriptExecutor js = (JavascriptExecutor)driver; 
			 js.executeScript("arguments[0].scrollIntoView()", w);
		   }
		   VerifyText(icra_elements.Fax_1_GridTable,Fax,"Fax is saved in Grid table","Fax is not saved in Grid table");
		   VerifyText(icra_elements.State_1_GridTable,State,"State is saved in Grid table","State is not saved in Grid table");
		   VerifyText(icra_elements.City_1_GridTable,City,"City is saved in Grid table","City is not saved in Grid table");
		   VerifyText(icra_elements.Address2_GridTable,Address2,"Address2 is saved in Grid table","Address2 is not saved in Grid table");
		   VerifyText(icra_elements.Address1_GridTable,Address1,"Address1 is saved in Grid table","Address1 is not saved in Grid table");
		   }
		   catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("ChkAddressTxtDtaInGrid() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}	
		
		
		
		public void VaildateTextDatainAddressTab() throws Exception
		{
			 try
			 {
			 action.ScrollToBottom();
			 WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'Address')]"));
			 action.clickButton(w1, "Address");
			 Extent_Reporting.Log_Message("Checking all Data Of Text Boxes in Address tab",test,driver);
			 action.selectDDByText(icra_elements.AddressType_Address,""+ExcelHandling.GetExcelData(TC_ID, "AddressType")+"");
			 WaitElement(icra_elements.ProviderManagementTab,20);			
			 VerifyFieldsText(icra_elements.Address1_Address,Address1);
			 VerifyFieldsText(icra_elements.Address2_Address,Address2);
			 VerifyFieldsText(icra_elements.State_Address,State);
			 VerifyFieldsText(icra_elements.City_Address,City);
			 VerifyFieldsText(icra_elements.Zip_Address,Zip);
			 VerifyFieldsText(icra_elements.FaxNo_Address,Fax);
			 Select condrop=new Select(icra_elements.AddressType_Address);
			 AddressType=condrop.getFirstSelectedOption().getText();
			 if(AddressType.trim().equals(""+ExcelHandling.GetExcelData(TC_ID, "AddressType")+""))
			 {
				Extent_Reporting.Log_Pass("AddressTypeDrop","Address type is saved in Address tab", test, driver);
			 }
			 else
			 {
				 Extent_Reporting.Log_Fail("AddressTypeDrop","Address type is not saved in address tab", test, driver);
			 }
			 Extent_Reporting.Log_Message("All Fields Text are verified",test,driver);
			 }
			 catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("VaildateTextDatainAddressTab() failed", test, driver);
					throw new Exception(e.getMessage());
				}
		}
		
		public void VaildateTextDatainContactTab() throws Exception
		{
			 try
			 {
			 WebElement w1=driver.findElement(By.xpath("//li//a[contains(@href,'ontact')]"));
			 action.clickButton(w1, "Contact");
			 Extent_Reporting.Log_Message("Checking all Data Of Text Boxes in Contact tab",test,driver);
			 log.info("++++++++++"+firstname.trim());
			 VerifyFieldsText(icra_elements.FirstName_Contact,firstname.trim());
			 VerifyFieldsText(icra_elements.LastName_Contact,Lastname);
			 VerifyFieldsText(icra_elements.Email_Contact,Email);
			 VerifyFieldsText(icra_elements.MailingAddress_Contact,MailingAddress);
			 VerifyFieldsText(icra_elements.State_Contact,State);
			 VerifyFieldsText(icra_elements.City_Contact,City);
			 VerifyFieldsText(icra_elements.Zip_Contact,Zip);
			 VerifyFieldsText(icra_elements.Fax_Contact,Fax);
			 VerifyFieldsText(icra_elements.Phone_Contact,Phone);
			 Select se=new Select(icra_elements.ContactType_Contact);
			if(se.getFirstSelectedOption().getText().trim().equals(ContactType.trim()))
			{
			   Extent_Reporting.Log_Pass("ContactTypeDrop","Contact type is saved in contact tab", test, driver);
			}
			else
			 {
				 Extent_Reporting.Log_Fail("ContactTypeDrop","Contact type is not saved in contact tab", test, driver);
			 }
			Extent_Reporting.Log_Message("All Fields Text are verified",test,driver);
			 }
			catch (Exception e)
			{
	            Extent_Reporting.Log_FailMessage("VaildateTextDatainContactTab() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		}
			
				
		public void VaildateTextDatainDocumentTab() throws Exception
		{
			try
			{
			String Username=ExcelHandling.GetExcelData(TC_ID, "LoginUsername");
			WebElement w=driver.findElement(By.xpath("//li//a[contains(@href,'Documents')]"));
			 action.clickButton(w, "Document");
			 Extent_Reporting.Log_Message("Checking all fields in Document tab",test,driver);
			 String xpath="//div[@class='ag-root ag-unselectable ag-layout-normal'][@aria-colcount='6']/div[3]//div[@role='rowgroup']/div";
			 List rows=driver.findElements(By.xpath(xpath));			 
			 for(int i=0;i<=rows.size()+1;i++)
			 {
	                 String text=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='4']")).getText();					 
					 if(text.equals(DocumentTitle))
					 {
						 WebElement w1=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='1']"));
						 CheckElementDisplay(w1,"Download icon_Document","Download icon_Document");
						 action.clickButton(w1, "Download icon_Document");					 
						 Extent_Reporting.Log_Message("Download icon is present and It is clickable",test,driver);						 
						 WebElement w2=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='2']"));
						 VerifyText(w2,DocumentType.trim(),"Doc.type is correct in grid table","Doc.type is not correct in grid table");
						 WebElement w3=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='3']"));
						 VerifyText(w3,DocumentYear.trim(),"Document Year is correct in grid table","Documen tYear is not correct in grid table");
						 WebElement w4=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='4']"));
						 VerifyText(w4,DocumentTitle.trim(),"Document title is correct in grid table","Document title is not correct in grid table");
						 WebElement w5=driver.findElement(By.xpath(xpath+"[@row-id='"+i+"']/div[@aria-colindex='6']"));
						 JavascriptExecutor js = (JavascriptExecutor)driver; 
						 js.executeScript("arguments[0].scrollIntoView()", w5);
						 if(w5.getText().trim().equalsIgnoreCase(Username.trim()))
						 {
							 Extent_Reporting.Log_Pass("UserName_Doctbl","Username is displayed", test, driver);
						 }
						 else
						 {
							 Extent_Reporting.Log_Fail("UserName_Doctbl","Username is not displayed", test, driver);
						 }
						
												 
//						 Extent_Reporting.Log_Message("Checking Document Opening Or Not...");
//						 driver.findElement(By.xpath(xpath+"/tr["+i+"]/td[4]")).click();
//						 WaitElement(icra_elements.LogOutLink,20);
//						 List pages=driver.findElements(By.xpath("//div[@class='pdfViewer removePageBorders']/div"));
//						 if(pages.size()>0)
//						 {
//						    Extent_Reporting.Log_Message("Document is Opening");
//						 }
//						 else
//						 {
//							 Assert.fail("Document is Not Opening");
//						 }
						 break;
					 }						
				  }
			  Extent_Reporting.Log_Message("All Fields Text are verified",test,driver);	
			}
			  catch (Exception e)
				{
		            Extent_Reporting.Log_FailMessage("VaildateTextDatainDocumentTab() failed", test, driver);
					throw new Exception(e.getMessage());
				}
	    	}
		

        
        
}