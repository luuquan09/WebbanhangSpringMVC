package CONTROLLER;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import BEAN.Product;
import DAO.SearchAndCmtDAO;


@Controller
public class SearchAndCmtController {

	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public String searchPerson (
			@ModelAttribute("name") String name,
			ModelMap model
			
			) {
		SearchAndCmtDAO searchAndcmtDAO = new SearchAndCmtDAO();
		
		List<Product> resultlist = searchAndcmtDAO.searchproduct(name);
		
		String result= "";
		for(Product product:resultlist) {
			result += "<div class='container' id='search'>"+
				 	"<h3 style='padding-left: 12px;opacity: 1.0;'>" +
				 	"<a href='shopsingle.htm?idpd="+product.getId()+"'>"+product.getName()+"</a></h3></div>";
		}

		System.out.println(result);
		return result;
	}

}
