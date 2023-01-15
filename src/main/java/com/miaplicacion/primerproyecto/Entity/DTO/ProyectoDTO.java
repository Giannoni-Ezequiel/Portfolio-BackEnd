package com.miaplicacion.primerproyecto.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaplicacion.primerproyecto.Entity.Proyectos;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProyectoDTO {
        
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("fecha")
    private Date fecha;
    @JsonProperty("github")
    private String github;
    @JsonProperty("img")
    private String img;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("proyecto")
    private String proyecto;
    
    public Proyectos toProyectoEntity(){
        return new Proyectos(this.descripcion, this.fecha, this.github,
                this.img, this.nombre, this.proyecto,null);
    }
}
