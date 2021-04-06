package com.qa.BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PageObjects_Pooja;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class AddProvider_BusinessLogic_Pooja extends Extent_Reporting {
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Pooja icra_elements;
	ICRA_BusinessLogic_Pooja BL;

	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;

	public AddProvider_BusinessLogic_Pooja(WebDriver driver, String TC_ID) {
		this.driver = driver;
		this.TC_ID = TC_ID;
		icra_elements = new ICRA_PageObjects_Pooja(driver);

	}
	
	
	public void Createprovider() throws Throwable {

		try {
			action.WaitUntilDisplayed(icra_elements.AddPFirstName);
			action.inputText(icra_elements.AddPFirstName, ExcelHandling.GetExcelData(TC_ID, "PFirstname"),
					"enter firstname ");
			action.WaitUntilDisplayed(icra_elements.AddPMiddleName);
			action.inputText(icra_elements.AddPMiddleName, ExcelHandling.GetExcelData(TC_ID, "PMiddlename"),
					"enter middlename ");
			action.WaitUntilDisplayed(icra_elements.AddPLastName);
			action.inputText(icra_elements.AddPLastName, ExcelHandling.GetExcelData(TC_ID, "PLastname"), "enter lastname ");
			action.WaitUntilDisplayed(icra_elements.AddPCredentials);
			action.inputText(icra_elements.AddPCredentials, ExcelHandling.GetExcelData(TC_ID, "Pcredentials"),
					"enter credentials");
			action.WaitUntilDisplayed(icra_elements.AddPNPI);
			action.inputText(icra_elements.AddPNPI, ExcelHandling.GetExcelData(TC_ID, "PNPI"), "enter NPI");
			action.WaitUntilDisplayed(icra_elements.AddPState);
			action.inputText(icra_elements.AddPState, ExcelHandling.GetExcelData(TC_ID, "Pstate"), "enter state");
			action.WaitUntilDisplayed(icra_elements.AddPGroupname);
			action.inputText(icra_elements.AddPGroupname, ExcelHandling.GetExcelData(TC_ID, "Pgroupname"),
					"enter groupnme ");
		} catch (Exception e) {
            Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		
	}

	public void submitbutton() throws Throwable{
		try {
			action.clickButton(icra_elements.submitbutton, "click on submit button");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
			throw new Exception(e.getMessage());
			}
	}

//	public boolean createprovider_validdata() throws Throwable {
//		
//		boolean flag = false;
//		try {
//			 String msg = null;  
//			Createprovider();
//			submitbutton();
//			if(action.elementDisplayed(icra_elements.AlertDialog))
//			{
//				msg = action.elementGetText(icra_elements.AlertDialog, "Alert dialog");
//				flag = true;
//				if(msg.contains("Provider NPI is Already exists!"))
//				{
//					flag=false;
//				}
//				
//				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
//			}
//			else
//			{
//			   List<WebElement> blankfielderror = driver.findElements(By.xpath("(//div[contains(@class,'invalid')]/div)"));
//			   if (blankfielderror.size() == 0)
//			   {
////				Extent_Reporting.Log_Pass(TC_ID, "provider added", test, driver);
//				flag = true;
//			   }
//			   else 
//			  {
//				for (int i = 1; i <= blankfielderror.size(); i++)
//				{
//					String ele = driver.findElement(By.xpath("(//div[contains(@class,'invalid')]/div)[" + i + "]"))
//							.getText();
//					System.out.println(ele);
//					Extent_Reporting.Log_Message("Error in " + i + "is: " + ele, test, driver);
//					flag=false;
//					
//				}			
//			}
//			}
////			if(msg.contains("NPI is Already Present"))
////			{
////				//String data = action.elementGetText(icra_elements.NPIdata, "NPI data");
//////				if(data.equalsIgnoreCase(ExcelHandling.GetExcelData(TC_ID, "PNPI")))
//////				{
//////					Extent_Reporting.Log_Pass("NPI_check", "NPI data is duplicate and present in system : "+data, test, driver);
//////				}
////				flag= false;
////			}
//			if(flag==true) {
//				Extent_Reporting.Log_Pass(TC_ID, " provider added", test, driver);
//			}
//				
//			else if(flag==false){
//				Extent_Reporting.Log_Fail(TC_ID, " provider  not added", test, driver);
//			}
//		}
//		catch (Exception e) 
//		{
//           Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
//		   throw new Exception(e.getMessage());
//		}
//		return flag;
//	}
//	
public boolean createprovider_validdata() throws Throwable {
		
		boolean flag = false;
		try {
			 String msg = null;  
			Createprovider();
			submitbutton();
			if(action.elementDisplayed(icra_elements.AlertDialog))
			{
				msg = action.elementGetText(icra_elements.AlertDialog, "Alert dialog");
				flag = true;
				if(msg.contains("Provider NPI is Already exists!"))
				{
					flag=false;
				}
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			}
			else
			{
			   List<WebElement> blankfielderror = driver.findElements(By.xpath("(//div[contains(@class,'invalid')]/div)"));
			   if (blankfielderror.size() == 0)
			   {
			     flag = true;
			   }
			   else 
			   {
				for (int i = 1; i <= blankfielderror.size(); i++)
				{
					String ele = driver.findElement(By.xpath("(//div[contains(@class,'invalid')]/div)[" + i + "]"))
							.getText();
					System.out.println(ele);
					Extent_Reporting.Log_Message("Error in " + i + "is: " + ele, test, driver);
					flag=false;					
				}			
			  }
			}

			if(flag==true) {
				Extent_Reporting.Log_Pass(TC_ID, " provider added", test, driver);
			}
				
			else if(flag==false){
				Extent_Reporting.Log_Fail(TC_ID, " provider  not added", test, driver);
			}
		}
		catch (Exception e) 
		{
           Extent_Reporting.Log_FailMessage("createprovider_validdata() failed", test, driver);
		   throw new Exception(e.getMessage());
		}
		return flag;
	}

	public boolean createprovider_invaliddata() throws Throwable {
		boolean flag = false;
		try {
			Createprovider();
			ICRA_error();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("createprovider_invaliddata() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean createprovider_blankddata() throws Throwable {
		boolean flag = false;
		try {
			ICRA_error();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("createprovider_blankddata() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_PFirstname() throws Throwable {
		boolean flag = false;
	    try {
			driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
			if(action.elementDisplayed(icra_elements.AddPFirstName))
				{
				Extent_Reporting.Log_Pass(TC_ID, "Firstname element is displayed", test, driver);
			flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "Firstname element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PFirstname() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_PLastname() throws Throwable {
		boolean flag = false;
		
			try {
				if(action.elementDisplayed(icra_elements.AddPLastName)) {
					Extent_Reporting.Log_Pass(TC_ID, "LastName element is displayed", test, driver);
					flag= true;
				}
				else
 {
					Extent_Reporting.Log_Fail(TC_ID, "LastName element is not  displayed", test, driver);
}
			} catch (Exception e) {
				Extent_Reporting.Log_FailMessage("Display_PLastname() failed", test, driver);
				throw new Exception(e.getMessage());
				}

		return flag;
	}

	public boolean Display_PMiddlename() throws Throwable {
		boolean flag = false;
		
			try {
				if(action.elementDisplayed(icra_elements.AddPMiddleName)) {
					Extent_Reporting.Log_Pass(TC_ID, "PMiddleName element is displayed", test, driver);
				flag = true;
} 
				else	{
					Extent_Reporting.Log_Fail(TC_ID, "PMiddleName element is not  displayed", test, driver);
}
			} catch (Exception e) {
				Extent_Reporting.Log_FailMessage("Display_PMiddlename() failed", test, driver);
				throw new Exception(e.getMessage());
				}
		return flag;
	}

	public boolean Display_PCredentialsname() throws Throwable {
		boolean flag = false;
		
		try {
			if(	action.elementDisplayed(icra_elements.AddPCredentials)) {
				Extent_Reporting.Log_Pass(TC_ID, "PCredentials element is displayed", test, driver);
				flag = true;
			} else {
				Extent_Reporting.Log_Fail(TC_ID, "PCredentials element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PCredentialsname() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;
	}

	public boolean Display_PNPIname() throws Throwable {
		boolean flag = false;
	
			try {
				if(action.elementDisplayed(icra_elements.AddPNPI)) {
					Extent_Reporting.Log_Pass(TC_ID, "PNPI element is displayed", test, driver);
				flag = true;
} else {
				Extent_Reporting.Log_Fail(TC_ID, "PNPI element is not  displayed", test, driver);
}
			} catch (Exception e) {
				Extent_Reporting.Log_FailMessage("Display_PNPIname() failed", test, driver);
				throw new Exception(e.getMessage());
				}

		return flag;
	}

	public boolean Display_PGroupname() throws Throwable {
		boolean flag = false;
		
			try {
				if(action.elementDisplayed(icra_elements.AddPGroupname))
				{
					Extent_Reporting.Log_Pass(TC_ID, "PGroupname element is displayed", test, driver);
				flag = true;
} else {
				Extent_Reporting.Log_Fail(TC_ID, "PGroupname element is not  displayed", test, driver);
}
			} catch (Exception e) {
				Extent_Reporting.Log_FailMessage("Display_PGroupname() failed", test, driver);
				throw new Exception(e.getMessage());
				}
		return flag;
	}

	public boolean Display_PState() throws Throwable {
		boolean flag = false;
		
		try {
			if(action.elementDisplayed(icra_elements.AddPState)) {
				Extent_Reporting.Log_Pass(TC_ID, "AddPState element is displayed", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "AddPState element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PState() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;
	}

	public boolean Display_All_Addproiderelements() throws Throwable {
		
		boolean flag = false;
		
		try {
			Display_PFirstname();
			Display_PLastname();
			Display_PMiddlename();
			Display_PCredentialsname();
			Display_PNPIname();
			Display_PGroupname();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_All_Addproiderelements() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;

	}

	public boolean Display_PUploadbutton() throws Throwable {
		boolean flag = false;
		
		try {
			if(action.elementDisplayed(icra_elements.Uplodfilebuton)) {
				Extent_Reporting.Log_Pass(TC_ID, "Uplodfilebuton element is displayed", test, driver);
			flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "Uplodfilebuton element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PUploadbutton() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_PDownloadTemplate() throws Throwable {
		boolean flag = false;
		try {
			if(action.elementDisplayed(icra_elements.Downtemplatefile)) {
				Extent_Reporting.Log_Pass(TC_ID, "Downtemplatefile element is displayed", test, driver);
				flag = true;	
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "Downtemplatefile element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PDownloadTemplate() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;
	}

	public boolean Display_PChoosefile() throws Throwable {
		boolean flag = false;
		try {
			if(action.elementDisplayed(icra_elements.ChooseFileButton)) {
				
				Extent_Reporting.Log_Pass(TC_ID, "ChooseFileButton element is displayed", test, driver);
			flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "ChooseFileButton element is not  displayed", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_PChoosefile() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_All_AddproiderExcelUploadelements() throws Throwable {
		boolean flag = false;
		try {
			Display_PUploadbutton();
			Display_PChoosefile();
			Display_PDownloadTemplate();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_All_AddproiderExcelUploadelements() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PFirstname_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPFirstName, "placeholder", "firstname");
			if (placeholder.equals("First Name")) {
				flag = true;
				Extent_Reporting.Log_Pass("First Name", "First Name:placeholder verified", test, driver);
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "PFirstname placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PFirstname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PLastname_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPLastName, "placeholder", "LastName");
			if (placeholder.equals("Last Name")) {
				Extent_Reporting.Log_Pass("Last Name", "Last Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "PLastname placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PLastname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PMiddlename_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPMiddleName, "placeholder", "middlename");
			if (placeholder.equals("Middle Name")) {
				Extent_Reporting.Log_Pass("Middle Name", "Middle Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "PMiddlename placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PMiddlename_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PCredentialsname_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPCredentials, "placeholder", "Credentials");
			if (placeholder.equals("Credentials")) {
				Extent_Reporting.Log_Pass("Credentials", "Credentials:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "Credentials placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PCredentialsname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PNPI_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPNPI, "placeholder", "NPI");
			if (placeholder.equals("NPI")) {
				Extent_Reporting.Log_Pass("NPI", "NPI:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "NPI placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PNPI_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PGroupname_placeholder() throws Throwable {
		boolean flag = false;
		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPGroupname, "placeholder", "gropname");
			if (placeholder.equals("Provider Group Name")) {
				Extent_Reporting.Log_Pass("Provider Group Name", "Provider Group Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "Provider Group Name placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PGroupname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_PState_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.AddPState, "placeholder", "state");
			if (placeholder.equals("State")) {
				Extent_Reporting.Log_Pass("State", "State:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, "State:placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_PState_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_All_placeholderofprovider() throws Throwable {
		boolean flag = false;
		try {
			verify_PFirstname_placeholder();
			verify_PLastname_placeholder();
			verify_PMiddlename_placeholder();
			verify_PCredentialsname_placeholder();
			verify_PNPI_placeholder();
			verify_PGroupname_placeholder();
			verify_PState_placeholder();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_All_placeholderofprovider() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_SearchPFirstname() throws Throwable {
		boolean flag = false;
		
		try {
			if(action.elementDisplayed(icra_elements.SearchPFirstname)) {
				Extent_Reporting.Log_Pass("SearchPFirstname", "SearchPFirstname verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "SearchPFirstname is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_SearchPFirstname() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;
	}

	public boolean Display_SearchPLastname() throws Throwable {
		boolean flag = false;
		
		try {
			if(action.elementDisplayed(icra_elements.SearchPLastame)) {
				Extent_Reporting.Log_Pass("SearchPLastame", "SearchPLastame verified", test, driver);
			flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "SearchPLastame is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_SearchPLastname() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_SearchPMiddlename() throws Throwable {
		boolean flag = false;
		try {
			if(action.elementDisplayed(icra_elements.SearchPMiddleame)) {
				Extent_Reporting.Log_Pass("SearchPMiddleame", "SearchPMiddleame verified", test, driver);
			
			flag = true;
			}
			else	{
				Extent_Reporting.Log_Fail(TC_ID, "SearchPMiddleame is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_SearchPMiddlename() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_SearchPNPIname() throws Throwable {
		boolean flag = false;
		try {
			if(action.elementDisplayed(icra_elements.SearchNPIfield)) {
				Extent_Reporting.Log_Pass("SearchNPIfield", "SearchNPIfield verified", test, driver);
			
			flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(TC_ID, "SearchNPIfield is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_SearchPNPIname() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean Display_All_Searchproiderelements() throws Throwable {
		boolean flag = false;
		try {
			Display_SearchPFirstname();
			Display_SearchPMiddlename();
			Display_SearchPLastname();
			Display_SearchPNPIname();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Display_All_Searchproiderelements() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_SearchPFirstname_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.SearchPFirstname, "placeholder", "firstname");
			if (placeholder.equals("First Name")) {
				Extent_Reporting.Log_Pass("First Name", " Search First Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, " Search PFirstname placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_SearchPFirstname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_SearchPMiddlename_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.SearchPMiddleame, "placeholder", "middlename");
			if (placeholder.equals("Middle Name")) {
				Extent_Reporting.Log_Pass("Middle Name", " Search Middle Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, " Search PMiddleName placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_SearchPMiddlename_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_SearchPLastname_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.SearchPLastame, "placeholder", "lastname");
			if (placeholder.equals("Last Name")) {
				Extent_Reporting.Log_Pass("Last Name", " Search Last Name:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, " Search PLastName placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_SearchPLastname_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_SearchPNPI_placeholder() throws Throwable {
		boolean flag = false;

		try {
			String placeholder = action.elementGetAttribute(icra_elements.SearchNPIfield, "placeholder", "npi");
			if (placeholder.equals("NPI")) {
				Extent_Reporting.Log_Pass("NPI field", " Search NPI field:placeholder verified", test, driver);
				flag = true;
			}
			else {
				Extent_Reporting.Log_Fail(placeholder, " Search NPI placeholder is not verified", test, driver);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_SearchPNPI_placeholder() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public boolean verify_All_placeholderofSearchprovider() throws Throwable {
		boolean flag = false;
		try {
			verify_SearchPFirstname_placeholder();
			verify_SearchPMiddlename_placeholder();
			verify_SearchPLastname_placeholder();
			verify_SearchPNPI_placeholder();
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("verify_All_placeholderofSearchprovider() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	public void ICRA_error() throws Throwable {
		try {
			action.WaitUntilDisplayed(icra_elements.submitbutton);
			action.clickButton(icra_elements.submitbutton, "click on save button");
			Extent_Reporting.Log_Pass("submit", "click on save", test, driver);
			List<WebElement> blankfielderror = driver.findElements(By.xpath("(//div[contains(@class,'invalid')]/div)"));
			if (blankfielderror.size() > 0) {
				for (int i = 1; i <= blankfielderror.size(); i++) {
					String ele = driver.findElement(By.xpath("(//div[contains(@class,'invalid')]/div)[" + i + "]"))
							.getText();
					System.out.println(ele);
					Extent_Reporting.Log_Message("Error in " + i + "is: " + ele, test, driver);
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("ICRA_error() failed", test, driver);
			throw new Exception(e.getMessage());
			}

	}

	/**
	 * Method:FName- searching Fname String Fname- taking Fname from Excel
	 * @throws Throwable 
	 */
	public String FName() throws Throwable {
		String Fname = ExcelHandling.GetExcelData(TC_ID, "PFirstname");
		try {
			System.out.println(Fname);
			action.inputText(icra_elements.SearchPFirstname, Fname, "Enter firstname ");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("FName() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return Fname;
	}

	/**
	 * Method:MName- searching Mname String Mname- taking Mname from Excel
	 * @throws Throwable 
	 */
	public String MName() throws Throwable {
		String Mname = ExcelHandling.GetExcelData(TC_ID, "PMiddlename");
		try {
			System.out.println(Mname);
			action.inputText(icra_elements.SearchPMiddleame, Mname, "Enter MiddleName ");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("MName() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return Mname;
	}

	/**
	 * Method:LName- searching Lname String Lname- taking Lname from Excel
	 * @throws Throwable 
	 */
	public String LName() throws Throwable {
		String Lname = ExcelHandling.GetExcelData(TC_ID, "PLastname");
		try {
			System.out.println(Lname);
			action.inputText(icra_elements.SearchPLastame, Lname, "Enter LastName ");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("LName() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return Lname;
	}

	/**
	 * Method:LName- searching NPI String npi- taking npi from Excel
	 * @throws Throwable 
	 */
	public String NPI() throws Throwable {
		String npi = ExcelHandling.GetExcelData(TC_ID, "PNPI");
		try {
			System.out.println(npi);
			action.inputText(icra_elements.SearchNPIfield, npi, "Enter NPI ");
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("NPI() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return npi;
	}

	/**
	 * search- clicks search
	 * @throws Throwable 
	 * 
	 */
	public void search() throws Throwable {
		
	
	try {
		action.clickButton(icra_elements.searchbutton, "Search Button clicked");
		try
		{
		  WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
		   //if(action.isElementDisplayed(icra_elements.AlertDialog,"AlertDialog"))
		  if(action.isElementDisplayed(w,"AlertDialog"))
		   {
		                action.elementGetText(icra_elements.AlertDialog, "Alert dialog");
		                Extent_Reporting.Log_Fail(TC_ID, "grid is not displayed", test, driver);
		   }
		}
		catch(Exception e)
		{
		  action.WaitUntilDisplayed(icra_elements.grid);
		  Extent_Reporting.Log_Pass("grid table", " grid is displayed", test, driver);
		}
	} catch (Exception e) {
		Extent_Reporting.Log_FailMessage("search() failed", test, driver);
		throw new Exception(e.getMessage());
		}
    
}

	

	/**
	 * Method: SearchByFName- searches first name and verifies the data returns:
	 * flag
	 * @throws Throwable 
	 * 
	 */
	public boolean Verify_searchFunctionalityfor_Firstname() throws Throwable {
		boolean flag = false;
		try {
			String firstname = FName();
			search();
			ArrayList<String> listdata = new ArrayList<String>();
			List<WebElement> fname = driver.findElements(By.xpath("//div[@col-id='PFirstName' and @role='gridcell']"));

			int size = fname.size();
			System.out.println(size);

			for (int i = 0; i < fname.size(); i++) {

				String ele = fname.get(i).getText();
				listdata.add(ele);
			    
			

			}
			for (String data : listdata) {
				{
					if (data.contains(firstname)||data.equalsIgnoreCase(firstname)) {
						System.out.println(data);
						Extent_Reporting.Log_Message("user search for:"+data, test, driver);
						Extent_Reporting.Log_Pass(TC_ID, "data is searched successully ", test, driver);
						flag = true;
						break;
					}
				}

			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Verify_searchFunctionalityfor_Firstname() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	/**
	 * Method: SearchByMName- searches middle name and verifies the data returns:
	 * flag
	 * @throws Throwable 
	 * 
	 */
	public boolean Verify_searchFunctionalityfor_Middlename() throws Throwable {
		boolean flag = false;
		try {
			String middlename = MName();
			search();
			ArrayList<String> listdata = new ArrayList<String>();
			List<WebElement> mname = driver.findElements(By.xpath("//div[@col-id='PMiddleName' and @role='gridcell']"));

			int size = mname.size();
			System.out.println(size);

			for (int i = 0; i < mname.size(); i++) {

				String ele = mname.get(i).getText();
				listdata.add(ele);

			}
			for (String data : listdata) {
				{
					if (data.contains(middlename)||data.equalsIgnoreCase(middlename)) {
						System.out.println(data);
						Extent_Reporting.Log_Message("user search for:"+data, test, driver);
						Extent_Reporting.Log_Pass(TC_ID, "data is searched successully ", test, driver);
						flag = true;
						break;
					}
				}

			}
		}  catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Verify_searchFunctionalityfor_Middlename() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	/**
	 * Method: SearchByLName- searches last name and verifies the data returns: flag
	 * @throws Throwable 
	 * 
	 */
	public boolean Verify_searchFunctionalityfor_Lastname() throws Throwable {
		boolean flag = false;
		try {
			String lastname = LName();
			search();
			ArrayList<String> listdata = new ArrayList<String>();
			List<WebElement> lname = driver.findElements(By.xpath("//div[@col-id='PLastName' and @role='gridcell']"));

			int size = lname.size();
			System.out.println(size);

			for (int i = 0; i < lname.size(); i++) {

				String ele = lname.get(i).getText();
				listdata.add(ele);

			}
			for (String data : listdata) {
				{
					if ((data.contains(lastname))||(data.equalsIgnoreCase(lastname))) {
						System.out.println(data);
						Extent_Reporting.Log_Message("user search for:"+ data, test, driver);
						Extent_Reporting.Log_Pass(TC_ID, "data is searched successully ", test, driver);
						flag = true;
						break;
					}
					
				}

			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Verify_searchFunctionalityfor_Lastname() failed", test, driver);
			throw new Exception(e.getMessage());}
		return flag;
	}

	/**
	 * Method: SearchByNPI- searches npi field and verifies the data returns: flag
	 * @throws Throwable 
	 * 
	 */
	public boolean Verify_searchFunctionalityfor_NPI() throws Throwable {
		boolean flag = false;
		try {
			String npifield = NPI();
			search();
			ArrayList<String> listdata = new ArrayList<String>();
			List<WebElement> npi = driver.findElements(By.xpath("//div[@col-id='ProviderNPI' and @role='gridcell']"));

			int size = npi.size();
			System.out.println(size);

			for (int i = 0; i < npi.size(); i++) {

				String ele = npi.get(i).getText();
				listdata.add(ele);

			}
			for (String data : listdata) {
				{
					if (data.equalsIgnoreCase(npifield)) {
						System.out.println(data);
						Extent_Reporting.Log_Message("user search for:"+data, test, driver);
						Extent_Reporting.Log_Pass(TC_ID, "data is searched successully ", test, driver);
						flag = true;
					}
				}

			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("Verify_searchFunctionalityfor_NPI() failed", test, driver);
			throw new Exception(e.getMessage());}
		return flag;
	}

	public boolean downloadtemplate() throws Throwable {
		boolean flag = false;
		try {
			action.WaitUntilDisplayed(icra_elements.Downtemplatefile);
			action.clickButton(icra_elements.Downtemplatefile, "download template");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("downloadtemplate() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		return flag;
	}

	

	public boolean uplodfiledynamically() throws Throwable {
		boolean flag = false;
		try {
			flag = downloadtemplate();
			      
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			File file = JavaUtilities.getTheNewestFile(GlobalConstant.DownloadPath, "xlsx");
			log.info("File Recevied And File Location is......." + file.getAbsolutePath());
			String fi = file.toString();
			fis = new FileInputStream(fi);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			String Firstname = ExcelHandling.GetExcelData(TC_ID, "PFirstname");
			String Middlename = ExcelHandling.GetExcelData(TC_ID, "PMiddlename");
			String Lastname = ExcelHandling.GetExcelData(TC_ID, "PLastname");
			String NPI = ExcelHandling.GetExcelData(TC_ID, "PNPI");
			String credentials = ExcelHandling.GetExcelData(TC_ID, "Pcred");
			String state = ExcelHandling.GetExcelData(TC_ID, "Pstate");
			
			sheet.getRow(1).createCell(0).setCellValue(NPI);
			sheet.getRow(1).createCell(1).setCellValue(Firstname);
			sheet.getRow(1).createCell(2).setCellValue(Middlename);
			sheet.getRow(1).createCell(3).setCellValue(Lastname);
			sheet.getRow(1).createCell(4).setCellValue(credentials);
			sheet.getRow(1).createCell(5).setCellValue(state);
			FileOutputStream fo = new FileOutputStream(file);
			wb.write(fo);
			fo.close();
			for(int i=0;i<=6;i++) {
			action.WaitUntilDisplayed(icra_elements.ChooseFileButton);
			}
			action.inputText(icra_elements.ChooseFileButton, fi, "file is selected");
			
			for(int i=0;i<=8;i++) {
				action.WaitUntilDisplayed(icra_elements.Uplodfilebuton);
				}
			action.clickButton(icra_elements.Uplodfilebuton, "file uploaded");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

			flag = true;
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("uplodfiledynamically() failed", test, driver);
			throw new Exception(e.getMessage());
			}

		return flag;

	}
   
}
