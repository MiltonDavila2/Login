package com.crud.app.repositorio;

import com.crud.app.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepositorio extends JpaRepository<Trabajador,Long> {
}
