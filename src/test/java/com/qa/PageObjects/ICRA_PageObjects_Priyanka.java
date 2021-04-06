package com.qa.PageObjects;
/**
 * @author pbhattacharjee
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRA_PageObjects_Priyanka extends DriverCalling{
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement AlertDialog;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement SelectClient;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement Submit;
	
	@FindBy(xpath = "//div[contains(@class,'sidebar-left')]")
	public WebElement Menu;
	
	@FindBy(xpath = "//div[contains(@class,'sidebar-left')]")
	public WebElement SidebarLength;
	
	@FindBy(xpath = "//div[@class='required-icon']//preceding-sibling::label")
	public WebElement MandatoryFields;
	
	@FindBy(xpath = "//div[@class='pull-left']//img[contains(@src,'logo.png')]")
	public WebElement CompanyLogo;
	
	@FindBy(xpath = "//span[@class='footer-legal']")
	public WebElement Copyrights;
	
	//------------------- CLIENT CONFIGURATION---------------------------------------
	@FindBy(xpath = "//strong[contains(text(),'Sub Client Name')]//following::button")
	public WebElement AddSubClients;
	
	@FindBy(xpath = "//input[@name='subClient1']")
	public WebElement SubClient;
	
	@FindBy(xpath = "//select[@formcontrolname='MultiSubClient']")
	public WebElement SubClientList;
	
	
	@FindBy(xpath = "//strong[contains(text(),'Attribute Type')]//following::select")
	public WebElement AttributeTypeDD;
	
	@FindBy(xpath = "//span[@class='error']")
	public WebElement BlankError;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement Save;
	
	@FindBy(xpath = "//button[contains(text(),'Clear')]")
	public WebElement Clear;
	
	//-------------------- LOGOUT ------------------------------------------
	
	@FindBy(xpath = "//li[contains(@class,'dropdown')]/a")
	public WebElement ProfileDD;
	
	@FindBy(xpath = "//a[contains(@href,'login')]")
	public WebElement Logout;
	
	@FindBy(xpath = "//a[contains(@href,'dashboard')]")
	public WebElement Homepage;
	
	
	//-------------------- SELECT CLIENT--------------------------------
	@FindBy(xpath = "//select[@name='ClientName']")
	public WebElement ClientNameProjectConf;
	
	@FindBy(xpath = "//select[@name='SubClientName']")
	public WebElement SubClientNameProjectConf;
	
	//-------------------- CODE REVIEW----------------------------------
	@FindBy(xpath = "//select[@name='Project']")
	public WebElement CodeReviewSelect;
	
	@FindBy(xpath = "//button[contains(text(),'Start')]")
	public WebElement StartCodingBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Project')]//following::strong")
	public WebElement CodingPage;
	
	@FindBy(xpath = "//button[contains(text(),'Chase ID')]//following::strong")
	public WebElement ChaseID;
	
	@FindBy(xpath = "//button[contains(text(),'Page Count')]//following::strong")
	public WebElement PageCount;
	
	@FindBy(xpath = "//button[contains(text(),'Chase ID')]//following::a[contains(@href,'.pdf')]")
	public WebElement MedicalRecord;
	
	@FindBy(xpath = "//input[@id='CDOSFromDate' or @formcontrolname='DOSFrom']")
	public WebElement FromDate;
	
	@FindBy(xpath = "//input[@id='CDOSToDate' or @formcontrolname='DOSTo']")
	public WebElement ToDate;  
	
	@FindBy(xpath = "//span[contains(text(),'Total Row')]/b")
	public WebElement TotalRow;  
	
	@FindBy(xpath = "//tbody[contains(@class,'owl-dt-calendar-body')]//td/span[contains(@class,'selected')]/..")
	public WebElement SelectedDate;  
	
	@FindBy(xpath = "//div[contains(@class,'owl-dt-container')]")
	public WebElement Calender;
	
	@FindBy(xpath = "//input[@id='CDOSToDate']/following::input[contains(@class,'ui-inputtext')]")
	public WebElement Provider;   
	
	@FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')]")
	public WebElement AutoCompleteList; 
	
	@FindBy(xpath = "//label[@id='lblCYTolalRecordsCount']//strong")
	public WebElement BlindCodingSavedRecordCount; 
	
	@FindBy(xpath = "//tbody[@id='tbodytblCYData']//tr")
	public WebElement BlindCodingSavedTableData; 
		
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	public WebElement Close;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebElement Ok;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement Cancel;
	
	@FindBy(xpath = "//button[contains(@id,'ClearAll')]")
	public WebElement ClearAll;
	
	@FindBy(xpath = "(//h6[@class='panel-title'])[last()]/a")
	public WebElement Toggle;
	
	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	public WebElement EditCodedTab;
	
	@FindBy(xpath = "//div[contains(text(),'Hold')]")
	public WebElement HoldTab;
	
	@FindBy(xpath = "//div[contains(text(),'Exception')]")
	public WebElement ExceptionTab;
	
	@FindBy(xpath = "//button[contains(text(),'Update Selected')]")
	public WebElement UpdateSelectedBtn;
	
	@FindBy(xpath = "//h5[contains(text(),'Bulk Update')]")
	public WebElement BulkUpdatePage;
	
	@FindBy(xpath = "//h5[contains(text(),'Bulk Update')]//following::select[contains(@formcontrolname,'Primary')]")
	public WebElement BulkPrimary;
	
	@FindBy(xpath = "//h5[contains(text(),'Bulk Update')]//following::*[contains(@formcontrolname,'SecondaryFindings')]//div[contains(@class,'trigger')]")
	public WebElement BulkSecondary;
	
	@FindBy(xpath = "//button[contains(text(),'Bulk Update')]")
	public WebElement BulkUpdateBtn;
	
	@FindBy(xpath = "//div[contains(@role,'rowgroup') and contains(@class,'center')]")
	public WebElement Data;
	
	@FindBy(xpath = "//div[contains(@class,'ag-cell') and contains(@col-id,'TimeSpent')]")
	public WebElement EditCodedData_TimeSpent;
	
	@FindBy(xpath = "//div[contains(@class,'ag-cell') and contains(@col-id,'TimeRemaining')]")
	public WebElement EditCodedData_TimeRemaining;
	
	@FindBy(xpath = "//h5[contains(text(),'View/Update')]")
	public WebElement View_Update;
	
	@FindBy(xpath = "//input[contains(@id,'updtComments')]")
	public WebElement Update_Comment;
	
	@FindBy(xpath = "//input[contains(@id,'updtPage')]//following::input")
	public WebElement Update_DX;
	
	@FindBy(xpath = "//h5[contains(text(),'View/Update')]//following::button[contains(text(),'Update')]")
	public WebElement Update;
	
	@FindBy(xpath = "//h5[contains(text(),'View/Update')]//following::button[contains(text(),'Delete')]")
	public WebElement Delete;
	
	@FindBy(xpath = "//button[contains(@title,'Row')]//following::label")
	public WebElement RecordCount; 
	
	@FindBy(xpath = "//button[contains(@id,'Save')]")
	public WebElement CodingSaveBtn; 
	
	@FindBy(xpath = "//button[contains(text(),'Row')]")  //button[contains(@title,'Add New Row')]
	public WebElement AddRowBtn; 
	
	@FindBy(xpath = "//h5[contains(text(),'Add Row')]")
	public WebElement AddRowPage;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement AddRowSaveBtn; 
	
	@FindBy(xpath = "//span[contains(text(),'Total Rows')]//following::span[contains(@class,'trigger')]")
	public WebElement TotalGrouping; 
	
	@FindBy(xpath = "//ul[contains(@class,'multiselect-list')]")
	public WebElement MultipleSelect; 
	
		
	@FindBy(xpath = "//button[contains(text(),'Comments')]")
	public WebElement Comments;
	
	@FindBy(xpath = "//h5[contains(text(),'Comments History')]")
	public WebElement CommentsHistoryPage;
	
	@FindBy(xpath = "//tbody[contains(@class,'ui-table-tbody')]")
	public WebElement CommentsHistoryTable;
	
	@FindBy(xpath = "//span[contains(text(),'Date and Time')]//i")
	public WebElement CommentsDateTimeSort;
	
	//---------------------------Exception----------------------------------------------
	
	@FindBy(xpath = "//tbody[contains(@class,'ui-table-tbody')]/tr")
	public WebElement ExceptionTable;
	
	@FindBy(xpath = "//span[contains(text(),'ChaseID')]//following::span")
	public WebElement ChaseID_DD;
	
	@FindBy(xpath = "//div[contains(@class,'ui-multiselect-filter')]/input")
	public WebElement ChaseID_Input;
	
	@FindBy(xpath = "//tbody[contains(@class,'ui-table-tbody')]//td")
	public WebElement Tbody_Data;
	
	
	//-------------------------SAMPLING---------------------------------------------
	
	@FindBy(xpath = "//div[contains(@class,'multiselect')]//span[contains(@class,'trigger')]")
	public WebElement SamplingMultiSelect;
	
	@FindBy(xpath = "//div[contains(text(),'Coder')]/..")
	public WebElement SamplingCoder;
	
	@FindBy(xpath = "//div[contains(text(),'HCC')]/..")
	public WebElement SamplingHCC;
	
	@FindBy(xpath = "//div[contains(@class,'chkbox-box')]")
	public WebElement SelectAll;

	@FindBy(xpath = "//a[contains(@class,'multiselect-close')]")
	public WebElement CloseAll;
	
	@FindBy(xpath = "//input[contains(@formcontrolname,'SamplingPer')]")
	public WebElement SamplingPercentage;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement SamplingSave;
	
	@FindBy(xpath = "//button[contains(text(),'Allocate Sampling')]")
	public WebElement Allocate;
	
	public ICRA_PageObjects_Priyanka(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}
