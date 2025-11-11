package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.DTO.ProyectoDTO;
import com.miaplicacion.primerproyecto.Entity.Proyectos;
import com.miaplicacion.primerproyecto.Repository.ProyectosRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService 
{
    private final ProyectosRepository proyectoRepository;
    
    @Autowired
    public ProyectosService(ProyectosRepository proyectoRepository)
    {
        this.proyectoRepository = proyectoRepository;
    }
    
    public List<Proyectos> listar()
    {
        return this.proyectoRepository.findAll();
    }
    
    public Proyectos listadId(Long id)
    {
        return this.proyectoRepository.findProyectoById(id);
    }
    
    public void add(ProyectoDTO proyecto)
    {
        this.proyectoRepository.save(proyecto.toProyectoEntity());
    }
    
    public Proyectos edit(ProyectoDTO proyecto)
    {
        // This logic assumes the DTO contains the ID to update the correct entity.
        Optional<Proyectos> optionalProyecto = proyectoRepository.findById(proyecto.getId());
        if (optionalProyecto.isPresent()) {
            Proyectos proyectoToUpdate = optionalProyecto.get();
            proyectoToUpdate.setNombre(proyecto.getNombre());
            proyectoToUpdate.setDescripcion(proyecto.getDescripcion());
            // Set other fields as needed
            return this.proyectoRepository.save(proyectoToUpdate);
        }
        return null; // Or throw an exception
    }
    
    public Proyectos delete(Long id)
    {
        this.proyectoRepository.deleteById(id);
        return null;
    }

    public boolean existsById(Long id) {
        return proyectoRepository.existsById(id);
    }
}
