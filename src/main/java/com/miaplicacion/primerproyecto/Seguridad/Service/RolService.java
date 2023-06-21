package com.miaplicacion.primerproyecto.Seguridad.Service;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Rol;
import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;
import com.miaplicacion.primerproyecto.Seguridad.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService 
{
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre)
    {
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol)
    {
        rolRepository.save(rol);
    }
}