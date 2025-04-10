package com.crud.app.servicio;

import com.crud.app.modelo.Rol;
import com.crud.app.modelo.Usuario;
import com.crud.app.repositorio.UsuarioRepositorio;
import com.crud.app.usuarios.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImple implements UsuarioServicio{

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepositorio repositorio;

    public UsuarioServicioImple(BCryptPasswordEncoder passwordEncoder ){
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Usuario GuardarUsuario(UsuarioRegistroDTO registroDTO) {

        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return repositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorio.findByEmail(username);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario o contraseña invalida");
        }

        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> Roles){
       return Roles.stream().map(role-> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}
