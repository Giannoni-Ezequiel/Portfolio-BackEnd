package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.DTO.HySDTO;
import com.miaplicacion.primerproyecto.Entity.HyS;
import com.miaplicacion.primerproyecto.Repository.HySRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HySService 
{
    private final HySRepository hysRepository;
    
    @Autowired
    public HySService(HySRepository hysRepository){
        this.hysRepository = hysRepository;
    }
    
    public List<HyS> listar() {
        return this.hysRepository.findAll();
    }
    
    public HyS listadId(Long id) {
        return this.hysRepository.findHySById(id);
    }
    
    public void add(HySDTO hys){
        this.hysRepository.save(hys.toHySEntity());
    }
    
    public HyS edit(HySDTO hys){
        return this.hysRepository.save(hys.toHySEntity());
    }
    
    public HyS delete(Long id){
        this.hysRepository.deleteById(id);
        return null;
    }
}
