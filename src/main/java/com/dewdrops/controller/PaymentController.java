package com.dewdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dewdrops.entity.Payment;
import com.dewdrops.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPayments", paymentService.getAllPayments());
        return "index";
    }

    @GetMapping("/showNewPaymentForm")
    public String showNewPaymentForm(Model model) {
    	Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "new_payment";
    }

    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") Payment payment) {
    	paymentService.savePayment(payment);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "paymentId") int paymentId, Model model) {
    	Payment payment = paymentService.getPaymentByPaymentId(paymentId);
        model.addAttribute("payment", payment);
        return "update_payment";
    }

    @GetMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable(value = "paymentId") int paymentId) {
    	paymentService.deletePaymentByPaymentId(paymentId);
        return "redirect:/";
    }
}