package com.miaplicacion.primerproyecto.Seguridad.dto;

import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;

public class RolDTO {
    private RolNombre rolNombre;

    public RolDTO(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
