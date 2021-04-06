package com.qa.BusinessLogic;
/**
 * @author pbhattacharjee

 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.JavaUtilities;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PageObjects_Priyanka;

public class ICRA_BusinessLogic_Priyanka extends Extent_Reporting{
	
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Priyanka icraPO; 
	
	
	//Constructor
	public ICRA_BusinessLogic_Priyanka(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icraPO= new ICRA_PageObjects_Priyanka(driver);
	}
	
	/*-----------------------GENERIC METHOD LIST--------------------------*/
	//Method to select the client after login
	public void ICRA_Client_Select() throws Throwable {
        boolean flag = false; int indexval = 0;
        try {
               action.WaitUntilDisplayed(icraPO.SelectClient);
               action.clickButton(icraPO.SelectClient, "SelectClient");
               List<WebElement> options = driver.findElements(By.xpath("//select[@id='ddlSelectClient']/option"));
               for(int i=2;i<=options.size();i++)
               {
                      WebElement optionname = driver.findElement(By.xpath("(//select[@id='ddlSelectClient']/option)["+i+"]"));
                      if ((optionname.getText().trim())
                                   .equalsIgnoreCase(ExcelHandling.GetExcelData(TC_ID, "ClientName")))
                            indexval = i;
                            flag = true;
               }
               action.selectDDByIndex(icraPO.SelectClient, indexval-1);
               action.clickButton(icraPO.Submit, "Submit selected client");
               action.WaitUntilDisplayed(icraPO.Menu);
               System.out.println(flag);
               if (flag == true) {
                      Extent_Reporting.Log_Pass("Main Page", "Desired client found.", test, driver);
               } else {
                      Extent_Reporting.Log_Fail("Main Page", "Desired client not found.", test, driver);
                      throw new Exception();
               }

        } catch (Exception e) {
               Extent_Reporting.Log_FailMessage("ICRA_Client_Select() failed - " + e.getMessage(), test, driver);
               throw new Exception(e.getMessage());

        }

  }


	  
	//Method to select the module and submodule
	public void ICRA_Menu_Selection_Local(String sub) throws Throwable
	{
		WebElement mainmenu = null;
		WebElement submenu = null;
		try {
			action.WaitUntilDisplayed(icraPO.Menu);
			Extent_Reporting.Log_Pass("Main Page", "Main Page loaded", test, driver);
			if(sub.isBlank()) 
			{
				sub = ExcelHandling.GetExcelData(TC_ID, "SubMenu");
			}
			
			 submenu = driver.findElement(By.xpath("//a[contains(text(),'"+sub+"')]"));
				if(submenu.isDisplayed())
				{
					action.JSclickButton(submenu, sub);
					driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
					//action.WaitUntilDisplayed(driver.findElement(By.xpath("//li[@class='breadcrumb-active']//*[contains(text(),'"+sub+"')]")));
					Extent_Reporting.Log_Pass("Menu", sub+" selected", test, driver);
				}
				else
				{
					String style = action.elementGetAttribute(icraPO.SidebarLength, "style", "Style value");
					if(style.contains("margin"))
					{
						mainmenu = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]"));
						submenu = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]//following::a[contains(text(),'"+sub+"')]"));
						action.JSclickButton(mainmenu, ExcelHandling.GetExcelData(TC_ID, "MainMenu"));
					}
					else
					{
						mainmenu = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]//preceding-sibling::span[contains(@class,'las')]"));
						action.mouseHover(mainmenu);
						submenu = driver.findElement(By.xpath("//a[contains(text(),'"+sub+"')]"));
						
						
					}
					ICRA_Submenu_List(mainmenu);
					action.JSclickButton(submenu, sub);
					driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
					//action.WaitUntilDisplayed(driver.findElement(By.xpath("//li[@class='breadcrumb-active']//*[contains(text(),'"+sub+"')]")));
					Extent_Reporting.Log_Pass("Menu", sub+" selected", test, driver);
				}
		}catch (Exception e) {
			//Extent_Reporting.Log_FailMessage("ICRA_Menu_Selection() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
		
	  }
	
	public void ICRA_Menu_Selection(String sub) throws Throwable
	{
		WebElement mainmenu = null;
		WebElement submenu = null;
		try {
			action.WaitUntilDisplayed(icraPO.Menu);
			Extent_Reporting.Log_Pass("Main Page", "Main Page loaded", test, driver);
			if(sub.isBlank()) 
			{
				sub = ExcelHandling.GetExcelData(TC_ID, "SubMenu");
			}
			
			 	submenu = driver.findElement(By.xpath("//a[contains(text(),'"+sub+"')]"));
				if(submenu.isDisplayed())
				{
					action.JSclickButton(submenu, sub);
					driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
					//action.WaitUntilDisplayed(driver.findElement(By.xpath("//li[@class='breadcrumb-active']//*[contains(text(),'"+sub+"')]")));
					Extent_Reporting.Log_Pass("Menu", sub+" selected", test, driver);
				}
				else
				{
					mainmenu = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]"));
					submenu = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]//following::a[contains(text(),'"+sub+"')]"));
					action.JSclickButton(mainmenu, ExcelHandling.GetExcelData(TC_ID, "MainMenu"));
				}
				ICRA_Submenu_List(mainmenu);
				action.JSclickButton(submenu, sub);
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				Extent_Reporting.Log_Pass("Menu", sub+" selected", test, driver);
				
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_Menu_Selection() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
		
	  }
	
	//Method to list out all the submodules under a specific mainmodule
	public void ICRA_Submenu_List(WebElement mainmenu) throws Throwable
	{
		try {
			if(!(ExcelHandling.GetExcelData(TC_ID, "NoSubs").equals("")))
			{
			action.WaitUntilDisplayed(mainmenu);
			Extent_Reporting.Log_Pass("SubmenuList", "All submenus", test, driver);
			int subcount = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "NoSubs"));
			for(int i =1;i<=subcount;i++)
			{
				String submenu = driver.findElement(By.xpath("(//span[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "MainMenu")+"')]//following::ul//a)["+i+"]")).getText();
				Extent_Reporting.Log_Message("Submenu in "+i+" is :"+submenu, test, driver);
			}
			}
		} catch (Exception e) {
            Extent_Reporting.Log_FailMessage("ICRA_Submenu_List() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		}
		
	
	/*-----------------------CLIENT CONFIGURATION MODULE--------------------------*/
	//Method to verify the AddSubClient button , Company Logo and Disclaimer
	public void ICRA_AddSubClient_Logo_Footer() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.Menu);
			
			if(icraPO.CompanyLogo.isDisplayed())
			   Extent_Reporting.Log_Pass("CompanyLogo", "CompanyLogo is displayed", test, driver);
			else
				Extent_Reporting.Log_Fail("CompanyLogo", "CompanyLogo is not displayed", test, driver);
			
			if(icraPO.Copyrights.isDisplayed())
				   Extent_Reporting.Log_Pass("Copyrights", "Copyrights is displayed", test, driver);
				else
					Extent_Reporting.Log_Fail("Copyrights", "Copyrights is not displayed", test, driver);
			action.elementGetText(icraPO.Copyrights, "");
			
			if(icraPO.AddSubClients.isDisplayed())
				   Extent_Reporting.Log_Pass("AddSubClients", "AddSubClients is displayed", test, driver);
				else
					Extent_Reporting.Log_Fail("AddSubClients", "AddSubClients is not displayed", test, driver);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_AddSubClient_Logo_Footer() failed", test, driver);
			throw new Exception(e.getMessage());
			}
			
	}
	
	public void ICRA_CC_Fields() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.MandatoryFields);
			Extent_Reporting.Log_Pass("CCFields", "All fields", test, driver);
			List<WebElement> label = driver.findElements(By.xpath("//form[contains(@class,'form-group')]//label/strong"));
			for(int i=1;i<=label.size();i++)
			{
				String list = driver.findElement(By.xpath("(//form[contains(@class,'form-group')]//label/strong)["+i+"]")).getText();
				Extent_Reporting.Log_Message("Fieldname in "+i+" is :"+list, test, driver);
				
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_Fields() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
		
	  }
	public void ICRA_CC_Mandatory_Fields() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.MandatoryFields);
			Extent_Reporting.Log_Pass("MandatoryFields", "All mandatory fields", test, driver);
			List<WebElement> mandate = driver.findElements(By.xpath("//div[@class='required-icon']//preceding-sibling::label"));
			
			for(int i=1;i<=mandate.size();i++)
			{
				String list = driver.findElement(By.xpath("(//div[@class='required-icon']//preceding-sibling::label)["+i+"]")).getAttribute("for");
				Extent_Reporting.Log_Message("Mandatory Fieldname in "+i+" is :"+list, test, driver);
				
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_Mandatory_Fields() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
		
	  }
	
	public void ICRA_CC_Placeholders() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.MandatoryFields);
			Extent_Reporting.Log_Pass("Placeholder", "All placeholders in fields", test, driver);
			List<WebElement> placeholder = driver.findElements(By.xpath("//label[@class='field prepend-icon']/input"));
			for(int i=1;i<=placeholder.size();i++)
			{
				String ele = driver.findElement(By.xpath("(//form[contains(@class,'form-group')]//label/strong)["+i+"]")).getText();
				String list = driver.findElement(By.xpath("(//label[@class='field prepend-icon']/input)["+i+"]")).getAttribute("placeholder");
				Extent_Reporting.Log_Message("Watermark in  "+ele+" is :"+list, test, driver);
				
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_Placeholders() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
		
	  }
	
	public void ICRA_CC_Attribute_Type() throws Throwable
	{
		try {
			driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait,TimeUnit.SECONDS);
			
			action.WaitUntilDisplayed(icraPO.AttributeTypeDD);
			action.clickButton(icraPO.AttributeTypeDD, "Attribute Type DD");
			Extent_Reporting.Log_Pass("AttributeTypeDD", "Element under AttributeTypeDD", test, driver);
			List<WebElement> placeholder = driver.findElements(By.xpath("//strong[contains(text(),'Attribute Type')]//following::select/option"));
			
			for (int i=2;i<=placeholder.size();i++)
			{
				String optionname = driver.findElement(By.xpath("//strong[contains(text(),'Attribute Type')]//following::select/option["+i+"]")).getText();
				Extent_Reporting.Log_Message("Option in "+(i-1)+" is :"+optionname, test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_Attribute_Type() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
	  }
	
	public void ICRA_CC_Add_Attribute_Type() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.AttributeTypeDD);
			if(!(ExcelHandling.GetExcelData(TC_ID, "AttributeType").equals("")))
			 action.selectDDByText(icraPO.AttributeTypeDD, ExcelHandling.GetExcelData(TC_ID, "AttributeType"));
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_Add_Attribute_Type() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
	  }
	
	
	
	public void ICRA_Save() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.Save);
			action.clickButton(icraPO.Save, "Save button");
			Extent_Reporting.Log_Pass("Save", "Save clicked", test, driver);
			 try
			    {
			      WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
			       //if(action.isElementDisplayed(icra_elements.AlertDialog,"AlertDialog"))
			      if(action.isElementDisplayed(w,"AlertDialog"))
			       {
			           action.elementGetText(w, "Alert dialog");
			           action.ScrollToTop();
			           action.clickButton(icraPO.Homepage, "Homepage");
			       }
			    }
			    catch(Exception e)
			    {
			    	List<WebElement> blankerror = driver.findElements(By.xpath("(//span[@class='error'])"));
					if((blankerror.size())>0)
					{
					for (int i=1;i<=blankerror.size();i++)
					{
						String ele = driver.findElement(By.xpath("(//span[@class='error']//preceding::label[contains(@class,'field-label')]/strong)["+i+"]")).getText();
						String errormsg = driver.findElement(By.xpath("(//span[@class='error'])["+i+"]")).getText();
						Extent_Reporting.Log_Message("Error  in field "+ele+" is :"+errormsg, test, driver);
					}
					}
			    }
			
			action.waitForPageLoad();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_Save() failed", test, driver);
			throw new Exception(e.getMessage());
			}
	  }
	
	public String clientVerifyProject(String verifyEle) throws Throwable
	{
		String [] fielddata = null;
		try {
			
			fielddata = verifyEle.split(",");
			action.clickButton(icraPO.ClientNameProjectConf, "Client created to be verified");
			boolean pressence = action.elementDisplayed(driver.findElement(By.xpath("//option[contains(text(),'"+fielddata[0]+"')]")));
			if(pressence)
			{
				action.selectDDByText(icraPO.ClientNameProjectConf, fielddata[0]);
				Extent_Reporting.Log_Pass("Client", "Client present with the name : "+fielddata[0], test, driver);
				
			}
			else
			{
				Extent_Reporting.Log_Fail("Client", "Client not present with the name : "+fielddata[0], test, driver);
			}
			
			action.waitForPageLoad();
			//action.selectDDByValue(icraPO.SubClientNameProjectConf, fielddata[1]);
				
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("clientVerifyProject() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return fielddata[0];
		
	}
	
	public void Logout() throws Throwable
	{ 
		try {
			action.WaitUntilDisplayed(icraPO.ProfileDD);
			action.clickButton(icraPO.ProfileDD, "Profile Dropdown");
			//Thread.sleep(20000);
			driver.manage().timeouts().pageLoadTimeout(20000,TimeUnit.SECONDS);
			action.WaitUntilDisplayed(icraPO.Logout);
			action.clickButton(icraPO.Logout, "Logout");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Logout() failed", test, driver);
			throw new Exception(e.getMessage());
			}
	  }
	
	public void displayHashmap(HashMap<String, String> datamap) throws Throwable
	{
		try {
			if(!datamap.isEmpty()) {
				Iterator<String> itr = datamap.keySet().iterator();
				while (itr.hasNext())
				{
					String key = itr.next().toString();
					String value = datamap.get(key).toString();
			        Extent_Reporting.Log_Message(key + " = " + value, test, driver);
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("displayHashmap() failed", test, driver);
			throw new Exception(e.getMessage());
			}
	}
	
	
	public String ICRA_CC_DataEntry() throws Throwable 
	{
		
		String ele = null;
		try {
			String letters = randomAlphabet();
			action.WaitUntilDisplayed(icraPO.Clear);
			action.clickButton(icraPO.Clear, "Clear");
			
			action.WaitUntilDisplayed(icraPO.MandatoryFields);
			String data = ExcelHandling.GetExcelData(TC_ID, "FieldData");
			String [] fielddata = data.split(",");
			List<WebElement> enterdata = driver.findElements(By.xpath("//label[@class='field prepend-icon']/input"));
			
			String element = driver.findElement(By.xpath("(//label[@class='field prepend-icon']/input)[1]")).getAttribute("placeholder");
			WebElement datatoenter = driver.findElement(By.xpath("(//label[@class='field prepend-icon']/input)[1]"));//@class
			action.inputText(datatoenter, fielddata[0]+letters, "For "+element+" data entered is :"+fielddata[0]);
			String verifyele = fielddata[0]+letters;
			String sub = ICRA_CC_SubClients();
			for (int i=4 , j=1;i<=enterdata.size();i++,j++)
			{
				element = driver.findElement(By.xpath("(//label[@class='field prepend-icon']/input)["+i+"]")).getAttribute("placeholder");
				datatoenter = driver.findElement(By.xpath("(//label[@class='field prepend-icon']/input)["+i+"]"));
				action.inputText(datatoenter, fielddata[j], "For "+element+" data entered is :"+fielddata[j]);
			}
			ICRA_CC_Add_Attribute_Type();
			ele = verifyele+","+sub;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_DataEntry() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return ele;
	  }
	
	public String ICRA_CC_SubClients() throws Throwable
	{
		String subverify = null;
		try {
			action.WaitUntilDisplayed(icraPO.SubClient);
			int noofsub = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "NoSubClients"));
			String data = ExcelHandling.GetExcelData(TC_ID, "SubClientsData");
			String [] fielddata = data.split(",");
			if(noofsub>1)
			{
				for (int i=0,j=0 ;i<noofsub;i++,j++)
				{ 
					String letters = randomAlphabet();
					action.inputText(icraPO.SubClient, fielddata[j]+letters, "Data entered for SubClient "+i+" is :"+fielddata[j]);
					driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait,TimeUnit.SECONDS);
					subverify = fielddata[j]+letters;
					action.clickButton(icraPO.AddSubClients, "Add sub client no"+i);
					action.waitForPageLoad();
					 
				}
				Extent_Reporting.Log_Pass("SubClientList", "SubClients Added", test, driver);
				List<WebElement> options = driver.findElements(By.xpath("//select[@formcontrolname='MultiSubClient']/option"));
				for (WebElement list : options)
				{
					Extent_Reporting.Log_Message(list.getText(), test, driver);
				}
				
			}
			else if(noofsub==1)
			{
				action.inputText(icraPO.SubClient, fielddata[0], "Data entered for SubClient is :"+fielddata[0]);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_CC_SubClients() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return subverify;
		
		
		
	  }
	
	
	
	public void select_Project() throws Throwable
	{
		String msg = null;int iSelect = 0;
		try
		{
		action.WaitUntilDisplayed(icraPO.CodeReviewSelect);
		action.selectDDByText(icraPO.CodeReviewSelect, ExcelHandling.GetExcelData(TC_ID, "ProjectSelect"));
		Extent_Reporting.Log_Pass("CodeReviewSelect", "Selected the poject : "+ExcelHandling.GetExcelData(TC_ID, "ProjectSelect"), test, driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("select_Project() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void startProject() throws Throwable
	{
		String msg = null;
		try
		{
		action.WaitUntilDisplayed(icraPO.StartCodingBtn);
		action.clickButton(icraPO.StartCodingBtn, "Start button");
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try
		{
			WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
			  if(action.isElementDisplayed(w,"AlertDialog"))
			{
				msg = action.elementGetText(icraPO.AlertDialog, "AlertDialog");
				if((msg.contains("No record")) || (msg.contains("Hold period")))
				{
					Extent_Reporting.Log_Fail("error", msg, test, driver);
					throw new Exception();
				}
					
			}
			
		}
		catch(Exception e) 
		{throw new Exception();}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("startProject() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}

	
	public String chaseDetails() throws Throwable
	{
		String chase = null;
		try {
			action.WaitUntilDisplayed(icraPO.ChaseID);
			chase = action.elementGetText(icraPO.ChaseID, "Chase Id");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("chaseDetails() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		return chase;
	}
	
	public void pageCountCheck(boolean flag) throws Throwable
	{
		try {
			
			if(flag==true)
			{
				action.elementGetText(icraPO.PageCount, "PageCount");
			}
			else
			{
				WebElement Page_Count = driver.findElement(By.xpath("//input[@id='PageCount']"));
				action.elementGetText(Page_Count, "PageCount");
				String iSelect = Integer.toString(((int) (Math.random()*(999 - 1))) + 1);
				action.clearInputText(Page_Count, iSelect, iSelect);
			}
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("pageCountCheck() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	public boolean medicalRecordCheck() throws Throwable
	{
		boolean flag=false;
		try {
			try
			{ 
				WebElement w=driver.findElement(By.xpath("//button[contains(text(),'Chase ID')]//following::a[contains(@href,'.pdf')]"));
				if(action.isElementDisplayed(w,"MedicalRecord"))
				{
					String pdfUrl = action.elementGetAttribute(icraPO.MedicalRecord, "href", "PDF URL");
					action.clickButton(icraPO.MedicalRecord, "MedicalRecord");
					action.waitForPageLoad();
					String childurl = null;
					
					String mainWindowHandle = driver.getWindowHandle();
					for (String childWindowHandle : driver.getWindowHandles())
					{
					if(!childWindowHandle.equals(mainWindowHandle)){
						  driver.switchTo().window(childWindowHandle);
						  childurl = driver.getCurrentUrl(); 
						  action.waitForPageLoad();
						  if(childurl.equalsIgnoreCase(pdfUrl))
						  {
							  Extent_Reporting.Log_Pass("PDF", "Proper pdf file displayed", test, driver);
						  }
						  else
						  {
							  Extent_Reporting.Log_Fail("PDF", "Proper pdf file is not displayed", test, driver);
						  }
						  driver.close();
					 }
					}
					
					driver.switchTo().window(mainWindowHandle);
					flag=true;
					
				}
				    
					
			 }catch(Exception e)
			{
				Extent_Reporting.Log_Pass("MedicalRecord", "The project doesnot have a medical record", test, driver);
			}
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("medicalRecordCheck() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return flag;
		
	}
	
	public void datepicker(WebElement ele) throws Throwable
	{
		try {
			String month = JavaUtilities.datetime("MMM");
			String date = JavaUtilities.datetime("dd");
			String strPattern = "^0+(?!$)";
			date = date.replaceAll(strPattern, "");
			
			List<WebElement> allDates=driver.findElements(By.xpath("//tbody[contains(@class,'owl-dt-calendar-body')]//td[contains(@aria-label,'"+month+"')]"));
			
			for(WebElement tdele:allDates)
			{
				if(tdele.getText().trim().equalsIgnoreCase(date))
				{
					tdele.click();
					break;
				}
				
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("datepicker() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void dateChanges(WebElement ele , String name) throws Throwable
	{
		try {
			if(name.equalsIgnoreCase("FromDate"))
			{
				String selecteddate = icraPO.SelectedDate.getAttribute("aria-label").trim();
				String newDate = JavaUtilities.getPreviousDate(selecteddate, "MMMM dd, yyyy");
				String day = (newDate.split(",")[0]).split(" ")[1];
				String strPattern = "^0+(?!$)";
				day = day.replaceAll(strPattern, "");
				String updateDate = (newDate.split(",")[0]).split(" ")[0]+" "+day+","+newDate.split(",")[1];
				WebElement datetoselect = driver.findElement(By.xpath("//tbody[contains(@class,'owl-dt-calendar-body')]//td[contains(@aria-label,'"+updateDate+"')]"));
				action.JSclickButton(datetoselect, newDate);
				
			}
			else if(name.equalsIgnoreCase("ToDate"))
			{
				String selecteddate = icraPO.SelectedDate.getAttribute("aria-label").trim();
				String newDate = JavaUtilities.getNextDate(selecteddate, "MMMM dd, yyyy");
				String day = (newDate.split(",")[0]).split(" ")[1];
				String strPattern = "^0+(?!$)";
				day = day.replaceAll(strPattern, "");
				String updateDate = (newDate.split(",")[0]).split(" ")[0]+" "+day+","+newDate.split(",")[1];
				WebElement datetoselect = driver.findElement(By.xpath("//tbody[contains(@class,'owl-dt-calendar-body')]//td[contains(@aria-label,'"+updateDate+"')]"));
				action.JSclickButton(datetoselect, newDate);
				
			}
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("datepicker() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public String addCoding() throws Throwable
	{
		String chaseID = null;
		try {
			if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("BlindCoding"))
			{
				chaseID = blindCoding_Add();
				blindCoding_VerifyRecordCount();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("CDVCoding"))
			{
				VerifyRecordCount();
				chaseID = CDVCoding_Add();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoBlindCoding"))
			{
				chaseID = autoBlindCoding_Add();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoCDVCoding"))
			{
				chaseID = autoCDVCoding_Add();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("Optum2LR"))
			{
				chaseID = Optum2LRCoding_Add();
				//Optum2LRCoding_VerifyRecordCount();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("addCoding() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		return chaseID;
		
		
	}
	
	public void selectHoldChase() throws Throwable
	{
		int iSelect = 0;
		try
		{
			if(action.isElementDisplayed(icraPO.HoldTab, "HoldTab"))
			{
			List<WebElement> chases = driver.findElements(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)"));
			  if(chases.size() == 1)
			  {
				  iSelect = 1;
			  }
			  else if(chases.size() > 1)
			  {
				  Random index = new Random();
				  iSelect = index.nextInt((chases.size()) - 1) + 1;
				  System.out.println(iSelect);
			  }
			  WebElement selchase = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)["+iSelect+"]"));
			  System.out.println(selchase);
			  action.JSclickButton(selchase, selchase.getText());
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("selectHoldChase() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public String qualityControl_add() throws Throwable
	{
		String chaseID = null;
		try {
			if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("BlindCoding"))
			{
				chaseID = blindCoding_QC();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("CDVCoding"))
			{
				chaseID = CDVCoding_QC();
			}
			/*else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoBlindCoding"))
			{
				chaseID = autoBlindCoding_QC();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoCDVCoding"))
			{
				chaseID = autoCDVCoding_QC();
			}*/
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("Optum2LR"))
			{
				chaseID = Optum2LR_QC();
				//Optum2LRCoding_VerifyRecordCount();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("qualityControl_add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		return chaseID;
		
		
	}
	
	
	public String qualityAssurance_add() throws Throwable
	{
		String chaseID = null;
		try {
			/*if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("BlindCoding"))
			{
				chaseID = blindCoding_QA();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("CDVCoding"))
			{
				chaseID = CDVCoding_QA();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoBlindCoding"))
			{
				chaseID = autoBlindCoding_QA();
			}
			else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoCDVCoding"))
			{
				chaseID = autoCDVCoding_QA();
			}*/
			if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("Optum2LR"))
			{
				chaseID = Optum2LR_QA();
				//Optum2LRCoding_VerifyRecordCount();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("qualityControl_add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		return chaseID;
		
		
	}
	
	public String blindCoding_QC() throws Throwable
	{
		String chase = null;;
		try {
			chase = chaseDetails();
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			if(dxvalue == 0 && (ExcelHandling.GetExcelData(TC_ID, "ExtraRow")).equalsIgnoreCase(""))
			{
				allClickFunctionalities("Reject");
			}
			else
			{
			
			for(int i=1,j=2;i<=dxvalue;i++,j+=2)
			{
				if(j<=dxvalue)
				{
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+j+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+j+"]"));
				WebElement ErrorDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='QCCommentID'])["+j+"]//span[@class='ng-arrow-wrapper']"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@placeholder,'Comments')])["+i+"]"));
				WebElement ActionDD = driver.findElement(By.xpath("(//select[contains(@id,'Action')])["+j+"]"));
				
				
				action.Scroll(Comment);
				enterComment(Comment);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				int flag = enterAction(ActionDD);
				if(flag == 1)
				{
				enterError(ErrorDD);
				}
				
				
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				
				Extent_Reporting.Log_Pass("Details", "All details entered successfully", test, driver);
				}
				
			}
			action.ScrollToTop();
			addRow();
			submitButtonClick();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCoding_QC() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chase;
	}
	
	public String CDVCoding_QC() throws Throwable
	{
		String chase=null;
		try {
			chase = chaseDetails();
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			if(dxvalue == 0 && (ExcelHandling.GetExcelData(TC_ID, "ExtraRow")).equalsIgnoreCase(""))
			{
				allClickFunctionalities("Reject");
			}
			else
			{
			
			for(int i=1;i<=dxvalue;i++)
			{
				
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+i+"]//span[@class='ng-arrow-wrapper']"));
				WebElement ErrorDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='QCCommentID'])["+i+"]//span[@class='ng-arrow-wrapper']"));
				//WebElement Comment = driver.findElement(By.xpath("(//input[contains(@placeholder,'Comments')])["+i+"]"));
				WebElement ActionDD = driver.findElement(By.xpath("(//select[contains(@id,'Action')])["+i+"]"));
				
				
				action.Scroll(SecondaryDD);
				//enterComment(Comment);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				int flag = enterAction(ActionDD);
				if(flag == 1)
				{
				enterError(ErrorDD);
				}
				
				
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				
				Extent_Reporting.Log_Pass("Details", "All details entered successfully", test, driver);
				}
				
			}
			action.ScrollToTop();
			addRow();
			submitButtonClick();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("CDVCoding_QC() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		return chase;
	}
	
	public String Optum2LRCoding_Add() throws Throwable
	{
		String chaseID = "";
		try {
			
			chaseID = Optum2LR_InitialData();
			if(!(chaseID.isBlank()))
			{
				List<WebElement> dxRows = driver.findElements(By.xpath("(//i[@title='Row Save']/..)"));
				for(int i=2;i<dxRows.size();i+=2)
				{
					WebElement Dx = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'ICD')]//input)["+i+"]"));
							
					enter_Dx(Dx);
				}
				for(int i=1;i<= dxRows.size();i++)
				{
					WebElement Page = driver.findElement(By.xpath("(//input[contains(@formcontrolname,'PageNo')])["+i+"]"));
					WebElement Primary = driver.findElement(By.xpath("(//select[contains(@formcontrolname,'Primary')])["+i+"]"));
					WebElement SecondaryDD = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'SecondaryFindings')]//div[contains(@class,'trigger')])["+i+"]"));
					
					enter_Page(Page);
					enterPrimary(Primary);
					enter_Secondary(SecondaryDD);
					Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
					WebElement UpdateBtn = driver.findElement(By.xpath("(//i[@title='Row Save']/..)["+i+"]"));
					action.clickButton(UpdateBtn, "Update Button at position "+i+" is selected");
					action.waitForPageLoad();
					WebElement GreenTick = driver.findElement(By.xpath("(//i[@title='Row Save']//preceding::i[contains(@class,'pi-check')])["+i+"]"));
					if(GreenTick.isDisplayed())
					{
						Extent_Reporting.Log_Pass("Save", "Row "+i+" is saved", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail("Save", "Row "+i+" is not saved, check error", test, driver);
					}
				
				}
			action.ScrollToTop();
			driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			add_Row();
			action.ScrollToTop();
			submitButtonClick();
			}
		}
			catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Optum2LRCoding_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chaseID;
	}
	
	public String allClickFunctionalities(String buttonType) throws Throwable
	{
		String chaseID = null;
		try {
			chaseID = chaseDetails();
			buttonClickFunctionality(buttonType);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("allClickFunctionalities() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chaseID;
	}
	
	
		
	public void blindCoding_VerifyRecordCount() throws Throwable
	{
		
		try {
			List<WebElement> noOfTableData = driver.findElements(By.xpath("//tbody[@id='tbodytblCYData']//tr"));
			int tableSize = noOfTableData.size();
			String recordCount = action.elementGetText(icraPO.BlindCodingSavedRecordCount, "BlindCoding Saved Record Count");
			int rc = Integer.parseInt(recordCount);
			int noOfDx = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "NoDx"));
			if((tableSize == rc) && (tableSize == noOfDx))
			{
				Extent_Reporting.Log_Pass("VerifyCount", "Record count matches", test, driver);
				submitButtonClick();
				
			}
			else
			{
				Extent_Reporting.Log_Fail("VerifyCount", "Record count mismatch. From UI : "+tableSize+" . From excel : "+noOfDx, test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCoding_VerifyRecordCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void submitButtonClick() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.Submit);
			action.clickButton(icraPO.Submit, "Submit the Chase");
			try
			{
			  WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
			   //if(action.isElementDisplayed(icra_elements.AlertDialog,"AlertDialog"))
			  if(action.isElementDisplayed(w,"AlertDialog"))
			   {
				  String msg = action.elementGetText(icraPO.AlertDialog, "Alert Dialog");
				  if(!(msg.contains("successfully")))
				  {
			      Extent_Reporting.Log_Fail(TC_ID, w.getText(), test, driver);
				  }
				  else
				  {
					  action.WaitUntilDisplayed(icraPO.Ok);
						Extent_Reporting.Log_Pass("Submit", "Submit is clicked", test, driver);
						action.clickButton(icraPO.Ok, "Ok to submit chase");
						Extent_Reporting.Log_Pass("Ok", "Ok to submit chase", test, driver);
						closeButtonClick();
				  }
			   }
			}
			catch(Exception e)
			{
				action.WaitUntilDisplayed(icraPO.Ok);
				Extent_Reporting.Log_Pass("Submit", "Submit is clicked", test, driver);
				action.clickButton(icraPO.Ok, "Ok to submit chase");
				Extent_Reporting.Log_Pass("Ok", "Ok to submit chase", test, driver);
				closeButtonClick();
				}

			}catch (Exception e1) {
			Extent_Reporting.Log_FailMessage("submitButtonClick() failed "+e1.getMessage(), test, driver);
			throw new Exception(e1.getMessage());
		}
       
	}
	
	public void closeButtonClick() throws Throwable
	{
		try
		{
		   if(action.isElementDisplayed(icraPO.Close, "close"))
				{
			        action.clickButton(icraPO.Close, "Close the coding page");
			        action.WaitUntilDisplayed(icraPO.Ok);
			        Extent_Reporting.Log_Pass("Close", "Close the coding page", test, driver);
			        action.clickButton(icraPO.Ok, "Ok to close chase");
			        action.WaitUntilDisplayed(icraPO.CodeReviewSelect);
			        Extent_Reporting.Log_Pass("Ok", "Ok to close chase", test, driver);
				}
			}catch(Exception e1) {
				Extent_Reporting.Log_FailMessage("closeButtonClick() failed "+e1.getMessage(), test, driver);
				throw new Exception(e1.getMessage());
			}
	}
	
	
	public void VerifyRecordCount() throws Throwable
	{
		
		try {
			List<WebElement> noOfRows = driver.findElements(By.xpath("//button[contains(@id,'Save')]"));
			
			String recordCount = action.elementGetText(icraPO.RecordCount, "Record Count");
			String [] fielddata = recordCount.split(":");
			int rc = Integer.parseInt(fielddata[1].trim());
			
			if((noOfRows.size() == rc))
			{
				Extent_Reporting.Log_Pass("VerifyCount", "Record count matches", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("VerifyCount", "Record count mismatch. From record list : "+noOfRows.size()+" . From label : "+rc, test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("VerifyRecordCount() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public String blindCoding_Add() throws Throwable
	{
		String chaseID = null;
		try {
			chaseID = blindCoding_InitialValue();
			
			int dxvalue = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "NoDx")); 
			
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement Dx = driver.findElement(By.xpath("(//input[contains(@class,'ICD')])["+i+"]"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
				WebElement Page = driver.findElement(By.xpath("(//input[contains(@id,'Page')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+i+"]"));
				
				
				action.Scroll(Comment);
				enterDx(Dx);
				enterPage(Page);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				enterComment(Comment);
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				if(i<dxvalue)
				{
				WebElement AddBtn = driver.findElement(By.xpath("(//button[contains(@title,'Add')])["+i+"]"));
				action.clickButton(AddBtn, "Add Button at position "+i+" is selected");
				action.waitForPageLoad();
				}
				
			}
			action.ScrollToTop();
			action.clickButton(icraPO.Save, "Coding Save");
			action.WaitUntilDisplayed(icraPO.AlertDialog);
			Extent_Reporting.Log_Pass("Save", "Coding Save", test, driver);
			String msg = action.elementGetText(icraPO.AlertDialog, "Alert Dialog");
			if(msg.contains("successfully"))
			{
				action.WaitUntilDisplayed(icraPO.Toggle);
				action.clickButton(icraPO.Toggle, "Toggle button");
				action.WaitUntilDisplayed(icraPO.BlindCodingSavedTableData);
				Extent_Reporting.Log_Pass("BlindCodingSavedTableData", "BlindCoding Saved Table Data successfully displayed", test, driver);
			}
			else
			{ 
				Extent_Reporting.Log_Fail(TC_ID, msg, test, driver);
			    action.clickButton(icraPO.Clear, "Clear content");
			    action.WaitUntilDisplayed(icraPO.Ok);
			    Extent_Reporting.Log_Pass("Clear", "Clear content", test, driver);
			    action.clickButton(icraPO.Ok, "Ok to clear content");
			    action.WaitUntilDisplayed(icraPO.Close);
			    Extent_Reporting.Log_Pass("Ok", "Ok to clear content", test, driver);
			    action.clickButton(icraPO.Close, "Close the coding page");
			    action.WaitUntilDisplayed(icraPO.Ok);
			    Extent_Reporting.Log_Pass("Close", "Close the coding page", test, driver);
				action.clickButton(icraPO.Ok, "Ok to close chase");
				action.WaitUntilDisplayed(icraPO.CodeReviewSelect);
				Extent_Reporting.Log_Pass("Ok", "Ok to close chase", test, driver);
			   }
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCoding_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chaseID;
	}
	
	public String Optum2LR_InitialData() throws Throwable
	{
        String chaseID = null;
		try
		{
			chaseID = chaseDetails();
			boolean flag = medicalRecordCheck();
			pageCountCheck(flag);
			
			int dxvalue = Integer.parseInt(icraPO.TotalRow.getText());
			if(dxvalue == 0 && Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")) == 0)
			{
				allClickFunctionalities("Hold");
				chaseID="";
			}
			
			else if (dxvalue != 0)
			{
			List<WebElement> grids = driver.findElements(By.xpath("(//table[@class='data-grid'])"));
			for(int i=1;i<= grids.size();i++)
			{
				WebElement from = driver.findElement(By.xpath("(//input[@formcontrolname='DOSFrom'])["+i+"]"));
				action.clickButton(from, "From Date of grid - "+i);
				action.WaitUntilDisplayed(icraPO.Calender);
				dateChanges(from, "FromDate");
				//action.clickButton(from, "");
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				
				WebElement oprovider = driver.findElement(By.xpath("(//*[@formcontrolname='Provider']//input)["+i+"]"));
				enter_Provider(oprovider);
				
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				
				WebElement to = driver.findElement(By.xpath("(//input[@formcontrolname='DOSTo'])["+i+"]"));
				action.clickButton(to, "To Date of grid - "+i);
				action.WaitUntilDisplayed(icraPO.Calender);
				dateChanges(to, "ToDate");
				
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				if(flag == false)
				{
					WebElement POSID = driver.findElement(By.xpath("(//select[contains(@formcontrolname,'POSID')])["+i+"]"));
					WebElement SourceID = driver.findElement(By.xpath("(//select[contains(@formcontrolname,'SourceID')])["+i+"]"));
					enterPrimary(POSID);
					enterPrimary(SourceID);
				}
			}
		}
	} catch (Exception e) {
		Extent_Reporting.Log_FailMessage("Optum2LR_InitialData() failed", test, driver);
		throw new Exception(e.getMessage());
	}
	return chaseID;
	}
	
	
	public String Optum2LR_QC() throws Throwable
	{
		String chaseID = "";
		try {
			
			chaseID = Optum2LR_InitialData();
			if(!(chaseID.isBlank()))
			{
				List<WebElement> dxRows = driver.findElements(By.xpath("(//i[@title='Row Save']/..)"));
				/*for(int i=2;i<dxRows.size();i+=2)
				{
					WebElement Dx = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'ICD')]//input)["+i+"]"));
							
					enter_Dx(Dx);
				}*/
				for(int i=1;i<= dxRows.size();i++)
				{
					WebElement Page = driver.findElement(By.xpath("(//input[contains(@formcontrolname,'PageNo')])["+i+"]"));
					WebElement Primary = driver.findElement(By.xpath("(//select[contains(@formcontrolname,'ActionID')])["+i+"]"));
					WebElement SecondaryDD = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'ErrorCommentID')]//div[contains(@class,'trigger')])["+i+"]"));
					
					enterPage(Page);
					enterPrimary(Primary);
					enter_Secondary(SecondaryDD);
					Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
					WebElement UpdateBtn = driver.findElement(By.xpath("(//i[@title='Row Save']/..)["+i+"]"));
					action.clickButton(UpdateBtn, "Update Button at position "+i+" is selected");
					action.waitForPageLoad();
					WebElement GreenTick = driver.findElement(By.xpath("(//i[@title='Row Save']//preceding::i[contains(@class,'pi-check')])["+i+"]"));
					if(GreenTick.isDisplayed())
					{
						Extent_Reporting.Log_Pass("Save", "Row "+i+" is saved", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail("Save", "Row "+i+" is not saved, check error", test, driver);
					}
				
				}
			action.ScrollToTop();
			driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			add_Row();
			//datesCompare();
			action.ScrollToTop();
			submitButtonClick();
			}
		}
			catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Optum2LRQC_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chaseID;
	}
	
	
	public String Optum2LR_QA() throws Throwable
	{
		String chaseID = "";
		try {
			
			chaseID = Optum2LR_InitialData();
			if(!(chaseID.isBlank()))
			{
				List<WebElement> dxRows = driver.findElements(By.xpath("(//i[@title='Row Save']/..)"));
				/*for(int i=2;i<dxRows.size();i+=2)
				{
					WebElement Dx = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'ICD')]//input)["+i+"]"));
							
					enter_Dx(Dx);
				}*/
				for(int i=1;i<= dxRows.size();i++)
				{
					WebElement Page = driver.findElement(By.xpath("(//input[contains(@formcontrolname,'PageNo')])["+i+"]"));
					WebElement Primary = driver.findElement(By.xpath("(//select[contains(@formcontrolname,'ActionID')])["+i+"]"));
					WebElement SecondaryDD = driver.findElement(By.xpath("(//*[contains(@formcontrolname,'ErrorCommentID')]//div[contains(@class,'trigger')])["+(i*2)+"]"));
					
					enterPage(Page);
					enterPrimary(Primary);
					enter_Secondary(SecondaryDD);
					Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
					WebElement UpdateBtn = driver.findElement(By.xpath("(//i[@title='Row Save']/..)["+i+"]"));
					action.clickButton(UpdateBtn, "Update Button at position "+i+" is selected");
					action.waitForPageLoad();
					WebElement GreenTick = driver.findElement(By.xpath("(//i[@title='Row Save']//preceding::i[contains(@class,'pi-check')])["+i+"]"));
					if(GreenTick.isDisplayed())
					{
						Extent_Reporting.Log_Pass("Save", "Row "+i+" is saved", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail("Save", "Row "+i+" is not saved, check error", test, driver);
					}
				
				}
			action.ScrollToTop();
			driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			add_Row();
			//datesCompare();
			action.ScrollToTop();
			submitButtonClick();
			}
		}
			catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Optum2LRQC_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chaseID;
	}
	
	public void datesCompare() throws Throwable
	{
		String[] todatearray = null;String[] listdatearray = null;
		try
		{
			List<WebElement> todates = driver.findElements(By.xpath("(//input[@formcontrolname='DOSTo'])"));
			int todatecount = todates.size();
			
			for(int i=1;i<=todatecount;i++)
			{
				WebElement to = driver.findElement(By.xpath("(//input[@formcontrolname='DOSTo'])["+i+"]"));
				//String date = action.elementGetAttribute(to, "ng-reflect-text", "Date of "+i);
				String input = action.elementGetAttribute(to, "ng-reflect-text", "Date of "+i);
				String dt = input.split(" ")[1]+"/"+input.split(" ")[2]+"/"+input.split(" ")[3];
				System.out.println(dt);
						
				//Date d1 = JavaUtilities.string2Date(dt, "Mon/dd/yyyy");
				//System.out.println(d1);
				DateFormat srcDf = new SimpleDateFormat("Mon/dd/yyyy");
	             
	            // parse the date string into Date object
	            Date date = srcDf.parse(dt);
	             
	            DateFormat destDf = new SimpleDateFormat("dd/MM/yyyy");
	              
	            // format the date into another format
	            String output = destDf.format(date);

				//DateTimeFormatter f = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" ).withLocale( Locale.US );
				 
				//ZonedDateTime zdt = ZonedDateTime.parse( input , f );
				 
				//LocalDate ld = zdt.toLocalDate();
				//DateTimeFormatter fLocalDate = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );
				//String output = ld.format( fLocalDate) ;
				System.out.println(output);
				todatearray[i-1]=output;
		   }
			action.clickButton(icraPO.TotalGrouping, "DropDown");
			action.WaitUntilDisplayed(icraPO.MultipleSelect);
			List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'multiselect-item')]"));
			for(int i=1;i<=list.size();i++)
			{
				WebElement da = driver.findElement(By.xpath("(//li[contains(@class,'multiselect-item')])["+i+"]"));
				String listdate = action.elementGetAttribute(da, "aria-label", "List date of "+i);
				listdatearray[i-1]=listdate;
			}
			for(int i=0;i<todatearray.length;i++)
			{
				if(todatearray[i].equals(listdatearray[i]))
				{
					Extent_Reporting.Log_Message("All Dates listed in dropdown", test, driver);
				}
				else
				{
					Extent_Reporting.Log_FailMessage("All Dates listed in dropdown", test, driver);
				}
			}
	}catch (Exception e) {
		Extent_Reporting.Log_FailMessage("datesCompare() failed", test, driver);
		throw new Exception(e.getMessage());
	}
	}
	
	public String CDVCoding_Add() throws Throwable
	{
		String chase=null;
		try {
			chase = chaseDetails();
			
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			if(dxvalue == 0 && Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")) == 0)
			{
				allClickFunctionalities("Reject");
			}
			else
			{
			for(int i=1;i<=dxvalue;i++)
			{
			    WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
			    WebElement Page = driver.findElement(By.xpath("(//input[not(contains(@id,'PageCount')) and contains(@id,'Page')])["+i+"]"));
			    WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
			    WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+i+"]"));
				
				action.Scroll(Comment);
				
				enterPage(Page);
							
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				enterComment(Comment);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
				
			}
			action.ScrollToTop();
			addRow();
			submitButtonClick();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("CDVCoding_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chase;
	}
	
	
	public String autoCDVCoding_Add() throws Throwable
	{
		String chase = null;
		try {
			chase = chaseDetails();
			
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			if(dxvalue == 0 && Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")) == 0)
			{
				allClickFunctionalities("Reject");
			}
			else
			{
			for(int i=1;i<=dxvalue;i++)
			{
				String letters = randomAlphabet();
				WebElement Dx = driver.findElement(By.xpath("(//*[not(contains(@id,'CDV')) and contains(@id,'ICD')])["+i+"]//input"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
				WebElement Page = driver.findElement(By.xpath("(//input[contains(@id,'Page')])["+i+"]"));
				WebElement Provider = driver.findElement(By.xpath("(//strong[text()='Provider'])["+i+"]//following::input"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+i+"]"));
				
				action.Scroll(Dx);
						
				
				enterPage(Page);
				enterDx(Dx);
				enterProvider(Provider);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				action.inputText(Comment, "AutomationTesting_"+letters, "AutomationTesting_"+letters);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
				
			}
			action.ScrollToTop();
			addRow();
			submitButtonClick();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("autoCDVCoding_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chase;
	}
	
	public String autoBlindCoding_Add() throws Throwable
	{
		String chase = null;
		try {
			chase = chaseDetails();
			
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			if(dxvalue == 0 && Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")) == 0)
			{
				allClickFunctionalities("Reject");
			}
			else
			{
			for(int i=1;i<=dxvalue;i++)
			{
			    WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
			    WebElement Provider = driver.findElement(By.xpath("(//strong[text()='Provider'])["+i+"]//following::input"));
			    WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
			    WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[@bindvalue='SecondaryCommentID'])["+i+"]"));
				
			    
			    action.Scroll(Comment);
				enterProvider(Provider);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				enterComment(Comment);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				
				
			}
			action.ScrollToTop();
			addRow();
			submitButtonClick();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("autoBlindCoding_Add() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chase;
	}
	
	public String blindCoding_InitialValue() throws Throwable
	{
		String chase = null;
		try {
			chase = chaseDetails();
			action.clickButton(icraPO.FromDate, "From Date");
			action.WaitUntilDisplayed(icraPO.Calender);
			datepicker(icraPO.Calender);       
			if((icraPO.FromDate.getText().trim()).equalsIgnoreCase(icraPO.ToDate.getText().trim()))
			{
				Extent_Reporting.Log_Pass("Date", "Both the dates are same", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("Dates", "Todate need to be added", test, driver);
			}
			action.inputText(icraPO.Provider, ExcelHandling.GetExcelData(TC_ID, "Provider"), ExcelHandling.GetExcelData(TC_ID, "Provider"));
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			selectAutoComplete();
			Extent_Reporting.Log_Pass("InitialValue", "Dates and Provider details entered successfully", test, driver);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCoding_InitialValue() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return chase;
	}
	
	public void validatingSubmittedChase(String chaseID,String tcID) throws Throwable
	{
		int flag = 0,no = 0;
		action.waitForPageLoad();
		
		try {
			if(action.isElementDisplayed(icraPO.EditCodedTab, "EditCodedTab"))
			{
			action.waitForElementClickable(icraPO.EditCodedTab, "EditCodedTab");
			action.clickButton(icraPO.EditCodedTab, "Edit coded data tab");
			driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			action.WaitUntilDisplayed(icraPO.Data);
			Extent_Reporting.Log_Pass("EditCodedTab", "EditCodedTab is selected", test, driver);
			List<WebElement> chases = driver.findElements(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)"));
			if(chases.size() != 0)
			{
			for(int i=1;i<= chases.size();i++)
			{
				WebElement chaseIdEle = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)["+i+"]"));
				String id = action.elementGetText(chaseIdEle, "ChaseID");
				if(id.equalsIgnoreCase(chaseID))
				{
					flag = 1;no = i;
				    break;
				}
				
			}
			
			if(flag == 1)
			{
				WebElement chaseIdEle = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)["+no+"]"));
				
				Extent_Reporting.Log_Pass("Chase", "Desired chase found - "+chaseID, test, driver);
			    WebElement EditCodedData_TimeSpent = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'TimeSpent')])["+no+"]"));
			    WebElement EditCodedData_TimeRemaining = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'TimeRemaining')])["+no+"]"));
			    action.elementGetText(EditCodedData_TimeSpent, "EditCodedData_TimeSpent");
			    action.elementGetText(EditCodedData_TimeRemaining, "EditCodedData_TimeRemaining");
			    if((tcID.contains("Add")) || (tcID.contains("Edit")) || (tcID.contains("Delete")))
				{
			    		updateSubmittedChase(chaseIdEle);
				}
			    else if(tcID.contains("UnHold"))
    			{
    			   clickChase(chaseIdEle);
    			}
			    Thread.sleep(7000);
			    checkCommentHistory(chaseIdEle);
			    	
			}
			else
			{
				Extent_Reporting.Log_Fail("Chase", "Desired chase not found - "+chaseID, test, driver);
			    
			}
			}
			else
			{
				Extent_Reporting.Log_Pass("Chases", "No chases displayed, sampling time set to 0", test, driver);
			}
			}
		}
			catch (Exception e) 
			{
				Extent_Reporting.Log_Pass("EditCodedTab", "EditCodedTab is not displayed", test, driver);
				throw new Exception(e.getMessage());
			}
		
		
	}
	
	public void validatingButtonClickedChase(String chaseID,String buttonType, String tcID) throws Throwable
	{
		
		action.waitForPageLoad();
		
		try
		{
			if((buttonType.equalsIgnoreCase("Reject")) || (buttonType.equalsIgnoreCase("No HCC")))
			{
				validatingSubmittedChase(chaseID, tcID);
			}
			else if(buttonType.equalsIgnoreCase("Hold"))
			{
				validatingChase(chaseID, buttonType);
			}
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("validatingButtonClickedChase() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void validatingExceptionChase(String chaseID) throws Throwable
	{
		try 
		{
			ICRA_Menu_Selection("Exceptions");
			action.WaitUntilDisplayed(icraPO.ExceptionTable);
			action.WaitUntilDisplayed(icraPO.ChaseID_DD);
			action.clickButton(icraPO.ChaseID_DD, "ChaseID_DD");
			action.WaitUntilDisplayed(icraPO.ChaseID_Input);
			action.inputText(icraPO.ChaseID_Input, chaseID, "ChaseID Filter");
			WebElement select = driver.findElement(By.xpath("//li[contains(@class,'ui-multiselect')]//span[contains(text(),'"+chaseID+"')]//preceding-sibling::div/div"));
			action.clickButton(select, "Chase : "+chaseID);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Extent_Reporting.Log_Pass("Chase Details", chaseID+" is selected", test, driver);
			List<WebElement> chasesDetails = driver.findElements(By.xpath("(//tbody[contains(@class,'ui-table-tbody')]//td)"));
			for(int i=2;i< chasesDetails.size();i++)
			{
				WebElement header = driver.findElement(By.xpath("(//th//span[contains(@class,'title')])["+i+"]"));
				
				WebElement ele = driver.findElement(By.xpath("(//tbody[contains(@class,'ui-table-tbody')]//td)["+i+"]"));
				Extent_Reporting.Log_Message("Data for "+chaseID+" under "+header.getText()+" is : "+ele.getText().trim(), test, driver);
			}
			//driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("validatingExceptionChase() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void validatingChase(String chaseID,String buttonType) throws Throwable
	{
		int flag = 0,no = 0;
		action.waitForPageLoad();
		try {
			try
			{
				
			if(driver.findElement(By.xpath("//div[contains(text(),'"+buttonType+"')]")).isDisplayed())
			{
			action.waitForElementClickable(driver.findElement(By.xpath("//div[contains(text(),'"+buttonType+"')]")), buttonType+" Tab");
			action.clickButton(driver.findElement(By.xpath("//div[contains(text(),'"+buttonType+"')]")), buttonType+" tab");
			action.WaitUntilDisplayed(icraPO.Data);
			Extent_Reporting.Log_Pass("Tab", buttonType+" Tab is selected", test, driver);
			List<WebElement> chases = driver.findElements(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)"));
			for(int i=1;i<= chases.size();i++)
			{
				WebElement chaseIdEle = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)["+i+"]"));
				String id = action.elementGetText(chaseIdEle, "ChaseID");
				if(id.equalsIgnoreCase(chaseID))
				{
					flag = 1;no = i;
				    break;
				}
				
			}
			if(flag == 1 && buttonType.equalsIgnoreCase("Hold"))
			{
				WebElement chaseIdEle = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'ChaseID')]//div)["+no+"]"));
				
				Extent_Reporting.Log_Pass("Chase", "Desired chase found - "+chaseID, test, driver);
			    WebElement data = driver.findElement(By.xpath("(//div[contains(@class,'ag-cell') and contains(@col-id,'"+buttonType+"')])["+no+"]"));
			    action.elementGetText(data, "Data");
			    clickChase(chaseIdEle);
			    checkCommentHistory(chaseIdEle);
			    	
			}
			else
			{
				Extent_Reporting.Log_Fail("Chase", "Desired chase not found - "+chaseID, test, driver);
			    
			}
			}
			}
			catch(Exception e)
			{
				Extent_Reporting.Log_Pass(buttonType+" Tab", buttonType+" Tab is not displayed", test, driver);
			    
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("validatingChase() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	public void updateSubmittedChase(WebElement ele) throws Throwable
	{
		
			try {
				if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("BlindCoding"))
				{
					blindCodingUpdate(ele);
				}
				else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("CDVCoding"))
				{
					CDVCodingUpdate(ele);
				}
				else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoBlindCoding"))
				{
					AutoBlindCodingUpdate(ele);
				}
				else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("AutoCDVCoding"))
				{
					AutoCDVCodingUpdate(ele);
				}
				else if((ExcelHandling.GetExcelData(TC_ID, "TestCaseName")).startsWith("Optum2LR"))
				{
					Optum2LRCoding_Update(ele);
					//Optum2LRCoding_VerifyRecordCount();
				}
			} catch (Exception e) {
				Extent_Reporting.Log_FailMessage("updateSubmittedChase() failed", test, driver);
				throw new Exception(e.getMessage());
			}
		
	}
	
	public void checkCommentHistory(WebElement ele) throws Throwable
	{
		try {
			//action.WaitUntilDisplayed(ele);
			//action.clickButton(ele, ele.getText());
			//action.WaitUntilDisplayed(icraPO.CodingPage);
			commentHistory();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("checkCommentHistory() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void clickChase(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.CodingPage);
			//commentHistory();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("checkCommentHistory() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void blindCodingUpdate(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.CodingPage);
			action.WaitUntilDisplayed(icraPO.Toggle);
			action.clickButton(icraPO.Toggle, "Toggle button");
			action.WaitUntilDisplayed(icraPO.BlindCodingSavedTableData);
			Extent_Reporting.Log_Pass("BlindCodingSavedTableData", "BlindCoding Saved Table Data successfully displayed", test, driver);
			
			String recordCount = action.elementGetText(icraPO.BlindCodingSavedRecordCount, "BlindCoding Saved Record Count");
			int rc = Integer.parseInt(recordCount);
			int noOfDx = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "NoDx"));
			if(rc == noOfDx)
			{
				Extent_Reporting.Log_Pass("VerifyCount", "Record count matches", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail("VerifyCount", "Record count does not match", test, driver);
			}
			//commentHistory();
			if(TC_ID.contains("Edit"))
			{
				BCeditFunctionality(rc);
			}
			else if(TC_ID.contains("Delete"))
			{
				BCdeleteFunctionality(rc);
			}
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCodingUpdate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	
	public void Optum2LRCoding_Update(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.ChaseID);
			
			if(TC_ID.contains("Edit"))
			{
				Optum2LREdit();
			}
			
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("blindCodingUpdate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	public void Optum2LREdit() throws Throwable
	{
		try 
		{
			boolean flag = medicalRecordCheck();
			List<WebElement> grids = driver.findElements(By.xpath("(//table[@class='data-grid'])"));
			for(int i=1;i<= grids.size();i++)
			{
				WebElement update = driver.findElement(By.xpath("(//input[@formcontrolname='BulkUpdate'])["+i+"]"));
				action.clickButton(update, "From Date if grid - "+i);
				action.clickButton(icraPO.UpdateSelectedBtn, "UpdateSelectedBtn");
				action.WaitUntilDisplayed(icraPO.BulkUpdatePage);
				
				enterPrimary(icraPO.BulkPrimary);
				enter_Secondary(icraPO.BulkSecondary);
				Extent_Reporting.Log_Pass("Details", "All details updated successfully", test, driver);
				action.clickButton(icraPO.BulkUpdateBtn, "BulkUpdate button");
			
			}
			
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Optum2LREdit() failed "+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	
	
	public void CDVCodingUpdate(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.CodingPage);
			//commentHistory();
			if(TC_ID.contains("Edit"))
			{
				CDVeditFunctionality();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("CDVCodingUpdate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	   
		
	}
	
	public void AutoBlindCodingUpdate(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.CodingPage);
			//commentHistory();
			if(TC_ID.contains("Edit"))
			{
				autoBlindeditFunctionality();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("AutoBlindCodingUpdate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	   
		
	}
	
	public void AutoCDVCodingUpdate(WebElement ele) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(ele);
			action.clickButton(ele, ele.getText());
			action.WaitUntilDisplayed(icraPO.CodingPage);
			//commentHistory();
			if(TC_ID.contains("Edit"))
			{
				autoCDVeditFunctionality();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("AutoCDVCodingUpdate() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	   
		
	}
	
	public void CDVeditFunctionality() throws Throwable
	{
		try {
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement Page = driver.findElement(By.xpath("(//input[not(contains(@id,'PageCount')) and contains(@id,'Page')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
				
				action.Scroll(Comment);
				Extent_Reporting.Log_Pass("Data", "Data for : "+i+" element is as below : ", test, driver);
				action.elementGetAttribute(Page, "title", "");
				action.elementGetAttribute(Primary, "title", "");
				action.elementGetAttribute(Comment, "title", "");
				action.waitForPageLoad();
 
			    String letters = randomAlphabet();
				action.clearInputText(Comment, "AutomationTesting_"+letters, "AutomationTesting_"+letters);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				action.waitForPageLoad();
				
				Extent_Reporting.Log_Pass("Details", "Comment updated successfully", test, driver);
			}
			action.ScrollToTop();
			updateSubmit();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("CDVeditFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}
			
			
	}
	
	public void updateSubmit() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icraPO.Submit);
			action.clickButton(icraPO.Submit, "Submit the Chase");
			action.WaitUntilDisplayed(icraPO.Ok);
			Extent_Reporting.Log_Pass("Submit", "Submit is clicked", test, driver);
			action.clickButton(icraPO.Ok, "Ok to submit chase");
			action.WaitUntilDisplayed(icraPO.AlertDialog);
			Extent_Reporting.Log_Pass("Ok", "Ok to submit chase", test, driver);
			String msg = action.elementGetText(icraPO.AlertDialog, "Alert Dialog");
			if(msg.contains("successfully"))
			{
				Extent_Reporting.Log_Pass("SubmitChase", msg, test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, msg, test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("updateSubmit() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	public void autoBlindeditFunctionality() throws Throwable
	{
		try {
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement Page = driver.findElement(By.xpath("(//input[not(contains(@id,'PageCount')) and contains(@id,'Page')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
				
				action.Scroll(Comment);
				
				Extent_Reporting.Log_Pass("Data", "Data for : "+i+" element is as below : ", test, driver);
				action.elementGetAttribute(Page, "title", "");
				action.elementGetAttribute(Primary, "title", "");
				action.elementGetAttribute(Comment, "title", "");
				action.waitForPageLoad();
 
			    String letters = randomAlphabet();
				action.clearInputText(Comment, "AutomationTesting_"+letters, "AutomationTesting_"+letters);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				action.waitForPageLoad();
				
				Extent_Reporting.Log_Pass("Details", "Comment updated successfully", test, driver);
			}
			action.ScrollToTop();
			updateSubmit();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("autoBlindeditFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}
			
	}
	
	
	public void autoCDVeditFunctionality() throws Throwable
	{
		try {
			int dxvalue = driver.findElements(By.xpath("//button[contains(@id,'Save')]")).size();
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement Page = driver.findElement(By.xpath("(//input[not(contains(@id,'PageCount')) and contains(@id,'Page')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'Primary')])["+i+"]"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'Comments')])["+i+"]"));
				WebElement Dx = driver.findElement(By.xpath("(//*[not(contains(@id,'CDV')) and contains(@id,'ICD')])["+i+"]//input"));
				
				action.Scroll(Comment);
				
				Extent_Reporting.Log_Pass("Data", "Data for : "+i+" element is as below : ", test, driver);
				action.elementGetAttribute(Page, "title", "");
				action.elementGetAttribute(Primary, "title", "");
				action.elementGetAttribute(Comment, "title", "");
				action.waitForPageLoad();
				
				updateCDV_Dx(Dx);
 
			    String letters = randomAlphabet();
				action.clearInputText(Comment, "AutomationTesting_"+letters, "AutomationTesting_"+letters);
				WebElement SaveBtn = driver.findElement(By.xpath("(//button[contains(@id,'Save')])["+i+"]"));
				action.clickButton(SaveBtn, "Save button");
				action.waitForPageLoad();
				
				Extent_Reporting.Log_Pass("Details", "Comment updated successfully", test, driver);
			}
			action.ScrollToTop();
			updateSubmit();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("autoCDVeditFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}	
			
	}
	
		
	public void BCeditFunctionality(int rc) throws Throwable
	{
		try {
			for(int i=1;i<=rc;i++)
			{
				WebElement rowbutton = driver.findElement(By.xpath("(//tbody[@id='tbodytblCYData']//tr)["+i+"]//button"));
				action.clickButton(rowbutton, "Edit the button at position "+i);
				action.WaitUntilDisplayed(icraPO.View_Update);
				updateDx(i);
						
				String letters = randomAlphabet();
				action.clearInputText(icraPO.Update_Comment, "UpdateComments_"+letters, "UpdateComments_"+letters);
				action.WaitUntilDisplayed(icraPO.Update);
				action.clickButton(icraPO.Update, "Update button");
			}
			action.ScrollToTop();
			updateSubmit();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("BCeditFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void BCdeleteFunctionality(int rc) throws Throwable
	{
		try {
			for(int i=rc;i>=rc;i--)
			{
				WebElement rowbutton = driver.findElement(By.xpath("(//tbody[@id='tbodytblCYData']//tr)["+i+"]//button"));
				action.clickButton(rowbutton, "Edit the button at position "+i);
				action.WaitUntilDisplayed(icraPO.View_Update);
				
				action.WaitUntilDisplayed(icraPO.Delete);
				action.clickButton(icraPO.Delete, "Delete button");
				action.WaitUntilDisplayed(icraPO.Ok);
			    Extent_Reporting.Log_Pass("Ok", "Ok to delete", test, driver);
				action.clickButton(icraPO.Ok, "Ok to delete");
				action.WaitUntilDisplayed(icraPO.CodingPage);
				
				

			}
			action.clickButton(icraPO.Close, "Close Button");
			action.WaitUntilDisplayed(icraPO.Ok);
			action.clickButton(icraPO.Ok, "Ok to delete");
			action.WaitUntilDisplayed(icraPO.CodeReviewSelect);
			//action.ScrollToTop();
			//submitButtonClick();
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("BCdeleteFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterDx(WebElement Dx) throws Throwable
	{
		String dx = ExcelHandling.GetExcelData(TC_ID, "DXList");
		String [] dxlist = dx.split(",");
		try {
			if((action.elementGetAttribute(Dx, "style", "Style details")).contains("yellow"))
			{
				Extent_Reporting.Log_Pass("DxValue", "Dx is present", test, driver);
			}
			else
			{
			Random generator = new Random();
			int randomIndex = generator.nextInt(dxlist.length);
						
			action.inputText(Dx, dxlist[randomIndex], dxlist[randomIndex]);
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			selectAutoComplete();
			Extent_Reporting.Log_Pass("DxValue", "Dx entered successfully", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterDx() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enter_Dx(WebElement Dx) throws Throwable
	{
		String dx = ExcelHandling.GetExcelData(TC_ID, "DXList");
		String [] dxlist = dx.split(",");
		try {
			if((action.elementGetAttribute(Dx, "style", "Style details")).contains("yellow"))
			{
				Extent_Reporting.Log_Pass("DxValue", "Dx is present", test, driver);
			}
			else
			{
			Random generator = new Random();
			int randomIndex = generator.nextInt(dxlist.length);
						
			action.clearInputText(Dx, dxlist[randomIndex], dxlist[randomIndex]);
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			selectAutoComplete();
			Extent_Reporting.Log_Pass("DxValue", "Dx entered successfully", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enter_Dx() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void updateCDV_Dx(WebElement Dx) throws Throwable
	{
		String dx = ExcelHandling.GetExcelData(TC_ID, "DXList");
		String [] dxlist = dx.split(",");
		try {
			if((action.elementGetAttribute(Dx, "style", "Style details")).contains("yellow"))
			{
				Extent_Reporting.Log_Pass("DxValue", "Dx is present", test, driver);
			}
			else
			{
			Random generator = new Random();
			int randomIndex = generator.nextInt(dxlist.length);
						
			action.clearInputText(Dx, dxlist[randomIndex], dxlist[randomIndex]);
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			selectAutoComplete();
			Extent_Reporting.Log_Pass("DxValue", "Dx entered successfully", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("updateCDV_Dx() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void updateDx(int i) throws Throwable
	{
		String dx = ExcelHandling.GetExcelData(TC_ID, "DXList");
		String [] dxlist = dx.split(",");
		try {
			Random generator = new Random();
			int randomIndex = generator.nextInt(dxlist.length);
			
			action.clearInputText(icraPO.Update_DX, dxlist[randomIndex], dxlist[randomIndex]);
			if(action.elementDisplayed(driver.findElement(By.xpath("//*[contains(@class,'ui-autocomplete-loader')]"))))
			{
				action.inputText(icraPO.Update_DX, dxlist[randomIndex], dxlist[randomIndex]);
			}
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			selectAutoComplete();
			
			Extent_Reporting.Log_Pass("DxValue", "Dx entered successfully", test, driver);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("updateDx() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterProvider(WebElement Provider) throws Throwable
	{
		//WebElement Provider = driver.findElement(By.xpath("(//strong[text()='Provider'])["+i+"]//following::input"));
		try {
			if(Provider.isEnabled())
			{
			action.clearInputText(Provider, ExcelHandling.GetExcelData(TC_ID, "Provider"), ExcelHandling.GetExcelData(TC_ID, "Provider"));
			try {
			if(icraPO.AutoCompleteList.isDisplayed())
				selectAutoComplete();	
			}
			catch(Exception e)
			{
				 action.inputText(Provider, ExcelHandling.GetExcelData(TC_ID, "Provider"), ExcelHandling.GetExcelData(TC_ID, "Provider"));
			     action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			     selectAutoComplete();	
			}
			Extent_Reporting.Log_Pass("Provider", "Provider added", test, driver);
			
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterProvider() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enter_Provider(WebElement Provider) throws Throwable
	{
		
		try {
			Provider.click();
			action.clearInputText(Provider, ExcelHandling.GetExcelData(TC_ID, "Provider"), ExcelHandling.GetExcelData(TC_ID, "Provider"));
			action.WaitUntilDisplayed(icraPO.AutoCompleteList);
			selectAutoComplete();
			Extent_Reporting.Log_Pass("Provider", "Provider added", test, driver);

		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enter_Provider() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterPage(WebElement Page) throws Throwable
	{
		String PageContent = action.elementGetAttribute(Page, "title", "Page content");
		try {
			if(PageContent.isEmpty())
			{
			Random num = new Random();
			String iSelect = Integer.toString(num.nextInt(10 - 1) + 1);
			action.inputText(Page, iSelect, iSelect);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterPage() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enter_Page(WebElement Page) throws Throwable
	{
		try {
			String iSelect = Integer.toString((int) ((Math.random()*(10 - 1)) + 1));
			action.inputText(Page, iSelect, iSelect);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enter_Page() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterPrimary(WebElement Primary) throws Throwable
	{
		
		try {
			Select objSel = new Select(Primary);
			List <WebElement> weblist = objSel.getOptions();
			int iCnt = (weblist.size()-1);
			Random index = new Random();
			int iSelect1 = index.nextInt(iCnt - 1) + 1;
			
			objSel.selectByIndex(iSelect1);
			Extent_Reporting.Log_Pass("Option", "Option selected", test, driver);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterPrimary() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterSecondary(WebElement SecondaryDD) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(SecondaryDD);
			action.clickButton(SecondaryDD, "Secondary options");
			
			action.waitForPageLoad();
			List<WebElement> ddOptions = driver.findElements(By.xpath("(//div[@role='option']/input[not(@disabled)])"));
			int iCnt = ddOptions.size();
			if(iCnt != 0 )
			{
			Random num = new Random();
			int val = num.nextInt(iCnt - 1) + 1;
			
			WebElement SecData = driver.findElement(By.xpath("(//div[@role='option']/input[not(@disabled)])["+val+"]"));
			WebElement SecName = driver.findElement(By.xpath("(//div[@role='option']/input[not(@disabled)])["+val+"]/.."));
			action.clickButton(SecData, SecName.getText().trim());
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("SecondaryComment", "Secondary Comment added", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterSecondary() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enter_Secondary(WebElement SecondaryDD) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(SecondaryDD);
			action.clickButton(SecondaryDD, "Secondary options");
			
			action.waitForPageLoad();
			List<WebElement> ddOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li"));
			int iCnt = ddOptions.size();
			if(iCnt == 0) { Extent_Reporting.Log_Message("no options", test, driver);}
			else if(iCnt == 1)
			{
				WebElement SecData = driver.findElement(By.xpath("(//ul[contains(@class,'multiselect')]//li)["+iCnt+"]//div[contains(@class,'default')]"));
				String SecName = driver.findElement(By.xpath("(//ul[contains(@class,'multiselect')]//li)["+iCnt+"]")).getAttribute("aria-label").trim();
				action.clickButton(SecData, SecName);
				action.waitForPageLoad();
				Extent_Reporting.Log_Pass("SecondaryComment", "Secondary Comment added", test, driver);
			}
			else if((iCnt != 0) || (iCnt !=1))
			{
			Random num = new Random();
			int val = num.nextInt(iCnt - 1) + 1;
			WebElement SecData = driver.findElement(By.xpath("(//ul[contains(@class,'multiselect')]//li)["+val+"]//div[contains(@class,'default')]"));
			String SecName = driver.findElement(By.xpath("(//ul[contains(@class,'multiselect')]//li)["+val+"]")).getAttribute("aria-label").trim();
			action.clickButton(SecData, SecName);
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("SecondaryComment", "Secondary Comment added", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterSecondary() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void enterComment(WebElement Comment) throws Throwable
	{
		try {
			String letters = randomAlphabet();
			action.inputText(Comment, "AutomationTesting_"+letters, "AutomationTesting_"+letters);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterComment() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public int enterAction(WebElement ActionDD) throws Throwable
	{
		int flag = 0;
		try {
			String att = action.elementGetAttribute(ActionDD, "title", "title attribute");
			if((att.equalsIgnoreCase("Update"))||(att.equalsIgnoreCase("Delete")))
			{
				flag =1;
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterAction() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return flag;
				
	}
	
	public void enterError(WebElement ErrorDD) throws Throwable
	{
		try {
			if(ErrorDD.isEnabled())
			{
			action.waitForElementClickable(ErrorDD, "Error DD");
			action.clickButton(ErrorDD, "Error options");
			action.WaitUntilDisplayed(icraPO.ClearAll);
			action.clickButton(icraPO.ClearAll, "Clear All");
			action.waitForPageLoad();
			
			List<WebElement> ddOptions = driver.findElements(By.xpath("(//div[@role='option']/input[not(@disabled)])"));
			int iCnt = ddOptions.size();
			Random num = new Random();
			int val = num.nextInt(iCnt - 1) + 1;
			
			WebElement Data = driver.findElement(By.xpath("(//div[@role='option']/input[not(@disabled)])["+val+"]"));
			WebElement Name = driver.findElement(By.xpath("(//div[@role='option']/input[not(@disabled)])["+val+"]/.."));
			action.clickButton(Data, Name.getText().trim());
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("ErrorComment", "Error Comment added", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("enterError() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}

	public void selectAutoComplete() throws Throwable
	{
		try {
			List<WebElement> ddOptions = driver.findElements(By.xpath("(//ul[contains(@class,'ui-autocomplete')]//li)"));
			int iCnt = ddOptions.size();
			
			Random num = new Random();
			int iSelect = num.nextInt(iCnt - 1) + 1;
			WebElement selects = driver.findElement(By.xpath("(//ul[contains(@class,'ui-autocomplete')]//li/div)["+iSelect+"]"));
			WebElement selectsname = driver.findElement(By.xpath("(//ul[contains(@class,'ui-autocomplete')]//li/div/div)["+iSelect+"]"));
			try
			{
				
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				
				//selects.click();
				action.JSclickButton(selects, selectsname.getText());
				//Thread.sleep(10000);
				//Extent_Reporting.Log_Pass(selectsname.getText(), selectsname.getText()+" added", test, driver);
			}
			catch(StaleElementReferenceException e)
			{
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				selects.click();
				Extent_Reporting.Log_Pass(selectsname.getText(), selectsname.getText()+" added", test, driver);
			}
			
			//action.WaitUntilDisplayed(selects);
			
			//action.WaitUntilDisplayed(selects);
			//Extent_Reporting.Log_Pass("Select", "To select : "+selectsname, test, driver);
			//action.clickButton(selects, selectsname.getText());
			
			
		} catch (Exception e) {
			//Extent_Reporting.Log_FailMessage("selectAutoComplete() failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void addRow() throws Throwable
	{
		try {
			if(!(ExcelHandling.GetExcelData(TC_ID, "ExtraRow").equals("")))
			{
			action.WaitUntilDisplayed(icraPO.AddRowBtn);
			action.clickButton(icraPO.AddRowBtn,"Add Row Button");
			action.WaitUntilDisplayed(icraPO.AddRowPage);
			Extent_Reporting.Log_Pass("AddRow Page", "AddRow page is displayed", test, driver);
			int dxvalue = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")); 
			
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement AddFromDate = driver.findElement(By.xpath("(//input[contains(@id,'addDOSFrom')])["+i+"]"));
				WebElement AddToDate = driver.findElement(By.xpath("(//input[contains(@id,'addDOSTo')])["+i+"]"));
				
				action.clickButton(AddFromDate, "From Date");
				action.WaitUntilDisplayed(icraPO.Calender);
				datepicker(icraPO.Calender);       
				if((AddFromDate.getText().trim()).equalsIgnoreCase(AddToDate.getText().trim()))
				{
					Extent_Reporting.Log_Pass("Dates", "Both the dates are same", test, driver);
				}
				else
				{
					Extent_Reporting.Log_Fail("Dates", "Todate need to be added", test, driver);
				}
				
						
				WebElement Dx = driver.findElement(By.xpath("(//*[contains(@id,'addICD')]//input)["+i+"]"));
				WebElement Provider = driver.findElement(By.xpath("(//*[contains(@id,'addProviderComplete')]//input)["+i+"]"));
				WebElement Comment = driver.findElement(By.xpath("(//input[contains(@id,'addComments')])["+i+"]"));
				WebElement Page = driver.findElement(By.xpath("(//input[contains(@id,'addPage')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'addPrimary')])["+i+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[contains(@id,'addSecondary')])["+i+"]"));
				
				enterDx(Dx);
				enterPage(Page);
				enterProvider(Provider);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				enterComment(Comment);
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				if(i<dxvalue)
				{
				WebElement AddBtn = driver.findElement(By.xpath("(//button[contains(@id,'AddNewRow')])["+i+"]"));
				action.clickButton(AddBtn, "Add Button at position "+i+" is selected");
				action.waitForPageLoad();
				}
				
			
			
			action.clickButton(icraPO.AddRowSaveBtn, "Save button");
			action.waitForPageLoad();
			}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("addRow() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void add_Row() throws Throwable
	{
		try {
			if(Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")) != 0)
			{
			action.WaitUntilDisplayed(icraPO.AddRowBtn);
			action.clickButton(icraPO.AddRowBtn,"Add Row Button");
			action.WaitUntilDisplayed(icraPO.AddRowPage);
			Extent_Reporting.Log_Pass("AddRow Page", "AddRow page is displayed", test, driver);
			int dxvalue = Integer.parseInt(ExcelHandling.GetExcelData(TC_ID, "ExtraRow")); 
			
			for(int i=1;i<=dxvalue;i++)
			{
				WebElement AddFromDate = driver.findElement(By.xpath("(//input[contains(@id,'addDOSFrom')])["+i+"]"));
				WebElement AddToDate = driver.findElement(By.xpath("(//input[contains(@id,'addDOSTo')])["+i+"]"));
				
				action.clickButton(AddFromDate, "From Date");
				action.WaitUntilDisplayed(icraPO.Calender);
				datepicker(icraPO.Calender);       
				if((AddFromDate.getText().trim()).equalsIgnoreCase(AddToDate.getText().trim()))
				{
					Extent_Reporting.Log_Pass("Dates", "Both the dates are same", test, driver);
				}
				else
				{
					Extent_Reporting.Log_Fail("Dates", "Todate need to be added", test, driver);
				}
				
						
				WebElement Dx = driver.findElement(By.xpath("(//*[contains(@id,'addICD')]//input)["+i+"]"));
				WebElement Provider = driver.findElement(By.xpath("(//*[contains(@id,'addProviderComplete')]//input)["+i+"]"));
				
				WebElement Page = driver.findElement(By.xpath("(//input[contains(@id,'addPage')])["+i+"]"));
				WebElement Primary = driver.findElement(By.xpath("(//select[contains(@id,'addPrimary')])["+i+"]"));
				WebElement SecondaryDD = driver.findElement(By.xpath("(//ng-select[contains(@id,'addSecondary')])["+i+"]"));
				
				enterDx(Dx);
				enterPage(Page);
				enterProvider(Provider);
				enterPrimary(Primary);
				enterSecondary(SecondaryDD);
				try
				{
					WebElement POSID = driver.findElement(By.xpath("(//select[contains(@id,'addPOSID')])["+i+"]"));
					if(action.isElementDisplayed(POSID, "POS ID"))
					{
						enterPrimary(POSID);
					}
					WebElement SourceID = driver.findElement(By.xpath("(//select[contains(@id,'addSource')])["+i+"]"));
					if(action.isElementDisplayed(SourceID, "Source ID"))
					{
						enterPrimary(SourceID);
					}
					
				}catch(Exception e) {}
				
				Extent_Reporting.Log_Pass("Details", "All Dx details entered successfully", test, driver);
				if(i<dxvalue)
				{
				WebElement AddBtn = driver.findElement(By.xpath("(//button[contains(@id,'AddNewRow')])["+i+"]"));
				action.clickButton(AddBtn, "Add Button at position "+i+" is selected");
				action.waitForPageLoad();
				}
				
			
			
			action.clickButton(icraPO.AddRowSaveBtn, "Save button");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			action.waitForPageLoad();
			}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("add_Row() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void buttonClickFunctionality(String buttonType) throws Throwable
	{
		try {
			String date = JavaUtilities.datetime("ddMMyyhhmmss");
			WebElement buttonName = driver.findElement(By.xpath("//button[contains(text(),'"+buttonType+"')]"));
			action.WaitUntilDisplayed(buttonName);
			action.clickButton(buttonName, buttonName.getText());
			
			WebElement pageName = driver.findElement(By.xpath("//h5[contains(text(),'"+buttonType+"')]"));
			action.WaitUntilDisplayed(pageName);
			Extent_Reporting.Log_Pass("Page", pageName.getText()+" is displayed", test, driver);
			try {
				String selectname = selectNameFunction(buttonType);
				if((selectname.isEmpty()) && (!(buttonType.equalsIgnoreCase("Hold"))))
				{
					Extent_Reporting.Log_Fail("ButtonName", "Button name is null or wrong", test, driver);
				}
				else
				{
				if	(!(buttonType.equalsIgnoreCase("Hold")))
				{
				WebElement reason= driver.findElement(By.xpath("//select[contains(@id,'ddl"+selectname+"')]"));
				if(action.elementDisplayed(reason))
				{
					action.clickButton(reason, buttonType+" reason");
					List<WebElement> options = driver.findElements(By.xpath("//select[contains(@id,'"+selectname+"')]/option"));
					Random random = new Random();
					int randomNumber = random.nextInt(options.size() - 2) + 2;
					WebElement option = driver.findElement(By.xpath("(//select[contains(@id,'"+selectname+"')]/option)["+randomNumber+"]"));
					action.clickButton(option, option.getText().trim());
				}
				}
				WebElement comment= driver.findElement(By.xpath("//textarea[contains(@placeholder,'Comments')]"));
				WebElement submit= driver.findElement(By.xpath("//h5[contains(text(),'"+buttonType+"')]//following::button[contains(text(),'Submit')]"));
				
				action.inputText(comment, buttonType+" for automation testing on "+date, buttonType+" Comment");
				action.clickButton(submit, "Submit button");
				
				try
				{
					if(!(ExcelHandling.GetExcelData(TC_ID, "TestCaseName").equalsIgnoreCase("BlindCoding_Exception")))
					{
						action.WaitUntilDisplayed(icraPO.Ok);
						action.clickButton(icraPO.Ok, "Ok");
					}
				}catch(Exception e) {}
				String msg = action.elementGetText(icraPO.AlertDialog, "Alert Dialog");
				if(msg.contains("successfully"))
			    {
			    	Extent_Reporting.Log_Pass(buttonType+" Chase", msg, test, driver);
			    	try
			    	{
			    		action.waitForPageLoad();
			    		action.ScrollToTop();
			    		if(action.isElementDisplayed(icraPO.Close, "close"))
			    		{
			    			action.WaitUntilDisplayed(icraPO.Close);
			    	        action.clickButton(icraPO.Close, "Close the coding page");
			    	        action.WaitUntilDisplayed(icraPO.Ok);
			    	        Extent_Reporting.Log_Pass("Close", "Close the coding page", test, driver);
			    	        action.clickButton(icraPO.Ok, "Ok to close chase");
			    	        action.WaitUntilDisplayed(icraPO.CodeReviewSelect);
			    	        Extent_Reporting.Log_Pass("Ok", "Ok to close chase", test, driver);
			    		}
			    	}catch(Exception e) {}
			    	
			    }
			    else
			    {
			    	Extent_Reporting.Log_Fail(TC_ID, msg, test, driver);
			    }
				}
			}catch(Exception e) {}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("buttonClickFunctionality() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	public String selectNameFunction(String buttonType) throws Throwable
	{
		String selectname = null;
		try {
			switch(buttonType)
			{
			case "Reject" 	 : selectname = "RejectChase";
							   break;
			case "Exception" : selectname = "Exception";
			                   break;
			case "No HCC"    : selectname = "NoHCC";
							   break;
			default          : selectname = "";
					           break;
				
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("selectNameFunction() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return selectname;
	}

	
	public void commentHistory() throws Throwable
	{
		try {
			Thread.sleep(7000);
			System.out.println("Comments");
			action.WaitUntilDisplayed(icraPO.Comments);
			action.clickButton(icraPO.Comments, "Comments History");
			action.WaitUntilDisplayed(icraPO.CommentsHistoryPage);
			if(action.elementDisplayed(icraPO.CommentsHistoryTable))
			{
				String order = action.elementGetAttribute(icraPO.CommentsDateTimeSort, "class", "Sort Order");
				if(order.contains("sort-amount-up"))
				{
					Extent_Reporting.Log_Pass("AscendingSort", "Displayed in ascending sort order", test, driver);
					action.clickButton(icraPO.CommentsDateTimeSort, "Select Descending order");
				}
				else if(order.contains("sort-amount-down"))
				{
					Extent_Reporting.Log_Pass("DescendingSort", "Displayed in descending sort order", test, driver);
				}
				else
				{
					Extent_Reporting.Log_Pass("DefaultSort", "Displayed in default sort order", test, driver);
					action.clickButton(icraPO.CommentsDateTimeSort, "");
					action.clickButton(icraPO.CommentsDateTimeSort, "Select Descending order");
				}
			}
			
			commentSorting();
			commentAction();
			action.clickButton(icraPO.Cancel, "Cancel clicked");
			action.WaitUntilDisplayed(icraPO.CodingPage);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("commentHistory() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void commentSorting() throws Throwable
	{
		try {
			int noofrows = driver.findElements(By.xpath("//h5[contains(text(),'Comments')]//following::tbody/tr")).size();
			if(noofrows>1)
			{
				for(int i=1;i<noofrows;i++)
				{
					int j = i+1;
					String firstdate = driver.findElement(By.xpath("(//h5[contains(text(),'Comments')]//following::tbody/tr)["+i+"]/td[2]")).getText().trim();
					String seconddate = driver.findElement(By.xpath("(//h5[contains(text(),'Comments')]//following::tbody/tr)["+j+"]/td[2]")).getText().trim();
					SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"); 
					Date date1 = format.parse(firstdate);  
					Date date2 = format.parse(seconddate);  
					if(date1.after(date2)){
		                Extent_Reporting.Log_Pass("Sorted", "Dates are sorted in descending order", test, driver);
		            }

		            if(date1.before(date2)){
		            	Extent_Reporting.Log_Fail("NotSorted", "Dates are displayed in ascending order", test, driver);
		            }

		            if(date1.equals(date2)){
		            	Extent_Reporting.Log_Pass("Equal", "Dates are exactly equal", test, driver);
		            }
					
				}
			}
			else
			{
				Extent_Reporting.Log_Pass("SingleRow", "Single row cannot check sorting", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("commentSorting() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void commentAction() throws Throwable
	{
		try {
			Extent_Reporting.Log_Pass("CommentTable", "Comment table content", test, driver);
			int noofrows = driver.findElements(By.xpath("//h5[contains(text(),'Comments')]//following::tbody/tr")).size();
			for(int i=1;i<=noofrows;i++)
				{
					WebElement actions = driver.findElement(By.xpath("(//h5[contains(text(),'Comments')]//following::tbody/tr)["+i+"]/td[3]"));
					WebElement comments = driver.findElement(By.xpath("(//h5[contains(text(),'Comments')]//following::tbody/tr)["+i+"]/td[4]"));
					Extent_Reporting.Log_Message("In the "+i+" row , action is - "+actions.getText()+" and comment is - "+comments.getText(), test, driver);
				}
			
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("commentAction() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void setSampling() throws Throwable
	{
		try
		{
			Thread.sleep(5000);
			
			action.clickButton(icraPO.SamplingCoder, "SamplingCoder");
			samplingDetails();
			Extent_Reporting.Log_Pass("Coder", "Sampling done for Coder", test, driver);
			
			action.clickButton(icraPO.SamplingHCC, "SamplingHCC");
			samplingDetails();
			Extent_Reporting.Log_Pass("HCC", "Sampling done for HCC", test, driver);
			Thread.sleep(5000);
			
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("setSampling() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void allocateSampling() throws Throwable
	{
		String msg = null;
		try
		{
			action.clickButton(icraPO.SamplingCoder, "SamplingCoder");
			action.WaitUntilDisplayed(icraPO.SamplingMultiSelect);
			action.clickButton(icraPO.SamplingMultiSelect, "Dropdown");
			action.WaitUntilDisplayed(icraPO.SelectAll);
			action.clickButton(icraPO.SelectAll, "Select All");
			Extent_Reporting.Log_Pass("SelectAll", "Select all Options", test, driver);
			Thread.sleep(5000);
			action.clickButton(icraPO.CloseAll, "CloseAll");
			action.clickButton(icraPO.Allocate, "Allocate Sampling");
			msg = action.elementGetText(icraPO.AlertDialog, "AlertDialog");
	    	if(msg.contains("uccessfully"))
	    	 {
	    	   Extent_Reporting.Log_Pass("Sampling", msg, test, driver);
	         }
	    	else
	    	 {
		       Extent_Reporting.Log_Fail("Sampling", msg, test, driver);
		     }
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("allocateSampling() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void samplingDetails() throws Throwable
	{
		try
		{
			action.WaitUntilDisplayed(icraPO.SamplingMultiSelect);
			action.clickButton(icraPO.SamplingMultiSelect, "Dropdown");
			action.WaitUntilDisplayed(icraPO.SelectAll);
			action.clickButton(icraPO.SelectAll, "Select All");
			Extent_Reporting.Log_Pass("SelectAll", "Select all Options", test, driver);
			Thread.sleep(5000);
			action.clickButton(icraPO.CloseAll, "CloseAll");
			action.inputText(icraPO.SamplingPercentage, "100", "100% sampling");
			try
			{
				WebElement chartSampling = driver.findElement(By.xpath("//input[contains(@formcontrolname,'chkChartTypeSampling')]"));
				if(action.isElementDisplayed(chartSampling, "Chart Sampling"))
				{
					action.clickButton(chartSampling, "Chart Sampling");
				}
			}catch(Exception e) {}
			action.clickButton(icraPO.SamplingSave, "Save");
		}catch (Exception e) {
			Extent_Reporting.Log_FailMessage("samplingDetails() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public String randomAlphabet() throws Throwable
	{
		StringBuilder alphabat = null;
		try {
			Random rnd = new Random();
			final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
			alphabat = new StringBuilder();
			for (int i = 0; i < 5; i++){
			   alphabat.append(AB.charAt(rnd.nextInt(AB.length())));
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("randomAlphabet() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		return alphabat.toString();
	}
     
}
