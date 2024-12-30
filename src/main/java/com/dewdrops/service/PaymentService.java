package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.Payment;
import com.dewdrops.service.PaymentService;

public interface PaymentService {
	void saveUser(Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentByPaymentId(Integer paymentId);

	void deletePaymentByPaymentId(Integer paymentId);

	void savePayment(Payment payment);
}