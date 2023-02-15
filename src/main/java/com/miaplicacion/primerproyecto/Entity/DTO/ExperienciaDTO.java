package com.miaplicacion.primerproyecto.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaplicacion.primerproyecto.Entity.Experiencia;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExperienciaDTO {
    
    @JsonProperty("cargo")
    private String cargo;
    @JsonProperty("descripcion")
    private String descripcion;
    /*@JsonProperty("es_trabajo_actual")
    private Boolean es_trabajo_actual;*/
    @JsonProperty("fecha_fin")
    private Date fecha_fin;
    @JsonProperty("fecha_inicio")
    private Date fecha_inicio;
    @JsonProperty("nombreEmpresa")
    private String nombreEmpresa;
    
    
    public Experiencia toExperienciaEntity(){
        return new Experiencia(this.cargo, this.descripcion,
                this.fecha_fin, this.fecha_inicio, this.nombreEmpresa,
                null);
    }
}
