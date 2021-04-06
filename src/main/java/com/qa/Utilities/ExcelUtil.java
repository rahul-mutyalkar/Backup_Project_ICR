package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;




public class ExcelUtil
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFCellStyle my_style;
	static XSSFCell cell;
	static XSSFFont font;
	static XSSFRow row;
	static File file;
	static FileInputStream fis;
	static int lastRowNum;
    static int lastCellNum;
    static String filename = System.getProperty("user.dir")+"\\Reports\\TestResults.xlsx";
    
	public static void CreateHeading(String data) throws Exception
	{
		File fileName1 = new File(filename);
		FileOutputStream fos = new FileOutputStream(fileName1);
        wb = new XSSFWorkbook();  
        sheet = wb.createSheet("Results"); 
        row=sheet.createRow(2);
        cell=row.createCell(1);
        cell.setCellValue(data); 
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,5));
        my_style = wb.createCellStyle();
        my_style.setAlignment(my_style.ALIGN_CENTER);
        cell.setCellStyle(my_style);
        DoBorder(my_style);
        cell.setCellStyle(my_style);        
        my_style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	    my_style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
	    cell.setCellStyle(my_style);
        font=wb.createFont();
        font.setUnderline(XSSFFont.U_SINGLE);
        font.setColor((XSSFFont.ANSI_CHARSET));
        my_style.setFont(font);
        cell.setCellStyle(my_style);
        font=my_style.getFont();
        font.setFontHeightInPoints(((short)12));
        font.setBold(true);
        my_style.setFont(font);
        cell.setCellStyle(my_style);     
        
        cell=row.createCell(2);
        my_style = wb.createCellStyle();
        DoBorder(my_style);
         cell.setCellStyle(my_style);
        
        cell=row.createCell(3);
        my_style = wb.createCellStyle();
        DoBorder(my_style);
         cell.setCellStyle(my_style);
        
        cell=row.createCell(4);
        my_style = wb.createCellStyle();
        DoBorder(my_style);
        cell.setCellStyle(my_style);
        
        cell=row.createCell(5);
        my_style = wb.createCellStyle();
        DoBorder(my_style);
        cell.setCellStyle(my_style);
     
        wb.write(fos);
        fos.flush();
        fos.close();
       
	}
	public static void CrtTestColums(String data,int rowno,int colno) throws IOException
	{
        File fileName2= new File(filename);
		fis = new FileInputStream(fileName2);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        my_style = wb.createCellStyle();
        font=wb.createFont();
        font.setFontHeightInPoints(((short)11));
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        my_style.setFont(font);
        try {
         if(sheet.getRow(rowno)==null)
          {
           row=sheet.createRow(rowno);
           cell=row.createCell(colno);
           cell.setCellValue(data);
           my_style.setAlignment(my_style.ALIGN_CENTER);
           DoBorder(my_style);
   	       my_style.setFillPattern(XSSFCellStyle.FINE_DOTS);
   	       my_style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
           cell.setCellStyle(my_style);
           sheet.autoSizeColumn(colno);
          }
        else
        {
        	row=sheet.getRow(rowno);
            cell=row.createCell(colno);
            cell.setCellValue(data);
            my_style.setAlignment(my_style.ALIGN_CENTER);
            DoBorder(my_style);
    	    my_style.setFillPattern(XSSFCellStyle.FINE_DOTS);
    	    my_style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            cell.setCellStyle(my_style);
            sheet.autoSizeColumn(colno);
        }
        }
        catch(Exception e)
        {
        	System.out.println("Error");
        }
        FileOutputStream fout = new FileOutputStream(filename);
        wb.write(fout);
        fout.flush();
        fout.close();       
	}
	
	
	public static void CreateFile() throws Exception
	{
		CreateHeading("ICRA TEST SUMMARY REPORT");
		CrtTestColums("TC_Name",4,1);
		CrtTestColums("Status",4,2);
		CrtTestColums("Start_Time",4,3);
		CrtTestColums("End_Time",4,4);
		CrtTestColums("TC_Time",4,5);		
	}
	 
 
public static void DoBorder(XSSFCellStyle my_style)
{
	my_style.setBorderTop(XSSFCellStyle.BORDER_THIN);
    my_style.setBorderRight(XSSFCellStyle.BORDER_THIN);
    my_style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
    my_style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
}
 
 public static void WriteInExcel(String columnname,String data,String testcasename) throws Exception
 {
	//String filename = System.getProperty("user.dir")+"\\TestResults.xlsx";
	file = new File(filename);
	fis = new FileInputStream(file);
	wb = new XSSFWorkbook(fis);
	sheet = wb.getSheetAt(0);
    lastRowNum = sheet.getLastRowNum() ;
    my_style = wb.createCellStyle();
    a:
    for (int j = 5; j <= 100000; j++)
      {
    	try
    	{
    	 if(sheet.getRow(j)==null)
    	 {
    		row=sheet.createRow(j);
    		cell=row.createCell(1);
    		cell.setCellValue(testcasename); 
    		my_style.setAlignment(my_style.ALIGN_CENTER);
    		DoBorder(my_style); 
    		cell.setCellStyle(my_style);
    		sheet.autoSizeColumn(1);
     		break a;
         }
    	 else if(sheet.getRow(j).getCell(1).getStringCellValue().equalsIgnoreCase(testcasename.trim()))
    	 {
    		 row=sheet.getRow(j);
    		 cell=row.createCell(1);
     		 cell.setCellValue(testcasename);   
     		// my_style.setAlignment(my_style.ALIGN_CENTER);
     		 DoBorder(my_style); 
     		 cell.setCellStyle(my_style);
     		 sheet.autoSizeColumn(1);
    		 break a;
    	 }
    	 
     	}
    	catch(Exception e)
    	{
    		
    	}    	
     }
    for (int k = 1; k <=5; k++)
       {
        if(sheet.getRow(4).getCell(k).getStringCellValue().trim().equalsIgnoreCase(columnname.trim()))
         {
        	cell=row.createCell(k);
        	if(data.equalsIgnoreCase("Fail"))
        	{
        		font=wb.createFont();
                font.setColor((XSSFFont.COLOR_RED));
                my_style.setFont(font);
                cell.setCellStyle(my_style);
         		cell.setCellValue(data);
         		my_style.setAlignment(my_style.ALIGN_CENTER);
         		DoBorder(my_style); 
        		cell.setCellStyle(my_style); 
        		font=my_style.getFont();
        		font.setBold(true);
                my_style.setFont(font);
        	}
        	else
        	{
     		cell.setCellValue(data); 
     		my_style.setAlignment(my_style.ALIGN_CENTER);
     		DoBorder(my_style); 
    		cell.setCellStyle(my_style); 
    		sheet.autoSizeColumn(1);
        	}
     		break;        	
        }
        
       }
   FileOutputStream fos=new FileOutputStream(file);
   wb.write(fos);
   fos.flush();
   fos.close();
 }
 

 
 public static void EndExcel() throws Exception
 {
	
	 File file = new File(filename);
	 fis = new FileInputStream(file);
	 wb = new XSSFWorkbook(fis);
	 sheet = wb.getSheetAt(0);
	 my_style = wb.createCellStyle();
	 lastRowNum = sheet.getLastRowNum(); 
	 int rowno=lastRowNum+3;
	 CrtTestColums("Total_TC_Count",rowno,1);
	 CrtTestColums("Total_Pass_TC_Count",rowno,2);
	 CrtTestColums("Total_Fail_TC_Count",rowno,3);	
	 CrtTestColums("Total_Execution_Time",rowno,4);
	 File file1 = new File(filename);
	 fis = new FileInputStream(file1);
	 wb = new XSSFWorkbook(fis);
	 sheet = wb.getSheetAt(0);
	 my_style = wb.createCellStyle();
     int j=5;
     int totalcount=(lastRowNum-j)+1;
     int passcount=0; int failcount=0; int a[]=new int[3];
     a[0]=0;a[1]=0;a[2]=0;
     for (int i= 5; i <= lastRowNum; i++)
     {
    	 if(sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("PASS"))
    	 {
    		 passcount=passcount+1; 
    	 }
    	 if(sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("FAIL"))
    	 {
    		 failcount=failcount+1; 
    	 }
    	 String[] data=sheet.getRow(i).getCell(5).getStringCellValue().split(":");
    	 a[0]=Integer.parseInt(data[0])+a[0];//0
    	 a[1]=Integer.parseInt(data[1])+a[1];//62
    	 a[2]=Integer.parseInt(data[2])+a[2]; //368
    	 if(a[2]>60)
    	 {
    		 a[1]=a[1]+1;
    		 a[2]=a[2]-60;
    	 }
    	 if(a[1]>60)
    	 {
    		 a[0]=a[0]+1;
    		 a[1]=a[1]-60;
    	 }
    	 
    	}
     String s=String.valueOf(a[0]);String s1=String.valueOf(a[1]);String s2=String.valueOf(a[2]);
     row=sheet.createRow(lastRowNum+4);
	 cell=row.createCell(1);
	 cell.setCellValue(totalcount);
	 my_style.setAlignment(my_style.ALIGN_CENTER);
	 DoBorder(my_style);
	 cell.setCellStyle(my_style);
     DoBorder(my_style);
     cell=row.createCell(2);
	 cell.setCellValue(passcount);
	 my_style.setAlignment(my_style.ALIGN_CENTER);
	 DoBorder(my_style);
	 cell.setCellStyle(my_style);
     cell=row.createCell(3);
	 cell.setCellValue(failcount);
	 my_style.setAlignment(my_style.ALIGN_CENTER);
	 DoBorder(my_style);
	 cell.setCellStyle(my_style);
	 cell=row.createCell(4);
	 cell.setCellValue(s+":"+s1+":"+s2);
	 my_style.setAlignment(my_style.ALIGN_CENTER);
	 DoBorder(my_style);
	 cell.setCellStyle(my_style);
     FileOutputStream fos1=new FileOutputStream(file);
	 wb.write(fos1);
	 fos1.flush();
	 fos1.close();    
 }
 
 public static String GetTime(long t)
 {
	 Instant instant = Instant.ofEpochMilli(t);
	 ZonedDateTime zdt = ZonedDateTime.ofInstant ( instant , ZoneOffset.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "HH:mm:ss:SSS" );
		String output = formatter.format (zdt);
		return output;
 }
 
 public static String timeDifference(long timeDifference1)
 {
	 long timeDifference = timeDifference1/1000;
	 int h = (int) (timeDifference / (3600));
	 int m = (int) ((timeDifference - (h * 3600)) / 60);
	 int s = (int) (timeDifference - (h * 3600) - m * 60);

	 return String.format("%02d:%02d:%02d", h,m,s);
 }
 

// public static void convertExcel2Html(String excelFilePath, String htmlFilePath, String encoding) {
//		File excelFile = new File(excelFilePath);
//		File htmlFile = new File(htmlFilePath);
//		if (htmlFile.exists() && htmlFile.canRead())
//			return;
//		File htmlFileParent = new File(htmlFile.getParent());
//		InputStream is = null;
//		OutputStream out = null;
//		StringWriter writer = null;
//		try {
//			if (excelFile.exists()) {
//				if (!htmlFileParent.exists()) {
//					htmlFileParent.mkdirs();
//				}
//				is = new FileInputStream(excelFile);
//				HSSFWorkbook wb = new HSSFWorkbook(is);
//				ExcelToHtmlConverter converter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
//				converter.setOutputColumnHeaders(false);
//				converter.setOutputRowNumbers(false);
//				converter.processWorkbook(wb);
//
//				writer = new StringWriter();
//				Transformer serializer = TransformerFactory.newInstance().newTransformer();
//				serializer.setOutputProperty(OutputKeys.ENCODING, encoding);
//				serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//				serializer.setOutputProperty(OutputKeys.METHOD, "html");
//				serializer.transform(new DOMSource(converter.getDocument()), new StreamResult(writer));
//				out = new FileOutputStream(htmlFile);
//				out.write(writer.toString().getBytes(encoding));
//				out.flush();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (is != null) {
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				is = null;
//			}
//			if (out != null) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				out = null;
//			}
//			if (writer != null) {
//				try {
//					writer.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				writer = null;
//			}
//		}
//	}
}
 
 
 
