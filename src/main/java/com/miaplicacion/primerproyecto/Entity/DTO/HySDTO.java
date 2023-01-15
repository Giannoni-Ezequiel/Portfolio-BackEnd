package com.miaplicacion.primerproyecto.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaplicacion.primerproyecto.Entity.HyS;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HySDTO {
    
     @JsonProperty("img")
     private String img;
     @JsonProperty("porcentaje")
     private Double porcentaje;
     @JsonProperty("skill")
     private String skill;
     
     public HyS toHySEntity(){
        return new HyS(this.img, this.porcentaje,
                this.skill, null);
    } 
}
