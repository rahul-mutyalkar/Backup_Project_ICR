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

public class ICRA_PageObjects_Archana extends DriverCalling{
	
	
	@FindBy(xpath = "//input[@ng-reflect-name='UserName']")
	public WebElement UsernamePre;

	@FindBy(xpath = "//input[@ng-reflect-name='Password']")
	public WebElement PasswordPre;
	
	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientSel;

	@FindBy(xpath = "//span[@class='input-group-btn']//button[@type='button']")
	public WebElement ClientSubmit;
	
	@FindBy(xpath = "//button[@id='Submit']")
	public WebElement AddRollProjectSubmit;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement Alert;

	@FindBy(xpath = "//select[@formcontrolname='RetrievalMethod']")
	public WebElement Retrieval;
	
	@FindBy(xpath = "//div[contains(text(),'Retrieval')]")
	public WebElement RetrievalValidation;
	
	@FindBy(xpath = "//input[@id='ExpectedDate']")
	public WebElement RetrievalExpected;
	
	@FindBy(xpath = "//span[contains(@class,'owl-dt-calendar-cell-today')]")
	public WebElement TodayDate;
	
	@FindBy(xpath = "//div[contains(text(),'Expected')]")
	public WebElement ExpectedValidation;
	
	
	@FindBy(xpath = "//button[@id='btnSubmit']//i[@class='lar la-save fs18']")
	public WebElement RetSave;
	
	@FindBy(xpath = "//select[@formcontrolname='CallDesposition']")
	public WebElement CallDiposSel;
	
	@FindBy(xpath = "//div[contains(text(),'Call Disposition')]")
	public WebElement CallDiposValidation;
	
	@FindBy(xpath = "//div[contains(text(),'Call Notes')]")
	public WebElement CallNotesValidation;
	
	@FindBy(xpath = "//div[contains(text(),'Please Select Follow Up')]")
	public WebElement TimeZoneValidation;
	
	@FindBy(xpath = "//input[@formcontrolname='FollowUpDate']")
	public WebElement CallFollowupdate;	

	@FindBy(xpath = "//select[@formcontrolname='FollowUpTimeZone']")
	public WebElement CallTimezone;
	
	@FindBy(xpath = "//div[@class='col-md-7']//textarea[@formcontrolname='CallNotes']")
	public WebElement CallNote;
	
	@FindBy(xpath = "//textarea[@id='officeHours']")
	public WebElement office;
	
//	@FindBy(xpath = "//div[@comp-id='201']//div[@col-id='CallDispositionDescription_1']")
//	public WebElement verifycall;

	
	@FindBy(xpath = "//div[@id='tab15_1']//button[@id='btnSubmit']")
	public WebElement CallDipoSave;
	
	@FindBy(xpath = "//a[@href='#tab15_3']")
	public WebElement SpecialHanTab;
	 
	
	@FindBy(xpath = "//div[@id='tab15_3']//select[@formcontrolname='CallDesposition']")
	public WebElement SpecialHan;
	
	@FindBy(xpath = "//div[contains(text(),'Special handling.')]")
	public WebElement SpecialHanValid;
	
	@FindBy(xpath = "//div[contains(text(),'Specail Handling Notes.')]")
	public WebElement SpecialHanNotesValid;
	
	@FindBy(xpath = "//div[@id='tab15_3']//textarea[@id='comment']")
	public WebElement SpecialHanNotes;
	

	@FindBy(xpath = "//div[@id='tab15_3']//button[@id='btnSubmit']")
	public WebElement SpecialSave;
	
	
//	@FindBy(xpath = "//div[@comp-id='264']//div[@col-id='SpecialHandingCodeDescription_1']")
//	public WebElement verifySpecial;	
		
	@FindBy(xpath = "//a[@href='#tab15_2']")
	public WebElement TechnicalNoteTab;
	
	
	@FindBy(xpath = "//div[contains(text(),' Please Enter Tech Notes.')]")
	public WebElement TechValidaion;
	
	@FindBy(xpath = "//div[@id='tab15_2']//textarea[@id='comment']")
	public WebElement TechNote;
	

	@FindBy(xpath = "//div[@id='tab15_2']//button[@id='btnSubmit']")
	public WebElement TechNoteSave;
	
	@FindBy(xpath = "//div[@id='tab15_2']//button[@id='btnSubmit']")
	public WebElement TechNoteSaveMessage;
	
//	@FindBy(xpath = "//div[@comp-id='227']//div[@col-id='Notes_1']")
//	public WebElement verifyNotes;	
	
	@FindBy(xpath = "//a[@href='#tab15_4']")
	public WebElement RequestNoteTab;
	
	@FindBy(xpath = "//div[contains(text(),'Please Enter Request')]")
	public WebElement RequestNoteVal;
	
	@FindBy(xpath = "//div[@id='tab15_4']//textarea[@id='comment']")
	public WebElement RequestNote;
	
	
	@FindBy(xpath = "//div[@id='tab15_4']//button[@id='btnSubmit']")
	public WebElement RequestSave;
	
//	@FindBy(xpath = "//div[@comp-id='289']//div[@col-id='Notes_1']")
//	public WebElement verifyRequest;	
		
	
	@FindBy(xpath = "//header[@class='ph5']//a[@href='#tab6_2']")
	public WebElement ChaseLink;
		
	@FindBy(xpath = "//tr[1]//td[1]//p-tablecheckbox//div[contains(@class,'ui-chkbox-box')]")
	public WebElement Checkbox1;
	
	@FindBy(xpath = "//tr[2]//td[1]//p-tablecheckbox//div[contains(@class,'ui-chkbox-box')]")
	public WebElement Checkbox2;
	
	@FindBy(xpath = "//tr[3]//td[1]//p-tablecheckbox//div[contains(@class,'ui-chkbox-box')]")
	public WebElement Checkbox3;
	
	@FindBy(xpath = "//tr[1]//td[11]")
	public WebElement ChaseStatus1;
	
	@FindBy(xpath = "//tr[2]//td[11]")
	public WebElement ChaseStatus2;
	
	@FindBy(xpath = "//tr[3]//td[11]")
	public WebElement ChaseStatus3;
	
	@FindBy(xpath = "//button[contains(text(),'Exception')]")
	public WebElement ExceptionMain;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement ExceptionValidation;
	
	@FindBy(xpath = "//span[contains(text(),'Past Due Provider')]")
	public WebElement ExceptionChaseValue;
	
	@FindBy(xpath = "//textarea[@formcontrolname='ExeptionDescription']")
	public WebElement ExceptionDesc;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement ExceptionSubmit ;
	
	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']")
	public WebElement ExceptionVal;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter comments')]")
	public WebElement ExceptionDesVal;
	
	@FindBy(xpath = "//div[contains(text(),'Sent Exception')]")
	public WebElement ExceptionSucess;
	
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	public WebElement SendRequest;
	
	
	@FindBy(xpath = "//button[contains(text(),'Resend Request')]")
	public WebElement ResendRequest;
	
	@FindBy(xpath = "//button[contains(text(),' Resend Portal Link ')]")
	public WebElement ResendPortal;
	
	@FindBy(xpath = "//input[@value='5']")
	public WebElement EmailSel;
	
	@FindBy(xpath = "//input[@value='3']")
	public WebElement MailSel;
	
	@FindBy(xpath = "//input[@value='6']")
	public WebElement RequestMailSel;	
	
	@FindBy(xpath = "//input[@value='4']")
	public WebElement IndividualSel;
	
	@FindBy(xpath = "//div[@class='col-md-1']//button[@id='btnSubmit']")
	public WebElement SendSubmit;
	
	@FindBy(xpath = "//div//app-send-request//button[@class='close']")
	public WebElement SendClose;
	
//	@FindBy(xpath = "//div[contains(text(),'Please select the fax number to send the request')]")
//	public WebElement FaxValidation;
//	
//	@FindBy(xpath = "//div[contains(text(),' Please select the email address to send the request ')]")
//	public WebElement EmailValidation;
	
//	@FindBy(xpath = "//div[contains(text(),'Request is resent')]")
//	public WebElement SendSuccessValidation;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement SendValidation;
	
	
	
	///Move - copy xpath
	
	@FindBy(xpath = "//button[contains(text(),'Move')]")
	public WebElement Move;
	
	@FindBy(xpath = "//div[contains(text(),'Please select Chase Move')]")
	public WebElement MoveVal;
	
	@FindBy(xpath = "//input[@placeholder='Enter Adress 1']")
	public WebElement Move_Copy_address1;
	
	@FindBy(xpath = "//app-move-copy-chases//div//button[@class='btn btn-sm btn-primary mb5 ml40']")
	public WebElement Move_Copy_Search;
	
	@FindBy(xpath = "//span//input[@name='radio']")
	public WebElement Move_Copy_radio;
	
	@FindBy(xpath = "//app-move-copy-chases//div//button[contains(text(),'Move')]")
	public WebElement Move_Submit;
	
	@FindBy(xpath = "//app-move-copy-chases//div//button[contains(text(),'Copy')]")
	public WebElement Copy_Submit;
	
	@FindBy(xpath = "//button[contains(text(),'Copy')]")
	public WebElement Copy;
	
	@FindBy(xpath = "//div[contains(text(),'Please select Chase Copy')]")
	public WebElement CopyVal;
	
	@FindBy(xpath = "//tr[1]//td[1]")
	public WebElement AddIDRollup1;
	
	@FindBy(xpath = "//tr[2]//td[1]")
	public WebElement AddIDRollup2;
	
	@FindBy(xpath = "//tr[1]//td[3]")
	public WebElement Totalchase1;
	
	@FindBy(xpath = "//tr[2]//td[3]")
	public WebElement Totalchase2;
	
	@FindBy(xpath = "//tr[1]//td[9]")
	public WebElement Address1;
	
	@FindBy(xpath = "//tr[2]//td[9]")
	public WebElement Address2;
	
	@FindBy(xpath = "//button[@title='Address List']")
	public WebElement AddressList;
	
//	@FindBy(xpath = "//div[contains(text(),'Please select atleast one value for search address')]")
//	public WebElement SearchVal;
	
	@FindBy(xpath = "//input[@placeholder='Enter City']")
	public WebElement City;
	
	@FindBy(xpath = "//ngb-modal-window//div[@aria-colindex='4']")
	public WebElement CityVerify;
	
	@FindBy(xpath = "//ngb-modal-window//div[@aria-colindex='2']")
	public WebElement addVerify;
	
	@FindBy(xpath = "//ul//li//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement Cityautopopulate;
	
	@FindBy(xpath = "//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement addressautopopulate;
	

	@FindBy(xpath = "//app-move-copy-chases//input[@placeholder='Enter Provider NPI']")
	public WebElement NPI;
	
	@FindBy(xpath = "//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement NPIAutopopulate;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter Zip Code']")
	public WebElement Zipcode;
	
	@FindBy(xpath = "//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement ZipcodeAutopopolate;
	
	@FindBy(xpath = "//ngb-modal-window//div[@aria-colindex='6']")
	public WebElement ZipVerify;
	
	@FindBy(xpath = "//input[@placeholder='Global Filter']")
	public WebElement GlobalSearch;
	
	@FindBy(xpath = "//span[contains(text(),'Reset')]")
	public WebElement GlobalReset;
	
	@FindBy(xpath = "//app-move-copy-chases//div//button[contains(text(),'Cancel')]")
	public WebElement Move_Copy_Cancel;	

    @FindBy(xpath = "//strong[contains(text(),'Total Chase Count')]//parent::label")
	public WebElement TotchaseCount;
	
	//Tab Xpath
	
	@FindBy(xpath = "//a[@href='#tab6_1']")
	public WebElement CallDetailsTab;
	
	
	@FindBy(xpath = "//a[@href='#tab6_2']")
	public WebElement ChaseDetailsTab;
	
	@FindBy(xpath = "//a[@href='#tab6_3']")
	public WebElement ProviderDetailsTab;
	
	//Contact details Xpath
	
	@FindBy(xpath = "//div[@class='col-md-6 pl40 pr5']//button[contains(text(),'Add')]")
	public WebElement ContactAddbtn;
	
	@FindBy(xpath = "//input[@id='txtContactFirstName']")
	public WebElement FirstName;
	
	@FindBy(xpath = "//input[@id='txtContactMiddleName']")
	public WebElement MiddleName;
	
	@FindBy(xpath = "//input[@id='txtContactLastName']")
	public WebElement LastName;
	
	@FindBy(xpath = "//input[@id='txtContactPhone']")
	public WebElement Phone;
	
	@FindBy(xpath = "//input[@id='txtContactFaxNo']")
	public WebElement ContactFax;
	
	@FindBy(xpath = "//input[@id='txtContactEmail']")
	public WebElement ContactEmail;	
	
	
	@FindBy(xpath = "//input[@id='Contacttype1']")
	public WebElement PrimaryAddRadio;
	
	@FindBy(xpath = "//input[@id='Contacttype2']")
	public WebElement SecondaryAddRadio;
	
	@FindBy(xpath = "//div[@class='col-md-2']//button[contains(text(),'Save')]")
	public WebElement ContactSave;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter First Name')]")
	public WebElement FirstNameVal;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter Last')]")
	public WebElement LastNameVal;
	
	@FindBy(xpath = "//div[contains(text(),'Contact Saved')]")
	public WebElement ContactsuccessMess;
	
	@FindBy(xpath = "//app-addedit-contact-information//button[@class='close']")
	public WebElement AddcontactCancel;
	
	
//	@FindBy(xpath = "//div[contains(text(),' Please select at least one contact type ')]")
//	public WebElement EditVal;
	
	@FindBy(xpath = "//div[@class='col-md-6 pl40 pr5']//button[contains(text(),'Edit')]")
	public WebElement EditContactBtn;
	
	@FindBy(xpath = "//select[@placeholder='Enter Contact Type']")
	public WebElement EditSelectContact;
	
	@FindBy(xpath = "//a[@href='#tab122_1']")
	public WebElement PrimaryTab;
	
	@FindBy(xpath = "//a[@href='#tab122_2']")
	public WebElement SecondaryTab;
	
	@FindBy(xpath = "//div[@class='col-md-6 pl40 pr5']//button[contains(text(),' View')]")
	public WebElement ViewContactBtn;
	
	@FindBy(xpath = "//input[@name='contactType']")
	public WebElement PrimaryViewRadio;
	
	@FindBy(xpath = "//div[contains(text(),'You can not select')]")
	public WebElement PrimaryRadioVal;
	
	@FindBy(xpath = "//input[@id='selectedPrimaryRadio1']")
	public WebElement PrimaryViewRadio_2row;
	
	@FindBy(xpath = "//app-addedit-contact-information//button[contains(text(),'Save')]")
	public WebElement ViewContactSave;
	
	@FindBy(xpath = "//app-button-renderer//button[contains(@class,'btn btn-sm')]")
	public WebElement ViewDeleteBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-blue btn-jconfirm']")
	public WebElement ViewDeleteConfirm;
	
	
	
	//Address information
	@FindBy(xpath = "//input[@formcontrolname='PAdd1']")
	public WebElement Add1;
	
	@FindBy(xpath = "//input[@formcontrolname='PAdd2']")
	public WebElement Add2;
	
	@FindBy(xpath = "//input[@formcontrolname='PCity']")
	public WebElement AddCity;
	
	@FindBy(xpath = "//input[@formcontrolname='PState']")
	public WebElement AddState;
	
	@FindBy(xpath = "//input[@formcontrolname='PZip']")
	public WebElement AddZip;
	
	@FindBy(xpath = "//div[contains(text(),'Address is already present')]")
	public WebElement AddpresentVal;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter address 1')]")
	public WebElement Add1Val;
	
	@FindBy(xpath = "//div[contains(text(),' Please enter city')]")
	public WebElement CityVal;	
	
	@FindBy(xpath = "//div[contains(text(),' Please enter state ')]")
	public WebElement StateVal;	
	
	@FindBy(xpath = "//div[contains(text(),' Please enter zip')]")
	public WebElement ZipVal;	
	
	
	@FindBy(xpath = "//div[@class='col-md-2']//button[contains(text(),'Save')]")
	public WebElement AddressSave;
	
	
	@FindBy(xpath = "//td[3]//button[3][@id='btnSubmit']")
	public WebElement AddressAdd;
	
	@FindBy(xpath = "//td[3]//button[2][@id='btnSubmit']")
	public WebElement AddEdit;
	
	
	@FindBy(xpath = "//button[contains(text(),' NPPES')]")
	public WebElement NPPESBtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter Provider NPI']")
	public WebElement NPPESNPI;
	
	@FindBy(xpath = "//input[@placeholder='Enter FirstName']")
	public WebElement NPPESNPIFirst;
	
	@FindBy(xpath = "//input[@placeholder='Enter LastName']")
	public WebElement NPPESNPILast;
	
	@FindBy(xpath = "//app-nppes-details//button[@type='submit']")
	public WebElement NPPESSearch;
	
	@FindBy(xpath = "//div[contains(text(),'Please select Atleast')]")
	public WebElement NPPESSearchVal;
	
	@FindBy(xpath = "//div[7]//a[@role='button']//span")
	public WebElement NPPESClose;
	
	
	//xpath for previous and next
	
	@FindBy(xpath = "//div[@class='pb5']//span")
	public WebElement Addressidprint;
	
	@FindBy(xpath = "//button[@title='Next Address']")
	public WebElement NextBtn;
	
	@FindBy(xpath = "//button[@title='Previous Address']")
	public WebElement PreviousBtn;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement Previousalert;
	

	//Address Roll up 
	
	@FindBy(xpath = "//div[contains(text(),'Inprocess')]")
	public WebElement InprocessTab;
	
	@FindBy(xpath = "//span[contains(text(),'All Address ID')]")
	public WebElement AddFilter;
	
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement SearchInput;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'All Total')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement TotalChaseFilter;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'All Provider')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement ProviderCnt;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Address1')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement Address1Fil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Address2')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement Address2Fil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'City')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement CityFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'State')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement StateFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Zip')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement ZipFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'All Contact Name')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement ContatFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Fax')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement FaxFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Email_ID')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement EmailFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'LastContact')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement LastContactFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Status')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement StatusFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Call_Disposition')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement Call_DispositionFil;
	
	@FindBy(xpath = "//p-multiselect[contains(@defaultlabel,'Follow_up_Date')]//span[contains(@class,'ui-multiselect-label')]")
	public WebElement Follow_up_DateFil;
	
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement InprocessAddText;

	@FindBy(xpath = "//div[contains(text(),'Exception')]")
	public WebElement ExceptionTab;
	
	@FindBy(xpath = "//div[contains(text(),'Requested')]")
	public WebElement RequestedTab;
	
	
	//Scantech
	
	@FindBy(xpath = "//a[@title='Scan Tech']")
	public WebElement ScanTech;
	
	@FindBy(xpath = "//select[@formcontrolname='EMR']")
	public WebElement EMRValueSingle;
	
	@FindBy(xpath = "//input[@role='combobox']")
	public WebElement EMRValueMulti;
	
	
	@FindBy(xpath = "//div[contains(text(),'Please select EMR')]")
	public WebElement EMRValidation;
	
	@FindBy(xpath = "//input[@ng-reflect-value='1']")
	public WebElement EMR1;
	
	@FindBy(xpath = "//input[@ng-reflect-value='2']")
	public WebElement EMR2;
	
	@FindBy(xpath = "//input[@ng-reflect-value='3']")
	public WebElement paper;
	
	@FindBy(xpath = "//input[@ng-reflect-value='4']")
	public WebElement printpaper;
	
	@FindBy(xpath = "//input[@ng-reflect-value='5']")
	public WebElement Hybrid;
	
	
	@FindBy(xpath = "//span[@title='Clear all']")
	public WebElement ClearAll;
	
	//@FindBy(xpath = "//tr[1]//button[contains(text(),'Schedule')]")
	//public WebElement AppointBtn;
	
	//@FindBy(xpath = "//td[@data-time='09:00:00']//following-sibling::td")
	//public WebElement FixAppointBtn;
	
	@FindBy(xpath = "//button[@aria-label='next']")
	public WebElement ScanNext;
	
	@FindBy(xpath = "//select[@formcontrolname='UserID']")
	public WebElement FieldUser;
	
	@FindBy(xpath = "//input[@formcontrolname='AppoinmentDescription']")
	public WebElement AppointDes;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement ScanTechSave;
	
	@FindBy(xpath = "//div[2]//a[@role='button']")
	public WebElement Calenderclose;
	
	@FindBy(xpath = "//div[4]//a[@role='button']")
	public WebElement ScanTechclose;
	
	@FindBy(xpath = "//div[@class='col-md-12']//form//button[contains(text(),'Edit')]")
	public WebElement ScanTechEdit;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	public WebElement ScanTechDelete;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public WebElement ScanTechDeleteYES;
	
	@FindBy(xpath = "//form//ul/li[@class='address-details-li']")
	public WebElement ScanZipcode;
	
	//field tech
	@FindBy(xpath = "//select[@id='ddlfieldtechname']")
	public WebElement FieldTechName;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement FieldTechSearchBTN;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	public WebElement FieldTechSearchtext;
	
	@FindBy(xpath = "//button[contains(text(),'Select')]")
	public WebElement FieldTechSelect;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	public WebElement FieldADD;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	public WebElement FieldRemove;
	
	@FindBy(xpath = "//button[contains(text(),'Assign')]")
	public WebElement AssignZipcode;
	
	@FindBy(xpath = "//input[@ng-reflect-value='2']")
	public WebElement FieltechCity;
	
	@FindBy(xpath = "//input[@ng-reflect-value='3']")
	public WebElement FieltechCountry;
	
	@FindBy(xpath = "//button[contains(text(),'Print')]")
	public WebElement PrintBtn;
	
	@FindBy(xpath = " //button[@title='Zoom in']")
	public WebElement MapZoomin;
	
	@FindBy(xpath = " //button[@title='Zoom out']")
	public WebElement MapZoomout;
	
	@FindBy(xpath = "//button[contains(@title,'Toggle')]")
	public WebElement Toggle;
	
	public ICRA_PageObjects_Archana(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}
