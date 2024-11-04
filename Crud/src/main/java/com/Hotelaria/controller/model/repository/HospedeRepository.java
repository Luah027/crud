package com.Hotelaria.controller.model.repository;

import com.Hotelaria.controller.HospedeController;
import com.Hotelaria.controller.model.Hospede;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<HospedeController, Long> {

	static void save(Hospede hospede) {
		// TODO Auto-generated method stub
		
	}}
