package com.miaplicacion.primerproyecto.Seguridad.Entity;

import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rol 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol(RolNombre roleAdmin) {
    }
}