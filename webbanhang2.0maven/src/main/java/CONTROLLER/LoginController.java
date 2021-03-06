package CONTROLLER;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import BEAN.Category_member;
import BEAN.Mber;
import DAO.LoginAndRegistrationDAO;
import DAO.MemberDAO;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String loginindex(ModelMap model) {
		model.addAttribute("member",new Mber());
		return "client/login";
	}
	@RequestMapping("registration")
	public String registration(ModelMap model) {
		model.addAttribute("member", new Mber());
		return "client/registration";
	}
	@RequestMapping("logincontroller")
	public String logincontroller(
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("member") Mber mber
			) {
		String modelandview ="";
		LoginAndRegistrationDAO loginDAO = new LoginAndRegistrationDAO();
		List<Object[]> result = loginDAO.validatelogin(mber.getEmail(), mber.getPassword());
		
		if(result.size()>0) {
			Object[] obj = result.get(0);
			Category_member cate_member = (Category_member)obj[2];
			System.out.println(obj[0]+" "+obj[1]+" "+cate_member.getId());
			
			session.setAttribute("namemember", obj[0]);
			
			session.setAttribute("idmember", obj[1]);		
			if(cate_member.getId() == 2) {
				//redirect "/trang-chu.htm";
				//return "redirect:/login.htm";
				modelandview = "redirect:/trang-chu.htm";
			}
			if(cate_member.getId() == 1){
				//1 -> admin
				modelandview = "redirect:/trang-chuadmin.htm";
			}
		}		
		
		else {
			model.addAttribute("member", new Mber());
			model.addAttribute("msg", "Đăng nhập thất bại");
			modelandview = "client/login";
		}
		
		return modelandview;
	}
	@RequestMapping("logoutcontroller")
	public String logoutcontroller(HttpSession session) {
		session.invalidate();
		return "client/home";
	}
	
	
	@RequestMapping("registrationcontroller")
	public String registrationcontroller(
			ModelMap model,
			@ModelAttribute("member") Mber mber
			) {
		try {
	
		MemberDAO memberDAO = new MemberDAO();
		Category_member caregory = memberDAO.findCategoryMember(2);
		mber.setCategorymb(caregory);	
		mber.setCreateat(new Date());
		memberDAO.Save(mber);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login.htm";
	}
	
	
	
}
