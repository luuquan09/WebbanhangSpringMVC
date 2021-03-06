package CONTROLLER;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import BEAN.KnapsackPackage;
import BEAN.KnapsackPackageResult;
import BEAN.DSmanualinterface;
import DAO.Readlistimport;
import DAO.Solvedgreedy;
import DAO.ExportExcel;

@WebServlet("/ExportresultExcel")
public class ExportresultExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExportresultExcel() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		
	
		
		RequestDispatcher rd = request.getRequestDispatcher("Homefowar");
		rd.forward(request,response);
		
		 
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		List<KnapsackPackageResult> listkq=null;
		List<KnapsackPackage> listsp = null;
		
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		String filePath = request.getParameter("filePath");
		String SLlaytrom = request.getParameter("SLlaytrom");
		int SL = Integer.parseInt(SLlaytrom);	
		

		
		
		
		String result = "";
		if(DSmanualinterface.dsspkq.size()>0) {
			result = ExportExcel.write_file(DSmanualinterface.dsspkq);	
		}
		
		if(DSmanualinterface.dsspkq.size()==0 && filePath != "")
		{
			listsp = Readlistimport.TestdataFeed(filePath);
			listkq = Solvedgreedy.knapsackGreProc(listsp, SL, listsp.size());
			result = ExportExcel.write_file(listkq);
		}

		
	    Path path = Paths.get(result);
	    byte[] data = Files.readAllBytes(path);
	   
	    	//Thiet lap thong tin tra ve
	    
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-disposition", "attachment; filename=Result.xlsx");
	    response.setContentLength(data.length);
	    InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
		
	    OutputStream outStream = response.getOutputStream();
	    byte[] buffer = new byte[4096];
	    int bytesRead = -1;
	    while ((bytesRead = inputStream.read(buffer)) != -1) {
	    outStream.write(buffer, 0, bytesRead);
	    }
	    inputStream.close();
	    outStream.close();
	

		
	}

}
