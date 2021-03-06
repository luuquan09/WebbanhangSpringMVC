package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import DAO.SolvedgreedyConsole;
import DAO.Solvedgreedy;


@WebServlet("/GetthingController")
public class GetthingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetthingController() {
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
		
		
		List<KnapsackPackageResult> listkq=null;
		List<KnapsackPackage> listsp = null;
			if(request.getCharacterEncoding()==null) {
				request.setCharacterEncoding("UTF-8");
			}
		String SLlaytrom = request.getParameter("soluonglay");
		int SL = Integer.parseInt(SLlaytrom);	
	
		String filePath = request.getParameter("filePath");
			
		if (filePath == "" && DSmanualinterface.dssp.size()==0) {
			request.setAttribute("message", "Không có dữ liệu !");	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/Home.jsp");
			rd.forward(request,response);
			
		}
		
		else {
			if(filePath != "" || DSmanualinterface.dssp != null) 
			
			
		{ 
		
		if(filePath == "" && DSmanualinterface.dssp != null) {
			listsp = DSmanualinterface.dssp;
			for(int i=0;i < listsp.size();i++) {
		//	System.out.print(listsp.get(i).getnamething());
			}
		}
		else 
			{
			listsp = Readlistimport.TestdataFeed(filePath);
			}
		//Process
		
		int n=listsp.size();
		//=null,V[]=null;
		//String N[]=null;
		
		
		listkq = Solvedgreedy.knapsackGreProc(listsp, SL, n);
		DSmanualinterface.dsspkq.clear();
		for(KnapsackPackageResult backupResult:listkq) {
			
			DSmanualinterface.dsspkq.add(backupResult);
			System.out.print("Danh sách là: " + backupResult.getnamething());
		}
		
		for(KnapsackPackageResult t:DSmanualinterface.dsspkq) {
			//System.out.println("Danh sách là:" +t.getnamething());
		}	
	
		// Danh sách kết quả trả về
		request.setAttribute("listkq", listkq);
	//	HttpSession session = request.getSession(true);
	//	session.setAttribute("listkq", listkq);
		
		 //Danh sách nạp vào
		request.setAttribute("listsp", listsp);
		//Liên kết nạp vào
		request.setAttribute("filePath", filePath);
		//Khối lượng
		request.setAttribute("SLlaytrom", SLlaytrom);
		//List san pham hien tai +  Thông tin trước khi xử lý
		 Double TongKL = Readlistimport.TKL(listsp);
	     Double TongGT = Readlistimport.TGTafter(listsp);
	     int TongSL = Readlistimport.TSL(listsp);
		
	     
	     
	     
	     //List san pham ket qua tinh toan
	     Double TongKLkq = Readlistimport.TKLtinhtoan(listkq);
	     Double TongGTkq = Readlistimport.TGTtinhtoan(listkq);	     
	     int TongSLkq = Readlistimport.TSLtinhtoan(listkq);
		
	     
	     
	   //List ket qua con lai cua san pham
	      Double TongKLconlai = TongKL - TongKLkq;
	     Double TongGTconlai = TongGT - TongGTkq;
	     int TongSLconlai = TongSL - TongSLkq;
	     
	     
	     
	     
	     request.setAttribute("TongKL", TongKL);
	     request.setAttribute("TongGT", TongGT);
	     request.setAttribute("TongSL", TongSL);
	     
	     request.setAttribute("TongKLkq", TongKLkq);
	     request.setAttribute("TongGTkq", TongGTkq);
	     request.setAttribute("TongSLkq", TongSLkq);
	     
	     
	     request.setAttribute("TongKLconlai", TongKLconlai);
	     request.setAttribute("TongGTconlai", TongGTconlai);
	     request.setAttribute("TongSLconlai", TongSLconlai );
	     
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/Home.jsp");
		rd.forward(request,response);
		
		}
		
		}
		
		
		
		
		
	}

}
