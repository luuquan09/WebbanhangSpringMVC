package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import BEAN.KnapsackPackageResult;

public class ExportExcel {
//	private static final long serialVersionUID = 1L;
	 public static final String SAVE_DIRECTORY = "uploadDir";
	 
	 
	public static String write_file(List<KnapsackPackageResult> dskq) {
		String resultStr="";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Customer_Info");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell titlename = firstRow.createCell(0);
		titlename.setCellValue("Tên đồ vật");
		Cell titleweight = firstRow.createCell(1);
		titleweight.setCellValue("Khối lượng");
		Cell titlevalue = firstRow.createCell(2);
		titlevalue.setCellValue("Giá trị");
		Cell titlesoluong = firstRow.createCell(3);
		titlesoluong.setCellValue("Số lượng");
		for (KnapsackPackageResult result:dskq) {
				Row row = sheet.createRow(rowNum++);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue(result.getnamething());
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(result.getWeight());
				Cell cell3 = row.createCell(2);
				cell3.setCellValue(result.getValue());
				Cell cell4 = row.createCell(3);
				cell4.setCellValue(result.getSLsp());			
			}
		try {
			
			
		/*	
			// Đường dẫn tuyệt đối tới thư mục gốc của web app.
			 String appPath = request.getServletContext().getRealPath("");
			 appPath = appPath.replace('\\', '/');

			 // Thư mục để save file tải lên.
			 String fullSavePath = null;
			 if (appPath.endsWith("/")) {
			     fullSavePath = appPath + SAVE_DIRECTORY;
			 } else {
			     fullSavePath = appPath + "/" + SAVE_DIRECTORY;
			 }

	       // Tạo thư mục nếu nó không tồn tại.
	         File fileSaveDir = new File(fullSavePath);
	         if (!fileSaveDir.exists()) {
						   fileSaveDir.mkdir();
	         }  
				
	         try {
				for (Part part : request.getParts()) {
					   String fileName = extractFileName(part);
					   if (fileName != null && fileName.length() > 0) {
					       String filePath = fullSavePath + File.separator + fileName;
					       System.out.print("Cai dang tim:" + filePath);
					   }
				 }
			} 
	         catch (ServletException e) {
				
				e.printStackTrace();
			}
			
			*/
			
			
			
			
			  File myEx = new File("Q:\\MVC\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Nienluancoso\\uploadDir\\"+"Result"+".xlsx");			  
			  FileOutputStream outputStream = new FileOutputStream(myEx);
		      workbook.write(outputStream);
		      String absolutePath = myEx.getAbsolutePath();
		      resultStr = absolutePath;
		//      System.out.print(absolutePath);
		      workbook.close();
		      
		      
		      
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	//	    System.out.println("Done");
		return resultStr;
	}
			
	 
}
