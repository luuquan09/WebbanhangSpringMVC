package CONTROLLER;


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

import AddressBEAN.District;
import AddressBEAN.Province;
import AddressBEAN.Ward;
import BEAN.Address;
import BEAN.Cartitems;
import BEAN.Mber;
import BEAN.Order;
import BEAN.Order_item;
import DAO.AddressDAO;
import DAO.CheckouDAO;
import DAO.MemberDAO;
import DAO.OrderDAO;

@Controller
public class CheckoutController {

	
	@RequestMapping("checkout")
	public String checkoutindex(
			ModelMap model,
			HttpSession session		
			) {
		AddressDAO address = new AddressDAO();
		@SuppressWarnings("unchecked")
		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
		int idmember =(int)session.getAttribute("idmember");
		MemberDAO memberDAO = new MemberDAO();
		Mber mber = memberDAO.findbyId(idmember);	
		float total=0;
		int number=0;
		
		for(Cartitems cartitem:cart) {
			total+=cartitem.getProductitem().getPrice()*cartitem.getQuantity();
			number += cartitem.getQuantity();
		}
		
		
		Address addr = mber.getAddress();
		Order order = new Order(total,number,mber);
		
		if(addr.hashCode()>0) {
			order.setAddress(addr);
		}
		model.addAttribute("orderhave", order);
		//model.addAttribute("Order", new Order());
		model.addAttribute("member", mber);
		
		model.addAttribute("cart", cart);
		return "client/checkout";
	}
	
	@ModelAttribute("provincetest")
	public List<Province> getProvince(){
		AddressDAO address = new AddressDAO();
		List<Province> province = address.findALLprovince();
		return province;
	}
	AddressDAO address = new AddressDAO();
	
	@RequestMapping(value = "gethuyen", method = RequestMethod.POST)
	@ResponseBody
	public String gethuyen(
			@ModelAttribute("provinceid") int idprovince
			) {
		String result="";
		
			result="<option value='0'>---Chọn Quận/Huyện--</option>";
			AddressDAO address = new AddressDAO();
			List<District> district = address.findALLdistrict(idprovince);
			for(District dis:district) {
				result = result + "<option value='"+dis.getId()+"'>"+dis.getName()+"</option>" ;
			}
		
		return result;
	}
	
	@RequestMapping(value = "getward", method = RequestMethod.POST)
	@ResponseBody
	public String getward(
			@ModelAttribute("provinceid") int idprovince,
			@ModelAttribute("districtid") int districtid		
			) {
		
		String result = "";				
		result="<option value=''>--- Chọn Phường/Xã --</option>";
		AddressDAO address = new AddressDAO();
		List<Ward> ward = address.findALLward(idprovince, districtid);
		for(Ward wa:ward) {
			result = result + "<option value='"+wa.getId()+"'>"+wa.getName()+"</option>" ;
		}
		return result;
	}
	
	//GET SHIP COST
	@RequestMapping(value ="getshipcode", method=RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void getcostship(
			@ModelAttribute("provinceid") int idprovince,
			@ModelAttribute("districtid") int districtid,
			HttpSession session
			) {
		CheckouDAO checkDAO = new CheckouDAO();	
		float shipcost= checkDAO.getcost2(idprovince, districtid);		
		
	//	12 :164 166
	//	47 :550
		if(idprovince == 47 && districtid==550) {
			session.setAttribute("ship",25000f);
		}else {
		session.setAttribute("ship",shipcost);
		}
	}
	
	//GET DISCOUNT
	@RequestMapping(value ="discountcode",method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void getdiscount(
			@ModelAttribute("c_code") String c_code,
			HttpSession session		
			) {	
		CheckouDAO checkDAO = new CheckouDAO();	
		if(checkDAO.getDiscount(c_code) > 0) {
			session.setAttribute("c_codediscount", checkDAO.getDiscount(c_code));
			session.setAttribute("codename", checkDAO.getcodeDiscount(c_code));
		}	
		
	}
	
	@RequestMapping(value = "thankyou", method = RequestMethod.POST)
	public String thankyouindex(ModelMap model,
			HttpSession session,
			@ModelAttribute("orderhave") Order order
			) {
		OrderDAO orderDAO = new OrderDAO();
		
		System.out.println(order.getMemberoder().getId());
		
		
		System.out.println(order.getFirstname());
		System.out.println(order.getName());
		System.out.println(order.getEmail());
		System.out.println(order.getPhone());
		
		//IF idaddress old different ProvinceID, DistrictID, WardID then SAVE new Address TO DB
		AddressDAO addressDAO = new AddressDAO();
		Address address = new Address();
		boolean addressvali = addressDAO.valiAddressChangeFromID(order.getAddress().getId(), order.getAddress().getProvince().getId(),
				order.getAddress().getDistrict().getId(),
				order.getAddress().getWard().getId());
		if(addressvali==true) {
			address = addressDAO.findAddressByID(order.getAddress().getId()); 
		}else {
			address = new Address(order.getAddress().getNameaddress(),
					addressDAO.findWardbyId(order.getAddress().getWard().getId()),
					addressDAO.findProvincebyId(order.getAddress().getProvince().getId()),
					addressDAO.findDistrictbyId(order.getAddress().getDistrict().getId()));
			addressDAO.saveAddress(address);
		}
		
		//System.out.print(address);
		
	/*		
		//Id of address old
 		System.out.println(order.getAddress().getId());
		
		//Address can change
		System.out.println(order.getAddress().getProvince().getId());
		System.out.println(order.getAddress().getDistrict().getId());
		System.out.println(order.getAddress().getWard().getId());
		System.out.println(order.getAddress().getNameaddress());
		
		*/
	
		
		order.setAddress(address);
		float shipcost = (float)session.getAttribute("ship");
		order.setShipcost(shipcost);
		if(session.getAttribute("codename")!=null) {
			float discountcost =(float)session.getAttribute("codename");
			order.setDiscount(discountcost);
		}
		order.setCreateat(new Date());
		int idmember =(int)session.getAttribute("idmember");
		MemberDAO memberDAO = new MemberDAO();
		Mber mber = memberDAO.findbyId(idmember);
		order.setMemberoder(mber);
		System.out.println(order);
		
		orderDAO.saveorder(order);
		@SuppressWarnings("unchecked")
		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
		for(Cartitems cartitems:cart) {
			Order_item carti = new Order_item(order,cartitems.getProductitem(),cartitems.getQuantity(),
					cartitems.getSize(),
					cartitems.getProductitem().getPrice()*cartitems.getQuantity());
			orderDAO.saveorderitems(carti);
		}
		
		//AddressDAO addressDAO = new AddressDAO();
	
		
		
		
		
		
		 	
//		if(order.getAddress().getProvince().getName().equals(mber.getListAddress().get(0).getProvince().getName())
//			&& order.getAddress().getDistrict().getName().equals(mber.getListAddress().get(0).getDistrict().getName())	
//				&& order.getAddress().getWard().getName().equals(mber.getListAddress().get(0).getWard().getName())	
//				) {
//			order.setAddress(mber.getListAddress().get(0));
//		}else 
//		{
//			addressDAO.saveAddress(order.getAddress());
//			order.setAddress(order.getAddress());
//		}
		
		//addressDAO.saveAddress(order.getAddress());
	
//		System.out.print(order.getAddress());
//
//		OrderDAO orderDAO = new OrderDAO();
//		
//	    float total = 0;		
//		float costship = (float)session.getAttribute("ship");
//		if(session.getAttribute("c_codediscount") != null) {
//		float costdiscount =(float)session.getAttribute("c_codediscount");
//			total = order.getTotal() + costship - costdiscount;			
//			order.setDiscount(costdiscount);
//		}else {
//			total = order.getTotal() + costship;
//		}
//		order.setCreateat(new Date());
//		order.setShopcost(costship);
//		order.setTotal(total);
//		
//		orderDAO.saveorder(order);
//		System.out.println(order);
//		@SuppressWarnings("unchecked")
//		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
//		for(Cartitems cartitems:cart) {
//			Order_item orderitem = new Order_item(order,cartitems.getProductitem(),cartitems.getQuantity(),cartitems.getSize(),cartitems.getQuantity()*cartitems.getProductitem().getPrice());
//			order.addOrder_item(orderitem);
//			orderDAO.saveorderitems(orderitem);
//		System.out.println(orderitem);
//		}

	
		
		
		
//		
//		int idmember = (int) session.getAttribute("idmember");
//		@SuppressWarnings("unchecked")
//		List<Cartitems> cart = (List<Cartitems>) session.getAttribute("cart");
//		float total =0.f;
//		int numberproduct=0;
//		float ship = 30000f;
//		for(Cartitems cartitems:cart) {
//			total += cartitems.getProductitem().getPrice()*cartitems.getQuantity();
//			numberproduct += cartitems.getQuantity();
//		}
//		
//		OrderDAO orderDAO = new OrderDAO();
//		MemberDAO memberDAO = new MemberDAO();
//		Mber member = memberDAO.findbyId(idmember);
//		Address address = member.getAddress().get(0);		
//		//Order order = new Order(total,ship,numberproduct,new Date(),member,address);
//		orderDAO.saveorder(order);
//		for(Cartitems listcart:cart) {
//			Order_item orderitems = new Order_item(order,listcart.getProductitem(),listcart.getQuantity(),
//					listcart.getSize(),
//					listcart.getQuantity()*listcart.getProductitem().getPrice());
//					orderDAO.saveorderitems(orderitems);
//		}
//	
		
		return "client/thankyou";
	}
	
}
