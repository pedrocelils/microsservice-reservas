package com.microsservice.microsservice_reservas.resources;

import com.microsservice.microsservice_reservas.entities.Reservas;
import com.microsservice.microsservice_reservas.services.ReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ReservasResource {

    @Autowired
    private ReservasServices reservasServices;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/reservas")
    public List<Reservas> getAll(){
        List<Reservas> reservas = reservasServices.findAll();
        return reservas;
    }

    @PostMapping
    public ResponseEntity<Reservas> criarReserva(@RequestBody Reservas reservaDTO) {
        // Verificar se o cliente existe no microserviço de Clientes
        Clientes cliente = restTemplate.getForObject("http://cliente-service/clientes/" + reservaDTO.getIdCliente(), Clientes.class);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Criar reserva
        Reservas reserva = reservasServices.criarReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }
}
