package com.Hotelaria.controller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotelaria.controller.model.Hospede;


public interface HospedeRepository extends JpaRepository<Hospede, Long> {
		
	}
