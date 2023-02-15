package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.DTO.EstudioDTO;
import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Entity.Experiencia;
import com.miaplicacion.primerproyecto.Repository.EstudiosRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService 
{
    private final EstudiosRepository estudiosRepository;
    
    @Autowired
    public EstudiosService(EstudiosRepository estudiosRepository){
        this.estudiosRepository = estudiosRepository;
    }
    
    public List<Estudios> list() {
        return this.estudiosRepository.findAll();
    }

    public Optional<Estudios> getOne(int id) {
        return this.estudiosRepository.findById((long) id);
    }

    public Optional<Estudios> getByNombre(String nombre)
    {
        return this.estudiosRepository.findBynombre(nombre);
    }
    public Estudios listadId(Long id) {
        return this.estudiosRepository.findEstudiosById(id);
    }
    
    public void save(Estudios estudio){
        this.estudiosRepository.save(estudio);
    }
    
    public Estudios edit(EstudioDTO estudio){
        return this.estudiosRepository.save(estudio.toEstudioEntity());
    }
    
    public void delete(Long id){
        this.estudiosRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return this.estudiosRepository.existsById((long) id);
    }

    public boolean existsBynombre(String nombre)
    {
        return this.estudiosRepository.existsBynombre(nombre);
    }
}
