package com.qa.BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.PageObjects.RecordQAApproval_Pageobject;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;

public class RecordQAApproval_Logic extends Extent_Reporting {

	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	RecordQAApproval_Pageobject icra_elements;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	
	public RecordQAApproval_Logic(WebDriver driver, String TC_ID) {
		this.driver = driver;
		this.TC_ID = TC_ID;
		icra_elements = new RecordQAApproval_Pageobject(driver);

	}
	
	public void SubmitChase() throws Throwable
	{
		
	 	
		try {
			List<WebElement> label = driver.findElements(By.xpath("//div[contains(@ref,'eLeftContainer')]//div[contains(@class,'ag-row')]"));	 	
					
			for(int i=0;i<=label.size()-1;i++)
			{
				
				String list = driver.findElement(By.xpath("(//div[@row-index="+i+"]//div[8])")).getText();
				String[] parts = list.split(", ");
			
				String part2 = parts[1]; 
			   
				
				Extent_Reporting.Log_Message("Chasecount "+i+" is : "+list, test, driver);
				
				
				int size =label.size();
				if(part2.contains(ExcelHandling.GetExcelData(TC_ID, "LoginUsername"))||list.length() == 0 )
				{
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is Available for user ", test, driver);

					//Click check box
					action.clickButton(driver.findElement(By.xpath("(//div[@row-index="+i+"]//div[1])")), "click on checkbox");
					//select drop down 
					action.selectDDByText(driver.findElement(By.xpath("//div[@row-index="+i+"]//div[@col-id='ActionId']//app-record-qa-approval-grid-controls//div//select")), ExcelHandling.GetExcelData(TC_ID, "Action"));
			        //Provide comment
					action.inputText(driver.findElement(By.xpath("//div[@row-index=1]//div[@col-id='Comments']//app-record-qa-approval-grid-controls//div//textarea")),"TESTING","Provide Text");
			        //submit
					action.clickButton(icra_elements.RecordQASubmitBtn, "Submit");
					action.waitForPageLoad();
					Thread.sleep(3000);
					if(label.size()-1<size)
					{
					Extent_Reporting.Log_Pass(TC_ID, "Chase count is reduced" +icra_elements.RecordQATotCha.getText(), test, driver);
					break;
					}
					else
					{
						Extent_Reporting.Log_Pass(TC_ID, "Chase count is not reduced", test, driver);
						break;
					}
									
				}
			
				else
				{				
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is not Available for user ", test, driver);				
					//action.Scroll(driver.findElement(By.xpath("//div[@row-index="+i+"]//div[8])")));
					//check validation
					if(part2.contains(ExcelHandling.GetExcelData(TC_ID, "RecordQAUser")))
							{
						//submit
						action.clickButton(icra_elements.RecordQASubmitBtn, "Submit");
						Extent_Reporting.Log_Pass(TC_ID, "On submit alert message"+icra_elements.RecordQAAlert.getText(), test, driver);
						//click checkbx
						WebElement CHK1=driver.findElement(By.xpath("(//div[@row-index="+i+"]//div[1])"));
						action.clickButton(CHK1, "click on checkbox");
						//Print validation
						action.clickButton(icra_elements.RecordQASubmitBtn, "Submit");
						Extent_Reporting.Log_Pass(TC_ID, "On checkbox submit alert "+icra_elements.RecordQAAlert.getText(), test, driver);
						//click checkbx
						WebElement Drop=driver.findElement(By.xpath("//div[@row-index="+i+"]//div[@col-id='ActionId']//app-record-qa-approval-grid-controls//div//select"));
				        action.selectDDByText(Drop, ExcelHandling.GetExcelData(TC_ID, "Action"));	
				      //Print validation
				      		action.clickButton(icra_elements.RecordQASubmitBtn, "Submit");
				      		Extent_Reporting.Log_Pass(TC_ID, "On dropdown selection submit alert "+icra_elements.RecordQAAlert.getText(), test, driver);
				      		//break;	
					
							}//if loop end
				}//else loopp end
			
			}//inside loop
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "SubmitChase() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}
	}

		
	public void AccessChase() throws Throwable
	{
		
	 	
		try {
			List<WebElement> label = driver.findElements(By.xpath("//div[contains(@ref,'eLeftContainer')]//div[contains(@class,'ag-row')]"));	 	
					log.info("Size"+label.size());
			for(int i=0;i<=label.size()-1;i++)
			{
				
				String list = driver.findElement(By.xpath("(//div[@row-index="+i+"]//div[8])")).getText();
				String[] parts = list.split(", ");
			
				String part2 = parts[1]; 
			   
				
				Extent_Reporting.Log_Message("Chasecount "+i+" is : "+list, test, driver);
				
				if(part2.contains(ExcelHandling.GetExcelData(TC_ID, "LoginUsername"))||list.length() == 0 )
				{
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is Available for user ", test, driver);
					WebElement Drop=driver.findElement(By.xpath("//div[@row-index="+i+"]//div[4]"));
					String Membername= Drop.getText();
					//Click check box
					action.clickButton(driver.findElement(By.xpath("(//div[@row-index="+i+"]//div[2])")), "click on checkbox");
				    
					//check member name
					      if(Membername.equals(icra_elements.MemberMiddle.getText()))
							{
								Extent_Reporting.Log_Pass(TC_ID, "Member name is same as in the grid", test, driver);

							}
					      else
					      {
								Extent_Reporting.Log_Pass(TC_ID, "Member name is not matching", test, driver);

					      }
					
					Extent_Reporting.Log_Pass(TC_ID, "Chase Count is "+list, test, driver);
					
					
					Thread.sleep(1000);
					break;				
				}
			
				else
				{				
					Extent_Reporting.Log_Pass(TC_ID, "Pdf is not Available for user ", test, driver);
					//break;
					//action.Scroll(driver.findElement(By.xpath("//div[@row-index="+i+"]//div[8])")));
					
				}//else loop end
			
			}//fpr loop end
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AccessChase() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}//catch end
	}
}
