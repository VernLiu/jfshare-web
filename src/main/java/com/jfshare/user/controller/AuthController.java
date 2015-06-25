package com.jfshare.user.controller;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jfshare.logistics.service.DeliveryService;
import com.jfshare.logistics.service.model.Delivery;
import com.jfshare.user.service.UserService;
import com.jfshare.user.service.model.User;
import com.jfshare.user.util.GenerateImgUtils;

@Controller
@RequestMapping("/login")
public class AuthController {
	
	private DeliveryService deliveryService;
	private UserService userService;
	
	@Autowired
	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String login() {
		return "backend/login/login";
	}

	@RequestMapping(value="/valdCode.jpge*", method=RequestMethod.GET)
	public void validationCode(HttpServletResponse response, HttpSession session) {
		try {
			response.setContentType("image/jpeg; charset=UTF-8");
			String valdCode = GenerateImgUtils.generate(response.getOutputStream());
			session.setAttribute("valdCode", valdCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String valdCode = request.getParameter("valdCode");
		String message = "";
		User user = null;
		if(valdCode != null && valdCode.equalsIgnoreCase((String)session.getAttribute("valdCode"))) {
			try {
				user = userService.login(loginId, password);
				session.setAttribute("user", user);
				return "redirect:logistics/overseas";
			} catch(LoginException le) {
				if(le.getMessage().equals("001")) {
					message = "User name does not exist.";
				} else if(le.getMessage().equals("002")) {
					message = "Password can not null.";
				} else if(le.getMessage().equals("003")) {
					message = "Password is not correct.";
				}
			}
		} else {
			message = "Validation code is wrong.";
		}
		model.addAttribute("message", message);
		return "backend/login/login";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String orderId = request.getParameter("orderId");
		Delivery delivery = new Delivery();
		delivery.setId(id != null ? Long.valueOf(id) : null);
		delivery.setOrderId(orderId != null ? Long.valueOf(orderId) : null);
		deliveryService.save(delivery);
		return login();
	}
}
