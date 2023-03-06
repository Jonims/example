/*package com.projeto.projetorestaurante.component;

import com.projeto.projetorestaurante.model.ReservaModel;
import com.projeto.projetorestaurante.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReservasInicialBanco implements CommandLineRunner {

    @Autowired
    private ReservasRepository reservaRep;

    @Override
    public void run(String... args) throws Exception {

        ReservaModel r1 = new ReservaModel("Joni");
        r1.setDataReserva();
        r1.setTelefone("89565623");

        ReservaModel r2 = new ReservaModel("Hugo");
        reservaRep.save(r1);

    }
}*/
