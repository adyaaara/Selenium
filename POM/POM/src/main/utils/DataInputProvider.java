package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

import testcases.TC002;

public class DataInputProvider {
	

	public static String[][] getData(String sheetName) 
	{
		String[][] testdata = null ;
		
		File file;
		
		try {
			FileInputStream fs = new FileInputStream("./testData/TestData.xls");
			HSSFWorkbook wb =  new HSSFWorkbook(fs);
			HSSFSheet sheet =wb.getSheet(sheetName);
			int rowcount=	sheet.getLastRowNum();

			System.out.println("row count is "+rowcount);//rowcount -1  
			int columncount =sheet.getRow(0).getLastCellNum();
			System.out.println("column count is "+columncount);
			testdata = new String[rowcount][columncount];
			for(int i=1; i<=rowcount; i++)
			{
			HSSFRow row =sheet.getRow(i);
			for(int j=0; j<columncount; j++)
			{
				
			String data= row.getCell(j).getStringCellValue();
			
			testdata[i-1][j] =data;
			System.out.println(data);
			}
}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return testdata;
	}

}
