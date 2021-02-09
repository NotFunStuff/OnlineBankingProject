package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.PaymentMethod;

public interface IPaymentMethodService {
	public PaymentMethod getPaymentMethodById(int paymentMethodId);
	
	public List<PaymentMethod> getAllPaymentMethod();
	public String addPaymentMethod(String paymentMethod);
	public String deletePaymentMethodById(int paymentMethodId);
	public String editPaymentMethod(String paymentMethod);
	public List<PaymentMethod> getPaymentMethodsByAccount(int accountId);
	
}
