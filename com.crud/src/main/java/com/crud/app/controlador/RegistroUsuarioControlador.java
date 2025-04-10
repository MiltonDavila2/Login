package com.crud.app.controlador;

import com.crud.app.servicio.UsuarioServicio;
import com.crud.app.usuarios.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro_usuario")
public class RegistroUsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;


    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoRegistroUsuarioDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro_usuario";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioServicio.GuardarUsuario(registroDTO);
        return "redirect:/registro_usuario?exito";
    }
}
