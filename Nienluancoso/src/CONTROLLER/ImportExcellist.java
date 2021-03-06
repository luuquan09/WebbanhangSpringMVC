package CONTROLLER;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import BEAN.KnapsackPackage;
import DAO.Readlistimport;
import DAO.ReadExcelFilesuport;


@WebServlet("/ImportExcellist")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
			maxFileSize = 1024 * 1024 * 10, // 10MB
			maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ImportExcellist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public static final String SAVE_DIRECTORY = "uploadDir";
    public ImportExcellist() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
	{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		 List<KnapsackPackage> listsp=null; 
				try {
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
			        
			         for (Part part : request.getParts()) {
								   String fileName = extractFileName(part);
								   if (fileName != null && fileName.length() > 0) {
								       String filePath = fullSavePath + File.separator + fileName;
								       System.out.println("Write attachment to file: " + filePath);
								       // Ghi vào file.
								       part.write(filePath);
								       listsp = Readlistimport.TestdataFeed(filePath);
								       Double TongKL = Readlistimport.TKL(listsp);
								       Double TongGT = Readlistimport.TGTafter(listsp);
								       int TongSL = Readlistimport.TSL(listsp);
								       request.setAttribute("filePath", filePath);
								       request.setAttribute("TongKL", TongKL);
								       request.setAttribute("TongGT", TongGT);
								       request.setAttribute("TongSL", TongSL);
								       request.setAttribute("listsp", listsp);
								   }
			         	}
			       
			 		
			     
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/Home.jsp");
				rd.forward(request,response);
	}
	 
	
	private String extractFileName(Part part) {
	       
	       String contentDisp = part.getHeader("content-disposition");
	       String[] items = contentDisp.split(";");
	       for (String s : items) {
	           if (s.trim().startsWith("filename")) {
	               // C:\file1.zip
	               // C:\Note\file2.zip
	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
	               clientFileName = clientFileName.replace("\\", "/");
	               int i = clientFileName.lastIndexOf('/');
	               // file1.zip
	               // file2.zip
	               return clientFileName.substring(i + 1);
	           }
	       }
	       return null;
	   }
		 
	  
}
