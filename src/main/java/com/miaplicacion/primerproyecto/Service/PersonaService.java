package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Persona;
import com.miaplicacion.primerproyecto.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas()
    {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per)
    {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id)
    {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id)
    {
        Persona persona = persoRepo.findById(id).orElse(null);
        return persona;
    }
    
    @Override
     public Persona updatePersona(Persona persona)
    {
        return persoRepo.save(persona);
    }
}
