package com.miaplicacion.primerproyecto.Seguridad.dto;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private Set<Rol> roles;
}
