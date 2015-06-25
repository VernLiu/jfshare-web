package com.jfshare.logistics.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jfshare.logistics.service.DeliveryService;
import com.jfshare.logistics.service.model.Delivery;
import com.jfshare.user.service.model.User;

@Controller
@RequestMapping("/logistics")
public class LogisticsController {
	
	private DeliveryService deliveryService;
	
	@Autowired
	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@RequestMapping("/overseas")
	public String overseas(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("user", user);
		return "backend/logistics/overseas/index";
	}
	
	@RequestMapping("/overseas/list")
	public String list(Model model) {
		List<Delivery> deliverys = deliveryService.getAllDeliverys();
		model.addAttribute("deliverys", deliverys);
		return "backend/logistics/overseas/list";
	}
	
	@RequestMapping(value="/overseas/add/{id}", method=RequestMethod.GET)
	public String add(@PathVariable Long id, Model model) {
		model.addAttribute("delivery", deliveryService.getDelivery(id));
		return "backend/logistics/overseas/add";
	}
	
	@RequestMapping(value="/overseas/add/{id}", method=RequestMethod.POST)
	public String add(HttpServletRequest request, @PathVariable Long id) {
		Long orderId = Long.valueOf((String)request.getParameter("orderId"));
		String detail = (String)request.getParameter("detail");
		String remark = (String)request.getParameter("remark");
		deliveryService.update(id, orderId, detail, remark);
		return "redirect:backend/logistics/overseas/list";
	}
	
	
}
