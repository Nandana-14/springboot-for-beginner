package com.dewdrops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dewdrops.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}