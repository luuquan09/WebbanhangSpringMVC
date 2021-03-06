package CONTROLLER;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import BEAN.Cart;
import BEAN.Cartitems;
import BEAN.Mber;
import DAO.CartDAO;
import DAO.MemberDAO;
import DAO.ProductDAO;

@Controller
public class CartController {

	@RequestMapping("cart")
	public String cartindex(
			HttpSession session,
			ModelMap model
			) {
		if(session.getAttribute("cart")!=null) {
		@SuppressWarnings("unchecked")
		List<Cartitems>  cart = (List<Cartitems>) session.getAttribute("cart");			
		model.addAttribute("cart", cart);		
		}		
		return "client/cart";
		
	}
	
	@RequestMapping(value = "addcart", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void additemcard(
			ModelMap model,
			@ModelAttribute("idpd") int idproduct,
			@ModelAttribute("number") int number,
			@ModelAttribute("size") String size,
			HttpSession session			
			) {
		
		MemberDAO memberDAO = new MemberDAO();
		ProductDAO productDAO = new ProductDAO();
		Mber mber = new Mber();
		int idmember;
		
		
		if(session.getAttribute("idmember")!=null) {
			idmember =(int)session.getAttribute("idmember");
			mber = memberDAO.findbyId(idmember);

		if(session.getAttribute("cart")==null) {
			List<Cartitems> cart = new ArrayList<Cartitems>();
			cart.add(new Cartitems(productDAO.findbyId(idproduct),number,size));
			session.setAttribute("cart", cart);
			session.setAttribute("numberofCart", cart.size());
		}
		else {
			
			@SuppressWarnings("unchecked")
			List<Cartitems>  cart = (List<Cartitems>) session.getAttribute("cart");			
			int index = this.exists(idproduct, size, cart);
			if(index!=-1)
				{		
					cart.get(index).setQuantity(cart.get(index).getQuantity()+number);												
				}
				else 
					{		
					cart.add(new Cartitems(productDAO.findbyId(idproduct),number,size));
					}
			session.setAttribute("cart", cart);
			session.setAttribute("numberofCart", cart.size());				
			}
		
		
		}
		
	
	}
	@RequestMapping(value = "removecart", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeCart(HttpSession session,
			@ModelAttribute("idpd") int idproduct,
			@ModelAttribute("size") String size
			) {
		@SuppressWarnings("unchecked")
		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
		int index = this.exists(idproduct,size, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		session.setAttribute("numberofCart", cart.size());
	}
	
	@RequestMapping(value = "updatequality", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void updatequality(HttpSession session,
			@ModelAttribute("idpd") int idproduct,
			@ModelAttribute("size") String size,
			@ModelAttribute("quality") int quality
			) {
		@SuppressWarnings("unchecked")
		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
		int index = this.exists(idproduct,size, cart);
		cart.get(index).setQuantity(quality);
		session.setAttribute("cart", cart);
		session.setAttribute("numberofCart", cart.size());

	}
	
	
	
	
		
	private int exists(int idproduct,String size,List<Cartitems> cart) {		
		
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getProductitem().getId() == idproduct && cart.get(i).getSize().equals(size)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
}
