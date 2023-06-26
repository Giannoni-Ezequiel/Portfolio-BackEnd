package com.miaplicacion.primerproyecto.Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia 
{
    @Id
    @SequenceGenerator(
            name= "experiencia_sequence",
            sequenceName = "experiencia_sequence",
            allocationSize = 1,
            initialValue = 0)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "experiencia_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "descripcion")
    private String descripcion;
    /*@Column(name = "es_trabajo_actual")
    private Boolean es_trabajo_actual;*/
    @Column(name = "fecha_fin")
    private String fecha_fin;
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "persona_fk")
    private Persona persona;

    public Experiencia(String cargo, String descripcion
           , String fecha_fin, String fecha_inicio,
            String nombreEmpresa, Persona persona) {
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.nombreEmpresa = nombreEmpresa;
        this.persona = persona;
    }
    
    
}
