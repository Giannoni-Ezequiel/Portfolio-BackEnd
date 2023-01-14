package com.miaplicacion.primerproyecto.Repository;

import com.miaplicacion.primerproyecto.Entity.Proyectos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long>
{
    List<Proyectos> findAll();
    Proyectos save(Proyectos proyecto);
    void deleteProyectoById(Long id);
    Proyectos findProyectoById(Long id);
}
