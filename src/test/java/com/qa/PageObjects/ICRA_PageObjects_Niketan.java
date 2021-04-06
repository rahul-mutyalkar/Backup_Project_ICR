package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRA_PageObjects_Niketan extends DriverCalling{
	
	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Select Client')]")
	public WebElement SelectClientHeading;
	
	@FindBy(xpath = "//button[@class='btn btn-md dropdown-toggle']")
	public WebElement LogOutLink;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientDropdown;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement SubmitButton_ClientDropdown;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement AlertDialog;
	
   /*******************Provider Management Screen ********************************/
	@FindBy(xpath = "//ul[@id='nav-tab']/li[2]/a")
	public WebElement ProviderManagementTab;
	
	@FindBy(id = "nav-add-provider")
	public WebElement AddProviderTab;
	
	
	
	@FindBy(xpath = "//div[contains(@class,'panel-footer')]/div/span/span")
	public WebElement ProviderName_ProviderManagementScreen;
	
	@FindBy(xpath = "//li[@class='breadcrumb-active']//a[contains(text(),'Provider Management')]")
	public WebElement ProviderManagementHeading;
	
	@FindBy(xpath = "//input[contains(@name,'PFirstName')]")
	public WebElement SearchTextBox;
	
	@FindBy(xpath = "//button[@type='Submit']")
	public WebElement SearchButton;
	
	@FindBy(xpath = "//button[@type='reset']")
	public WebElement ClearButton;
	
	@FindBy(xpath = "//li//a[contains(@href,'Provider')]")
	public WebElement Provider_Subtab;	
	
	
	@FindBy(xpath = "//input[@formcontrolname='PFirstName']")
	public WebElement FirstName_Provider;
	
	@FindBy(xpath = "//input[@formcontrolname='PLastName']")
	public WebElement LastName_Provider;
	
	@FindBy(xpath = "//input[@formcontrolname='PTaxIdenNum']")
	public WebElement Tax_Identification_Number_Provider;
	
	@FindBy(xpath = "//input[@formcontrolname='ProviderNPI']")
	public WebElement NPI_Provider;
	
	@FindBy(xpath = "//input[@formcontrolname='PSpeclty']")
	public WebElement Speclty_Provider;
	
	@FindBy(xpath = "//div[@class='col-md-2']//input[@formcontrolname='PGroupName']")
	public WebElement GroupName_Provider;
	
	@FindBy(xpath ="//input[@formcontrolname='PTaxCode']")
	public WebElement TaxCode_Provider;
	
	@FindBy(xpath ="//select[@formcontrolname='PCommMode']")
	public WebElement CommunicationMode_Provider;
	
	
	@FindBy(xpath ="//div[contains(@col-id,'ProviderFirstname')][contains(@class,'ag-cell ag')]")
	public WebElement FirstName_GridTable;
	
	@FindBy(xpath ="//div[contains(@col-id,'ProviderLastName')][contains(@class,'ag-cell ag')]")
	public WebElement LastName_GridTable;
	
	@FindBy(xpath ="//div[contains(@col-id,'ProviderSpecialty')][contains(@class,'ag-cell ag')]")
	public WebElement Specialty_GridTable;
	
	
	@FindBy(xpath = "//legend[contains(text(),'Provider Details')]/parent::fieldset//button[contains(text(),'Save')]")
	public WebElement Save_Provider;

	/****************************** ADDRESS TAB ***********************************/
	
	
	@FindBy(xpath = "//li//a[contains(@href,'Address')]")
	public WebElement Address_Subtab;	
	
	
	@FindBy(xpath ="//input[@formcontrolname='PAdd1']")
	public WebElement Address1_Address;

	@FindBy(xpath ="//input[@formcontrolname='PAdd2']")
	public WebElement Address2_Address;

	@FindBy(xpath ="//input[@formcontrolname='PCity']")
	public WebElement City_Address;

	@FindBy(xpath ="//input[@formcontrolname='PState']")
	public WebElement State_Address;

	@FindBy(xpath ="//input[@formcontrolname='PZip']")
	public WebElement Zip_Address;

	@FindBy(xpath ="//input[@formcontrolname='PFaxNo']")
	public WebElement FaxNo_Address;

	@FindBy(xpath ="//legend[contains(text(),'Address Details')]/parent::fieldset//button[contains(text(),'Save')]")
	public WebElement Save_Address;

	@FindBy(xpath ="//select[@formcontrolname='PAddressType']")
	public WebElement AddressType_Address;
	
	@FindBy(xpath ="//div[@col-id='ProviderAddress1_1'][@role='gridcell']")
	public WebElement Address1_GridTable;
	
	@FindBy(xpath ="//div[@col-id='ProviderAddress2_1'][@role='gridcell']")
	public WebElement Address2_GridTable;
	
	@FindBy(xpath ="//div[@col-id='ProviderCity_1'][@role='gridcell']")
	public WebElement City_1_GridTable;
	
	@FindBy(xpath ="//div[@col-id='ProviderState_1'][@role='gridcell']")
	public WebElement State_1_GridTable;
	
	@FindBy(xpath ="//div[@col-id='ProviderFax_1'][@role='gridcell']")
	public WebElement Fax_1_GridTable;	

	/****************************** CONTACT TAB ***********************************/
	
	
	@FindBy(xpath = "//li//a[contains(@href,'ontact')]")
	public WebElement Contact_Subtab;		
	
	@FindBy(xpath ="//input[@formcontrolname='CFirstName']")
	public WebElement FirstName_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CLastName']")
	public WebElement LastName_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CEmail']")
	public WebElement Email_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CMailingAddress']")
	public WebElement MailingAddress_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CState']")
	public WebElement State_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CCity']")
	public WebElement City_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CZip']")
	public WebElement Zip_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CFaxNo']")
	public WebElement Fax_Contact;

	@FindBy(xpath ="//input[@formcontrolname='CPhone']")
	public WebElement Phone_Contact;

	@FindBy(xpath ="//select[@formcontrolname='PContactType']")
	public WebElement ContactType_Contact;

	@FindBy(xpath ="//legend[contains(text(),'Contact Details')]/parent::fieldset//button[contains(text(),'Save')]")
	public WebElement Save_Contact;

	/****************************** DOCUMENT TAB ***********************************/
	
	
	@FindBy(xpath = "//li//a[contains(@href,'Documents')]")
	public WebElement Document_Subtab;	
	
	@FindBy(xpath ="//input[@formcontrolname='documentTitle']")
	public WebElement DocumentTitle_Document;

	@FindBy(xpath ="//input[@type='file']")
	public WebElement SelectFile_Document;

	@FindBy(xpath ="//div[@class='col-md-3']//button[contains(text(),'Upload Document')]")
	public WebElement UploadDocument_Document;

	@FindBy(xpath ="//select[@formcontrolname='documentType']")
	public WebElement DocumentType_Document;

	@FindBy(xpath ="//select[@formcontrolname='DocumentYear']")
	public WebElement DocumentYear_Document;
	
	
	/****************************** CONTRACT TAB ***********************************/
	
	@FindBy(xpath = "//li[@class='Tab_back']/a[contains(text(),'Contract')]")
	public WebElement Contract_Subtab;	
	
	@FindBy(xpath ="//form[contains(@class,'ng-prist')]//input[@name='PFirstName']")
	public WebElement PFirstName;
	
	@FindBy(xpath ="//form[contains(@class,'ng-prist')]//button[contains(text(),'Search')]")
	public WebElement Search;
	
	@FindBy(xpath ="//form[contains(@class,'ng-prist')]//button[contains(@type,'reset')]")
	public WebElement Clear;
	
	@FindBy(xpath ="//div[contains(@class,'panel-body Table_Panel')]//span[contains(text(),'Add')]/i")
	public WebElement AddProviderIcon;
		
	final String s="//h6[contains(text(),'Contract')]//parent::div//following-sibling::div[1]";
		
	@FindBy(xpath =""+s+""+ "//select[contains(@formcontrolname,'Client')]")
	public WebElement ClientName;
	
	@FindBy(xpath =""+s+""+"//select[contains(@formcontrolname,'ContractType')]")
	public WebElement ContractrateType;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ProviderGroupName')]")
    public WebElement ProviderGroupName;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ContractID')]")
    public WebElement ContractID;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'Description')]")
	public WebElement Decreiption;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ContractStartDate')]")
	public WebElement StartDate;
	
	@FindBy(xpath ="//span[contains(@class,'owl-dt-calendar-cell-content owl-dt-calendar-cell-today')]")
	public WebElement TodayDate;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ContractEndDate')]")
	public WebElement EndDate;
	
	@FindBy(xpath =""+s+""+"//select[contains(@formcontrolname,'LineofBusiness')]")
	public WebElement LineofBusiness;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ContractrateType')][1]")
	public WebElement StandardRadioButton;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ContractrateType')][2]")
	public WebElement TierRadioButton;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'StandardRate')]")
	public WebElement Amount;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'FromChaseCount')]")
	public WebElement From;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'ToChaseCount')]")
	public WebElement To;
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'Rate')]")
	public WebElement Rate;
		
	@FindBy(xpath =""+s+""+"//div[contains(@id,'addItem')]")
	public WebElement AddSymbol;	
	
	@FindBy(xpath =""+s+""+"//select[contains(@formcontrolname,'RetrievalMethod')]")
	public WebElement RetrievalMethod;	
	
	@FindBy(xpath =""+s+""+"//input[contains(@formcontrolname,'Qty')]")
	public WebElement MinimumQty;
	
	@FindBy(xpath =""+s+""+"//button[contains(text(),'Save')]")
	public WebElement Save;
		
	@FindBy(xpath ="//div[contains(@class,'modal-footer')]//i/parent::button")
	public WebElement Close;
	
	
	final String q="//legend[contains(text(),'Provider Contract Details')]//parent::div[1]//following-sibling::div";
	
	@FindBy(xpath =""+q+""+ "//select[contains(@formcontrolname,'Client')]")
	public WebElement ClientName1;
	
	@FindBy(xpath =""+q+""+"//select[contains(@formcontrolname,'ContractType')]")
	public WebElement ContractrateType1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ProviderGroupName')]")
    public WebElement ProviderGroupName1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ContractID')]")
    public WebElement ContractID1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'Description')]")
	public WebElement Decreiption1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ContractStartDate')]")
	public WebElement StartDate1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ContractEndDate')]")
	public WebElement EndDate1;
	
	@FindBy(xpath =""+q+""+"//select[contains(@formcontrolname,'LineofBusiness')]")
	public WebElement LineofBusiness1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ContractrateType')][1]")
	public WebElement StandardRadioButton1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ContractrateType')][2]")
	public WebElement TierRadioButton1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'StandardRate')]")
	public WebElement Amount1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'FromChaseCount')]")
	public WebElement From1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'ToChaseCount')]")
	public WebElement To1;
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'Rate')]")
	public WebElement Rate1;
		
	@FindBy(xpath =""+q+""+"//div[contains(@id,'addItem')]")
	public WebElement AddSymbol1;	
	
	@FindBy(xpath =""+q+""+"//select[contains(@formcontrolname,'RetrievalMethod')]")
	public WebElement RetrievalMethod1;	
	
	@FindBy(xpath =""+q+""+"//input[contains(@formcontrolname,'Qty')]")
	public WebElement MinimumQty1;
	
	@FindBy(xpath =""+q+""+"//button[contains(text(),'Save')]")
	public WebElement Save1;
		
	/****************************** PAYEMNT TAB ***********************************/
	
	
	@FindBy(xpath = "//li//a[contains(text(),'Payment')]")
	public WebElement Payment_Subtab;	
	
	@FindBy(xpath ="//input[@formcontrolname='PGroupName']")
	public WebElement GroupName_Payment;

	@FindBy(xpath ="//input[@formcontrolname='PayeeName']")
	public WebElement PayeeName_Payment;

	@FindBy(xpath ="//input[@formcontrolname='BankName']")
	public WebElement BankName_Payment;

	@FindBy(xpath ="//input[@formcontrolname='PaymentTypeVal']")
	public WebElement PaymentTypeVal_Payment;

	@FindBy(xpath ="//input[@formcontrolname='BankAcNO']")
	public WebElement BankAcNO_Payment;

	@FindBy(xpath ="//input[@formcontrolname='RoutingNo']")
	public WebElement RoutingNo_Payment;

	@FindBy(xpath ="//input[contains(@id,'paymentMethod1')]")
	public WebElement ChequeRadio_Payment;

	@FindBy(xpath ="//input[contains(@id,'paymentMethod2')]")
	public WebElement EFTRadio_Payment;

	@FindBy(xpath ="//select[@formcontrolname='PaymentType']")
	public WebElement PaymentType_Payment;

	@FindBy(xpath ="//input[@formcontrolname='HolderName']")
	public WebElement HolderName_Payment;

	@FindBy(xpath ="//input[@formcontrolname='Amt']")
	public WebElement Amt_Payment;
	
	@FindBy(xpath ="//div[@class='col-md-3']//input[@formcontrolname='RoutingNo']//parent::label//parent::div" 
		       + "//parent::div//parent::div//following::div[1]//button[1][contains(text(),'Save')]")
   public WebElement Save_Payment;
	
		
	@FindBy(xpath ="//div[@class='toast-message ng-star-inserted']")
	public WebElement SaveMsg;
	
	/****************************** ADDRESS ALLOCATION SCREEN ***********************************/
	
	@FindBy(xpath ="//input[@name='AllocatedAddressSUM']")
	public WebElement AllocateCountBox;
	
	@FindBy(xpath ="//button[contains(text(),'Allocate')]")
	public WebElement AllocateButton;
	
	@FindBy(xpath ="//select[@id='ddlAgentList']")
	public WebElement AgentList;
	
	@FindBy(xpath ="//select[@id='ddlAgentList0']")
	public WebElement AgentList_ReassignWindow;
	
	@FindBy(xpath ="//button//span[contains(text(),'Remove')]")
	public WebElement Remove;
	
	@FindBy(xpath ="//span[contains(text(),'Reassign')]")
	public WebElement Reassign;
	
	@FindBy(xpath ="//nz-table[@class='allcp-form ant-table-wrapper']/following-sibling::button[2]")
	public WebElement Submit_RemoveAddress;
	
	@FindBy(xpath ="//input[@name='AllocateByArea']")
	public WebElement AllocateAreaCodeRadio;
	
	@FindBy(xpath ="//input[@name='AllocateByZip']")
	public WebElement AllocateZipCodeRadio;
	
	@FindBy(xpath ="//input[@name='ViewByArea']")
	public WebElement ViewByAreaRadioButton;
	
	@FindBy(xpath ="//input[@name='ViewByZip']")
	public WebElement ViewByZipRadioButton;
	
	@FindBy(xpath ="//a[@data-toggle='dropdown']")
	public WebElement Heading_WelCm_User;
	
	@FindBy(xpath ="//a[contains(text(),'Logout')]")
	public WebElement LogoutLink;
	
	@FindBy(xpath ="//input[@id='chkFilterSH']")
	public WebElement FilterSpecHandChk;
	
	@FindBy(xpath ="//select[@id='ddlFilterSH']")
	public WebElement SpecHandDropDown;
	
	@FindBy(xpath ="//select[@id='ddlProviderState']")
	public WebElement State;
	
	@FindBy(xpath ="//select[@id='ddlProjectType']")
	public WebElement ProjectType;
	
	@FindBy(xpath ="//input[@name='AllocatedCode']")
	public WebElement Codetextbox;
	

	@FindBy(xpath ="//div[@role='alertdialog']")
	public WebElement AlertMsg;
	
/****************************** RECORD QA SCREEN ***********************************/
	
	@FindBy(xpath ="//div[contains(text(),'Hold Queue')]")
	public WebElement HoldQueueBucket;
	
	@FindBy(xpath ="//input[contains(@placeholder,'Global Filter')]")
	public WebElement GlobalFilter;
	
	@FindBy(xpath ="//input[@id='btnMoveSelected']")
	public WebElement Move;
	
	@FindBy(xpath ="//input[@id='btnCopySelected']")
	public WebElement Copy;
	
	@FindBy(xpath ="//div[@class='toolbar']//input[@id='pageNumber']")
	public WebElement MaxPageNo_Pdf;
	
	@FindBy(xpath ="//input[@id='IsNoHCC']")
	public WebElement ChkBoxNoHCC;
	
	@FindBy(xpath ="//label[@id='lblchkIsNOHCC']")
	public WebElement NOHCCtext;
	
	@FindBy(xpath ="//input[@id='chkIsReject']")
	public WebElement ChkBoxReject;
	
	@FindBy(xpath ="//label[@id='lblchkIsReject']")
	public WebElement Rejecttext;
	
	
	
	@FindBy(xpath ="//input[@value='Move Page']")
	public WebElement MovePage;
	
	@FindBy(xpath ="//input[@value='Delete Page']")
	public WebElement DeletePage;
	
	@FindBy(xpath ="//input[@value='Follow up']")
	public WebElement FollowUp;
	
	@FindBy(xpath ="//input[@value='Cancel Chase']")
	public WebElement CancelChase;
	
	@FindBy(xpath ="//input[@value='Submit']")
	public WebElement Submit;
	
	@FindBy(xpath ="//input[@value='Close']")
	public WebElement Close_RecordQA;
	
	@FindBy(xpath ="//input[@value='Hold']")
	public WebElement Hold;	
	
	@FindBy(id ="lbtnMCMove")
	public WebElement Move_MoveWindow;
	
	@FindBy(id ="btnMCClose")
	public WebElement Close_MoveWindow;
	
	@FindBy(xpath ="//input[@formcontrolname='FromPage']")
	public WebElement FromPage;
	
	@FindBy(xpath ="//input[@formcontrolname='ToPage']")
	public WebElement ToPage;
	
	@FindBy(xpath ="//input[@formcontrolname='MemberLastName']")
	public WebElement MemberLastName;
	
	@FindBy(xpath ="//input[@formcontrolname='ProviderLastName']")
	public WebElement ProviderLastName;
	
	@FindBy(id ="lbtnMCSearch")
	public WebElement Search_MoveWindow;
	
	                    /*== MOVE PAGE SCREEN ==*/
	
	@FindBy(xpath ="//input[@formcontrolname='MoveFrom']")
	public WebElement FromPage_MovePageWin;
	
	@FindBy(xpath ="//input[@formcontrolname='MoveTo']")
	public WebElement ToPage_MovePageWin;
	
	                   /*== DELETE PAGE SCREEN ==*/
	
	@FindBy(xpath ="//input[@formcontrolname='DeletePages']")
	public WebElement DeletePages_DeletepgeWin;
	
	                    /*== HOLD PAGE SCREEN ==*/
	
	@FindBy(xpath ="//select[@id='ReasonType']")
	public WebElement Reason_HoldWin;
	
	@FindBy(xpath ="//input[@formcontrolname='CommentField']")
	public WebElement Comm_HoldWin;
	
	@FindBy(xpath ="//span[contains(text(),'Hold')]")
	public WebElement Hold_HoldWin;
	
	@FindBy(xpath ="//span[contains(text(),'Close')]")
	public WebElement Close_HoldWin;
	
                        /*== CANCEL CHASE PAGE SCREEN ==*/
	
	@FindBy(xpath ="//select[@id='drpReason']")
	public WebElement Reason_CancelChaseWin;
	
	@FindBy(xpath ="//textarea[@id='Comments']")
	public WebElement Comm_CancelChaseWin;
	
	                   /*== PDF SCREEN ==*/
	
	@FindBy(xpath ="//button[@id='secondaryToolbarToggle']")
	public WebElement Tools;
	
	@FindBy(xpath ="//span[@data-l10n-id='page_rotate_cw_label']")
	public WebElement RotateClockwise;
	
	@FindBy(xpath ="//span[@data-l10n-id='page_rotate_ccw_label']")
	public WebElement RotateCounterClockwise;
	
	@FindBy(xpath ="//span[@data-l10n-id='last_page_label']")
	public WebElement GoToLastPage;
	
	@FindBy(xpath ="//span[@data-l10n-id='first_page_label']")
	public WebElement GoToFirstPage;
	
	@FindBy(xpath ="//button[@id='presentationMode']")
	public WebElement Presentation_mode_label;	
	
	@FindBy(xpath ="//span[@data-l10n-id='scroll_horizontal_label']")
	public WebElement Horizontal_Scroll_label;
	
	@FindBy(xpath ="//span[@data-l10n-id='scroll_vertical_label']")
	public WebElement Vertical_Scroll_label;	
	
	@FindBy(xpath ="//span[@data-l10n-id='document_properties_label']")
	public WebElement Document_properties_label;
	
	@FindBy(xpath ="//span[@data-l10n-id='spread_odd_label']")
	public WebElement Spread_odd_label;
	
	@FindBy(xpath ="//span[@data-l10n-id='spread_even_label']")
	public WebElement Spread_even_label;
	
	@FindBy(xpath ="//span[@data-l10n-id='spread_none_label']")
	public WebElement Spread_None_label;
	
	
	
	@FindBy(xpath ="//div[@class='pdfViewer']//div[@data-page-number='1']")
	public WebElement FirstPgePDFView;
	
	
	/****************************** REPORT SCREEN ***********************************/
	
	@FindBy(xpath ="//input[@id='btnSubmit']")
	public WebElement Submit_Production_Report;
	
	@FindBy(id ="tblProduction")
	public WebElement Production_tblReport;
	
	@FindBy(id ="ddlProductionStartTime")
	public WebElement ProductionStartTime;
	
	                          /*== CODER PRODUCTION REPORT ==*/
	
	
	@FindBy(id ="ddlProjects")
	public WebElement ProjectName;
	
	@FindBy(id ="ddlRole")
	public WebElement Role;
	
	@FindBy(xpath ="//span[contains(@class,'multiselect-selected-text')]")
	public WebElement NoneSelected;
	
	@FindBy(xpath ="//li[contains(@class,'multiselect-item multiselect-all')]")
	public WebElement SelectAllChkbok;
	
	@FindBy(id ="ddlDateRange")
	public WebElement DateRange;
	
	@FindBy(id ="divCodingProductionSummary")
	public WebElement CoderProductionGridTbl;	
	
	@FindBy(xpath ="//table[contains(@class,'data-grid tableSummary')]")
	public WebElement Summary;
	
	@FindBy(id ="ddlTimeZone")
	public WebElement TimeZone;	
	
	@FindBy(id ="tbodyOftblhold")
	public WebElement HoldTblData;
	
	@FindBy(id ="tbodyOfNOHCCReportSummary")
	public WebElement NOHCCTblData;
	
	
	@FindBy(id ="tbodyOftblreject")
	public WebElement RejectTblData;
	
	
	@FindBy(id ="tbodyOftblBatchStatus")
	public WebElement CoderReviewStatusGrid;	
	
	@FindBy(id ="btnSearch")
	public WebElement Search_CoderReviewStatus;
	
	
	@FindBy(id ="ddlProjectName")
	public WebElement Project_CoderReviewStatus;
	
	/*                 =================== CoderReview dashboard============================================*/	
	
	@FindBy(xpath ="//div[contains(@aria-label,'Coding Completion Status')]")
	public WebElement CodingCompletionStatus;
	
	
	@FindBy(xpath ="//div[contains(@aria-label,'Chases Received')]")
	public WebElement Chases_Received;

	
	@FindBy(xpath ="//div[contains(@aria-label,'Average HCC')]")
	public WebElement AverageHCC;
	
	
	
	@FindBy(xpath ="//div[contains(@aria-label,'Average Page Count')]")
	public WebElement AveragePageCount;
		
	
	@FindBy(xpath ="//div[contains(@aria-label,'Average DOS')]")
	public WebElement AverageDOS;
	
	
	@FindBy(xpath="//div[contains(@title,'Coding Review')]/parent::div")
	public WebElement CoderReviewStatus;	
		
	
	@FindBy(xpath="//div[contains(@title,'Cumulative Coding')]/parent::div")
	public WebElement CumulativeCoding;
	
	
	@FindBy(xpath="//div[contains(@title,'Production Weekly')]/parent::div")
	public WebElement ProductionWeekly;
	
	@FindBy(xpath="//div[contains(@title,'Production Monthly')]/parent::div")
	public WebElement ProductionMonthly;
	
		
	
	@FindBy(xpath="//div[contains(@title,'Submit vs No HCC vs Reject')]/parent::div")
	public WebElement Submit_NoHCC_Reject;
	
	
	@FindBy(xpath="//div[contains(@aria-label,'ProjectName')]")
	public WebElement ProjectDropdown;
	
	
	@FindBy(xpath="//div[contains(@aria-label,'Custom')]")
	public WebElement ReportingPeriod;
	
	//i[contains(@class,'dragGrip')]//parent::div/parent::visual-container-header-modern/following-sibling::div[1]//div[@class='imageBackground']
	
	@FindBy(xpath="//div[@tab-order='9000']")
	public WebElement ReportingBy_Weekly;
	
	@FindBy(xpath="//div[@tab-order='10000']")
	public WebElement ReportingBy_Monthly;
	

	@FindBy(xpath="//button[contains(@aria-label,'Filters Show')]")
	public WebElement ShowFilterPane;
	
	@FindBy(xpath="//div[contains(@id,'outspace-pane-title')]")
	public WebElement Filters;
	
	
	@FindBy(xpath="//div[contains(@class,'filterBtnIcon')]")
	public WebElement Filtersicon;
	
	@FindBy(xpath="//div[@class='mat-form-field-flex']")
	public WebElement Search_Filter;
	
	
	@FindBy(xpath="//button[contains(@aria-label,'Next pages')]/i")
	public WebElement NextPageIcon;
	
	
	@FindBy(xpath="//div[contains(@title,'Cumulative weekly Output')]")
	public WebElement CumulativeweeklyOutput;
	

	@FindBy(xpath="//div[contains(@title,'Average DOS Weekly')]")
	public WebElement AverageDOSWeekly;
	
	@FindBy(xpath="//div[contains(@title,'Weekly Page Count')]")
	public WebElement WeeklyPageCount;
	
	
	@FindBy(xpath="//div[contains(@title,'Monthly Page Count')]")
	public WebElement MonthlyPageCount;
	
	
	@FindBy(xpath="//div[contains(@title,'Cumulative Weekly Completed')]")
	public WebElement CumulativeWeeklyCompleted;
	
	
	@FindBy(xpath="//div[contains(@title,'Average DOS Monthly')]")
	public WebElement AverageDOSMonthly;
	
	
	@FindBy(xpath="//div[contains(@title,'Cumulative Monthly Completed')]")
	public WebElement CumulativeMonthlyDrill;
	
	
	@FindBy(xpath="//div[contains(@title,'Cumulative Monthly Out')]")
	public WebElement CumulativeMonthlyOut;
	
	
	@FindBy(xpath="//div[contains(@title,'Monthly Dashboard')]")
	public WebElement MonthlyDashboard;
	
	
	@FindBy(xpath="//div[@class='title']")
	public WebElement ProjectTitle_Header;
	
	
	
	@FindBy(xpath="//span[contains(text(),'Monthly')]")
	public WebElement ReportbyTitle1_Header;
	
	@FindBy(xpath="//span[contains(text(),'Weekly')]")
	public WebElement ReportbyTitle2_Header;
	
	
	@FindBy(xpath="//div[@class='button-outline']")
	public WebElement Backarrow;
	
	
	@FindBy(xpath="//button[contains(@aria-label,'Focus mode')]")
	public WebElement FocusMode;
	
	@FindBy(xpath="//button[contains(@aria-label,'More options')]")
	public WebElement MoreOptions;
	
	@FindBy(xpath="//button[contains(@class,'vcFilterRestatementBtn')]")
	public WebElement FilterIcon;
	
	@FindBy(xpath="//div[@class='preTextWithEllipsis']")
	public WebElement Heading;
	
	@FindBy(xpath="//div[@class='popOutBar']//i")
	public WebElement BackReporticon;
	
	
	@FindBy(xpath="//div[contains(@title,'Export data')]")
	public WebElement ExportData_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Show')]")
	public WebElement Showtbl_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Spotlight')]")
	public WebElement Spotlight_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Sort de')]")
	public WebElement Sortdec_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Sort as')]")
	public WebElement Sortaec_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Sort by')]")
	public WebElement Sortby_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Reporting Date')]")
	public WebElement ReportingDate_Menu;
	
	@FindBy(xpath="//div[contains(@title,'ChaseID')]")
	public WebElement ChaseID_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Page Count')]")
	public WebElement PageCount_Menu;
		
	@FindBy(xpath="//div[contains(@title,'Completed Date')]")
	public WebElement CompletedDate_Menu;
	
	@FindBy(xpath="//div[contains(@title,'DOS')]")
	public WebElement DOS_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Project')]")
	public WebElement Project_Menu;
	
	@FindBy(xpath="//drop-down-list//div[contains(@title,'Member')]")
	public WebElement MemberName_Menu;
	
	@FindBy(xpath="//drop-down-list//div[contains(@title,'Provider Name')]")
	public WebElement ProviderName_Menu;
	
	@FindBy(xpath="//drop-down-list//div[contains(@title,'ProviderNPI')]")
	public WebElement ProviderNPI_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Is No HCC')]")
	public WebElement IsNoHCC_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Is Reject')]")
	public WebElement IsReject_Menu;
	
	@FindBy(xpath="//div[contains(@title,'Output Generated')]")
	public WebElement OutputGenerated_Menu;
	
		

	public ICRA_PageObjects_Niketan(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}
