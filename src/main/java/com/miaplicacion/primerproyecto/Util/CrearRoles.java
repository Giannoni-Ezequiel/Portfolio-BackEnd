package com.miaplicacion.primerproyecto.Util;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Rol;
import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;
import com.miaplicacion.primerproyecto.Seguridad.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CrearRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
         /**Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
         Rol rolUser = new Rol(RolNombre.ROLE_USER);
         rolService.save(rolAdmin);
         rolService.save(rolUser);
         **/
    }
}
//Ejecutar una vez para crear rol admin y rol user