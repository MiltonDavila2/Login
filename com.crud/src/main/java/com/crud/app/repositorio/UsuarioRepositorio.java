package com.crud.app.repositorio;

import com.crud.app.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    public Usuario findByEmail(String email);
}
