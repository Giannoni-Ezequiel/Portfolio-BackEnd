package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Proyectos;
import com.miaplicacion.primerproyecto.Repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService 
{
    private final ProyectosRepository proyectoRepository;
    
    @Autowired
    public ProyectosService(ProyectosRepository proyectoRepository){
        this.proyectoRepository = proyectoRepository;
    }
    
    public List<Proyectos> listar() {
        return this.proyectoRepository.findAll();
    }
    
    public Proyectos listadId(Long id) {
        return this.proyectoRepository.findProyectoById(id);
    }
    
    /*public void add(ProyectosDTO proyecto){
        this.proyectoRepository.save(proyecto.toProyectosEntity());
    }
    
    public Proyectos edit(HySDTO proyecto){
        return this.proyectoRepository.save(proyecto.toProyectosEntity());
    }*/
    
    public Proyectos delete(Long id){
        this.proyectoRepository.deleteById(id);
        return null;
    }
}
