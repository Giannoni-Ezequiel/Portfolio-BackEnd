package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>
{
    //List<Persona> findAll();
    Persona save(Persona persona);
    void deletePersonaById(Long id);
    Persona findPersonaById(Long id);
}
