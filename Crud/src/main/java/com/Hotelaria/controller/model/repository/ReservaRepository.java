package com.Hotelaria.controller.model.repository;

import com.Hotelaria.controller.ReservaController;
import com.Hotelaria.controller.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaController, Long> {

	void save(Reserva reserva);}
