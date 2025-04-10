package com.crud.app.servicio;

import com.crud.app.modelo.Trabajador;

import java.util.List;

public interface TrabajadorServicio {
    public List<Trabajador> ListarTrabajadores();

    public Trabajador GuardarTrabajador(Trabajador trabajador);

    public Trabajador obtenerTrabajadorID(Long id);

    public Trabajador actualizarTrabajador(Trabajador trabajador);

    public void eliminarTrabajador(Long id);
}
