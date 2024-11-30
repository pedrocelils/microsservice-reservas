package com.microsservice.microsservice_reservas.repository;

import com.microsservice.microsservice_reservas.entities.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResservasRepository extends JpaRepository<Reservas, Integer> {
}
