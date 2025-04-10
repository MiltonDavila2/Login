package com.crud.app.servicio;

import com.crud.app.modelo.Trabajador;
import com.crud.app.repositorio.TrabajadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServicioImple implements TrabajadorServicio{

    @Autowired
    private TrabajadorRepositorio repositorio;

    @Override
    public List<Trabajador> ListarTrabajadores() {
        return repositorio.findAll();
    }

    @Override
    public Trabajador GuardarTrabajador(Trabajador trabajador) {
        return repositorio.save(trabajador);
    }

    @Override
    public Trabajador obtenerTrabajadorID(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajador) {
        return repositorio.save(trabajador);
    }

    @Override
    public void eliminarTrabajador(Long id) {
        repositorio.deleteById(id);
    }
}
