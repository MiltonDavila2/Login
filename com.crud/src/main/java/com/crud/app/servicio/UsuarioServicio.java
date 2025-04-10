package com.crud.app.servicio;

import com.crud.app.modelo.Usuario;
import com.crud.app.usuarios.dto.UsuarioRegistroDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService {
    public Usuario GuardarUsuario(UsuarioRegistroDTO registroDTO);
}
