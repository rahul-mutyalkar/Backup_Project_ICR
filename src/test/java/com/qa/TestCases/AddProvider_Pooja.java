package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.AddProvider_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class AddProvider_Pooja extends DriverCalling {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	public static String startTime;
	public static String endTime;
	Long StartTime;
	Long EndTime;

	public static WebDriver webDriver = null;
	public static String tcID = null;
	ICRA_BusinessLogic_Pooja BL = null;
	AddProvider_BusinessLogic_Pooja provider_BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;

	@Test
	public void TC_AddProvider_Pooja() throws Throwable {

		file = new File(GlobalConstant.ExcelPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheet = wb.getSheetAt(i);
			for (int j = 1; j <= sheet.getLastRowNum(); j++) {

				if ((sheet.getRow(j).getCell(2).toString()).equalsIgnoreCase(this.getClass().getSimpleName())
						&& (sheet.getRow(j).getCell(4).toString()).equalsIgnoreCase("Y")) {
					StartTime = System.currentTimeMillis();
					try
					{
						tcID = sheet.getRow(j).getCell(1).toString();
						log.info(tcID);
						webDriver = launchbrowser(tcID);
						BL = new ICRA_BusinessLogic_Pooja(webDriver, tcID);
						provider_BL = new AddProvider_BusinessLogic_Pooja(webDriver, tcID);
						PBL = new ICRA_BusinessLogic_Priyanka(webDriver, tcID);
						BL.ICRA_Login();
						// BL.Click_On_Login();
						PBL.ICRA_Client_Select();
						
						PBL.ICRA_Menu_Selection("");
						if (tcID.contains("Verify all elements are present in add provider tab"))
						{
							boolean statusdisplayallprovider = provider_BL.Display_All_Addproiderelements();
							Assert.assertTrue(statusdisplayallprovider, " elements are not displayed");
						} 
						else	if (tcID.contains("placeholder of addprovider"))
						{
							boolean statusplaceholderofprovider = provider_BL.verify_All_placeholderofprovider();
							Assert.assertTrue(statusplaceholderofprovider, " placeholder are  not correct ");

						} 
						else if (tcID.contains("createprovider_validdata"))  
						{
							boolean statuscreatevalidprovider = provider_BL.createprovider_validdata();
							Assert.assertTrue(statuscreatevalidprovider, " provider is not  created  ");
							log.info(" data created with valid data");
						

						} else if (tcID.contains("createprovider_invaliddata")) {
							boolean statuscreateinvalidprovider = provider_BL.createprovider_invaliddata();
							Assert.assertTrue(statuscreateinvalidprovider, " provider is  not created  ");

						} else if (tcID.contains("createprovider_blankddata")) {
							boolean statuscreateblankprovider = provider_BL.createprovider_blankddata();
							Assert.assertTrue(statuscreateblankprovider, " provider is not  created  ");

						} else if (tcID.contains("excel upload tab")) {

							boolean statusAddproiderExcelUploadelements = provider_BL
									.Display_All_AddproiderExcelUploadelements();
							Assert.assertTrue(statusAddproiderExcelUploadelements,
									"display all element of excel upload");
						} else if (tcID.contains("all elements of search provider")) {
							boolean statusSearchproiderelements = provider_BL.Display_All_Searchproiderelements();
							Assert.assertTrue(statusSearchproiderelements,
									" displayed all element of search provider ");
						}

						else if (tcID.contains("placeholder of searchprovider")) {
							boolean statusverify_All_placeholderofSearchprovider = provider_BL
									.verify_All_placeholderofSearchprovider();
							Assert.assertTrue(statusverify_All_placeholderofSearchprovider, "verified all placeholder");
						}

						else if (tcID.contains("uplodfiledynamically")) {
							boolean uploadfilestatus = provider_BL.uplodfiledynamically();
							Assert.assertTrue(uploadfilestatus, "file is uploaded");
						}

						else if (tcID.contains("searchFunctionalityfor_Firstname")) {
							boolean uploadfilestatus = provider_BL.Verify_searchFunctionalityfor_Firstname();
							Assert.assertTrue(uploadfilestatus, "searchFunctionality is verified for firstname");
						}

						else if (tcID.contains("searchFunctionalityfor_Middlename")) {
							boolean Middlenamestatus = provider_BL.Verify_searchFunctionalityfor_Middlename();
							Assert.assertTrue(Middlenamestatus, "searchFunctionality is not verified for middlename");
						}

						else if (tcID.contains("searchFunctionalityfor_Lastname")) {
							boolean Lastnamestatus = provider_BL.Verify_searchFunctionalityfor_Lastname();
							Assert.assertTrue(Lastnamestatus, "searchFunctionality is not verified for lastname");
						}

						else if (tcID.contains("searchFunctionalityfor_NPI")) {
							boolean NPIstatus = provider_BL.Verify_searchFunctionalityfor_NPI();

							Assert.assertTrue(NPIstatus, "searchFunctionality is  not verified for npi");

						}
						EndTime = System.currentTimeMillis();
						EndExcelReport1(EndTime, StartTime, tcID);
						EndReport();
					}
				
						catch (AssertionError e) 
                		{
							 EndTime=System.currentTimeMillis();
							 EndExcelReport(EndTime,StartTime,"Fail",tcID);
							EndReport();
							
						}
					 catch (Exception e) {
						EndTime = System.currentTimeMillis();
						EndExcelReport(EndTime, StartTime, "Fail", tcID);
						EndReport();
					}
				}
			}
		}
	}

	@AfterTest
	public void CloseDriver() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
