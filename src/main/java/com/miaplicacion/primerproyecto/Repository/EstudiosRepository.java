package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.Estudios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Long>
{
    List<Estudios> findAll();
    Estudios save(Estudios estudio);
    void deleteEstudiosById(Long id);
    Estudios findEstudiosById(Long id);
}
