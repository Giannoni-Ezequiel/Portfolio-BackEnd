package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.DTO.HySDTO;
import com.miaplicacion.primerproyecto.Entity.HyS;
import com.miaplicacion.primerproyecto.Repository.HySRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HySService 
{
    private final HySRepository hysRepository;
    
    @Autowired
    public HySService(HySRepository hysRepository)
    {
        this.hysRepository = hysRepository;
    }
    
    public List<HyS> listar()
    {
        return this.hysRepository.findAll();
    }
    
    public HyS listadId(Long id)
    {
        return this.hysRepository.findHySById(id);
    }
    
    public void add(HySDTO hys)
    {
        this.hysRepository.save(hys.toHySEntity());
    }
    
    public HyS edit(HySDTO hys)
    {
        // This logic assumes the DTO contains the ID to update the correct entity.
        Optional<HyS> optionalHys = hysRepository.findById(hys.getId());
        if (optionalHys.isPresent()) {
            HyS hysToUpdate = optionalHys.get();
            hysToUpdate.setSkill(hys.getSkill());
            hysToUpdate.setPorcentaje(hys.getPorcentaje());
            return this.hysRepository.save(hysToUpdate);
        }
        return null; // Or throw an exception
    }
    
    public HyS delete(Long id)
    {
        this.hysRepository.deleteById(id);
        return null;
    }

    public boolean existsById(Long id) {
        return hysRepository.existsById(id);
    }
}
