package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICRA_Intake_PO_Dhanshri {
	
	@FindBy(xpath = "//div[@class='mat-tab-label mat-ripple ng-star-inserted']")
	public WebElement HoldTab;
	
	
	
	@FindBy(xpath = "//input[@formcontrolname='SplitFrom']")
	public WebElement SplitFrom;
	
	@FindBy(xpath = "//input[@formcontrolname='SplitTill']")
	public WebElement SplitTo;

	@FindBy(xpath = "//div[@class='pdfViewer']")
	public WebElement pdf;
	
	
	@FindBy(xpath = "//div[@class='canvasWrapper']")
	public WebElement pdft;
	
	@FindBy(xpath = "//button[@class='toolbarButton zoomIn']")
	public WebElement Zoomin;

	@FindBy(xpath = "//button[@class='toolbarButton zoomOut']")
	public WebElement Zoomout; 
	
	@FindBy(xpath = "//button[@id='secondaryToolbarToggle']")
	public WebElement pdftool; 
	
	@FindBy(xpath = "//span[@data-l10n-id='page_rotate_ccw_label']")
	public WebElement rccw;
	
	@FindBy(xpath = "//span[@data-l10n-id='page_rotate_cw_label']")
	public WebElement rcw;
	
	@FindBy(xpath = "//div[@class='page']")
	public WebElement pages;
	
	@FindBy(xpath = "//span[@data-l10n-id='last_page_label']")
	public WebElement gtlastpage;
	

	@FindBy(xpath = "//span[@data-l10n-id='first_page_label']")
	public WebElement gtfirstpage;
	
	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary mb5'][contains(text(),'Hold ')]")
	public WebElement holdbutton;
	
	@FindBy(xpath = "//select[@id='ReasonType']")
	public WebElement holdreason;
	
	@FindBy(xpath = "//input[@formcontrolname='CommentField']")
	public WebElement holdComments;

	
	@FindBy(xpath = "//button[1][@class='pull-left ant-btn ng-star-inserted ant-btn-primary']")
	public WebElement holdSubmit;
	
	
	
	
	
	@FindBy(xpath = "//button[@id='next']")
	public WebElement next;
	
	
	@FindBy(xpath = "//span[@data-l10n-id='previous_label']")
	public WebElement previous;

	
	
	
	
	
	
	@FindBy(xpath = "//i[@class='ui-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	public WebElement AginghoursSort;
	
	@FindBy(xpath = "//input[@class='form-control']")
	public WebElement GlobalFilt;

	
	@FindBy(xpath = "//div[@class='fw700']")
	public WebElement TotalCount;
	
	
	
	@FindBy(xpath = "//input[@class='form-control']")
	public WebElement GlobalFilter;

	@FindBy(xpath = "//div[@aria-label='This file is already in use by another user.']")
	public WebElement Error;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Submit')]")
	public WebElement submitbutton;
	
	@FindBy(xpath = "//input[@id='pageNumber']")
	public WebElement Noofpages;
	

	
	
	
	@FindBy(xpath = "//a[@routerlink='provider-management/add-provider']")
	public WebElement ProviderManagementMenu;
	
	@FindBy(xpath = "//label[@for='Provider First']/preceding-sibling::input[@formcontrolname='PFirstName']")
	public WebElement AddPFirstName;
	
	@FindBy(xpath = "//label[@for='Provider Middle  Name']/preceding-sibling::input[@formcontrolname='PMiddleName']")
	public WebElement AddPMiddleName;
	
	@FindBy(xpath = "//label[@for='Provider Last  Name']/preceding-sibling::input[@formcontrolname='PLastName']")
	public WebElement AddPLastName;
	
	@FindBy(xpath = "//label[@for='Provider Credentials']/preceding-sibling::input[@formcontrolname='PCredentials']")
	public WebElement AddPCredentials;
	
	@FindBy(xpath = "//div[@class='required-icon']/preceding-sibling::label/preceding-sibling::input[@formcontrolname='ProviderNPI']")
	public WebElement AddPNPI;
	
	@FindBy(xpath = "//label[@for='Provider State']/preceding-sibling::input[@formcontrolname='PState']")
	public WebElement AddPState;
	
	@FindBy(xpath = "//label[@for='Provider Group Name']/parent::label/input[@formcontrolname='PGroupName']")
	public WebElement AddPGroupname;

	@FindBy(xpath = "//button[contains(text(),'Clear')]")
	public WebElement ClearButton;
	
	@FindBy(xpath = "//i[@title='Download Sample Excel for Upload']/parent::button")
	public WebElement Downtemplatefile;

	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	public WebElement Uplodfilebuton;
	
	@FindBy(xpath = "//button[contains(text(),'Search ')]/parent::div/preceding-sibling::div/div/div/label/input[@formcontrolname='ProviderNPI']")
	public WebElement SearchNPIfield;
	
	@FindBy(xpath = "//label[@for='Provider First Name']/preceding-sibling::input[@formcontrolname='PFirstName']")
	public WebElement SearchPFirstname;
	
	@FindBy(xpath = "//label[@for='Provider Middle Name']/preceding-sibling::input[@formcontrolname='PMiddleName']")
	public WebElement SearchPMiddleame;
	
	@FindBy(xpath = "//label[@for='Provider Last Name']/preceding-sibling::input[@formcontrolname='PLastName']")
	public WebElement SearchPLastame;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),' Provider inserted successfully.! ')]")
	public WebElement sucessfulprovidertoaster;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),' Please provide any search option for provider.')]")
	public WebElement unsucessfulsearchprovidertoaster;
	
	@FindBy(xpath = "//input[@type='file']")
	public WebElement ChooseFileButton;

	@FindBy(xpath = "//div[@ref='eValue1']/div/input")
	public WebElement filterinputtext;
	
	@FindBy(xpath = "//button[contains(text(),'Search ')]")
	public WebElement searchbutton;
	
	@FindBy(xpath = "//div[contains(text(),'First Name Should Contain Only Characters')]")
	public WebElement invalid_msgfor_digitsin_PFirstname;
	
	@FindBy(xpath = "//span[contains(text(),'Provider First Name')]/parent::div/preceding-sibling::span/span[@class='ag-icon ag-icon-menu']")
	public WebElement searchfirstnamefilter;
	
	@FindBy(xpath = "//label[contains(.,'AND')]/parent::div/div/input")
	public WebElement filterANDradio;
	
	@FindBy(xpath = "//label[contains(.,'OR')]/parent::div/div/input")
	public WebElement filterORradio;
	
	@FindBy(xpath = " //span[contains(text(),'Provider First Name')]/parent::div")
	public WebElement sortasc_Firstname;
	@FindBy(xpath = "//label[contains(.,'OR')]/parent::div/div/input")
	public WebElement sortdesc_Firstname;
	
	@FindBy(xpath = "//button[@routerlink='/login']")
	public WebElement Logout;
	@FindBy(xpath = "//div[@ref='eHeaderContainer']")
	public WebElement grid;
	
	
	@FindBy(xpath = "//input[@formcontrolname='SplitFrom']")
	public WebElement frompagenotxt;

	@FindBy(xpath = "//input[@formcontrolname='SplitTill']")
	public WebElement Topagenotxt;

	@FindBy(xpath = "//button[contains(text(),'Reorder')]")
	public WebElement ReorderButton;
	
	@FindBy(xpath = "//input[@formcontrolname='ReorderFrom']")
	public WebElement ReorderFrom;
	
	@FindBy(xpath = "//input[@formcontrolname='ReorderTo']")
	public WebElement ReorderTo;

	
	@FindBy(xpath = "//button[1][@class='pull-left ant-btn ng-star-inserted ant-btn-primary']")
	public WebElement ReorderPage;
	
	
	@FindBy(xpath = "//legend[contains(text(),'Member')]")
	public WebElement MemberTab;

	@FindBy(xpath = "//input[@formcontrolname='MemberLastName']")
	public WebElement MemberLastNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberFirstName']")
	public WebElement MemberFirstNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberMiddleName']")
	public WebElement MemberMiddleNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberDOB']")
	public WebElement MemberDOBTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderLastName']")
	public WebElement ProviderLastNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderFirstName']")
	public WebElement ProviderFirstNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderMiddleName']")
	public WebElement ProviderMiddleNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderNPI']")
	public WebElement ProviderNPITxt;

	@FindBy(xpath = "//textarea[@formcontrolname='ProviderAddress']")
	public WebElement ProviderAddressTxt;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary mb5'][contains(text(),'Search Chase')]")
	public WebElement SearchChaseButton;

	@FindBy(xpath = "//button[contains(text(),'Finish')]")
	public WebElement FinishButton;

	@FindBy(xpath = "//input[@formcontrolname='ChaseNotFound']")
	public WebElement ChaseNotFoundCheckBox;

	@FindBy(xpath = "//input[@formcontrolname='DuplicateDocument']")
	public WebElement DuplicateDocumentCheckBox;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement SubmitButton;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	public WebElement CloseButton;

	@FindBy(xpath = "//legend[contains(text(),'Provider')]")
	public WebElement Providertab;

	@FindBy(xpath = "//span[contains(text(),'Chart Retrival')]")
	public WebElement ChartRetrivalMenu;

	@FindBy(xpath = "//a[@href='/ICRARevamp/intake']")
	public WebElement intakeMenu;

	@FindBy(xpath = "//a[contains(text(),'Intake - Document Routing')]")
	public WebElement intakePageHeader;

	@FindBy(xpath = "//div[contains(text(),' Please map the chase OR mark this file as Duplicate Document OR Chase Not Found.')]")
	public WebElement failchasetoaster;

	@FindBy(xpath = "//input[@id='pageNumber']")
	public WebElement maxnumpages;
	@FindBy(xpath = "//iframe[@title='ng2-pdfjs-viewer']")
	public WebElement pdfframe;

	@FindBy(xpath="//div[@role='alertdialog']")
	public WebElement alertToaster;
	
	@FindBy(xpath="//strong[contains(text(),'Project Name:')]")
	public WebElement Projectname;
	@FindBy(xpath="//strong[contains(text(),'File Name:')]")
	public WebElement Filename;
	@FindBy(xpath="//strong[contains(text(),'Retrieval Method:')]")
	public WebElement RetrievaMethod;
	
	@FindBy(xpath="//strong[contains(text(),'Chase Id:')]")
	public WebElement ChaseId;
	
	@FindBy(xpath="//strong[contains(text(),'Chase Status:')]")
	public WebElement ChaseStatus;
	
	@FindBy(xpath="//span[contains(text(),'Original')]/parent::button")
	public WebElement   ViewOriginalButton;
	
		
	
	public ICRA_Intake_PO_Dhanshri(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}
