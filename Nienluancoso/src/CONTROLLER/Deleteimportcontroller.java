package CONTROLLER;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.DSmanualinterface;


@WebServlet("/Deleteimportcontroller")
public class Deleteimportcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Deleteimportcontroller() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
	
		DSmanualinterface.dssp.clear();
		DSmanualinterface.dsspkq.clear();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/Home.jsp");
		rd.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
{
		
		doGet(request, response);
	}

}
