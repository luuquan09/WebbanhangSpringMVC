package DAO;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelFilesuport {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ReadExcelFilesuport (String excelPath) {
		try {
			
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public String getData(int sheetnumber,int row,int column) {
		sheet = wb.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public Double getintData(int sheetnumber,int row,int column) {
		sheet = wb.getSheetAt(sheetnumber);
		Row roww = sheet.getRow(row);    
		Cell cell = roww.getCell(column);  
		return cell.getNumericCellValue();
	}
	

	
	public int getrowcount(int SheetIndex) {
		int row = wb.getSheetAt(SheetIndex).getLastRowNum();
		row= row+1;
		return row;
	}
	
	
}
