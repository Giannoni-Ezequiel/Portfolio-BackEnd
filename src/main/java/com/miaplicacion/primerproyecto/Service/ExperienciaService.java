package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.DTO.ExperienciaDTO;
import com.miaplicacion.primerproyecto.Entity.Experiencia;
import com.miaplicacion.primerproyecto.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;

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
    
    public List<Experiencia> list() {
        return this.experienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return this.experienciaRepository.findById((long) id);
    }
    
    public Experiencia listarId(Long id) {
        return this.experienciaRepository.findExperienciaById(id);
    }
    public Experiencia edit(ExperienciaDTO experiencia){
        return this.experienciaRepository.save(experiencia.toExperienciaEntity());
    }

    public Optional<Experiencia> getByNombreEmpresa(String nombreEmpresa)
    {
        return this.experienciaRepository.findBynombreEmpresa(nombreEmpresa);
    }
    public void save(Experiencia experiencia){
        this.experienciaRepository.save(experiencia);
    }
    
    public void delete(Long id){
        this.experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return this.experienciaRepository.existsById((long) id);
    }

    public boolean existsBynombreEmpresa(String nombreEmpresa)
    {
        return this.experienciaRepository.existsBynombreEmpresa(nombreEmpresa);
    }
}
