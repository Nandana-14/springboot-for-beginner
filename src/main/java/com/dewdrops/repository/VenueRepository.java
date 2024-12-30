package com.dewdrops.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dewdrops.entity.Venue;
@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {

	

}