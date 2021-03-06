package CONTROLLER;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import BEAN.Product;
import DAO.ProductDAO;

import java.util.*;
@Controller
public class ShopController {
	
	//The number of list product to show    
	final int total = 6;
	
	@RequestMapping("shop")
	public String shopindex(ModelMap model
		//	   @ModelAttribute("pageid") String pageidString
			   ) {	 
		ProductDAO produrtDAO = new ProductDAO();
	     List<Object[]> listproduct = produrtDAO.findproductbyPage(0, total);
	     int numberpage = produrtDAO.numberofproduct() / total;   
	     model.addAttribute("check", 1);
	     model.addAttribute("numberpage", numberpage);
	     model.addAttribute("listproduct", listproduct);
	
		return "client/shop";
	}
	@RequestMapping("page")
	public String shoppage(ModelMap model,
			@ModelAttribute("pageid") String pageidString
			) 
	{
		
	    int pageid = Integer.parseInt(pageidString);
	    ProductDAO produrtDAO = new ProductDAO();
	    List<Object[]> listproduct = produrtDAO.findproductbyPage(pageid, total);
	    int numberpage = produrtDAO.numberofproduct() / total;
	    model.addAttribute("check", pageid);
	    model.addAttribute("numberpage", numberpage);
	    model.addAttribute("listproduct", listproduct);
		return "client/shop";
	}

	
}
