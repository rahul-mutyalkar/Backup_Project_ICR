package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRA_PNPException_PO_Dhanshri extends DriverCalling {
	
	/*******************Send  ********************************/
	
	@FindBy(xpath ="//select[@id='ProjectType']")
	public WebElement projectDD;
	
	
	@FindBy(xpath = "//tr[1][@class='ui-selectable-row ng-star-inserted']")
	public WebElement TRow;
	
	
	
	
	@FindBy(xpath = "//button[@id='btnSend']")
	public WebElement SendButton;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement AlertDialog;
	
	@FindBy(xpath = "//tr[1]//td//div[2][contains(@class,'ui-chkbox-box')]")
	
//@FindBy(xpath = "//tr[1]//td[1]//div[2][@role='checkbox']")
	public WebElement Checkbox;
	
	@FindBy(xpath = "//tr[1]//td[2]//input[@class='addressMstComment form-control ng-star-inserted']")
	public WebElement ResolutionNote;
	
	
	@FindBy(xpath = "//tr[1]//td[3][@class='text-center ng-star-inserted']")
	public WebElement ChaseID;
	
	@FindBy(xpath = "//div[@id='mat-tab-label-0-1']")
	public WebElement PNPsendtoclientTab;
	
	@FindBy(xpath = "//div[@id='mat-tab-label-0-2']")
	public WebElement PNPclientResponse;
	
	
	/*******************Validation message  ********************************/
	
	@FindBy(xpath = "//div[contains(text(),'Please select atleast one exception')]")
	public WebElement Errormsg;  //Without selecting anything click on Release/send button
	
	@FindBy(xpath = "//div[contains(text(),'Please insert comment')]")
	//@FindBy(xpath = "//div[@aria-label='Please insert comment']")
	public WebElement ErrormsgSCB;  //Without resolution note click on Release/send button
	
	
	@FindBy(xpath = "//div[contains(text(),'Please select atleast one exception')]")
	public WebElement ErrormsgWRN;  //Without selecting check box click on Release/send button
	
	
	@FindBy(xpath = "//div[contains(text(),'Record saved successfully.')]")
	//@FindBy(xpath = "//div[@aria-label='Record saved successfully.']")
	public WebElement Valmsg;  //With resolution note & check box click on Release/send button
	
	
	
	
	/*******************Release  ********************************/
	
	@FindBy(xpath = "//button[@id='btnRelease']")
	public WebElement ReleaseButton;
	
	
	/*******************Export To Excel  ********************************/
	@FindBy(xpath = "//button[@id='btnExportToExcel']")
	public WebElement ExportToExcel;
	
	
	/*******************Filter for table1  ********************************/
	@FindBy(xpath = "//span[@class='ui-chkbox-icon ui-clickable pi pi-check']")
	public WebElement ClearFilter;
	
	@FindBy(xpath = "//div[@class='ui-chkbox ui-widget ng-tns-c11-139 ng-star-inserted']")
	public WebElement ClearFilterCB;
	

	@FindBy(xpath = "//tr[2]//td[6][@class='text-center']")
	public WebElement ChaseCount;
	
	
	@FindBy(xpath = "//tr[1]//td[5][@class='text-center']")
	public WebElement AddressCount;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'All ChaseID')]")
	public WebElement ChaseIDF;
	
	@FindBy(xpath = "//span[contains(text(),'All AddressMasterID')]")
	public WebElement AddressIDF;
	
	
	@FindBy(xpath = "//span[contains(text(),'All MemberName')]")
	public WebElement MemberNameF;
	
	@FindBy(xpath = "//input[@class='ui-inputtext ui-widget ui-state-default ui-corner-all'][@role='textbox']")
	public WebElement MemberNameCB;
	
	
	@FindBy(xpath = "//span[contains(text(),'All MemberDOB')]")
	public WebElement MemberDOBF;
	
	
	@FindBy(xpath = "//span[contains(text(),'All ProviderName')]")
	public WebElement ProviderNameF;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'All ProviderGroupName')]")
	public WebElement GroupNameF;
	
	@FindBy(xpath = "//span[contains(text(),'All ProviderCity')]")
	public WebElement CityF;
	
	@FindBy(xpath = "//span[contains(text(),'All ProviderState')]")
	public WebElement StateF;
	
	@FindBy(xpath = "//span[contains(text(),'All ProviderPhone')]")
	public WebElement PhoneF;
	
	@FindBy(xpath = "//span[contains(text(),'All CreatedDate')]")
	public WebElement DateCreatedF;
	

	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement ChaseIDTB;

	//@FindBy(xpath = "//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']/parent::div")
	@FindBy(xpath = "//div[@role='checkbox'][@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	public WebElement ChaseIDCB;
	

	@FindBy(xpath = "//p-multiselectitem[1]//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'")
	public WebElement ChaseIDS;
	
		
	
	/*******************First Row of table 2  ********************************/
	
	@FindBy(xpath = "//tr[1]//td[3][@class='text-center ng-star-inserted']")
	public WebElement ChaseIDTRW;
		
	@FindBy(xpath = "//tr[1]//td[4][@class='text-center']")
	public WebElement AddressIDTRW;
	
	
	@FindBy(xpath = "//tr[1]//td[5][@class='ng-star-inserted']")
	public WebElement MemberNameTRW;
	
	@FindBy(xpath = "//tr[1]//td[6][@class='ng-star-inserted']")
	public WebElement MemberDOBTRW;
	
	
	@FindBy(xpath = "//tr[1]//td[7][@class='ng-star-inserted']")
	public WebElement ProviderNameTRW;
	
	
	@FindBy(xpath = "//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'][@role='checkbox']")
	public WebElement ProviderNameCB;
	
	
	
	
	@FindBy(xpath = "//tr[1]//td[8][@class='ng-star-inserted']")
	public WebElement GroupNameTRW;
	
	@FindBy(xpath = "//*[@id=\"content\"]//table/tbody/tr[1]/td[9]")
	public WebElement CityTRW;
	
	@FindBy(xpath = "//*[@id=\"content\"]//table/tbody/tr[1]/td[10]")
	public WebElement StateTRW;
	
	@FindBy(xpath = "//tr[1]//td[11][@class='text-center']")
	public WebElement PhoneTRW;
	
	@FindBy(xpath = "//*[@id=\"content\"]//table/tbody/tr[1]/td[12]")
	public WebElement DateCreatedTRW;
	
	
	/*******************Filter for table1  ********************************/
	
	@FindBy(xpath = "//span[contains(text(),'All Count')]")
	public WebElement ExceptioncountF;
	
	@FindBy(xpath = "//span[contains(text(),'All Type')]")
	public WebElement TypeF;
	
	@FindBy(xpath = "//span[contains(text(),'All PNPCode')]")
	public WebElement PNPCodeF;
	
	@FindBy(xpath = "//span[contains(text(),'All PNPDescription')]")
	public WebElement PNPExceptionF;
	
	@FindBy(xpath = "//span[contains(text(),'All Address Count')]")
	public WebElement AddressCountF;
	
	
	@FindBy(xpath = "//span[contains(text(),'All Chase Count')]")
	public WebElement ChaseCountF;
	
	
	
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement ExceptioncountTB;
	
	
	@FindBy(xpath = "//div[@role='checkbox']")
	public WebElement ExceptioncountCB;
	
	
	
	@FindBy(xpath = "//p-multiselectitem[1]//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	public WebElement checkboxfilter;
	/*******************First Row of table 1  ********************************/
	
	@FindBy(xpath = "//tr[1]//td[1][@class='text-center']")
	public WebElement ExceptioncountFRW;
	
	
	@FindBy(xpath = "//tr[1]//td[5][@class='text-center']")
	public WebElement AddressCountFRW;
	
	
	@FindBy(xpath = "//tr[1]//td[6][@class='text-center']")
	public WebElement ChaseCountFRW;
	
	
	
	
	
	
	
	
	public ICRA_PNPException_PO_Dhanshri(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
}
