package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Experiencia;
import com.miaplicacion.primerproyecto.Repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService 
{
    private final ExperienciaRepository experienciaRepository;
    
    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository){
        this.experienciaRepository = experienciaRepository;
    }
    
    public List<Experiencia> listar() {
        return this.experienciaRepository.findAll();
    }
    
    public Experiencia listadId(Long id) {
        return this.experienciaRepository.findExperienciaById(id);
    }
    
    /*public void add(ExperienciaDTO experiencia){
        this.experienciaRepository.save(experiencia.toExperienciaEntity());
    }
    
    public Experiencia edit(ExperienciaDTO experiencia){
        return this.experienciaRepository.save(experiencia.toExperienciaEntity());
    }*/
    
    public Experiencia delete(Long id){
        this.experienciaRepository.deleteById(id);
        return null;
    }
    
}
