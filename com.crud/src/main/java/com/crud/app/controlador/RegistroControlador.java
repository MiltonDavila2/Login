package com.crud.app.controlador;

import com.crud.app.servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {

    @Autowired
    private TrabajadorServicio servicio;

    @GetMapping("/login")
    public String IniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String VerPaginaDeInicio(Model modelo){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = "Invitado";
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            nombreUsuario = ((UserDetails) auth.getPrincipal()).getUsername();
        }

        modelo.addAttribute("nombreUsuario", nombreUsuario);
        modelo.addAttribute("trabajadores", servicio.ListarTrabajadores());

        return "trabajadores";
    }
}

