package com.projeto.projetorestaurante.repository;

import com.projeto.projetorestaurante.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<ReservaModel, Long> {
}
