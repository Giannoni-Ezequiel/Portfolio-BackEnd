package com.miaplicacion.primerproyecto.Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estudio")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Estudios {
    @Id
    @SequenceGenerator(
            name= "estudio_sequence",
            sequenceName = "estudio_sequence",
            allocationSize = 1,
            initialValue = 0)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "estudio_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "fecha_fin")
    private String fecha_fin;
    @Column(name = "img")
    private String img;
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "persona_fk")
    private Persona persona;

    public Estudios(String titulo,String nombre,
                    String fecha_inicio,String fecha_fin,
                    String img, String descripcion,  Persona persona) {
        this.descripcion = descripcion;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.img = img;
        this.nombre = nombre;
        this.titulo = titulo;
        this.persona = persona;
    }
    
    
}
