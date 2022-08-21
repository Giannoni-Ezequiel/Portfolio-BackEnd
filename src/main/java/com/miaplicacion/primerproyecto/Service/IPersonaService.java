package com.miaplicacion.primerproyecto.Service;

import com.miaplicacion.primerproyecto.Entity.Persona;
import java.util.List;


public interface IPersonaService {

    
    
    public List<Persona> verPersonas ();
    
    public void crearPersona (Persona per);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
    
    public Persona updatePersona(Persona persona);
    
}
