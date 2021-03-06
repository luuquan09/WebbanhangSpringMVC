package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.KnapsackPackage;
import BEAN.KnapsackPackageResult;
import BEAN.DSmanualinterface;
import DAO.Readlistimport;


@WebServlet("/Importmauallist")
public class Importmauallist extends HttpServlet implements DSmanualinterface {
	private static final long serialVersionUID = 1L;
   // private static final List<KnapsackPackage> dssp = new ArrayList<KnapsackPackage>();
    public Importmauallist() {
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
		
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String weightStr = request.getParameter("weight");		
		String valueStr = request.getParameter("value");
		
		Double weight = Double.parseDouble(weightStr);
		Double value = Double.parseDouble(valueStr);
		
		String SLsp = request.getParameter("SLsp");
		
		String name = request.getParameter("name");
		
		
		
		int SL = Integer.parseInt(SLsp);
		KnapsackPackage eachrow = new KnapsackPackage(weight,value,name,SL);
	
		
		DSmanualinterface.dssp.add(eachrow);
		 request.setAttribute("listsp", DSmanualinterface.dssp);
		
		 Double TongKL = Readlistimport.TKL(DSmanualinterface.dssp);
	     Double TongGT = Readlistimport.TGTafter(DSmanualinterface.dssp);
	     int TongSL = Readlistimport.TSL(DSmanualinterface.dssp);
		 
  
	     
	     request.setAttribute("TongKL", TongKL);
	     request.setAttribute("TongGT", TongGT);
	     request.setAttribute("TongSL", TongSL);
		 
	     //if(DSmanualinterface.dssp.size()>0) {
	   //  request.setAttribute("ktdsinterface", "havedata");
	    // }
	     
	     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/Home.jsp");
		rd.forward(request,response);
		
		
	}

}
