package com.miaplicacion.primerproyecto.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Entity.Persona;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudioDTO {
    
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("fecha_fin")
    private Date fecha_fin;
    @JsonProperty("fecha_inicio")
    private Date fecha_inicio;
    @JsonProperty("img")
    private String img;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("persona")
    private Persona persona;
    
    public Estudios toEstudioEntity(){
        return new Estudios(this.descripcion, this.fecha_fin, this.fecha_inicio,
        this.img, this.nombre, this.titulo, null);
    }
    
}
