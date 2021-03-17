package com.se2_project.group8C18.demoEBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Service.PaymentMethodService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PaymentMethodController {
	@Autowired
	PaymentMethodService paymentMethodService;
	
	@PostMapping(value = "/paymentMethod/addPaymentMethod")
	public String addPaymentMethod(@RequestBody String paymentMethod)
	{
		return paymentMethodService.addPaymentMethod(paymentMethod);
	}
}
