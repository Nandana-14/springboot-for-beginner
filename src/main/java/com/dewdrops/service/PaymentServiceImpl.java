package com.dewdrops.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.Payment;
import com.dewdrops.repository.PaymentRepository;

@Service
public abstract class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public void savePayment(Payment payment) {
		if (payment.getPaymentId() == null) {
			paymentRepository.save(payment);
		} else {
			Payment staffUpdate = paymentRepository.findById(payment.getPaymentId()).get();
			staffUpdate.setPaymentId(payment.getPaymentId());
			staffUpdate.setUserId(payment.getUserId());
			staffUpdate.setTicketId(payment.getTicketId());
			staffUpdate.setAmount(payment.getAmount());
			staffUpdate.setPaymentDate(payment.getPaymentDate());
			staffUpdate.setPaymentStatus(payment.getPaymentStatus());
			staffUpdate.setPaymentMode(payment.getPaymentMode());
			paymentRepository.save(staffUpdate);
		}
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentByPaymentId(Integer paymentId) {
		return paymentRepository.findById(paymentId).get();

	}

	@Override
	public void deletePaymentByPaymentId(Integer paymentId) {
		paymentRepository.deleteById(paymentId);
	}

	
}