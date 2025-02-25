package com.dewdrops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dewdrops.entity.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}