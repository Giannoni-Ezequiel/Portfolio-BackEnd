package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>
{
    List<Experiencia> findAll();
    Experiencia save(Experiencia experiencia);
    void deleteExperienciaById(Long id);
    Experiencia findExperienciaById(Long id);
}
