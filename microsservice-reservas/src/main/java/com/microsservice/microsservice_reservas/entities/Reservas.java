package com.microsservice.microsservice_reservas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;
    private Integer idCliente;
    private Integer idMesa;

    public Reservas() {}

    public Reservas(Integer idReserva, Integer idCliente, Integer idMesa) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }
}
