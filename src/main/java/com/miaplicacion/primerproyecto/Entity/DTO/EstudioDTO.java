package com.miaplicacion.primerproyecto.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Entity.Persona;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class EstudioDTO {

    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("fecha_inicio")
    private String fecha_inicio;
    @JsonProperty("fecha_fin")
    private String fecha_fin;
    @JsonProperty("img")
    private String img;
    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("persona")
    private Persona persona;
    
    public Estudios toEstudioEntity(){
        return new Estudios(this.descripcion, this.fecha_fin, this.fecha_inicio,
        this.img, this.nombre, this.titulo, null);
    }
    
}
