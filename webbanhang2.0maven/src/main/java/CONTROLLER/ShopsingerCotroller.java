package CONTROLLER;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import BEAN.Product;
import DAO.ProductDAO;

@Controller
public class ShopsingerCotroller {

	@RequestMapping("shopsingle")
	public String shopsingle(ModelMap model,
			@ModelAttribute("idpd") int id
			) {
		ProductDAO produrtDAO = new ProductDAO();
		Product product = produrtDAO.findproductbyidd(id);
		model.addAttribute("product", product); 	
		
		return "client/shopsingle";			
	}
	
}
