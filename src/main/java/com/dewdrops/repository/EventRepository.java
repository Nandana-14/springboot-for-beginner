package com.dewdrops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dewdrops.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}