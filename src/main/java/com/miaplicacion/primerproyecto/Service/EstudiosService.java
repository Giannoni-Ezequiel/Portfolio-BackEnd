package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Repository.EstudiosRepository;
import java.util.List;
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
    
    public List<Estudios> listar() {
        return this.estudiosRepository.findAll();
    }
    
    public Estudios listadId(Long id) {
        return this.estudiosRepository.findEstudiosById(id);
    }
    
    /*public void add(EstudioDTO estudio){
        this.estudiosRepository.save(estudio.toEstudioEntity());
    }
    
    public Estudios edit(EstudioDTO estudio){
        return this.estudiosRepository.save(estudio.toEstudioEntity());
    }*/
    
    public Estudios delete(Long id){
        this.estudiosRepository.deleteById(id);
        return null;
    }
}
