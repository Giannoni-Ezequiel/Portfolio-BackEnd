package com.miaplicacion.primerproyecto.Seguridad.Repository;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Rol;
import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> 
{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
