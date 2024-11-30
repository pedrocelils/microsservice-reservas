package com.microsservice.microsservice_reservas.services;

import com.microsservice.microsservice_reservas.entities.Reservas;
import com.microsservice.microsservice_reservas.repository.ResservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservasServices {

    @Autowired
    private ResservasRepository reservasServices;

    public List<Reservas> findAll() {
        return reservasServices.findAll();
    }

    public Reservas criarReserva(Reservas reservaDTO) {
        Reservas reserva = new Reservas();
        reserva.setIdCliente(reservaDTO.getIdCliente());
        reserva.setIdReserva(reservaDTO.getIdReserva());
        reserva.setIdMesa(reservaDTO.getIdMesa());
        return reservasServices.save(reserva);
    }
}
